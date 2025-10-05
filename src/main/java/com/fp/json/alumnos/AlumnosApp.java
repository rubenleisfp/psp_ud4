package com.fp.json.alumnos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AlumnosApp {
    public static void main(String[] args) {
        try {
            List<Alumno> alumnos = getAlumnos();
            mostrarAlumnos(alumnos);
            mostrarNotaMedia(alumnos);
        } catch (Exception e) {
           System.err.println(e.getMessage());
        }
    }

    private static List<Alumno> getAlumnos() throws IOException {
        throw new UnsupportedOperationException("A implementar por el alumno");

    }

    private static void mostrarAlumnos(List<Alumno> alumnos) {
        throw new UnsupportedOperationException("A implementar por el alumno");

    }

    private static void mostrarNotaMedia(List<Alumno> alumnos) {
        throw new UnsupportedOperationException("A implementar por el alumno");
    }


}
