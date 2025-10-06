package com.fp.solid.inyeccion.solution.service;

import com.fp.solid.inyeccion.problem.repository.EmployeeDao;
import com.fp.solid.inyeccion.problem.repository.impl.EmployeeJdbcDao;

import java.math.BigDecimal;



public class AppServiceSolution {

	EmployeeServiceSolution employeeService;
	EmployeeDao employeeDao;

	public static void main(String[] args) {
		AppServiceSolution appService = new AppServiceSolution();
		appService.cfgComponentes();
		try {
			appService.procesar();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Configuramos los componentes que utilizaremos en nuestra app:
	 * 
	 * DAOs y Services con DAOs inyectados
	 * 
	 */
	private void cfgComponentes() {
		//Podria pasar este mismo objeto a todas los componentes de mi aplicacion que lo necesitasen
		employeeDao = new EmployeeJdbcDao();
		employeeService = new EmployeeServiceSolution(employeeDao);
	}

	private void procesar() throws Exception {
		String employeesWithLessSalarySeparatedWithCommas = employeeService
				.getEmployeesWithLessSalarySeparatedWithCommas(new BigDecimal(30000));
		System.out.println("employeesWithLessSalarySeparatedWithCommas: " + employeesWithLessSalarySeparatedWithCommas);
	}

}