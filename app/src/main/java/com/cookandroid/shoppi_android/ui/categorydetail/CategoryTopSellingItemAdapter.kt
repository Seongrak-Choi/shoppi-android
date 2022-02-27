package com.cookandroid.shoppi_android.ui.categorydetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.shoppi_android.databinding.ItemCategoryTopSellingBinding
import com.cookandroid.shoppi_android.model.Category
import com.cookandroid.shoppi_android.ui.common.CategoryDiffCallback
import kotlin.math.truncate

class CategoryTopSellingItemAdapter : ListAdapter<Category, CategoryTopSellingItemAdapter.TopSellingItemViewHolder>(CategoryDiffCallback()){

    inner class TopSellingItemViewHolder(private val binding:ItemCategoryTopSellingBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data:Category){
            binding.category= data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopSellingItemViewHolder {
        val binding = ItemCategoryTopSellingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TopSellingItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopSellingItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}