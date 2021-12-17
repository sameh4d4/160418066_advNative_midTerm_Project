package com.example.advnative_project_uts_160418066.view

import android.view.View
import com.example.advnative_project_uts_160418066.model.Departemen
import com.example.advnative_project_uts_160418066.model.Fasilitas

//region department
interface DepartemenCardClickListener{
    fun onCardDepartemenClickListener(v:View)
}
interface DepartemenEditClick{
    fun onDepartemenEditClickListener(v:View)
}
interface DepartemenSaveChangeClick{
    fun onDepartemenSaveChangeClick(v:View, obj:Departemen)
}
//endregion

//region fasilitas
interface FasilitasCardClickListener{
    fun onFasilitasCardClickListener(v:View)
}
interface FasilitasTambahClickListener{
    fun onFasilitasTambahClickListener(v:View)
}
interface FasilitasSaveChangeClickListener{
    fun onFasilitasSaveChangeClickListener(v:View,obj:Fasilitas)
}
interface FasilitasDeleteClickListener{
    fun onFasilitasDeleteClickListener(v:View,id:String)
}
interface FasilitasEditBtnImageClickListener{
    fun onFasilitasEditBtnImageClickListener(v:View)
}
interface FasilitasFABTambahClickListener{
    fun onFasilitasFABTambahClickListener(v:View)
}
//endregion

//region dokter
interface DokterFABTambahClickListener{
    fun onDokterFABTambahClickListener(v:View)
}
interface DokterBtnTambahBaruListener{
    fun onDokterBtnTambahBaruListener(v:View)
}
interface DokterItemCardClickListener{
    fun onDokterItemCardClickListener(v:View,id:Int)
}
//endregion