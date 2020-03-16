# CustomView-Example

![imge](https://img.shields.io/badge/ProjectType-SingleStudy-green) ![imge](https://img.shields.io/badge/Language-Kotlin-yellow) ![imge](https://img.shields.io/badge/Tools-AndroidStudio-blue)

안드로이드 스튜디오 커스텀뷰를 직접 제작해보고 적용해보기 위한 프로젝트입니다.

0. [소개](https://github.com/Jaesungchi/CustomView-Example#0-소개)

   (1) [커스텀뷰 란?](https://github.com/Jaesungchi/CustomView-Example#1-커스텀뷰-란)

   (2) [시작하기 전...](https://github.com/Jaesungchi/CustomView-Example#2-시작하기-전)

   (3) [오버라이드 메소드](https://github.com/Jaesungchi/CustomView-Example#3-오버라이드-메소드)

1. [ViewGroup에서 상속받아 만들기](https://github.com/Jaesungchi/CustomView-Example#1-ViewGroup에서-상속받아-만들기)

2. [View를 상속받아 구현하기](https://github.com/Jaesungchi/CustomView-Example#2-View를-상속받아-구현하기)

## 0. 소개

### (1) 커스텀뷰 란?

안드로이드 프레임워크에서 제공하는 기본 뷰로는 Button, TextView, EditText 등이 있습니다.

하지만 앱을 만들다 보면 원하는 기능을 프레임워크에서 제공하는 뷰로는 만들기 어렵거나 불가능 한 경우가 많습니다.

따라서 자신이 원하는 기능을 하는 View를 만들기 위해서는 커스텀뷰를 제작할 수 있어야 합니다.

구현하는 방식에는 2가지가 있습니다.

1. ViewGroup을 상속받고 만들어둔 레이아웃xml을 추가하는 경우.
2. View를 상속받아서 구현하는 경우.

이번 프로젝트에서는 View를 상속받고 TextView와 Button을 담아  타임라인으로 만들 수 있게 하겠습니다.

### (2) 시작하기 전...

커스텀뷰를 구현하는 방식은 위에서 언급한 2가지가 있습니다. 원하는 View클래스를 상속받는 것이며, 그 이후는 ViewGroup에서 상속 받나 그냥 View를 상속받나 동일합니다.

1. onDraw(), onMeasure(), onKeyDown()과 같이 on으로 시작하는 수퍼 클래스 메소드를 오버라이드합니다.
2. 새로만든 커스텀 뷰를 기존에 사용방식과 동일하게 xml 레이아웃 등에서 사용하면 됩니다.

### (3) 오버라이드 메소드

커스텀뷰를 만들기 위해 사용하는 메소드들 에서는 기본적으로 onDraw()와 onMeasure()이 있습니다.

onDraw()에서는 개발자가 원하는대로 구현할 수 있는 Canvas를 제공하며 onDraw()에서 그리고 싶은 내용을 그리면 됩니다.

onMeasure()은 뷰와 뷰에 포함된 컨텐츠의 사이즈를 측정해 측정된 width와 height를 결정합니다. onMeasure()은 measure(int,int)에 의해 호출되며 measure()에서 뷰의 사이즈를 측정하고 실제 측정된 사이즈가 수행되는 곳은 onMeasure()입니다. onMeasure()을 오버라이드 하는 경우엔 setMeasuredDimension(int,int)를 호출해 측정된 사이즈를 저장할 수 있도록 해야합니다.

## 1. ViewGroup에서 상속받아 만들기

ViewGroup에서 EditText를 상속받아 밑줄이 있는 EditText를 만들어 보겠습니다.

```kotlin
class LinedEditText : EditText {
    private val mRect : Rect
    private val mPaint : Paint
    constructor(context: Context, attrs : AttributeSet) : super(context, attrs) {
        mRect = Rect()
        mPaint = Paint()
        mPaint.style = Paint.Style.STROKE
        mPaint.color = 0x800000FF.toInt()
    }

    override fun onDraw(canvas: Canvas?) {
        val count = lineCount
        val r = mRect
        val paint  = mPaint
        for(i in 0 until count){
            val baseline = getLineBounds(i,r)
            canvas?.drawLine(r.left.toFloat(), (baseline).toFloat(), r.right.toFloat(), (baseline).toFloat(),paint)
        }
        super.onDraw(canvas)
    }
}
```

위의 코드에 설명을 더하면, 생성자를 통해 mRect와 mPaint객체를 초기화 하고 onDraw메소드를 통해 선을 그립니다.

lineCount를 통해 몇줄 인지를 가져오고, getLineBounds를 통해 그 줄의 좌표를 가져오며 canvas.drawLine을 통해 줄을 하나씩 그려주는 방식으로 그릴수 있습니다.

## 2. View를 상속받아 구현하기

자 이제 View를 상속받아 구현할 차례입니다. 

기본적으로 구현할 생성자와 onDraw를 구현합니다.

```kotlin
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
        super.onDraw(canvas)
    }
}
```



## Issue

```kotlin
java.lang.RuntimeException: Unable to start activity ComponentInfo{com.kotlin.jaesungchi.customview/com.kotlin.jaesungchi.customview.MainActivity}: android.view.InflateException: Binary XML file line #20 in com.kotlin.jaesungchi.customview:layout/activity_main: Binary XML file line #20 in com.kotlin.jaesungchi.customview:layout/activity_main: Error inflating class com.kotlin.jaesungchi.customview.ContentBox
```

```kotlin
constructor(context : Context) : super(context) {
    ...
}
```

커스텀뷰 제작 이슈 이다. 생성자를 Context만 있는 생성자가 있어서 발생한 에러이다. constructor를 오버로딩하거나 Parameter에 AttributeSet 변수를 추가한다.

```kotlin
constructor(context : Context) : super(context,null) {
    ...
}
constructor(context : Context, attrs : AttributeSet) : super(context, attrs) {
    ...
}
```

---