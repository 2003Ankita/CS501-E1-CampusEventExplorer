# 🎓 Campus Event Explorer

**Name:** Ankita Patra  
**Course:** CS501 E1  
**Assignment:** Individual Coding Assignment 3 — Campus Event Explorer  
**Package:** `com.ankitapatra.campuseventexplorer`  
**Repository:** [CS501-E1-CampusEventExplorer](https://github.com/2003Ankita/CS501-E1-CampusEventExplorer)

---

## Overview

Campus Event Explorer is a Kotlin-based Android application designed to help students discover and explore campus activities. Built with Jetpack Compose, Material 3, and Navigation Compose, the app provides an interactive interface for browsing events, searching by title or category, viewing detailed information, and sharing events through Android's native Sharesheet.

## Features

- Eight campus events with stable `Long` IDs.
- Scrollable `LazyColumn` with stable item keys.
- Case-insensitive search and category filtering.
- Search state preservation using `rememberSaveable`.
- Type-safe navigation between event list and details.
- Android Sharesheet using `Intent.ACTION_SEND`.
- Reusable Compose components and Material 3 styling.

## Project Structure

The application follows a modular structure, separating event data, navigation, UI components, and utility functions for better maintainability and reusability.

```text
app/src/main/java/com/ankitapatra/campuseventexplorer/
│
├── MainActivity.kt
│
├── model/
│   └── CampusEvent.kt
│
├── data/
│   ├── EventRepository.kt
│   ├── CampusEventRepository.kt
│   └── SampleEvents.kt
│
├── navigation/
│   ├── Routes.kt
│   └── EventNavGraph.kt
│
├── ui/
│   ├── screens/
│   │   ├── EventListScreen.kt
│   │   └── EventDetailScreen.kt
│   │
│   ├── components/
│   │   ├── EventCard.kt
│   │   ├── EventSearchBar.kt
│   │   ├── EventCategoryFilter.kt
│   │   ├── EventCategoryStyle.kt
│   │   └── EventInfoRow.kt
│   │
│   └── theme/
│       ├── Color.kt
│       └── Theme.kt
│
└── util/
    └── EventShareHelper.kt
```

## Design Decisions

**1. Why does the route contain an event ID instead of the complete event object?**

Passing only the stable `Long` ID keeps navigation lightweight. The detail screen retrieves the event from the repository without serializing the complete object.

**2. Which composable owns the search state?**

`EventNavGraph` owns the search query and passes it to `EventListScreen` through parameters and callbacks.

**3. Why does the search value use `rememberSaveable`?**

It preserves the search query across configuration changes, including screen rotation, and supported activity recreation.

**4. What happens to the back stack when an event is selected?**

Selecting an event pushes `EventDetail(eventId)` onto the navigation back stack. Pressing Back removes the detail destination and returns to the list.

**5. How does the UI request navigation without directly accessing `NavController`?**

`EventListScreen` calls `onEventClick(eventId)`. `EventNavGraph` handles the callback and performs navigation.

**6. What makes the Share action an implicit intent?**

`Intent.ACTION_SEND` specifies the sharing action and `text/plain` MIME type without targeting a particular app. Android displays compatible applications through a chooser.

---

## Running the App

1. Clone the [GitHub repository](https://github.com/2003Ankita/CS501-E1-CampusEventExplorer).
2. Open the project in Android Studio and sync Gradle.
3. Start an emulator or connect a device running Android API 24 or higher.
4. Select the `app` configuration and click **Run**.

---

## Testing and Results

Manually tested on a Pixel 7 Android Emulator. All 15 test cases passed, covering event discovery, searching, category filtering, empty states, navigation, sharing, and rotation.

**Required screenshots:**

- [Event List Screen](screenshots/01_event_list.png)
- [Event Detail Screen](screenshots/06_event_details.png)

Additional test screenshots are available in the [`screenshots/`](screenshots/) directory.

## AI Use

ChatGPT (OpenAI) assisted with  planning, debugging, and README documentation. I reviewed the whatever suggested, and manually tested the application.