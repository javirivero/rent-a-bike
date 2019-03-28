package com.rentabike.service;

import com.rentabike.model.BikeRental;

/**
 * BikeRentalService Interface
 * @author javierrivero
 *
 */
public interface BikeRentalService {
    /**
     * Perform calculation on rental charges
     * @param bikeRental rental unit
     * @return the charges
     */
    BikeRental rentTotal(BikeRental bikeRental);
}
