package batoota.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 

import n3na3a.service.AccountService;
import n3na3a.service.BankEmployeeService;
import n3na3a.service.ClientService;
import zglola.db.Account;
import zglola.db.BankEmployee;
import zglola.db.Client;

@SessionScoped
@ManagedBean(name = "user")
public class User implements Serializable {
	private int type; // 1 = client or 2 = bank employee
	private String password;
	private String username;
	private Client client;
	private BankEmployee bankEmployee;
	private Account account;
	private static Long accountNumber = 1000000L;

	public User() {
		type = 1;
		client = new Client();
		bankEmployee = new BankEmployee();

		account = new Account();

	}

	public Long handleClientId() {
		return (long) ClientService.getNoOfClientsInDbToHandleID();
	}

	public Long handleAccountId() {
		return (long) AccountService.getNoOfAccountInDbToHandleID();
	}

	public Long handleBankEmployeeId() {
		// TODO review
 		return (long) BankEmployeeService.getNoOfEmployeesInDbToHandleID();
		}

	public String addBankEmployee() {
		if( ! UserValidation.validateBankEmployee(bankEmployee) ) 
			return "error";

		bankEmployee.setId(handleBankEmployeeId());
		BankEmployeeService.insertEmployee(bankEmployee);

		return "index";
	}

	// sign
	public String addClient() {
		if( ! UserValidation.validateClient(client) ) 
			return "error";
		
		client.setId(handleClientId());
		ClientService.insertClient(client);

		addAccount(client.getId());

		return "index";
	}
	
	
	
	
	public void addAccount(Long clientId) {
		account.setId(handleAccountId());
		account.setBalance(0L);
		account.setClientId(clientId);
		account.setAccountNumber(generateAccountNumber());
		account.setAvailableBalance(0L);
	}

	public Long generateAccountNumber() {
		return accountNumber += 1;

	}

	public String login() {
		
		HttpSession session = SessionUtils.getSession();
		 
		// part1 [client]: check if username is correct and pass is not correct
		// part2 [client]: check if username and pass are correct 
		Client client = ClientService.getClientByUsernameAndPassword(username, password);
		if (client != null) {
			session.setAttribute("client", client);
			return "clientHome";
		}
		
		
		///////////////////////////////
		// part3 [employee]: check if username is correct and pass is not correct
		// part4 [employee]: check if username and pass are correct 
		BankEmployee bankEmployee=  BankEmployeeService.getEmployeeByUsernameAndPassword(username, password);
		if (bankEmployee != null) {
			session.setAttribute("employee", bankEmployee);
			return "employeeHome";
		}
		
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Invalid Username or Passowrd",
						"Please enter correct username and Password"));
		return "index";
	}

	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
