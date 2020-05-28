package com.example.alerticon.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.alerticon.fragments.DataFragment
import com.example.alerticon.fragments.SettingsFragment
import com.example.alerticon.fragments.TimeFragment

/**
 * ViewPagerAdapter to change to the right tab fragment
 */

internal class PagerViewAdapter (fm:FragmentManager?):
        FragmentPagerAdapter(fm!!){
    override fun getItem(position: Int): Fragment {

        return when(position){
            0 -> {
                TimeFragment()
            }
            1 -> {
                DataFragment()
            }
            2 -> {
                SettingsFragment()
            }
            else -> TimeFragment()
        }
    }

    override fun getCount(): Int {

        return 3
    }


}