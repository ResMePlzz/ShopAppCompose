package com.example.shopappcomposefinal.data.firebase.google_sign_in

import android.content.Context
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.userProfileChangeRequest

class GoogleSignInAuth {

    companion object {


        const val WEB_ID =
            "510030711272-38giqedfun56cdi5p2svpo875qrmaj2c.apps.googleusercontent.com"


        //google client
        fun getGoogleClient(context: Context): GoogleSignInClient {
            val gso =
                GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(
                    WEB_ID
                ).requestEmail().requestProfile().build()
            return GoogleSignIn.getClient(context, gso)

        }

        fun getGoogleSignInOption(): GoogleSignInOptions {
            return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(
                WEB_ID
            ).requestEmail().requestProfile().build()
        }


        fun fireBaseAuthGoogle(
            token: String,
            auth: FirebaseAuth,
            gso:GoogleSignInOptions,
            onSuccess: () -> Unit
        ) {
            val credential = GoogleAuthProvider.getCredential(token, null)
            auth.signInWithCredential(credential).addOnCompleteListener {
                if (it.isSuccessful) {
                    while (auth.currentUser == null) {
                        auth.currentUser?.reload()
                    }
                    auth.currentUser?.updateProfile(userProfileChangeRequest {
                        displayName = gso.account?.name
                    })

                    onSuccess()
                    Log.d("userTag", "${it.result.user}")

                }
            }

        }

    }


}