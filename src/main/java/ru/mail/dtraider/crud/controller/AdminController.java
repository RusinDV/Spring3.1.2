package ru.mail.dtraider.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.mail.dtraider.crud.model.AuthGroup;
import ru.mail.dtraider.crud.model.User;
import ru.mail.dtraider.crud.service.AuthGroupService;
import ru.mail.dtraider.crud.service.UserService;


import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/admin")
@PreAuthorize(value = "hasRole('ADMIN')")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    AuthGroupService authGroupService;

    @GetMapping("/")
    public ModelAndView getIndex(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();

        User userP = userService.readUserByEmail(principal.getName());
        List<AuthGroup> listP=authGroupService.getListAuthGroupByName(userP.getEmail());
        StringBuilder stringBuilderP=new StringBuilder();
        for (AuthGroup authGroup : listP) {
            stringBuilderP.append(authGroup.getAuthGroup()+" ");
        }
        userP.setAuthGroupList(stringBuilderP.toString());
        modelAndView.addObject("user", userP);

        modelAndView.addObject("newUser", new User());
        List<User> allUsers = userService.getUsers();
        for (User allUser : allUsers) {
            List<AuthGroup> list = authGroupService.getListAuthGroupByName(allUser.getEmail());
            StringBuilder stringBuilder = new StringBuilder();
            for (AuthGroup authGroup : list) {
                stringBuilder.append(authGroup.getAuthGroup() + " ");
            }
            allUser.setAuthGroupList(stringBuilder.toString());
        }
        modelAndView.addObject("allUsers", allUsers);

        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView getAdd(@ModelAttribute("user") User theUser, @ModelAttribute("role") String role) {
        ModelAndView modelAndView = new ModelAndView();

        AuthGroup authGroup = new AuthGroup();
        authGroup.setName(theUser.getEmail());
        authGroup.setAuthGroup("USER");
        authGroupService.createAuthGroup(authGroup);

        if (role.equals("admin")) {
            AuthGroup authGroup2 = new AuthGroup();
            authGroup2.setName(theUser.getEmail());
            authGroup2.setAuthGroup("ADMIN");
            authGroupService.createAuthGroup(authGroup2);
        }
        String encode = new BCryptPasswordEncoder(11).encode(theUser.getPassword());
        theUser.setPassword(encode);
        userService.createUser(theUser);
        modelAndView.setViewName("redirect:/admin/");
        return modelAndView;
    }

    @PostMapping(value = "/delete")
    public ModelAndView getDelete(@ModelAttribute("newUser") User theUser) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin/");
        authGroupService.deleteAuthGroupByName(theUser.getEmail());
        userService.deleteUser(theUser.getId());
        return modelAndView;
    }


    @PostMapping(value = "update")
    public ModelAndView getUpdatePost(@ModelAttribute("newUser") User theUser, @ModelAttribute("role") String role) {
        ModelAndView modelAndView = new ModelAndView();

        User userOld = userService.readUser(theUser.getId());
        authGroupService.deleteAuthGroupByName(userOld.getEmail());

        AuthGroup authGroupUser = new AuthGroup();
        authGroupUser.setName(theUser.getEmail());
        authGroupUser.setAuthGroup("USER");
        authGroupService.createAuthGroup(authGroupUser);

        if (role.equals("admin")) {
            AuthGroup authGroupAdmin = new AuthGroup();
            authGroupAdmin.setName(theUser.getEmail());
            authGroupAdmin.setAuthGroup("ADMIN");
            authGroupService.createAuthGroup(authGroupAdmin);
        }
        String encode = new BCryptPasswordEncoder(11).encode(theUser.getPassword());

        userService.updateUser(theUser.getId(), theUser.getFirstName(), theUser.getLastName(), theUser.getAge(), theUser.getEmail(), encode);

        modelAndView.setViewName("redirect:/admin/");
        return modelAndView;
    }

}