package com.example.advnative_project_uts_160418066.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
        viewModel.getUser(MainActivity.user)
        observeViewModel()
        btnLogOutProfile.setOnClickListener {
            val sharedFile="com.example.advnative_project_uts_160418066"
            var shared: SharedPreferences =this.requireActivity().getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = shared.edit()
            editor.putString("user_username", "")
            editor.putString("user_password", "")
            editor.apply()
            var intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }

    fun observeViewModel() {
        viewModel.userLD.observe(viewLifecycleOwner, Observer {
            with(it){
                txtTeleponProfile.setText(noHp)
                txtEmailProfile.setText(email)
                txtMRNProfile.setText(mrn)
                txtNamaProfile.setText(nama)
                txtTglLahirProfile.setText(tglLahir)
            }
        })
    }
}