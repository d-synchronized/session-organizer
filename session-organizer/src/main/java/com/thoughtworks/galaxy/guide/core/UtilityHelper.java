package com.thoughtworks.galaxy.guide.core;

import org.apache.commons.lang.StringUtils;

import com.thoughtworks.galaxy.guide.dto.constants.RomanLiteral;

/**
 * The Class UtilityHelper.
 */
public class UtilityHelper {

    /**
     * Validate literals.
     * 
     * @param literalQuery the literal query
     * @return true, if successful
     */
    public static boolean validateLiterals(final String literalQuery) {
        if (StringUtils.isBlank(literalQuery)) {
            return false;
        }
        final char[] literals = literalQuery.toCharArray();

        int repeatCounter = 0;
        char previousLiteral = '\u0000';
        for (final char literal : literals) {

            boolean validLiteral = isLiteralValid(literal);

            if (!validLiteral) {
                return false;
            }

            if (previousLiteral == '\u0000') {
                previousLiteral = literal;
                continue;
            }

            if (previousLiteral == literal) {
                if (RomanLiteral.D.getLiteral() == literal || RomanLiteral.L.getLiteral() == literal || RomanLiteral.V.getLiteral() == literal) {
                    return false;
                } else
                    repeatCounter++;
            } else {
                repeatCounter = 0;
            }

            if (repeatCounter > 2) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if is literal valid.
     * 
     * @param literal the literal
     * @return true, if is literal valid
     */
    private static boolean isLiteralValid(final char literal) {
        boolean validLiteral = false;
        for (final RomanLiteral romanLiteral : RomanLiteral.values()) {
            if (romanLiteral.getLiteral() == literal) {
                validLiteral = true;
                break;
            }
        }
        return validLiteral;
    }

    /**
     * Convert roman literal to number.
     * 
     * @param romanLiteralQuery the roman literal query
     * @return the integer
     */
    public static Integer convertRomanLiteralToNumber(final String romanLiteralQuery) {
        if (StringUtils.isBlank(romanLiteralQuery)) {
            return 0;
        }
        final char[] literals = romanLiteralQuery.toCharArray();

        Integer sum = 0;
        char previousLiteral = '\u0000';
        for (final char literal : literals) {
            final int value = RomanLiteral.getValudForLiteral(literal);
            if (previousLiteral == '\u0000') {
                previousLiteral = literal;
            } else {
                final int previousLiteralValue = RomanLiteral.getValudForLiteral(previousLiteral);
                if (previousLiteralValue < value) {
                    sum = sum - value;
                    continue;
                }
            }
            sum = sum + value;
        }
        if(sum < 0){
            sum = -(sum);
        }
        return sum;
    }
}
