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

## (2) 시작하기 전...

ViewGroup에서 상속 받고 거기에 기능을 추가하는 방식을 하지 않고 View를 이용해 완전히 처음부터 그리는 경우를 선택한 이유는 인스타그램처럼 화면이 무한 스크롤이 되는 구조에서 속도가 빠르기 때문에 조금 복잡한 레이아웃에서는 onDraw를 이용해 그리는것이 추천된다.

