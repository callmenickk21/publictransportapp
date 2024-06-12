package com.example.publictransportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    lateinit var tvRegister : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

            tvRegister = findViewById(R.id.tvDirectToRegister)

            tvRegister.setOnClickListener{
                val i = Intent(this, RegisterActivity::class.java)
                startActivity(i)
                finish()
            }

    }
}