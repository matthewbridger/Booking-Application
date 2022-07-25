import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField userNameText;
	private JTextField passwordText;


	
	public Register() {
		// Set up the register login panel.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Labels that instruct the patient.
		JLabel registerLabel = new JLabel("Register new patient");
		registerLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		registerLabel.setBounds(189, 24, 172, 25);
		contentPane.add(registerLabel);
		
		JLabel userName = new JLabel("Enter Username");
		userName.setBounds(78, 100, 100, 16);
		contentPane.add(userName);
		
		JLabel passwordLabel = new JLabel("Enter Password");
		passwordLabel.setBounds(78, 150, 100, 16);
		contentPane.add(passwordLabel);
		
		JLabel complete = new JLabel("");
		complete.setBounds(78, 256, 272, 47);
		complete.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(complete);
		
		userNameText = new JTextField();
		userNameText.setBounds(231, 100, 130, 26);
		contentPane.add(userNameText);
		userNameText.setColumns(10);
		// Drop down bar using JComboBox that takes an Array of String. The string contains the doctors name.
		String[] choices = {"DR.Smith", "DR.Johnson", "DR.Brown", "DR.Jones"};
		JComboBox doctorList = new JComboBox(choices);
		doctorList.setBounds(231, 250, 150, 27);
		contentPane.add(doctorList);
		
		JLabel doctorLabel = new JLabel("Choose Doctor");
		doctorLabel.setBounds(78, 250, 100, 16);
		contentPane.add(doctorLabel);
		
		passwordText = new JTextField();
		passwordText.setBounds(231, 150, 130, 26);
		contentPane.add(passwordText);
		passwordText.setColumns(10);
		
		JLabel UnqueIDLabel = new JLabel("Here your unque ID");
		UnqueIDLabel.setBounds(78, 200, 150, 16);
		contentPane.add(UnqueIDLabel);
		// Creates a UniqueID object that runs the method. 
		JLabel UnqueID = new JLabel("");
		UnqueID.setBounds(231, 200, 130, 16);
		UniqueId id = new UniqueId();
		id.run();
		// Retrieve the ID from the class using the getter method.
		String result = id.getUniqueID();
		// Sets the label displaying the ID number.
		UnqueID.setText(result);
		contentPane.add(UnqueID);
		
		JButton enterButton = new JButton("Enter ");
		enterButton.setBounds(231, 326, 117, 29);
		contentPane.add(enterButton);
		enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String s=String.valueOf(doctorList.getSelectedItem());
            	DBManager database = new DBManager();
            	// Validation that the patient has entered information above 0 letters long.
            	if(userNameText.getText().length() > 0 && passwordText.getText().length() > 0) {
            		complete.setText("error");
            	} else {
            		// Setting the userNameText and passwordText field in the Patient class. Then sending it to the database. 
            		Patient patient = new Patient(userNameText.getText(), passwordText.getText(), result, s);
            		database.registerUser(patient);
            		complete.setText("Register Completed");
            		// Change to the InformationPage panel.
            		patient.setIsLoggedInd(true);
               	    contentPane.setVisible(false);
                    InformationPage info = new InformationPage(patient);
                    info.setComplete('f');
                    info.setVisible(true);
            	}
 
            }
        });
		
		
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
            	Login log = new Login();
            	log.setVisible(true);
			}
		});
		backButton.setBounds(78, 326, 117, 29);
		contentPane.add(backButton);
		
	
			
		}
	
	 
}


