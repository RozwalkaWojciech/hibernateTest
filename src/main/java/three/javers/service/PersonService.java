package three.javers.service;

import three.javers.dao.PersonDao;
import three.javers.model.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.UUID;

@RequestScoped
public class PersonService {

    @Inject
    PersonDao personDao;

    public Person savePerson(Person person) {
        return personDao.savePerson(person);
    }

    public Person findById(UUID id) {
        return personDao.findById(id);
    }

    public Person edit(UUID id, Person person) {
        return personDao.edit(id, person);
    }

    public boolean remove(UUID id) {
        return personDao.remove(id);
    }

}
