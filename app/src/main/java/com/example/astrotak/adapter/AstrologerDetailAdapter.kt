package com.example.astrotak.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.astrotak.databinding.FullAstrologerRowBinding
import com.example.astrotak.model.AstrologerDetail
import java.util.*
import kotlin.collections.ArrayList

class AstrologerDetailAdapter() :
    RecyclerView.Adapter<AstrologerDetailAdapter.AstrologerViewHolder>(), Filterable {
    private var astrologers: List<AstrologerDetail> = ArrayList()
    private var tempList: List<AstrologerDetail> = ArrayList()

    inner class AstrologerViewHolder(val aBinding: FullAstrologerRowBinding) :
        RecyclerView.ViewHolder(aBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AstrologerViewHolder {
        val binding =
            FullAstrologerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return AstrologerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AstrologerViewHolder, position: Int) {
        val astrologer: AstrologerDetail = astrologers[position]

        holder.aBinding.astrologerName.text = astrologer.name
        holder.aBinding.skills.text = astrologer.skills
        holder.aBinding.language.text = astrologer.languages
        holder.aBinding.experience.text = astrologer.exp.toString() + " Years"
        holder.aBinding.charges.text = "₹${astrologer.charges}/min"
        holder.aBinding.astrologerImage.setImageResource(astrologer.image)
    }

    override fun getItemCount(): Int {
        return astrologers.size
    }

    fun setData(astrologers: List<AstrologerDetail>){
        this.astrologers = astrologers
        tempList = astrologers
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object :Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {

                val filterResults = FilterResults()
                if (constraint == null || constraint.isEmpty()){
                    filterResults.count = tempList.size
                    filterResults.values = tempList
                }else{

                    val searchChr = constraint.toString()
                    val astrologers = ArrayList<AstrologerDetail>()

                    for (item in tempList){
                        if (item.name.contains(searchChr, ignoreCase = true)){
                            astrologers.add(item)
                        }
                    }

                    filterResults.count = astrologers.size
                    filterResults.values = astrologers
                }

                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                astrologers = results!!.values as List<AstrologerDetail>
                notifyDataSetChanged()
            }

        }
    }

}