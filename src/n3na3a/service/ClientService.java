package n3na3a.service;
import java.io.Serializable;

import zglola.db.Client;
import instead.of.db.ClientDB;


@SuppressWarnings("serial")
public class ClientService implements Serializable{

	public static void insertClient(Client client) {
		
		ClientDB.getClientList().add(client);
	}
	
	public static Client getClientByUsernameAndPassword(String username,String pass)
	{
		for(Client c: ClientDB.getClientList())
		{
			if(c.getUserName().toLowerCase().equals(username.toLowerCase()) && c.getPassword().equals(pass) ) 	return c;
		}
		return null;
	}
	
	public static Long getNoOfClientsInDbToHandleID(){
		return (long) ClientDB.getClientList().size();
	}
	
	public static void updateClient() {
		
	}
	
}
