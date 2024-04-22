package com.example.day_05.ultils;

import com.example.day_05.model.Person;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Qualifier("JSONReader")
@Component
public class JsonFileReader implements IFileReader {

    @Override
    public List<Person> readFile(String path) {
        System.out.println("Đọc file JSON");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            // Đọc file JSON và chuyển đổi nó thành danh sách các đối tượng Person
            return mapper.readValue(Paths.get(path).toFile(), new TypeReference<List<Person>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();  // Trả về danh sách trống nếu có lỗi
    }



}
