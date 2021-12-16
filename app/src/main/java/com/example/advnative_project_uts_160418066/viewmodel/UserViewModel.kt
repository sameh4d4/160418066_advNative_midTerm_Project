package com.example.advnative_project_uts_160418066.viewmodel

import android.app.Application
import android.util.Log
import com.android.volley.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.AndroidViewModel
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.advnative_project_uts_160418066.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UserViewModel(application: Application):AndroidViewModel(application) {
    val userLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val userLD= MutableLiveData<User>()
    val adaDataLD=MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun getUser(user:User){
        userLD.value=user
        userLoadErrorLD.value = false
        loadingLD.value = false
    }

    fun login(pUsername:String,pPassword:String){
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://ubaya.fun/flutter/160418066/API/AdvNa_uas/login.php"

        val stringRequest = object:StringRequest(
            Method.POST, url,
            { response ->
                val sType = object : TypeToken<User>() { }.type
                val result = Gson().fromJson<User>(response, sType)
                userLD.value = result
                userLoadErrorLD.value = false
                loadingLD.value = false
//                user= userLD.value!!
                adaDataLD.value = result.id!=null
                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
            }
        ){
            override fun getParams(): MutableMap<String, String> {
                val param= HashMap<String,String>()
                param["username"] = pUsername
                param["password"] = pPassword
                return param
            }
        }
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}