package core.observer;

import core.WeatherUpdateStrategy;
import java.util.List;

public class MultiCountryObserver {
    private final WeatherUpdateStrategy strategy;

    public MultiCountryObserver(WeatherUpdateStrategy strategy) {
        this.strategy = strategy;
    }

    public void showAll(List<String> countries) {
        System.out.println("🌎 Multi-country weather report:");
        for (String c : countries) {
            System.out.println(strategy.updateWeather(c));
        }
    }
}
