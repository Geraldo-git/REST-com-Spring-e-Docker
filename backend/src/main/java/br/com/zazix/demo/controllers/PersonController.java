package br.com.zazix.demo.controllers;

import br.com.zazix.demo.data.vo.v1.PersonVo;
import br.com.zazix.demo.data.vo.v2.PersonVoV2;
import br.com.zazix.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping(value = "/{id}")
    public PersonVo findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<PersonVo> findAll() {
        return service.findAll();
    }

    @PostMapping()
    public PersonVo create(@RequestBody PersonVo personVo) {
        return service.create(personVo);
    }

    @PostMapping(value = "/v2")
    public PersonVoV2 createV2(@RequestBody PersonVoV2 person) {

        return service.createV2(person);
    }


    @PutMapping(value = "/{id}")
    public PersonVo update(@PathVariable Long id, @RequestBody PersonVo person) {

        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
