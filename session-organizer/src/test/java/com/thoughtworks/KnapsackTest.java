package com.thoughtworks;

import com.thoughtworks.knapsack.utils.core.KnapsackCoreImpl;
import com.thoughtworks.knapsack.utils.core.interfaces.KnapsackCore;
import com.thoughtworks.knapsack.utils.dto.KnapsackDetailRequest;

public class KnapsackTest {

    public static void main(final String args[]) {
        final KnapsackCore knapsackCore = new KnapsackCoreImpl();

        final KnapsackDetailRequest knapsackDetail = new KnapsackDetailRequest();
        knapsackDetail.setNumberOfItems(4);
        knapsackDetail.setMaxWeight(7);

        final int[] itemWeights = new int[] { 0 , 2, 3, 7, 9 };
        final int[] itemBenefits = new int[] { 0 , 3, 12, 15, 5 };

        knapsackDetail.setBenefits(itemBenefits);
        knapsackDetail.setWeights(itemWeights);

        final boolean[] maxBenefitItems = knapsackCore.fetchMaxBenfitItems(knapsackDetail);
    }
}
