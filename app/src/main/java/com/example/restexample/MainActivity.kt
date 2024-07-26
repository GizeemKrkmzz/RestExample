package com.example.restexample

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.restexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       /* mainViewModel.isLoading.observe(this){ value ->
            if (value) binding.progress.visibility = View.GONE
            else binding.progress.visibility = View.GONE
        } */
       mainViewModel.post.observe(this) { value ->
           binding.txtError.text= value.body.toString()
           if(!value.body.toString().isEmpty()){
           binding.progress.visibility = View.GONE
       }
       }
        mainViewModel.isLoading.observe(this){isLoading->
            binding.progress.visibility; if(isLoading) View.VISIBLE else View.GONE
        }
        mainViewModel.hasError.observe(this){ hasError ->
            //binding.txtError.text= hasError.toString()
    }
}
}