package com.sandeep.thandu.UserDataManager.service;

import com.sandeep.thandu.UserDataManager.model.UserInfo;
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

    public List<UserInfo> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(UserInfo user) {
        userRepository.save(user);
    }

    //ToDO:
    public List<UserInfo> getUsersByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }


    public List<UserInfo> getUsersByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }


    public List<UserInfo> getUsersByAge(int age) {
        return userRepository.findByAge(age);
    }

    //sort By Age
    public List<UserInfo> sortUsersByAge() {
        List<UserInfo> userListByAge = userRepository.findAll().stream().sorted(Comparator.comparing(UserInfo::getAge)).collect(Collectors.toList());
        return userListByAge;
    }

    //sort By FirstName
    public List<UserInfo> sortUsersByFirstName() {
        List<UserInfo> usersListByFirstName = userRepository.findAll().stream().sorted(Comparator.comparing(UserInfo::getFirstName)).collect(Collectors.toList());
        return usersListByFirstName;
    }

    public List<UserInfo> getUsersByAgeLastName(int age, String lastName) {
       // List<UserInfo> userListAge =userRepository.findByAge(age);
        //List<UserInfo> userListLastName =userRepository.findByLastName(lastName);
        return userRepository.  findAllByAgeAndLastName(age,lastName);

        //findAllByPriceBetweenAndCityAndRentORbuyAndUtilitiesBetweenAndNumberOfBedsBetweenAndNum
        //List<UserInfo> combinedList = Stream.concat(userListAge.stream(),userListLastName.stream()).collect(Collectors.toList());
        //return combinedList;
    }
}
