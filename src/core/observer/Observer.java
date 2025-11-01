package core.observer;

import core.WeatherData;

public interface Observer {
    void update(WeatherData data);
}