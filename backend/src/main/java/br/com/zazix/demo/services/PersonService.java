package br.com.zazix.demo.services;

import br.com.zazix.demo.data.vo.v1.PersonVo;
import br.com.zazix.demo.data.vo.v2.PersonVoV2;
import br.com.zazix.demo.exceptions.ResourceNotFoundException;
import br.com.zazix.demo.mapper.DozerMapper;
import br.com.zazix.demo.mapper.custom.PersonMapper;
import br.com.zazix.demo.model.Person;
import br.com.zazix.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;
    @Autowired
    private PersonMapper mapper;


    public List<PersonVo> findAll() {

        return DozerMapper.parseListObject(repository.findAll(), PersonVo.class);
    }

    public PersonVo findById(Long id) {
        var entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Id não encontrado"));
        return DozerMapper.parseObject(entity, PersonVo.class);
    }

    public PersonVo create(PersonVo personVo) {
        var entity = DozerMapper.parseObject(personVo, Person.class);
        return DozerMapper.parseObject(repository.save(entity), PersonVo.class);
    }

    public PersonVoV2 createV2(PersonVoV2 person) {
        var entity = mapper.convertVoToEntity(person);
        return mapper.convertEntityToVo(repository.save(entity));
    }

    public PersonVo update(PersonVo personVo) {
        var entity = repository.findById(personVo.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Id não encontrado"));
        return DozerMapper.parseObject(repository.save(entity), PersonVo.class);

    }

    public void delete(Long id) {
        var entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Id não encontrado"));
        repository.deleteById(id);
    }
}
