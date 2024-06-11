# Panda News

Panda News is a native Android news application built using Jetpack Compose. The app follows the MVVM (Model-View-ViewModel) architecture to some extent and uses API network calling to fetch the latest news articles across different countries.

## Features

- Display the latest news articles from various sources from a wide range of countries.
- View detailed news articles.
- Dark mode support.

## Screenshots

![NewsAppHome](https://github.com/Aban3049/PandaNews/assets/157634467/f02ace75-5833-4479-be9d-dc61f6844178)
![NewsAppCountries](https://github.com/Aban3049/PandaNews/assets/157634467/00e3e14a-176f-46de-aa6f-96e46d694f03)
![NewDetailScreen](https://github.com/Aban3049/PandaNews/assets/157634467/6483c8b4-1fa1-4d6f-aa7e-9d15d6194a3d)


## Architecture

The app follows the MVVM architecture pattern to some extent, which helps in separating the concerns of the application and makes the codebase more maintainable and testable.

- **Model**: Represents the data layer of the app, including the data models and repository classes.
- **View**: Represents the UI layer of the app, built using Jetpack Compose.
- **ViewModel**: Acts as a bridge between the Model and View layers, handling the business logic and preparing data for the UI.

## Tech Stack

- **Kotlin**: The programming language used for Android development.
- **Jetpack Compose**: The modern toolkit for building native Android UI.
- **Retrofit**: A type-safe HTTP client for making API network calls.
- **Coroutines**: For asynchronous programming.
- **Coil**: An image loading library for Android.

## Getting Started

To get a local copy of the project up and running, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/Aban3049/PandaNews
