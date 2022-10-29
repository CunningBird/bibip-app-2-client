package ru.iubip.catsapp.data.client

import retrofit2.Call
import retrofit2.http.GET
import ru.iubip.catsapp.data.domain.CatListItem

interface CatsApi {

    @GET("images/search?limit=10")
    fun getCatsList(): Call<List<CatListItem>>
}