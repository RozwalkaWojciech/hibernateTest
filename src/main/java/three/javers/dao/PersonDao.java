package three.javers.dao;

import three.javers.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Stateless
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Person savePerson(Person person) {
        entityManager.persist(person);
        return person;
    }

    public Person findById(UUID id) {
        return entityManager.find(Person.class, id);
    }

    public Person edit(UUID id, Person person) {
        Person personToEdit = findById(id);
        if (personToEdit != null) {
            personToEdit.setName(person.getName());
            personToEdit.setLastName(person.getLastName());
            entityManager.merge(personToEdit);
            return personToEdit;
        }
        return null;
    }

    public boolean remove(UUID id) {
        Person personToRemove = findById(id);
        if (personToRemove != null) {
            entityManager.remove(personToRemove);
            return true;
        }
        return false;
    }
}
