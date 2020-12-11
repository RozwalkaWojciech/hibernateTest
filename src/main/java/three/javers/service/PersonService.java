package three.javers.service;

import three.javers.dao.PersonDao;
import three.javers.dto.PersonDto;
import three.javers.model.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class PersonService {

    @Inject
    PersonDao personDao;

    public PersonDto savePerson(PersonDto personDto) {
        return personDao.savePerson(personDto);
    }

    public PersonDto findById(Integer id) {
        return personDao.findById(id);
    }
//TODO
    public Person edit(Integer id, Person person) {
        return personDao.edit(id, person);
    }
//TODO
    public boolean remove(Integer id) {
        return personDao.remove(id);
    }

}
