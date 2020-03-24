import java.util.ArrayList;
import java.util.List;

public class BellmanFord {
    private List<Vertex> vertexList;
    private List<Edge> edgeList;
    private List<Vertex> cycleList;

    public BellmanFord(List<Edge> edgeList, List<Vertex> vertexList) {
        this.vertexList = vertexList;
        this.edgeList = edgeList;
        this.cycleList = new ArrayList<>();
    }

    public void findArbitrage(Vertex sourceVertex) {
        sourceVertex.setMinDistance(0);

        for (int i = 0; i < this.vertexList.size() - 1; ++i) {
            for (Edge edge : this.edgeList) {

                if (edge.getStartVertex().getMinDistance() == Double.MAX_VALUE) {
                    continue;
                }

                double newDistance = edge.getStartVertex().getMinDistance() + edge.getWeight();

                if (newDistance < edge.getTargetVertex().getMinDistance()) {
                    edge.getTargetVertex().setMinDistance(newDistance);
                    edge.getTargetVertex().setPreviousVertex(edge.getStartVertex());
                }
            }
        }

        for (Edge edge : this.edgeList) {
            if (edge.getStartVertex().getMinDistance() != Double.MAX_VALUE) {
                if (hasCycle(edge)) {
                    Vertex vertex = edge.getStartVertex();
                    while (!vertex.equals(edge.getTargetVertex())) {
                        this.cycleList.add(vertex);
                        vertex = vertex.getPreviousVertex();
                    }
                    this.cycleList.add(edge.getTargetVertex());

                    return;
                }
            }
        }

//        if (targetVertex.getMinDistance() == Double.MAX_VALUE) {
//            System.out.println("There is no path at all to target from source...");
//        } else {
//            System.out.println("Shortest path is: " + targetVertex.getMinDistance());
//        }

    }

    private boolean hasCycle(Edge edge) {
        return (edge.getStartVertex().getMinDistance() + edge.getWeight()) < edge.getTargetVertex().getMinDistance();
    }

    public void printCycle() {
        if (!this.cycleList.isEmpty()) {
            System.out.println("Detected!");
            for (Vertex vertex : cycleList) {
                System.out.println(vertex);
            }
        } else {
            System.out.println("Not found!");
        }
    }
}