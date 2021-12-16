package com.example.advnative_project_uts_160418066.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var  viewModel:UserViewModel
    private val sharedFile="com.example.advnative_project_uts_160418066"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        btnLogin.setOnClickListener {
            val username=txtEmailLogin.text.toString()
            val password=txtPassLogin.text.toString()
            viewModel.login(username,password)
            observe()
        }
    }
    fun observe(){
        viewModel.adaDataLD.observe(this, Observer {
            if(it==true){
                val shared: SharedPreferences =getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = shared.edit()
                editor.putString("user_username", txtEmailLogin.text.toString())
                editor.putString("user_password", txtPassLogin.text.toString())
                editor.apply()
                val intent= Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }
}