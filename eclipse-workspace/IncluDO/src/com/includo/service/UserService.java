package com.includo.service;

import com.includo.model.User;
import com.includo.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(
            String nome,
            String cognome,
            String dataNascita,
            String indirizzo,
            String documentoId) {

        int newId =
                userRepository.getNextId();

        User user =
                new User(
                        newId,
                        nome,
                        cognome,
                        dataNascita,
                        indirizzo,
                        documentoId
                );

        userRepository.addUser(user);

        System.out.println(
                "Utente aggiunto con successo.");

        System.out.println(
                "ID assegnato: " + newId);
    }
}