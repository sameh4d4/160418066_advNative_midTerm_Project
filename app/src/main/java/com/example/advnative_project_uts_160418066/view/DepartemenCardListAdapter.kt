package com.example.advnative_project_uts_160418066.view

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.databinding.DepartemenListItemBinding
import com.example.advnative_project_uts_160418066.model.Departemen

class DepartemenCardListAdapter(val departemenList:ArrayList<Departemen>):RecyclerView.Adapter<DepartemenCardListAdapter.DepartemenListViewHolder>(),
    DepartemenCardClickListener,
    DepartemenEditClick
{
    class DepartemenListViewHolder(val view:DepartemenListItemBinding):RecyclerView.ViewHolder(view.root)

    fun updateDepartementList(newDepartList: List<Departemen>){
        departemenList.clear()
        departemenList.addAll(newDepartList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartemenListViewHolder {

        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.departemen_list_item, parent, false)
        val view = DataBindingUtil.inflate<DepartemenListItemBinding>(inflater,R.layout.departemen_list_item,parent,false)
        return DepartemenListViewHolder(view)
    }

    override fun onBindViewHolder(holder: DepartemenListViewHolder, position: Int) {
        holder.view.departemen=departemenList[position]
        holder.view.listenerCardOnClick=this
        holder.view.listenerEditDepartOnClick=this
        if(MainActivity.user.jabatan==2) holder.view.imgEditDepartement.visibility=View.GONE
        else holder.view.imgEditDepartement.visibility=View.VISIBLE
    }

    override fun getItemCount(): Int {
        return departemenList.size
    }

    override fun onCardDepartemenClickListener(v: View) {
        val builder = AlertDialog.Builder(v.context)
        builder.setTitle("Konsultasi")
        builder.setMessage("Janji telah dibuat!")
        builder.setPositiveButton(android.R.string.ok) { dialog, which ->
            val action=KonsultasiBuatPilihJenisListFragmentDirections.actionItemKonsultasiFromBuatPilihJenis()
            Navigation.findNavController(v).navigate(action)
        }
        builder.show()
    }

    override fun onDepartemenEditClickListener(v: View) {
        val uuid=v.tag.toString().toInt()
        val action=KonsultasiBuatPilihJenisListFragmentDirections.actionEditDepartement(uuid)
        Navigation.findNavController(v).navigate(action)
    }
}