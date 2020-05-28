package com.example.alerticon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.alerticon.adapter.PagerViewAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var mViewPager: ViewPager
    private lateinit var timeButton: ImageButton
    private lateinit var dataButton: ImageButton
    private lateinit var settingsButton: ImageButton
    private lateinit var mPagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init views

        mViewPager = findViewById(R.id.mViewPager)

        // init image buttons

        timeButton = findViewById(R.id.time_tab)
        dataButton = findViewById(R.id.data_tab)
        settingsButton = findViewById(R.id.settings_tab)

        mPagerAdapter = PagerViewAdapter(supportFragmentManager)
        mViewPager.adapter = mPagerAdapter
        mViewPager.offscreenPageLimit = 3

        // add page change listener

        mViewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                changingTabs(position)
            }
        })

        mViewPager.currentItem = 0
        timeButton.setImageResource(R.drawable.ic_time_tab_dark)

    }

    private fun changingTabs(position: Int) {

        if(position == 0){
            timeButton.setImageResource(R.drawable.ic_time_tab_dark)
            dataButton.setImageResource(R.drawable.ic_data_tab_light)
            settingsButton.setImageResource(R.drawable.ic_settings_tab_light)
        }
        if(position == 1){
            timeButton.setImageResource(R.drawable.ic_time_tab_light)
            dataButton.setImageResource(R.drawable.ic_data_tab_dark)
            settingsButton.setImageResource(R.drawable.ic_settings_tab_light)
        }
        if(position == 2){
            timeButton.setImageResource(R.drawable.ic_time_tab_light)
            dataButton.setImageResource(R.drawable.ic_data_tab_light)
            settingsButton.setImageResource(R.drawable.ic_settings_tab_dark)
        }

    }
}