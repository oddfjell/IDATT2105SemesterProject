package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.ECommerceMarketplaceApplication;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.User;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.model.LoginResponse;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;


import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Mock data -Call the API -Verify the result
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@SpringBootTest(webEnvironment = MOCK, classes = ECommerceMarketplaceApplication.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private User user;
    @BeforeEach
    void setup() {
        user = new User();
    }


    @Test
    public void testGetAllUsers() throws Exception {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("user1");
        userList.add(user1);
        User user2 = new User();
        user2.setId(2);
        user2.setUsername("user2");
        userList.add(user2);
        when(userService.getAllUsers()).thenReturn(userList);

        mockMvc.perform(get("http://localhost:8080/users/"))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$", hasSize(2)))
                        .andExpect(jsonPath("$[0].id", is(1)))
                        .andExpect(jsonPath("$[0].username", is("user1")))
                        .andExpect(jsonPath("$[1].id", is(2)))
                        .andExpect(jsonPath("$[1].username", is("user2")));
    }

    @Test
    public void testLoginUser() throws Exception {
        Map<String, Object> payload = new HashMap<>();
        //payload.put("username", "test1");
        //payload.put("password", "test1password");

        LoginResponse loginResponse = new LoginResponse("jwt", 11, "rÅle");// = new LoginResponse();
        ResponseEntity<LoginResponse> responseEntity = new ResponseEntity<>(loginResponse, HttpStatus.CREATED);
        when(userService.loginUser(payload)).thenReturn(responseEntity.getBody());

        mockMvc.perform(post("http://localhost:8080/users/service/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(payload)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.*", hasSize(3)))
                .andExpect(jsonPath("$.jwt", is("jwt")))
                .andExpect(jsonPath("$.id", is(11)))
                .andExpect(jsonPath("$.role", is("rÅle")));

    }

    @Test
    public void testCreateUser() throws Exception {
        User user1 = new User();

        ResponseEntity<Integer> responseEntity = new ResponseEntity<>(3, HttpStatus.CREATED);
        when(userService.createUser(user1)).thenReturn(responseEntity.getBody());

        mockMvc.perform(post("http://localhost:8080/users/service/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user1)))
                .andExpect(status().isConflict());

    }

    @Test
    public void testGetUserByUserName() throws Exception {
        String username = "user1";
        User user1 = new User();
        user1.setUsername(username);
        user1.setId(1);

        when(userService.getUserByUsername(username)).thenReturn(user1);

        mockMvc.perform(get("http://localhost:8080/users/getusername/"+username))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is(username)));
    }
    @Test
    public void testErrorGetUserByUserName() throws Exception {
        String username = "user1";

        when(userService.getUserByUsername(username)).thenReturn(null);

        mockMvc.perform(get("http://localhost:8080/users/getusername/"+username))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testErrorDeleteUser() throws Exception {
        User user1 = new User();

        when(userService.deleteUser(user1)).thenReturn(false);

        mockMvc.perform(delete("http://localhost:8080/users/deleteUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user1)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("false"));
    }

    @Test
    public void getNonExistentCourseReturns404() throws Exception {

        mockMvc.perform(get("/courses/1"))
                .andExpect(status().isNotFound());

        mockMvc.perform(get("/courses"))
                .andExpect(status().isNotFound());
    }
}