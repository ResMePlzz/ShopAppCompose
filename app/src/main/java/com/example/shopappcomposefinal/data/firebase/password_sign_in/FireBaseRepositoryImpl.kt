package com.example.shopappcomposefinal.data.firebase.password_sign_in

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopappcomposefinal.domain.model.MessageModel
import com.example.shopappcomposefinal.domain.repository.ChatRepository
import com.example.shopappcomposefinal.domain.repository.DataBaseRepository
import com.example.shopappcomposefinal.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class FireBaseRepositoryImpl @Inject constructor(private val auth: FirebaseAuth) :
    DataBaseRepository, ChatRepository {


    val database = Firebase.database.reference

    private var _readAllMessage: MutableLiveData<List<MessageModel>> = MutableLiveData(listOf())
    val readAllMessage: LiveData<List<MessageModel>> = _readAllMessage


    private val listenerMessage = object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            _readAllMessage.value = snapshot.children.map {
                it.getValue<MessageModel>() ?: MessageModel()
            }
        }

        override fun onCancelled(error: DatabaseError) {

        }
    }


    override suspend fun registrationAndToEnterFB(
        email: String,
        password: String,
        name: String,
        onSuccess: () -> Unit,
        onFail: () -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                while (auth.currentUser == null) {
                    auth.currentUser?.reload()
                }
                auth.currentUser?.updateProfile(userProfileChangeRequest { displayName = name })
                    ?.addOnSuccessListener {

                    }
                onSuccess()


            } else onFail()
        }
    }

    override suspend fun signInToFireBase(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFail: () -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                while (auth.currentUser == null) {
                    auth.currentUser?.reload()
                }
                onSuccess()
                Log.d("AuthTag", "success")
            } else {
                onFail()
                Log.d("AuthTag", "fail")
            }
        }.addOnCanceledListener(onFail)
    }

    override suspend fun signOutToFireBase() {
        auth.signOut()
    }

    override fun getCurrentUser(): UserModel {
        return UserModel(
            userName = auth.currentUser?.displayName,
            email = auth.currentUser?.email,
            userAvatar = auth.currentUser?.photoUrl.toString(),

            )
    }

    override fun addListener() {
        database.addValueEventListener(listenerMessage)

    }

    override fun readAllMessage(): LiveData<List<MessageModel>> {
        return readAllMessage
    }

    override suspend fun sendMessage(messageModel: MessageModel) {

        val messageId = database.push().key.toString()
        val messageMap = HashMap<String, Any?>()
        messageMap["id"] = messageId
        messageMap["userName"] = messageModel.userName
        messageMap["message"] = messageModel.message


        database.child(messageId).updateChildren(messageMap).addOnSuccessListener {
            Log.d("AddChatTag", "onSuccess")
        }.addOnFailureListener {
            Log.d("AddChatTag", "Error:$it")
        }

    }


}