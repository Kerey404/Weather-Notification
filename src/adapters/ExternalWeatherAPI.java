package adapters;

import java.util.Random;

public class ExternalWeatherAPI {
    public String fetchWeather(String city) {
        double temp = new Random().nextDouble() * 40 - 10;
        double wind = new Random().nextDouble() * 15;
        return city + ";" + temp + ";" + wind;
    }
}