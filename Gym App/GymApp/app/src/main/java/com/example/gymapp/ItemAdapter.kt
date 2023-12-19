package com.example.gymapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gymapp.databinding.ItemFileBinding

class ItemAdapter(var dataList:ArrayList<DataModel>, var context:Context):RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(var binding: ItemFileBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = ItemFileBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.binding.exerciseName.text = dataList[position].exerciseName
        Glide.with(context).load(dataList[position].exerciseImg).into(holder.binding.exerciseImage)

        holder.binding.itemLinear.setOnClickListener {

            Toast.makeText(context, dataList[position].exerciseName, Toast.LENGTH_SHORT).show()
            val intent = Intent(context , ExerciseType::class.java)
            intent.putExtra("id",position)
            context.startActivity(intent)
        }
    }
}