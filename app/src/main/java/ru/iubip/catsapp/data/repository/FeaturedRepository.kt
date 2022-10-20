package ru.iubip.catsapp.data.repository

import ru.iubip.catsapp.data.domain.CatFeatured
import ru.iubip.catsapp.data.domain.CatFeaturedItem
import java.net.URL
import java.util.*

class FeaturedRepository {
    fun getPage(num: Int): List<CatFeaturedItem> {
        return listOf(
            CatFeaturedItem(228, URL("https://i.scdn.co/image/ab67616d0000b273ab1b87d1256fa066cf24b52a")),
            CatFeaturedItem(228, URL("https://i.scdn.co/image/ab67616d0000b273ab1b87d1256fa066cf24b52a"))
        )
    }

    fun getCat(id: Long): CatFeatured {
        return CatFeatured(228, URL("https://i.scdn.co/image/ab67616d0000b273ab1b87d1256fa066cf24b52a"), 337, Date())
    }
}