package three.javers.dao;

import three.javers.dto.PersonDto;
import three.javers.model.Person;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Inject
    private PersonDto personDto;

    public PersonDto savePerson(PersonDto personDto) {
        Person person = personDto.dtoToPerson(personDto);
        entityManager.persist(person);
        return personDto.personToDto(person);
    }

    public Person findById(Integer id) {
        return entityManager.find(Person.class, id);
    }

    public Person edit(Integer id, Person person) {
        Person personToEdit = findById(id);
        if (personToEdit != null) {
            personToEdit.setName(person.getName());
            personToEdit.setLastName(person.getLastName());
            entityManager.merge(personToEdit);
            return personToEdit;
        }
        return null;
    }

    public boolean remove(Integer id) {
        Person personToRemove = findById(id);
        if (personToRemove != null) {
            entityManager.remove(personToRemove);
            return true;
        }
        return false;
    }
}
