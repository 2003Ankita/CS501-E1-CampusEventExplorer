# 🎓 Campus Event Explorer

**Name:** Ankita Patra  
**Course:** CS501 E1  
**Assignment:** Individual Coding Assignment 3 — Campus Event Explorer  
**Package:** `com.ankitapatra.campuseventexplorer`  
**Repository:** [CS501-E1-CampusEventExplorer](https://github.com/2003Ankita/CS501-E1-CampusEventExplorer)

---

## Overview

Campus Event Explorer is a colorful Android application built with Kotlin, Jetpack Compose, Material 3, and Navigation Compose. It helps students discover campus activities, search events, view details, and share event information.

## Features

- Eight sample campus events with unique, stable `Long` IDs.
- Scrollable event list using `LazyColumn` and stable item keys.
- Live search by event title or category.
- Search state preserved across configuration changes using `rememberSaveable`.
- Type-safe navigation between event list and detail screens.
- Detailed event information, including title, category, location, time, and description.
- Android Sharesheet integration using `Intent.ACTION_SEND`.
- Graceful handling of unknown event IDs.
- Reusable Compose components and a custom Material 3 theme.

## Screenshots

### 1. Event List — All Campus Events

**Test Case:** Launch application

**Expected Result:** Displays all 8 campus events in a scrollable list.

![Event List — All Campus Events](screenshots/01_event_list.png)

### 2. Search by Event Title

**Test Case:** Search by event title

**Input:** `Innovation`

**Expected Result:** Displays only Tech & AI Innovation Night.

**Observed Result:** 1 matching event displayed.

![Search by Event Title](screenshots/02_search_by_title.png)

### 3. Search by Event Category

**Test Case:** Search by event category

**Input:** `Music`

**Expected Result:** Displays only events belonging to the Music category.

**Observed Result:** 1 event found — Fall Music Festival.

**Result:** PASS

![Search by Event Category](screenshots/03_search_by_category.png)

### 4. Filter Events Using Category Chips

**Test Case:** Filter events using category chips

**Action:** Select the Music category chip with an empty search field.

**Expected Result:** Only Music events appear, and the selected chip is highlighted.

**Observed Result:** Music chip highlighted, 1 event found — Fall Music Festival.

**Result:** PASS

![Category Chip Filtering](screenshots/04_category_chip_filter.png)

## Running the App

1. Clone the repository and open it in Android Studio.
2. Allow Gradle synchronization to finish.
3. Start an Android emulator (API 24+) or connect a device.
4. Select the `app` configuration and click **Run ▶**.
5. Browse, search, open, and share campus events.

## Architecture and State

The project separates `model`, `data`, `navigation`, `ui/screens`, `ui/components`, and `util`. An `EventRepository` interface abstracts event retrieval. Screens receive data and callbacks rather than directly controlling navigation. Navigation passes only the event ID, and the destination retrieves the corresponding event from the repository.

Search results are derived from the current query instead of being stored as duplicate mutable state.

## Testing and Results

### Manual Test Cases

The following test cases cover the main functionality and navigation behavior of Campus Event Explorer.

| Test Case | Expected Result |
|---|---|
| Launch application | Displays all 8 campus events |
| Search by event title | Displays events matching the entered title |
| Search by category | Displays events belonging to the searched category |
| Case-insensitive search | Matches events regardless of uppercase or lowercase input |
| Search with no matches | Displays an appropriate empty-state message |
| Clear search input | Restores the complete event list |
| Select an event | Opens the corresponding event detail screen |
| View event details | Displays title, category, location, time, and description |
| Navigate back | Returns to the event list |
| Preserve search after navigation | Retains the previous search query when returning from details |
| Rotate the device | Preserves the search query and keeps the interface usable |
| Share an event | Opens the Android Sharesheet with the event title, time, and location |
| Open an unknown event ID | Displays a fallback message without crashing |
| Scroll through events | Allows access to all events using the scrollable list |

### Test Environment

- **Device:** Pixel 7 Android Emulator
- **Language:** Kotlin
- **UI Framework:** Jetpack Compose and Material 3
- **Navigation:** Navigation Compose with type-safe routes
- **Minimum SDK:** API 24

### Screenshots

Screenshots of the application demonstrate the following scenarios:

1. **Event List:** All campus events displayed in the scrollable list.
2. **Search by Title:** Filtered events matching a title.
3. **Search by Category:** Filtered events matching a category.
4. **No Results:** Empty-state message for an unmatched query.
5. **Event Details:** Complete information for a selected event.
6. **Share Event:** Android Sharesheet displaying event information.
7. **Screen Rotation:** Search state retained in landscape orientation.

Screenshots will be added after capturing them from the emulator.
## AI Use

ChatGPT by OpenAI assisted with project structure, reusable component design, and README preparation. Generated suggestions are reviewed against the assignment requirements; application testing is documented separately.