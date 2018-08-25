package com.dataimport;

import com.dataimport.Exceptions.FileReaderException;
import com.dataimport.model.ProgramInfo;
import com.dataimport.service.FileRead;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class DataInputRunner {

    public static void main(String args[]) throws IOException {

        ConfigurableApplicationContext context = SpringApplication.run(DataInputRunner.class);

        FileRead fileReader = context.getBean(FileRead.class);

        ProgramInfo programInfo = context.getBean(ProgramInfo.class);

        programInfo.printInfo();

        System.out.println("________________________________________");
        System.out.println("Select path to Your txt file: f.e. D://data.txt");

        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        try {
            fileReader.readFile(path);
        } catch (FileReaderException e) {
            System.out.println("Something went wrong, check file path.");
        }
    }
}
