package zglola.db;

import java.io.Serializable;

public class Account implements Serializable {
	private Long id;
	private Long amount;
	private Long clientId;
	private Long accountNumber;
	public Account() {}
	public Account(Long id, Long amount, Long clientId,Long accountNo) {
		this.clientId = id;
		this.amount = amount;
		this.clientId = clientId;
		this.setAccountNumber(accountNo);
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}


	public Long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
}
