package com.example.publictransportapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventRVAdapter(private val eventList: ArrayList<EventRVModel>, private val context: Context):
    RecyclerView.Adapter<EventRVAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.event_rv_item,
            parent, false
        )
        return EventViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.eventName.text = eventList.get(position).eventName
    }

    class EventViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val eventName: TextView = itemView.findViewById(R.id.idTvEvent)
    }

}