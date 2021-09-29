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
import com.example.advnative_project_uts_160418066.viewmodel.DepartementListViewModel
import kotlinx.android.synthetic.main.fragment_konsultasi_buat_pilih_jenis_list.*

class KonsultasiBuatPilihJenisListFragment : Fragment() {
    private lateinit var viewModel:DepartementListViewModel
    private val departemenListAdapter= DepartemenListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_konsultasi_buat_pilih_jenis_list,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DepartementListViewModel::class.java)
        viewModel.refresh()
        recViewDepartemenList.layoutManager = LinearLayoutManager(context)
        recViewDepartemenList.adapter = departemenListAdapter
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.DepartementsLD.observe(viewLifecycleOwner, Observer {
            departemenListAdapter.updateDepartementList(it)
        })

        viewModel.DepartementsLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtErrorDepartemenList.visibility = View.VISIBLE
            } else {
                txtErrorDepartemenList.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recViewDepartemenList.visibility = View.GONE
                progressLoadDepartemenList.visibility = View.VISIBLE
            } else {
                recViewDepartemenList.visibility = View.VISIBLE
                progressLoadDepartemenList.visibility = View.GONE
            }
        })
    }
}