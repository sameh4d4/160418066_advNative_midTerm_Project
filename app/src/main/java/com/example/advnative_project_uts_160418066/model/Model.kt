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