package com.example.bankaccentur.ui.login

import java.util.*
import java.util.regex.Pattern


class UserVerification {

    private val EMAIL_ADRESS = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})"
    )

    private val PASSWORD_PATTERN = Pattern.compile(
        "^" +  "(?=.*[0-9])" +
                "(?=.*[A-Z])" +
                "(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&+=])" +
                "(?=\\S+$)" +
                ".{4,}" +
                "$"
    )
    fun verifyPassword(pass: String): Boolean {
        return PASSWORD_PATTERN.matcher(pass).matches()
    }

    fun verifyCpf(CPF: String): Boolean {
        if (CPF == "00000000000" || CPF == "11111111111" || CPF == "22222222222" ||
            CPF == "33333333333" || CPF == "44444444444" || CPF == "55555555555" ||
            CPF == "66666666666" || CPF == "77777777777" || CPF == "88888888888" ||
            CPF == "99999999999" || CPF.length != 11) return false

        val dig10: Char
        val dig11: Char
        var sm: Int
        var i: Int
        var r: Int
        var num: Int
        var peso: Int

        return try {
            sm = 0
            peso = 10
            i = 0

            while (i < 9) {
                num = (CPF[i].toInt() - 48)
                sm = sm + num * peso
                peso = peso - 1
                i++ }

            r = 11 - sm % 11
            dig10 = if (r == 10 || r == 11) '0' else (r + 48).toChar() // converte no respectivo caractere numerico

            sm = 0
            peso = 11
            i = 0
            while (i < 10) {
                num = (CPF[i].toInt() - 48)
                sm = sm + num * peso
                peso = peso - 1
                i++
            }
            r = 11 - sm % 11
            dig11 = if (r == 10 || r == 11) '0' else (r + 48).toChar()

            if (dig10 == CPF[9] && dig11 == CPF[10]) true else false
        } catch (erro: InputMismatchException) {
            false
        }
    }

    fun verifyEmail(email: String): Boolean {
        return EMAIL_ADRESS.matcher(email).matches()
    }
}