package com.rentabike.model;

import com.rentabike.RentalPromotion;

import java.util.List;

/**
 * BikeRental
 * @author javierrivero
 *
 */
public class BikeRental {
    private List<BikeRentalItem> bikeRentalItems;
    private RentalPromotion rentalPromotion;
    private double total;

    public List<BikeRentalItem> getBikeRentalItems() {
        return bikeRentalItems;
    }

    public void setBikeRentalItems(List<BikeRentalItem> bikeRentalItems) {
        this.bikeRentalItems = bikeRentalItems;
    }

    public RentalPromotion getRentalPromotion() {
        return rentalPromotion;
    }

    public void setRentalPromotion(RentalPromotion rentalPromotion) {
        this.rentalPromotion = rentalPromotion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
