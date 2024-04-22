package com.example.day_05.services;

import com.example.day_05.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPeople();

    List<Person> getAllPeople(int page, int size);

}
