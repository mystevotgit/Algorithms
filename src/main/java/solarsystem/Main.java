package solarsystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Planet> planets = new ArrayList<>();
        planets.add(new Planet("Mecury"));
        planets.add(new Planet("Venus"));
        planets.add(new Planet("Earth"));
        planets.add(new Planet("Mars"));
        planets.add(new Planet("Jupiter"));
        planets.add(new Planet("Saturn"));
        planets.add(new Planet("Uranus"));
        planets.add(new Planet("Neptune"));
        planets.add(new Planet("Pluto"));
        Star solarSystem = new Star(planets, planets.size());
        solarSystem.getPlanets().forEach(planet -> System.out.println(planet.getName()));
    }
}
