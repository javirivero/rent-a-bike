package com.rentabike;

import com.rentabike.model.BikeRental;
import com.rentabike.model.BikeRentalItem;
import com.rentabike.service.BikeRentalService;
import com.rentabike.service.impl.BikeRentalServiceImpl;
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
    BikeRentalService bikeRentalService = new BikeRentalServiceImpl();

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

        Assert.assertEquals(bikeRentalResult.getTotal(), 20, 0);
        Assert.assertEquals(bikeRentalItems.get(0).getAmount(), 20, 0);

    }

    @Test
    public void rentByDayTest() {
        BikeRentalItem  bikeRentalItem = new BikeRentalItem.Builder().quantity(5).
                type(RentalType.DAY_RENTAL).build();

        List<BikeRentalItem> bikeRentalItems = new ArrayList<>();
        bikeRentalItems.add(bikeRentalItem);
        bikeRental.setBikeRentalItems(bikeRentalItems);

        BikeRental bikeRentalResult = bikeRentalService.rentTotal(bikeRental);

        Assert.assertEquals(bikeRentalResult.getTotal(), 100, 0);
        Assert.assertEquals(bikeRentalItems.get(0).getAmount(), 100, 0);
    }

    @Test
    public void rentByWeekTest() {
        BikeRentalItem  bikeRentalItem = new BikeRentalItem.Builder().quantity(5).
                type(RentalType.WEEK_RENTAL).build();

        List<BikeRentalItem> bikeRentalItems = new ArrayList<>();
        bikeRentalItems.add(bikeRentalItem);
        bikeRental.setBikeRentalItems(bikeRentalItems);

        BikeRental bikeRentalResult = bikeRentalService.rentTotal(bikeRental);

        Assert.assertEquals(bikeRentalResult.getTotal(), 300, 0);
        Assert.assertEquals(bikeRentalItems.get(0).getAmount(), 300, 0);
    }

    @Test
    public void rentFamilyDiscount() {
        BikeRentalItem  bikeRentalItem1 = new BikeRentalItem.Builder().quantity(5).
                type(RentalType.WEEK_RENTAL).build();
        BikeRentalItem  bikeRentalItem2 = new BikeRentalItem.Builder().quantity(5).
                type(RentalType.DAY_RENTAL).build();
        BikeRentalItem  bikeRentalItem3 = new BikeRentalItem.Builder().quantity(5).
                type(RentalType.HOUR_RENTAL).build();

        List<BikeRentalItem> bikeRentalItems = new ArrayList<>();
        bikeRentalItems.add(bikeRentalItem1);
        bikeRentalItems.add(bikeRentalItem2);
        bikeRentalItems.add(bikeRentalItem3);
        bikeRental.setBikeRentalItems(bikeRentalItems);
        bikeRental.setRentalPromotion(RentalPromotion.FAMILY_DISCOUNT_PROMO);

        BikeRental bikeRentalResult = bikeRentalService.rentTotal(bikeRental);

        Assert.assertEquals(bikeRentalResult.getTotal(), 297.5, 0);

    }
}
