package com.artrak.shoppinglist.domain.usecase

import com.artrak.shoppinglist.domain.ShopItem
import com.artrak.shoppinglist.domain.ShopListRepository

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    suspend fun getShopItem(shopItemId: Int): ShopItem{
        return shopListRepository.getShopItem(shopItemId)
    }
}