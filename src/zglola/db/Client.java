package zglola.db;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

// After Hibernate
// please add @Entity
// and @Table .. 

// note that this ORM so please delete the managedbean from it in future

@ManagedBean(name= "client")
@SessionScoped
public class Client implements Serializable{
	private Long id;
	private String name;
	private String userName;
	private String password;
	private Long mobile;
	private Date birthDate;
	private String mail;
	private String address;
	private Long netSalary;
	private Long bankId;
	private Long employeeId;
	private Long type;
	
	public Client()
	{
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(Long netSalary) {
		this.netSalary = netSalary;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	
}
	

