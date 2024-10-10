import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityGraph {
    private Map<String, City> map;
    public CityGraph() {
        map = new HashMap<>();
    }
    public void loadCityPopulation(String populationFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(populationFile));
        String line = "";
        while((line = br.readLine()) != null) {
            String[] cityInfo = line.split(":");
            String cityName = cityInfo[0].trim();
            int population = Integer.parseInt(cityInfo[1].trim());
            City city = new City(cityName, population);
            map.put(cityName, city);
        }
        br.close();
    }
    //test code: whether loadCityPopulation method works
    public int cityNumber() {
        return map.size();
    }
    public void loadRoadNetwork(String roadNetwork) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(roadNetwork));
        String line = "";
        while((line = br.readLine()) != null) {
            String[] connectedRoad = line.split(":");
            String cityName1 = connectedRoad[0].trim();
            String cityName2 = connectedRoad[1].trim();
            City city1 = map.get(cityName1);
            City city2 = map.get(cityName2);
            if(city1 != null && city2 != null) {
                city1.connectCity(city2);
                city2.connectCity(city1);
            }
        }
        br.close();
    }
    //test code: whether loadRoadNetwork method works
    public void getRoadNetwork() {
        for(City c : map.values()) {
            for(City networkCity : c.getConnectedCities()) {
                System.out.print(networkCity.getName() + " ");
            }
            System.out.println();
        }
    }
    public List<City> getCities() {
        return new ArrayList<>(map.values());
    }
}
