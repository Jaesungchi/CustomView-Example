package com.kotlin.jaesungchi.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.widget.EditText

class LinedEditText : EditText {
    private val mRect : Rect
    private val mPaint : Paint

    //생성자를 통해 mRect와 mPaint 객체 생성
    constructor(context: Context, attrs : AttributeSet) : super(context, attrs) {
        mRect = Rect()
        mPaint = Paint()
        //Paint의 스타일과 색깔을 정한다.
        mPaint.style = Paint.Style.STROKE
        mPaint.color = 0x800000FF.toInt()
    }

    override fun onDraw(canvas: Canvas?) {
        //EditText안에 라인의 갯수를 저장한다.
        val count = lineCount
        val r = mRect
        val paint  = mPaint
        //라인의 갯수만큼 줄을 긋습니다.
        for(i in 0 until count){
            //베이스 라인의 좌표를 가져오고.
            val baseline = getLineBounds(i,r)
            //Paint객체를 그려냅니다.
            canvas?.drawLine(r.left.toFloat(),
                (baseline).toFloat(), r.right.toFloat(), (baseline).toFloat(),paint)
        }
        //마지막은 수퍼 메소드를 호출하는것으로 마무리 합니다.
        super.onDraw(canvas)
    }
}