# DoorDashSampleApp

A lite version of DoorDash app. Users can browse a list of restaurants (currently 50) near their current location (Currently static, set to lat: 37.422740, long: -122.139956).

Architecture: MVVM (Model-View-ViewModel)

On opening app, a netowrk check is done to see if internet is available. If yes, then app makes call to doordash open source api to fetch list of restaurants and store in cache (SQLite DB).
Once saved to DB , the ViewModel class looks for changes to DB data by observing a list of restaurant objects wrapped around a LiveData class. Any subsequent changes to this LiveData is observed by the UI and updates accordingly.


## Getting Started
```
git clone
```
Open Android Studio and import project. Ensure that Android SDK version 26 is installed at a minimum.


### Prerequisites
```
Android Studio
Android SDK 26
```

## Screenshots
Portrait mode

<img width="317" alt="Screen Shot 2019-03-16 at 9 10 01 PM" src="https://user-images.githubusercontent.com/13279942/54485090-0caff900-4830-11e9-9c8b-8853cf50b35f.png">

Landscape mode

<img width="525" alt="Screen Shot 2019-03-16 at 9 10 28 PM" src="https://user-images.githubusercontent.com/13279942/54485093-10438000-4830-11e9-9403-386658ea2a6f.png">


## Dependencies
1. Android Lifecycle components - LiveData, ViewModel
2. Room - for data persistence using SQLite DB
3. Retrofit2 & OkHttp3 - for making network requests
4. Picasso - for loading thumbnail images for restaurants
5. PowerMock & JUnit - for unit testing



