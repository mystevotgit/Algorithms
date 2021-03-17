package solarsystem;

import java.util.List;

public class Star {
    private List<Planet> planets;
    private int numberOfPlanets;

    public Star(List<Planet> planets, int numberOfPlanets) {
        this.planets = planets;
        this.numberOfPlanets = numberOfPlanets;
    }

    public Star() {
    }

    public int getNumberOfPlanets() {
        return numberOfPlanets;
    }

    public void setNumberOfPlanets(int numberOfPlanets) {
        this.numberOfPlanets = numberOfPlanets;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }
}
