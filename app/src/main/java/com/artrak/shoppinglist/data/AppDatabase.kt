package com.artrak.shoppinglist.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ShopItemDbModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun shopListDao(): ShopListDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "shop_item.db"

        //Application - чтоб не утекал контекст активити
        fun getInstance(application: Application): AppDatabase {
            //Если к INSTANCE присвоенно значение, возвращаем:
            INSTANCE?.let {
                return it
            }
            //Сингентолы должны быть синхронизированы.
            // Если 2 потока одновременно вызвали getInstance(), в обоех потоках была сделана
            // проверка (см. выше) и INSTANCE == null, тогда ниже строчка пропустит только один поток,
            // а второй будет ждать
            synchronized(LOCK) {
                //проверка нужно, чтоб не переназначить INSTANCE в каждом потоке
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                )
                    .build()
                INSTANCE = db
                return db
            }
        }
    }
}