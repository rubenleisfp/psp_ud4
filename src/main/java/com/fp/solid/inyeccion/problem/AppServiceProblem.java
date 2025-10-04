package com.fp.solid.inyeccion.problem;

import com.fp.solid.inyeccion.problem.service.EmployeeService;

import java.math.BigDecimal;



public class AppServiceProblem {

	EmployeeService employeeService = new EmployeeService();


	public static void main(String[] args) {
		AppServiceProblem appService = new AppServiceProblem();;
		try {
			appService.procesar();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private void procesar() throws Exception {
		String employeesWithLessSalarySeparatedWithCommas = employeeService.getEmployeesWithLessSalarySeparatedWithCommas(new BigDecimal(30000));
		System.out.println("employeesWithLessSalarySeparatedWithCommas: " + employeesWithLessSalarySeparatedWithCommas);
	}

}