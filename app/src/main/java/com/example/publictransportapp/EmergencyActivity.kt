package com.example.publictransportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.google.android.material.navigation.NavigationView

class EmergencyActivity : AppCompatActivity() {

    lateinit var ivIconMenu : ImageView
    lateinit var navigationViewData : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)

        ivIconMenu = findViewById(R.id.ivMenuEmergency)
        navigationViewData = findViewById(R.id.navigation_view_menu)

        // set on click listener
        ivIconMenu.setOnClickListener {
            if (navigationViewData.visibility == View.GONE) {
                navigationViewData.visibility = View.VISIBLE

                navigationViewData.setNavigationItemSelectedListener { item ->
                    item.isChecked = !item.isChecked
                    when (item.itemId) {
                        R.id.Login -> {
                            val i = Intent(this, LoginActivity::class.java)
                            startActivity(i)
                            finish()
                        }
                    }
                    true
                }
            } else {
                navigationViewData.visibility = View.GONE
            }
        }

    }
}