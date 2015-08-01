package com.thoughtworks.knapsack.utils.core;

import com.thoughtworks.knapsack.utils.core.interfaces.KnapsackCore;
import com.thoughtworks.knapsack.utils.dto.KnapsackDetailRequest;

/**
 * The Class KnapsackCoreImpl.
 */
public class KnapsackCoreImpl implements KnapsackCore {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.thoughtworks.knapsack.utils.core.interfaces.KnapsackCore#createMaxBenefitSack(com.thoughtworks.knapsack.utils.dto
     * .KnapsackDetail)
     */
    public boolean[] fetchMaxBenfitItems(final KnapsackDetailRequest knapsackDetail) {
        final int maxAllowedSackWeight = knapsackDetail.getMaxWeight();
        final int totalAvailableItems = knapsackDetail.getNumberOfItems();

        final int[] itemWeights = knapsackDetail.getWeights();
        final int[] itemBenefits = knapsackDetail.getBenefits();

        final int[][] knapsackBenefitMatrix = new int[totalAvailableItems + 1][maxAllowedSackWeight + 1];

        final boolean[][] optimalSolutionMatrix = new boolean[totalAvailableItems + 1][maxAllowedSackWeight + 1];

        for (int item = 1; item <= totalAvailableItems; item++) {
            for (int weight = 1; weight <= maxAllowedSackWeight; weight++) {
                // Algorithm says either take the nth item or dont take it that is the way for maximum benefit

                // option 1=> Dont take the n'th item
                int option1 = knapsackBenefitMatrix[item - 1][weight];

                // option 2 => Take item 2
                int option2 = 0;
                if (itemWeights[item] <= weight) {
                    option2 = itemBenefits[item] + knapsackBenefitMatrix[item - 1][weight - itemWeights[item]];
                }

                knapsackBenefitMatrix[item][weight] = Math.max(option1, option2);

                optimalSolutionMatrix[item][weight] = option2 > option1;
            }
        }

        final boolean[] selectedItems = new boolean[totalAvailableItems + 1];

        // Once the optimalSolution is prepared , find out those items which can actually be put up in the sack
        int weight = maxAllowedSackWeight;
        for (int item = totalAvailableItems; item >= 1; item--) {
            if (optimalSolutionMatrix[item][maxAllowedSackWeight]) {
                selectedItems[item] = true;
                weight = weight - itemWeights[item];
            } else {
                selectedItems[item] = false;
            }
        }

        return selectedItems;
    }

}
