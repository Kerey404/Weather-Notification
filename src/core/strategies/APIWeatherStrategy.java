package core.strategies;

import adapters.APIWeatherAdapter;
import core.WeatherUpdateStrategy;

public class APIWeatherStrategy implements WeatherUpdateStrategy {
    private final APIWeatherAdapter adapter;

    public APIWeatherStrategy(APIWeatherAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public String updateWeather(String city) {
        return adapter.getWeather(city);
    }
}
