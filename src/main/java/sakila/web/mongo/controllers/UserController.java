package sakila.web.mongo.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sakila.web.mongo.entities.User;
import sakila.web.mongo.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
@AllArgsConstructor
    @CrossOrigin
public class UserController {

    private UserService service;

    @PostMapping("/create")
    public User create(@RequestBody User user){
        log.trace("User create -->{}",user);
        return service.create(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable Long id){
        return service.read(String.valueOf(id));
    }
    @GetMapping("/all")
    public List<User> getAll(){
        return service.readAll();
    }
}
