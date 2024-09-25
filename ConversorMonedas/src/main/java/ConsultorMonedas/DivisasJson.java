package ConsultorMonedas;

import com.google.gson.JsonObject;

public class DivisasJson {
    private String result;
    private JsonObject conversion_rates;

    public JsonObject getConversionRates() {
        return conversion_rates;
    }
}
