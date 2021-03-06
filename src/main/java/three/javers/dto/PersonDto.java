package three.javers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import three.javers.model.Person;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Integer id;
    private String name;
    private String lastName;
    private LocalDate birthdate;

    public PersonDto(String name, String lastName, LocalDate birthdate) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }

    public static Person dtoToPerson(PersonDto personDto) {
        Person person = new Person();
        person.setName(personDto.getName());
        person.setLastName(personDto.getLastName());
        person.setBirthdate(personDto.getBirthdate());
        return person;
    }

    public static PersonDto personToDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setName(person.getName());
        personDto.setLastName(person.getLastName());
        personDto.setBirthdate(person.getBirthdate());
        return personDto;
    }

}
