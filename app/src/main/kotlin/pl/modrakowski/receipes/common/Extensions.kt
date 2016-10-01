package pl.modrakowski.receipes.common

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) {
    Glide.with(context).load(url).crossFade().into(this)
}

fun applyDefaultForeground(view: FrameLayout?) {
    if (view != null) {
        view.foreground = obtainDefaultBackground(view)
    } else {
        Log.e("applyDefaultBackground", "Can't do applyDefaultBackground.")
    }
}

fun applyDefaultBackground(view: View?) {
    if (view != null) {
        view.background = obtainDefaultBackground(view)
    } else {
        Log.e("applyDefaultBackground", "Can't do applyDefaultBackground.")
    }
}

fun obtainDefaultBackground(view: View): Drawable {
    val attrs = intArrayOf(android.R.attr.selectableItemBackground)
    val ta = view.context.obtainStyledAttributes(attrs)
    val drawableFromTheme = ta.getDrawable(0)
    ta.recycle()
    return drawableFromTheme;
}
