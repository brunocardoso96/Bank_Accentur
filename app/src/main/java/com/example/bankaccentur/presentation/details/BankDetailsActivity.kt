package com.example.bankaccentur.presentation.details

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bankaccentur.R
import com.example.bankaccentur.data.StatementApi
import com.example.bankaccentur.data.model.Statement
import com.example.bankaccentur.data.response.StatementListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BankDetailsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_details_activity)

        recyclerView = findViewById(R.id.recyclerViewPayment)

        StatementApi.service.getStatement().enqueue(object: Callback<StatementListResponse> {
            override fun onResponse(call: Call<StatementListResponse>, response: Response<StatementListResponse>) {
                if(response.isSuccessful) {
                    val lists: MutableList<Statement> = mutableListOf()
                    response.body()?.let{statementListResponse ->
                        for(result in statementListResponse.statementList) {
                            val listaState = result.getStatementModel()
                            lists.add(listaState)
                        }
                    }
                    initalizerRecycler(lists)
                }
            }

            override fun onFailure(call: Call<StatementListResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })



    }
    companion object {
        fun getStartIntent(context: Context): Intent { return Intent(context, BankDetailsActivity::class.java)}
    }

    fun initalizerRecycler(list: List<Statement>) {
        recyclerView.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@BankDetailsActivity, LinearLayout.VERTICAL, false)
            val adapter = BankAdapter(list)
            recyclerView.adapter = adapter
        }
    }

    fun listaPagamentos(): List<Statement> {
        return listOf(
            Statement("Pagamento", "Conta de luz", "2018-08-15", (-50).toDouble()),
            Statement("TED Recebida", "Joao Alfredo", "2018-07-25", (745.03).toDouble()),
            Statement("DOC Recebida", "Victor Silva", "2018-06-23", (399.9).toDouble()),
            Statement("Pagamento", "Conta de internet", "2018-05-12", (-73.4).toDouble())
        )
    }
}