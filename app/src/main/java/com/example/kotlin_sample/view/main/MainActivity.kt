package com.example.kotlin_sample.view.main

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_sample.R
import com.example.kotlin_sample.util.replace
import com.example.kotlin_sample.view.main.Dashboard.DashboardFragment
import com.example.kotlin_sample.view.main.Notification.NotificationsFragment
import com.example.kotlin_sample.view.main.home.HomeFragment

class MainActivity : AppCompatActivity() {



    private val homeFragment : HomeFragment by lazy {
        HomeFragment()
    }

    private val dashboardFragment: DashboardFragment by lazy{
        DashboardFragment().apply {
            arguments = Bundle().apply {
                putInt(DashboardFragment.KEY_TITLE, R.string.title_dashboard)
            }
        }
    }

    private val notificationFragment : NotificationsFragment by lazy{
        NotificationsFragment().apply {
            arguments = Bundle().apply {
                putInt(NotificationsFragment.KEY_TITLE, R.string.title_notifications)
            }
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item->
        when(item.itemId){
            R.id.navigation_home->{
                replace(R.id.container, homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard->{
                replace(R.id.container, dashboardFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications->{
                replace(R.id.container, notificationFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replace(R.id.container, homeFragment)


        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


    }




}
