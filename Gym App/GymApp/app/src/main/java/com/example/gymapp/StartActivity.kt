package com.example.gymapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

                val auth = Firebase.auth

                if(auth.currentUser != null){
                    Toast.makeText(this, "User already logged in!!", Toast.LENGTH_SHORT).show()
                    redirect("MAIN")
                }

        val start = findViewById<Button>(R.id.start)

        start.setOnClickListener {
            redirect("LOGIN")
        }
    }

    private fun redirect(name:String) {
        val intent = when(name){
            "LOGIN" -> Intent(this,LogIn::class.java)
            "MAIN" -> Intent(this,MainActivity::class.java)
            else -> throw Exception("No Path Exists")
        }
        startActivity(intent)
        finish()

    }
}