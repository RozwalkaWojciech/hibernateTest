package three.javers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private String lastName;
}
