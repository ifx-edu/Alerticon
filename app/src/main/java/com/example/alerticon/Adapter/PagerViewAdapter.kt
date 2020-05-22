package com.example.alerticon.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.alerticon.Fragments.DataFragment
import com.example.alerticon.Fragments.SettingsFragment
import com.example.alerticon.Fragments.TimeFragment

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