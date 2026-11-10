package com.includo.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.includo.model.User;
import com.includo.repository.UserRepository;
import com.includo.model.Course;
import com.includo.repository.CourseRepository;
import com.includo.model.Booking;
import com.includo.repository.BookingRepository;

public class CsvLoaderService {

    public void loadUsers(UserRepository repository) {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("utenti.csv"));

            String line;

            // Salta intestazione
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] values = line.split(";");

                int id = Integer.parseInt(values[0]);

                String nome = values[1];
                String cognome = values[2];
                String dataNascita = values[3];
                String indirizzo = values[4];
                String documentoId = values[5];

                User user = new User(
                        id,
                        nome,
                        cognome,
                        dataNascita,
                        indirizzo,
                        documentoId
                );

                repository.addUser(user);
            }

            reader.close();

            System.out.println("Utenti caricati correttamente.");

        } catch (IOException e) {

            System.out.println("Errore durante la lettura del file utenti.csv");
            e.printStackTrace();
        }
    }
    
    public void loadCourses(CourseRepository repository) {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("corsi.csv"));

            String line;

            // Salta intestazione
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                // Elimina spazi iniziali e finali
                line = line.trim();

                // Salta righe vuote
                if (line.isEmpty()) {
                    continue;
                }

                // Salta righe composte da soli ;
                if (line.replace(";", "").isEmpty()) {
                    continue;
                }

                String[] values = line.split(";");

                // Verifica numero minimo di colonne
                if (values.length < 7) {

                    System.out.println(
                            "Riga ignorata: " + line);

                    continue;
                }

                try {

                    int id =
                            Integer.parseInt(values[0].trim());

                    String nome =
                            values[1].trim();

                    String descrizione =
                            values[2].trim();

                    String data =
                            values[3].trim();

                    int durataOre =
                            Integer.parseInt(values[4].trim());

                    String luogo =
                            values[5].trim();

                    boolean disponibile =
                            values[6].trim()
                                    .equalsIgnoreCase("SI");

                    Course course =
                            new Course(
                                    id,
                                    nome,
                                    descrizione,
                                    data,
                                    durataOre,
                                    luogo,
                                    disponibile
                            );

                    repository.addCourse(course);

                } catch (Exception e) {

                    System.out.println(
                            "Errore nella riga: "
                                    + line);

                }
            }

            reader.close();

            System.out.println(
                    "Corsi caricati correttamente.");

        } catch (IOException e) {

            System.out.println(
                    "Errore durante la lettura di corsi.csv");

            e.printStackTrace();
        }
    }
    
    public void loadBookings(
            BookingRepository repository) {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("prenotazioni.csv"));

            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] values = line.split(";");

                int id =
                        Integer.parseInt(values[0]);

                int courseId =
                        Integer.parseInt(values[1]);

                int userId =
                        Integer.parseInt(values[2]);

                String dataInizio =
                        values[3];

                String dataFine =
                        values[4];

                Booking booking =
                        new Booking(
                                id,
                                courseId,
                                userId,
                                dataInizio,
                                dataFine
                        );

                repository.addBooking(booking);
            }

            reader.close();

            System.out.println(
                    "Prenotazioni caricate correttamente.");

        } catch (IOException e) {

            System.out.println(
                    "Errore lettura prenotazioni.csv");
        }
    }
}