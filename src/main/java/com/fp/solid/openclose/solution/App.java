package com.fp.solid.openclose.solution;

public class App {

	/*
	Ahora puedo agregar mas vehiculos sin modificar el codigo
	Simplemente tengo que crear una nueva clase
	 */
	public static void main(String[] args) {
		App app = new App();
		app.run();
	}

	public void run() {
		Vehicle v1 = new Car();
		Vehicle v2 = new Motorbike();

		v1.draw();
		v2.draw();
	}
}