package core;

import core.observer.Observer;
import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private final List<Observer> observers = new ArrayList<>();
    private WeatherUpdateStrategy strategy;

    public WeatherStation(WeatherUpdateStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(WeatherUpdateStrategy strategy) {
        this.strategy = strategy;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String city) {
        String weather = strategy.updateWeather(city);
        for (Observer o : observers) {
            o.update(weather);
        }
    }
}
