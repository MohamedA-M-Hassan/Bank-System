package zglola.db;

import java.io.Serializable;
import java.util.Date;

// After Hibernate
// please add @Entity
// and @Table .. 
public class Client implements Serializable {
	private Long id;
	private String name;
	private String userName;
	private String password;
	private String mobile;
	private Date birthDate;
	private String mail;
	private String address;
	private Long netSalary;
	//private Long bankId;
	// private Long employeeId;
	// private Long type;

	public Client() {

	}

	public Client(Long id, String name, String userName, String password, String mobile, Date birthDate, String mail, String address, Long netSalary) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
		this.birthDate = birthDate;
		this.mail = mail;
		this.address = address;
		this.netSalary = netSalary;
		//this.bankId = bankId;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/*
	 * public Date getBirthDate() { return birthDate; }
	 * 
	 * public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
	 */
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
/*
	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}
	
	 * public Long getEmployeeId() { return employeeId; }
	 * 
	 * public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
	 * 
	 * public Long getType() { return type; }
	 * 
	 * public void setType(Long type) { this.type = type; }
	 * 
	 */
}
