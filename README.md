# MovieApp

Sample app implementing MVVM, IoC and DI (using Koin), LiveData and various other useful stuff

## Used libraries

- Retrofit for networking and API requests
- Glide for image loading
- Android Architecture Components
  - LiveData and ViewModel for MVVM and notifiable properties
  - ConstraintLayout for better layouts
  - Design, AppCompat, Fragment, CardView and RecyclerView for UI stuff
  - Navigation for navigation implementation
- fonix232-common, for generic base classes
- Koin with ViewModel extensions
- Timber for logging

## Used technologies

- DataBinding for easier UI management
- Dependency Injection for separation of concerns
- Inversion Of Control for easily replaceable parts (e.g. `MovieClient`s)

## Compile and use

1. Create a `private.properties` in the root directory
2. Add a new property called `default.omdb.apikey` and set its value to your OMDB API Key
3. Compile and run

