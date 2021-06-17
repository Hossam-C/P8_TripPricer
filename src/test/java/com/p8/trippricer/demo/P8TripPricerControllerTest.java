package com.p8.trippricer.demo;


import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class P8TripPricerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void tripPricerHome() throws Exception {
        Locale.setDefault(Locale.US);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk());

    }
    @Test
    public void tripPricerControllerResponseOK () throws Exception {

        String apiKey="test-server-api-key";
        UUID attractionId=UUID.randomUUID();
        int adults=2;
        int children=1;
        int nightsStay=5;
        int rewardsPoints=5;

        mockMvc.perform(get("/getPrice?apiKey="+apiKey+"&attractionId=" + attractionId+"&adults=" + adults+"&children=" + children+"&nightsStay=" + nightsStay+"&rewardsPoints=" + rewardsPoints))
                .andExpect(status().isOk());
    }
    @Test
    public void tripPricerControllerApiKeyEmpty () throws Exception {

        String apiKey="test-server-api-key";
        UUID attractionId=UUID.randomUUID();
        int adults=2;
        int children=1;
        int nightsStay=5;
        int rewardsPoints=5;

        mockMvc.perform(get("/getPrice?apiKey="+apiKey+"&attractionId=" + attractionId+"&adults=" + adults+"&children=" + children+"&nightsStay=" + nightsStay+"&rewardsPoints=" + rewardsPoints))
                .andExpect(status().isBadRequest());
    }

}
