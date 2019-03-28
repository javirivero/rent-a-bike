package com.rentabike.model;

import com.rentabike.RentalPromotion;

import java.util.List;

/**
 * BikeRentalRate
 * @author javierrivero
 *
 */
public class BikeRentalRate {
    private List<BikeRentalItem> bikeRentalItems;
    private RentalPromotion rentalPromotion;
    private double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
