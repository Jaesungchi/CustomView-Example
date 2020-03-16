package com.kotlin.jaesungchi.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.TextView

class ContentBox : View {

    private val mPaint : Paint

    constructor(context : Context) : super(context,null) {
        mPaint = Paint()
        mPaint.color = Color.BLACK
    }
    constructor(context : Context, attrs : AttributeSet) : super(context, attrs) {
        mPaint = Paint()
        mPaint.color = Color.BLACK
    }
    override fun onDraw(canvas: Canvas?) {

        canvas?.drawText("test Data\ntextData", 0F,0F,mPaint)
        super.onDraw(canvas)
    }
}