package ru.iubip.catsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.iubip.catsapp.R
import ru.iubip.catsapp.usecases.ListUsecase

class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var usecase: ListUsecase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        usecase = (activity as MainActivity).listUsecase
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onStart() {
        super.onStart()
        val list = usecase.getPage(0).execute()
    }
}