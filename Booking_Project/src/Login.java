import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userText, UniqueID;
	private JPasswordField passwordText;



	public Login() {
		// Setting up the panel layout.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(189, 351, 117, 29);
		contentPane.add(registerButton);
		// ActionListener to switch to the register class panel.
		registerButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	contentPane.setVisible(false);
	            	Register ref = new Register();
	            	ref.setVisible(true);
	            	
	            }
	        });
		// Create text field for the patient to enter their login details.
		userText = new JTextField();
		userText.setBounds(189, 119, 130, 26);
		contentPane.add(userText);
		userText.setColumns(10);
		
		// Create text field for the patient to enter their Unique ID.
		UniqueID = new JTextField();
		UniqueID.setBounds(189, 230, 130, 26);
		contentPane.add(UniqueID);
		UniqueID.setColumns(10);
		
		JLabel UniqueIDL = new JLabel("Your Unique ID");
		UniqueIDL.setBounds(64, 234, 150, 16);
		contentPane.add(UniqueIDL);
		
		// Label that gives the patient an indication if they have entered the wrong details.
		JLabel failLogIn = new JLabel("");
		failLogIn.setBounds(200, 400, 117, 29);
		contentPane.add(failLogIn);

		// A button that allows the patient to log in. The actionListener is set on the button, when pressed it changes to the InformationPage.
		JButton loginButton = new JButton("LogIn");
		loginButton.setBounds(189, 300, 117, 29);
		contentPane.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Sends the Patient information to the Patient Class then to the database to check if it exists. 
            	Patient patient = new Patient(userText.getText(), passwordText.getText(), UniqueID.getText());
            	DBManager manager = new DBManager();
            	// Gets the result from the database.
            	String resultData = manager.checkLogin(patient);
            	// If it is greater then 0 then it goes to the Information page.
            	if(resultData.length() > 0) {
            		// Turn the panel visible to false
            	 patient.setIsLoggedInd(true);
            	 contentPane.setVisible(false);
                 InformationPage info = new InformationPage(patient);
                 info.setVisible(true);
            	} else {
            		// Sets the failLogIn text field.
            		failLogIn.setText("Log in failed");
            	}
            	}
        });
		// Patient log in labels.
		JLabel usernNameLabel = new JLabel("UserName");
		usernNameLabel.setBounds(64, 124, 64, 16);
		contentPane.add(usernNameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(64, 181, 61, 16);
		contentPane.add(passwordLabel);
		
		JLabel loginTitle = new JLabel("Login Interface");
		loginTitle.setBounds(189, 42, 107, 16);
		contentPane.add(loginTitle);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(189, 176, 130, 26);
		contentPane.add(passwordText);
		
		JLabel checkLabel = new JLabel("");
		checkLabel.setBounds(128, 399, 242, 44);
		contentPane.add(checkLabel);
		
		
		
		
	}
}
