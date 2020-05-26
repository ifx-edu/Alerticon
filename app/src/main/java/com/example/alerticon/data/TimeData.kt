package com.example.alerticon.data

import com.example.alerticon.models.WakeTime

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
                    "8:00",
                    "",
                    "yes"
                )
            )
            return list
        }
    }

}