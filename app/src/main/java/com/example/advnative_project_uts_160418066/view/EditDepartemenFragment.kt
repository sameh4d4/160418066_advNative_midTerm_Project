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
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.databinding.FragmentEditDepartemenBinding
import com.example.advnative_project_uts_160418066.model.Departemen
import com.example.advnative_project_uts_160418066.viewmodel.DepartementViewModel

class EditDepartemenFragment : Fragment(),DepartemenSaveChangeClick {
    private lateinit var viewModel: DepartementViewModel
    private lateinit var dataBinding: FragmentEditDepartemenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_edit_departemen, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this).get(DepartementViewModel::class.java)
        val uuid=EditDepartemenFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.getDepartement(uuid)
        observe()
        dataBinding.saveChangeListener=this
    }
    fun observe(){
        viewModel.departemenLD.observe(viewLifecycleOwner, Observer {
            dataBinding.departement=it
        })
    }

    override fun onDepartemenSaveChangeClick(v: View, obj: Departemen) {
        viewModel.updateDepartement(obj)
        Toast.makeText(v.context,"Data Departemen terupdate",Toast.LENGTH_SHORT)
        Navigation.findNavController(v).popBackStack()
    }
}