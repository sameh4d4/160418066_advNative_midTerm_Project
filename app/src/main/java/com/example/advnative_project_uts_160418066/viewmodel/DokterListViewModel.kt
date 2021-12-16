package com.example.advnative_project_uts_160418066.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advnative_project_uts_160418066.model.Dokter

class DokterListViewModel:ViewModel() {
    val doktersLD = MutableLiveData<List<Dokter>>()
    val doktersLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val dokterLD=MutableLiveData<Dokter>()

    fun getDokterList(): ArrayList<Dokter> {
        val Dokter1 = Dokter(
            "0",
            "Dr.achmad fahmi, dr., Sp.BS(K)",
            "Neuro Surgery",
            "081231",
            "email1@test.com",
            "jl raya",
            "https://i.pravatar.cc/300?img=0")
        val Dokter2 = Dokter(
            "1",
            "Dr.agoes wilyono, Sp.S",
            "Neurology",
            "081232",
            "email2@test.com",
            "jl raya",
            "https://i.pravatar.cc/300?img=1")
        val Dokter3 = Dokter(
            "2",
            "Dr.achmad yuniari heryana, Sp.A",
            "Paediatric",
            "081233",
            "email3@test.com",
            "jl raya",
            "https://i.pravatar.cc/300?img=2")
        return arrayListOf(Dokter1,Dokter2,Dokter3)
    }

    fun refresh() {
        val dokterList:ArrayList<Dokter> = getDokterList()
        doktersLD.value = dokterList
        doktersLoadErrorLD.value = false
        loadingLD.value = false
    }

    fun getOneDokter(id:Int){
        dokterLD.value=getDokterList()[id]
    }
}