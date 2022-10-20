package ru.iubip.catsapp.data.domain

import java.net.URL
import java.util.*

data class CatFeatured(
    val id: Long,
    val url: URL,
    val sub_id: Long,
    val created_at: Date,
)
