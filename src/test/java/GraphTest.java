import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphTest {
    @Test
    public void testGraphCanBeCreated() throws IOException {
        List<Vertex> vertexList = new ArrayList<>();

        vertexList.add(new Vertex("USD"));
        vertexList.add(new Vertex("EUR"));
        vertexList.add(new Vertex("JPY"));
        vertexList.add(new Vertex("BTC"));

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(-1*Math.log(1.00), new Vertex("USD"), new Vertex("USD")));
        edgeList.add(new Edge(-1*Math.log(0.7779), new Vertex("USD"), new Vertex("EUR")));
        edgeList.add(new Edge(-1*Math.log(102.4590), new Vertex("USD"), new Vertex("JPY")));
        edgeList.add(new Edge(-1*Math.log(0.0083), new Vertex("USD"), new Vertex("BTC")));

        edgeList.add(new Edge(-1*Math.log(1.2851), new Vertex("EUR"), new Vertex("USD")));
        edgeList.add(new Edge(-1*Math.log(1.00), new Vertex("EUR"), new Vertex("EUR")));
        edgeList.add(new Edge(-1*Math.log(131.7110), new Vertex("EUR"), new Vertex("JPY")));
        edgeList.add(new Edge(-1*Math.log(0.01125), new Vertex("EUR"), new Vertex("BTC")));

        edgeList.add(new Edge(-1*Math.log(0.0098), new Vertex("JPY"), new Vertex("USD")));
        edgeList.add(new Edge(-1*Math.log(0.0075), new Vertex("JPY"), new Vertex("EUR")));
        edgeList.add(new Edge(-1*Math.log(1.00), new Vertex("JPY"), new Vertex("JPY")));
        edgeList.add(new Edge(-1*Math.log(0.0000811), new Vertex("JPY"), new Vertex("BTC")));

        edgeList.add(new Edge(-1*Math.log(115.65), new Vertex("BTC"), new Vertex("USD")));
        edgeList.add(new Edge(-1*Math.log(88.8499), new Vertex("BTC"), new Vertex("EUR")));
        edgeList.add(new Edge(-1*Math.log(12325.44), new Vertex("BTC"), new Vertex("JPY")));
        edgeList.add(new Edge(-1*Math.log(1.00), new Vertex("BTC"), new Vertex("BTC")));

//        JSONObject jsonResponse = HTTPClient.readJsonFromUrl("https://fx.priceonomics.com/v1/rates/");
//        for (String key: jsonResponse.keySet()) {
//            String[] keySplit = key.split("_");
//            String v1 = keySplit[0];
//            String v2 = keySplit[1];
//            if (!v1.equals(v2)) {
//                edgeList.add(new Edge(Float.parseFloat(jsonResponse.get(key).toString()), new Vertex(v1), new Vertex(v2)));
//            }
//        }

        BellmanFord algorithm = new BellmanFord(edgeList, vertexList);
        algorithm.findArbitrage(new Vertex("USD"));
        algorithm.printCycle();

//        List<Vertex> vertexList = new ArrayList<>();
//
//        vertexList.add(new Vertex("A"));
//        vertexList.add(new Vertex("B"));
//        vertexList.add(new Vertex("C"));
//        vertexList.add(new Vertex("D"));
//
//        List<Edge> edgeList = new ArrayList<>();
//
//        edgeList.add(new Edge(2, vertexList.get(0), vertexList.get(1)));
//        edgeList.add(new Edge(1, vertexList.get(1), vertexList.get(2)));
//        edgeList.add(new Edge(3, vertexList.get(2), vertexList.get(3)));
////        edgeList.add(new Edge(-5, vertexList.get(3), vertexList.get(1))); // negative case
//        edgeList.add(new Edge(1, vertexList.get(0), vertexList.get(3)));
//
//        BellmanFord algorithm = new BellmanFord(edgeList, vertexList);
//        algorithm.findArbitrage(vertexList.get(0), vertexList.get(3));
    }

}
