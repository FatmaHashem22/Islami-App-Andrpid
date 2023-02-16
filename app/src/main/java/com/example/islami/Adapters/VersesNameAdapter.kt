package com.example.islami.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.R
import com.example.islami.callbacks.OnVerseClickListener

class VersesNameAdapter(val verses: List<String>?) : Adapter<VersesNameAdapter.VersesNameViewHolder>(){

    var onVerseClickListener : OnVerseClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersesNameViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.ahadeeth_list_item,parent,false)
        return VersesNameViewHolder(view)
    }

    override fun onBindViewHolder(holder: VersesNameViewHolder, position: Int) {
        holder.verseName.text = verses?.get(position)
        holder.itemView.setOnClickListener {
            onVerseClickListener?.onVerseClick(position)
        }
    }

    override fun getItemCount(): Int {
        return verses?.size?:0
    }

    class VersesNameViewHolder(itemview: View) : ViewHolder(itemview){
        var verseName : TextView

        init {
            verseName = itemview.findViewById(R.id.hadeeth_name)
        }
    }


}