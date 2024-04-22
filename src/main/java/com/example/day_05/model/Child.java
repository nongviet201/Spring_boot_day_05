package com.example.day_05.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level =  AccessLevel.PRIVATE)
public class Child {
    String name;
    int age;
}
