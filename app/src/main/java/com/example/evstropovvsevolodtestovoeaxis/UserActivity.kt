package com.example.evstropovvsevolodtestovoeaxis

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.evstropovvsevolodtestovoeaxis.databinding.ActivityUserBinding
import com.example.evstropovvsevolodtestovoeaxis.pagerAdapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class UserActivity:AppCompatActivity() {
    lateinit var binding: ActivityUserBinding
    val array = arrayOf(
        "User Info",
        "Notes"
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = array[position]
        }.attach()
    }
}