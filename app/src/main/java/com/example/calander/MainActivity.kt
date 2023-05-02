package com.example.calander


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity(),FragmentActionListener {
    var fragmentManager: FragmentManager? = null
    var fragmentTransaction: FragmentTransaction? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
        addMonths()
    }
    private fun addMonths(){
        fragmentTransaction = fragmentManager?.beginTransaction()
        val monthsListFragment = MonthFragment()
        monthsListFragment.setFragmentActionListener(this)
        fragmentTransaction!!.add(R.id.fragmentContainer,monthsListFragment)
        fragmentTransaction!!.addToBackStack("fragments")
        fragmentTransaction!!.commit()
    }
    private fun addMonthDescription(monthsName : String?){
        fragmentTransaction = fragmentManager?.beginTransaction()
        val monthDescriptionFragment = DaysFragment()
        val bundle = Bundle()
        bundle.putString(FragmentActionListener.KEY_SELECTED_MONTHS, monthsName)
        monthDescriptionFragment.setArguments(bundle)
        fragmentTransaction!!.replace(R.id.fragmentContainer, monthDescriptionFragment)
        fragmentTransaction!!.addToBackStack(null)
        fragmentTransaction!!.commit()
    }

    override fun onMonthsSelected(month: String?) {
        addMonthDescription(month)
    }

}
