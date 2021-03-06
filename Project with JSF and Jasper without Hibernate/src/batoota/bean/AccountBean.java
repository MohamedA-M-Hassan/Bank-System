package batoota.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
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
	private LocaleBean locale;

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
		this.locale = new LocaleBean();

	}

	public void dialogTransaction() {
		transaction = new Transaction();
	}

	public void dialogSalary() {
		this.netSalary = this.client.getNetSalary();
	}

	public void updateSalary() {
		client.setNetSalary(this.netSalary);
		System.out.println(
				"hello from the other side, we are going to test this function to make sure that we are fail in this stage");
	}

	public void addTransaction() {
		if (transaction.getToAccountId() == null || transaction.getAmount() == null) {
			// don't do anything
		} else {
			transaction.setFromAccountId(this.account.getId());
			transaction.setTransactionDate(new Date());
			// if (the reciever not in DB) or if he sends to others and has no charge:
			// reject
			if (!isRecieverAccountNumberInDb(transaction.getToAccountId())
					|| (transaction.getAmount() > account.getAvailableBalance()
							&& (!transaction.getToAccountId().equals(transaction.getFromAccountId())))) {
				// transaction.setToAccountId(-1000L);
				transaction.setStatus("Rejected");

			} else {
				transaction.setStatus("Pending");

				if (transaction.getToAccountId() != transaction.getFromAccountId())
					AccountService.handleAccountAvailableBalanceNegative(transaction, account);
				else
					AccountService.handleAccountBalancePositive(transaction, account);
			}
			TransactionService.addTransaction(transaction);
			transactionList.add(transaction);
		}
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

	public void generateReport2() throws ClassNotFoundException, SQLException, JRException, IOException {

		String sourceFileName;
		if (locale.getLanguage() == "en") {
			sourceFileName = "C:/Users/mamohamed/report9.jrxml";
		} else {
			sourceFileName = "C:/Users/mamohamed/report10.jrxml";
		}
		// String outFileName = "D:/all training/" + client.getUserName() +
		// "transactions.pdf";
		// String outFileName = "D:/all training/transactions.pdf";
		JasperDesign jasDesign = JRXmlLoader.load(sourceFileName);
		Map parameters = new HashMap();
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(transactionList);
		parameters.put("clientName", client.getName());
		JasperReport jr = JasperCompileManager.compileReport(jasDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jr, parameters, beanColDataSource);
		// JasperExportManager.exportReportToPdfFile(jasperPrint, outFileName);

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse resp = (HttpServletResponse) context.getExternalContext().getResponse();
		resp.setContentType("application/x-pdf");
		resp.setHeader("Content-disposition", "inline; filename=testReport.pdf");
		final ServletOutputStream outStream = resp.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		///////////

	}

	public void generateReport() throws ClassNotFoundException, SQLException, JRException, IOException {

		String sourceFileName;
		if (locale.getLanguage() == "en") {
			sourceFileName = "C:/Users/mamohamed/report9.jrxml";
		} else {
			sourceFileName = "C:/Users/mamohamed/report10.jrxml";
		}

		JasperDesign jasDesign = JRXmlLoader.load(sourceFileName);
		Map parameters = new HashMap();
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(transactionList);
		parameters.put("clientName", client.getName());
		JasperReport jr = JasperCompileManager.compileReport(jasDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jr, parameters, beanColDataSource);
		// if ()

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse resp = (HttpServletResponse) context.getExternalContext().getResponse();
		resp.setContentType("application/x-pdf");
		resp.setHeader("Content-disposition", "inline; filename=testReport.pdf");
		final ServletOutputStream outStream = resp.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

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

	public LocaleBean getLocale() {
		return locale;
	}

	public void setLocale(LocaleBean locale) {
		this.locale = locale;
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
	 * public void generateReport() throws ClassNotFoundException, SQLException,
	 * JRException {
	 * 
	 * String sourceFileName = "C:\\Users\\mamohamed\\report7.jrxml"; String
	 * outFileName = "D:\\all training\\report1.pdf"; JasperDesign jasDesign =
	 * JRXmlLoader.load(sourceFileName); Map parameters = new HashMap();
	 * 
	 * JRBeanCollectionDataSource beanColDataSource = new
	 * JRBeanCollectionDataSource(transactionList);
	 * parameters.put("transactionDataSource", beanColDataSource);
	 * parameters.put("clientName", client.getName()); JasperReport jr =
	 * JasperCompileManager.compileReport(jasDesign); JasperPrint jasperPrint =
	 * JasperFillManager.fillReport(jr, parameters, new JREmptyDataSource());
	 * JasperExportManager.exportReportToPdfFile(jasperPrint, outFileName); }
	 */
	public Transaction getTransaction() {
		return transaction;

	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
