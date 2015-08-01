package com.thoughtworks.galaxy.guide.dto.constants;

/**
 * The Enum RomanLiteral.
 */
public enum RomanLiteral {

    /** The i. */
    I('I', 1),

    /** The v. */
    V('V', 5),

    /** The x. */
    X('X', 10),

    /** The l. */
    L('L', 50),

    /** The c. */
    C('C', 100),

    /** The d. */
    D('D', 500),

    /** The m. */
    M('M', 1000);

    /** The literal. */
    private char literal;

    /** The value. */
    private int value;

    /**
     * Instantiates a new roman literal.
     * 
     * @param literal the literal
     * @param value the value
     */
    private RomanLiteral(final char literal, final int value) {
        this.setLiteral(literal);
        this.setValue(value);
    }

    /**
     * Gets the valud for literal.
     * 
     * @param literal the literal
     * @return the valud for literal
     */
    public static int getValudForLiteral(final char literal) {
        for (final RomanLiteral romanLiteral : RomanLiteral.values()) {
            if (romanLiteral.getLiteral() == literal) {
                return romanLiteral.getValue();
            }
        }
        return 0;
    }

    /**
     * Gets the value.
     * 
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value.
     * 
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Gets the literal.
     * 
     * @return the literal
     */
    public char getLiteral() {
        return literal;
    }

    /**
     * Sets the literal.
     * 
     * @param literal the literal to set
     */
    public void setLiteral(char literal) {
        this.literal = literal;
    }

}
