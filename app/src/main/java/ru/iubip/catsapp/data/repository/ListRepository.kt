package ru.iubip.catsapp.data.repository

import retrofit2.Call
import ru.iubip.catsapp.data.client.CatsApi
import ru.iubip.catsapp.data.domain.CatList
import ru.iubip.catsapp.data.domain.CatListItem
import java.net.URL
import java.util.*

class ListRepository(
    private val client: CatsApi
) {

    fun getPage(num: Int): Call<List<CatListItem>> {
        return client.getCatsList()
    }

    fun getCat(id: Long): CatList {
        return CatList(228, URL("https://i.scdn.co/image/ab67616d0000b273ab1b87d1256fa066cf24b52a"), 337, Date())
    }
}