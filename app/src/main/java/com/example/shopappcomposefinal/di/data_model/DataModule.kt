package com.example.shopappcomposefinal.di.data_model

import android.content.Context
import android.content.SharedPreferences
import androidx.activity.ComponentActivity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shopappcomposefinal.data.firebase.google_sign_in.GoogleSignInAuth
import com.example.shopappcomposefinal.data.firebase.password_sign_in.FireBaseRepositoryImpl
import com.example.shopappcomposefinal.data.room.DataBaseRoom
import com.example.shopappcomposefinal.data.room.RoomRepository
import com.example.shopappcomposefinal.data.room.ShopDAO
import com.example.shopappcomposefinal.data.shared_pref.SharedPreferenceManager
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {


    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("MyPrefs", ComponentActivity.MODE_PRIVATE)

    }

    @Provides
    @Singleton
    fun provideFireBaseAuth(): FirebaseAuth {
        return Firebase.auth
    }


    @Provides
    @Singleton
    fun provideGoogleClient(@ApplicationContext context: Context): GoogleSignInClient {
        return GoogleSignInAuth.getGoogleClient(context)
    }


    @Provides
    @Singleton
    fun providesAuthRepository(): FireBaseRepositoryImpl {
        return FireBaseRepositoryImpl(Firebase.auth)
    }


    @Provides
    @Singleton
    fun provideSharedPreferenceManager(@ApplicationContext context: Context): SharedPreferenceManager {
        return SharedPreferenceManager(context)

    }

    @Provides
    @Singleton
    fun provideRoomRepository(dao: ShopDAO): RoomRepository {
        return RoomRepository(dao)
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): DataBaseRoom {
        return Room.databaseBuilder(
            context,
            DataBaseRoom::class.java,
            "db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDAO(database:DataBaseRoom):ShopDAO{
        return database.getShopDAO()
    }

}