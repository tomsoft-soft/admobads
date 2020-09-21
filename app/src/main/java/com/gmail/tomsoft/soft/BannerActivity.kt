package com.gmail.tomsoft.soft

import android.widget.Button
import android.widget.TextView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.gms.ads.*
import java.util.*

// Remove the line below after defining your own ad unit ID.
private const val TOAST_TEXT = "Test ads are being shown. " +
        "To show live ads, replace the ad unit ID in res/values/strings.xml " +
        "with your own ad unit ID."
private const val START_LEVEL = 1

class BannerActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)

        MobileAds.initialize(this)

        val testDeviceIds = listOf("1234567890ABCD")
        val configuration = RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build()
        MobileAds.setRequestConfiguration(configuration)

        mAdView = findViewById(R.id.adView)
        mAdView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(p0: Int) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        }

        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
}