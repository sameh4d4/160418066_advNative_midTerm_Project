package com.example.advnative_project_uts_160418066.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.advnative_project_uts_160418066.model.Dokter
import com.example.advnative_project_uts_160418066.util.buildDbDepart
import com.example.advnative_project_uts_160418066.util.buildDbDokter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DokterListViewModel(application: Application):AndroidViewModel(application), CoroutineScope {
    val doktersLD = MutableLiveData<List<Dokter>>()
    val doktersLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val dokterLD=MutableLiveData<Dokter>()

    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun refresh() {
        launch {
            val db = buildDbDokter(getApplication())
            doktersLD.value=db.dokterDao().selectAllDokter()
        }
        doktersLoadErrorLD.value = false
        loadingLD.value = false
    }

    fun getOneDokter(id:Int){
        launch {
            val db= buildDbDokter(getApplication())
            dokterLD.value=db.dokterDao().selectDokter(id)
        }
    }

    fun insertDokter(dok:Dokter){
        launch {
            val db= buildDbDokter(getApplication())
            db.dokterDao().insertDokter(dok)
            val id=db.dokterDao().selectLastID()
            db.dokterDao().updateGBR("https://i.pravatar.cc/300?img=$id",id)
        }
    }
}