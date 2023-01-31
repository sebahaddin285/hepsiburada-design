package com.marangoz.hepsiburada.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.marangoz.hepsiburada.R
import com.marangoz.hepsiburada.adapter.CategoryMainAdapter
import com.marangoz.hepsiburada.adapter.CategoryMainSubAdapter
import com.marangoz.hepsiburada.adapter.HomePageAdapter
import com.marangoz.hepsiburada.databinding.FragmentCategoryBinding
import com.marangoz.hepsiburada.repository.Repository
import com.marangoz.hepsiburada.ui.homepage.HomePageViewModel
import com.marangoz.hepsiburada.ui.homepage.HomePageViewModelFactory

class CategoryFragment : Fragment() {

    private lateinit var _binding: FragmentCategoryBinding
    private lateinit var viewModel: CategoryFragmentViewModel
    private val repo = Repository()
    val viewModelFactory by lazy { CategoryFragmentViewModelFactory(repo) }
    var isDown: Boolean = true
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(CategoryFragmentViewModel::class.java)

        val adap = CategoryMainAdapter(requireContext(), { position -> adapterPosition(position) },
            { mainId -> categorySub(mainId) })
            val adap1 = CategoryMainSubAdapter (requireContext())
        viewModel.categoryMainList.observe(viewLifecycleOwner) {
            adap.setList(it)
        }
        viewModel.categoryMainAllData()

        viewModel.categorySubList.observe(viewLifecycleOwner) {
            adap1.setLists(it)
        }
        categorySub(1)

        _binding.mainRv.apply {
            setHasFixedSize(true)
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            adapter = adap
        }
        _binding.childRv.apply {
            setHasFixedSize(true)
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            adapter = adap1
        }
        return _binding.root
    }

    fun adapterPosition(position: Int) {
        if (isDown) {
            _binding.mainRv.postDelayed({
                _binding.mainRv.scrollToPosition(position + 3)
            }, 100)
            if (_binding.mainRv.adapter!!.itemCount - 2 == position) {
                isDown = false
            }
        } else {
            _binding.mainRv.postDelayed({
                _binding.mainRv.scrollToPosition(position - 3)
            }, 100)
            if (_binding.mainRv.adapter!!.itemCount - 7 == position) {
                isDown = true
            }
        }
    }

    fun categorySub(mainId: Int) {
        viewModel.categorySubAllData(mainId)
    }


}