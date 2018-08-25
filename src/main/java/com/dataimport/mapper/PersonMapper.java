package com.dataimport.mapper;

import com.dataimport.Exceptions.NumberFormatExc;
import com.dataimport.model.Person;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class PersonMapper {

    public Person mapToPersonWithPhone(final List<String> personData) throws NumberFormatExc {
            String phone = personData.get(3);
        try{
            return new Person(personData.get(0),
                    personData.get(1),
                    LocalDate.parse(personData.get(2)),
                    Long.valueOf(personData.get(3)));
        } catch (NumberFormatException e) {
            System.out.println("Check phoneNumber format: " + phone);
        }
        return mapToPersonWithoutPhone(personData);
    }

    public Person mapToPersonWithoutPhone(final List<String> personData) {

        return new Person(personData.get(0),
                    personData.get(1),
                    LocalDate.parse(personData.get(2)));
    }
}
