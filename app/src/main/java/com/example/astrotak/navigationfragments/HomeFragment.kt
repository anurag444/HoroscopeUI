package com.example.astrotak.navigationfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.astrotak.R
import com.example.astrotak.adapter.*
import com.example.astrotak.databinding.FragmentHomeBinding
import com.example.astrotak.model.Astrologer
import com.example.astrotak.model.Feedback
import com.example.astrotak.model.Horoscope
import com.example.astrotak.model.Report

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var bannerAdapter: BannerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)

        setUpBanner()

        setUpHoroscopeRV()

        setUpAstrologerRV()

        val questions = arrayOf<String?>("Career", "Love",
            "Hobby", "Relationships",
            "Work")
        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            requireContext(),
            android.R.layout.simple_spinner_item,
            questions)
        ad.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item)
        binding.categoryDropdown.adapter = ad




        setUpReportRV()

        setUpFeedbackRV()

        return binding.root
    }

    private fun setUpFeedbackRV() {
        val feedbacks: List<Feedback> = listOf(
            Feedback("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", "Gagan Deep Agarwal", "Bhopal, India"),
            Feedback("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", "Anurag", "Chandigarh, India"),
            Feedback("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", "Gagan Deep Agarwal", "Pune, India"),
        )

        binding.feedbackList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = FeedbackAdapter(feedbacks)
        }
    }

    private fun setUpReportRV() {
        val reports: List<Report> = listOf(
            Report(R.drawable.report1, "₹999"),
            Report(R.drawable.report2, "₹399"),
            Report(R.drawable.report3, "₹599"),
            Report(R.drawable.report1, "₹1999/min"),
            Report(R.drawable.report2, "₹399/min"),
        )

        binding.reportsList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = ReportAdapter(reports)
        }
    }

    private fun setUpAstrologerRV() {
        val astrologers: List<Astrologer> = listOf(
            Astrologer(R.drawable.bejan, "Bejan Daruwala", "4.3", "Coffe Cup Reading", "₹500/min"),
            Astrologer(R.drawable.sri, "Brahma Gopal Bhadury", "4.4", "Vastu", "₹400/min"),
            Astrologer(R.drawable.harilal, "Harilal Upadhyay", "4.9", "Coffe Cup Reading", "₹450/min"),
            Astrologer(R.drawable.bejan, "Bejan Daruwala", "4.3", "Coffe Cup Reading", "₹500/min"),
        )

        binding.astrologerList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = AstrologerAdapter(astrologers)
        }
    }

    private fun setUpHoroscopeRV() {
        val horoscopes:List<Horoscope> = listOf(
            Horoscope(R.drawable.aquarius, "Aries", "Jan 20 - Feb 18"),
            Horoscope(R.drawable.pisces, "Pisces", "Feb 19 - Mar 20"),
            Horoscope(R.drawable.aries, "Aries", "Mar 21 - Apr 19"),
            Horoscope(R.drawable.taurus, "Taurus", "Apr 20 - May 20"),
            Horoscope(R.drawable.gemini, "Gemini", "May 21 - Jun 20"),
            Horoscope(R.drawable.cancer, "Cancer", "Jun 21 - Jul 22"),
            Horoscope(R.drawable.leo, "Leo", "Jul 23 - Aug 22"),
            Horoscope(R.drawable.virgo, "Virgo", "Aug 23 - Sept 22"),
            Horoscope(R.drawable.libra, "Libra", "Sept 23 - Oct 22"),
            Horoscope(R.drawable.scorpio, "Scorpio", "Oct 23 - Nov 21"),
            Horoscope(R.drawable.sagittarius, "Sagittarius", "Nov 22 - Dec 21"),
            Horoscope(R.drawable.capricorn, "Capricorn", "Dec 22 - Jan 19"),
        )

        val horoscopeAdapter = HoroscopeAdapter(horoscopes)

        binding.horoscopeList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = horoscopeAdapter
        }
    }

    private fun setUpBanner() {
        val images = listOf(
            R.drawable.banner4,
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3,
        )
        bannerAdapter = BannerAdapter(images)


        binding.viewPager.adapter = bannerAdapter

        binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)


            }
        })
    }

}