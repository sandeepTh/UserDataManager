package com.sandeep.thandu.UserDataManager.service;

import com.sandeep.thandu.UserDataManager.model.User;
import com.sandeep.thandu.UserDataManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    //ToDO:
    public List<User> getUsersByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }


    public List<User> getUsersByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }


    public List<User> getUsersByAge(int age) {
        return userRepository.findByAge(age);
    }

    //sort By Age
    public List<User> sortUsersByAge() {
        List<User> userListByAge = userRepository.findAll().stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        return userListByAge;
    }

    //sort By FirstName
    public List<User> sortUsersByFirstName() {
        List<User> usersListByFirstName = userRepository.findAll().stream().sorted(Comparator.comparing(User::getFirstName)).collect(Collectors.toList());
        return usersListByFirstName;
    }

    public List<User> getUsersByAgeLastName(int age, String lastName) {
        List<User> userListAge =userRepository.findByAge(age);
        List<User> userListLastName =userRepository.findByLastName(lastName);
        List<User> combinedList = Stream.concat(userListAge.stream(),userListLastName.stream()).collect(Collectors.toList());
        return combinedList;
    }
}
