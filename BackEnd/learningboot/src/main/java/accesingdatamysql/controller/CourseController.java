package accesingdatamysql.controller;
import accesingdatamysql.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import accesingdatamysql.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController // This means that this class is a Controller
@RequestMapping(path="/course") // This means URL's start with /demo (after Application path)
public class CourseController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private CourseRepository CourseRepository;

    @PostMapping(path="/add",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    ) // Map ONLY POST Requests
    public @ResponseBody String addNewCourse(@RequestBody Course a) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        CourseRepository.save(a);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Course> getAllCourses() {
        // This returns a JSON or XML with the users
        return CourseRepository.findAll();
    }
    @GetMapping(path="/")
    public @ResponseBody Course getCourse(@RequestParam String id) {
        // This returns a JSON or XML with the users
        Integer idToSearch= Integer.valueOf(id);
        Course CourseToChange = new Course();
        if(CourseRepository.existsById(idToSearch)){
            CourseToChange =CourseRepository.findById(idToSearch).get();
        };
        return CourseToChange;
    }

    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteCourse(@RequestParam String name) {
        // This returns a JSON or XML with the users
        Integer idToSearch= Integer.valueOf(CourseRepository.findByName(name));
        Integer id= Integer.valueOf(idToSearch);
        Course CourseToChange = null;
        if(CourseRepository.existsById(idToSearch)){
            CourseRepository.deleteById(idToSearch);
            return "deleted";
        };
        return "not found";
    }
    @PutMapping(path="/change")
    public @ResponseBody Course changeCourse(@RequestParam String id) {
        // This returns a JSON or XML with the users
        Integer idToSearch= Integer.valueOf(id);
        Course CourseToChange;
         if(CourseRepository.existsById(idToSearch)){
             CourseToChange =CourseRepository.findById(idToSearch).get();
         };
         return null;
    }
    @GetMapping(path="/allByName")
    public @ResponseBody Course getCourseByName(@RequestParam String name) {
        // This returns a JSON or XML with the users
        //Course prueba2 = CourseRepository.findByName(name);
        Integer idToSearch= Integer.valueOf(CourseRepository.findByName(name));
        Course CourseToChange = null;
        if(CourseRepository.existsById(idToSearch)){
            CourseToChange =CourseRepository.findById(idToSearch).get();
        };
        return CourseToChange;
    }

    @GetMapping(path="/allByUniversity")
    public @ResponseBody List<Course> getCoursesByUniversity(@RequestParam String university){
        List<Integer> univToSearch= CourseRepository.getCoursesByUniversity(university);
        ArrayList<Course> coursesOfUniv = new ArrayList<>();

        for(Integer id:univToSearch){
            if(CourseRepository.existsById(id)){
                Course courseToAdd = CourseRepository.findById(id).get();
                coursesOfUniv.add(courseToAdd);
            };
        }
        return coursesOfUniv;
        /*
        Iterable<Course> todo =  CourseRepository.findAll();
        List<Course> coursesOfUniv = null;
        for(Course unCurso : todo){
            if(unCurso.university==university){
                coursesOfUniv.add(unCurso);
            }
        }
        */
        //return coursesOfUniv;
    }


}