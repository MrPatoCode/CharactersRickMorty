package com.paulinoeme.charactersrickmorty.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paulinoeme.charactersrickmorty.R
import com.paulinoeme.charactersrickmorty.data.model.Result

class RecyclerViewAdapter(private val info: List<Result>) :
    RecyclerView.Adapter<RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecyclerViewHolder(
            layoutInflater
                .inflate(R.layout.item_character, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return info.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val item = info[position]
        holder.bind(item)
    }
}