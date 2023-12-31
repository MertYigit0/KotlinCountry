package com.example.kotlincountry.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlincountry.R


fun ImageView.downnloadFromUrl(url: String?,progressDrawable: CircularProgressDrawable) {


    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.drawable.ic_launcher_background)

    Glide.with(context)
        .load(url)
        .into(this)

}

    fun placeholderProgressBar(context: Context) : CircularProgressDrawable{

        return CircularProgressDrawable(context).apply {
            strokeWidth = 8f
            centerRadius = 40f
            start()
        }
    }



