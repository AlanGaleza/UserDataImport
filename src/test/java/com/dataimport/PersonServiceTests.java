package com.dataimport;

import com.dataimport.model.Person;
import com.dataimport.service.PersonService;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PersonServiceTests {

    @Test
    public void shouldReturnOldestPeople() {
        //given
        PersonService personService = new PersonService();

        List<Person> personData = new ArrayList<>();
        personData.add(new Person("Alan", "Galeza", LocalDate.now(), 505344961L ));
        personData.add(new Person("Alan", "Galeza", LocalDate.of(1980,12,21), 505344961 ));
        personData.add(new Person("Iwona", "Galeza", LocalDate.of(1980,12,21), 505344961 ));
        personData.add(new Person("Iwona", "Galeza", LocalDate.of(1980,12,21)));
        personData.add(new Person("Iwona", "Galeza", LocalDate.of(1980,11,21), 505344961 ));
        personData.add(new Person("Gabi", "Galeza", LocalDate.of(1980,11,21), 505344961 ));
        personData.add(new Person("Alan", "Galeza", LocalDate.of(2000,7,22), 505344961 ));

        //when
        String result = personService.findHighestAgeSearcher(personData);

        //then
        assertThat(result).contains("There is/are 2");
    }
}
