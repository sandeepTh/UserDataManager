package com.sandeep.thandu.UserDataManager.controller;

import com.sandeep.thandu.UserDataManager.model.User;
import com.sandeep.thandu.UserDataManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
    Display all users
     */
    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    /*
     Add User Object
     */
    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    /*
    filter By LastName
     */
    @GetMapping("/search/lastName")
    public List<User> getUserByLastName(@RequestParam("lastName") String lastName){
        return userService.getUsersByLastName(lastName);
    }

    /*
    filter By Age
     */
    @GetMapping("/search/age")
    public List<User> getUserByAge(@RequestParam("age") int age){
        return userService.getUsersByAge(age);
    }

    /*
    filter By Age and LastName and Age
     */
    @GetMapping("/search")
    public List<User> getUserByAge(@RequestParam("age") int age, @RequestParam("lastName") String lastName){
        return userService.getUsersByAgeLastName(age, lastName);
    }

    /*
      Sort By FirstName
     */
    @GetMapping("/fName")
    public List<User> sortUsersByFirstName(){
        return userService.sortUsersByFirstName();
    }

    /*
    Sort By Age
     */
    @GetMapping("/age")
    public List<User> sortUsersByAge(){
        return userService.sortUsersByAge();
    }
}
