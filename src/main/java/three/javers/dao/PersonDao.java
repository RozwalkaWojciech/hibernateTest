package three.javers.dao;

import three.javers.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Person savePerson(Person person) {
        entityManager.persist(person);
        return person;
    }
}
