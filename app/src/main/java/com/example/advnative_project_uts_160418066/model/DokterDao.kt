package com.example.advnative_project_uts_160418066.model

import androidx.room.*

@Dao
interface DokterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDokter(vararg dok:Dokter)

    @Query("SELECT * FROM Dokter")
    suspend fun selectAllDokter(): List<Dokter>

    @Query("SELECT uuid from Dokter order by uuid desc limit 1")
    suspend fun selectLastID():Int

    @Query("UPDATE Dokter set gambar=:gambar where uuid=:id")
    suspend fun updateGBR(gambar: String,id: Int)

    @Query("SELECT * FROM Dokter WHERE uuid= :id")
    suspend fun selectDokter(id:Int): Dokter

    @Query("UPDATE Dokter SET nama=:nama, spesialisasi=:spes,nohp=:nohp,email=:email,alamat=:alamat,gambar=:gambar WHERE uuid = :id")
    suspend fun update(nama: String,spes:String,nohp:String,email:String,alamat:String,gambar:String, id: Int)

    @Delete
    suspend fun deleteDepartement(dok:Dokter)
}