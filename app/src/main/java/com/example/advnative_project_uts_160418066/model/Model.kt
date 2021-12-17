package com.example.advnative_project_uts_160418066.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.util.*
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class User(
    var id:String?,
    val username:String?,
    val password:String?,
    val nama:String?,
    val jabatan:Int?,
    @SerializedName("no_hp")
    val noHp:String?,
    val email:String?,
    val mrn:String?,
    @SerializedName("tgl_lahir")
    val tglLahir:String?,
)

@Entity
data class Dokter(
    @ColumnInfo(name = "nama")
    val nama:String,
    @ColumnInfo(name = "spesialisasi")
    val spesialisasi:String,
    @ColumnInfo(name = "nohp")
    val noHp:String,
    @ColumnInfo(name = "email")
    val email:String,
    @ColumnInfo(name = "alamat")
    val alamat:String,
    @ColumnInfo(name = "gambar")
    val gambar: String,
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int=0
}

data class Fasilitas(
    val id:String?,
    var nama:String?,
    @SerializedName("gambar_link")
    var gambar:String?,
    val jenis:String?,
)

@Entity
data class Departemen(
    @ColumnInfo(name = "nama")
    var nama:String,
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int=0
}