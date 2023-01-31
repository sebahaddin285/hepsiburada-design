package com.marangoz.hepsiburada.ui.homepage

import android.annotation.SuppressLint
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.os.CancellationSignal
import android.os.CountDownTimer
import android.view.*
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.marangoz.hepsiburada.R
import com.marangoz.hepsiburada.adapter.HomePageAdapter
import com.marangoz.hepsiburada.adapter.ViewPagerAdapter
import com.marangoz.hepsiburada.databinding.FragmentHomeBinding
import com.marangoz.hepsiburada.repository.Repository
import java.util.function.Consumer


class HomeFragment : Fragment() {

    private lateinit var _binding : FragmentHomeBinding
    private lateinit var viewModel: HomePageViewModel
    private val repo = Repository()
    val viewModelFactory by lazy { HomePageViewModelFactory(repo) }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)

        val images = listOf(
            R.drawable.f1,
            R.drawable.f2,
            R.drawable.f3,
            R.drawable.f4,
            R.drawable.f5,
            R.drawable.f6,
        )
        val viewPagerAdapter by lazy { ViewPagerAdapter(images,requireContext()) }
        _binding.viewPager.adapter = viewPagerAdapter


        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(HomePageViewModel::class.java)

        val adap = HomePageAdapter(requireContext())
        viewModel.productList.observe(viewLifecycleOwner){
            adap.setList(it)

        }
        viewModel.allData()

        _binding.rv.apply {
            setHasFixedSize(true)
            layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)
            adapter = adap
        }

        _binding.locationButton.setOnClickListener(){
            findNavController().navigate(R.id.goToBottomSheet)
        }



        return _binding.root
    }



}