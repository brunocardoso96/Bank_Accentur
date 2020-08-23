package com.example.bankaccentur.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Button
import android.widget.TextView
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

    private fun initialize() {
        clickButtonLogin()
        val userSave = PreferenceManager.getDefaultSharedPreferences(this@UserActivity).getString("MYLABEL", "defaultValue")

        // pra não ficar colocando a senha sempre
        val passSave = PreferenceManager.getDefaultSharedPreferences(this@UserActivity).getString("MYPASS", "@Aa2")
        // pra não ficar colocando a senha sempre

        textViewUser.setText(userSave)
        textViewPass.setText(passSave)
    }

    private fun clickButtonLogin() {
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonLogin.setOnClickListener {
            val viewModel: UserViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
            val passInput = textViewPass.text.toString()
            val userInput = textViewUser.text.toString()
            PreferenceManager.getDefaultSharedPreferences(this@UserActivity).edit().putString("MYLABEL", userInput).apply()

            // pra não ficar colocando a senha sempre
            PreferenceManager.getDefaultSharedPreferences(this@UserActivity).edit().putString("MYPASS", passInput).apply()
            // pra não ficar colocando a senha sempre

            viewModel.autenticLogin(userInput, passInput)
            val intent = BankMainActivity.getStartIntent(this@UserActivity)
            if(verifyUser()) {
                viewModel.userLiveData.observe(this, Observer {userResponse ->
                    userResponse?.let {
                        intent.putExtra("EXTRA_userId", it.userId.toString())
                        intent.putExtra("EXTRA_name", it.name)
                        intent.putExtra("EXTRA_bankAccount", it.bankAccount)
                        intent.putExtra("EXTRA_agency", it.agency)
                        intent.putExtra("EXTRA_balance", it.balance.toString())
                    }
                    this@UserActivity.startActivity(intent)
                })
            }
        }
    }

    fun verifyUser(): Boolean {
        val pass= verifyPassword()
        val email= verifyCpf()
        val cpf= verifyEmail()
        intent = Intent(this, UserActivity::class.java)

        when {
            !pass -> {
                startActivity(intent)
                Toast.makeText(applicationContext, "Email ou Senha errado", Toast.LENGTH_LONG).show()
                Log.i("VERIFY", "Login/Password error Password")
                return false
            }
            cpf -> {
                Log.i("VERIFY", "CPF OK")
                return true
            }
            email -> {
                Log.i("VERIFY", "Email Ok")
                return true
            }
            else -> {
                startActivity(intent)
                Toast.makeText(applicationContext, "Email ou Senha errado", Toast.LENGTH_LONG).show()
                Log.i("VERIFY", "Login/Password error - pass OK")
                return false
            }
        }
    }

    private fun verifyPassword(): Boolean {
        val passInput = textViewPass.text.toString()
        if(!UserVerification().verifyPassword(passInput)) return false
        return true
    }

    private fun verifyCpf(): Boolean {
        val userInput = textViewUser.text.toString()
        if(!UserVerification().verifyCpf(userInput)) return false
        return true
    }

    private fun verifyEmail(): Boolean {
        val userInput = textViewUser.text.toString()
        if(!UserVerification().verifyEmail(userInput)) return false
        return true
    }
}