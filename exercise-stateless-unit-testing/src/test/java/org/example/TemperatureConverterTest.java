package org.example;

import junit.framework.TestCase;

public class TemperatureConverterTest extends TestCase {
    TemperatureConverter converter = new TemperatureConverter();

    public void testCelsiusToFahrenheit() {
        // ARRANGE
        double input = 0.0;
        double expected = 32.0;
        // ACT
        double actual = converter.celsiusToFahrenheit(input);
        // ASSERT
        assertEquals(expected, actual);
    }

    public void testFahrenheitToCelsius() {
        // ARRANGE
        double input = 32.0;
        double expected = 0.0;
        // ACT
        double actual = converter.fahrenheitToCelsius(input);
        // ASSERT
        assertEquals(expected, actual);
    }

    public void testCelsiusToKelvin() {
        // ARRANGE
        double input = 100.0;
        double expected = 373.15;
        // ACT
        double actual = converter.celsiusToKelvin(input);
        // ASSERT
        assertEquals(expected, actual);
    }

    public void testKelvinToCelsius() {
        // ARRANGE
        double input = 0;
        double expected = -273.15;
        // ACT
        double actual = converter.kelvinToCelsius(input);
        // ASSERT
        assertEquals(expected, actual);
    }

    public void testFahrenheitToKelvin() {
        // ARRANGE
        double input = 32;
        double expected = 273.15;
        // ACT
        double actual = converter.fahrenheitToKelvin(input);
        // ASSERT
        assertEquals(expected, actual);
    }

    public void testKelvinToFahrenheit() {
        // ARRANGE
        double input = 273.15;
        double expected = 32.0;
        // ACT
        double actual = converter.kelvinToFahrenheit(input);
        // ASSERT
        assertEquals(expected, actual);
    }
}