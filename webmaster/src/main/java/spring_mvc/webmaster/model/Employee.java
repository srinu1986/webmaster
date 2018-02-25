package spring_mvc.webmaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	@Id
	public Integer empld;
	@Column(name="stdName")
	public String name;
	@Column(name="stdAdress")
	public String address;
	/**
	 * @return the empld
	 */
	public Integer getEmpld() {
		return empld;
	}
	/**
	 * @param empld the empld to set
	 */
	public void setEmpld(Integer empld) {
		this.empld = empld;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
