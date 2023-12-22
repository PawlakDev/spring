# Dzienniczek treningowy 2.0

## Projekt zaliczeniowy na przedmiot Programowanie Java 2.

## Opis projektu
Aplikacja służy do prowadzenia dzienniczka treningowego. Użytkownik może dodawać treningi, ćwiczenia, wyświetlać statystyki treningów, ćwiczeń, wykresy, wyświetlać informacje o swoim profilu, edytować dane, zmieniać hasło, usuwać konto.
Jest równiez mozliwość planowania treningów, dodawania ćwiczeń do planu treningowego, edycji, usuwania planów treningowych.

## Funkcjonalności nad którymi obecnie pracujemy:
* Frontend: szkielet aplikacji 
  - W przypadku użycia Spring REST API frontend zrobiony przy użyciu wybranego narzędzia.

* Backend :
###  1. zaprojektowanie modeli bazy danych

#### 1.1. Modele główne bazy danych:
 - user - korzystanie z Spring Security. Pola: login, hasło, imie, nazwisko, rok urodzenia 
 - trening planowany (PlannedWorkout) - model opisuje planowany trening w planie treningowym. Końcówka CRUD, model ma mieć FK do workoutType, pozostałe pola: data (lub dzień tygodnia)
 - plan treningowy (WorkoutPlan) - końcówka CRUD, model ma mieć FK do usera i zawiera liste planowanych treningów
 - cwiczenie (Exercise) - końcówka CRUD, model jest wykorzystywany do siłowni i ma pola: nazwa, opis, czas trwania
 - trening odbyty (WorkoutSummary) - końcówka CRUD, model ma mieć FK do usera, FK do treningu planowanego, inne do dodania pola
 - typ treningu (WorkoutType) - Model generyczny dla modeli typów treningów. Zawiera czas liste ćwiczeń
 #### 1.2. Modele typu treningu - dziedziczą po typie treningu:
 - siłownia (Gym) - końcówka READONLY, pola: min reps, max reps, min weight, max weight, series, rest_time
 - bieganie (Running) - końcówka READONLY, pola: distance, avg_speed, avg_heart_rate
 - rower (Bike) - końcówka READONLY, pola: distance, avg_speed, avg_heart_rate
 - ergometr (IndoorRower) - końcówka READONLY, pola: distance, avg_speed, avg_heart_rate, avg_watts
 - pływanie (Swimming) - końcówka READONLY, pola: distance, avg_speed, avg_heart_rate, style
 - gry zespolowe (TeamSports) - końcówka READONLY, pola: avg_speed, avg_heart_rate, sets_number, points_number
 - inne (Other) - końcówka READONLY, pola: distance, series, avg_speed, avg_heart_rate, description (wszystkie pola opcjonalne)
### 2. Panel logowania i rejestracji dla usera - użytkownicy w bazie danych - Spring Security.


## Technologie
* Java 11
* Spring Boot
* Spring REST API
* Hibernate
* Postgresql