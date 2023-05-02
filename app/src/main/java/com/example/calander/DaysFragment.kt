package com.example.calander

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

@Suppress("DEPRECATION")
class DaysFragment:Fragment() {
    private var rootView: View? = null
    private var listViewMonthDescription: ListView? = null
    private var monthName: String? = null
    private var monthDescription = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_month_decription, container, false)
        initUI()
        return rootView
    }
    private fun initUI() {
        listViewMonthDescription = rootView?.findViewById(R.id.listViewDays) as ListView

    }
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.title = monthName
        listViewMonthDescription?.adapter = ArrayAdapter(requireContext(), R.layout.custom_list_item_set, monthDescription)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bundle: Bundle? = arguments
        monthName = bundle?.getString(FragmentActionListener.KEY_SELECTED_MONTHS, "Jan")
        monthDescription = genrateDays(daysOfMonth(monthName))
    }

    private fun daysOfMonth(month : String?): Int{
        return when(month){
            "Jan","Mar","May","July","Aug","Oct","Dec" -> 31
            "Feb" -> 28
            else -> 30
        }
    }


    private fun genrateDays(i :Int):ArrayList<String>{
        val data=ArrayList<String>()
        for(i in 1..i) {
            data.add("day $i")
        }
        return data
    }
}