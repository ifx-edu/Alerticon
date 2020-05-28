package com.example.alerticon.fragments

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alerticon.R
import com.example.alerticon.adapter.TimeRecyclerAdapter
import com.example.alerticon.data.TimeData
import kotlinx.android.synthetic.main.fragment_time.add_time_button
import kotlinx.android.synthetic.main.popup_time_set.view.*
import java.text.SimpleDateFormat
import java.util.*

class TimeFragment: Fragment() {

    private lateinit var timeAdapter: TimeRecyclerAdapter
    private lateinit var alertDialog: AlertDialog
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

        add_time_button.setOnClickListener { showTimeSetDialog() }
    }

    private fun addDataSet(){
        val data = TimeData.createDataSet()
        timeAdapter.submitList(data)
    }

    // Danke!! Credits gehen an https://stackoverflow.com/a/59563393, mit einer Navigation Action wollte es einfach nicht funktionieren
    private fun showTimeSetDialog() {
        val inflater: LayoutInflater = this.layoutInflater
        val timeSetView: View = inflater.inflate(R.layout.popup_time_set, null)
        val timeSetBuilder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        val confirmTimeButton: ImageButton = timeSetView.confirm_time_button

        timeSetBuilder.setOnDismissListener { }
        timeSetBuilder.setView(timeSetView)
        alertDialog = timeSetBuilder.create()
        alertDialog.show()
        confirmTimeButton.setOnClickListener { setTime(timeSetView) }
    }

    private fun setTime(timeSetView: View) {
        val timeFormat = SimpleDateFormat("hh:mm", Locale.ROOT)
        val now = Calendar.getInstance()
        val timeInputLabel = timeSetView.time_input
        val timePicker = TimePickerDialog(requireContext(), TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
            val selectedTime = Calendar.getInstance()
            selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
            selectedTime.set(Calendar.MINUTE, minute)
            timeInputLabel.hint = timeFormat.format(selectedTime.time).toString()
        },
            now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), true)
        timePicker.show()
    }
}