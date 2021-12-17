package com.example.advnative_project_uts_160418066.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.databinding.FragmentTambahDokterBinding
import com.example.advnative_project_uts_160418066.model.Dokter
import com.example.advnative_project_uts_160418066.viewmodel.DokterListViewModel
import kotlinx.android.synthetic.main.fragment_tambah_dokter.*

class TambahDokterFragment : Fragment(), DokterBtnTambahBaruListener {
    private lateinit var dataBinding:FragmentTambahDokterBinding
    private lateinit var modelView:DokterListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_tambah_dokter, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.btnTambahBaruListener=this
        modelView=ViewModelProvider(this).get(DokterListViewModel::class.java)
    }

    override fun onDokterBtnTambahBaruListener(v: View) {
        val dok=Dokter(txtNamaTambahDokter.text.toString(),txtSpesialisasiTambahDokter.text.toString(),txtNoHpTambahDokter.text.toString(),txtEmailTambahDokter.text.toString(),txtAlamatTambahDokter.text.toString(),"")
        modelView.insertDokter(dok)
        Navigation.findNavController(v).popBackStack()
    }
}