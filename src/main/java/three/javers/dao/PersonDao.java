package three.javers.dao;

import three.javers.dto.PersonDto;
import three.javers.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PersonDto savePerson(PersonDto personDto) {
        Person person = PersonDto.dtoToPerson(personDto);
        entityManager.persist(person);
        return PersonDto.personToDto(person);
    }

    public PersonDto findById(Integer id) {
        return PersonDto.personToDto(entityManager.find(Person.class, id));
    }

    public PersonDto edit(Integer id, PersonDto personDto) {
        PersonDto personToEdit = findById(id);
        if (personToEdit != null) {
            personToEdit.setName(personDto.getName());
            personToEdit.setLastName(personDto.getLastName());
            entityManager.merge(personToEdit);
            return personToEdit;
        }
        return null;
    }
//TODO
    public boolean remove(Integer id) {
        Person personToRemove = findById(id);
        if (personToRemove != null) {
            entityManager.remove(personToRemove);
            return true;
        }
        return false;
    }
}
