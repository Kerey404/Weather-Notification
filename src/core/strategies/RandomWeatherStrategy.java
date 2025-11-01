package core.strategies;

import core.UpdateStrategy;
import core.WeatherData;
import util.RandomWeatherGenerator;

public class RandomWeatherStrategy implements UpdateStrategy {
    @Override
    public WeatherData update(String city) {
        return RandomWeatherGenerator.generate(city);
    }
}