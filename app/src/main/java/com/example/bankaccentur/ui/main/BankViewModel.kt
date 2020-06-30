package com.example.bankaccentur.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bankaccentur.data.retrofit.Api
import com.example.bankaccentur.data.model.StatementListResponse
import com.example.bankaccentur.data.model.StatementResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BankViewModel : ViewModel() {

    val bankLiveData: MutableLiveData<List<StatementResponse>> = MutableLiveData()

    fun getStatementLive() {
        Api.serviceStatement.getStatement().enqueue(object: Callback<StatementListResponse> {
            override fun onResponse(call: Call<StatementListResponse>, response: Response<StatementListResponse>) {
                if(response.isSuccessful) {
                    val lists: MutableList<StatementResponse> = mutableListOf()
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