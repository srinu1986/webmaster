package spring_mvc.webmaster.dao;

import spring_mvc.webmaster.model.Employee;

public interface EmployeeDao {
	public void registerEmployee(Employee e);
	public Employee getEmployee(int id);
	public boolean updateEmployee(int id,Employee employee);
	public boolean removeEmployee(int id);

}
