package com.p8.trippricer.demo.Controller;


import com.p8.trippricer.demo.Service.TripPricerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tripPricer.Provider;

import java.util.List;
import java.util.UUID;

@RestController
public class TripPricerController {

    private Logger logger = LoggerFactory.getLogger(TripPricerController.class);

    @Autowired
    private TripPricerService tripPricerService;

    @GetMapping("/")
    public String tripPricerHome() {

        logger.info("Controller : tripPricer Home");

        return "P8 tripPricerHome";
    }

    @GetMapping(value = "/getPrice")
    public List<Provider> getPrice (@RequestParam String apiKey, @RequestParam UUID attractionId, @RequestParam int adults, @RequestParam int children, @RequestParam int nightsStay, @RequestParam int rewardsPoints)  {

        logger.info("Controller : getPrice");

        return tripPricerService.getPrice(apiKey,  attractionId,  adults,  children,  nightsStay,  rewardsPoints);
    }

    @GetMapping(value = "/getProviderName")
    public String getProviderName (@RequestParam String apiKey,@RequestParam int adults)  {

        logger.info("Controller : getProviderName");

        return tripPricerService.getProviderName(apiKey,  adults);

    }


}
