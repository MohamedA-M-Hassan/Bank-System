package zglola.db;

import java.io.Serializable;

//After Hibernate
//please add @Entity
//and @Table .. 

@SuppressWarnings("serial")
public class BankEmployee implements Serializable {
	private Long id;
	private String name;
	private String userName;
	private String password;
	private String mobile;
	//private Date birthDate;
	private String position;
	private Long bankId;
	
	public BankEmployee(Long id, String name, String userName, String password, String mobile
			//, Date birthDate
			, String position, Long bankId) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
		//this.birthDate = birthDate;
		this.position = position;
		this.bankId = bankId;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Long getBankId() {
		return bankId;
	}
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}
}
