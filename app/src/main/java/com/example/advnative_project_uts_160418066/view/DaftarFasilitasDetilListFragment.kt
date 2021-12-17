package com.example.advnative_project_uts_160418066.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.databinding.FragmentDaftarFasilitasDetilListBinding
import com.example.advnative_project_uts_160418066.viewmodel.DetilFasilitasListViewModel
import kotlinx.android.synthetic.main.fragment_daftar_fasilitas_detil_list.*

class DaftarFasilitasDetilListFragment : Fragment(), FasilitasFABTambahClickListener {
    private lateinit var viewModel: DetilFasilitasListViewModel
    private val fasilitasDetilListAdapter = FasilitasDetilListAdapter(arrayListOf())
    private lateinit var dataBinding:FragmentDaftarFasilitasDetilListBinding
    var jenis=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_daftar_fasilitas_detil_list, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        jenis=DaftarFasilitasDetilListFragmentArgs.fromBundle(requireArguments()).jenisFasilitas
        viewModel = ViewModelProvider(this).get(DetilFasilitasListViewModel::class.java)
        viewModel.fasilitasGet(jenis)
        dataBinding.fabTambahListener=this
        recViewFasilitasDetilList.layoutManager = LinearLayoutManager(context)
        recViewFasilitasDetilList.adapter = fasilitasDetilListAdapter
        if(MainActivity.user.jabatan==1) fabTambahFasilitas.visibility=View.VISIBLE
        else fabTambahFasilitas.visibility=View.GONE
        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.fasilitasGet(jenis)
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

    override fun onFasilitasFABTambahClickListener(v: View) {
        val action=DaftarFasilitasDetilListFragmentDirections.actionDaftarFasilitasDetilListFragmentToTambahFasilitasFragment(jenis)
        Navigation.findNavController(v).navigate(action)
    }
}