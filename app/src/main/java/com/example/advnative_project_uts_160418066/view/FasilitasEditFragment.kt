package com.example.advnative_project_uts_160418066.view

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.databinding.FragmentFasilitasEditBinding
import com.example.advnative_project_uts_160418066.model.Fasilitas
import com.example.advnative_project_uts_160418066.viewmodel.DetilFasilitasListViewModel
import java.io.IOException
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.navigation.Navigation


class FasilitasEditFragment : Fragment(), FasilitasEditBtnImageClickListener,
    FasilitasSaveChangeClickListener, FasilitasDeleteClickListener {
    private lateinit var modelView:DetilFasilitasListViewModel
    private lateinit var dataBinding:FragmentFasilitasEditBinding
    val REQUEST_IMAGE_GALERY = 999
    private var imageData: ByteArray? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_fasilitas_edit, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        modelView=ViewModelProvider(this).get(DetilFasilitasListViewModel::class.java)
        val uuid=FasilitasEditFragmentArgs.fromBundle(requireArguments()).id
        modelView.getOneFasilitas(uuid)
        dataBinding.btnPilihImageListener=this
        dataBinding.btnUpdateFasilitasListener=this
        dataBinding.btnDeleteFasilitasListener=this
        observe()
    }

    fun observe(){
        modelView.facilityLD.observe(viewLifecycleOwner, Observer {
            dataBinding.fasilitas=it
        })
    }

    override fun onFasilitasEditBtnImageClickListener(v: View) {
        Toast.makeText(context,"ok button",Toast.LENGTH_SHORT)
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
                dataBinding.imgPreviewEditFasilitas.setImageURI(uri)
                uriToByteArray(uri)
            }
        }
    }

    private fun imgToString(): Any {
        var hasil= Base64.encodeToString(imageData, Base64.DEFAULT)
        return hasil
    }

    override fun onFasilitasSaveChangeClickListener(v: View, obj: Fasilitas) {
        modelView.uploadImage(imgToString() as String,obj.id.toString())
        modelView.updateFasilitas(obj)
        Toast.makeText(v.context,"Data fasilitas terupdate",Toast.LENGTH_SHORT)
        Navigation.findNavController(v).popBackStack()
    }

    override fun onFasilitasDeleteClickListener(v: View, id: String) {
        modelView.deleteFasilitas(id)
        Toast.makeText(v.context,"Data fasilitas terhapus",Toast.LENGTH_SHORT)
        Navigation.findNavController(v).popBackStack()
    }
}