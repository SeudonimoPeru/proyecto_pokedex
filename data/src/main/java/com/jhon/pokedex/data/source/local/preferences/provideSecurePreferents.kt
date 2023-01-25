package com.jhon.pokedex.data.source.local.preferences

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import com.jhon.pokedex.data.source.local.preferences.ConstansPreferences.SECURE_PREFS_FILE_KEY

object SharedPreferencesUtils {

    /**
     * Multiple preferences files
     * more information: https://medium.com/@prus.piotr/multiple-shared-preferences-how-to-manage-them-with-koin-di-dbebeb95b121
     */
    fun provideSecurePreferences(app: Application): SharedPreferences =
        app.getSharedPreferences(SECURE_PREFS_FILE_KEY, Context.MODE_PRIVATE)

    fun provideSecurePreferences(app: Application, sharedPreferencesKey: SharedPreferencesKey): SharedPreferences {
        return if (sharedPreferencesKey.getMasterKey() != null) {
            EncryptedSharedPreferences.create(
                app,
                SECURE_PREFS_FILE_KEY,
                sharedPreferencesKey.getMasterKey()!!,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        } else {
            provideSecurePreferences(app)
        }
    }
}