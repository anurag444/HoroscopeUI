package com.example.astrotak.navigationfragments

import android.R.attr
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.astrotak.R
import com.example.astrotak.adapter.AstrologerDetailAdapter
import com.example.astrotak.databinding.FragmentTalkToAstrologerBinding
import com.example.astrotak.model.AstrologerDetail
import android.app.Dialog
import android.view.Window
import androidx.appcompat.app.AlertDialog

import com.example.astrotak.MainActivity
import com.example.astrotak.databinding.FilterLayoutBinding
import android.R.attr.data
import android.widget.SearchView
import java.util.*
import kotlin.Comparator


class TalkToAstrologerFragment : Fragment() {

    private var _binding: FragmentTalkToAstrologerBinding? = null
    private val binding get() = _binding!!
    private lateinit var astrologers:List<AstrologerDetail>
    private lateinit var astrologerAdapter: AstrologerDetailAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTalkToAstrologerBinding.inflate(inflater, container, false)
        val view = binding.root

        seUpAstrologersRV()

        setUpFilter()

        binding.search.setOnClickListener {
            binding.searchView.visibility = View.VISIBLE
        }


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                astrologerAdapter.filter.filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                astrologerAdapter.filter.filter(newText)
                return true
            }
        })

        return view
    }

    private fun setUpFilter() {
        binding.filter.setOnClickListener {
            binding.searchView.visibility = View.GONE
            val dialog = Dialog(requireContext())
            val dialogBinding = FilterLayoutBinding.inflate(LayoutInflater.from(context))
            dialog.setContentView(dialogBinding.root)
            dialog.setCancelable(false)

            dialogBinding.expHl.setOnClickListener {
                sortListExp(false)
                dialog.dismiss()
            }
            dialogBinding.expLh.setOnClickListener {
                sortListExp(true)
                dialog.dismiss()
            }
            dialogBinding.priceHl.setOnClickListener {
                sortListPrice(false)
                dialog.dismiss()
            }
            dialogBinding.priceLh.setOnClickListener {
                sortListPrice(true)
                dialog.dismiss()
            }

            dialog.show()
        }
    }

    private fun sortListExp(asc:Boolean) {
        val comparator = compareBy<AstrologerDetail>{it.exp}
        astrologers = astrologers.sortedWith(comparator)
        if (!asc) astrologers = astrologers.reversed()
        astrologerAdapter.setData(astrologers)
    }

    private fun sortListPrice(asc:Boolean) {
        val comparator = compareBy<AstrologerDetail>{it.charges}
        astrologers = astrologers.sortedWith(comparator)
        if (!asc) astrologers = astrologers.reversed()
        astrologerAdapter.setData(astrologers)
    }

    private fun seUpAstrologersRV() {
        astrologers= listOf(
            AstrologerDetail(R.drawable.bejan, "Arvind Shukla", "Vedic Astrology, Face Reading, Tarot", "Hindi, English", 1000, 15),
            AstrologerDetail(R.drawable.sri, "Ashwani Mangal", "Coffe Cup Reading, Vastu Astrology, Vedic Astrology", "Hindi, English", 900, 14),
            AstrologerDetail(R.drawable.report3, "Dr. Sripati Tripati", "Coffe Cup Reading, Vedic Astrology, Face Reading, Tarot", "Hindi, English", 800, 13),
            AstrologerDetail(R.drawable.report1, "Acharaya Arvind Mishra", "Vastu Astrology, Vedic Astrology, Face Reading, Tarot", "Hindi, English", 550, 23),
            AstrologerDetail(R.drawable.report2, "Shailendra Pandey", "Vedic Astrology, Face Reading, Tarot", "Hindi, English", 450, 30),
            AstrologerDetail(R.drawable.harilal, "Harilal Upadhyay", "Coffe Cup Reading, Vastu Astrology, Vedic Astrology, Face Reading, Tarot", "Hindi, English", 2000, 4),
            AstrologerDetail(R.drawable.bejan, "Bejan Daruwala", "Coffe Cup Reading, Vastu Astrology, Vedic Astrology, Face Reading, Tarot", "Hindi, English", 650, 21),
            AstrologerDetail(R.drawable.sri, "Brahma Gopal Bhadury", "Coffe Reading, Vastu Astrology, Vedic Astrology, Face Reading, Tarot", "Hindi, English", 1200, 12),
            AstrologerDetail(R.drawable.report3, "Arvind Shukla", "Coffe Cup Reading, Vastu Astrology, Vedic Astrology, Face Reading, Tarot", "Hindi, English", 890, 16),
        )

        astrologerAdapter = AstrologerDetailAdapter()
        astrologerAdapter.setData(astrologers)

        binding.astrologersList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = astrologerAdapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}