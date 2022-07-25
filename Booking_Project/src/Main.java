

// Software developing module 
// Name - mab93
// This is the main and it will create the login page.
public class Main {

	public static void main(String[] args) {
		
		DBManager man = new DBManager();
		man.testConnection();
		
		Login l = new Login();
		l.setVisible(true);
	}

}
