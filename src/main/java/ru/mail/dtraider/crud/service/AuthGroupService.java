package ru.mail.dtraider.crud.service;

import ru.mail.dtraider.crud.model.AuthGroup;

import java.util.List;

public interface AuthGroupService {
    void createAuthGroup(AuthGroup authGroup);
    AuthGroup readAuthGroup(Long idAuthGroup);
    void updateAuthGroup(Long idAuthGroup,String name, String authGroup);
    void deleteAuthGroup(Long idAuthGroup);
    void deleteAuthGroupByName(String name);
    List<AuthGroup> getListAuthGroupByName(String name);
    List<AuthGroup> getAuthGroup();
    void deleteAuthGroupByNameAndAuthGroup(String name,String authGroup);

}
