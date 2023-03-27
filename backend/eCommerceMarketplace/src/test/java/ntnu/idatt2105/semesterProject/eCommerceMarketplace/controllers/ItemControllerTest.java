package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.ECommerceMarketplaceApplication;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.Item;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.User;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.service.ItemService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@SpringBootTest(webEnvironment = MOCK, classes = ECommerceMarketplaceApplication.class)
@AutoConfigureMockMvc(addFilters = false)
public class ItemControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Test
    public void testGetAllItems() throws Exception {
        List<Item> itemList = new ArrayList<>();
        Item item1 = new Item();
        item1.setId(1);
        item1.setTitle("yey");
        itemList.add(item1);
        Item item2 = new Item();
        item2.setId(2);
        item2.setTitle("yeyyyyyy");
        itemList.add(item2);
        when(itemService.getAllItems()).thenReturn(itemList);

        mockMvc.perform(get("http://localhost:8080/item/service/getitems"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("yey")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].title", is("yeyyyyyy")));
    }


    @Test
    public void testGetItemsByUserId() throws Exception{
        String username = "user1";
        User user1 = new User();
        user1.setUsername(username);
        user1.setId(1);

        //when(itemService.getI.getUserByUsername(username)).thenReturn(user1);

        mockMvc.perform(get("http://localhost:8080/users/getusername/"+username))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is(username)));//TODO fiks ovenfor
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
                .andExpect(jsonPath("$.username", is(username)));//TODO fiks ovenfor
    }
    @Test
    public void testErrorGetUserByUserName() throws Exception {
        String username = "user1";

        when(userService.getUserByUsername(username)).thenReturn(null);

        mockMvc.perform(get("http://localhost:8080/users/getusername/"+username))
                .andExpect(status().isNotFound());
    }



     /*
        mockMvc.perform(delete("http://localhost:8080/users/deleteUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user1)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("false"));*/
    /*Item item = new Item();

        when(itemService.createItem(item)).thenReturn(true);

        mockMvc.perform(get("http://localhost:8080/item/createitem")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(item)))
                .andExpect(status().isCreated())
                .andExpect(content().string("true"));*/


}
