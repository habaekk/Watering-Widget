
# 💧 Watering
[English](https://github.com/habaekk/Watering-Widget) | [한국어](https://github.com/habaekk/Watering-Widget/blob/main/README_kr.md)
  

`Watering` is an Android application that helps you track and manage your daily water intake. With various widgets, you can easily record your water consumption and review past intake records.

## 🌟 Key Features

-   **Widget Support for Various Containers**: Easily record your water intake by selecting from different container types such as cups, tumblers, and bottles.

-   **Daily Intake Tracking**: View your daily water intake at a glance on the home screen.

-   **Intake History Review**: Review and manage your water intake over the past 7 days.

-   **User-Friendly Interface**: Intuitive design makes it easy for anyone to use.


## 🚀 How to Use

### Home Screen

-   View your daily water intake at a glance.

-   Icons for cups, tumblers, and bottles display the amount of water consumed.


### Using Widgets

-   Add a widget to your home screen for quick water intake logging.

-   Each widget manages the intake amount for its respective container.

-   Tap the icon to increase the intake. Use the reset button to clear the intake.


### Reviewing Intake History

-   Select the **History** tab from the bottom navigation bar.

-   Review your water intake for the past 7 days by date.


### Detailed Information

-   Check the **Details** tab for usage instructions and additional information.


## 🗂️ Project Structure

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
│   │   │   ├── res/ # Omitted in this repository
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

## 🛡️ License