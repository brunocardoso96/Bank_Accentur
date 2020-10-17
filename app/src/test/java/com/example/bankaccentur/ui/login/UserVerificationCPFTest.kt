package com.example.bankaccentur.ui.login

import org.junit.Assert
import org.junit.Test

class UserVerificationCPFTest {

        val verify = UserVerification()

        @Test
        fun verifyCpf_InvalidCpf_Inserting_Name() {
            val cpf = "teste"
            val validateCpf = verify.verifyCpf(cpf)
            Assert.assertEquals(false, validateCpf)
        }

        @Test
        fun verifyCpf_InvalidCpf_Inserting_SpecialCharacter() {
            val cpf = "@@@@@"
            val validateCpf = verify.verifyCpf(cpf)
            Assert.assertEquals(false, validateCpf)
        }

        @Test
        fun verifyCpf_InvalidCpf_Inserting_IncompleteCpf_10Numbers() {
            val cpf = "2534148362"
            val validateCpf = verify.verifyCpf(cpf)
            Assert.assertEquals(false, validateCpf)
        }

        @Test
        fun verifyCpf_InvalidCpf_Inserting_Name_CompletCpf() {
            val cpf = "Teste25341483626"
            val validateCpf = verify.verifyCpf(cpf)
            Assert.assertEquals(false, validateCpf)
        }

        @Test
        fun verifyCpf_InvalidCpf_Inserting_More_Than_11_Numbers() {
            val cpf = "253414836261"
            val validateCpf = verify.verifyCpf(cpf)
            Assert.assertEquals(false, validateCpf)
        }

        @Test
        fun verifyCpf_InvalidCpf_Inserting_Vazio() {
            val cpf = ""
            val validateCpf = verify.verifyCpf(cpf)
            Assert.assertEquals(false, validateCpf)
        }

        @Test
        fun verifyCpf_CorrectCpf_Inserting_Simple_Cpf(){
            val cpf = "92526376483"
            val validateCpf = verify.verifyCpf(cpf)
            Assert.assertEquals(true, validateCpf)

            val OtherCpf = "25341483626"
            val validateOtherCpf = verify.verifyCpf(OtherCpf)
            Assert.assertEquals(true, validateOtherCpf)
        }
}