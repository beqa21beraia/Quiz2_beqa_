package com.example.mobileapplications22.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.mobileapplications22.databinding.FragmentHomeBinding
import com.example.mobileapplications22.adapters.ViewPagerAdapter

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val fragments = listOf(
            BlankFragment1(),
            PagerFragment.newInstance(),
            BlankFragment2(),
        )

        val adapter = ViewPagerAdapter(requireActivity(), fragments)
        binding.HomeViewPager.adapter = adapter

        binding.HomeViewPager.setCurrentItem(1, true)
    }
    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}