package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controllers;

import jakarta.annotation.PostConstruct;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.ECommerceMarketplaceApplication;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.User;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.model.LoginResponse;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.service.UserService;
import org.junit.Rule;
import org.junit.Test;

import org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
    public void testGetAllUsers(){
        // Mock data
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

        // Call the API
        ResponseEntity<Iterable<User>> result = userController.getAllUsers();

        // Verify the result
        assertNotNull(result);
        List<User> resultList = new ArrayList<>();
        result.getBody().forEach(resultList::add);
        assertEquals(2, resultList.size());
        assertEquals("user1", resultList.get(0).getUsername());
        assertEquals("user2", resultList.get(1).getUsername());
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
        
        mockMvc.perform(get("/"))
                        .andExpect(status().isOk())
    }

    @Test
    void getNonExistentCourseReturns404() throws Exception {

        mockMvc.perform(get("/courses/1"))
                .andExpect(status().isNotFound());

        mockMvc.perform(get("/courses"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getExistentCourseWorks() throws Exception {
        when(service.getById(1))
                .thenReturn(response);

        mockMvc.perform(get("/courses/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(request.getCode())));
    }

    @Test
    void deletingCourseWorks() throws Exception {
        when(service.deleteById(1))
                .thenReturn(response);

        mockMvc.perform(delete("/courses/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(request.getCode())));
    }





    /**
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Rule //initMocks
    public MockitoRule rule = MockitoJUnit.rule();

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getNonExistentCourseReturns404() throws Exception {

        mockMvc.perform(get("/courses/1"))
                .andExpect(status().isNotFound());//.isNotFound());

        mockMvc.perform(get("/courses"))
                .andExpect(status().isNotFound());
    }


    @Test
    public void testGetAllUsers(){
        // Mock data
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

        // Call the API
        ResponseEntity<Iterable<User>> result = userController.getAllUsers();

        // Verify the result
        assertNotNull(result);
        List<User> resultList = new ArrayList<>();
        result.getBody().forEach(resultList::add);
        assertEquals(2, resultList.size());
        assertEquals("user1", resultList.get(0).getUsername());
        assertEquals("user2", resultList.get(1).getUsername());
    }*/




/*
    @Test
    public void testLoginUser() {
        // Mock data
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", "test1");
        payload.put("password", "test1password");
        LoginResponse loginResponse;// = new LoginResponse();
        loginResponse.setUsername("testuser");
        loginResponse.setToken("testtoken");
        ResponseEntity<LoginResponse> responseEntity = new ResponseEntity<>(loginResponse, HttpStatus.OK);
        when(userService.loginUser(payload)).thenReturn(responseEntity);

        // Call the API
        ResponseEntity<LoginResponse> result = userController.loginUser(payload);

        // Verify the result
        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("testuser", result.getBody().getUsername());
        assertEquals("testtoken", result.getBody().getToken());
    }

    @Test
    public void testCreateUser() {
        // Mock data
        User user = new User();
        user.setId(1);
        user.setUsername("testuser");
        when(userService.createUser(user)).thenReturn(1);

        // Call the API
        int result = userController.createUser(user);

        // Verify the result
        assertEquals(1, result);
    }

    @Test
    public void testGetUsername() {
        // Mock data
        User user = new User();
        user.setId(1);
        user.setUsername("testuser");
        when(userService.getUsername("testuser")).thenReturn(user);

        // Call the API
        User result = userController.getUsername("testuser");

        // Verify the result
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("testuser", result.getUsername());
    }

    @Test
    public void testGetUser(){

    }*/

}
/*
import TestResources.UnitsGnotts;
import WGames.Model.Classes.Army;
import WGames.Model.Classes.Filewriter;
import WGames.Model.Units.Unit;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArmyTest {

    @Test
    public void testConstructorWithName(){
        Army army = new Army("Army");

        assertEquals(army.getName(),"Army");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionEmptyNameConstructorWithName(){
        Army army = new Army("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionNameLengthConstructorWithName(){
        Army army = new Army("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionSymbolNameConstructorWithName(){
        Army army = new Army("+");
    }

    @Test
    public void testConstructorWithNameAndList(){
        List<Unit> units = new ArrayList<>();
        Army army = new Army("Army", units);

        assertEquals(army.getName(),"Army");
        assertEquals(army.getAllUnits().size(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionEmptyNameConstructorWithNameAndList(){
        List<Unit> units = new ArrayList<>();
        Army army = new Army("", units);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionSymbolNameConstructorWithNameAndList(){
        List<Unit> units = new ArrayList<>();
        Army army = new Army("+", units);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionNameLengthConstructorWithNameAndList(){
        List<Unit> units = new ArrayList<>();
        Army army = new Army("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr", units);
    }

    @Test
    public void testAddToArmy() {
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        ArrayList<Unit> gnotts = unitsGnotts.getGnotts();
        gnotts.add(unitsGnotts.getGnott1());

        assertEquals(1, gnotts.size());
    }

    @Test
    public void testAddAllToArmy() {
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        ArrayList<Unit> gnotts = new ArrayList<>();
        Army army = new Army("hei", gnotts);
        army.addAll(unitsGnotts.getSevralGnotts());

        assertEquals(4, army.getAllUnits().size());
    }


    @Test
    public void testRemoveFromArmy() {
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        ArrayList<Unit> gnotts = unitsGnotts.getSevralGnotts();
        gnotts.remove(0);

        assertEquals(3, gnotts.size());
    }

    @Test
    public void testHasUnits() {
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        assertTrue(unitsGnotts.premier().hasUnits());
        assertFalse(unitsGnotts.deuxieme().hasUnits());
    }

    @Test
    public void testGetInfantryUnits(){
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        assertEquals(1,unitsGnotts.premier().getInfantryUnits().size());
    }

    @Test
    public void testGetCommanderUnits(){
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        assertEquals(1,unitsGnotts.premier().getCommanderUnits().size());
    }

    @Test
    public void testCavalryUnits(){
        UnitsGnotts unitsGnotts = new UnitsGnotts();

        assertEquals(1,unitsGnotts.premier().getCavalryUnits().size());
    }

    @Test
    public void testGetRangedUnits(){
        UnitsGnotts unitsGnotts = new UnitsGnotts();
        Filewriter filewriter = new Filewriter();

        assertEquals(1,unitsGnotts.premier().getRangedUnits().size());
    }
}

 */