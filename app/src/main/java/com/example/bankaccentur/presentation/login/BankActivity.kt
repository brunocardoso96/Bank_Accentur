package com.example.bankaccentur.presentation.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.bankaccentur.presentation.details.BankDetailsActivity
import com.example.bankaccentur.R

class BankActivity : AppCompatActivity() {

    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonLogin = findViewById(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val intent =
                BankDetailsActivity.getStartIntent(
                    this@BankActivity
                )
            this@BankActivity.startActivity(intent)
        }
    }
}