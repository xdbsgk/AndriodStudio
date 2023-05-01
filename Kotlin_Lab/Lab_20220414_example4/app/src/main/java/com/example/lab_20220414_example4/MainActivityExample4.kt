package com.example.lab_20220414_example4

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_20220414_example4.databinding.ActivityMainExample4Binding

class MainActivityExample4 : AppCompatActivity() {
    lateinit var toqqle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding = ActivityMainExample4Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        toqqle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toqqle.syncState()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toqqle.onOptionsItemSelected(item)) {return true}
        return super.onOptionsItemSelected(item)
    }

}