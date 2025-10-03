package com.fp.json.alumnos;

public class Asignatura {
    private String nombre;
    private int calificacion;

    public Asignatura() {
    }

    public Asignatura(String nombre, int calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return nombre + " (" + calificacion + ")";
    }
}
