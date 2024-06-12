package com.example.publictransportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TerminalActivity : AppCompatActivity() {

    lateinit var terminalsRV : RecyclerView
    lateinit var terminalRVAdapter: TerminalRVAdapter
    lateinit var mrtListTerminal : ArrayList<TerminalRVModel>
    lateinit var tjListTerminal : ArrayList<TerminalRVModel>
    lateinit var transportationTitle : TextView
    lateinit var ivBackIconTerminal : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terminal)

        terminalsRV = findViewById(R.id.rvTerminal)
        transportationTitle = findViewById(R.id.titleTransportationType)
        ivBackIconTerminal = findViewById(R.id.ivBackIconTerminal)

        mrtListTerminal = ArrayList()
        tjListTerminal = ArrayList()

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        terminalsRV.layoutManager = layoutManager


        // back page to before
        ivBackIconTerminal.setOnClickListener({
            val back = Intent(this, TransportationActivity::class.java)
            startActivity(back)
            finish()
        })

        // validate data getString intent
        if(intent.extras?.getString("typeTransport") == "mrt") {
            mrtListTerminal.add(TerminalRVModel("Lebak Bulus station", "Lebak bulus station adalah terminal yang berlokasi di Jakarta Selatan"))
            transportationTitle.text = "MRT"
            terminalRVAdapter = TerminalRVAdapter(mrtListTerminal, this)

            terminalsRV.adapter = terminalRVAdapter

            // applying click on adapter
            terminalRVAdapter.onItemClick = {
                val i = Intent(this, DetailActivity::class.java)
                i.putExtra("terminaldata", it)
                startActivity(i)
            }
        }

        // validate data get string intent th
        if(intent.extras?.getString("typeTransport") == "tj"){
            tjListTerminal.add(TerminalRVModel("Cawang Terminal", "Cawang station adalah terminal transjarta yang berada di pusat kota Jakarta"))
            transportationTitle.text = "Transjakarta"
            terminalRVAdapter = TerminalRVAdapter(tjListTerminal, this)
            terminalsRV.adapter = terminalRVAdapter
        }

        terminalRVAdapter.notifyDataSetChanged()




    }
}