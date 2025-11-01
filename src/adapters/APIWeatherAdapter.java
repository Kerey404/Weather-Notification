package adapters;

public class APIWeatherAdapter {
    private final ExternalWeatherAPI api = new ExternalWeatherAPI();

    public String getWeather(String city) {
        return api.requestWeather(city);
    }
}
