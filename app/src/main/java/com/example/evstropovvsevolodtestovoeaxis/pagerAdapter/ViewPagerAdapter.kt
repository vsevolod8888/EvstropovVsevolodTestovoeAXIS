package com.example.evstropovvsevolodtestovoeaxis.pagerAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.evstropovvsevolodtestovoeaxis.fragments.NotesFragment
import com.example.evstropovvsevolodtestovoeaxis.fragments.UserInfoFragment

private const val NUM_TABS = 2

public class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return UserInfoFragment()
            1 -> return NotesFragment()
        }
        return NotesFragment()
    }
}