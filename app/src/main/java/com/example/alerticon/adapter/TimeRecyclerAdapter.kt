package com.example.alerticon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alerticon.R
import com.example.alerticon.models.WakeTime
import kotlinx.android.synthetic.main.layout_time_list_item.view.*

class TimeRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<WakeTime> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TimeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_time_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is  TimeViewHolder ->{
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(timeList: List<WakeTime>){
        items = timeList
    }

    class TimeViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        private val timeTime = itemView.time_time
        private val timeDay = itemView.time_day
        private val timeRepeat = itemView.time_repeat

        fun bind(wakeTime: WakeTime){
            timeTime.text = wakeTime.time
            timeDay.text = wakeTime.day
            timeRepeat.text = wakeTime.repeat
        }
    }
}