package br.com.zazix.demo.services;

import br.com.zazix.demo.exceptions.ResourceNotFoundException;
import br.com.zazix.demo.model.Person;
import br.com.zazix.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(Long id) {

        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Id não encontrado"));
    }

    public Person create(Person person) {

        return repository.save(person);
    }

    public Person update(Person person) {
        var entity = repository.findById(person.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Id não encontrado"));
        return repository.save(person);
    }

    public void delete(Long id) {
        var entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Id não encontrado"));
        repository.deleteById(id);
    }
}
