package com.marangoz.hepsiburada.ui.homepage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marangoz.hepsiburada.model.Products
import com.marangoz.hepsiburada.repository.Repository
import kotlinx.coroutines.launch

class HomePageViewModel(val repository: Repository) : ViewModel() {
    val productList: MutableLiveData<List<Products>> = MutableLiveData()

    fun allData() {
        viewModelScope.launch {
            productList.value = repository.allData()
        }
    }



}