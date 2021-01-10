package ru.mail.dtraider.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mail.dtraider.crud.model.AuthGroup;

import java.util.List;

public interface AuthGroupJpaRepository extends JpaRepository<AuthGroup, Long> {
    List<AuthGroup> findByName(String authGroupName);

    void deleteAuthGroupByName(String name);

    void deleteAuthGroupByNameAndAuthGroup(String name, String authGroup);
}
