package com.artrak.shoppinglist.domain.usecase

import com.artrak.shoppinglist.domain.ShopItem
import com.artrak.shoppinglist.domain.ShopListRepository

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    suspend fun editShopItem(shopItem: ShopItem){
        shopListRepository.editShopItem(shopItem)
    }
}