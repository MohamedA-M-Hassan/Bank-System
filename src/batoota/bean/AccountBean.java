package batoota.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

//import com.sun.javafx.collections.MappingChange.Map;

import n3na3a.service.AccountService;
import n3na3a.service.TransactionService;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import zglola.db.Account;
import zglola.db.Client;
import zglola.db.Transaction;

@SuppressWarnings("serial")
@ManagedBean(name = "account")
@SessionScoped
public class AccountBean implements Serializable {
	private Client client;
	private Account account;
	private ArrayList<Transaction> transactionList;
	// private ArrayList<Transaction> transactionListToDisply;
	private Transaction transaction;
	private Long netSalary;

	public Long getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(Long netSalary) {
		this.netSalary = netSalary;
	}

	public AccountBean() {
		HttpSession session = SessionUtils.getSession();
		this.client = (Client) session.getAttribute("client");
		this.account = AccountService.getAccountByClientByClient(this.client.getId());
		this.transactionList = TransactionService.getTransactionsByAccountId(this.account.getId());
		// this.transactionListToDisply
		// =TransactionService.transactionListToDislpyWithAccountNo(this.transactionList);
		transaction = new Transaction();

	}

	public void dialogTransaction() {
		transaction = new Transaction();
	}


	
	public void updateSalary()
	{
		client.setNetSalary(this.netSalary);
	}	
	
	public void addTransaction() {
		transaction.setFromAccountId(this.account.getId());
		transaction.setTransactionDate(new Date());
		
		if (!isRecieverAccountNumberInDb(transaction.getToAccountId()) || (transaction.getAmount() > account.getAvailableBalance()) ) {
		//	transaction.setToAccountId(-1000L);
			transaction.setStatus("Rejected");
		
		} 
		else {
			transaction.setStatus("Pending");

			if (transaction.getToAccountId() != transaction.getFromAccountId())
				AccountService.handleAccountAvailableBalanceNegative(transaction, account);
			else
				AccountService.handleAccountBalancePositive(transaction, account);

		}

		TransactionService.addTransaction(transaction);
		transactionList.add(transaction);
	}

	private boolean isRecieverAccountNumberInDb(Long recieverId) {
		if (AccountService.isRecieverAccountNumberInDb(recieverId))
			return true;

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN,
						"transaction rejected, please enter a valid reciever account number",
						"Please enter correct username and Password"));

		return false;
	}
	public void generateReport() throws ClassNotFoundException, SQLException, JRException {

		System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRequestLocale());
		//if(FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		String sourceFileName = "C:/Users/mamohamed/report9.jrxml";
		String outFileName = "D:/all training/"+client.getUserName()+"transactions.pdf";
		//String outFileName = "D:/all training/transactions.pdf";
		JasperDesign jasDesign = JRXmlLoader.load(sourceFileName);
		Map parameters = new HashMap();
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(transactionList);
		parameters.put("clientName", client.getName());
		JasperReport jr = JasperCompileManager.compileReport(jasDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jr, parameters, beanColDataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, outFileName);
		//*/
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
	 * public ArrayList<Transaction> getTransactionListToDisply() { return
	 * transactionListToDisply; }
	 * 
	 * 
	 * public void setTransactionListToDisply(ArrayList<Transaction>
	 * transactionListToDisply) { this.transactionListToDisply =
	 * transactionListToDisply; }
	 */
/*
	public void generateReport() throws ClassNotFoundException, SQLException, JRException {

		String sourceFileName = "C:\\Users\\mamohamed\\report7.jrxml";
		String outFileName = "D:\\all training\\report1.pdf";
		JasperDesign jasDesign = JRXmlLoader.load(sourceFileName);
		Map parameters = new HashMap();

		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(transactionList);
		parameters.put("transactionDataSource", beanColDataSource);
		parameters.put("clientName", client.getName());
		JasperReport jr = JasperCompileManager.compileReport(jasDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jr, parameters, new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(jasperPrint, outFileName);
	}
*/
		public Transaction getTransaction() {
		return transaction;
		
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
