import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaMoneda {

    private static final String api = System.getenv("39e2efd20833cd65705d4780");
    private static final String url = "https://v6.exchangerate-api.com/v6/39e2efd20833cd65705d4780/latest/USD";

    public static String obtenerCodigo() throws Exception {
        HttpClient usu = HttpClient.newHttpClient();
        HttpRequest piri = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
        HttpResponse<String> res = usu.send(piri, HttpResponse.BodyHandlers.ofString());
        if(res.statusCode() == 200){
            return res.body();
        }else{
            throw new RuntimeException("Error: " + res.statusCode());
        }
    }



}
