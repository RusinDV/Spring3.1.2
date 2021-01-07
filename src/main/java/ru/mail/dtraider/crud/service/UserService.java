package ru.mail.dtraider.crud.service;



import ru.mail.dtraider.crud.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    User readUser(Long idUser);
    void updateUser(Long idUser,String name, String lastname, int age);
    void deleteUser(Long idUser);
    List<User> getUsers();
}
