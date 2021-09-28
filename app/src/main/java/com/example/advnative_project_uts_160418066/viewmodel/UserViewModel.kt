package com.example.advnative_project_uts_160418066.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advnative_project_uts_160418066.model.User

class UserViewModel:ViewModel() {
    val userLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val userLD= MutableLiveData<User>()

    fun getUser(){
        val user=User("00-xx-xx-11","Nicky Setyawan Dinata", "14-06-2000","085755173422","s160418066@student.ubaya.ac.id")
        userLD.value=user
        userLoadErrorLD.value = false
        loadingLD.value = false
    }
}