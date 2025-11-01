package core.strategies;

import adapters.APIWeatherAdapter;
import core.UpdateStrategy;
import core.WeatherData;

public class APIWeatherStrategy implements UpdateStrategy {
    private final APIWeatherAdapter adapter = new APIWeatherAdapter();

    @Override
    public WeatherData update(String city) {
        return adapter.getWeather(city);
    }
}