package com.artrak.shoppinglist.domain.usecase

import androidx.lifecycle.LiveData
import com.artrak.shoppinglist.domain.ShopItem
import com.artrak.shoppinglist.domain.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}