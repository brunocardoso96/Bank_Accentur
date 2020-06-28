package com.example.bankaccentur.data.response

import com.example.bankaccentur.data.model.Statement

data class StatementResponse(val title: String, val desc: String, val date: String, val value: Double) {

    fun getStatementModel() =  Statement(
        title = this.title,
        desc = this.desc,
        date = this.date,
        value = this.value)

}