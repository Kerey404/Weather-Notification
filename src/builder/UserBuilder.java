package builder;

public class UserBuilder {
    private String name;
    private String city;

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public User build() {
        return new User(name, city);
    }
}