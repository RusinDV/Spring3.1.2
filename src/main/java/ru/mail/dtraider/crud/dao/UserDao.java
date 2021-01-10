package ru.mail.dtraider.crud.dao;


import ru.mail.dtraider.crud.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);

    User readUser(Long idUser);

    User readUserByEmail(String email);

    void updateUser(Long idUser, String firstName, String lastName, int age, String email, String password);

    void deleteUser(Long idUser);

    List<User> getUsers();
}
