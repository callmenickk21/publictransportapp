package com.example.publictransportapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TerminalRVAdapter(private val terminalList : ArrayList<TerminalRVModel>, private val context : Context) :
    RecyclerView.Adapter<TerminalRVAdapter.TerminalViewHolder>(){

//    private var onCLickListener : OnClickListener? = null
    var onItemClick: ((TerminalRVModel) -> Unit?)? = null

    class TerminalViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val terminalName : TextView = itemView.findViewById(R.id.terminalRVItemTV)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TerminalRVAdapter.TerminalViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.terminal_rv_item,
            parent, false
        )

        return TerminalViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TerminalRVAdapter.TerminalViewHolder, position: Int) {
        holder.terminalName.text = terminalList.get(position).terminalName

        // holder clicked
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(terminalList.get(position))
//            if(onCLickListener != null){
//                onCLickListener!!.onClick(position, terminalList.get(position))
//            }
        }
    }

    override fun getItemCount(): Int {
       return terminalList.size
    }

    // bind click listener
//    fun setOnCLickListener(onClickListener: OnClickListener){
//        this.onCLickListener = onCLickListener
//    }

//    interface OnClickListener{
//        fun onClick(position: Int, model: TerminalRVModel)
//    }

}