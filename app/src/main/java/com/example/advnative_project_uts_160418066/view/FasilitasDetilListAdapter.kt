package com.example.advnative_project_uts_160418066.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.databinding.FasilitasListItemBinding
import com.example.advnative_project_uts_160418066.model.Fasilitas
import com.example.advnative_project_uts_160418066.util.loadImage
import kotlinx.android.synthetic.main.fasilitas_list_item.view.*

class FasilitasDetilListAdapter(val fasilitasList:ArrayList<Fasilitas>):RecyclerView.Adapter<FasilitasDetilListAdapter.FasilitasDetilViewHolder>(),
    FasilitasCardClickListener {
    class FasilitasDetilViewHolder(var view:FasilitasListItemBinding):RecyclerView.ViewHolder(view.root)

    fun updateFasilitasList(newFasilitasList: List<Fasilitas>) {
        fasilitasList.clear()
        fasilitasList.addAll(newFasilitasList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FasilitasDetilViewHolder {
        val inflater=LayoutInflater.from(parent.context)
//        val view=inflater.inflate(R.layout.fasilitas_list_item,parent,false)
        val view =DataBindingUtil.inflate<FasilitasListItemBinding>(inflater,R.layout.fasilitas_list_item,parent,false)
        return FasilitasDetilViewHolder(view)
    }

    override fun onBindViewHolder(holder: FasilitasDetilViewHolder, position: Int) {
        holder.view.fasilitas=fasilitasList[position]
        holder.view.fasilitasCardClickListener=this
    }

    override fun getItemCount(): Int {
        return fasilitasList.size
    }

    override fun onFasilitasCardClickListener(v: View) {
        val uuid = v.tag.toString().toInt()
        if (MainActivity.user.jabatan == 1) {
            val act = DaftarFasilitasDetilListFragmentDirections.actionEditFasilitas(uuid)
            Navigation.findNavController(v).navigate(act)
        }
    }
}