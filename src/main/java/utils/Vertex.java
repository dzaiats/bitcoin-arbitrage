package utils;

public class Vertex {
    private String name;
    private double minDistance = Double.MAX_VALUE;
    private Vertex previousVertex;

    public Vertex(String name) {
        this.name = name;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    public String getName() {
        return name;
    }
}