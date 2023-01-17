package com.example.islami.quran_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.quran_details.adapters.SuraContentAdapter

class QuranDetailsActivity : AppCompatActivity() {

    lateinit var suraContentRecyclerView : RecyclerView
    lateinit var adapter : SuraContentAdapter
    var suraPosition : Int? = null
    var suraName : String? = null
    lateinit var suraNameTextView : TextView
    lateinit var backIcon : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran_details)

        suraContentRecyclerView = findViewById(R.id.suraa_recycler_view)
        adapter = SuraContentAdapter(null)
        suraPosition = intent.getIntExtra(Constants.EXTRA_SURA_POSITION,-1)
        suraName = intent.getStringExtra(Constants.EXTRA_SURA_NAME)
        suraContentRecyclerView.adapter = adapter
        readFileText()
        suraNameTextView = findViewById(R.id.sura_name)
        suraNameTextView.text = suraName
        backIcon = findViewById(R.id.arrow_back)
        backIcon.setOnClickListener{
            finish()
        }
    }

    fun readFileText(){
        val fileName = "${suraPosition?.plus(1)}.txt"
        val fileContent : String =  assets.open(fileName)
            .bufferedReader()
            .use { it.readText() }
        val suraContent = fileContent.split("\n")
        adapter.updateData(suraContent)
    }
}