package com.artrak.shoppinglist.domain.usecase

import com.artrak.shoppinglist.domain.ShopItem
import com.artrak.shoppinglist.domain.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    suspend fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}