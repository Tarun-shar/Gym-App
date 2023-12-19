package com.example.gymapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val obj: Thread = object : Thread(){
            override fun run() {
                try {
                    sleep(2000)
                }
                catch (e:Exception){
                    e.printStackTrace()
                }
                finally {
                    val intent  = Intent(this@SplashActivity , StartActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
        obj.start()
    }
}