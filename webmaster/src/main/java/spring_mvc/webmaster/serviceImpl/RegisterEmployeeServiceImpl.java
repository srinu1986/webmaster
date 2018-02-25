package spring_mvc.webmaster.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_mvc.webmaster.daoImpl.EmployeeDaoImpl;
import spring_mvc.webmaster.model.Employee;
import spring_mvc.webmaster.service.EmployeeService;
@Service
public class RegisterEmployeeServiceImpl implements EmployeeService{
	@Autowired
	public EmployeeDaoImpl employeeDaoImpl;
	public void employeeRegister(Employee e)
	{
		employeeDaoImpl.registerEmployee(e);
	}
	public Employee getEmployee(int id)
	{
		Employee employee = employeeDaoImpl.getEmployee(id);
		return employee;
	}
	public boolean updateEmployee(int id,Employee employee){
		boolean status = employeeDaoImpl.updateEmployee(id, employee);
		return status;
		
	}
	public boolean removeEmployee(int id){
		boolean status = employeeDaoImpl.removeEmployee(id);
		return status;
		
	}

}
