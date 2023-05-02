package com.example.calander

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MonthFragment:Fragment() {
    private var rootView: View? = null
    private var listViewMonths: ListView? = null
    private var monthNamesAdapter: ArrayAdapter<String>? = null
    private var context: Context? = null
    private lateinit var weeks: Array<String>
    private var fragmentActionListener: FragmentActionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragments_months, container, false)
        initUI()
        return rootView
    }
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name) + "->Select Months"
    }

    fun setFragmentActionListener(fragmentActionListener: FragmentActionListener?) {
        this.fragmentActionListener = fragmentActionListener
    }
    private fun initUI() {
        context = getContext()
        weeks = resources.getStringArray(R.array.months)
        listViewMonths = rootView!!.findViewById<View>(R.id.listViewMonths) as ListView
        monthNamesAdapter =
            ArrayAdapter(requireContext(), R.layout.custom_list_item_set, weeks)
        listViewMonths!!.adapter=monthNamesAdapter
        listViewMonths!!.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, i, _ ->
                fragmentActionListener?.onMonthsSelected(weeks[i])
            }
    }


}