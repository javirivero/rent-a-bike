package com.rentabike.service.impl;

import com.rentabike.RentalPromotion;
import com.rentabike.RentalType;
import com.rentabike.model.BikeRental;
import com.rentabike.model.BikeRentalItem;
import com.rentabike.service.BikeRentalService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BikeRentalService Implementation
 * @author javierrivero
 */
public class BikeRentalServiceImpl implements BikeRentalService {

    private final static Logger logger = LoggerFactory.getLogger(BikeRentalServiceImpl.class);
    @Override
    public BikeRental rentTotal(BikeRental bikeRental) {
        double discount = 0;
        double total = 0;
        if (bikeRental == null || CollectionUtils.isEmpty(bikeRental.getBikeRentalItems())) {
            logger.error("No rental items to process...");
        }
        if (bikeRental.getRentalPromotion() != null &&
                RentalPromotion.FAMILY_DISCOUNT_PROMO.getName().equals(bikeRental.getRentalPromotion().getName())) {
            if (bikeRental.getBikeRentalItems().size() < RentalPromotion.FAMILY_MIN_PROMO.getValue()
                || bikeRental.getBikeRentalItems().size() > RentalPromotion.FAMILY_MAX_PROMO.getValue()) {
                logger.error("Rent not fit for discount");
            } else {
                discount = RentalPromotion.FAMILY_DISCOUNT_PROMO.getValue();
                bikeRental.setRentalPromotion(RentalPromotion.FAMILY_DISCOUNT_PROMO);
            }
        }
        for (BikeRentalItem bikeRentalItem : bikeRental.getBikeRentalItems()) {
            double amount = 0;
            switch (bikeRentalItem.getRentalType()) {
                case HOUR_RENTAL:
                    amount = RentalType.HOUR_RENTAL.getPrice() * bikeRentalItem.getQuantity();
                    break;
                case DAY_RENTAL:
                    amount = RentalType.DAY_RENTAL.getPrice() * bikeRentalItem.getQuantity();
                    break;
                case WEEK_RENTAL:
                    amount = RentalType.WEEK_RENTAL.getPrice() * bikeRentalItem.getQuantity();
                    break;
                default:
                    logger.error("Incorrect rental type...");
            }
            bikeRentalItem.setAmount(amount);
            total += amount;
        }
        if (discount > 0 ) {
            double discountMade = (total * discount / 100);
            total = total - discountMade;
        }
        bikeRental.setTotal(total);

        return bikeRental;
    }
}
