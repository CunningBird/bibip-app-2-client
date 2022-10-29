package ru.iubip.catsapp.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.iubip.catsapp.R
import ru.iubip.catsapp.ui.MainActivity
import ru.iubip.catsapp.usecases.ListUsecase

class ListDetailsFragment : Fragment(R.layout.fragment_list_details) {

    private lateinit var usecase: ListUsecase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        usecase = (activity as MainActivity).listUsecase
        return inflater.inflate(R.layout.fragment_list_details, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = this.arguments

        println(bundle?.getString("cat_id"))
    }
}