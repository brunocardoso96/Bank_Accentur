package com.example.bankaccentur.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bankaccentur.data.model.UserAccountResponse
import com.example.bankaccentur.data.model.UserResponse
import com.example.bankaccentur.data.retrofit.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {

    val userLiveData: MutableLiveData<UserResponse> = MutableLiveData()

    fun autenticLogin() {

        Api.serviceUser.postAluno("test_user", "Test@1").enqueue(object:
            Callback<UserAccountResponse> {
            override fun onResponse(call: Call<UserAccountResponse>, response: Response<UserAccountResponse>) {
                Log.i("USER_VERIFY", "Login Batendo na API")
//                val user = response.body()
                response.body()?.let {userAccountResponse ->
                    val user = userAccountResponse.userAccount
                    Log.i("USER_VERIFY", "Nome: " + user.name)

                    userLiveData.value = user
                }


            }
            override fun onFailure(call: Call<UserAccountResponse>, t: Throwable) {
                Log.i("USER_VERIFY", "Login Error")
            }

        })
    }

}