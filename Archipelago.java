import java.util.*;

public class Archipelago {
    public int islandsNum(List<City> list) {
        Set<City> visited = new HashSet<>();
        int count = 0;
        for(City c : list) {
            if(!visited.contains(c)) {
                count++;
                explore(visited, c);
            }
        }
        return count;
    }

    private void explore(Set<City> visited, City city) {
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

    private int exploreIslandPopulation(Set<City> visited, City city) {
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

    public int shortestPath(City start, City end) {
        if(start.equals(end)) {
            return 0;
        }
        Set<City> visited = new HashSet<>();
        Queue<City> que = new LinkedList<>();
        Map<City, Integer> distance = new HashMap<>();
        distance.put(start, 0);
        que.offer(start);
        visited.add(start);
        while(!que.isEmpty()) {
            City current = que.poll();
            for(City neighbor : current.getConnectedCities()) {
                if(!visited.contains(neighbor)) {
                    que.offer(neighbor);
                    visited.add(neighbor);
                    distance.put(neighbor, distance.get(current) + 1);
                    if(neighbor.equals(end)) {
                        return distance.get(neighbor);
                    }
                }
            }
        }
        return -1;
    }
}
