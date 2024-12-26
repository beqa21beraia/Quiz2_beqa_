package com.example.mobileapplications22

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mobileapplications22.databinding.FragmentMainBinding
import com.example.mobileapplications22.home.HomeFragment
import com.example.mobileapplications22.profile.ProfileFragment

class MainFragment : Fragment() {

    private lateinit var binding : FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadFragment(HomeFragment.newInstance())
        listeners()
    }

    private fun listeners() = with(binding){
        bottomNavMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    loadFragment(HomeFragment.newInstance())
                    true
                }
                R.id.search -> {
                    Toast.makeText(requireContext(), "coming soon!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.addPost -> {
                    Toast.makeText(requireContext(), "coming soon!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.reels -> {
                    Toast.makeText(requireContext(), "coming soon!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.profile -> {
                    loadFragment(ProfileFragment.newInstance())
                    true
                }
                else -> {
                    loadFragment(HomeFragment.newInstance())
                    true
                }
            }
        }
    }

    private fun loadFragment(f: Fragment){
        parentFragmentManager.beginTransaction()
            .replace(R.id.container,f)
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}