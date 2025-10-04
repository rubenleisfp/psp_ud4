package com.fp.solid.inyeccion.pizzeria;

public class Pizza {
    private Ingredientes ingredientes;


    public Pizza(Ingredientes ingredientes) {
        this.ingredientes = ingredientes; 
    }


    public void prepararPizza() {
        // Aquí usas los ingredientes para preparar la pizza
        System.out.println("Preparando pizza con " + ingredientes.getTipo());
    }
}