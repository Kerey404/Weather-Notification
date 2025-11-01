package core.observer;

import builder.User;

public class UserObserver implements Observer {
    private final User user;

    public UserObserver(User user) {
        this.user = user;
    }

    @Override
    public void update(String weatherInfo) {
        System.out.println("📩 Notification for " + user.getName() + ": " + weatherInfo);
    }
}
