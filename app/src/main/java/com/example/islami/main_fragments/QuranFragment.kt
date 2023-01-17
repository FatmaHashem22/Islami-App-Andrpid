package com.example.islami.main_fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.Adapters.SurasNameAdapter
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.callbacks.OnSuraClickListener
import com.example.islami.data.ArSuras
import com.example.islami.quran_details.QuranDetailsActivity

class QuranFragment : Fragment() {
    lateinit var quranRecyclerView: RecyclerView
    lateinit var quranAdapter : SurasNameAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.quran_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quranRecyclerView = view.findViewById(R.id.quran_recycler_view)
        quranAdapter = SurasNameAdapter(ArSuras)
        quranRecyclerView.adapter = quranAdapter
        quranAdapter.onSuraClickListener = object : OnSuraClickListener{
            override fun onSuraClick(position: Int, suraName: String) {
                val intent1 = Intent(requireActivity(),QuranDetailsActivity::class.java)
                intent1.putExtra(Constants.EXTRA_SURA_POSITION,position)
                intent1.putExtra(Constants.EXTRA_SURA_NAME,suraName)
                startActivity(intent1)

             }
        }
    }
}