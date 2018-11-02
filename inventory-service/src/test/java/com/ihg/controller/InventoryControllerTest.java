package com.ihg.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ihg.model.InventoryType;
import com.ihg.model.RoomType;
import com.ihg.service.InventoryService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={InventoryController.class})
@AutoConfigureMockMvc
public class InventoryControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	private InventoryType inventoryType;
	private RoomType roomtype;
    @MockBean
    private InventoryService inventoryService;
    @InjectMocks
    private InventoryController inventoryController;
    private List<InventoryType> inventoryList;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(inventoryController).build();
        inventoryType = new InventoryType();
        inventoryType.setStatusDate("2018-08-31");
        roomtype = new RoomType();
        List<RoomType> roomList = new ArrayList<>();
        roomtype.setNumberOfBeds("2");
        roomtype.setRoomStatus("Available");
        roomtype.setRoomtype("AC");
        roomList.add(roomtype);
        inventoryType.setHotelRoomTypes(roomList);
        
        inventoryList = new ArrayList<>();
        
        inventoryList.add(inventoryType);
     }
    
    @Test
    public void getInventoryByHotelIdandDatesSuccess() throws Exception {
        when(inventoryService.getInventory(Long.parseLong("1"), "2018-08-31", "2018-09-02")).thenReturn(inventoryList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hotelinventory/1")
        		.param("startdate", "2018-08-31")
                .param("enddate", "2018-09-02")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }
    
    @Test
    public void getInventoryByHotelIdandDatesFailure() throws Exception {
        when(inventoryService.getInventory(Long.parseLong("1"), "2018-08-31", "2018-09-02")).thenThrow(Exception.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hotelinventory/1")
        		.param("startdate", "2018-08-31")
        		.param("enddate", "2018-09-02")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
    }

}
