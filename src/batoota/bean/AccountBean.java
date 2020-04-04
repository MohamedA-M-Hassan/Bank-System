package batoota.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import n3na3a.service.AccountService;
import n3na3a.service.TransactionService;
import zglola.db.Account;
import zglola.db.Client;
import zglola.db.Transaction;

@SuppressWarnings("serial")
@ManagedBean(name = "account")
@SessionScoped
public class AccountBean implements Serializable{
	private Client client;
	private Account account;
	private ArrayList<Transaction> transactionList;
	//private ArrayList<Transaction> transactionListToDisply;
	private Transaction transaction;
	
	public AccountBean() {
		HttpSession session = SessionUtils.getSession();
		this.client = (Client) session.getAttribute("client");
		this.account = AccountService.getAccountByClientByClient(this.client.getId());
		this.transactionList = TransactionService.getTransactionsByAccountId(this.account.getId());
		//this.transactionListToDisply =TransactionService.transactionListToDislpyWithAccountNo(this.transactionList);
	}
	

	public void dialogTransaction()
	{
		transaction= new Transaction();
		transaction.setFromAccountId(this.account.getId());
		//transaction.setTransactionDate(new Date ());
		transaction.setStatus("pending");
	}
	
	public void addTransaction()
	{
		TransactionService.addTransaction(transaction);
	}
	
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "index";
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(ArrayList<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

/*
	public ArrayList<Transaction> getTransactionListToDisply() {
		return transactionListToDisply;
	}


	public void setTransactionListToDisply(ArrayList<Transaction> transactionListToDisply) {
		this.transactionListToDisply = transactionListToDisply;
	}
*/


	public Transaction getTransaction() {
		return transaction;
	}


	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
