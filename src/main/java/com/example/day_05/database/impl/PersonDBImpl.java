package com.example.day_05.database.impl;

import com.example.day_05.database.PersonDB;
import com.example.day_05.model.Person;
import com.example.day_05.ultils.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonDBImpl implements CommandLineRunner {
    @Qualifier("JSONReader") // goi doi tuong muon lua chon uu tien
    @Autowired
    public IFileReader iFileReader;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("khởi tạo dữ liệu");

        PersonDB.persons = iFileReader.readFile("F:/java23 Techmaster/JavaSpring/SpringBoot/day_05/src/main/java/com/example/day_05/ultils/People.JSON");

    }
}
