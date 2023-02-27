package br.com.zazix.demo.controllers;

import br.com.zazix.demo.model.Person;
import br.com.zazix.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping(value ="/{id}")
    public Person findById(@PathVariable Long id){
        return null;//service.findById(id);
    }


}
