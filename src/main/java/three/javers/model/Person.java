package three.javers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private LocalDate birthdate;

    public Person(String name, String lastName, LocalDate birthday) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthday;
    }
}
