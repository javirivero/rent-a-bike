package com.rentabike.model;

import com.rentabike.RentalType;

/**
 * BikeRentalItemClass
 * @author javier rivero
 *
 */
public class BikeRentalItem {
    private int quantity;
    private RentalType rentalType;
    private double amount;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public RentalType getRentalType() {
        return rentalType;
    }

    public void setRentalType(RentalType rentalType) {
        this.rentalType = rentalType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static class Builder {
        int quantity;
        RentalType rentalType;

        public Builder quantity(int quantity){
            this.quantity = quantity;
            return this;
        }

        public Builder type(RentalType rentalType){
            this.rentalType = rentalType;
            return this;
        }

        public BikeRentalItem build(){
            BikeRentalItem bikeRentalItem = new BikeRentalItem();
            bikeRentalItem.quantity = this.quantity;
            bikeRentalItem.rentalType = this.rentalType;

            return bikeRentalItem;
        }
    }
}
