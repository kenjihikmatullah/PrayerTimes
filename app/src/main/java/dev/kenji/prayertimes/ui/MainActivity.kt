package dev.kenji.prayertimes.ui

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dev.kenji.prayertimes.R
import dev.kenji.prayertimes.database.getDatabase
import dev.kenji.prayertimes.databinding.ActivityMainBinding
import dev.kenji.prayertimes.viewmodel.MainViewModel
import dev.kenji.prayertimes.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * Binding
         */
        val binding: ActivityMainBinding = setContentView(this, R.layout.activity_main)

        /**
         * Get application
         */
        val application: Application = requireNotNull(this).application

        /**
         * Create view model
         */
        val viewModelFactory = MainViewModelFactory(getDatabase(application))
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        /**
         * Observe prayer times
         */
        viewModel.prayerTimes.observe(this, Observer {
            binding.shubuhTime.text = it.shubuh
            binding.dhuhurTime.text = it.dhuhur
            binding.asharTime.text = it.ashar
            binding.maghribTime.text = it.maghrib
            binding.isyaTime.text = it.isya
        })


    }
}
