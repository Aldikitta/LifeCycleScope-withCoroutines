package com.aldikitta.lifecyclescope_withcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.aldikitta.lifecyclescope_withcoroutines.databinding.ActivityMainBinding
import com.aldikitta.lifecyclescope_withcoroutines.ui.main.MainFragment
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        lifecycleScope.launch(Main) {
            delay(500)
            binding.progressBar.visibility = View.VISIBLE
            delay(10000)
            binding.progressBar.visibility = View.GONE
        }

        lifecycleScope.launchWhenCreated {

        }
        lifecycleScope.launchWhenStarted {

        }
        lifecycleScope.launchWhenResumed {

        }
    }
}