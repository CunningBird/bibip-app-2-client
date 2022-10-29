package ru.iubip.catsapp.ui.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.iubip.catsapp.R
import ru.iubip.catsapp.data.domain.CatListItem
import ru.iubip.catsapp.ui.MainActivity
import ru.iubip.catsapp.usecases.ListUsecase


class ListFragment : Fragment(R.layout.fragment_list), ListItemAdapter.OnCatListItemListener {

    private lateinit var usecase: ListUsecase

    val items: MutableList<CatListItem> = mutableListOf()

    val adapter = ListItemAdapter(items)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        usecase = (activity as MainActivity).listUsecase
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        view.findViewById<RecyclerView>(R.id.catsList).adapter = adapter
        adapter.setItemClickListener(this)
        return view
    }

    override fun onStart() {
        super.onStart()
        usecase.getPage(0).enqueue(object : Callback<List<CatListItem>> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<List<CatListItem>>, response: Response<List<CatListItem>>) {
                response.body()?.forEach {
                    items.add(it)
                }
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<CatListItem>>, t: Throwable) {
                println("Обосрался")
            }
        })
    }

    override fun onCatListItemClick(position: Int) {
        val bundle = Bundle()
        bundle.putString("cat_id", items[position].id)
        findNavController().navigate(R.id.action_listFragment_to_listDetailsFragment, bundle)
    }
}