package com.example.sapinterview.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.sapinterview.R
import kotlinx.android.synthetic.main.user_details.*

class DetailsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_details)

        displayUserData()
    }

    private fun displayUserData() {

        val bundle: Bundle? = intent.extras
        val name: String? = bundle?.getString(resources.getString(R.string.name))
        val description: String? = bundle?.getString(resources.getString(R.string.description))
        val image: String? = bundle?.getString(resources.getString(R.string.image))

        tvName.text = name
        tvDescription.text = description

        Glide
            .with(this)
            .load(image)
            .placeholder(R.mipmap.ic_launcher)
            .dontAnimate()
            .into(ivAvatar)
    }
}