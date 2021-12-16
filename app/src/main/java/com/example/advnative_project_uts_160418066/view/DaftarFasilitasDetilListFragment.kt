package com.example.advnative_project_uts_160418066.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.viewmodel.DetilFasilitasListViewModel
import kotlinx.android.synthetic.main.fragment_daftar_fasilitas_detil_list.*

class DaftarFasilitasDetilListFragment : Fragment() {
    private lateinit var viewModel: DetilFasilitasListViewModel
    private val fasilitasDetilListAdapter = FasilitasDetilListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daftar_fasilitas_detil_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val jenis=DaftarFasilitasDetilListFragmentArgs.fromBundle(requireArguments()).jenisFasilitas
        viewModel = ViewModelProvider(this).get(DetilFasilitasListViewModel::class.java)
        viewModel.fasilitasGet(jenis)
        recViewFasilitasDetilList.layoutManager = LinearLayoutManager(context)
        recViewFasilitasDetilList.adapter = fasilitasDetilListAdapter
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.facilitiesLD.observe(viewLifecycleOwner, Observer {
            fasilitasDetilListAdapter.updateFasilitasList(it)

        })

        viewModel.facilitiesLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtErrorFasilitasDetilList.visibility = View.VISIBLE
            } else {
                txtErrorFasilitasDetilList.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recViewFasilitasDetilList.visibility = View.GONE
                progressLoadFasilitasDetilList.visibility = View.VISIBLE
            } else {
                recViewFasilitasDetilList.visibility = View.VISIBLE
                progressLoadFasilitasDetilList.visibility = View.GONE
            }
        })
    }
}