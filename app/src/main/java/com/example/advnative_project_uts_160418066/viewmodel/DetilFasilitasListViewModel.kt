package com.example.advnative_project_uts_160418066.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.advnative_project_uts_160418066.model.Fasilitas
import com.example.advnative_project_uts_160418066.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetilFasilitasListViewModel(application: Application): AndroidViewModel(application) {
    val facilitiesLD = MutableLiveData<List<Fasilitas>>()
    val facilitiesLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val facilityLD=MutableLiveData<Fasilitas>()

    val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun deleteFasilitas(id: String){
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://ubaya.fun/flutter/160418066/API/AdvNa_uas/deleteFasilitas.php"
        val stringRequest = object: StringRequest(
            Method.POST, url,
            { response ->
                Log.d("Status","berhasil")
            },
            {
                Log.d("status", "gagal")
            }
        ){
            override fun getParams(): MutableMap<String, String> {
                val param= HashMap<String,String>()
                param["id"] = id
                return param
            }
        }
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    fun insertFasilitas(obj:Fasilitas,img:String){
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://ubaya.fun/flutter/160418066/API/AdvNa_uas/insertFasilitas.php"
        val stringRequest = object: StringRequest(
            Method.POST, url,
            { response ->
                Log.d("Status","berhasil")
            },
            {
                Log.d("status", "gagal")
            }
        ){
            override fun getParams(): MutableMap<String, String> {
                val param= HashMap<String,String>()
                param["nama"] = obj.nama.toString()
                param["jenis"] = obj.jenis.toString()
                param["image"]= img
                return param
            }
        }
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    fun updateFasilitas(obj:Fasilitas){
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://ubaya.fun/flutter/160418066/API/AdvNa_uas/editFasilitas.php"
        val stringRequest = object: StringRequest(
            Method.POST, url,
            { response ->
                Log.d("Status","berhasil")
            },
            {
                Log.d("status", "gagal")
            }
        ){
            override fun getParams(): MutableMap<String, String> {
                val param= HashMap<String,String>()
                param["id"] = obj.id.toString()
                param["nama"] = obj.nama.toString()
                return param
            }
        }
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    fun uploadImage(img:String,id:String) {
        val url = "https://ubaya.fun/flutter/160418066/API/AdvNa_uas/uploadImage.php"
        queue = Volley.newRequestQueue(getApplication())
        val stringRequest = object: StringRequest(
            Method.POST, url,
            { response ->
                Log.d("status",response.toString())
            },
            {
                Log.d("status", it.message.toString())
            }
        ){
            override fun getParams(): MutableMap<String, String> {
                val param= HashMap<String,String>()
                param["id"] = id
                param["image"]= img
                return param
            }
        }
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    fun getOneFasilitas(id:Int){
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://ubaya.fun/flutter/160418066/API/AdvNa_uas/getOneFacility.php"
        val stringRequest = object: StringRequest(
            Method.POST, url,
            { response ->
                val sType = object : TypeToken<Fasilitas>() { }.type
                val result = Gson().fromJson<Fasilitas>(response, sType)
                facilityLD.value = result
            },
            {
                Log.d("status", "gagal")
            }
        ){
            override fun getParams(): MutableMap<String, String> {
                val param= HashMap<String,String>()
                param["id"] = id.toString()
                return param
            }
        }
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    fun fasilitasGet(jenis:String){
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://ubaya.fun/flutter/160418066/API/AdvNa_uas/getFasilitas.php"
        val stringRequest = object: StringRequest(
            Method.POST, url,
            { response ->
                val sType = object : TypeToken<List<Fasilitas>>() { }.type
                val result = Gson().fromJson<List<Fasilitas>>(response, sType)
                facilitiesLD.value = result
                facilitiesLoadErrorLD.value = false
                loadingLD.value = false
            },
            {
                Log.d("status", "gagal")
            }
        ){
            override fun getParams(): MutableMap<String, String> {
                val param= HashMap<String,String>()
                param["jenis"] = jenis
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