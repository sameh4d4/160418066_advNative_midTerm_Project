package com.example.advnative_project_uts_160418066.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.util.loadImage
import com.example.advnative_project_uts_160418066.viewmodel.DokterListViewModel
import kotlinx.android.synthetic.main.fragment_daftar_dokter_detil.*

class DaftarDokterDetilFragment : Fragment() {
    private lateinit var viewModel: DokterListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daftar_dokter_detil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id=DaftarDokterDetilFragmentArgs.fromBundle(requireArguments()).id
        viewModel = ViewModelProvider(this).get(DokterListViewModel::class.java)
        viewModel.getOneDokter(id)
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.dokterLD.observe(viewLifecycleOwner, Observer {
            with(it){
                txtNamaDetilDokter.setText(nama)
                txtNoTelpDetilDokter.setText(noHp)
                txtSpesialisasiDetilDokter.setText(spesialisasi)
                txtEmailDetilDokter.setText(email)
                imgDetilDokter.loadImage(gambar.toString(),progressBarDetilDokter)
            }
        })
    }
}