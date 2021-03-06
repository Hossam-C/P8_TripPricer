package com.p8.trippricer.demo.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tripPricer.Provider;
import tripPricer.TripPricer;

import java.util.List;
import java.util.UUID;

@Service
public class TripPricerServiceImpl implements TripPricerService{

    private Logger logger = LoggerFactory.getLogger(TripPricerServiceImpl.class);

    private final TripPricer tripPricer;

    public TripPricerServiceImpl() {
        this.tripPricer = new TripPricer();
    }


    @Override
    public List<Provider> getPrice(String apiKey, UUID attractionId, int adults, int children, int nightsStay, int rewardsPoints){

        logger.debug("getPrice");

        return tripPricer.getPrice(apiKey,attractionId,adults,children,nightsStay,rewardsPoints);
    }

    @Override
    public String getProviderName(String apiKey, int adults){


        logger.debug("getProviderName");

        return tripPricer.getProviderName(apiKey,adults);
    }
}
