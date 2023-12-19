package com.example.gymapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gymapp.databinding.ItemFileExtypeBinding

class ExItemAdapter(var exDataList : ArrayList<ModelClass2> , var context : Context):RecyclerView.Adapter<ExItemAdapter.ViewHolder>() {

    class ViewHolder(var binding: ItemFileExtypeBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val exItemView = ItemFileExtypeBinding.inflate(LayoutInflater.from(context),parent ,false)
        return ViewHolder(exItemView)
    }

    override fun getItemCount(): Int {
        return exDataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        Toast.makeText(context,exDataList[position].exTypeImage , Toast.LENGTH_SHORT).show()
        Glide.with(context).load(exDataList[position].exTypeImage).into(holder.binding.exTypeImage)
        holder.binding.exTypeName.text = exDataList[position].exTypeName
    }
}