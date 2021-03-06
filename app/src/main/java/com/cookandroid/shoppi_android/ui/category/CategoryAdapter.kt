package com.cookandroid.shoppi_android.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.shoppi_android.databinding.ItemCategoryBinding
import com.cookandroid.shoppi_android.model.Category
import com.cookandroid.shoppi_android.ui.common.CategoryDiffCallback


class CategoryAdapter(private val viewModel:CategoryViewModel) : ListAdapter<Category, CategoryAdapter.ViewHolder>(
    CategoryDiffCallback()
) {


    inner class ViewHolder(private val binding:ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(category:Category){
            binding.cateogry = category
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

