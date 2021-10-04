package com.example.astrotak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.astrotak.databinding.ActivityMainBinding
import com.example.astrotak.navigationfragments.HomeFragment
import com.example.astrotak.navigationfragments.TalkToAstrologerFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fragment1: Fragment = HomeFragment()
    private val fragment2: Fragment = TalkToAstrologerFragment()
    private val fm: FragmentManager = supportFragmentManager
    private var active: Fragment = fragment1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fm.beginTransaction().add(R.id.content_main, fragment2, "2").hide(fragment2).commit()
        fm.beginTransaction().add(R.id.content_main,fragment1, "1").commit()

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    fm.beginTransaction().hide(active).show(fragment1).commit()
                    active = fragment1
                    true
                }
                R.id.menu_astrologer -> {
                    fm.beginTransaction().hide(active).show(fragment2).commit()
                    active = fragment2
                    true
                }
                R.id.menu_ask -> {
                    //setContent("Question")
                    true
                }
                R.id.menu_reports -> {
                    //setContent("Reports")
                    true
                }
                else -> false
            }
        }
    }

}