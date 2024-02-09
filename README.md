# Project Draft Overview

## Architecture

The project architecture is organized into the following components:

- **Data**: Handling data operations such as fetching from and storing to various sources (room, datastore).
- **Domain**: Core business logic (usecase) and models.
- **Common**: Shared utilities and helper functions (logging).
- **MVI Presentation**: Presentation layer following the Model-View-Intent pattern.
- **Test**: Unit and integration tests.
- **Offline-First Approach**: Design strategy prioritizing offline functionality.

## Frameworks

The project utilizes the following frameworks and libraries:

- **Koin (Dependency Injection)**: For managing dependencies and facilitating testing.
- **Navigation**: Handling navigation between different screens and components.
- **ViewBinding**: Efficiently binding views in layout files.
- **Timber**: Logging library for better debugging and error tracking.
- **Room**: Persistence library for local database implementation.
- **Compose**: Modern UI toolkit for building native UIs.
- **ViewModel**: Architecture component for managing UI-related data.
- **Work Manager**: Library for managing background tasks.
- **Retrofit**: Type-safe HTTP client for API communication.
- **Moshi**: JSON library for parsing JSON into Kotlin objects.
- **OkHttp3**: HTTP client for making network requests.
- **Coroutines**: Asynchronous programming library for managing background tasks.
- **Coil**: Image loading library for loading images asynchronously.
- **LeakCanary**: Memory leak detection library for detecting memory leaks.
- **DataStore**: Modern data storage solution for managing key-value pairs.

## Use Cases

The project encompasses various use cases including:

- **Tracker Location on Background**: Tracking user location even when the app is in the background.
- **Get Current Location**: Retrieving the user's current location.
- **Multi-Language Support**: Supporting multiple languages within the app.
- **Retrofit API Implementation**: Utilizing Retrofit for handling API requests.
- **Room Database Implementation**: Implementing a local database using Room.
- **User Login/Logout Mechanism**: Managing user authentication and session handling.
- **Bottom Bar Nested Navigation**: Implementing a bottom bar navigation with nested screens.
- **Drawer**: Utilizing a navigation drawer for accessing app features.
- **Debug Panel**: Providing a debug panel for switching APIs, clearing app data, and theme switching.
- **Light/Dark/Dynamic/Custom Theme**: Supporting both light and dark themes, following material design guidelines.
- **Deep Links**: Enabling navigation directly to specific content within the app.
- **Firebase Notifications**: Implementing push notifications functionality.
- **Firebase Analytics**: Integrating analytics for user behavior tracking.
- **Social Login**: Integration for logging in via social media accounts.
## Additional Notes
//todo
