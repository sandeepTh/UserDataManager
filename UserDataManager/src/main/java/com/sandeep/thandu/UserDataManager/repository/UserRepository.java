package com.sandeep.thandu.UserDataManager.repository;

import com.sandeep.thandu.UserDataManager.model.UserInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserInfo,Long> {


    List<UserInfo> findByLastName(String lastName);

    List<UserInfo> findByAge(int age);

    List<UserInfo> findByFirstName(String firstName);

    List<UserInfo> findAllByAgeAndLastName(int age, String lastName);
}
