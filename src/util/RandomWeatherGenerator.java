package util;

import core.WeatherData;
import java.util.Random;

public class RandomWeatherGenerator {
    public static WeatherData generate(String city) {
        Random r = new Random();
        double temp = -10 + r.nextDouble() * 45;
        double wind = r.nextDouble() * 20;
        return new WeatherData(city, temp, wind);
    }
}