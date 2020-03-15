# CustomView-Example

![imge](https://img.shields.io/badge/ProjectType-SingleStudy-green) ![imge](https://img.shields.io/badge/Language-Kotlin-yellow) ![imge](https://img.shields.io/badge/Tools-AndroidStudio-blue)

안드로이드 스튜디오 커스텀뷰를 직접 제작해보고 적용해보기 위한 프로젝트입니다.

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

