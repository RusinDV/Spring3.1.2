package ru.mail.dtraider.crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mail.dtraider.crud.model.AuthGroup;

import java.util.List;

@Repository
public class AuthGroupDaoJpaRepositoryImpl implements AuthGroupDao {

    @Autowired
    AuthGroupJpaRepository authGroupJpaRepository;

    @Override
    public void createAuthGroup(AuthGroup authGroup) {
        authGroupJpaRepository.save(authGroup);
    }

    @Override
    public AuthGroup readAuthGroup(Long idAuthGroup) {
        return authGroupJpaRepository.getOne(idAuthGroup);
    }

    @Override
    public void updateAuthGroup(Long idAuthGroup, String name, String authGroup) {
        AuthGroup one = authGroupJpaRepository.getOne(idAuthGroup);
        one.setName(name);
        one.setAuthGroup(authGroup);
    }

    @Override
    public void deleteAuthGroup(Long idAuthGroup) {
        authGroupJpaRepository.deleteById(idAuthGroup);
    }

    @Override
    public void deleteAuthGroupByName(String name) {
        authGroupJpaRepository.deleteAuthGroupByName(name);
    }

    @Override
    public List<AuthGroup> getListAuthGroupByName(String name) {
        return authGroupJpaRepository.findByName(name);
    }

    @Override
    public List<AuthGroup> getAuthGroup() {
        return authGroupJpaRepository.findAll();
    }

    @Override
    public void deleteAuthGroupByNameAndAuthGroup(String name, String authGroup) {
        authGroupJpaRepository.deleteAuthGroupByNameAndAuthGroup(name,authGroup);
    }



}
