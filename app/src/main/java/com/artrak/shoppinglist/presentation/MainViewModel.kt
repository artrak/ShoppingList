package com.artrak.shoppinglist.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artrak.shoppinglist.data.ShopListRepositoryImpl
import com.artrak.shoppinglist.domain.ShopItem
import com.artrak.shoppinglist.domain.usecase.DeleteShopItemUseCase
import com.artrak.shoppinglist.domain.usecase.EditShopItemUseCase
import com.artrak.shoppinglist.domain.usecase.GetShopListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)


    val shopList = getShopListUseCase.getShopList() // LiveData

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }
    }

    fun changeEnableState(shopItem: ShopItem) {
        viewModelScope.launch{
            val newItem = shopItem.copy(enable = !shopItem.enable)
            editShopItemUseCase.editShopItem(newItem)
        }
    }

    fun editing(shopItem: ShopItem) {
        Log.d("MainViewModel", "editing - ${shopItem.id} ${shopItem.name}")
    }
}