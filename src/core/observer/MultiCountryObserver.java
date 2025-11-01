package core.observer;

import core.WeatherData;
import java.util.List;

public class MultiCountryObserver implements Observer {
    private final String userName;
    private final List<String> countries;

    public MultiCountryObserver(String userName, List<String> countries) {
        this.userName = userName;
        this.countries = countries;
    }

    @Override
    public void update(WeatherData data) {
        System.out.println("\n🌍 " + userName + " получает погоду для нескольких стран:");
        for (String country : countries) {
            System.out.println(" - " + country + ": " + data);
        }
    }
}
