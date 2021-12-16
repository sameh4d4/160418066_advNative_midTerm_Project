package com.example.advnative_project_uts_160418066.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.advnative_project_uts_160418066.model.Departemen
import com.example.advnative_project_uts_160418066.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DepartementViewModel (application: Application): AndroidViewModel(application),
    CoroutineScope {
    private val job = Job()
    val todoLD = MutableLiveData<Departemen>()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun addDepartement(list:List<Departemen>) {
        launch {
            val db = buildDb(getApplication())
            db.departemenDao().insertAll(*list.toTypedArray())
        }
    }
}