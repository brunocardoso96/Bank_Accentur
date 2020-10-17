package com.example.bankaccentur.ui.login

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

    fun autenticLogin(user: String, pass: String){
        Api.serviceUser.postAluno(user, pass).enqueue(object:
            Callback<UserAccountResponse> {
            override fun onResponse(call: Call<UserAccountResponse>, response: Response<UserAccountResponse>) {
                response.body()?.let {userAccountResponse ->
                    val user = userAccountResponse.userAccount
                    userLiveData.value = user
                }
            }
            override fun onFailure(call: Call<UserAccountResponse>, t: Throwable) {

            }
        })
    }
}