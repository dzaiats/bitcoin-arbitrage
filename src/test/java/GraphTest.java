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

        for (int i = 0; i < 10; i++) {
            List<Edge> edgeList = new ArrayList<>();

            JSONObject jsonResponse = HTTPClient.readJsonFromUrl("https://fx.priceonomics.com/v1/rates/");
            for (String key : jsonResponse.keySet()) {
                String[] keySplit = key.split("_");
                String v1 = keySplit[0];
                String v2 = keySplit[1];
                if (!v1.equals(v2)) {
                    double weigth = Double.parseDouble(jsonResponse.get(key).toString());
                    edgeList.add(new Edge(weigth, mapper.get(v1), mapper.get(v2)));
                }
            }
            ArbitrageConverter algorithm = new ArbitrageConverter(edgeList);
            algorithm.findArbitrage(mapper.get("USD"), 1);
        }
    }

}
