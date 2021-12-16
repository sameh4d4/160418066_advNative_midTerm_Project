package com.example.advnative_project_uts_160418066.view

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.advnative_project_uts_160418066.R
import kotlinx.android.synthetic.main.fragment_event.*
import org.json.JSONObject

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
            var pesan=""
            val q = Volley.newRequestQueue(activity)
            val kode=txtInputKode.text.toString()
            val url = "https://ubaya.fun/flutter/160418066/API/AdvNa_uas/cekKode.php?kode=$kode"
            var stringRequest = StringRequest(
                Request.Method.GET, url,
                {
                    val obj = JSONObject(it)
                    if(obj.getString("result")=="ok") {
                        pesan=obj.getString("data")
                        Log.d("pesan",kode)
                        val builder = AlertDialog.Builder(context)
                        builder.setTitle("Cek Kode")
                        builder.setMessage("Kode $pesan")
                        builder.setPositiveButton(android.R.string.ok) { dialog, which ->
                        }
                        builder.show()
                    }
                },
                {
                    Log.e("Error", it.toString())
                }
            )
            q.add(stringRequest)


        }

    }
}