package com.example.alerticon.data

import com.example.alerticon.models.WakeTime

/**
 * array as companion object containing all data for the TimeFragment.kt RecyclerView
 */

class TimeData {

    companion object{

        fun createDataSet(): ArrayList<WakeTime>{
            val list = ArrayList<WakeTime>()
            list.add(
                WakeTime(
                    "07:00",
                    "Monday",
                    "yes"
                )
            )
            list.add(
                WakeTime(
                    "09:00",
                    "Thursday",
                    "yes"
                )
            )
            list.add(
                WakeTime(
                    "06:00",
                    "",
                    "no"
                )
            )
            list.add(
                WakeTime(
                    "11:00",
                    "Sunday",
                    "no"
                )
            )
            list.add(
                WakeTime(
                    "08:00",
                    "",
                    "yes"
                )
            )
            list.add(
                WakeTime(
                    "08:15",
                    "",
                    "no"
                )
            )
            list.add(
                WakeTime(
                    "12:45",
                    "",
                    "no"
                )
            )
            list.add(
                WakeTime(
                    "04:20",
                    "",
                    "no"
                )
            )
            list.add(
                WakeTime(
                    "15:30",
                    "",
                    "no"
                )
            )
            list.add(
                WakeTime(
                    "18:15",
                    "",
                    "no"
                )
            )
            return list
        }
    }
}