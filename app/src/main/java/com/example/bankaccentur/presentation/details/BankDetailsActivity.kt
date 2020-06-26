package com.example.bankaccentur.presentation.details

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bankaccentur.R
import com.example.bankaccentur.data.model.PaymentHistory

class BankDetailsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_details_activity)

        recyclerView = findViewById(R.id.recyclerViewPayment)

        recyclerView.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@BankDetailsActivity, LinearLayout.VERTICAL, false)
            val adapter = BankAdapter(listaPagamentos())
            recyclerView.adapter = adapter
        }
    }
    companion object {
        fun getStartIntent(context: Context): Intent { return Intent(context, BankDetailsActivity::class.java)}
    }

    fun listaPagamentos(): List<PaymentHistory> {
        return listOf(
            PaymentHistory("Pagamento", "Conta de luz", "2018-08-15", (-50).toDouble()),
            PaymentHistory("TED Recebida", "Joao Alfredo", "2018-07-25", (745.03).toDouble()),
            PaymentHistory("DOC Recebida", "Victor Silva", "2018-06-23", (399.9).toDouble()),
            PaymentHistory("Pagamento", "Conta de internet", "2018-05-12", (-73.4).toDouble())
        )
    }
}