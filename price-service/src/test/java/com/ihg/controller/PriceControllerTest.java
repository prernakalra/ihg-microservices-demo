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

import com.ihg.price.controller.PriceController;
import com.ihg.price.hibernate.model.HotelPricingInfo;
import com.ihg.price.model.HotelRoomPrice;
import com.ihg.price.service.PriceService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={PriceController.class})
@AutoConfigureMockMvc
public class PriceControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	private HotelPricingInfo hotelPricingInfo;
	private HotelRoomPrice hotelRoomPrice;
    @MockBean
    private PriceService priceService;
    @InjectMocks
    private PriceController priceController;
    private List<HotelRoomPrice> priceList;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(priceController).build();
        hotelPricingInfo = new HotelPricingInfo();
        hotelPricingInfo.setId(1);
        
        hotelRoomPrice = new HotelRoomPrice();
        hotelRoomPrice.setCurrencyCd("INR");
        hotelRoomPrice.setPrice("123");
        hotelRoomPrice.setRoomType("Single");
        
        priceList = new ArrayList<>();
        priceList.add(hotelRoomPrice);
    }
    
    @Test
    public void getHotelPriceByIdSuccess() throws Exception {
        when(priceService.getHotelPriceById(hotelPricingInfo.getId())).thenReturn(priceList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hotelprice/1")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(MockMvcResultMatchers.status().isOk())
        		.andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }
    
    @Test
    public void getHotelPriceByIdFailure() throws Exception {
        when(priceService.getHotelPriceById(hotelPricingInfo.getId())).thenThrow(Exception.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hotelprice/1")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(MockMvcResultMatchers.status().isOk())
        		.andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
    }

}
