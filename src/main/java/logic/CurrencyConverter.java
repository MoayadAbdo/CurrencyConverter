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
    private Map<String, Double> rates;   // store rates once


    // i do loadrates so the "rates" Map wont be null at fetching
    public CurrencyConverter() {
        loadRates();
    }
    private void loadRates() {
        try {
            HttpRequest request = HttpRequest.newBuilder(
                    URI.create(API_URL)
            ).build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            Map<String, Object> json = gson.fromJson(response.body(), Map.class);

            this.rates = (Map<String, Double>) json.get("rates");

        } catch (Exception e) {
            e.printStackTrace();
            this.rates = null;
        }
    }

    public double convert(String from,String to,double amount){

        try{
            HttpRequest request = HttpRequest.newBuilder(
                    URI.create(API_URL + from)
            ).build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            //JSON --> MAP
            Map<String,Object> json = gson.fromJson(response.body(), Map.class);
            this.rates = (Map<String, Double>) json.get("rates");

            //from -> USD
            //USD -> to

            double rate1 = rates.get(from);
            double rate2 =  rates.get(to);
            return amount*(rate2/rate1);
        }
        catch(Exception e){
            e.printStackTrace(); // to know where the error occured
            return 0;
        }

    }
    public String[] getCurrencies(){
        String[] countries = rates.keySet().toArray(new String[0]);
        return countries;
    }

}
