package logic;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.google.gson.Gson;

public class CurrencyConverter {

    private static final String API_URL = "https://open.er-api.com/v6/latest/USD";
    private static final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();


    public double convert(String from,String to,double amount){

        try{
            HttpRequest request = HttpRequest.newBuilder(
                    URI.create(API_URL + from)
            ).build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            //JSON --> MAP
            Map<String,Object> json = gson.fromJson(response.body(), Map.class);
            Map<String,Double> rates = (Map<String, Double>) json.get("rates");

            double rate = rates.get(to);
            return amount*rate;
        }
        catch(Exception e){
            e.printStackTrace(); // to know where the error occured
            return 0;
        }

    }
    public String[] getCurrencies(){
        return new String[]{"USD", "EUR", "JOD", "GBP", "JPY", "CAD"};
    }

}
