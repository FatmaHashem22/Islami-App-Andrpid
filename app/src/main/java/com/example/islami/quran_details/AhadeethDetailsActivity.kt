package com.example.islami.quran_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.islami.Constants
import com.example.islami.R

class AhadeethDetailsActivity : AppCompatActivity() {
    lateinit var verseName : TextView
    var versePosition : Int? = null
    lateinit var verseContent : TextView
     var verseNameList : ArrayList<String> = ArrayList()
     var verseList : ArrayList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ahadeeth_details_activity)

        verseName = findViewById(R.id.verse_name)
        verseContent = findViewById(R.id.verse_content)
        versePosition = intent.getIntExtra(Constants.EXTRA_VERSE_POSITION,-1)
        readVersesFile()
        verseName.text = verseNameList.get(versePosition!!)
        verseContent.text = verseList.get(versePosition!!)


    }

    fun readVersesFile(){
        val reader : String? = assets?.open("ahadeth .txt")?.bufferedReader().use { it?.readText() }
        if(reader == null) return

        val verseContent = reader.trim().split("#")
        verseContent.forEach {
            val title = it.trim().substringBefore("\n")
            val verse = it.trim().substringAfter("\n")
            verseList.add(verse)
            verseNameList.add(title)
            Log.e("verse = ",verse)
        }

    }


}