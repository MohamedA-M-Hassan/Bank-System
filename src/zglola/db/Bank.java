package zglola.db;

import java.io.Serializable;

public class Bank implements Serializable{
	private Long id;
	private String branchAddress;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
