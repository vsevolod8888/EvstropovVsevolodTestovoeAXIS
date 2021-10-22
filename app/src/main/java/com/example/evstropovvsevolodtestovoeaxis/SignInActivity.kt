package com.example.evstropovvsevolodtestovoeaxis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.evstropovvsevolodtestovoeaxis.databinding.ActivitySignInBinding
class SignInActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonEnter.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}