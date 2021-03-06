package com.example.advnative_project_uts_160418066.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.advnative_project_uts_160418066.R
import kotlinx.android.synthetic.main.fragment_daftar_fasilitas.*

class DaftarFasilitasFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daftar_fasilitas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnFasUmum.setOnClickListener {
            val action=DaftarFasilitasFragmentDirections.actionDaftarFasilitasDetilFragment("umum")
            Navigation.findNavController(it).navigate(action)
        }
        btnFasDiagnosa.setOnClickListener {
            val action=DaftarFasilitasFragmentDirections.actionDaftarFasilitasDetilFragment("diagnosa")
            Navigation.findNavController(it).navigate(action)
        }
        btnFasSpesialis.setOnClickListener {
            val action=DaftarFasilitasFragmentDirections.actionDaftarFasilitasDetilFragment("spesialis")
            Navigation.findNavController(it).navigate(action)
        }
    }
}