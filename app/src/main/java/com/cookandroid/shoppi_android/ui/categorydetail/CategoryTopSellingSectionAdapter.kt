package com.cookandroid.shoppi_android.ui.categorydetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.shoppi_android.databinding.ItemCategoryTopSellingSectionBinding
import com.cookandroid.shoppi_android.model.TopSelling

class CategoryTopSellingSectionAdapter:ListAdapter<TopSelling,CategoryTopSellingSectionAdapter.ViewHolder>(TopSellingDiffCallback()) {

    inner class ViewHolder(private val binding: ItemCategoryTopSellingSectionBinding) : RecyclerView.ViewHolder(binding.root){

        private val nestedAdapter = CategoryTopSellingItemAdapter()

        init {
            binding.rvCategorySection.adapter = nestedAdapter
        }


        fun bind(data:TopSelling){
            binding.title=data.title
            binding.executePendingBindings()
            nestedAdapter.submitList(data.categories)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCategoryTopSellingSectionBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class TopSellingDiffCallback : DiffUtil.ItemCallback<TopSelling>(){
    override fun areItemsTheSame(oldItem: TopSelling, newItem: TopSelling): Boolean {
        return oldItem.title.text == newItem.title.text
    }

    override fun areContentsTheSame(oldItem: TopSelling, newItem: TopSelling): Boolean {
        return oldItem == newItem
    }

}