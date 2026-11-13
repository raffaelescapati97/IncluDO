# IncluDO - Course Booking System

## Descrizione

IncluDO è un'applicazione Java sviluppata per la gestione delle prenotazioni di corsi professionali destinati a migranti e persone svantaggiate.

Il progetto nasce con l'obiettivo di supportare la formazione professionale e la conservazione dei mestieri tradizionali attraverso la gestione centralizzata di utenti, corsi e prenotazioni.

---

## Funzionalità

### Caricamento dati

All'avvio dell'applicazione vengono caricati automaticamente:

- utenti.csv
- corsi.csv
- prenotazioni.csv

I dati vengono memorizzati in memoria tramite ArrayList.

---

### Gestione corsi

L'utente può:

- Visualizzare tutti i corsi presenti nel sistema
- Verificare la disponibilità dei corsi

---

### Gestione prenotazioni

L'utente può:

- Prenotare un corso disponibile
- Disdire una prenotazione esistente

Durante la prenotazione il sistema verifica:

- Esistenza dell'utente
- Esistenza del corso
- Disponibilità del corso

---

### Gestione utenti

L'utente può:

- Registrare un nuovo utente

L'identificativo viene generato automaticamente dal sistema.

---

### Esportazione CSV

L'utente può esportare tutti i corsi disponibili in un file CSV.

Formato generato:

```text
prenotazioni_DD_MM_YYYY.csv
```

---

## Tecnologie utilizzate

- Java
- Eclipse IDE
- Git
- GitHub

---

## Struttura del progetto

```text
com.includo

├── app
│   └── Main.java
│
├── model
│   ├── User.java
│   ├── Course.java
│   └── Booking.java
│
├── repository
│   ├── UserRepository.java
│   ├── CourseRepository.java
│   └── BookingRepository.java
│
├── service
│   ├── CsvLoaderService.java
│   ├── CourseService.java
│   ├── BookingService.java
│   └── UserService.java
│
├── ui
│   └── Menu.java
│
└── util
    └── CsvExporter.java
```

---

## Configurazione

### Clonare il repository

```bash
git clone https://github.com/raffaelescapati97/IncluDO.git
```

Entrare nella directory del progetto:

```bash
cd IncluDO
```

---

## Compilazione

Esempio da terminale:

```bash
javac src/**/*.java
```

Oppure importare il progetto in Eclipse.

---

## Esecuzione

Da Eclipse:

Eseguire:

```java
Main.java
```

presente nel package:

```text
com.includo.app
```

---

## Generazione del JAR

Da Eclipse:

```text
File
→ Export
→ Java
→ JAR File
```

Main Class:

```java
com.includo.app.Main
```

---

## Autore

Raffaele Scapati

Progetto sviluppato come elaborato finale del corso Java.
