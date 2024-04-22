package com.example.day_05.ultils;

import com.example.day_05.model.Child;
import com.example.day_05.model.Person;

import java.util.List;

public interface IFileReader {
    List<Person> readFile(String path);
}
