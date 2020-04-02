package n3na3a.service;
import java.io.Serializable;

import zglola.db.Client;
import instead.of.db.ClientDB;


@SuppressWarnings("serial")
public class ClientService implements Serializable{

	
	
	
	
	public static void insertClient(Client client) {
		
		ClientDB.getClientList().add(client);
	}
	
	public static Client getClientByEmailAndPassword(String mail,String pass)
	{
		
		
		
		for(Client c: ClientDB.getClientList())
		{
			if(c.getMail().toLowerCase().equals(mail.toLowerCase()) && c.getPassword().equals(pass) ) 	return c;
		}
		return null;
	}
	
	public static void updateClient() {
		
	}
	
}
