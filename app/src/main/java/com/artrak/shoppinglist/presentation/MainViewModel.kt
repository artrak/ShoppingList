package com.artrak.shoppinglist.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.artrak.shoppinglist.data.ShopListRepositoryImpl
import com.artrak.shoppinglist.domain.ShopItem
import com.artrak.shoppinglist.domain.usecase.DeleteShopItemUseCase
import com.artrak.shoppinglist.domain.usecase.EditShopItemUseCase
import com.artrak.shoppinglist.domain.usecase.GetShopListUseCase

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList() // LiveData

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enable = !shopItem.enable)
        editShopItemUseCase.editShopItem(newItem)
    }

    fun editing(shopItem: ShopItem) {
        Log.d("MainViewModel", "editing - ${shopItem.id} ${shopItem.name}")
    }
}