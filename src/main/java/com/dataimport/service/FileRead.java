package com.dataimport.service;

import com.dataimport.Exceptions.FileReaderException;
import com.dataimport.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileRead {

    @Autowired
    PersonService personService;

    public void readFile(String path) throws FileReaderException {

        File file = new File(path);

        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))) {
            List<String> dataList = fileLines.collect(Collectors.toList());
            List<Person> personList = personService.createPersonList(dataList);
            System.out.println(personService.findHighestAgeSearcher(personList));

        } catch (IOException e) {

            throw new FileReaderException("Check path to file");
        }
    }
}
