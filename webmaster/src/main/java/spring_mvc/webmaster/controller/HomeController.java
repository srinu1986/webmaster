package spring_mvc.webmaster.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import spring_mvc.webmaster.exception.EmployeeNotFoundException;
import spring_mvc.webmaster.model.Employee;
import spring_mvc.webmaster.serviceImpl.RegisterEmployeeServiceImpl;

@RestController
@RequestMapping("user")
public class HomeController {
  @Autowired
   public RegisterEmployeeServiceImpl employeeService;
	@RequestMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id){
		Employee employee = null;
		try	{
		System.out.println("id is"+id);
		employee = employeeService.getEmployee(id);
		System.out.println(employee.getAddress());
	}
/*	catch(SQLException sql)
	{
		throw new SQLException("SQLException, id="+id);
	}
	catch(IOException io)
	{
		throw new IOException("IOException, id="+id);
	}*/
	catch(Exception e)
	{
		try{
		throw new EmployeeNotFoundException(id);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
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
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
		System.out.println("Requested URL="+request.getRequestURL());
		System.out.println("Exception Raised="+ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}
}
