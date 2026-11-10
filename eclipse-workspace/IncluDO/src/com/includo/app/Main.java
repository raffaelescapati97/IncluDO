package com.includo.app;

import java.util.Scanner;

import com.includo.repository.BookingRepository;
import com.includo.repository.CourseRepository;
import com.includo.repository.UserRepository;
import com.includo.service.BookingService;
import com.includo.service.CourseService;
import com.includo.service.UserService;
import com.includo.service.CsvLoaderService;
import com.includo.ui.Menu;
import com.includo.util.CsvExporter;

public class Main {

    public static void main(String[] args) {

        // Repository
        UserRepository userRepository = new UserRepository();
        CourseRepository courseRepository = new CourseRepository();
        BookingRepository bookingRepository = new BookingRepository();
        // Caricamento dati CSV
        CsvLoaderService loader = new CsvLoaderService();

        loader.loadUsers(userRepository);
        loader.loadCourses(courseRepository);
        loader.loadBookings(bookingRepository);

        // Services
        CourseService courseService =
                new CourseService(courseRepository);

        BookingService bookingService =
                new BookingService(
                        bookingRepository,
                        userRepository,
                        courseRepository);
        
        UserService userService =
                new UserService(userRepository);
        
        CsvExporter exporter =
                new CsvExporter();

        // Menu
        Menu menu = new Menu();

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {

            menu.show();

            try {

                choice =
                        Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:

                        System.out.println("\n=== ELENCO CORSI ===");
                        courseService.showAllCourses();

                        break;

                    case 2:

                        System.out.print(
                                "Inserisci ID utente: ");

                        int userId =
                                Integer.parseInt(
                                        scanner.nextLine());

                        System.out.print(
                                "Inserisci ID corso: ");

                        int courseId =
                                Integer.parseInt(
                                        scanner.nextLine());

                        bookingService.bookCourse(
                                userId,
                                courseId);

                        break;

                    case 3:

                        System.out.print(
                                "Inserisci ID prenotazione da eliminare: ");

                        int bookingId =
                                Integer.parseInt(
                                        scanner.nextLine());

                        bookingService.cancelBooking(
                                bookingId);

                        break;

                    case 4:

                        System.out.print("Nome: ");
                        String nome =
                                scanner.nextLine();

                        System.out.print("Cognome: ");
                        String cognome =
                                scanner.nextLine();

                        System.out.print("Data di nascita: ");
                        String dataNascita =
                                scanner.nextLine();

                        System.out.print("Indirizzo: ");
                        String indirizzo =
                                scanner.nextLine();

                        System.out.print("Documento ID: ");
                        String documentoId =
                                scanner.nextLine();

                        userService.addUser(
                                nome,
                                cognome,
                                dataNascita,
                                indirizzo,
                                documentoId
                        );

                        break;

                    case 5:

                        exporter.exportAvailableCourses(
                                courseRepository);

                        break;
                        
                    case 6:

                        bookingService.showAllBookings();

                        break;
                        
                    case 7:

                        for (var user :
                                userRepository.getUsers()) {

                            System.out.println(user);
                        }

                        break;

                    case 0:

                        System.out.println(
                                "\nChiusura applicazione...");
                        break;

                    default:

                        System.out.println(
                                "Scelta non valida.");

                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Inserisci un numero valido.");

                choice = -1;
            }

        } while (choice != 0);

        scanner.close();

        System.out.println("Arrivederci!");
    }
}