package com.example.bankaccentur.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.bankaccentur.ui.main.BankMainActivity
import com.example.bankaccentur.R
import com.example.bankaccentur.data.model.UserAccountResponse
import com.example.bankaccentur.data.retrofit.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {

    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
    }
    fun initialize() {
        clickButtonLogin()
    }

    fun clickButtonLogin() {
        buttonLogin = findViewById(R.id.buttonLogin)
        val viewModel: UserViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        buttonLogin.setOnClickListener {
            val intent =
                BankMainActivity.getStartIntent(
                    this@UserActivity
                )

           viewModel.autenticLogin()

            this@UserActivity.startActivity(intent)
        }
    }
}