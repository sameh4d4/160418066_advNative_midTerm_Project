package com.example.advnative_project_uts_160418066.model

data class User(
    val mrn:String?,
    val name:String?,
    val tglLahir:String?,
    val noHp:String?,
    val email:String?,
)

data class Dokter(
    val id:String?,
    val nama:String?,
    val spesialisasi:String?,
    val noHp:String?,
    val email:String?,
    val alamat:String?,
    val gambar: String?,
)

data class Fasilitas(
    val nama:String?,
    val gambar:String?,
)