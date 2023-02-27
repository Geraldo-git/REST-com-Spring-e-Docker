package br.com.zazix.demo.mapper.custom;

import br.com.zazix.demo.data.vo.v2.PersonVoV2;
import br.com.zazix.demo.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVoV2 convertEntityToVo(Person person){
        PersonVoV2 vo = new PersonVoV2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        vo.setBirthdate(new Date());
        return vo;
    }

    public Person convertVoToEntity(PersonVoV2 person){
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setAddress(person.getAddress());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        //vo.setBirthdate(new Date());
        return entity;
    }


}
