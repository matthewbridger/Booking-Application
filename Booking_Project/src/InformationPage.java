
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class InformationPage extends JFrame {

	private JPanel contentPane;
	private char flag = 'r';
	JLabel complete = new JLabel("");
	public InformationPage(Patient patient) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 43, 416, 224);
		contentPane.add(scrollPane);
		
		JButton viewBooking = new JButton("View Booking");
		viewBooking.setBounds(38, 300, 130, 29);
		contentPane.add(viewBooking);
		viewBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
            	contentPane.setVisible(false);
            	ViewBooking info = new ViewBooking(patient); // sent patient to ViewBooking
            	info.setVisible(true); 
            	}
            
        });
		
		JButton changeDoc = new JButton("Change Doctor");
		changeDoc.setBounds(38, 350, 130, 29);
		contentPane.add(changeDoc);
		changeDoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	contentPane.setVisible(false);
            	ChangeDoctor info = new ChangeDoctor(patient);// sent patient to ChangeDoctor
            	info.setVisible(true);
            	
       
            	}
            
        });
		
		
		JButton newBooking = new JButton("New Booking");
		newBooking.setBounds(38, 400, 130, 29);
		contentPane.add(newBooking);
		newBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	contentPane.setVisible(false);
            	NewBooking info = new NewBooking(patient);// sent patient to ChangeDoctor
            	info.setVisible(true);
            	}
            
        });
		
		JButton logOut= new JButton("Log Out");
		logOut.setBounds(300, 400, 130, 29);
		contentPane.add(logOut);
		logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	contentPane.setVisible(false);
            	Login info = new Login();// sent patient to ChangeDoctor
            	info.setVisible(true);
            	}
            
        });
		
		
		
		JLabel details = new JLabel("Details");
		details.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		details.setBounds(206, 6, 78, 16);
		details.setText(patient.getUserId());
		contentPane.add(details);
		
		
		complete.setBounds(150, 256, 272, 47);
		complete.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(complete);

	}
	public void setComplete(char s) {
		char flag = s;
		if(flag == 'e') {
			complete.setText("Change doctor Complete");
		} else if(flag == 'f') {
			complete.setText("Register Complete");
		}
	}
}
