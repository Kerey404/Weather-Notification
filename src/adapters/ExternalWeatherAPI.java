package adapters;

import java.util.Random;

public class ExternalWeatherAPI {
    private final Random random = new Random();

    public String requestWeather(String city) {
        int temp = random.nextInt(40) - 5;
        String[] cond = {"☀️ Clear", "🌧️ Rain", "❄️ Snow", "🌫️ Fog"};
        return city + ": " + cond[random.nextInt(cond.length)] + " (" + temp + "°C)";
    }
}
