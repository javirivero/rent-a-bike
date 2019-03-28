package com.rentabike;

/**
 * RentalTypeEnum
 * @author javierrivero
 *
 */
public enum RentalType {
    HOUR_RENTAL("Hour", 5),
    DAY_RENTAL("Day", 20),
    WEEK_RENTAL("Week", 60);

    private String type;
    private double price;

    RentalType(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }}
