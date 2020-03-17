package com.kotlin.jaesungchi.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView

class ContentBox @JvmOverloads constructor(
    context : Context, attrs: AttributeSet? = null, defStyleAttr : Int = 0
) : View(context, attrs, defStyleAttr) {
    init{
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}