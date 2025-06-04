package com.example.weather.service;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.json.JSONObject;
import com.example.weather.model.WeatherResponse;

/**
 * Service class that handles communication with the OpenWeatherMap API.
 * It builds a request using city name, sends the request, and parses the response.
 */
@Service
public class WeatherService {

    // Inject the OpenWeatherMap API key from application.properties
    @Value("${openweathermap.api.key}")
    private String apiKey;

    // Inject the base URL for the OpenWeatherMap API
    @Value("${openweathermap.api.url}")
    private String apiUrl;

    /**
     * Calls the weather API to get current weather data for a given city.
     *
     * @param city the name of the city (e.g., "London")
     * @return WeatherResponse object containing city, temperature, description, etc.
     * @throws JSONException if the response cannot be parsed
     */
    public WeatherResponse getWeather(String city) throws JSONException {
        // Create a RestTemplate for making HTTP requests
        RestTemplate restTemplate = new RestTemplate();

        // Build the full URL with query parameters
        String uri = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .build().toUriString();

        // Make the GET request to the API and get the response as a String
        String response = restTemplate.getForObject(uri, String.class);

        // Parse the JSON response
        JSONObject json = new JSONObject(response);

        // Create a new WeatherResponse object and fill it with data from the API response
        WeatherResponse weather = new WeatherResponse();
        weather.setCity(json.getString("name"));
        weather.setTemperature(json.getJSONObject("main").getDouble("temp"));
        weather.setDescription(json.getJSONArray("weather")
                .getJSONObject(0).getString("description"));
        weather.setHumidity(json.getJSONObject("main").getInt("humidity"));
        weather.setWindSpeed(json.getJSONObject("wind").getDouble("speed"));
        weather.setTimestamp(System.currentTimeMillis());

        return weather;
    }
}