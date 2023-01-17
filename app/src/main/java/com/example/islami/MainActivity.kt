package com.example.islami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islami.main_fragments.AhadeethFragment
import com.example.islami.main_fragments.QuranFragment
import com.example.islami.main_fragments.RadioFragment
import com.example.islami.main_fragments.TasbeehFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener {

            if(it.itemId == R.id.quran) {
                pushFragment(QuranFragment())
            } else if(it.itemId == R.id.ahadeeth) {
                pushFragment(AhadeethFragment())
            } else if(it.itemId == R.id.tasbeeh) {
                pushFragment(TasbeehFragment())
            } else if(it.itemId == R.id.radio) {
                pushFragment(RadioFragment())
            }
            return@setOnItemSelectedListener true
        }
        bottomNavigationView.selectedItemId = R.id.quran
    }

    fun pushFragment(fragment: Fragment) {
       supportFragmentManager
           .beginTransaction()
           .replace(R.id.container_fragment,fragment)
           .commit()
    }
}