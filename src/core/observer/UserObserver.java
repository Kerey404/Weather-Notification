package core.observer;

import builder.User;
import core.WeatherData;

public class UserObserver implements Observer {
    private User user;

    public UserObserver(User user) {
        this.user = user;
    }

    @Override
    public void update(WeatherData data) {
        System.out.println("📢 " + user.getName() + ", weather update in " +
                user.getCity() + ": " + data);
    }
}