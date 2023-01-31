package com.marangoz.hepsiburada.ui.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.marangoz.hepsiburada.repository.Repository
import com.marangoz.hepsiburada.ui.homepage.HomePageViewModel

class CategoryFragmentViewModelFactory (private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CategoryFragmentViewModel(repository) as T
    }

}