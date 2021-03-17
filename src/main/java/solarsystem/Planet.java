package solarsystem;

public class Planet {
    private String name;
    private long radius;
    private int gravity;
    private int revolution;
    private boolean ishabitable;

    public Planet(String name, long radius, int gravity, int revolution, boolean ishabitable) {
        this.name = name;
        this.radius = radius;
        this.gravity = gravity;
        this.revolution = revolution;
        this.ishabitable = ishabitable;
    }

    public Planet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRadius() {
        return radius;
    }

    public void setRadius(long radius) {
        this.radius = radius;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public int getRevolution() {
        return revolution;
    }

    public void setRevolution(int revolution) {
        this.revolution = revolution;
    }

    public boolean isIshabitable() {
        return ishabitable;
    }

    public void setIshabitable(boolean ishabitable) {
        this.ishabitable = ishabitable;
    }
}
