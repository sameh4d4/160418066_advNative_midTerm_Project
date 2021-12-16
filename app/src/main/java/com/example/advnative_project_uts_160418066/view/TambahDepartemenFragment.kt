package com.example.advnative_project_uts_160418066.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.model.Departemen
import com.example.advnative_project_uts_160418066.viewmodel.DepartementViewModel
import kotlinx.android.synthetic.main.fragment_tambah_departemen.*

class TambahDepartemenFragment : Fragment() {
    private lateinit var viewModel:DepartementViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tambah_departemen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this).get(DepartementViewModel::class.java)
        btnTambahDepartemen.setOnClickListener {
            var depart=Departemen(txtNamaTambahDepartemen.text.toString())
            val list= listOf<Departemen>(depart)
            viewModel.addDepartement(list)
            Toast.makeText(view.context, "Data departemen ditambahkan", Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()
        }
    }
}