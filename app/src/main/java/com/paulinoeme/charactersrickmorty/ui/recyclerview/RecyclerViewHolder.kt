package com.paulinoeme.charactersrickmorty.ui.recyclerview

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.paulinoeme.charactersrickmorty.R.drawable
import com.paulinoeme.charactersrickmorty.data.model.Result
import com.paulinoeme.charactersrickmorty.databinding.ItemCharacterBinding
import com.squareup.picasso.Picasso

class RecyclerViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemCharacterBinding.bind(view)
    fun bind(info: Result){
        intoImage(info.image)
        binding.tvName.text = info.name
        binding.tvSpecies.text = info.species
        binding.tvGender.text = info.gender
        status(info.status)
    }

    private fun intoImage(image: String){
        Picasso.get()
            .load(image)
            .into(binding.ivCharacter)
    }

    @SuppressLint("ResourceAsColor")
    private fun status(status: String){
        when (status) {
            "Alive" -> binding.vStatus.setBackgroundResource(drawable.life_icon)
            "unknown" -> binding.vStatus.setBackgroundResource(drawable.unknown_icon)
            "Dead" -> binding.vStatus.setBackgroundResource(drawable.dead_icon)
        }
    }
}