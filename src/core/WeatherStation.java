package core;

import core.observer.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private UpdateStrategy strategy;
    private WeatherData data;

    public WeatherStation(UpdateStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(UpdateStrategy strategy) {
        this.strategy = strategy;
    }

    public void updateWeather(String city) {
        this.data = strategy.update(city);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(data);
        }
    }
}
