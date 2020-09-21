package com.gmail.tomsoft.soft

import android.widget.Button
import android.widget.TextView

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_interstitial.*


class InterstitialActivity : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interstitial)

        MobileAds.initialize(this)

        val testDeviceIds = listOf("1234567890ABCD")
        val configuration = RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build()
        MobileAds.setRequestConfiguration(configuration)

        mInterstitialAd = InterstitialAd(this)

        mInterstitialAd.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                button.isEnabled = true

            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
                Log.d("TAG", "onAdFailedToLoad: $errorCode")
            }

            override fun onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
                mInterstitialAd.loadAd(AdRequest.Builder().build())
                button.isEnabled = false

            }
        }

        mInterstitialAd.adUnitId = getResources().getString(R.string.interstitial_ad_unit_id);
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        button = findViewById<Button>(R.id.next_button)
        button.isEnabled = false


    }

    fun onButton(v : View) {
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.")
        }
    }

}