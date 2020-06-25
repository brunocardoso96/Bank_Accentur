package com.example.bankaccentur

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LoginDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_details_activity)
    }
    companion object {
        fun getStartIntent(context: Context): Intent { return Intent(context, LoginDetailsActivity::class.java)}
    }
}