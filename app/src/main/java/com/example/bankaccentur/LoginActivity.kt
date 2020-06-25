package com.example.bankaccentur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonLogin = findViewById(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val intent = LoginDetailsActivity.getStartIntent(this@LoginActivity)
            this@LoginActivity.startActivity(intent)
        }
    }
}