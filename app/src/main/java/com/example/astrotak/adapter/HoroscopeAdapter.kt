package com.example.astrotak.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.astrotak.databinding.HoroscopeRowBinding
import com.example.astrotak.model.Horoscope

class HoroscopeAdapter(private var horoscopes: List<Horoscope>) :
    RecyclerView.Adapter<HoroscopeAdapter.HoroscopeViewHolder>() {

    inner class HoroscopeViewHolder(val hBinding: HoroscopeRowBinding) :
        RecyclerView.ViewHolder(hBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        val binding =
            HoroscopeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HoroscopeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        val horoscope: Horoscope = horoscopes[position]

        holder.hBinding.horoscopeName.text = horoscope.sign
        holder.hBinding.horoscopeTime.text = horoscope.timeline
        holder.hBinding.horoscopeImage.setImageResource(horoscope.image)
    }

    override fun getItemCount(): Int {
        return horoscopes.size
    }
}