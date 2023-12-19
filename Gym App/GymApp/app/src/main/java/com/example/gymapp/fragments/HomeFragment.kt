package com.example.gymapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gymapp.DataModel
import com.example.gymapp.ItemAdapter
import com.example.gymapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var adapterObj : ItemAdapter
    lateinit var dataList : ArrayList<DataModel>

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater , container , false)

        dataList = ArrayList()

        dataList.add(DataModel("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/chest.jpg","Chest"))
        dataList.add(DataModel("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/tricep.jpg","Triceps"))
        dataList.add(DataModel("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/back.jpg","Back"))
        dataList.add(DataModel("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/bisep.jpg","Biceps"))
        dataList.add(DataModel("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/shoulder.jpg","Shoulders"))
        dataList.add(DataModel("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/forearm.webp","Forearms"))
        dataList.add(DataModel("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/abs.jpg","Abs"))
        dataList.add(DataModel("https://raw.githubusercontent.com/Tarun-shar/Gym-App-Images/main/leg.jpg","Legs"))

        adapterObj = ItemAdapter(dataList , requireContext())

        binding.recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        binding.recyclerView.adapter = adapterObj
        // Inflate the layout for this fragment
        return binding.root
    }
}