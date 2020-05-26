package com.example.alerticon.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alerticon.R
import com.example.alerticon.adapter.TimeRecyclerAdapter
import com.example.alerticon.data.TimeData

class TimeFragment: Fragment() {

    private lateinit var timeAdapter: TimeRecyclerAdapter
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_time, container, false)

        recyclerView = view.findViewById(R.id.time_recycler_view)
        recyclerView!!.layoutManager = LinearLayoutManager(context)
        recyclerView!!.setHasFixedSize(true)
        timeAdapter = TimeRecyclerAdapter()
        recyclerView!!.adapter = timeAdapter

        // Danke!!! Tipp des Tages: http://www.chansek.com/RecyclerView-no-adapter-attached-skipping-layout/

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        addDataSet()
    }

    private fun addDataSet(){
        val data = TimeData.createDataSet()
        timeAdapter.submitList(data)
    }
}
