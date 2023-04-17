package com.example.mvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.mvvmdemo.databinding.ActivityMainBinding
import com.example.mvvmdemo.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel:MyViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObservers()
        binding.button.setOnClickListener {
             viewModel.getList()
        }
    }

    private fun initObservers(){
      viewModel.liveData.observe(this) { list ->
         binding.textView.text = list[1]
      }
    }
}