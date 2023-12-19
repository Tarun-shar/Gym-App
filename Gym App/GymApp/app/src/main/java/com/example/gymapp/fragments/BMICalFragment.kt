package com.example.gymapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import com.example.gymapp.R
import com.example.gymapp.databinding.FragmentBMICalBinding
import kotlin.math.pow

class BMICalFragment : Fragment() {

    lateinit var binding:FragmentBMICalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentBMICalBinding.inflate(layoutInflater , container , false)

        binding.boyImg.setOnClickListener {
            binding.boyImg.setImageResource(R.drawable.boy)
            binding.girlImg.setImageResource(R.drawable.girl_blur)
        }

        binding.girlImg.setOnClickListener {
            binding.boyImg.setImageResource(R.drawable.boy_blur)
            binding.girlImg.setImageResource(R.drawable.girl)
        }

        binding.calculateButton.setOnClickListener {
            var weightValue1 = 0.0
            var heightValue1 = 0.0
            if(binding.weightValue.text.toString().isNotEmpty()){
                weightValue1 = binding.weightValue.text.toString().toDouble()
            }
            if(binding.heightValue.text.toString().isNotEmpty()){
//                height value must be in meter
                heightValue1 = (binding.heightValue.text.toString().toDouble() / 100)
            }
            if (weightValue1 > 0.0 && heightValue1 > 0.0){
                val bmiValue = String.format("%.2f", weightValue1/heightValue1.pow(2))
                binding.bmi.text = bmiValue
                binding.bmiStatus.text = bmiStatusValue(weightValue1/heightValue1.pow(2))
                binding.bmiView.visibility = VISIBLE
                binding.calculateButton.visibility = GONE
            }
            else
                Toast.makeText(context, "Please input weight and height values greater than 0", Toast.LENGTH_SHORT).show()
        }

        binding.calculateAgain.setOnClickListener {
            binding.bmiView.visibility = GONE
            binding.calculateButton.visibility = VISIBLE
            binding.weightValue.text.clear()
            binding.heightValue.text.clear()
            binding.weightValue.requestFocus()

        }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun bmiStatusValue(bmi: Double): String {
        lateinit var bmiStatus : String
        if (bmi < 18.5)
            bmiStatus = "UnderWeight"
        else if (bmi>=18.5 && bmi<25)
            bmiStatus = "Normal"
        else if(bmi>=25 && bmi<30)
            bmiStatus = "OverWeight"
        else if(bmi>30)
            bmiStatus = "Obese"
        return bmiStatus
    }

}






