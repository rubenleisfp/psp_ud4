package com.fp.json.ejemplos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MkyongExamples {

    public static void main(String[] args) {
        convertObjectToJson();
        convertJsonToObject();
        writeObjectToJsonFile();
        readObjectFromJsonFile();
    }

    /**
     * Escribir un objeto Java en un String
     */
    private static void convertObjectToJson () {
        Person person = new Person("mkyong", 42);

        ObjectMapper om = new ObjectMapper();

        try {

            // covert Java object to JSON strings
            String json = om.writeValueAsString(person);

            // output: {"name":"mkyong","age":42}
            System.out.println(json);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * Leer un String JSON y convertirlo en un objeto Java
     */
    private static void convertJsonToObject() {
        String json = "{\"name\": \"mkyong\", \"age\": 20}";

        ObjectMapper om = new ObjectMapper();

        try {

            // covert JSON to Java object
            Person person = om.readValue(json, Person.class);

            // output: Person{name='mkyong', age=20}
            System.out.println(person);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }

    private static void writeObjectToJsonFile() {
        Person person = new Person("mkyong", 42);

        ObjectMapper om = new ObjectMapper();

        try {

            // convert Java object to JSON strings and save it to file `person.json`
            om.writeValue(new File("person.json"), person);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void readObjectFromJsonFile() {
        ObjectMapper om = new ObjectMapper();

        try {

            // read JSON from a file and convert it to Java object
            Person person = om.readValue(new File("person.json"), Person.class);

            System.out.println(person);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
