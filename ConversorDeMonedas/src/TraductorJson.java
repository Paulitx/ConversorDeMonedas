import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TraductorJson {
    private JsonObject jsonMoneda;


    public TraductorJson(String jsonMoneda) {
        this.jsonMoneda = new JsonParser().parseString(jsonMoneda).getAsJsonObject();

    }

    public Map<String, Double> filtrarMonedas(Set<String> codigo) {
        JsonObject valores = jsonMoneda.getAsJsonObject("conversion_rates");
        return codigo.stream()
                .filter(valores::has)
                .collect(Collectors.toMap(c -> c, c -> valores.get(c).getAsDouble()));
    }
}
