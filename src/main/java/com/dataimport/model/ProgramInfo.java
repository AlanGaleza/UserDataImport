package com.dataimport.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProgramInfo {

    @Value("${info.app.name}")
    private String programName;

    @Value("${info.app.description}")
    private String description;

    @Value("${info.app.version}")
    private String version;

    @Value("${info.app.owner.name}")
    private String ownerName;

    @Value("${info.app.owner.surname}")
    private String ownerSurname;

    @Value("${info.app.administrator.email}")
    private String adminMail;

    public void printInfo(){
        System.out.println(programName + "\n" + description + "\nversion: " + version + "\nCreated by: " + ownerName + " " + ownerSurname + "\nemail: " + adminMail);
    }


}
