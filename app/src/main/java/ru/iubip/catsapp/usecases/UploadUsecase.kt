package ru.iubip.catsapp.usecases

import ru.iubip.catsapp.data.repository.FeaturedRepository
import ru.iubip.catsapp.data.repository.UploadRepository
import java.io.File

class UploadUsecase(
    private val uploadRepository: UploadRepository
) {

    fun uploadViaGallery(file: File) {
        uploadRepository.uploadViaGallery(file)
    }

    fun uploadViaCamera(file: File) {
        uploadRepository.uploadViaCamera(file)
    }
}