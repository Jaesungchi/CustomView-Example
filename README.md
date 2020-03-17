# CustomView-Example

![imge](https://img.shields.io/badge/ProjectType-SingleStudy-green) ![imge](https://img.shields.io/badge/Language-Kotlin-yellow) ![imge](https://img.shields.io/badge/Tools-AndroidStudio-blue)

안드로이드 스튜디오 커스텀뷰를 직접 제작해보고 적용해보기 위한 프로젝트입니다.

0. [소개](https://github.com/Jaesungchi/CustomView-Example#0-소개)

    (1) [커스텀뷰 란?](https://github.com/Jaesungchi/CustomView-Example#1-커스텀뷰-란)

    (2) [커스텀뷰 LifeCycle](https://github.com/Jaesungchi/CustomView-Example#2-커스텀뷰-LifeCycle)

    (3) [오버라이드 메소드](https://github.com/Jaesungchi/CustomView-Example#3-오버라이드-메소드)

1. [Layout xml파일 생성](https://github.com/Jaesungchi/CustomView-Example#1-layout-xml파일-생성)

2. [attrs xml파일 생성](https://github.com/Jaesungchi/CustomView-Example#2-attrs-xml파일-생성)

## 0. 소개

### (1) 커스텀뷰 란?

안드로이드 프레임워크에서 제공하는 기본 뷰로는 Button, TextView, EditText 등이 있습니다.

하지만 앱을 만들다 보면 원하는 기능을 프레임워크에서 제공하는 뷰로는 만들기 어렵거나 불가능 한 경우가 많습니다.

따라서 자신이 원하는 기능을 하는 View를 만들기 위해서는 커스텀뷰를 제작할 수 있어야 합니다.

이번 프로젝트에서는 TextView와 Image를 담아  타임라인으로 만들 수 있게 하겠습니다.

### (2) 커스텀뷰 LifeCycle

Constructor -> onAttachedToWindow() -> measure() -> onMeasure() -> layout() -> onLayout()

-> dispatchDraw() -> draw() -> onDraw()  순으로 그려진다.

간단하게 설명하자면

- onAttachedToWindow()  : View가 Window에 연결되는 단계로, 이 단계부터 id로 접근이 가능.
- onMeasure() : View의 사이즈를 측정한다.
- onLayout() : 개별 자식View들의 사이즈 및 위치를 할당.
- onDraw() : View를 그립니다.

### (3) 오버라이드 메소드

커스텀뷰를 만들기 위해 사용하는 메소드들 에서는 기본적으로 onDraw()와 onMeasure()이 있습니다.

onDraw()에서는 개발자가 원하는대로 구현할 수 있는 Canvas를 제공하며 onDraw()에서 그리고 싶은 내용을 그리면 됩니다.

onMeasure()은 뷰와 뷰에 포함된 컨텐츠의 사이즈를 측정해 측정된 width와 height를 결정합니다. onMeasure()은 measure(int,int)에 의해 호출되며 measure()에서 뷰의 사이즈를 측정하고 실제 측정된 사이즈가 수행되는 곳은 onMeasure()입니다. onMeasure()을 오버라이드 하는 경우엔 setMeasuredDimension(int,int)를 호출해 측정된 사이즈를 저장할 수 있도록 해야합니다.

## 1. layout xml파일 생성

이미지를 담을 ImageView와 게시물의 글을 담을 TextView를 담습니다.

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id = "@+id/CL"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <ImageView
        android:id="@+id/thumbnail"
        android:layout_width="match_parent"
        android:layout_height="400dp"
        android:layout_gravity="center"
        android:src="@drawable/abc_vector_test"
        />
    <TextView
        android:id="@+id/text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:gravity="center"
        android:text="임의 텍스트"
        android:textSize="20dp"
        />
</LinearLayout>
```

## 2. attrs xml파일 생성

각 상황에 맞게 custom하게 해줄 attrs파일을 values 폴더에 만듭니다.

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <declare-styleable name ="ContentBox">
        <attr name="content" format="reference|string"/>
        <attr name="picture" format="reference"/>
        <attr name="bg" format="reference|integer"/>
    </declare-styleable>
</resources>
```

여기에 들어가는 reference는 @drawable/test 같은 reference를 말합니다.



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

