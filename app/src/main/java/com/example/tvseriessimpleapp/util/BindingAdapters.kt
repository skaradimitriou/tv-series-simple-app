package com.example.tvseriessimpleapp.util

import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.tvseriessimpleapp.R

@BindingAdapter("loadImageUrl")
fun ImageView.loadImageUrl(url: String?) = url?.let {
    Glide.with(context).load(url).placeholder(R.mipmap.tv_series_logo).into(this)
} ?: run {
    setImageResource(R.mipmap.tv_series_logo)
}

@BindingAdapter("loadHtmlText")
fun TextView.loadHtmlText(htmlText: String?) {
    text = HtmlCompat.fromHtml(htmlText ?: "", HtmlCompat.FROM_HTML_MODE_COMPACT)
}

@BindingAdapter("setShowRating")
fun RatingBar.setShowRating(rate: Double) {
    rating = (rate / 2).toFloat()
}