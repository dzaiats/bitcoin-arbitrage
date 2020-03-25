import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BFAlgorithm {
    private List<Vertex> vertexList;
    private List<Edge> edgeList;
    private List<List<Vertex>> cycleLists;

    public BFAlgorithm(List<Edge> edgeList, List<Vertex> vertexList) {
        this.vertexList = vertexList;
        this.edgeList = edgeList;
        this.cycleLists = new ArrayList<>();
    }

    public void findArbitrage(Vertex sourceVertex) {
        sourceVertex.setMinDistance(0);

        for (int i = 0; i < vertexList.size() - 1; ++i) {
            for (Edge edge : edgeList) {

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

        for (Edge edge : edgeList) {
            if (edge.getStartVertex().getMinDistance() != Double.MAX_VALUE) {
                List<Vertex> cycleList = new ArrayList<>();
                if (hasCycle(edge)) {
                    Vertex vertex = edge.getStartVertex();
                    while (!vertex.equals(edge.getTargetVertex())) {
                        cycleList.add(vertex);
                        vertex = vertex.getPreviousVertex();
                        if (vertex == null) {
                            break;
                        }
                    }
                    cycleList.add(edge.getTargetVertex());

                    //return;
                }
                if (!cycleList.isEmpty()) {
                    cycleLists.add(cycleList);
                }
            }
        }
    }

    private boolean hasCycle(Edge edge) {
        return (edge.getStartVertex().getMinDistance() + edge.getWeight()) > edge.getTargetVertex().getMinDistance();
    }

    public void printCycle() {
        if (!this.cycleLists.isEmpty()) {
            for (List<Vertex> list: cycleLists) {
                if (!list.isEmpty()) {
                    System.out.println("Detected!");
                    for (Vertex vertex : list) {
                        System.out.println(vertex.getName());
                    }
                    System.out.println("\n");
                }
            }
        } else {
            System.out.println("Not found!");
        }
    }
}