package com.artrak.shoppinglist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artrak.shoppinglist.data.ShopListRepositoryImpl
import com.artrak.shoppinglist.domain.ShopItem
import com.artrak.shoppinglist.domain.usecase.DeleteShopItemUseCase
import com.artrak.shoppinglist.domain.usecase.EditShopItemUseCase
import com.artrak.shoppinglist.domain.usecase.GetShopListUseCase

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }
}