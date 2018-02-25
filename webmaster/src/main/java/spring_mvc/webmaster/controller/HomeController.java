package spring_mvc.webmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring_mvc.webmaster.model.Employee;
import spring_mvc.webmaster.serviceImpl.RegisterEmployeeServiceImpl;

@RestController
@RequestMapping("user")
public class HomeController {
  @Autowired
   public RegisterEmployeeServiceImpl employeeService;
	@RequestMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id){
		System.out.println("id is"+id);
		Employee employee = employeeService.getEmployee(id);
		System.out.println(employee.getAddress());
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	
	}
	@RequestMapping(value="/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registerEmployee(@RequestBody Employee employee){
		System.out.println("id is"+employee.getAddress());
		employeeService.employeeRegister(employee);
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	
	}
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<String> updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee ){
	
		employeeService.updateEmployee(id, employee);
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	
	}
	@RequestMapping(value="/user1/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> removeEmployee(@PathVariable("id") int id){
		System.out.println("value");
		boolean status = employeeService.removeEmployee(id);
		System.out.println("Status is"+status);
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	
	}
}
