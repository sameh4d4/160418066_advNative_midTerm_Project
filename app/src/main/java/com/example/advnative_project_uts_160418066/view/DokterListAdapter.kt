package com.example.advnative_project_uts_160418066.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.model.Dokter
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
//        holder.view.btnNamaDokterCard.setText(dokterList[position].nama)
//        holder.view.btnSpesialisasiDokterCard.setText(dokterList[position].spesialisasi)
//        holder.view.cardDokterList.setOnClickListener {
//            Toast.makeText(context, "asd", Toast.LENGTH_SHORT).show()
//        }
        with(holder.view){
            btnNamaDokterCard.setText(dokterList[position].nama)
            btnSpesialisasiDokterCard.setText(dokterList[position].spesialisasi)
            cardDokterList.setOnClickListener {
                Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return dokterList.size
    }
}