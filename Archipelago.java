import java.util.*;

public class Archipelago {
    public int islandsNum(List<City> list) {
        Set<City> visited = new HashSet<>();
        int count = 0;
        for(City c : list) {
            if(!visited.contains(c)) {
                count++;
                //visited.add(c);
                explore(visited, c);
            }
        }
        return count;
    }

    public void explore(Set<City> visited, City city) {
        Queue<City> que = new LinkedList<>();
        que.offer(city);
        visited.add(city);
        while(!que.isEmpty()) {
            City cur = que.poll();
            for(City neighbor : cur.getConnectedCities()) {
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    que.offer(neighbor);
                }
            }
        }
    }
    public List<Integer> islandsPopulation(List<City> list) {
        Set<City> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for(City c : list) {
            if(!visited.contains(c)) {
                int islandPopulation = exploreIslandPopulation(visited, c);
                result.add(islandPopulation);
            }
        }
        return result;
    }

    public int exploreIslandPopulation(Set<City> visited, City city) {
        int population = 0;
        Queue<City> que = new LinkedList<>();
        que.offer(city);
        population += city.getPopulation();
        visited.add(city);
        while(!que.isEmpty()) {
            City cur = que.poll();
            for(City neighbor : cur.getConnectedCities()) {
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    que.offer(neighbor);
                    population += city.getPopulation();
                }
            }
        }
        return population;
    }

    public int shortestRoute(City start, City end) {
        int step = 1;
        Set<City> visited = new HashSet<>();
        for(City neighbor : start.getConnectedCities()) {
            if(neighbor.equals(end)) {
                return step;
            }
        }
    }
    public void exploreShortestRoute(Set<City> visited, City neighbor, City end) {
        Queue<City> que = new LinkedList<>();
        que.offer(neighbor);
    }
}
