package ru.mail.dtraider.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mail.dtraider.crud.model.User;

public interface UserJPARepository extends JpaRepository<User, Long> {
}
