package ru.iubip.catsapp.usecases

import retrofit2.Call
import ru.iubip.catsapp.data.domain.CatList
import ru.iubip.catsapp.data.domain.CatListItem
import ru.iubip.catsapp.data.repository.ListRepository
import java.net.URL
import java.util.*

class ListUsecase(
    private val listRepository: ListRepository
) {

    fun getPage(num: Int): Call<List<CatListItem>> {
        return listRepository.getPage(num)
    }

    fun getCat(id: Long): CatList {
        return listRepository.getCat(id)
    }
}