package com.example.bankaccentur.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bankaccentur.data.retrofit.StatementApi
import com.example.bankaccentur.data.model.Statement
import com.example.bankaccentur.data.model.StatementListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BankViewModel : ViewModel() {

    val bankLiveData: MutableLiveData<List<Statement>> = MutableLiveData()

    fun getStatementLive() {
        StatementApi.service.getStatement().enqueue(object: Callback<StatementListResponse> {
            override fun onResponse(call: Call<StatementListResponse>, response: Response<StatementListResponse>) {
                if(response.isSuccessful) {
                    val lists: MutableList<Statement> = mutableListOf()
                    response.body()?.let{statementListResponse ->
                        for(result in statementListResponse.statementList) {
                            val listaState = result.getStatementModel()
                            lists.add(listaState)
                        }
                        bankLiveData.value = lists
                    }
                }
            }
            override fun onFailure(call: Call<StatementListResponse>, t: Throwable) {
            }
        })
    }
}