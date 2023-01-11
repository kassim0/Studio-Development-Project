package erasmus.frontla.endpoints;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import erasmus.frontla.objects.Course;
import erasmus.frontla.objects.LA;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.List;

public class LAPetitions {
    private static LAPetitions instance;
    public LAPetitions(){
        instance=this;
    }

    public static LAPetitions getInstance(){
        if(instance==null) {
            new LAPetitions();
        }
        return instance;
    }


    final static String linkStatic = "http://localhost:8080/LA";


    public List<LA> getAllLA() throws Exception {

        Gson gsonMod = new Gson();
        HttpRequest a= HttpRequest.newBuilder()
                .uri(new URI(linkStatic+"/all"))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(a, HttpResponse.BodyHandlers.ofString());

        Type listType = new TypeToken<List<LA>>() {}.getType();
        List<LA> LA = gsonMod.fromJson(response.body(), listType);

        return LA;
    }
    public LA getLA(int id) throws Exception {

        Gson gsonMod = new Gson();
        HttpRequest a= HttpRequest.newBuilder()
                .uri(new URI(linkStatic+"/?id="+id))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(a, HttpResponse.BodyHandlers.ofString());

        LA LA = gsonMod.fromJson(response.body(), LA.class);

        return LA;
    }
    public LA createLA(LA a) throws Exception{

        Gson gsonMod = new Gson();
        String jsonRequest = gsonMod.toJson(a);
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest b= HttpRequest.newBuilder()
                .uri(new URI(linkStatic+"/add"))
                .POST(BodyPublishers.ofString(jsonRequest))
                .header("Content-type","application/json")
                .build();


        HttpResponse<String> response = httpClient.send(b, HttpResponse.BodyHandlers.ofString());


        return null;
    }

    public LA findByName(String name) throws Exception {

        Gson gsonMod = new Gson();
        HttpRequest a= HttpRequest.newBuilder()
                .uri(new URI(linkStatic+"/allByName?name="+name))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(a, HttpResponse.BodyHandlers.ofString());

        return gsonMod.fromJson(response.body(), LA.class);
    }

    public String deleteLA(String name) throws Exception {

        Gson gsonMod = new Gson();
        HttpRequest a= HttpRequest.newBuilder()
                .uri(new URI(linkStatic+"/delete?name="+name))
                .DELETE()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(a, HttpResponse.BodyHandlers.ofString());

        String LA = gsonMod.fromJson(response.body(), String.class);

        return LA;
    }

}
