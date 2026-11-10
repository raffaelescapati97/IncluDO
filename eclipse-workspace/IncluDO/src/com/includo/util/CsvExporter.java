package com.includo.util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.includo.model.Course;
import com.includo.repository.CourseRepository;

public class CsvExporter {

    public void exportAvailableCourses(
            CourseRepository repository) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd_MM_yyyy");

        String fileName =
                "prenotazioni_"
                        + LocalDate.now().format(formatter)
                        + ".csv";

        try {

            FileWriter writer =
                    new FileWriter(fileName);

            writer.write(
                    "ID;Nome;Data;Luogo\n");

            for (Course course :
                    repository.getCourses()) {

                if (course.isDisponibile()) {

                    writer.write(
                            course.getId() + ";"
                                    + course.getNome() + ";"
                                    + course.getData() + ";"
                                    + course.getLuogo()
                                    + "\n");
                }

            }

            writer.close();

            System.out.println(
                    "File esportato correttamente: "
                            + fileName);

        } catch (IOException e) {

            System.out.println(
                    "Errore durante l'esportazione.");

            e.printStackTrace();
        }
    }
}