package ru.mail.dtraider.crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mail.dtraider.crud.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoJpaRepositoryImpl implements UserDao {
    @Autowired
    UserJPARepository userJPARepository;

    @Override
    public void createUser(User user) {
        userJPARepository.save(user);
    }

    @Override
    public User readUser(Long idUser) {
        User user = userJPARepository.getOne(idUser);
        return user;
    }

    @Override
    public void updateUser(Long idUser, String name, String lastname, int age) {
        User user = userJPARepository.getOne(idUser);
        user.setName(name);
        user.setLastName(lastname);
        user.setAge(age);
        userJPARepository.save(user);
    }

    @Override
    public void deleteUser(Long idUser) {
        userJPARepository.deleteById(idUser);
    }

    @Override
    public List<User> getUsers() {
        return userJPARepository.findAll();
    }
}
