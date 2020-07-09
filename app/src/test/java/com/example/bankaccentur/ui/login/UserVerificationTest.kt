package com.example.bankaccentur.ui.login

import org.junit.Test

import org.junit.Assert.*

class UserVerificationTest {

    val verify = UserVerification()

    @Test
    fun verifyPassword_InvalidPassword_Inserting_LowerCase_Number_Number() {
        val password = "a11"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_LowerCase_Number_UpperCase() {
        val password = "a1A"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_LowerCase_Number_SpecialCharacter() {
        val password = "a1@"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_LowerCase_UpperCase_Number() {
        val password = "aA1"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_LowerCase_UpperCase_UpperCase() {
        val password = "aAA"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }
    @Test
    fun verifyPassword_CorrectPassword_Inserting_LowerCase_UpperCase_SpecialCharacter() {
        val password = "aA@"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(true, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_LowerCase_SpecialCharacter_Number() {
        val password = "a@1"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_CorrectPassword_Inserting_LowerCase_SpecialCharacter_UpperCase() {
        val password = "a@A"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(true, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_LowerCase_SpecialCharacter_SpecialCharacter() {
        val password = "a@@"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }


}

/*

    @Test
    fun verifyPassword_InvalidPassword_InsertingNumber() {
        val password = "aaa"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }


*/