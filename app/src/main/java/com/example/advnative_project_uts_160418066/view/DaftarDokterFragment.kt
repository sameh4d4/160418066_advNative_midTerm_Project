package com.example.advnative_project_uts_160418066.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.viewmodel.DokterListViewModel
import kotlinx.android.synthetic.main.fragment_daftar_dokter.*

class DaftarDokterFragment : Fragment() {
    private lateinit var viewModel:DokterListViewModel
    private val dokterListAdapter = DokterListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daftar_dokter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DokterListViewModel::class.java)
        viewModel.refresh()
        recViewDokterList.layoutManager = LinearLayoutManager(context)
        recViewDokterList.adapter = dokterListAdapter
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.doktersLD.observe(viewLifecycleOwner, Observer {
            dokterListAdapter.updateDoktertList(it)
        })

        viewModel.studentLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtErrorDokterList.visibility = View.VISIBLE
            } else {
                txtErrorDokterList.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recViewDokterList.visibility = View.GONE
                progressLoadDokterList.visibility = View.VISIBLE
            } else {
                recViewDokterList.visibility = View.VISIBLE
                progressLoadDokterList.visibility = View.GONE
            }
        })
    }
}