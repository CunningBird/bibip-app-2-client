package ru.iubip.catsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.iubip.catsapp.R
import ru.iubip.catsapp.usecases.UploadUsecase

class UploadFragment : Fragment(R.layout.fragment_upload) {

    private lateinit var usecase: UploadUsecase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        usecase = (activity as MainActivity).uploadUsecase
        return inflater.inflate(R.layout.fragment_upload, container, false)
    }
}