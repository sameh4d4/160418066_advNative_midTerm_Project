package com.example.advnative_project_uts_160418066.view

import android.view.View
import com.example.advnative_project_uts_160418066.model.Departemen

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
    fun onFasilitasSaveChangeClickListener(v:View)
}
interface FasilitasDeleteClickListener{
    fun onFasilitasDeleteClickListener(v:View)
}
//endregion