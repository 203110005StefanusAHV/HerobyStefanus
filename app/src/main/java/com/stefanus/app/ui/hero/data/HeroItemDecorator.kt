package com.stefanus.app.ui.hero.data

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.State

// pola desain yang memungkinkan penambahan fungsionalitas baru ke objek yang sudah ada tanpa
// mengubah strukturnya dan tanpa memengaruhi perilaku objek lain dari kelas yang sama.
class HeroItemDecorator : RecyclerView.ItemDecoration() {

  private var spanCount = 2
  private var spacing = 30

  override fun getItemOffsets(
    outRect: Rect,
    view: View,
    parent: RecyclerView,
    state: State
  ) {
    val position = parent.getChildAdapterPosition(view)
    val column = position % spanCount
    outRect.left = spacing - column * spacing / spanCount
    outRect.right = (column + 1) * spacing / spanCount
    if (position < spanCount) {
      outRect.top = spacing + 200
    }
    outRect.bottom = spacing
  }
}