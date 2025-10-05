package com.fp.solid.inyeccion.problem.service;

import com.fp.solid.inyeccion.problem.repository.Employee;
import com.fp.solid.inyeccion.problem.repository.EmployeeDao;
import com.fp.solid.inyeccion.problem.repository.impl.EmployeeFileDao;
import com.fp.solid.inyeccion.problem.repository.impl.EmployeeJdbcDao;

import java.math.BigDecimal;
import java.util.List;


public class EmployeeService {

	//Aqui estamos atados a la implementacion JDBC. 
	// ¿Qué pasa si ahora necesitamos interactuar con el fichero en vez de con la BBDD?
	//Si solo usamos el DAO en esta clase, solo tenemos que cambiar estar linea, pero ¿y si lo usamos en 40 clases?
	//Podriamos mejorarlo con la inyeccion de dependencias. Solo una parte de nuestra app debería crear las instancias de componentes
	//y pasarsela a quien la requiera
	//private EmployeeDao employeeDao = new EmployeeJdbcDao();
	private EmployeeDao employeeDao = new EmployeeFileDao("src/main/resources/solid.inyeccion/employees.csv");
	

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