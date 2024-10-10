import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private int population;
    private List<City> connectedCities;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
        connectedCities = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public int getPopulation() {
        return population;
    }
    public List<City> getConnectedCities() {
        return connectedCities;
    }
    public void connectCity(City city) {
        connectedCities.add(city);
    }
}
