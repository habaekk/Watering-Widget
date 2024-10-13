package com.bada.widgetprac

import android.os.Bundle
import android.widget.NumberPicker
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.bada.widgetprac.DetailsFragment
import com.bada.widgetprac.HomeFragment
import com.bada.widgetprac.R
import com.bada.widgetprac.SettingsFragment
import com.bada.widgetprac.databinding.ActivityNav2Binding


private const val TAG_HOME = "home_fragment"
private const val TAG_SETTINGS = "settings_fragment"
private const val TAG_DETAILS = "details_fragment"
private const val TAG_HISTORY = "history_fragment"

class NavActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityNav2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNav2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        setFragment(TAG_HOME, HomeFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                //R.id.settingsFragment -> setFragment(TAG_SETTINGS, SettingsFragment())
                R.id.detailsFragment-> setFragment(TAG_DETAILS, DetailsFragment())
                R.id.historyFragment-> setFragment(TAG_HISTORY, HistoryFragment())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val home = manager.findFragmentByTag(TAG_HOME)
        val settings = manager.findFragmentByTag(TAG_SETTINGS)
        val details = manager.findFragmentByTag(TAG_DETAILS)
        val history = manager.findFragmentByTag(TAG_HISTORY)

        if (home != null){
            fragTransaction.hide(home)
        }

        if (history != null) {
            fragTransaction.hide(history)
        }

        if (settings != null){
            fragTransaction.hide(settings)
        }

        if (details != null) {
            fragTransaction.hide(details)
        }

        if (tag == TAG_HOME) {
            if (home!=null){
                fragTransaction.show(home)
            }
        }
        else if (tag == TAG_HISTORY) {
            if (history != null) {
                fragTransaction.show(history)
            }
        }
        else if (tag == TAG_SETTINGS) {
            if (settings != null) {
                fragTransaction.show(settings)
            }
        }

        else if (tag == TAG_DETAILS){
            if (details != null){
                fragTransaction.show(details)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}