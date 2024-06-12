package com.example.publictransportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var eventsRV:RecyclerView
    lateinit var eventRVAdapter: EventRVAdapter
    lateinit var eventsList: ArrayList<EventRVModel>

    lateinit var imageButtonTransportation : ImageButton
    lateinit var menuIconView : ImageView
    lateinit var navigationView : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eventsRV = findViewById(R.id.rvEvent)
        imageButtonTransportation = findViewById(R.id.imageButtonTransportation)
        menuIconView = findViewById(R.id.menuIconView)
        navigationView = findViewById(R.id.navigationView)

        // set onclick listener image button
        imageButtonTransportation.setOnClickListener({
            val nextPage = Intent(this, TransportationActivity::class.java)
            startActivity(nextPage)
            finish()
        })

        // set onclick menu view icon
        menuIconView.setOnClickListener({
            Log.d("clickmenu", navigationView.visibility.toString())
            if(navigationView.visibility == View.GONE){
                navigationView.visibility = View.VISIBLE
                navigationView.setNavigationItemSelectedListener {menuItem ->
                    menuItem.isChecked = !menuItem.isChecked
                    when(menuItem.itemId){
                        R.id.Emergency -> {
                            Log.d("emergency", "emergency")
                            val i = Intent(this, EmergencyActivity::class.java)
                            startActivity(i)
                            finish()
                        }

                        R.id.Login -> {
                            val i = Intent(this, LoginActivity::class.java)
                            startActivity(i)
                        }


                    }
                    true
                }
            }
            else{
                navigationView.visibility = View.GONE
            }
        })


        eventsList = ArrayList()

        val layoutManager = GridLayoutManager(this, 2)
        eventsRV.layoutManager = layoutManager

        eventRVAdapter = EventRVAdapter(eventsList, this)

        eventsRV.adapter = eventRVAdapter

        eventsList.add(EventRVModel("Event Jakarta"))
        eventsList.add(EventRVModel("Event Betawi"))

        eventRVAdapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.Emergency -> {
                Log.d("emergency", "onOptionsItemSelected: ")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}


