package com.example.advnative_project_uts_160418066.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advnative_project_uts_160418066.model.Dokter

class DokterListViewModel:ViewModel() {
    val doktersLD = MutableLiveData<List<Dokter>>()
    val studentLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh() {
        val Dokter1 = Dokter(
            "0",
            "Dr.achmad fahmi, dr., Sp.BS(K)",
            "Neuro Surgery",
            "00000",
            "email@test.com",
            "jl raya",
            "http://adv.jitusolution.com/student.php?id=0")
        val Dokter2 = Dokter(
            "1",
            "Dr.agoes wilyono, Sp.S",
            "Neurology",
            "00000",
            "email@test.com",
            "jl raya",
            "http://adv.jitusolution.com/student.php?id=1")
        val Dokter3 = Dokter(
            "2",
            "Dr.achmad yuniari heryana, Sp.A",
            "Paediatric",
            "00000",
            "email@test.com",
            "jl raya",
            "http://adv.jitusolution.com/student.php?id=2")

        val dokterList:ArrayList<Dokter> = arrayListOf<Dokter>(Dokter1,Dokter2,Dokter3)
        doktersLD.value = dokterList
        studentLoadErrorLD.value = false
        loadingLD.value = false
    }
}