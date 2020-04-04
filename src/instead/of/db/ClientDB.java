package instead.of.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import zglola.db.Client;

@SuppressWarnings("serial")
public class ClientDB implements Serializable {

	private static ArrayList<Client> clientList = new ArrayList<Client>();

	public ClientDB() {
	}

	public static ArrayList<Client> getClientList() {

		if (clientList.size() < 3) {

			clientList.add(new Client(0L, "Mohamed", "mo", "123@S", "01144181789", new Date(), "mohamed@mail.com", "nasr city", 1000L, 1L));
			clientList.add(new Client(new Long(1), "Sral", "sral", "123456A#", "0123456798", new Date(), "siko@mail.com", "bait elwatan", new Long(999), new Long(1)));
			clientList.add(new Client(new Long(2), "Shaf", "anosh", "987@H", "0129746543", new Date(), "sombol@mail.com", "Giza", new Long(900), new Long(1)));

		}
		return clientList;
	}
}
