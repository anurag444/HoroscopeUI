package com.example.astrotak.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.astrotak.R
import com.example.astrotak.databinding.BannerLayoutBinding

class BannerAdapter(
    private val images: List<Int>
) : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    inner class BannerViewHolder(val binding: BannerLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val binding = BannerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val currImage = images[position]
        holder.binding.bannerImage.setImageResource(currImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}