package com.p8.trippricer.demo.Controller;


import com.p8.trippricer.demo.Service.TripPricerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tripPricer.Provider;

import java.util.List;
import java.util.UUID;

@RestController
public class TripPricerController {

    @Autowired
    private TripPricerService tripPricerService;

    @GetMapping("/")
    public String tripPricerHome() {
        return "P8 tripPricerHome";
    }

    @GetMapping(value = "/getPrice")
    public List<Provider> getPrice (@RequestParam String apiKey, @RequestParam UUID attractionId, @RequestParam int adults, @RequestParam int children, @RequestParam int nightsStay, @RequestParam int rewardsPoints)  {

        return tripPricerService.getPrice(apiKey,  attractionId,  adults,  children,  nightsStay,  rewardsPoints);
    }

    @GetMapping(value = "/getProviderName")
    public String getProviderName (@RequestParam String apiKey,@RequestParam int adults)  {
        return tripPricerService.getProviderName(apiKey,  adults);

    }


}
