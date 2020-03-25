import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ArbitrageConverterIterative {
    private Map<Edge, Double> chainedMap;
    private List<Edge> edgeList;
    private LinkedList<String> listOfUsedCombinations;
    private Vertex startVertex = null;
    private double startRate = -1;
    private boolean found = false;

    public ArbitrageConverterIterative(List<Edge> edgeList) {
        this.listOfUsedCombinations = new LinkedList<>();
        this.chainedMap = new LinkedHashMap<>();
        this.edgeList = edgeList;
    }

    public void findArbitrage(Vertex sourceVertex, double amountToConvert) {
        startRate = amountToConvert;
        startVertex = sourceVertex;
        for (int i = 0; i < edgeList.size(); i++) {
            Collections.shuffle(edgeList);
            for (Edge edge : edgeList) {
                if (areRulesPassing(sourceVertex, edge)) {
                    amountToConvert *= edge.getWeight();
                    chainedMap.put(new Edge(edge.getWeight(), sourceVertex, edge.getTargetVertex()), amountToConvert);
                    sourceVertex = edge.getTargetVertex();

                    if (sourceVertex.getName().equals(startVertex.getName())) {
                        if (amountToConvert > startRate) {
                            System.out.println("!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!");
                            System.out.println("!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!");
                            System.out.println("Start amount: " + startRate);
                            System.out.println("End amount: " + amountToConvert);
                            System.out.println(chainedMap.toString());
                            System.out.println("!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!");
                            System.out.println("!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!");
                            System.out.println("\n\n");
                            found = true;
                        } else {
                            chainedMap.clear();
                            listOfUsedCombinations.clear();
                        }
                    }
                }
            }
        }
    }

    private boolean areRulesPassing(Vertex sourceVertex, Edge edge) {
        if (sourceVertex.getName().equals(edge.getStartVertex().getName())) {
            if (!found) {
                String pair = sourceVertex.getName() + "_" + edge.getTargetVertex().getName();
                String invertedPair = edge.getTargetVertex().getName() + "_" + sourceVertex.getName();
                if (listOfUsedCombinations.isEmpty() || (!listOfUsedCombinations.contains(pair) && !listOfUsedCombinations.getLast().equals(invertedPair))) {
                    listOfUsedCombinations.add(pair);
                    return true;
                }
            }
        }
        return false;
    }
}