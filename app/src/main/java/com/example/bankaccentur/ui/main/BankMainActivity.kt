package com.example.bankaccentur.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bankaccentur.R
import com.example.bankaccentur.data.model.Statement

class BankMainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_details_activity)

        initalizer()
    }
    companion object {
        fun getStartIntent(context: Context): Intent { return Intent(context, BankMainActivity::class.java)}
    }

    fun initalizer() {
        recyclerView = findViewById(R.id.recyclerViewPayment)
        val viewModel: BankViewModel = ViewModelProviders.of(this).get(BankViewModel::class.java)

        viewModel.bankLiveData.observe(this, Observer {
            it?.let {statements ->
                initalizeRecycler(statements)
            }
        })
        viewModel.getStatementLive()
    }

    @SuppressLint("WrongConstant")
    fun initalizeRecycler(list: List<Statement>) {
        recyclerView.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@BankMainActivity, LinearLayout.VERTICAL, false)
            val adapter = BankAdapter(list)
            recyclerView.adapter = adapter
        }
    }

}