package com.example.islami.main_fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.Adapters.VersesNameAdapter
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.callbacks.OnVerseClickListener
import com.example.islami.quran_details.AhadeethDetailsActivity

class AhadeethFragment : Fragment() {
    lateinit var ahadeethRecyclerView: RecyclerView
    lateinit var ahadeethAdapter: VersesNameAdapter
    lateinit var ahadeethList : ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ahadeeth_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ahadeethRecyclerView = view.findViewById(R.id.ahadeeth_recycler_view)
        initializeAhadeeth()
        ahadeethAdapter = VersesNameAdapter(ahadeethList)
        ahadeethRecyclerView.adapter = ahadeethAdapter
        ahadeethAdapter.onVerseClickListener = object : OnVerseClickListener {
            override fun onVerseClick(position: Int) {
                val intent1 = Intent(requireActivity(),AhadeethDetailsActivity::class.java)
                intent1.putExtra(Constants.EXTRA_VERSE_POSITION,position)
                startActivity(intent1)
            }

        }



    }

    fun initializeAhadeeth() {
        ahadeethList = ArrayList(50)
        var n = 0
        for(i in 0..50) {
            n = i+1
            ahadeethList.add("حديث رقم "+n)
        }
    }
}