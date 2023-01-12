package accesingdatamysql.controller;

import accesingdatamysql.entity.Users;
import accesingdatamysql.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import accesingdatamysql.repository.*;

@RestController
@RequestMapping(path="/users")
public class UsersController{
    @Autowired

    private UsersRepository UsersRepository;

    @PostMapping(path="/add",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )

    public @ResponseBody String addNewUsers(@RequestBody Users u) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        UsersRepository.save(u);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Users> getAllUsers() {
        // This returns a JSON or XML with the users
        return UsersRepository.findAll();
    }

    public @ResponseBody Users getUsers(@RequestParam String id) {
        // This returns a JSON or XML with the users
        Integer idToSearch= Integer.valueOf(id);
        Course UsersToChange = new Users();
        if(UsersRepository.existsById(idToSearch)){
            UsersToChange =UsersRepository.findById(idToSearch).get();
        };
        return UsersToChange;
    }

    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteUsers(@RequestParam String name) {
        // This returns a JSON or XML with the users
        Integer idToSearch= Integer.valueOf(UsersRepository.findByName(name));
        Integer id= Integer.valueOf(idToSearch);
        Course UsersToChange = null;
        if(UsersRepository.existsById(idToSearch)){
            UsersRepository.deleteById(idToSearch);
            return "deleted";
        };
        return "not found";
    }

    @PutMapping(path="/change")
    public @ResponseBody Users changeUsers(@RequestParam String id) {
        // This returns a JSON or XML with the users
        Integer idToSearch= Integer.valueOf(id);
        Users UsersToChange;
        if(UsersRepository.existsById(idToSearch)){
            UsersToChange =UsersRepository.findById(idToSearch).get();
        };
        return null;
    }

    public @ResponseBody Users getUsersByName(@RequestParam String name) {
        // This returns a JSON or XML with the users
        //Course prueba2 = CourseRepository.findByName(name);
        Integer idToSearch= Integer.valueOf(UsersRepository.findByName(name));
        Users UsersToChange = null;
        if(UsersRepository.existsById(idToSearch)){
            UsersToChange =UsersRepository.findById(idToSearch).get();
        };
        return UsersToChange;
    }

}