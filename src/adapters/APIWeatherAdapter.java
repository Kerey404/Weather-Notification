package adapters;

import core.WeatherData;

public class APIWeatherAdapter {
    private final ExternalWeatherAPI api = new ExternalWeatherAPI();

    public WeatherData getWeather(String city) {
        String raw = api.fetchWeather(city);
        String[] parts = raw.split(";");
        return new WeatherData(parts[0],
                Double.parseDouble(parts[1]),
                Double.parseDouble(parts[2]));
    }
}