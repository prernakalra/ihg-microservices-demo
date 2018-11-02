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

import com.ihg.details.controller.HotelDetailsController;
import com.ihg.details.hibernate.model.HotelAddress;
import com.ihg.details.hibernate.model.HotelDetails;
import com.ihg.details.model.Address;
import com.ihg.details.model.HotelDetailsModel;
import com.ihg.details.service.HotelDetailsService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={HotelDetailsController.class})
@AutoConfigureMockMvc
public class HotelDetailsControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	private HotelDetailsModel hotelDetailsModel;
	private HotelDetails hotelDetails;
    @MockBean
    private HotelDetailsService hotelDetailsService;
    @InjectMocks
    private HotelDetailsController hotelDetailsController;
    private List<HotelDetailsModel> detailsList;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(hotelDetailsController).build();
        hotelDetailsModel = new HotelDetailsModel();
        hotelDetails = new HotelDetails();
        hotelDetails.setId(1);
        
        HotelAddress hotelAddress = new HotelAddress();
        hotelAddress.setCity("kolkata");
        hotelDetails.setHotelAddress(hotelAddress);
        
        Address ha = new Address();
        ha.setCity("kolkalta");
        ha.setCountry("India");
        ha.setStreetName("1st St");
        ha.setZipCode("5700001");
        ha.setStreetNumber("123");
        hotelDetailsModel.setAddress(ha);
        List<String> amenityList = new ArrayList<>();
        amenityList.add("Single");
        hotelDetailsModel.setAmenities(amenityList);
        hotelDetailsModel.setHotelId("12");
        List<String> phoneList = new ArrayList<>();
        phoneList.add("123");
        hotelDetailsModel.setPhoneList(phoneList);
        
        detailsList = new ArrayList<>();
        detailsList.add(hotelDetailsModel);
     }
    
    @Test
    public void getHotelsSuccess() throws Exception {
        when(hotelDetailsService.getAllHotelDetails()).thenReturn(detailsList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hotels-all")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }
    
    @Test
    public void getHotelsFailure() throws Exception {
        when(hotelDetailsService.getAllHotelDetails()).thenThrow(Exception.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hotels-all")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
    }
    
    @Test
    public void getHotelsByIdSuccess() throws Exception {
        when(hotelDetailsService.getHotelDetailsById(hotelDetails.getId())).thenReturn(hotelDetailsModel);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hotels/1")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }
    
    @Test
    public void getHotelsByIdFailure() throws Exception {
        when(hotelDetailsService.getHotelDetailsById(hotelDetails.getId())).thenThrow(Exception.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hotels/1")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
    }
    
    @Test
    public void getHotelsByLocationSuccess() throws Exception {
        when(hotelDetailsService.getHotelDetailsByLocation(hotelDetails.getHotelAddress().getCity())).thenReturn(detailsList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hotels/1")
        		.param("location", "kolkata")
        		.contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
    }
    
    @Test
    public void getHotelsByLocationFailure() throws Exception {
        when(hotelDetailsService.getHotelDetailsByLocation(hotelDetails.getHotelAddress().getCity())).thenThrow(Exception.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hotels/1")
        		.param("location", "kolkata")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
    }

}
