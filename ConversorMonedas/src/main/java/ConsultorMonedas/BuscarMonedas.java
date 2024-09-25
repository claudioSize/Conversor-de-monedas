package ConsultorMonedas;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscarMonedas {

    public DivisasJson CambioMoneda(int opcion, int monto) {

        Conversion conversion = new Conversion();

        String respuesta = "";
        String respuesta2 = "";

        if (opcion == 1) {
            respuesta = "USD";
            respuesta2 = "ARS";
        }else if (opcion == 2){
            respuesta = "ARS";
            respuesta2 = "USD";
        }else if (opcion == 3){
            respuesta = "USD";
            respuesta2 = "BRL";
        }else if (opcion == 4){
            respuesta = "BRL";
            respuesta2 = "USD";
        }else if (opcion == 5){
            respuesta = "USD";
            respuesta2 = "COP";
        }else if (opcion == 6){
            respuesta = "COP";
            respuesta2 = "USD";
        }
        String urlMoneda = "https://v6.exchangerate-api.com/v6/b9fa01edc7ae516e0380adae/latest/"+respuesta;

        URI direccion = URI.create(urlMoneda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            DivisasJson Divisas = new Gson().fromJson(response.body(), DivisasJson.class);

            JsonObject conversionRates = Divisas.getConversionRates();

            double price = conversionRates.get(respuesta2).getAsDouble();
            conversion.conversion(monto, price);
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("El total de las divisas " + respuesta + " convertidas "+ respuesta2 + " es: " + String.format("%.2f", conversion.total) + " " + respuesta2);
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");


        } catch (Exception e) {
            throw new RuntimeException("Error al ingresar la moneda", e);
        }
        return null;
    }
}

