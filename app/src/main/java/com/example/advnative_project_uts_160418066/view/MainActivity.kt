package com.example.advnative_project_uts_160418066.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.model.User
import com.example.advnative_project_uts_160418066.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        var user= User("","","","",1,"","","","")
    }
    private lateinit var navController: NavController
    private lateinit var  viewModel:UserViewModel
    val sharedFile="com.example.advnative_project_uts_160418066"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shared: SharedPreferences =getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
        val username= shared.getString("user_username","").toString()
        val password= shared.getString("user_password","").toString()
        if(username==""&&password==""){
            val intent= Intent(applicationContext,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        else{
            viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
            viewModel.login(username, password)
            observe()
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(navView, navController)

        bottomNav.setupWithNavController(navController)
    }

    fun observe(){
        viewModel.userLD.observe(this, Observer {
            user=it
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,drawerLayout)||super.onSupportNavigateUp()
    }
}