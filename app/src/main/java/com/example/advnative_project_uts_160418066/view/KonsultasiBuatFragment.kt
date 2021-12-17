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
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.databinding.FragmentKonsultasiBuatBinding
import com.example.advnative_project_uts_160418066.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_konsultasi_buat.*

class KonsultasiBuatFragment : Fragment() {
    private lateinit var viewModel: UserViewModel
    private lateinit var dataBinding:FragmentKonsultasiBuatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_konsultasi_buat, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnKonsultasiBuatKembali.setOnClickListener {
            val action=KonsultasiBuatFragmentDirections.actionKonsultasiFragmentFromBuat()
            Navigation.findNavController(it).navigate(action)
        }
        btnKonsultasiBuatLanjutkan.setOnClickListener {
            val action=KonsultasiBuatFragmentDirections.actionKonsultasiBuatPilihJenisFragment()
            Navigation.findNavController(it).navigate(action)
        }
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.getUser(MainActivity.user)
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.userLD.observe(viewLifecycleOwner, Observer {
            dataBinding.user=it
        })
    }
}