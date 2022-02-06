package com.sandeep.thandu.UserDataManager.repository;

import com.sandeep.thandu.UserDataManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    List<User> findByLastName(String lastName);

    List<User> findByAge(int age);

    List<User> findByFirstName(String firstName);
}
