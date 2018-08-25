package com.dataimport.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Person {

    private String name;

    private String surname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private long phoneNumber;

    public Person(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "| name: "+ name
                + ", surname: " + surname
                + ", age: "+ (LocalDate.now().getYear() - birthDate.getYear())
                + ", phoneNumber: " + phoneNumber
                + " |\n";
    }
}
