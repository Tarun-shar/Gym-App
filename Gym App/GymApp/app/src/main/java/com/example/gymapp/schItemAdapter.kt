package com.example.gymapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.gymapp.databinding.SchItemFileBinding

class schItemAdapter(var schDataList: ArrayList<ModelClass3> , var context : Context ):RecyclerView.Adapter<schItemAdapter.ViewHolder>() {

    class ViewHolder(var binding: SchItemFileBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = SchItemFileBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return schDataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.exname.text = schDataList.get(position).exName
        holder.binding.dayName.text = schDataList.get(position).day
        holder.binding.schTime.text = schDataList.get(position).time

        holder.binding.linear2.setOnClickListener {
            Toast.makeText(context, "Clicked $position", Toast.LENGTH_SHORT).show()
        }
    }
}