package com.example.bankaccentur.presentation.details

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
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
        val viewModel: BankViewModel = ViewModelProviders.of(this).get(BankViewModel::class.java)

        viewModel.bankLiveData.observe(this, Observer {
            it?.let {statements ->
                initalizerRecycler(statements)
            }
        })

        viewModel.getStatementLive()

    }
    companion object {
        fun getStartIntent(context: Context): Intent { return Intent(context, BankDetailsActivity::class.java)}
    }

    @SuppressLint("WrongConstant")
    fun initalizerRecycler(list: List<Statement>) {
        recyclerView.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@BankDetailsActivity, LinearLayout.VERTICAL, false)
            val adapter = BankAdapter(list)
            recyclerView.adapter = adapter
        }
    }

}