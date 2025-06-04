# Weather Information Service 🌤️

This is a simple Spring Boot project that returns the current weather for a given city using the OpenWeatherMap API.

## How run

1. Add your API key `src/main/resources/application.properties`:

```properties
openweathermap.api.key=YOUR_API_KEY
openweathermap.api.url=https://api.openweathermap.org/data/2.5/weather
```

2. Start the project

In the terminal, run:
`./gradlew bootRun`

3. Open in browser or Postman

You can test the service using this URL:
`http://localhost:8080/weather?city=London`

You can change the city name (e.g., Paris, New York, Tokyo).

Example Response
`{
"city": "London",
"description": "Clear",
"temperature": 15.5
}`

Technologies Used

•	Java 17

•	Spring Boot 3

•	RestTemplate

•	OpenWeatherMap API


# License

Free to use for learning purposes.

