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
import com.example.bankaccentur.data.model.StatementResponse
import kotlinx.android.synthetic.main.activity_bank_main_activity.*
import java.lang.Exception


class BankMainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_main_activity)

        initalizer()
    }
    companion object {
        fun getStartIntent(context: Context): Intent { return Intent(context, BankMainActivity::class.java)}
    }

    fun initalizer() {
        recyclerView = findViewById(R.id.recyclerViewPayment)
        val viewModel: BankViewModel = ViewModelProviders.of(this).get(BankViewModel::class.java)
        initializeUserInfo()
        viewModel.bankLiveData.observe(this, Observer {
            it?.let {statements ->
                initalizeRecycler(statements)
            }
        })
        val userId = intent.getStringExtra("EXTRA_userId")
        viewModel.getStatementLive(userId.toInt())
    }

    @SuppressLint("WrongConstant")
    fun initalizeRecycler(list: List<StatementResponse>) {
        recyclerView.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@BankMainActivity, LinearLayout.VERTICAL, false)
            val adapter = BankAdapter(list)
            recyclerView.adapter = adapter
        }
    }

    fun initializeUserInfo() {
        val name = intent.getStringExtra("EXTRA_name")
        val bankAccount = intent.getStringExtra("EXTRA_bankAccount")
        val agency = intent.getStringExtra("EXTRA_agency")
        val balance = intent.getStringExtra("EXTRA_balance")

        textViewName.setText(name)
        textViewAgency.setText(agency)
        textViewBankAccount.setText(accountFormat(bankAccount))
        textViewBalance.setText(balance)
    }

    fun accountFormat(account: String): String {
        try {
            val campo1 = account.substring(0,2)
            val campo2 = account.substring(2,8)
            val campo3 = account.substring(8,9)
            return "$campo1.$campo2-$campo3"
        } catch (e: Exception) {
            return account
            Log.i("ERROR FORMAT", "Erro ao formatar a string $account")
        }

    }



}

