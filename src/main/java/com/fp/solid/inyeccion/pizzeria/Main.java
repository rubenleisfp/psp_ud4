package com.fp.solid.inyeccion.pizzeria;

public class Main {
    public static void main(String[] args) {
        //Ingredientes ingredientes = new JamonYQueso(); // ⇒ inyectamos los ingredientes
        Ingredientes ingredientes = new ChorizoYChampinhones();
        Pizza pizza = new Pizza(ingredientes);
        pizza.prepararPizza();
    }
}