package com.example.advnative_project_uts_160418066.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.model.Fasilitas
import com.example.advnative_project_uts_160418066.util.loadImage
import kotlinx.android.synthetic.main.fasilitas_list_item.view.*

class FasilitasDetilListAdapter(val fasilitasList:ArrayList<Fasilitas>):RecyclerView.Adapter<FasilitasDetilListAdapter.FasilitasDetilViewHolder>() {
    class FasilitasDetilViewHolder(var view:View):RecyclerView.ViewHolder(view)

    fun updateFasilitasList(newFasilitasList: List<Fasilitas>) {
        fasilitasList.clear()
        fasilitasList.addAll(newFasilitasList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FasilitasDetilViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.fasilitas_list_item,parent,false)
        return FasilitasDetilViewHolder(view)
    }

    override fun onBindViewHolder(holder: FasilitasDetilViewHolder, position: Int) {
        with(holder.view){
            imgItemListDetilFasilitas.loadImage(fasilitasList[position].gambar,progressBarItemListDetilFasilitas)
            txtNamaItemListDetilFasilitas.setText(fasilitasList[position].nama)
        }
    }

    override fun getItemCount(): Int {
        return fasilitasList.size
    }
}