package core.strategies;

import core.WeatherUpdateStrategy;
import java.util.Random;

public class RandomWeatherStrategy implements WeatherUpdateStrategy {
    private final Random random = new Random();

    @Override
    public String updateWeather(String city) {
        int temp = random.nextInt(35) - 10;
        String condition = switch (random.nextInt(3)) {
            case 0 -> "☀️ Sunny";
            case 1 -> "🌧️ Rainy";
            default -> "☁️ Cloudy";
        };
        return city + ": " + condition + " (" + temp + "°C)";
    }
}
