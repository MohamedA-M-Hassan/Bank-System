package batoota.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import n3na3a.service.ClientService;
import zglola.db.BankEmployee;
import zglola.db.Client;

@SessionScoped
@ManagedBean(name = "user")
public class User extends HttpServlet implements Serializable {
	private int type; // 1 = client or 2 = bank employee
	private String password;
	private String mail;
	private Client client;
	private BankEmployee bankEmployee;

	public User() {
		type = 1;
		client = new Client();
		bankEmployee = new BankEmployee();
		HttpSession session2 = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
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
		validateClient(client);

		client.setId(handleClientId());
		ClientService.insertClient(client);

		return "index";

	}

	public String validateClient(Client client) {
		if (client.getName().equals(null) || client.getName().trim().equals("")) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Name is required"));
			return "error";
		}
		return "";

	}

	public String login() {
		// TO_DO save session

		if (ClientService.getClientByEmailAndPassword(mail, password) != null)

			return "clientHome";
		else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("User name or Password is not correct please try again."));
		}

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
