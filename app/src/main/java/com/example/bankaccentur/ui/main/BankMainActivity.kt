package com.example.bankaccentur.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bankaccentur.R
import com.example.bankaccentur.data.helper.FormatAccont
import com.example.bankaccentur.data.helper.FormatBalance
import com.example.bankaccentur.data.model.StatementResponse
import kotlinx.android.synthetic.main.activity_bank_main_activity.*
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*


class BankMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_main_activity)

        initalizer()
    }
    companion object {
        fun getStartIntent(context: Context): Intent { return Intent(context, BankMainActivity::class.java)}
    }

    private fun initalizer() {
        insertUserInfo()
        initalizeViewModel()
    }

    private fun initalizeViewModel() {
        val viewModel: BankViewModel = ViewModelProviders.of(this).get(BankViewModel::class.java)
        viewModel.bankLiveData.observe(this, Observer {
            it?.let {statements ->
                initalizeRecycler(statements)
            }
        })
        val userId = intent.getStringExtra("EXTRA_userId")
        viewModel.getStatementLive(userId.toInt())
    }

    private fun initalizeRecycler(list: List<StatementResponse>) {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewPayment)
        recyclerView.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@BankMainActivity, RecyclerView.VERTICAL, false)
            recyclerView.adapter = BankAdapter(list)
        }
    }

    private fun insertUserInfo() {
        textViewName.setText(intent.getStringExtra("EXTRA_name"))
        textViewAgency.setText(intent.getStringExtra("EXTRA_agency"))
        textViewBankAccount.setText(FormatAccont.format(intent.getStringExtra("EXTRA_bankAccount")))
        textViewBalance.setText(FormatBalance.format(intent.getStringExtra("EXTRA_balance")))
    }
}


