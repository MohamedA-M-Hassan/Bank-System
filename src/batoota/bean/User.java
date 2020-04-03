package batoota.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import n3na3a.service.ClientService;
import zglola.db.BankEmployee;
import zglola.db.Client;

@SessionScoped
@ManagedBean(name = "user")
public class User implements Serializable {
	private int type; // 1 = client or 2 = bank employee
	private String password;
	private String mail;
	private Client client;
	private BankEmployee bankEmployee;

	public User() {
		type = 1;
		client = new Client();
		bankEmployee = new BankEmployee();
	}

	public Long handleClientId() {
		return (long) ClientService.getNoOfClientsInDbToHandleID();
	}

	public Long handleBankEmployeeId() {
		// TO_DO
		return (long) ClientService.getNoOfClientsInDbToHandleID();
	}

	public String addBankEmployee() {
		// TO_DO
		return "index";
	}

	public String addClient() {

		client.setId(handleClientId());
		ClientService.insertClient(client);
		return "index";
	}

	public String login() {
		// TO_DO save session

		if (ClientService.getClientByEmailAndPassword(mail, password) != null)
			return "clientHome";

		return "index";
	}

	public void reset() {

	}

	public String go() {
		return "signup";
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public BankEmployee getBankEmployee() {
		return bankEmployee;
	}

	public void setBankEmployee(BankEmployee bankEmployee) {
		this.bankEmployee = bankEmployee;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
