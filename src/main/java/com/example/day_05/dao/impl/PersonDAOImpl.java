package com.example.day_05.dao.impl;

import com.example.day_05.dao.PersonDAO;
import com.example.day_05.database.PersonDB;
import com.example.day_05.model.Person;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PersonDAOImpl implements PersonDAO {
    @Override
    public void printListPeople(List<Person> persons) {
        for (Person person : PersonDB.persons) {
            System.out.println(person);
        }
    }

    @Override
    public List<Person> getAll() {
        return PersonDB.persons;
    }

    @Override
    public List<Person> sortPeopleByFullName() {
        return PersonDB.persons.stream()
                .sorted(Comparator.comparing(Person::getFullname))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> sortPeopleByFullNameReversed() {
        return PersonDB.persons.stream()
                .sorted(Comparator.comparing(Person::getFullname).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getSortedJobs() {
        return PersonDB.persons.stream()
                .map(Person::getJob)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getSortedCities() {
        return PersonDB.persons.stream()
                .map(Person::getCity)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> femaleNames() {
        return PersonDB.persons.stream()
                .filter(person -> person.getGender().equals("Female"))
                .map(Person::getFullname)
                .collect(Collectors.toList());
    }

    @Override
    public Person highestEarner() {
        return PersonDB.persons.stream()
                .max(Comparator.comparingDouble(Person::getSalary))
                .orElse(null);
    }

    @Override
    public List<Person> bornAfter1990() {
        return PersonDB.persons.stream()
                .filter(p -> p.getBirthday().getYear() > 1990)
                .collect(Collectors.toList());
    }

    @Override
    public double averageSalary() {
        return PersonDB.persons.stream()
                .mapToDouble(Person::getSalary)
                .average()
                .orElse(0);
    }

    @Override
    public double averageAge() {
        return PersonDB.persons.stream()
                .mapToInt(person -> LocalDate.now().getYear() - person.getBirthday().getYear())
                .average()
                .orElse(0);
    }

    @Override
    public List<Person> nameContains(String keyword) {
        return PersonDB.persons.stream()
                .filter(person -> person.getFullname().contains(keyword))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> sortedByAgeForMale() {
        return PersonDB.persons.stream()
                .filter(person -> person.getGender().equals("Male"))
                .sorted(Comparator.comparing(Person::getBirthday))
                .collect(Collectors.toList());
    }

    @Override
    public Person longestName() {
        return PersonDB.persons.stream()
                .max(Comparator.comparingInt(person -> person.getFullname().length()))
                .orElse(null);
    }

    @Override
    public List<Person> aboveAverageSalary() {
        double averageSalary = averageSalary();
        return PersonDB.persons.stream()
                .filter(p -> p.getSalary() >= averageSalary)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Person>> groupPeopleByCity() {
        return PersonDB.persons.stream()
                .collect(Collectors.groupingBy(Person::getCity));
    }

    @Override
    public Map<String, Integer> groupJobByCount() {
        return PersonDB.persons.stream()
                .collect(Collectors.groupingBy(Person::getJob, Collectors.summingInt(p -> 1)));
    }
}
