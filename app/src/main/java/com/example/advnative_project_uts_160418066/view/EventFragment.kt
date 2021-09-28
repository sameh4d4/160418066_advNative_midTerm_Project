package com.example.advnative_project_uts_160418066.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.advnative_project_uts_160418066.R
import kotlinx.android.synthetic.main.fragment_event.*

class EventFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnChekKodeEvent.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Cek Kode")
            if(txtInputKode.text.toString()=="001"){
                builder.setMessage("Kode benar")
            }
            else{
                builder.setMessage("Kode salah")
            }
            builder.setPositiveButton(android.R.string.ok) { dialog, which ->
                Toast.makeText(context,
                    android.R.string.yes, Toast.LENGTH_SHORT).show()
            }
            builder.show()
        }

    }
}