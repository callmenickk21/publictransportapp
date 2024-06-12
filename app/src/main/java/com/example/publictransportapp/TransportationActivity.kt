package com.example.publictransportapp

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class TransportationActivity : AppCompatActivity() {

    lateinit var ivBackIcon : ImageView
    lateinit var mrtIcon : ImageView
    lateinit var tjIcon : ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transportation)

        ivBackIcon = findViewById(R.id.ivBackIcon)
        mrtIcon = findViewById(R.id.mrtTransport)
        tjIcon = findViewById(R.id.tjTransport)

        // set listener back icon
        ivBackIcon.setOnClickListener({
            val backPage = Intent(this@TransportationActivity, MainActivity::class.java)
            startActivity(backPage)
            finish()
        })

        // onclick mrt transport
        mrtIcon.setOnClickListener({
            val i = Intent(this, TerminalActivity::class.java)
            i.putExtra("typeTransport", "mrt")
            startActivity(i)
            finish()
        })

        // onclick transjakarta icon
        tjIcon.setOnClickListener({
            val i = Intent(this, TerminalActivity::class.java)
            i.putExtra("typeTransport", "tj")
            startActivity(i)
            finish()
        })

    }
}