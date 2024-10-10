import java.io.IOException;

public class GraphTest {
    public static void main(String[] args) throws IOException {
        CityGraph graph = new CityGraph();
        String path = "C:\\code\\city_population.txt";
        graph.loadCityPopulation(path);
        System.out.println(graph.cityNumber());
        String roadPath = "C:\\code\\road_network.txt";
        graph.loadRoadNetwork(roadPath);
        graph.getRoadNetwork();
    }
}
