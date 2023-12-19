package com.example.gymapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gymapp.ModelClass3
import com.example.gymapp.databinding.FragmentScheduleBinding
import com.example.gymapp.schItemAdapter

class ScheduleFragment : Fragment() {

    lateinit var schAdapter: schItemAdapter
    lateinit var schDataList: ArrayList<ModelClass3>
    lateinit var binding: FragmentScheduleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentScheduleBinding.inflate(layoutInflater , container , false)

        schDataList = ArrayList()

        schDataList.add(ModelClass3("Exercise - Chest","Monday","Time - 5:00 PM to 6:00 PM"))
        schDataList.add(ModelClass3("Exercise - Triceps","Tuesday","Time - 5:00 PM to 6:00 PM"))
        schDataList.add(ModelClass3("Exercise - Back","Wednesday","Time - 5:00 PM to 6:00 PM"))
        schDataList.add(ModelClass3("Exercise - Biceps","Thursday","Time - 5:00 PM to 6:00 PM"))
        schDataList.add(ModelClass3("Exercise - Shoulder & Forearms","Friday","Time - 5:00 PM to 6:00 PM"))
        schDataList.add(ModelClass3("Exercise - Abs & Legs","Saturday","Time - 5:00 PM to 6:00 PM"))
        schDataList.add(ModelClass3("No Exercise","Sunday","No Time"))

        schAdapter = schItemAdapter(schDataList , requireContext())

        binding.schRecycle.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL,false)

        binding.schRecycle.adapter = schAdapter

        return binding.root
    }

}