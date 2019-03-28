package com.rentabike;

import com.rentabike.model.BikeRental;
import com.rentabike.model.BikeRentalItem;
import com.rentabike.service.BikeRentalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RentABikeTest {
    @InjectMocks
    BikeRentalService bikeRentalService;

    @InjectMocks
    BikeRental bikeRental;

    @Test
    public void rentByHourTest() {
        BikeRentalItem bikeRentalItem = new BikeRentalItem.Builder().quantity(4).
                type(RentalType.HOUR_RENTAL).build();
        List<BikeRentalItem> bikeRentalItems = new ArrayList<>();
        bikeRentalItems.add(bikeRentalItem);
        bikeRental.setBikeRentalItems(bikeRentalItems);

        BikeRental bikeRentalResult = bikeRentalService.rentTotal(bikeRental);

        Assert.assertEquals(20, bikeRentalResult.getTotal());
        Assert.assertEquals(20, bikeRentalItems.get(0).getAmount());

    }
}
