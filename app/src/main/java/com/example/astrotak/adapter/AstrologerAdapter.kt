package com.example.astrotak.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.astrotak.databinding.AstrologerRowBinding
import com.example.astrotak.model.Astrologer

class AstrologerAdapter(private var astrologers: List<Astrologer>) :
    RecyclerView.Adapter<AstrologerAdapter.AstrologerViewHolder>() {

    inner class AstrologerViewHolder(val aBinding: AstrologerRowBinding) :
        RecyclerView.ViewHolder(aBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AstrologerViewHolder {
        val binding =
            AstrologerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return AstrologerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AstrologerViewHolder, position: Int) {
        val astrologer: Astrologer = astrologers[position]

        holder.aBinding.astrologerName.text = astrologer.name
        holder.aBinding.astrologerRating.text = astrologer.rating
        holder.aBinding.astrologerProfile.text = astrologer.profile
        holder.aBinding.astrologerCharges.text = astrologer.charges
        holder.aBinding.imageView.setImageResource(astrologer.image)
    }

    override fun getItemCount(): Int {
        return astrologers.size
    }
}