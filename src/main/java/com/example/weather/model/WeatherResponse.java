package com.example.weather.model;

/**
 * A simple model class that represents weather data returned to the client.
 *
 * This class holds the essential weather details for a city, such as:
 * - city name
 * - temperature
 * - weather description
 * - humidity
 * - wind speed
 * - timestamp of the response
 *
 * Lombok is used to automatically generate getters and setters.
 */
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeatherResponse {

    /**
     * Name of the city for which weather data is retrieved.
     */
    private String city;

    /**
     * Short text description of the weather (e.g., "clear sky", "rain").
     */
    private String description;

    /**
     * Current temperature in Celsius.
     */
    private double temperature;

    /**
     * Current humidity percentage.
     */
    private int humidity;

    /**
     * Current wind speed in meters per second.
     */
    private double windSpeed;

    /**
     * Timestamp when the data was retrieved (in milliseconds).
     */
    private long timestamp;
}