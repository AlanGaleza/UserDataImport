package com.dataimport.service;

import com.dataimport.mapper.PersonMapper;
import com.dataimport.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class PersonService {

    @Autowired
    PersonMapper personMapper;

    public List<Person> createPersonList(List<String> dataList) {
        List<Person> personList = new ArrayList<>();

        for (String data : dataList) {

            List<String> personData = Arrays.asList(data.split(","));
            if(personData.size() == 4) {
                personList.add(personMapper.mapToPersonWithPhone(personData));
            } else if (personData.size() == 3) {
                personList.add(personMapper.mapToPersonWithoutPhone(personData));
            }
        }
        System.out.println(personList.size() + " users have been loaded.");
        return personList;
    }

    public String findHighestAgeSearcher(List<Person> personData){
        List<Person> highestAgePerson = new ArrayList<>();
        int age = 0;

        Person minByAge = personData.stream()
                .min(Comparator.comparing(Person::getBirthDate))
                .orElseThrow(NoSuchElementException::new);

        for (Person p : personData) {
            if(p.getBirthDate().equals(minByAge.getBirthDate()) && p.getPhoneNumber()!= 0 && LocalDate.now().isAfter(p.getBirthDate())) {
                highestAgePerson.add(new Person(p.getName(), p.getSurname(), p.getBirthDate(), p.getPhoneNumber()));
            }
        }

        if(highestAgePerson.size() > 0) {
            age = (LocalDate.now().getYear() - minByAge.getBirthDate().getYear());
        }

        return "There is/are " + highestAgePerson.size() + " oldest person with age of: " + age + " having phone number.\n" + highestAgePerson;
    }

}
