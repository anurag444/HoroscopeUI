package com.example.astrotak.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.astrotak.databinding.ReportRowBinding
import com.example.astrotak.model.Report

class ReportAdapter(private var reports: List<Report>) :
    RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {

    inner class ReportViewHolder(val rBinding: ReportRowBinding) :
        RecyclerView.ViewHolder(rBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        val binding =
            ReportRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ReportViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        val report: Report = reports[position]
        holder.rBinding.charges.text = report.charges
        holder.rBinding.reportImage.setImageResource(report.image)
    }

    override fun getItemCount(): Int {
        return reports.size
    }
}