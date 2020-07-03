package com.example.bankaccentur.ui.login

import android.text.Editable
import android.util.Log
import java.util.regex.Pattern


class VerifyPassword {
    private val PASSWORD_PATTERN = Pattern.compile(
        "^" +  "(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +  //any letter
                "(?=.*[@#$%^&+=])" +  //at least 1 special character
                "(?=\\S+$)" +  //no white spaces
                ".{4,}" +  //at least 4 characters
                "$"
    )
    fun verificar(pass: Editable): Boolean {
        if(PASSWORD_PATTERN.matcher(pass).matches()) {
            Log.i("VERIFY", "SUCESSO")
            return true
        } else {
            Log.i("VERIFY", "Senha erraada")
            return false
        }
    }





}