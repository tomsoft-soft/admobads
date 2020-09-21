package com.gmail.tomsoft.soft

import android.content.Intent

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onInterstitial(v: View){
        val intent = Intent(this, InterstitialActivity::class.java)
        startActivity(intent)
    }

    fun onBanner(v: View){
        val intent = Intent(this, BannerActivity::class.java)
        startActivity(intent)
    }
}