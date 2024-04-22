package com.example.day_05.model;

import com.example.day_05.ultils.CustomLocalDateDeserializer;
import com.example.day_05.ultils.JsonFileReader;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level =  AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
     int id;
     String fullname;
     String job;
     String gender;
     String city;
     int salary;

//     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
     @JsonDeserialize(using = CustomLocalDateDeserializer.class)
     LocalDate birthday;

//     List<Child> childrens;
}
