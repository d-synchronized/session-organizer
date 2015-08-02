package com.thoughtworks.knapsack.utils.core.interfaces;

import com.thoughtworks.knapsack.utils.dto.KnapsackDetailRequest;

/**
 * The Interface KnapsackCore.
 */
public interface KnapsackCore {

    /**
     * Creates the max benefit sack.
     * 
     * @param knapsackDetail the knapsack detail
     */
    boolean[] fetchMaxBenfitItems(final KnapsackDetailRequest knapsackDetail);

}
