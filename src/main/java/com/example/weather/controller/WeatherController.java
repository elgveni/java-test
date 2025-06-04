package com.example.weather.controller;

import com.example.weather.model.WeatherResponse;
import com.example.weather.service.WeatherService;
import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for receiving weather data for the city.
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    /**
     * Constructor for implementation WeatherService.
     *
     * @param weatherService weather service
     */
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Get current weather for the city.
     *
     * @param city name of the city
     * @return weather data object
     * @throws JSONException if JSON response cannot be parsed
     */
    @GetMapping
    public WeatherResponse getWeather(@RequestParam String city) throws JSONException {
        return weatherService.getWeather(city);
    }
}