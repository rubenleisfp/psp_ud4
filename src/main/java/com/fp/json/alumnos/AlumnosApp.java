package com.fp.json.alumnos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class AlumnosApp {
    public static void main(String[] args) {
        try {
            // Crear ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Leer JSON a List<Alumno>
            List<Alumno> alumnos = mapper.readValue(
                    new File("src/main/resources/json/alumnos/alumnos_asignaturas.json"),
                    new TypeReference<List<Alumno>>() {}
            );

            // Mostrar alumnos
            System.out.println("Lista de alumnos:");
            for (Alumno alumno : alumnos) {
                System.out.println(alumno);
            }

            // Calcular media de calificaciones
            double suma = 0;
            int contador = 0;

            for (Alumno alumno : alumnos) {
                for (Asignatura asignatura : alumno.getAsignaturas()) {
                    suma += asignatura.getCalificacion();
                    contador++;
                }
            }

            double media = (contador > 0) ? (suma / contador) : 0;

            System.out.println("\nCalificación media de todos los alumnos: " + media);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
