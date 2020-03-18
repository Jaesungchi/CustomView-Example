package com.kotlin.jaesungchi.customview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class ContentBox @JvmOverloads constructor(
    context : Context, attrs: AttributeSet? = null, defStyleAttr : Int = 0
) : LinearLayout(context,attrs,defStyleAttr) {
    init{
        val v = LayoutInflater.from(context).inflate(R.layout.customlayout,this,false)
        addView(v)
    }

    private fun getAttrs(attrs : AttributeSet){
        val typedArray = context.obtainStyledAttributes(attrs,R.styleable.ContentBox)

        setTypeArray(typedArray)
    }

    private fun setTypeArray(typedArray : TypedArray){
        val bg_resID = typedArray.getResourceId(R.styleable.ContentBox_bg,R.drawable.ic_launcher_foreground)
        findViewById<LinearLayout>(R.id.CL).setBackgroundResource(bg_resID)

        val picture_resID = typedArray.getResourceId(R.styleable.ContentBox_picture,R.drawable.ic_launcher_foreground)
        findViewById<ImageView>(R.id.thumbnail).setImageResource(picture_resID)

        val textContent = typedArray.getString(R.styleable.ContentBox_content)
        findViewById<TextView>(R.id.text).setText(textContent)

        typedArray.recycle()
    }

    fun setBg(bg_resID : Int){
        findViewById<LinearLayout>(R.id.CL).setBackgroundResource(bg_resID)
    }

    fun setPicture(picture_resID : Int){
        findViewById<ImageView>(R.id.thumbnail).setImageResource(picture_resID)
    }

    fun setContent(textContent : String){
        findViewById<TextView>(R.id.text).setText(textContent)
    }
}