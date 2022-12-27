package com.stefanus.app.util

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stefanus.app.data.api.model.Hero
import com.stefanus.app.ui.hero.data.HeroAdapter

@BindingAdapter("app:isVisible")
fun bindVisibility(
  view: View,
  visible: Boolean
) {
  view.visibility = when {
    visible -> View.VISIBLE
    else -> View.GONE
  }
}

//sintak ini digunakan untuk menampikan data dari recycleView berupa list hero
@BindingAdapter("app:bindHeroes")
fun bindHeroes(
  view: RecyclerView,
  items: List<Hero>?
) {
  val adapter = view.adapter
  if (adapter is HeroAdapter && items != null) {
    adapter.submitList(items)
    view.post { view.scrollToPosition(0) }
  }
}