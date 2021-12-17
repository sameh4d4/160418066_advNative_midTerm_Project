package com.example.advnative_project_uts_160418066.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.databinding.DokterListItemBinding
import com.example.advnative_project_uts_160418066.model.Dokter
import com.example.advnative_project_uts_160418066.util.loadImage
import kotlinx.android.synthetic.main.dokter_list_item.view.*

class DokterListAdapter(val dokterList:ArrayList<Dokter>):RecyclerView.Adapter<DokterListAdapter.DokterViewHolder>(),
    DokterItemCardClickListener {
    class DokterViewHolder(var view:DokterListItemBinding):RecyclerView.ViewHolder(view.root)

    fun updateDoktertList(newDokterList: List<Dokter>) {
        dokterList.clear()
        dokterList.addAll(newDokterList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DokterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<DokterListItemBinding>(inflater,R.layout.dokter_list_item, parent, false)
        return DokterViewHolder(view)
    }

    override fun onBindViewHolder(holder: DokterViewHolder, position: Int) {
        holder.view.dokter=dokterList[position]
        holder.view.cardClickListener=this
    }

    override fun getItemCount(): Int {
        return dokterList.size
    }

    override fun onDokterItemCardClickListener(v: View,id:Int) {
        val action=DaftarDokterFragmentDirections.actionDetilDokter(id)
        Navigation.findNavController(v).navigate(action)
    }
}