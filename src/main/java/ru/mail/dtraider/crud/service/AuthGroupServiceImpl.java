package ru.mail.dtraider.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.dtraider.crud.dao.AuthGroupDao;
import ru.mail.dtraider.crud.model.AuthGroup;

import java.util.List;

@Service
public class AuthGroupServiceImpl implements AuthGroupService {

    @Autowired
    AuthGroupDao authGroupDao;
    @Transactional
    @Override
    public void createAuthGroup(AuthGroup authGroup) {
        authGroupDao.createAuthGroup(authGroup);
    }
    @Transactional
    @Override
    public AuthGroup readAuthGroup(Long idAuthGroup) {
        return authGroupDao.readAuthGroup(idAuthGroup);
    }
    @Transactional
    @Override
    public void updateAuthGroup(Long idAuthGroup, String name, String authGroup) {
        authGroupDao.updateAuthGroup(idAuthGroup, name, authGroup);
    }
    @Transactional
    @Override
    public void deleteAuthGroup(Long idAuthGroup) {
        deleteAuthGroup(idAuthGroup);
    }
    @Transactional
    @Override
    public void deleteAuthGroupByName(String name) {
        authGroupDao.deleteAuthGroupByName(name);
    }
    @Transactional
    @Override
    public List<AuthGroup> getListAuthGroupByName(String name) {
        return authGroupDao.getListAuthGroupByName(name);
    }
    @Transactional
    @Override
    public List<AuthGroup> getAuthGroup() {
        return authGroupDao.getAuthGroup();
    }
    @Transactional
    @Override
    public void deleteAuthGroupByNameAndAuthGroup(String name, String authGroup) {
        authGroupDao.deleteAuthGroupByNameAndAuthGroup(name,authGroup);
    }

}
