package com.marangoz.hepsiburada.ui.homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.marangoz.hepsiburada.repository.Repository

class HomePageViewModelFactory (private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomePageViewModel(repository) as T
    }

}