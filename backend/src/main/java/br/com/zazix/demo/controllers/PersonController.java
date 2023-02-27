package br.com.zazix.demo.controllers;

import br.com.zazix.demo.model.Person;
import br.com.zazix.demo.services.PersonService;
import jakarta.validation.constraints.FutureOrPresent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Person> findAll() {
        return service.findAll();
    }

    @PostMapping()
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping(value = "/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


}
