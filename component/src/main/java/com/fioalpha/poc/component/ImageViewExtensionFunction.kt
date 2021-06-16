package com.fioalpha.poc.component

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.get(url: String) {
    if (url.isEmpty()) return
    Picasso.get().load(url)
        .centerCrop()
        .into(this)
}
