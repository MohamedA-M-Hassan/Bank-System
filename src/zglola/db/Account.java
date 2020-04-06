package zglola.db;

import java.io.Serializable;

public class Account implements Serializable {
	private Long id;
	private Long balance;
	private Long availableBalance;
	private Long clientId;
	private Long accountNumber;

	public Account() {}
	public Account(Long id, Long balance, Long availableBalance, Long clientId,Long accountNo) {
		this.id = id;
		this.balance = balance;
		this.availableBalance = availableBalance;
		this.clientId = clientId;
		this.accountNumber =accountNo;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
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
	
	public Long getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(Long availableBalance) {
		this.availableBalance = availableBalance;
	}

}
