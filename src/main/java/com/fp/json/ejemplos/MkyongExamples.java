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
        throw new UnsupportedOperationException("A implementar por el alumno");
    }

    /**
     * Leer un String JSON y convertirlo en un objeto Java
     */
    private static void convertJsonToObject() {
        throw new UnsupportedOperationException("A implementar por el alumno");
    }

    private static void writeObjectToJsonFile() {
        throw new UnsupportedOperationException("A implementar por el alumno");
    }

    private static void readObjectFromJsonFile() {
        throw new UnsupportedOperationException("A implementar por el alumno");
    }
}
