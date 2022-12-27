package com.stefanus.app.ui.hero.data

import androidx.recyclerview.widget.DiffUtil
import com.stefanus.app.data.api.model.Hero

//class abstrak dan digunakan sebagai class callback oleh DiffUtil saat menghitung
// selisih antara dua daftar. Ini memiliki empat metode abstrak dan satu metode non-abstrak.
class HeroDiffUtilCallback : DiffUtil.ItemCallback<Hero>() {
  override fun areItemsTheSame(
    oldItem: Hero,
    newItem: Hero
  ): Boolean = oldItem.id == newItem.id

  override fun areContentsTheSame(
    oldItem: Hero,
    newItem: Hero
  ): Boolean = oldItem.name == newItem.name
}