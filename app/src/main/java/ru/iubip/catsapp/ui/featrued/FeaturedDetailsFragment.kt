package ru.iubip.catsapp.ui.featrued

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.iubip.catsapp.R
import ru.iubip.catsapp.ui.MainActivity
import ru.iubip.catsapp.usecases.FeaturedUsecase

class FeaturedDetailsFragment : Fragment(R.layout.fragment_featured_details) {

    private lateinit var usecase: FeaturedUsecase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        usecase = (activity as MainActivity).featuredUsecase
        return inflater.inflate(R.layout.fragment_featured_details, container, false)
    }
}