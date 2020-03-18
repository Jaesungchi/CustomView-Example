package com.kotlin.jaesungchi.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val masterLayout = findViewById<LinearLayout>(R.id.masterLayout)
        val newContent = ContentBox(this)
        newContent.setContent("안녕하세요 반갑습니다.")
        newContent.setPicture(R.drawable.background2)
        masterLayout.addView(newContent)
        val newContent2 = ContentBox(this)
        newContent2.setPicture(R.drawable.face2)
        newContent2.setContent("반가워요 학이하이!")
        masterLayout.addView(newContent2)
    }
}
