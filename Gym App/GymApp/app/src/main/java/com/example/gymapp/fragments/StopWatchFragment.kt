package com.example.gymapp.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymapp.R
import com.example.gymapp.databinding.FragmentHomeBinding
import com.example.gymapp.databinding.FragmentStopWatchBinding

class StopWatchFragment : Fragment() {

    lateinit var binding: FragmentStopWatchBinding
    private var isRunning = false
    private var timerSeconds = 0

    //    handler use to schedule and run the code on a particular/specific thread
    private val handler = Handler(Looper.getMainLooper())
    private val runnable = object : Runnable{
        override fun run() {
            timerSeconds++
            val hours = timerSeconds / 3600
            val minutes = (timerSeconds % 3600) / 60
            val seconds = timerSeconds % 60

            val time = String.format("%02d:%02d:%02d" , hours , minutes , seconds)
            binding.timerText.text = time

            handler.postDelayed(this,1000)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentStopWatchBinding.inflate(layoutInflater , container , false)

        binding.startBtn.setOnClickListener {
            startTimer()
        }
        binding.stopBtn.setOnClickListener {
            stopTimer()
        }
        binding.resetBtn.setOnClickListener {
            resetTimer()
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun startTimer(){
        if(!isRunning){
            handler.postDelayed(runnable,1000)
            isRunning = true

            binding.startBtn.isEnabled = false
            binding.stopBtn.isEnabled = true
            binding.resetBtn.isEnabled = true
        }
    }

    private fun stopTimer(){
        if(isRunning){
            handler.removeCallbacks(runnable)
            isRunning = false

            binding.startBtn.isEnabled = true
            binding.startBtn.text = "Resume"
            binding.stopBtn.isEnabled = false
            binding.resetBtn.isEnabled = true
        }
    }

    private fun resetTimer(){
        stopTimer()

        timerSeconds = 0
        binding.timerText.text = "00:00:00"

        binding.startBtn.isEnabled = true
        binding.startBtn.text = "Start"
        binding.resetBtn.isEnabled = false

    }
}