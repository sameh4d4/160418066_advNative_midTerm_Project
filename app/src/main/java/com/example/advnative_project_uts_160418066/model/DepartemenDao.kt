package com.example.advnative_project_uts_160418066.model

import androidx.room.*

@Dao
interface DepartemenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg depart:Departemen)

    @Query("SELECT * FROM Departemen")
    suspend fun selectAllDepartement(): List<Departemen>

    @Query("SELECT * FROM Departemen WHERE uuid= :id")
    suspend fun selectDepartement(id:Int): Departemen

    @Query("UPDATE Departemen SET nama=:nama WHERE uuid = :id")
    suspend fun update(nama: String, id: Int)

    @Delete
    suspend fun deleteDepartement(todo:Departemen)

}