package erasmus.frontla.endpoints;

import erasmus.frontla.objects.Course;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.List;

public class CoursePetitions {
    private static  CoursePetitions instance;
    private  CoursePetitions(){
        instance=this;
    }

    public static CoursePetitions getInstance(){
        if(instance==null) {
            new CoursePetitions();
        }
        return instance;
    }


    final static String linkStatic = "http://localhost:8080/course";


    public List<Course> getAllCurso(){

        Gson gsonMod = new Gson();

        try {

            String response = HTTPWrapper.SetRequest(linkStatic+"/all", "GET");
            Type listType = new TypeToken<List<Course>>() {}.getType();
            List<Course> cursos = gsonMod.fromJson(response.toString(), listType);
            return cursos;

        }catch(Exception e){}

        return null;
    }
    public Course getCourse(int id){

        Gson gsonMod = new Gson();
        System.out.println("OK");
        try {

            String response = HTTPWrapper.SetRequest(linkStatic+"/"+id, "GET");
            Course course = gsonMod.fromJson(response.toString(), Course.class);
            System.out.println("OKWW");
            return course;

        }catch(Exception e){}

        return null;
    }
    public Course createCourse(int id){

        Gson gsonMod = new Gson();

        try {

            String response = HTTPWrapper.SetRequest(linkStatic+"/add", "PUT");
            Type listType = new TypeToken<Course>() {}.getType();
            Course course = gsonMod.fromJson(response.toString(), listType);
            return course;

        }catch(Exception e){}

        return null;
    }


}
