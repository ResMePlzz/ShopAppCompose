package com.example.shopappcomposefinal.data.shared_pref

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.core.content.edit

class SharedPreferenceManager(context: Context) {


    companion object {
        const val EMAIL = "EmailSP"
        const val PROVIDER_AUTH = "ProviderAuth"
        const val CHANGE_ICON_COLOR = "CHANGE_ICON_COLOR"
    }

    val sharedPreferences = context.getSharedPreferences(
        "CurrentUserSP",
        ComponentActivity.MODE_PRIVATE
    )

    val editor = sharedPreferences.edit()

    var email: String
        get() = sharedPreferences.getString(EMAIL, "") ?: ""
        set(value) {
            editor.putString(EMAIL, value).apply()
        }

    var providerAuth: String
        get() = sharedPreferences.getString(PROVIDER_AUTH, "") ?: ""
        set(value) {
            editor.putString(PROVIDER_AUTH, value).apply()
        }

    var favoriteIcon: Boolean
        get() = sharedPreferences.getBoolean(CHANGE_ICON_COLOR, false)
        set(value) {
            editor.putBoolean(PROVIDER_AUTH, value).apply()
        }

}