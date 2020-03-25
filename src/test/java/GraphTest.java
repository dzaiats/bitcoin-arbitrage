import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphTest {
    @Test
    public void testGraphCanBeCreated() throws IOException {
        List<Vertex> vertexList = new ArrayList<>();

        vertexList.add(new Vertex("USD"));
        vertexList.add(new Vertex("EUR"));
        vertexList.add(new Vertex("JPY"));
        vertexList.add(new Vertex("BTC"));

        Map<String, Vertex> mapper = Map.of("USD", vertexList.get(0),
                "EUR", vertexList.get(1),
                "JPY", vertexList.get(2),
                "BTC", vertexList.get(3)
        );

        List<Edge> edgeList = new ArrayList<>();
//        //edgeList.add(new Edge(-1*Math.log(1.00), mapper.get("USD"),  mapper.get("USD")));
//        edgeList.add(new Edge(-1*Math.log(0.7779),  mapper.get("USD"),  mapper.get("EUR")));
//        edgeList.add(new Edge(-1*Math.log(102.4590),  mapper.get("USD"),  mapper.get("JPY")));
//        edgeList.add(new Edge(-1*Math.log(0.0083),  mapper.get("USD"),  mapper.get("BTC")));
//
//        edgeList.add(new Edge(-1*Math.log(1.2851),  mapper.get("EUR"), mapper.get("USD")));
//        //edgeList.add(new Edge(-1*Math.log(1.00), mapper.get("EUR"), mapper.get("EUR")));
//        edgeList.add(new Edge(-1*Math.log(131.7110), mapper.get("EUR"), mapper.get("JPY")));
//        edgeList.add(new Edge(-1*Math.log(0.01125), mapper.get("EUR"), mapper.get("BTC")));
//
//        edgeList.add(new Edge(-1*Math.log(0.0098), mapper.get("JPY"), mapper.get("USD")));
//        edgeList.add(new Edge(-1*Math.log(0.0075), mapper.get("JPY"), mapper.get("EUR")));
//        //edgeList.add(new Edge(-1*Math.log(1.00), mapper.get("JPY"), mapper.get("JPY")));
//        edgeList.add(new Edge(-1*Math.log(0.0000811), mapper.get("JPY"), mapper.get("BTC")));
//
//        edgeList.add(new Edge(-1*Math.log(115.65), mapper.get("BTC"), mapper.get("USD")));
//        edgeList.add(new Edge(-1*Math.log(88.8499), mapper.get("BTC"), mapper.get("EUR")));
//        edgeList.add(new Edge(-1*Math.log(12325.44), mapper.get("BTC"), mapper.get("JPY")));
//        //edgeList.add(new Edge(-1*Math.log(1.00), mapper.get("BTC"), mapper.get("BTC")));

        JSONObject jsonResponse = HTTPClient.readJsonFromUrl("https://fx.priceonomics.com/v1/rates/");
        System.out.println(jsonResponse);
        for (String key: jsonResponse.keySet()) {
            String[] keySplit = key.split("_");
            String v1 = keySplit[0];
            String v2 = keySplit[1];
            if (!v1.equals(v2)) {
                edgeList.add(new Edge(Float.parseFloat(jsonResponse.get(key).toString()), mapper.get(v1), mapper.get(v2)));
            }
        }

        BFAlgorithm algorithm = new BFAlgorithm(edgeList, vertexList);
        algorithm.findArbitrage(mapper.get("USD"));
        algorithm.printCycle();
    }

}
