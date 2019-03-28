package com.rentabike;

/**
 * RentalPromotionEnum
 * @author javierrivero
 *
 */
public enum RentalPromotion {
    FAMILY_MIN_PROMO("Minimal Promo", 3),
    FAMILY_MAX_PROMO("Maximal Promo", 5),
    FAMILY_DISCOUNT_PROMO("Family Discount", 30);

    private String name;
    private double value;

    RentalPromotion(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

}
