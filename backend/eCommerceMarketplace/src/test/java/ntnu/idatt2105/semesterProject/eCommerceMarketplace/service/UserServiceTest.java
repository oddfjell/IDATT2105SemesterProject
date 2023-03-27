package ntnu.idatt2105.semesterProject.eCommerceMarketplace.service;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.controllers.UserController;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.User;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Rule //initMocks
    public MockitoRule rule = MockitoJUnit.rule();

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
        Iterable<User> result = userController.getAllUsers();

        // Verify the result
        assertNotNull(result);
        List<User> resultList = new ArrayList<>();
        result.forEach(resultList::add);
        assertEquals(2, resultList.size());
        assertEquals("user1", resultList.get(0).getUsername());
        assertEquals("user2", resultList.get(1).getUsername());
    }

    /*@Test
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
    }*/

}
