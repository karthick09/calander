package com.example.calander

interface FragmentActionListener {
    fun onMonthsSelected(month: String?)

    companion object {
        const val KEY_SELECTED_MONTHS = "KEY_SELECTED_MONTHS"
    }
}