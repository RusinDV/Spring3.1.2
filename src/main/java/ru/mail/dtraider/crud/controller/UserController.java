package ru.mail.dtraider.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.mail.dtraider.crud.dao.UserDao;
import ru.mail.dtraider.crud.model.AuthGroup;
import ru.mail.dtraider.crud.model.User;
import ru.mail.dtraider.crud.service.AuthGroupService;
import ru.mail.dtraider.crud.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@PreAuthorize(value = "hasRole('USER')")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthGroupService authGroupService;

    @GetMapping("/user")
    public ModelAndView getIndex(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        User user = userService.readUserByEmail(principal.getName());
        List<AuthGroup> list=authGroupService.getListAuthGroupByName(user.getEmail());
        StringBuilder stringBuilder=new StringBuilder();
        for (AuthGroup authGroup : list) {
            stringBuilder.append(authGroup.getAuthGroup()+" ");
        }
        user.setAuthGroupList(stringBuilder.toString());

        modelAndView.addObject("user", user);

        return modelAndView;

    }


}
