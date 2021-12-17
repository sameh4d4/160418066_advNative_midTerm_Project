package com.example.advnative_project_uts_160418066.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.advnative_project_uts_160418066.model.Departemen
import com.example.advnative_project_uts_160418066.util.buildDbDepart
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DepartementListViewModel(application: Application):AndroidViewModel(application), CoroutineScope {
    val DepartementsLD = MutableLiveData<List<Departemen>>()
    val DepartementsLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun refresh() {
        loadingLD.value = false
        DepartementsLoadErrorLD.value = false
        launch {
            val db = buildDbDepart(getApplication())
            DepartementsLD.value = db.departemenDao().selectAllDepartement()
        }
    }
}