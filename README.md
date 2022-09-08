# Compose Music List

## Stack
- Kotlin
- Compose
- MVVM
- Hilt
- Realm
- Coroutines
- Flow
- Coil

## Approach
- Compose was used for UI layer.
- For Dependency Injection, Hilt was used. The general pattern is MVVM based, with DataSource/DAO, Repository, ViewModel and View layers and the communication is done
  through an Observer pattern - Flow library for Android.
- In the set up architecture the DataSource layer exposes storage/network operation, Repository layer is an intermediary layer where data can be mapped/changed in
  both directions, ViewModel triggers and observes data (also holds some data and calculations for View related operations) and the View only reacts to data changes.
- Project is organized in base package and features package. 
  base package contains code shared across features 
  features package is split by app features. Packages under feature package are organized by necessary layers - data source, repository, viewmodel and ui. 

Modularization was an overkill here, but you can find my modularized app example here:
https://github.com/azentner1/Stopwatch-Compose

## Video
