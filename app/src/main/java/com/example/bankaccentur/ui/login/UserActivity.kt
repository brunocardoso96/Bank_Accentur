package com.example.bankaccentur.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bankaccentur.ui.main.BankMainActivity
import com.example.bankaccentur.R
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        initialize()
    }

    fun initialize() {
        clickButtonLogin()

    }

    fun clickButtonLogin() {
        buttonLogin = findViewById(R.id.buttonLogin)
        val viewModel: UserViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        viewModel.autenticLogin()

        buttonLogin.setOnClickListener {
            val intent = BankMainActivity.getStartIntent(this@UserActivity)
            viewModel.userLiveData.observe(this, Observer {userResponse ->
                userResponse?.let {
                    intent.putExtra("EXTRA_userId", it.userId.toString())
                    intent.putExtra("EXTRA_name", it.name)
                    intent.putExtra("EXTRA_bankAccount", it.bankAccount)
                    intent.putExtra("EXTRA_agency", it.agency)
                    intent.putExtra("EXTRA_balance", it.balance.toString())
                }
            })
            this@UserActivity.startActivity(intent)
            verifyPassword()
        }
    }

    fun verifyPassword() {
        val passInput = textViewPass.text
        if(!VerifyPassword().verificar(passInput)) {
            Log.i("VERIFY", "False")
            intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext, "Email ou Senha errado", Toast.LENGTH_LONG).show()
        }

    }
}