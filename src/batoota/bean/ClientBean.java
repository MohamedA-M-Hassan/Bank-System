package batoota.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import n3na3a.service.ClientService;
import zglola.db.Client;


@SuppressWarnings("serial")
@ManagedBean(name = "client")
// @ViewScoped
@SessionScoped
public class ClientBean implements Serializable {
	private Long id;
	private String name;
	private String userName;
	private String password;
	private String mobile;
	private Date birthDate;
	private String mail;
	private String address;
	private Long netSalary;
	private Long bankId;
	private ArrayList<Client> clientList;

	public ClientBean() {
	}

	public String addClient() {
		Client insertedClient = new Client();
		insertedClient.setName(name);
		// insertedClient.setMobile(mobile);
		insertedClient.setUserName(userName.toLowerCase());
		insertedClient.setPassword(password);
		// insertedClient.setNetSalary(netSalary);
		insertedClient.setMail(mail);
		// insertedClient.setAddress(address);
		// insertedClient.setBirthDate(birthDate);
		ClientService.insertClient(insertedClient);
		return "index";
	}
	
	public String login() {
		
		if(
				ClientService.getClientByEmailAndPassword(mail, password) != null)
			return "clientHome";
		return "index";
	}

	public String go() {
		return "signup";
	}

	/****************************/
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

	public ArrayList<Client> getClientList() {
		return clientList;
	}

	public void setClientList(ArrayList<Client> clientList) {
		this.clientList = clientList;
	}
}