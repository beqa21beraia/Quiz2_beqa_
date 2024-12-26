package com.example.mobileapplications22.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileapplications22.R
import com.example.mobileapplications22.Story
import com.example.mobileapplications22.adapters.RcViewStoryAdapter
import com.example.mobileapplications22.adapters.ViewPagerAdapter
import com.example.mobileapplications22.databinding.FragmentProfileBinding
import com.example.mobileapplications22.profile.fragments.BlankFragment1
import com.example.mobileapplications22.profile.fragments.BlankFragment2
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding

    private lateinit var storyAdapter: RcViewStoryAdapter

    private val fList = listOf(
        BlankFragment1.newInstance(), BlankFragment2.newInstance()
    )

    private val tList = listOf("POSTS","TAGGED")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRV()
        initVP()
    }

    private fun initRV() = with(binding){
        rcViewProfile.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        storyAdapter = RcViewStoryAdapter()
        rcViewProfile.adapter = storyAdapter
        val list = listOf(
            Story("","qweyuiop"),
            Story("","09876543"),
            Story("","oiuytrew")
        )
        storyAdapter.submitList(list)
    }

    private fun initVP() = with(binding){
        val adapter = ViewPagerAdapter(activity as FragmentActivity, fList)
        vp.adapter = adapter
        TabLayoutMediator(tabLayout, vp){ tab, position ->
            tab.text = tList[position]
        }.attach()
    }

    companion object {
          @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}