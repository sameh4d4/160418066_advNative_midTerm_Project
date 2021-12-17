package com.example.advnative_project_uts_160418066.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.databinding.FragmentDaftarDokterBinding
import com.example.advnative_project_uts_160418066.viewmodel.DokterListViewModel
import kotlinx.android.synthetic.main.fragment_daftar_dokter.*

class DaftarDokterFragment : Fragment(), DokterFABTambahClickListener {
    private lateinit var viewModel:DokterListViewModel
    private val dokterListAdapter = DokterListAdapter(arrayListOf())
    private lateinit var dataBinding:FragmentDaftarDokterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_daftar_dokter, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DokterListViewModel::class.java)
        viewModel.refresh()
        if(MainActivity.user.jabatan==1) dataBinding.fabTambahDokter.visibility=View.VISIBLE
        else dataBinding.fabTambahDokter.visibility=View.GONE
        dataBinding.fabTambahDokterListener=this
        recViewDokterList.layoutManager = LinearLayoutManager(context)
        recViewDokterList.adapter = dokterListAdapter
        observeViewModel()
        if(MainActivity.user.jabatan==1)fabTambahDokter.visibility=View.VISIBLE
        else fabTambahDokter.visibility=View.GONE
    }

    fun observeViewModel() {
        viewModel.doktersLD.observe(viewLifecycleOwner, Observer {
            dokterListAdapter.updateDoktertList(it)
        })

        viewModel.doktersLoadErrorLD.observe(viewLifecycleOwner, Observer {
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

    override fun onDokterFABTambahClickListener(v: View) {
        if(MainActivity.user.jabatan==1){
            val action=DaftarDokterFragmentDirections.actionTambahDokter()
            Navigation.findNavController(v).navigate(action)
        }
    }
}