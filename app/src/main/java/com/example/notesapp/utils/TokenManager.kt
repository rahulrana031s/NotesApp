package com.example.notesapp.utils

import android.content.Context
import com.example.notesapp.utils.Constants.PREF_TOKEN_FILE
import com.example.notesapp.utils.Constants.USER_TOKEN
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManager @Inject constructor(@ApplicationContext context: Context) {

    private val pref = context.getSharedPreferences(PREF_TOKEN_FILE,Context.MODE_PRIVATE)

    fun saveToken(token:String){
        val editor = pref.edit()
        editor.putString(USER_TOKEN,token)
        editor.apply()
    }

    fun getToke(): String?{
        return  pref.getString(USER_TOKEN,null)
    }


}