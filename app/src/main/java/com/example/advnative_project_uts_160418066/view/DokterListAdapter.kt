package com.example.advnative_project_uts_160418066.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.model.Dokter
import com.example.advnative_project_uts_160418066.util.loadImage
import kotlinx.android.synthetic.main.dokter_list_item.view.*

class DokterListAdapter(val dokterList:ArrayList<Dokter>):RecyclerView.Adapter<DokterListAdapter.DokterViewHolder>() {
    class DokterViewHolder(var view:View):RecyclerView.ViewHolder(view)

    fun updateDoktertList(newDokterList: List<Dokter>) {
        dokterList.clear()
        dokterList.addAll(newDokterList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DokterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.dokter_list_item, parent, false)
        return DokterViewHolder(view)
    }

    override fun onBindViewHolder(holder: DokterViewHolder, position: Int) {
        with(holder.view){
            btnNamaDokterCard.setText(dokterList[position].nama)
            btnSpesialisasiDokterCard.setText(dokterList[position].spesialisasi)
            imgDokterListItem.loadImage(dokterList[position].gambar.toString(),progressBarItemListDok)
            cardDokterList.setOnClickListener {
                val action=DaftarDokterFragmentDirections.actionDetilDokter(position)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return dokterList.size
    }
}