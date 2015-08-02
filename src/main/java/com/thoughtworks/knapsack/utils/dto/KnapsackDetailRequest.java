package com.thoughtworks.knapsack.utils.dto;

/**
 * The Class KnapsackDetailRequest.
 */
public class KnapsackDetailRequest {

    /** The number of items. */
    private int numberOfItems;

    /** The max weight. */
    private int maxWeight;

    /** The benefits. */
    private int[] benefits;

    /** The weights. */
    private int[] weights;

    /**
     * Gets the number of items.
     * 
     * @return the numberOfItems
     */
    public int getNumberOfItems() {
        return numberOfItems;
    }

    /**
     * Sets the number of items.
     * 
     * @param numberOfItems the numberOfItems to set
     */
    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    /**
     * Gets the max weight.
     * 
     * @return the maxWeight
     */
    public int getMaxWeight() {
        return maxWeight;
    }

    /**
     * Sets the max weight.
     * 
     * @param maxWeight the maxWeight to set
     */
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * Gets the benefits.
     * 
     * @return the benefits
     */
    public int[] getBenefits() {
        return benefits;
    }

    /**
     * Sets the benefits.
     * 
     * @param benefits the benefits to set
     */
    public void setBenefits(int[] benefits) {
        this.benefits = benefits;
    }

    /**
     * Gets the weights.
     * 
     * @return the weights
     */
    public int[] getWeights() {
        return weights;
    }

    /**
     * Sets the weights.
     * 
     * @param weights the weights to set
     */
    public void setWeights(int[] weights) {
        this.weights = weights;
    }

}
