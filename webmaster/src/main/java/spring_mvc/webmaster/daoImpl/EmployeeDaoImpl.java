package spring_mvc.webmaster.daoImpl;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_mvc.webmaster.dao.EmployeeDao;
import spring_mvc.webmaster.model.Employee;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
		@Autowired
		public SessionFactory sessionFactory;
		public void registerEmployee(Employee e){
			System.out.println("Srinu");
			Session session = sessionFactory.openSession();
			session.save(e);
			Transaction t = session.beginTransaction();
			System.out.println(e.getEmpld());
			t.commit();
			session.close();
			
			
		}
		public Employee getEmployee(int id){
			Session session = sessionFactory.openSession();
			Employee employee = (Employee)session.get(Employee.class,id);
		
			Transaction t = session.beginTransaction();
			session.save(employee);
			t.commit();
			session.close();
			return employee;
		}
		public boolean updateEmployee(int id,Employee employee){
			boolean status = true;
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			Employee employee2 = session.byId(Employee.class).load(id);
			employee2.setAddress(employee.getAddress());
			employee2.setName(employee.getName());
			session.flush();
			t.commit();
			session.close();
			
			return status;
		}
		public boolean removeEmployee(int id){
			boolean status = false;
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			//SQLQuery query = session.createSQLQuery("Delete from employee where eid = ?");
			Employee employee2 = session.byId(Employee.class).load(id);
			
			session.delete(employee2);
			
			t.commit();
			session.close();
			return status;
			
		}
	

}
