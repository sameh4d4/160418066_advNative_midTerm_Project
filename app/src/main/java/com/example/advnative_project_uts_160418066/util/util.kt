package com.example.advnative_project_uts_160418066.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.room.Room
import com.example.advnative_project_uts_160418066.R
import com.example.advnative_project_uts_160418066.model.DepartementDatabase
import com.example.advnative_project_uts_160418066.model.DokterDatabase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String?, progressBar: ProgressBar) {
    Picasso.get().load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object: Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }
            override fun onError(e: Exception?) {
            }
        })
}

val DB_NAME_DEPARTEMEN = "newdepartementdb"
fun buildDbDepart(context: Context):DepartementDatabase {
    val db = Room.databaseBuilder(context,
        DepartementDatabase::class.java, DB_NAME_DEPARTEMEN)
        .addMigrations()
        .build()
    return db
}

val DB_NAME_DOKTER = "newdokterdb"
fun buildDbDokter(context: Context):DokterDatabase {
    val db = Room.databaseBuilder(context,
        DokterDatabase::class.java, DB_NAME_DOKTER)
        .addMigrations()
        .build()
    return db
}

@BindingAdapter("android:imageUrl","android:progressBar")
fun loadPhotoURL(view:ImageView,url:String?,pb:ProgressBar){
    view.loadImage(url,pb)
}