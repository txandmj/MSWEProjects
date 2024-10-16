import java.io.IOException;
import java.util.List;

public class GraphTest {
    public static void main(String[] args) throws IOException {
        CityGraph graph = new CityGraph();
        String path = "C:\\code\\city_population.txt";
        graph.loadCityPopulation(path);

        System.out.println(graph.cityNumber());
        String roadPath = "C:\\code\\road_network.txt";
        graph.loadRoadNetwork(roadPath);
//        graph.getRoadNetwork();
//        Archipelago arch = new Archipelago();
//        List<City> cityList = graph.getCities();
//        System.out.println("The archipelago has " + arch.islandsNum(cityList) + " islands");
//        List<Integer> islandsPopulation = arch.islandsPopulation(cityList);
//        for(int population : islandsPopulation) {
//            System.out.println("The island population: " + population);
//        }
//
//        City cityA = cityList.get(0);
//        City cityB = cityList.get(1);
//
//        int shortestPath = arch.shortestPath(cityA, cityB);
//        System.out.println("Shortest path between " + cityA.getName() + " and " + cityB.getName() + ": " + shortestPath);
   }
}
