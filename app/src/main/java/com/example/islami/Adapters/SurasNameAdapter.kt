package com.example.islami.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.R
import com.example.islami.callbacks.OnSuraClickListener
import com.example.islami.data.SuraDataItem

class SurasNameAdapter (
    val suras : List<String> ,
    var count : Int = 286
        ) : Adapter<SurasNameAdapter.SurasNameViewHolder>() {

    var onSuraClickListener : OnSuraClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurasNameViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.quran_list_item,parent,false)
        return SurasNameViewHolder(view)
    }

    override fun onBindViewHolder(holder: SurasNameViewHolder, position: Int) {
        holder.suraName.text = suras.get(position)
        holder.ayatCount.text = "$count"
        holder.itemView.setOnClickListener{
            onSuraClickListener?.onSuraClick(position,suras.get(position))
        }
    }

    override fun getItemCount(): Int {
        return suras.size
    }



    class SurasNameViewHolder(itemView : View) : ViewHolder(itemView) {

        var suraName : TextView
        var ayatCount : TextView

        init{
            suraName = itemView.findViewById(R.id.sura_name)
            ayatCount = itemView.findViewById(R.id.sura_ayat_no)
        }
    }


}