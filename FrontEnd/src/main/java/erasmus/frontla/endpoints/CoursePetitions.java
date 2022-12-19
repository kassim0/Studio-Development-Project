package erasmus.frontla.endpoints;

import erasmus.frontla.objects.Course;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;


import java.lang.reflect.Type;
import java.net.http.HttpResponse;
import java.util.List;

public class CoursePetitions {
    private static  CoursePetitions instance;
    public CoursePetitions(){
        instance=this;
    }

    public static CoursePetitions getInstance(){
        if(instance==null) {
            new CoursePetitions();
        }
        return instance;
    }


    final static String linkStatic = "http://localhost:8080/course";


    public List<Course> getAllCurso() throws Exception {

        Gson gsonMod = new Gson();
        HttpRequest a= HttpRequest.newBuilder()
                .uri(new URI(linkStatic+"/all"))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(a, HttpResponse.BodyHandlers.ofString());

        Type listType = new TypeToken<List<Course>>() {}.getType();
        List<Course> curso = gsonMod.fromJson(response.body(), listType);

        return curso;
    }
    public Course getCourse(int id) throws Exception {

        Gson gsonMod = new Gson();
        HttpRequest a= HttpRequest.newBuilder()
                .uri(new URI(linkStatic+"/?id="+id))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(a, HttpResponse.BodyHandlers.ofString());

        Course curso = gsonMod.fromJson(response.body(), Course.class);

        return curso;
    }
    public Course createCourse(Course a) throws Exception{

        Gson gsonMod = new Gson();
        String jsonRequest = gsonMod.toJson(a);
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest b= HttpRequest.newBuilder()
                .uri(new URI(linkStatic+"/add"))
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .header("Content-type","application/json")
                .build();


        HttpResponse<String> response = httpClient.send(b, HttpResponse.BodyHandlers.ofString());


        return null;
    }

    public Course findByName(String name) throws Exception {

        Gson gsonMod = new Gson();
        HttpRequest a= HttpRequest.newBuilder()
                .uri(new URI(linkStatic+"/allByName?name="+name))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(a, HttpResponse.BodyHandlers.ofString());

        return gsonMod.fromJson(response.body(), Course.class);
    }

    public String deleteCourse(String name) throws Exception {

        Gson gsonMod = new Gson();
        HttpRequest a= HttpRequest.newBuilder()
                .uri(new URI(linkStatic+"/delete?name="+name))
                .DELETE()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(a, HttpResponse.BodyHandlers.ofString());

        String curso = gsonMod.fromJson(response.body(), String.class);

        return curso;
    }

}
