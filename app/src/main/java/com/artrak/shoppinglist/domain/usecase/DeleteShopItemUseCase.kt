package com.artrak.shoppinglist.domain.usecase

import com.artrak.shoppinglist.domain.ShopItem
import com.artrak.shoppinglist.domain.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun deleteShopItem(shopItem: ShopItem){
        shopListRepository.deleteShopItem(shopItem)
    }
}