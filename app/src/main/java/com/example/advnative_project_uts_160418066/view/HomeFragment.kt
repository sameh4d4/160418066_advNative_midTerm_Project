package com.example.advnative_project_uts_160418066.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.advnative_project_uts_160418066.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnFasilitas.setOnClickListener {
            val action=HomeFragmentDirections.actionDaftarFasilitasFragment()
            Navigation.findNavController(it).navigate(action)
        }
        btnEvent.setOnClickListener {
            val action=HomeFragmentDirections.actionEventFragment()
            Navigation.findNavController(it).navigate(action)
        }
        btnKonsultasi.setOnClickListener {
            val action=HomeFragmentDirections.actionKonsultasiFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}