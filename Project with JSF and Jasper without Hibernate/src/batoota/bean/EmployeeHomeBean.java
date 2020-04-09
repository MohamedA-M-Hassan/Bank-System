package batoota.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import n3na3a.service.AccountService;
import n3na3a.service.ClientService;
import n3na3a.service.TransactionService;
import zglola.db.Account;
import zglola.db.BankEmployee;
import zglola.db.Client;
import zglola.db.Transaction;

@SuppressWarnings("serial")
@ManagedBean(name = "employeeHome")
@SessionScoped
public class EmployeeHomeBean implements Serializable {

	private BankEmployee employee;
	private ArrayList<Transaction> transactionList;
	// private ArrayList<Transaction> transactionListToDisply;
	private Transaction transactionToBeEdited;
	private Long totalNumberOfClients;
	private Long totalNumberOfTransactions;
	private Long totalNumberOfPendingTransactions;
	private Long totalNumberOfTransactionsSubmitedByCurrentEmployee;
	private Client bestClient;
	private Float performanceRatio;

	public EmployeeHomeBean() {
		HttpSession session = SessionUtils.getSession();
		this.employee = (BankEmployee) session.getAttribute("employee");
		this.transactionList = TransactionService.getAllTransactions();
		// this.transactionListToDisply
		// =TransactionService.transactionListToDislpyWithAccountNo(this.transactionList);
		transactionToBeEdited = new Transaction();
		this.totalNumberOfClients = ClientService.getNoOfClientsInDbToHandleID();
		this.totalNumberOfTransactions = TransactionService.getNoOfTransactions();
		this.totalNumberOfPendingTransactions = TransactionService.getNoOfPendingTransactions();
		this.bestClient = returnBestClient();
		this.totalNumberOfTransactionsSubmitedByCurrentEmployee = TransactionService
				.getTotalNumberOfTransactionsSubmitedByCurrentEmployee(this.employee.getId());
		this.performanceRatio = 100 * ((float) this.totalNumberOfTransactionsSubmitedByCurrentEmployee
				/ (float) this.totalNumberOfTransactions);
	}
	
	public String logout() {

		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "index";
	}

	public void approveTransaction() {
		this.transactionToBeEdited.setBankEmployeeId(this.employee.getId());
		this.transactionToBeEdited.setStatus("Accepted");
		AccountService.updateBalanceAndAvailableBalance(transactionToBeEdited);
		// TransactionService.updateTransaction(transactionToBeEdited);
		// this.bestClient = returnBestClient();
		init();
	}

	public void rejectTransaction()
	{
		this.transactionToBeEdited.setBankEmployeeId(this.employee.getId());
		this.transactionToBeEdited.setStatus("Rejected");
		AccountService.updateBalanceAndAvailableBalance(transactionToBeEdited);
		// TransactionService.updateTransaction(transactionToBeEdited);
		// this.bestClient = returnBestClient();
		init();
	}
	public void init() {
		transactionToBeEdited = new Transaction();
		this.totalNumberOfClients = ClientService.getNoOfClientsInDbToHandleID();
		this.totalNumberOfTransactions = TransactionService.getNoOfTransactions();
		this.totalNumberOfPendingTransactions = TransactionService.getNoOfPendingTransactions();
		this.bestClient = returnBestClient();
		this.totalNumberOfTransactionsSubmitedByCurrentEmployee = TransactionService
				.getTotalNumberOfTransactionsSubmitedByCurrentEmployee(this.employee.getId());
		this.performanceRatio = 100 * ((float) this.totalNumberOfTransactionsSubmitedByCurrentEmployee
				/ (float) this.totalNumberOfTransactions);
	}

	public void selectedTransaction(Transaction t) {
		this.transactionToBeEdited = t;
	}

	public Client returnBestClient() {
		return ClientService.getClientById(AccountService.getBestClientIdWithHigherBlance());
	}
	/////////////////

	public Float getPerformanceRatio() {
		return performanceRatio;
	}

	public void setPerformanceRatio(Float performanceRatio) {
		this.performanceRatio = performanceRatio;
	}

	public BankEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(BankEmployee employee) {
		this.employee = employee;
	}

	public ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(ArrayList<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	public Transaction getTransactionToBeEdited() {
		return transactionToBeEdited;
	}

	public void setTransactionToBeEdited(Transaction transaction) {
		this.transactionToBeEdited = transaction;
	}

	public Long getTotalNumberOfClients() {
		return totalNumberOfClients;
	}

	public void setTotalNumberOfClients(Long totalNumberOfClients) {
		this.totalNumberOfClients = totalNumberOfClients;
	}

	public Client getBestClient() {
		return bestClient;
	}

	public void setBestClient(Client bestClient) {
		this.bestClient = bestClient;
	}

	public Long getTotalNumberOfTransactions() {
		return totalNumberOfTransactions;
	}

	public void setTotalNumberOfTransactions(Long totalNumberOfTransactions) {
		this.totalNumberOfTransactions = totalNumberOfTransactions;
	}

	public Long getTotalNumberOfPendingTransactions() {
		return totalNumberOfPendingTransactions;
	}

	public void setTotalNumberOfPendingTransactions(Long totalNumberOfPendingTransactions) {
		this.totalNumberOfPendingTransactions = totalNumberOfPendingTransactions;
	}

	public Long getTotalNumberOfTransactionsSubmitedByCurrentEmployee() {
		return totalNumberOfTransactionsSubmitedByCurrentEmployee;
	}

	public void setTotalNumberOfTransactionsSubmitedByCurrentEmployee(
			Long totalNumberOfTransactionsSubmitedByCurrentEmployee) {
		this.totalNumberOfTransactionsSubmitedByCurrentEmployee = totalNumberOfTransactionsSubmitedByCurrentEmployee;
	}

}