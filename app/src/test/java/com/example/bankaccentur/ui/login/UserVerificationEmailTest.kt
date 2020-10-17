package com.example.bankaccentur.ui.login

import org.junit.Assert
import org.junit.Test

class UserVerificationEmailTest {

        val verify = UserVerification()

        @Test
        fun verifyEmail_InvalidEmail_Inserting_Text() {
            val email = "teste"
            val validateEmail = verify.verifyEmail(email)
            Assert.assertEquals(false, validateEmail)
        }

        @Test
        fun verifyEmail_InvalidEmail_Inserting_SpecialCharacter() {
            val email = "@@@@@"
            val validateEmail = verify.verifyEmail(email)
            Assert.assertEquals(false, validateEmail)
        }

        @Test
        fun verifyEmail_InvalidEmail_Inserting_Text_SpecialCharacter() {
            val email = "teste@"
            val validateEmail = verify.verifyEmail(email)
            Assert.assertEquals(false, validateEmail)
        }

        @Test
        fun verifyEmail_InvalidEmail_Inserting_Text_SpecialCharacter_Text() {
            val email = "teste@teste."
            val validateEmail = verify.verifyEmail(email)
            Assert.assertEquals(false, validateEmail)
        }

        @Test
        fun verifyEmail_InvalidEmail_Inserting_SpecialCharacter_Text_Com() {
            val email = "@teste.com"
            val validateEmail = verify.verifyEmail(email)
            Assert.assertEquals(false, validateEmail)
        }

        @Test
        fun verifyEmail_InvalidEmail_Inserting_Text_Com() {
            val email = "teste.com"
            val validateEmail = verify.verifyEmail(email)
            Assert.assertEquals(false, validateEmail)
        }

        @Test
        fun verifyEmail_InvalidEmail_Inserting_Void() {
            val email = ""
            val validateEmail = verify.verifyEmail(email)
            Assert.assertEquals(false, validateEmail)
        }

        @Test
        fun verifyEmail_CorrectEmail_Inserting_EmailSimple_Com(){
            val email = "teste@teste.com"
            val validateEmail = verify.verifyEmail(email)
            Assert.assertEquals(true, validateEmail)
        }

        @Test
        fun verifyEmail_CorrectEmail_Inserting_EmailSimple_Com_Br(){
            val email = "teste@teste.com.br"
            val validateEmail = verify.verifyEmail(email)
            Assert.assertEquals(true, validateEmail)
        }
}