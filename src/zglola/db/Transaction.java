package zglola.db;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Transaction implements Serializable {
	private Long id;
	private Date transactionDate;
	private String description;
	private String status;
	private Long fromAccountId;
	private Long toAccountId;
	private Long bankEmployeeId;
	private Long amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(Long fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public Long getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(Long toAccountId) {
		this.toAccountId = toAccountId;
	}

	public Long getBankEmployeeId() {
		return bankEmployeeId;
	}

	public void setBankEmployeeId(Long bankEmployeeId) {
		this.bankEmployeeId = bankEmployeeId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
}
