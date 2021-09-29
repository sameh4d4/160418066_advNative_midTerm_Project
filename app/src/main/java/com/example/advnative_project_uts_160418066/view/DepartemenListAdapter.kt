package com.example.advnative_project_uts_160418066.view

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.model.Departemen
import kotlinx.android.synthetic.main.departemen_list_item.view.*
import kotlinx.android.synthetic.main.fragment_event.*

class DepartemenListAdapter(val departemenList:ArrayList<Departemen>):RecyclerView.Adapter<DepartemenListAdapter.DepartemenListViewHolder>() {
    class DepartemenListViewHolder(val view:View):RecyclerView.ViewHolder(view)

    fun updateDepartementList(newDepartList: List<Departemen>){
        departemenList.clear()
        departemenList.addAll(newDepartList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartemenListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.departemen_list_item, parent, false)
        return DepartemenListAdapter.DepartemenListViewHolder(view)
    }

    override fun onBindViewHolder(holder: DepartemenListViewHolder, position: Int) {
        holder.view.txtNamaItemListDepartemen.setText(departemenList[position].nama)
        holder.view.cardItemListDepartement.setOnClickListener {
            val builder = AlertDialog.Builder(holder.view.context)
            builder.setTitle("Cek Kode")
            builder.setMessage("Janji telah dibuat!")
            builder.setPositiveButton(android.R.string.ok) { dialog, which ->
                val action=KonsultasiBuatPilihJenisListFragmentDirections.actionItemKonsultasiFromBuatPilihJenis()
                Navigation.findNavController(it).navigate(action)
            }
            builder.show()
        }
    }

    override fun getItemCount(): Int {
        return departemenList.size
    }
}