package com.example.bankaccentur.ui.login

import org.junit.Test

import org.junit.Assert.*

class UserVerificationTest {

    class verifyPassword {

        val verify = UserVerification()

        @Test
        fun verifyPassword_CorrectPassword_Up_To_FiveCaracters() {
            val onePassword = "A"
            val validateOnePassword = verify.verifyPassword(onePassword)
            assertEquals(false, validateOnePassword)

            val twoPassword = "A@"
            val validateTwoPassword = verify.verifyPassword(twoPassword)
            assertEquals(false, validateTwoPassword)

            val threePassword = "A@1"
            val validateThreePassword = verify.verifyPassword(threePassword)
            assertEquals(true, validateThreePassword)

            val fourPassword = "A@1a"
            val validateFourPassword = verify.verifyPassword(fourPassword)
            assertEquals(true, validateFourPassword)

            val fivePassword = "A@1aA"
            val validateFivePassword = verify.verifyPassword(fivePassword)
            assertEquals(true, validateFivePassword)

            val zeroPassword = ""
            val validateZeroPassword = verify.verifyPassword(zeroPassword)
            assertEquals(false, validateZeroPassword)
        }

        @Test
        fun verifyPassword_InvalidPassword_Up_To_FiveCaracters() {
            val onePassword = "a"
            val validateOnePassword = verify.verifyPassword(onePassword)
            assertEquals(false, validateOnePassword)

            val twoPassword = "aa"
            val validateTwoPassword = verify.verifyPassword(twoPassword)
            assertEquals(false, validateTwoPassword)

            val threePassword = "aaa"
            val validateThreePassword = verify.verifyPassword(threePassword)
            assertEquals(false, validateThreePassword)

            val fourPassword = "aaaa"
            val validateFourPassword = verify.verifyPassword(fourPassword)
            assertEquals(false, validateFourPassword)

            val fivePassword = "aaaaa"
            val validateFivePassword = verify.verifyPassword(fivePassword)
            assertEquals(false, validateFivePassword)

            val zeroPassword = ""
            val validateZeroPassword = verify.verifyPassword(zeroPassword)
            assertEquals(false, validateZeroPassword)
        }

        @Test
        fun verifyPassword_DuasTentativasDePassword_InvalidPassword_and_CorrectPassword() {
            val invalidPassword = "aaa"
            val validatePasswordInvalid = verify.verifyPassword(invalidPassword)
            assertEquals(false, validatePasswordInvalid)

            val correctPassword = "A@1"
            val validateCorrectPassword = verify.verifyPassword(correctPassword)
            assertEquals(true, validateCorrectPassword)
        }

        @Test
        fun verifyPassword_DuasTentativasDePassword_InvalidPassword_and_InvalidPassword() {
            val invalidPassword1 = "aaa"
            val validatePasswordInvalid = verify.verifyPassword(invalidPassword1)
            assertEquals(false, validatePasswordInvalid)

            val invalidPassword2 = "aaa"
            val validateCorrectPassword = verify.verifyPassword(invalidPassword2)
            assertEquals(false, validateCorrectPassword)
        }

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

    class verifyEmail {

        val verify = UserVerification()

        @Test
        fun verifyEmail_InvalidEmail_Inserting_Text() {
            val email = "teste"
            val validateEmail = verify.verifyEmail(email)
            assertEquals(false, validateEmail)
        }

        @Test
        fun verifyEmail_InvalidEmail_Inserting_SpecialCharacter() {
            val email = "@@@@@"
            val validateEmail = verify.verifyEmail(email)
            assertEquals(false, validateEmail)
        }

        @Test
        fun verifyEmail_InvalidEmail_Inserting_Text_SpecialCharacter() {
            val email = "teste@"
            val validateEmail = verify.verifyEmail(email)
            assertEquals(false, validateEmail)
        }

        @Test
        fun verifyEmail_InvalidEmail_Inserting_Text_SpecialCharacter_Text() {
            val email = "teste@teste."
            val validateEmail = verify.verifyEmail(email)
            assertEquals(false, validateEmail)
        }

        @Test
        fun verifyEmail_InvalidEmail_Inserting_SpecialCharacter_Text_Com() {
            val email = "@teste.com"
            val validateEmail = verify.verifyEmail(email)
            assertEquals(false, validateEmail)
        }

        @Test
        fun verifyEmail_InvalidEmail_Inserting_Text_Com() {
            val email = "teste.com"
            val validateEmail = verify.verifyEmail(email)
            assertEquals(false, validateEmail)
        }

        @Test
        fun verifyEmail_InvalidEmail_Inserting_Void() {
            val email = ""
            val validateEmail = verify.verifyEmail(email)
            assertEquals(false, validateEmail)
        }

        @Test
        fun verifyEmail_CorrectEmail_Inserting_EmailSimple_Com(){
            val email = "teste@teste.com"
            val validateEmail = verify.verifyEmail(email)
            assertEquals(true, validateEmail)
        }

        @Test
        fun verifyEmail_CorrectEmail_Inserting_EmailSimple_Com_Br(){
            val email = "teste@teste.com.br"
            val validateEmail = verify.verifyEmail(email)
            assertEquals(true, validateEmail)
        }
    }

    class verifyCpf {

        val verify = UserVerification()

        @Test
        fun verifyCpf_InvalidCpf_Inserting_Name() {
            val cpf = "teste"
            val validateCpf = verify.verifyCpf(cpf)
            assertEquals(false, validateCpf)
        }

        @Test
        fun verifyCpf_InvalidCpf_Inserting_SpecialCharacter() {
            val cpf = "@@@@@"
            val validateCpf = verify.verifyCpf(cpf)
            assertEquals(false, validateCpf)
        }

        @Test
        fun verifyCpf_InvalidCpf_Inserting_IncompleteCpf_10Numbers() {
            val cpf = "2534148362"
            val validateCpf = verify.verifyCpf(cpf)
            assertEquals(false, validateCpf)
        }

        @Test
        fun verifyCpf_InvalidCpf_Inserting_Name_CompletCpf() {
            val cpf = "Teste25341483626"
            val validateCpf = verify.verifyCpf(cpf)
            assertEquals(false, validateCpf)
        }

        @Test
        fun verifyCpf_InvalidCpf_Inserting_More_Than_11_Numbers() {
            val cpf = "253414836261"
            val validateCpf = verify.verifyCpf(cpf)
            assertEquals(false, validateCpf)
        }

        @Test
        fun verifyCpf_InvalidCpf_Inserting_Vazio() {
            val cpf = ""
            val validateCpf = verify.verifyCpf(cpf)
            assertEquals(false, validateCpf)
        }

        @Test
        fun verifyCpf_CorrectCpf_Inserting_Simple_Cpf(){
            val cpf = "92526376483"
            val validateCpf = verify.verifyCpf(cpf)
            assertEquals(true, validateCpf)

            val OtherCpf = "25341483626"
            val validateOtherCpf = verify.verifyCpf(OtherCpf)
            assertEquals(true, validateOtherCpf)
        }



    }

}
