package com.sandeep.thandu.UserDataManager.controller;

import com.sandeep.thandu.UserDataManager.model.User;
import com.sandeep.thandu.UserDataManager.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getUsers() throws Exception {
    User user1 = new User(1L,3,"FN1","LN","AD1","AD2");
    User user2 = new User(2L,4,"FN2","LN","AD1","AD2");
    User user3 = new User(3L,5,"FN3","LN","AD1","AD2");
    List<User> userList = Arrays.asList(user1,user2,user3);
        Mockito.when(userService.getUsers()).thenReturn(userList);
        MvcResult mvcResult = mockMvc.perform(
            MockMvcRequestBuilders.get("/user/all")
                    .contentType(MediaType.APPLICATION_JSON)
                ).andReturn();
    }

    @Test
    void addUser() {
    }

    @Test
    void getUserByLastName() {
    }

    @Test
    void getUserByAge() {
    }

    @Test
    void testGetUserByAge() {
    }

    @Test
    void sortUsersByFirstName() {
    }

    @Test
    void sortUsersByAge() {
    }
}