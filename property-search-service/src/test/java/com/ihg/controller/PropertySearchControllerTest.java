package com.ihg.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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

import com.ihg.model.HotelDetails;
import com.ihg.service.PropertySearchService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={PropertySearchController.class})
@AutoConfigureMockMvc
public class PropertySearchControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	private HotelDetails hotelDetails;
	
	@MockBean
    private PropertySearchService propertySearchService;
	
	@InjectMocks
    private PropertySearchController propertySearchController;
	private List<HotelDetails> detailsList;
	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(propertySearchController).build();
        
        hotelDetails = new HotelDetails();
        hotelDetails.setHotelId("1");
      
        detailsList = new ArrayList<>();
        detailsList.add(hotelDetails);
    }
	
	@Test
    public void getHotelDetailsSuccess() throws Exception {
        when(propertySearchService.getHotelDetails("kolkata","2018-08-31","2018-09-02","2","1")).thenReturn(detailsList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hotel")
        		.param("location", "kolkata")
        		.param("startdate", "2018-08-31")
        		.param("enddate", "2018-09-02")
        		.param("numberofrooms", "2")
        		.param("numberofadults", "1")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(MockMvcResultMatchers.jsonPath("$").exists())
        		.andDo(print());
    }
    
    @Test
    public void ggetHotelDetailsFailure() throws Exception {
        when(propertySearchService.getHotelDetails("kolkata","2018-08-31","2018-09-02","2","1")).thenThrow(Exception.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hotel")
        		.param("location", "kolkata")
        		.param("startdate", "2018-08-31")
        		.param("enddate", "2018-09-02")
        		.param("numberofrooms", "2")
        		.param("numberofadults", "1")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
    }

}
