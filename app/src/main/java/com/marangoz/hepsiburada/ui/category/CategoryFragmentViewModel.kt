package com.marangoz.hepsiburada.ui.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marangoz.hepsiburada.model.CategoryMain
import com.marangoz.hepsiburada.model.CategorySub
import com.marangoz.hepsiburada.model.Products
import com.marangoz.hepsiburada.repository.Repository
import kotlinx.coroutines.launch

class CategoryFragmentViewModel (val repository: Repository) : ViewModel() {
    val categoryMainList: MutableLiveData<List<CategoryMain>> = MutableLiveData()
    val categorySubList: MutableLiveData<List<CategorySub>> = MutableLiveData()


    fun categoryMainAllData() {
        viewModelScope.launch {
            categoryMainList.value = repository.categoryMainAllData()
        }
    }
    fun categorySubAllData(mainId:Int) {
        viewModelScope.launch {
            categorySubList.value = repository.categorySubAllData(mainId)
        }
    }


}