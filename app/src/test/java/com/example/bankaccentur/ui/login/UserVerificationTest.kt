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

    @Test
    fun verifyPassword_InvalidPassword_Inserting_Number_LowerCase_LowerCase() {
        val password = "1aa"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_Number_LowerCase_UpperCase() {
        val password = "1aA"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_Number_LowerCase_SpecialCharacter() {
        val password = "1a@"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_Number_UpperCase_LowerCase() {
        val password = "1Aa"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_Number_UpperCase_UpperCase() {
        val password = "1AA"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_CorrectPassword_Inserting_Number_UpperCase_SpecialCharacter() {
        val password = "1A@"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(true, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_Number_SpecialCharacter_LowerCase() {
        val password = "1@a"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_CorrectPassword_Inserting_Number_SpecialCharacter_UpperCase() {
        val password = "1@A"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(true, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_Number_SpecialCharacter_SpecialCharacter() {
        val password = "1@@"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_UpperCase_LowerCase_LowerCase() {
        val password = "Aaa"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_UpperCase_LowerCase_Number() {
        val password = "Aa1"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_CorrectPassword_Inserting_UpperCase_LowerCase_EspecialCharacter() {
        val password = "Aa@"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(true, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_UpperCase_Number_LowerCase() {
        val password = "A1a"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_UpperCase_Number_Number() {
        val password = "A11"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_CorrectPassword_Inserting_UpperCase_Number_SpecialCharacter() {
        val password = "A1@"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(true, validarPassword)
    }

    @Test
    fun verifyPassword_CorrectPassword_Inserting_UpperCase_SpecialCharacter_LowerCase() {
        val password = "A@a"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(true, validarPassword)
    }

    @Test
    fun verifyPassword_CorrectPassword_Inserting_UpperCase_SpecialCharacter_Number() {
        val password = "A@1"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(true, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_UpperCase_SpecialCharacter_SpecialCharacter() {
        val password = "A@@"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_SpecialCharacter_LowerCase_LowerCase() {
        val password = "@aa"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_SpecialCharacter_LowerCase_Number() {
        val password = "@a1"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_CorrectPassword_Inserting_SpecialCharacter_LowerCase_UpperCase() {
        val password = "@aA"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(true, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_SpecialCharacter_Number_LowerCase() {
        val password = "@1a"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_SpecialCharacter_Number_Number() {
        val password = "@11"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_CorrectPassword_Inserting_SpecialCharacter_Number_UpperCase() {
        val password = "@1A"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(true, validarPassword)
    }

    @Test
    fun verifyPassword_InvalidPassword_Inserting_SpecialCharacter_UpperCase_UpperCase() {
        val password = "@AA"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }

    @Test
    fun verifyPassword_CorrectPassword_Inserting_SpecialCharacter_UpperCase_LowerCase() {
        val password = "@Aa"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(true, validarPassword)
    }

    @Test
    fun verifyPassword_CorrectPassword_Inserting_SpecialCharacter_UpperCase_Number() {
        val password = "@A1"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(true, validarPassword)
    }

}

/*

 @Test
    fun verifyPassword_InvalidPassword_Inserting_SpecialCharacter_() {
        val password = "aaa"
        val validarPassword = verify.verifyPassword(password)
        assertEquals(false, validarPassword)
    }




*/