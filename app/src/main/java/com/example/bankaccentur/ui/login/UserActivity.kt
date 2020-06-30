package com.example.bankaccentur.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.bankaccentur.ui.main.BankMainActivity
import com.example.bankaccentur.R
import com.example.bankaccentur.data.model.UserAccountResponse
import com.example.bankaccentur.data.model.UserLoginRequest
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

        Api.serviceUser.postAluno("test_user", "Test@1").enqueue(object: Callback<UserAccountResponse> {
            override fun onResponse(call: Call<UserAccountResponse>, response: Response<UserAccountResponse>) {

                Log.i("USER_VERIFY", "Login Batendo na API")


                    val user = response.body()
                    Log.i("USER_VERIFY", "Nome: " + user)
            }

            override fun onFailure(call: Call<UserAccountResponse>, t: Throwable) {
                Log.i("USER_VERIFY", "Login Error")
            }

        })
    }
    fun initialize() {
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonLogin.setOnClickListener {
            val intent =
                BankMainActivity.getStartIntent(
                    this@UserActivity
                )
            this@UserActivity.startActivity(intent)
        }
    }
}