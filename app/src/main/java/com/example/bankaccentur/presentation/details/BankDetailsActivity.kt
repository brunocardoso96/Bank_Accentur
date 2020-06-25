package com.example.bankaccentur.presentation.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bankaccentur.R

class BankDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_details_activity)
    }
    companion object {
        fun getStartIntent(context: Context): Intent { return Intent(context, BankDetailsActivity::class.java)}
    }
}