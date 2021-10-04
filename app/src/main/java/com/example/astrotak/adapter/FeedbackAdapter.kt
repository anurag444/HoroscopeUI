package com.example.astrotak.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.astrotak.databinding.FeedbackRowBinding
import com.example.astrotak.databinding.HoroscopeRowBinding
import com.example.astrotak.model.Feedback
import com.example.astrotak.model.Horoscope

class FeedbackAdapter(private var feedbacks: List<Feedback>) :
    RecyclerView.Adapter<FeedbackAdapter.FeedbackViewHolder>() {

    inner class FeedbackViewHolder(val fBinding: FeedbackRowBinding) :
        RecyclerView.ViewHolder(fBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedbackViewHolder {
        val binding =
            FeedbackRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return FeedbackViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedbackViewHolder, position: Int) {
        val feedback: Feedback = feedbacks[position]

        holder.fBinding.textView6.text = feedback.feedbackText
        holder.fBinding.username.text = feedback.username
        holder.fBinding.userLocation.text = feedback.location
    }

    override fun getItemCount(): Int {
        return feedbacks.size
    }
}