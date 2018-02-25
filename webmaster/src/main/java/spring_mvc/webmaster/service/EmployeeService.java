package spring_mvc.webmaster.service;

import spring_mvc.webmaster.model.Employee;

public interface EmployeeService {
	
	public void employeeRegister(Employee e);
	public Employee getEmployee(int id);
	public boolean updateEmployee(int id,Employee employee);
	public boolean removeEmployee(int id);
		
	

}
