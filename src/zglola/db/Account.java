package zglola.db;

import java.io.Serializable;

public class Account implements Serializable {
	private Long id;
	private Long amount;
	private Long clientId;
	
	public Account(Long id, Long amount, Long clientId) {
		this.clientId = id;
		this.amount = amount;
		this.clientId = clientId;
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
}
