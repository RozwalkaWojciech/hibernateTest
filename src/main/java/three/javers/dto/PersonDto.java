package three.javers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Integer id;
    private String name;
    private String lastName;
    private LocalDate birthdate;
}
