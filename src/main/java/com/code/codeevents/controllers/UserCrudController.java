package com.code.codeevents.controllers;


import com.code.codeevents.data.UserCrudRepository;
import com.code.codeevents.models.Role;
import com.code.codeevents.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
@RequestMapping("users")
public class UserCrudController {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping
    public String displayAllUsers(Model model) {
       model.addAttribute("title", "All Users");
       model.addAttribute("users", userCrudRepository.findAll());
       return "users/index";
    }

    @GetMapping("create")
    public String displayCreateUserForm(Model model) {
        model.addAttribute("title", "Add new User");
        model.addAttribute(new User());
        return "users/create";
    }

    @PostMapping("create")
    public String processCreateUserForm(@ModelAttribute @Valid User newUser,
                                            Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add new User");
            model.addAttribute(newUser);
            return "users/create";
        }

        System.out.println("add: " + passwordEncoder.encode(newUser.getPassword()) + " parola " + newUser.getPassword());
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setRoles(Arrays.asList(new Role("USER")));
        userCrudRepository.save(newUser);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteUsersForm(Model model) {
        model.addAttribute("title", "Delete User");
        model.addAttribute("users", userCrudRepository.findAll());
        return "users/delete";
    }

    @PostMapping("delete")
    public String processDeleteUsersForm(@RequestParam(required = false) Long[] userIds) {
        if(userIds != null) {
            for (Long id : userIds) {
                userCrudRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("edit")
    public String renderUpdatePetForm(Model model){
        model.addAttribute("title", "Edit User");
        model.addAttribute(new User());
        model.addAttribute("userIds", userCrudRepository.findAll());
        return "users/edit";
    }

    @PostMapping("edit")
    public String updatePet(@RequestParam(required = false) Long[] userIds, Model model,
                            @ModelAttribute @Valid User newUser, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title", "Edit User");
            return "users/edit";
        }
        if(userIds != null) {
            for (Long id : userIds) {
                userCrudRepository.deleteById(id);
            }
        }
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setRoles(Arrays.asList(new Role("USER")));

        userCrudRepository.save(newUser);
        return "redirect:";
    }

}
