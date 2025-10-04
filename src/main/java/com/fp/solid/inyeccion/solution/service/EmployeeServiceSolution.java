package com.fp.solid.inyeccion.solution.service;

import com.fp.solid.inyeccion.problem.repository.Employee;
import com.fp.solid.inyeccion.problem.repository.EmployeeDao;

import java.math.BigDecimal;
import java.util.List;



public class EmployeeServiceSolution {

	private EmployeeDao employeeDao;

	/**
	 * Ahora recibimos el DAO por constructor
	 * Esto nos ayuda a desacoplar la implementacion
	 * Podemos estar usando JDBC, fichero o cualquier otra implementacion
	 *
	 * @param employeeDao
	 */
	public EmployeeServiceSolution(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	

	public List<Employee> getEmployeesWithLessSalary(BigDecimal salaryCondition) throws Exception {
		return this.employeeDao.getEmployeesWithLessSalary(salaryCondition);
	}

	public String getEmployeesWithLessSalarySeparatedWithCommas(BigDecimal salaryCondition) throws Exception {
		StringBuilder sb = new StringBuilder();
		List<Employee> employeesWithLessSalary = this.getEmployeesWithLessSalary(salaryCondition);
		for (Employee e : employeesWithLessSalary) {
			sb.append(e.getName());
			sb.append(";");
		}
		return sb.toString();
	}

}