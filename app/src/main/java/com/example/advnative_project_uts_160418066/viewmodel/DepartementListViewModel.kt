package com.example.advnative_project_uts_160418066.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advnative_project_uts_160418066.model.Departemen

class DepartementListViewModel: ViewModel() {
    val DepartementsLD = MutableLiveData<List<Departemen>>()
    val DepartementsLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh() {
        val dep1 = Departemen("Andrology")
        val dep2= Departemen("Cardiology")
        val listdep= arrayListOf<Departemen>(dep1,dep2)
        DepartementsLD.value = listdep
        DepartementsLoadErrorLD.value = false
        loadingLD.value = false
    }
}