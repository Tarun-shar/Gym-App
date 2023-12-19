package com.example.gymapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.gymapp.databinding.ActivityMainBinding
import com.example.gymapp.fragments.BMICalFragment
import com.example.gymapp.fragments.ScheduleFragment
import com.example.gymapp.fragments.HomeFragment
import com.example.gymapp.fragments.ProfileFragment
import com.example.gymapp.fragments.StopWatchFragment
import com.google.android.material.navigation.NavigationView
class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.title = "Welcome"

        binding.navView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this , binding.drawerLayout , binding.toolbar , R.string.open_nav , R.string.close_nav)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

            binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.home -> {
                        replaceFragment(HomeFragment())
                        true
                    }
                    R.id.schedule -> {
                        replaceFragment(ScheduleFragment())
                        true
                    }
                    R.id.profile -> {
                        replaceFragment(ProfileFragment())
                        true
                    }
                    else -> false
                }
            }
//        initially give default fragment
        replaceFragment(HomeFragment())
    }

//    bottom_navi_work

    //    set frame layout
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit()
    }

//    for navigation drawer

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.bmi -> {
                replaceFragment(BMICalFragment())
            }
            R.id.stopwatch -> {
                replaceFragment(StopWatchFragment())
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)

        }
        else{
            onBackPressedDispatcher.onBackPressed()
        }
    }


}



