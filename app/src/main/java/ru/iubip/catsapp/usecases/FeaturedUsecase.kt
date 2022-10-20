package ru.iubip.catsapp.usecases

import ru.iubip.catsapp.data.domain.CatFeatured
import ru.iubip.catsapp.data.domain.CatFeaturedItem
import ru.iubip.catsapp.data.repository.FeaturedRepository
import java.net.URL
import java.util.*

class FeaturedUsecase(
    private val repository: FeaturedRepository
) {

    fun getPage(num: Int): List<CatFeaturedItem> {
        return repository.getPage(num)
    }

    fun getCat(id: Long): CatFeatured {
        return repository.getCat(id)
    }
}