# Dzienniczek treningowy 2.0

## Projekt zaliczeniowy na przedmiot Programowanie Java 2.

## Opis projektu
Aplikacja służy do prowadzenia dzienniczka treningowego. Użytkownik może dodawać treningi, ćwiczenia, wyświetlać statystyki treningów, ćwiczeń, wykresy, wyświetlać informacje o swoim profilu, edytować dane, zmieniać hasło, usuwać konto.
Jest równiez mozliwość planowania treningów, dodawania ćwiczeń do planu treningowego, edycji, usuwania planów treningowych.

## Funkcjonalności nad którymi obecnie pracujemy:
* Frontend: szkielet aplikacji
* Bazy danych: analiza pol modeli i relacji
* Backend :
###  1. zaprojektowanie modeli bazy danych

#### 1.1. Modele główne bazy danych:
 - user - login, hasło, można skorzystac z defaultowego usera springa
 - trening (Workout) - końcówka CRUD, model ma mieć FK do usera oraz do planu treningowego, dziedzczy o typie treningu
 - plan treningowy (WorkoutPlan) - końcówka CRUD, model ma mieć FK do usera
 - cwiczenie (Exercise) - końcówka CRUD, model ma mieć FK do planowanego tringu
 - opis treningu (WorkoutSummary) - końcówka CRUD, model ma mieć FK do treningu
 - typ treningu (WorkoutType) - końcówka READONLY, Model łączący modele z kategori typu treningu z treningiem
 #### 1.2. Modele typu treningu:
 - siłownia (Gym) - końcówka READONLY, pola: min reps, max reps, min weight, max weight, series, rest_time
 - bieganie (Running) - końcówka READONLY, pola: distance, avg_speed, avg_heart_rate
 - rower (Bike) - końcówka READONLY, pola: distance, avg_speed, avg_heart_rate
 - ergometr (IndoorRower) - końcówka READONLY, pola: distance, avg_speed, avg_heart_rate, avg_watts
 - pływanie (Swimming) - końcówka READONLY, pola: distance, avg_speed, avg_heart_rate, style
 - gry zespolowe (TeamSports) - końcówka READONLY, pola: avg_speed, avg_heart_rate, sets_number, points_number
 - inne (Other) - końcówka READONLY, pola: distance, series, avg_speed, avg_heart_rate, description (wszystkie pola opcjonalne)
### 2. Panel logowania i rejestracji dla usera
### Łącznosc z garmin API ???


## Technologie
* Java 11
* Spring Boot
* Hibernate
* Postgresql