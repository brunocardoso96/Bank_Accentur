package com.example.bankaccentur.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.bankaccentur.ui.main.BankMainActivity
import com.example.bankaccentur.R

class LoginActivity : AppCompatActivity() {

    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
    }

    fun initialize() {
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonLogin.setOnClickListener {
            val intent =
                BankMainActivity.getStartIntent(
                    this@LoginActivity
                )
            this@LoginActivity.startActivity(intent)
        }
    }
}