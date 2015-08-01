package com.thoughtworks.galaxy.guide.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * The Class UniversalConverter.
 */
public class ConverterCore {

    /** The default values. */
    private static Properties defaultValues;

    /** The Constant REGEX_EXP. */
    private static final String REGEX_EXP = "[ ,;:]+";
    
    static{
        readDefaultValues();
    }

    /**
     * Read default values.
     */
    private static void readDefaultValues() {
        final Properties properties = new Properties();
        InputStream inputStream;
        try {
            inputStream = new FileInputStream("src/main/resources/default-value.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        defaultValues = properties;
    }

    /**
     * Calculate sum.
     * 
     * @param queryString the query string
     * @return the int
     */
    public static String calculateSum(final String queryString) {
        final String[] tokens = queryString.split(REGEX_EXP);

        Double multiplierValue = null;
        final StringBuilder romanLiteralStringBuilder = new StringBuilder();
        for (final String token : tokens) {
            final String tokenDefaultValue = (String) defaultValues.get(token);

            if (NumberUtils.isNumber(tokenDefaultValue)) {
                final Double value = Double.valueOf(tokenDefaultValue);
                if (multiplierValue != null) {
                    multiplierValue = multiplierValue * value;
                }
                multiplierValue = value;
            } else {
                romanLiteralStringBuilder.append(tokenDefaultValue);
            }
        }

        final String romanLiteralString = romanLiteralStringBuilder.toString();
        //validate the romain literal string
        final boolean literalStringValid = UtilityHelper.validateLiterals(romanLiteralString);

        if (!literalStringValid) {
            System.out.println("Literal String '" + romanLiteralString + "' not valid");
            return null;
        }

        if (multiplierValue == null && StringUtils.isNotBlank(romanLiteralString) && romanLiteralString.length() == 1) {
            return romanLiteralString;
        }

        final Integer calculatedSum = UtilityHelper.convertRomanLiteralToNumber(romanLiteralString);

        final Double result = calculateResult(calculatedSum, multiplierValue);
        if (result != null) {
            return String.valueOf(result);
        }
        return result != null ? String.valueOf(result) : null;
    }

    /**
     * Calculate result.
     * 
     * @param sum the sum
     * @param multiplierValue the multiplier value
     * @return the double
     */
    private static Double calculateResult(final Integer sum, final Double multiplierValue) {
        if (sum == null && multiplierValue == null) {
            return null;
        } else if (sum == null && multiplierValue != null) {
            return multiplierValue;
        } else if (sum != null && multiplierValue == null) {
            return new Double(sum);
        }
        return sum * multiplierValue;
    }
}
