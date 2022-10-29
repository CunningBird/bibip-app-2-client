package ru.iubip.catsapp.ui.list

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.iubip.catsapp.R
import ru.iubip.catsapp.data.domain.CatListItem

class ListItemAdapter(private val list: MutableList<CatListItem>) :
    RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {

    private var onCatListItemClickListener: OnCatListItemListener? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val catName: TextView
        val catImage: ImageView
        init {
            catName = view.findViewById(R.id.catName)
            catImage = view.findViewById(R.id.catImage)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        holder.catImage.setOnClickListener {
            onCatListItemClickListener?.onCatListItemClick(position)
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.catName.text = list[position].id
        //viewHolder.catImage.setImageURI(Uri.parse(list[position].url))
    }

    override fun getItemCount() = list.size

    fun setItemClickListener(listener: OnCatListItemListener) {
        onCatListItemClickListener = listener
    }

    interface OnCatListItemListener {
        fun onCatListItemClick(position: Int)
    }
}