package ntnu.idatt2105.semesterProject.eCommerceMarketplace.service;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.ECommerceMarketplaceApplication;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.controllers.UserController;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.User;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.model.LoginResponse;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories.UserRepository;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.security.service.TokenService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@SpringBootTest(webEnvironment = MOCK, classes = ECommerceMarketplaceApplication.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserServiceTest {



    @Mock
    private UserRepository userRepository;

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        userRepository = mock(UserRepository.class);
        tokenService = mock(TokenService.class);
        userService = mock(UserService.class);
    }

    /**@Test
    public void testLoginUser() {
        // Mock UserRepository
        User user = new User();
        user.setUsername("user1");
        user.setPassword("pass1");



        when(userRepository.findAll()).thenReturn(List.of(user));
        when(userRepository.findByUsername("user1")).thenReturn(user);

        // Mock TokenService
        when(tokenService.generateToken("user1")).thenReturn("jwt_token");

        // Test loginUser
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", "user1");
        payload.put("password", "pass1");
        LoginResponse response = userService.loginUser(payload);

        //assertNotNull(response);
        assertEquals("jwt_token", response.getJwt());
        //assertEquals("user1", response.getgetUsername());
    }*/

    @Test
    public void testCreateUser() {
        // Mock UserRepository
        when(userRepository.findByUsername("user1")).thenReturn(null);
        when(userRepository.findByPhoneNumber("12345678")).thenReturn(null);
        when(userRepository.findByEmail("user1@test.com")).thenReturn(null);

        // Test createUser
        User user = new User();
        user.setUsername("user1");
        user.setPassword("pass1");
        user.setPhoneNumber("12345678");
        user.setEmail("user1@test.com");
        int result = userService.createUser(user);

        assertEquals(3, result);
    }

    @Test
    public void testGetUserByUsername() {
        // Mock UserRepository
        User user = new User();
        user.setUsername("user1");
        when(userRepository.findByUsername(anyString())).thenReturn(user);

        // Test getUserByUsername
        User result = userService.getUserByUsername("user1");

        assertNotNull(result);
        assertEquals("user1", result.getUsername());
    }

    @Test
    public void testGetUserById() {
        // Mock UserRepository
        User user = new User();
        user.setId(1);
        when(userRepository.findById(1)).thenReturn(user);

        // Test getUserById
        User result = userService.getUserById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
    }


    /**
    @Mock
    private User user;
    @Mock
    private LoginResponse loginResponse;
    @Mock
    private UserRepository userRepository;
    @Mock
    private TokenService tokenService;
    @Spy
    @InjectMocks
    private UserService userService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testLoginUserWithValidCredentials() {
        // Arrange
        String username = "testuser";
        String password = "password";
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        when(userRepository.findAll()).thenReturn(java.util.Arrays.asList(user));
        when(tokenService.generateToken(username)).thenReturn("testtoken");
        when(userRepository.findByUsername(username)).thenReturn(user);

        Map<String, Object> payload = new HashMap<>();
        payload.put("username", username);
        payload.put("password", password);

        when(userService.loginUser(payload).thenReturn())
        // Act
        LoginResponse loginResponse = userService.loginUser(payload);

        // Assert
        assertNotNull(loginResponse);
        assertEquals("testtoken", loginResponse.getJwt());
        assertEquals(0, loginResponse.getId());
        assertEquals("ROLE_USER", loginResponse.getRole());
    }

    @Test
    public void testLoginUserWithInvalidCredentials() {
        // Arrange
        String username = "testuser";
        String password = "password";
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        Mockito.when(userRepository.findAll()).thenReturn(java.util.Arrays.asList(user));

        Map<String, Object> payload = new HashMap<>();
        payload.put("username", username);
        payload.put("password", "invalidpassword");

        // Act
        LoginResponse loginResponse = userService.loginUser(payload);

        // Assert
        assertNull(loginResponse);
    }

    @Test
    public void testCreateUserWithValidData() {
        // Arrange
        User user = new User();
        user.setUsername("testuser");
        user.setPhoneNumber("12345678");
        user.setEmail("testuser@test.com");

        Mockito.when(userRepository.findByUsername(user.getUsername())).thenReturn(null);
        Mockito.when(userRepository.findByPhoneNumber(user.getPhoneNumber())).thenReturn(null);
        Mockito.when(userRepository.findByEmail(user.getEmail())).thenReturn(null);
        Mockito.when(userRepository.save(user)).thenReturn(user);

        // Act
        int result = userService.createUser(user);

        // Assert
        assertEquals(3, result);
    }

    @Test
    public void testCreateUserWithDuplicateUsername() {
        // Arrange
        User user = new User();
        user.setUsername("testuser");
        user.setPhoneNumber("12345678");
        user.setEmail("testuser@test.com");

        Mockito.when(userRepository.findByUsername(user.getUsername())).thenReturn(user);

        // Act
        int result = userService.createUser(user);

        // Assert
        assertEquals(0, result);
    }*/

}
