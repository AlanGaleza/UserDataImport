package com.dataimport;

import com.dataimport.mapper.PersonMapper;
import com.dataimport.model.Person;
import org.junit.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PersonMapperTests {

    @Test
    public void shouldMapPersonWithPhone() {
        //given
        List<String> personData = Arrays.asList("Alan", "Galeza", "2017-05-12", "505344961");
        PersonMapper personMapper = new PersonMapper();

        //when
        Person result = personMapper.mapToPersonWithPhone(personData);

        //then
        assertThat(result.getName()).isEqualTo("Alan");
        assertThat(result.getSurname()).isEqualTo("Galeza");
        assertThat(result.getBirthDate()).isEqualTo(LocalDate.of(2017,5,12));
        assertThat(result.getPhoneNumber()).isEqualTo(505344961);
    }

    @Test
    public void shouldMapPersonWithoutPhone(){
        //given
        List<String> personData = Arrays.asList("Alan", "Galeza", "2017-05-12");
        PersonMapper personMapper = new PersonMapper();

        //when
        Person result = personMapper.mapToPersonWithoutPhone(personData);

        //then
        assertThat(result.getName()).isEqualTo("Alan");
        assertThat(result.getSurname()).isEqualTo("Galeza");
        assertThat(result.getBirthDate()).isEqualTo(LocalDate.of(2017,5,12));
        assertThat(result.getPhoneNumber()).isEqualTo(0);
    }
}
