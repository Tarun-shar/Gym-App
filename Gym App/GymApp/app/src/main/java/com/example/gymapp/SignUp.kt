package com.example.gymapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.WindowManager
import android.widget.Toast
import com.example.gymapp.databinding.ActivitySignUpBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app

class SignUp : AppCompatActivity() {

    lateinit var auth : FirebaseAuth

    lateinit var binding : ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        binding.OpenLogin.setOnClickListener{
            val intent = Intent(this,LogIn::class.java)
            startActivity(intent)
            finish()
        }

        emailFocusListener()
//        firebase work
        auth = Firebase.auth

        binding.signUp.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val passsword = binding.passwordEditText.text.toString()
            val confirmPassword = binding.confirmPasswordEditText.text.toString()

            if(email.isBlank() || passsword.isBlank() || confirmPassword.isBlank()){
                Toast.makeText(this, "Any Field can't be blank !!", Toast.LENGTH_SHORT).show()
            }
            else{
                if(passsword != confirmPassword){
                    Toast.makeText(this, "Password and Confirm Password do not match !!", Toast.LENGTH_SHORT).show()
                }
                else{
                    if(binding.emailContainer.helperText == null){
                        auth.createUserWithEmailAndPassword(email, passsword)
                            .addOnCompleteListener(this) {
                                if (it.isSuccessful) {

                                    Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
                                    val intent = Intent(this,MainActivity::class.java)
                                    startActivity(intent)
                                    resetForm()
                                    finish()

                                } else {
                                    Toast.makeText(this, "Invalid Form", Toast.LENGTH_SHORT).show()
                                }
                            }
                    }
                    else{
                        Toast.makeText(this, "Invalid E-mail", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun resetForm() {
        binding.emailEditText.text = null
        binding.passwordEditText.text = null
        binding.confirmPasswordEditText.text = null
    }

    private fun emailFocusListener() {
        binding.emailEditText.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = binding.emailEditText.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            return "Invalid Email Address"
        }
        return null
    }
}
