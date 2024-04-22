package com.example.day_05.services.impl;

import com.example.day_05.dao.PersonDAO;
import com.example.day_05.dao.impl.PersonDAOImpl;
import com.example.day_05.model.Person;
import com.example.day_05.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDAO personDAO;

    @Override
    public List<Person> getAllPeople() {
        return personDAO.getAll();
    }

    @Override
    public List<Person> getAllPeople(int page, int size) {
        return List.of();
    }
}
