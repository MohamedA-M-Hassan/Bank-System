package instead.of.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import zglola.db.Client;

public class ClientDB implements Serializable {

	private static ArrayList<Client> clientList = new ArrayList<Client>();

	@SuppressWarnings("deprecation")
	public ClientDB() {
		clientList.add(new Client(new Long(1), "Mohamed", "mo", "123@S", "01144181789", new Date("1-4-1950"), "mohamed@mail.com", "nasr city", new Long(1000), new Long(1)));
		clientList.add(new Client(new Long(2), "Sral", "sral", "123456A#", "0123456798", new Date("2-4-1964"), "siko@mail.com", "bait elwatan", new Long(999), new Long(1)));
		clientList.add(new Client(new Long(3), "Shaf", "anosh", "987@H", "0129746543", new Date("1-4-1980"), "sombol@mail.com", "Giza", new Long(900), new Long(1)));
	}

	public static ArrayList<Client> getClientList() {
		return clientList;
	}

	public void setClientList(ArrayList<Client> clientList) {
		this.clientList = clientList;
	}

}
