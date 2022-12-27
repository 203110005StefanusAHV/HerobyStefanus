package com.stefanus.app.ui.hero.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stefanus.app.data.api.model.Hero
import com.stefanus.app.databinding.HeroListItemBinding
import javax.inject.Inject

//berisi class yang  menyediakan akses ke item data dan juga bertanggung jawab untuk
// membuat sebuah View pada setiap item dalam kumpulan data.
class HeroAdapter @Inject constructor() : ListAdapter<Hero, HeroViewHolder>(HeroDiffUtilCallback()) {

  lateinit var callback: (product: Hero) -> Unit

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): HeroViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = HeroListItemBinding.inflate(inflater, parent, false)
    return HeroViewHolder(binding, callback)
  }

  override fun onBindViewHolder(
    holder: HeroViewHolder,
    position: Int
  ) {
    holder.bind(getItem(position))
  }
}

