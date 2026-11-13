😂 LOLify

Your Daily Dose of Laughter!

LOLify is a fun Android application that lets users discover random memes fetched from Reddit through a REST API. Built with modern Android development technologies, it provides a simple and engaging meme-browsing experience.

📱 About the Project

LOLify is an Android project developed using Kotlin and Jetpack Compose. It demonstrates REST API integration using Retrofit, asynchronous programming with Kotlin Coroutines, and modern UI development.

The application fetches random memes from the Meme API and displays them in an attractive dark-themed interface.

✨ Features

* 🎭 Random Memes: Discover random memes with a single tap.
* 🌐 API Integration: Fetch meme data from a REST API.
* 🖼️ Image Loading: Load meme images using Coil.
* 🔄 Loading State: Display loading indicators while fetching memes.
* ⚠️ Error Handling: Handle API failures with retry functionality.
* 🎨 Modern UI: Dark-themed interface built with Jetpack Compose.
* 🏗️ MVVM Architecture: Separate UI, business logic, and data layers.

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Kotlin | Programming Language |
| Jetpack Compose | UI Development |
| Retrofit | REST API Integration |
| Gson | JSON Parsing |
| Kotlin Coroutines | Asynchronous Programming |
| StateFlow | Reactive UI State Management |
| ViewModel | UI State Management |
| Coil | Image Loading |
| MVVM | Application Architecture |

---

## 🏛️ Architecture

LOLify follows the **MVVM (Model-View-ViewModel)** architecture.

### Project Structure

```text
com.example.lolify
│
├── data
│   ├── Meme.kt
│   ├── remote
│   │   ├── MemeApi.kt
│   │   └── RetrofitInstance.kt
│   └── MemeRepository.kt
│
├── MemeScreen.kt
├── MemeUiState.kt
└── MemeViewModel.kt
```

### Data Flow

```text
UI (Jetpack Compose)
        |
        v
   MemeViewModel
        |
        v
   MemeRepository
        |
        v
      MemeApi
        |
        v
  RetrofitInstance
        |
        v
     Meme API
```

🌐 API Used

LOLify uses the public Meme API to fetch random memes.

Base URL:
https://meme-api.com/

Endpoint:
https://meme-api.com/gimme

No API key is required for the basic random meme endpoint.

🚀 Getting Started

Prerequisites

* Android Studio
* Android SDK
* Kotlin support
* Android Emulator or physical Android device

Installation

1. Clone the repository:

git clone https://github.com/bhupesh1309-code/LOLify.git

2. Open the project in Android Studio.
3. Wait for Gradle synchronization to complete.
4. Connect an Android device or start an emulator.
5. Click Run to build and launch the application.

🎯 Learning Outcomes

Through this project, I explored:

* Integrating REST APIs into Android applications using Retrofit.
* Converting JSON responses into Kotlin data classes using Gson.
* Managing asynchronous network operations with Kotlin Coroutines.
* Implementing reactive UI state management using StateFlow.
* Understanding Repository and ViewModel in MVVM architecture.
* Loading remote images using Coil in Jetpack Compose.
* Handling loading, success, and error states in Android applications.

🔮 Future Improvements

* ❤️ Save favourite memes.
* 🔗 Share memes with friends.
* 📂 Browse memes by categories or subreddits.
* 👆 Add swipe gestures to navigate between memes.
* ✨ Add animations and improve user interactions.

👨‍💻 Developer

Bhupesh

B.Tech Computer Science & Engineering Student

Built with ❤️ using Kotlin and Jetpack Compose.

⸻

LOLify – Because everyone deserves a daily dose of laughter! 😂
