package ru.iubip.catsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.iubip.catsapp.R
import ru.iubip.catsapp.usecases.FeaturedUsecase

class FeaturedFragment : Fragment(R.layout.fragment_featured) {

    private lateinit var usecase: FeaturedUsecase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        usecase = (activity as MainActivity).featuredUsecase
        return inflater.inflate(R.layout.fragment_featured, container, false)
    }
}