package com.example.advnative_project_uts_160418066.view

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.databinding.FragmentFasilitasEditBinding
import com.example.advnative_project_uts_160418066.databinding.FragmentTambahFasilitasBinding
import com.example.advnative_project_uts_160418066.model.Fasilitas
import com.example.advnative_project_uts_160418066.viewmodel.DetilFasilitasListViewModel
import kotlinx.android.synthetic.main.fragment_tambah_departemen.*
import kotlinx.android.synthetic.main.fragment_tambah_fasilitas.*
import java.io.IOException

class TambahFasilitasFragment : Fragment(), FasilitasTambahClickListener,
    FasilitasEditBtnImageClickListener {
    private lateinit var modelView: DetilFasilitasListViewModel
    private lateinit var dataBinding: FragmentTambahFasilitasBinding
    val REQUEST_IMAGE_GALERY = 999
    private var imageData: ByteArray? = null
    var jenis=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_tambah_fasilitas, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        modelView= ViewModelProvider(this).get(DetilFasilitasListViewModel::class.java)
        jenis=TambahFasilitasFragmentArgs.fromBundle(requireArguments()).jenis
        dataBinding.btnPilihImageListener=this
        dataBinding.btnSimpanListener=this
    }

    override fun onFasilitasTambahClickListener(v: View) {
        var obj=Fasilitas("",txtTambahFasilitas.text.toString(),"",jenis)
        modelView.insertFasilitas(obj,imgToString() as String)
        Toast.makeText(v.context,"Data fasilitas ditambahkan",Toast.LENGTH_SHORT)
        Navigation.findNavController(v).popBackStack()
    }

    override fun onFasilitasEditBtnImageClickListener(v: View) {
        Toast.makeText(context,"ok button", Toast.LENGTH_SHORT)
        val i = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        startActivityForResult(i, REQUEST_IMAGE_GALERY)
    }

    @Throws(IOException::class)
    private fun uriToByteArray(uri: Uri) {
        val inputStream = activity?.contentResolver?.openInputStream(uri)
        inputStream?.buffered()?.use {
            imageData = it.readBytes()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_IMAGE_GALERY) {
            val uri = data?.data
            if (uri != null) {
                dataBinding.imgPreviewTambahFasilitas.setImageURI(uri)
                uriToByteArray(uri)
            }
        }
    }

    private fun imgToString(): Any {
        var hasil= Base64.encodeToString(imageData, Base64.DEFAULT)
        return hasil
    }
}