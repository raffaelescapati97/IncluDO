package com.includo.service;

import com.includo.model.Booking;
import com.includo.model.Course;
import com.includo.model.User;
import com.includo.repository.BookingRepository;
import com.includo.repository.CourseRepository;
import com.includo.repository.UserRepository;

public class BookingService {

    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    private CourseRepository courseRepository;

    public BookingService(
            BookingRepository bookingRepository,
            UserRepository userRepository,
            CourseRepository courseRepository) {

        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    public void bookCourse(int userId, int courseId) {

        User user = userRepository.findById(userId);

        if (user == null) {

            System.out.println("Utente non trovato.");
            return;
        }

        Course course =
                courseRepository.findById(courseId);

        if (course == null) {

            System.out.println("Corso non trovato.");
            return;
        }

        if (!course.isDisponibile()) {

            System.out.println("Corso non disponibile.");
            return;
        }

        int bookingId =
                bookingRepository.getNextId();

        Booking booking =
                new Booking(
                        bookingId,
                        courseId,
                        userId,
                        "01/01/2024",
                        "01/01/2024"
                );

        bookingRepository.addBooking(booking);

        course.setDisponibile(false);

        System.out.println(
                "Prenotazione effettuata con successo.");
    }
    
    public void cancelBooking(int bookingId) {

        Booking booking =
                bookingRepository.findById(bookingId);

        if (booking == null) {

            System.out.println(
                    "Prenotazione non trovata.");

            return;
        }

        Course course =
                courseRepository.findById(
                        booking.getCourseId());

        if (course != null) {

            course.setDisponibile(true);

        }

        bookingRepository.removeBooking(booking);

        System.out.println(
                "Prenotazione eliminata correttamente.");
    }
    
    public void showAllBookings() {

        for (Booking booking :
                bookingRepository.getBookings()) {

            System.out.println(booking);

        }
    }
}