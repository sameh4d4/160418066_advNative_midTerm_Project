package com.example.advnative_project_uts_160418066.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.viewmodel.DokterListViewModel
import com.example.advnative_project_uts_160418066.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    private lateinit var viewModel:UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.getUser()
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.userLD.observe(viewLifecycleOwner, Observer {
            with(it){
                txtTeleponProfile.setText(noHp)
                txtEmailProfile.setText(email)
                txtMRNProfile.setText(mrn)
                txtNamaProfile.setText(name)
                txtTglLahirProfile.setText(tglLahir)
            }
        })
    }
}