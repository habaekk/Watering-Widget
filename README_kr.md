
# 💧 물꼬대 (Watering)



물꼬대는 일일 물 섭취량을 추적하고 관리할 수 있는 안드로이드 애플리케이션입니다. 다양한 위젯을 통해 손쉽게 물 섭취를 기록하고, 과거의 섭취 기록을 확인할 수 있습니다.

## 🌟 주요 기능

-   **다양한 용기의 위젯 지원**: 컵, 텀블러, 병 등 다양한 물 용량을 선택하여 위젯으로 섭취량을 손쉽게 기록할 수 있습니다.

-   **일일 섭취량 추적**: 홈 화면에서 오늘의 물 섭취량을 한눈에 확인할 수 있습니다.

-   **섭취 기록 확인**: 지난 7일간의 물 섭취 내역을 확인하고 관리할 수 있습니다.

-   **사용자 친화적인 인터페이스**: 직관적인 디자인으로 누구나 쉽게 사용할 수 있습니다.


## 🚀 사용 방법

### 홈 화면

-   오늘의 물 섭취량을 한눈에 확인할 수 있습니다.

-   컵, 텀블러, 병 아이콘이 채워진 정도로 섭취량을 표시합니다.


### 위젯 사용

-   홈 화면에 위젯을 추가하여 빠르게 물 섭취를 기록할 수 있습니다.

-   각 위젯은 해당 용기의 섭취량을 관리합니다.

-   아이콘을 터치하여 섭취량을 증가시킵니다. 리셋 버튼으로 초기화할 수 있습니다.


### 섭취 기록 확인

-   하단 네비게이션 바에서 **History** 탭을 선택합니다.

-   지난 7일간의 물 섭취 내역을 날짜별로 확인할 수 있습니다.


### 상세 정보

-   **Details** 탭에서 앱의 사용 방법 및 추가 정보를 확인할 수 있습니다.


## 🗂️ 프로젝트 구조

```
widgetPrac/
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── settings.gradle.kts
├── .idea/
│   ├── misc.xml
│   └── workspace.xml
├── app/
│   ├── build.gradle.kts
│   ├── proguard-rules.pro
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── bada/
│   │   │   │           └── widgetprac/
│   │   │   │               ├── MainActivity.kt
│   │   │   │               ├── BottleAppWidget.kt
│   │   │   │               ├── DetailsFragment.kt
│   │   │   │               ├── HistoryFragment.kt
│   │   │   │               ├── HomeFragment.kt
│   │   │   │               ├── SettingsFragment.kt
│   │   │   │               ├── PracWidget.kt
│   │   │   │               └── TumblerAppWidget.kt
│   │   │   ├── res/ # 이 레포지토리에서는 생략됨
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   └── prac_widget.xml
│   │   │   │   ├── drawable/
│   │   │   │   │   ├── app_widget_background.xml
│   │   │   │   │   └── boundary.xml
│   │   │   │   └── values/
│   │   │   │       ├── strings.xml
│   │   │   │       ├── colors.xml
│   │   │   │       └── styles.xml
└── gradle/
    ├── wrapper/
        ├── gradle-wrapper.properties
        └── gradle-wrapper.jar
```

## 🛡️ 라이선스