package com.appscrip.myapplication.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.appscrip.myapplication.R

class SplashScreenActivity : AppCompatActivity() {
    // Splash screen timer
    private val SPLASH_TIME_OUT = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Hiding the actionbar/toolbar
        supportActionBar!!.hide();
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({ // This method will be executed once the timer is over
            // Start your app main activity
            val i = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(i)


            // close this activity
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }
}