import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ViewBooking extends JFrame {

	private JPanel contentPane;

	
	public ViewBooking(Patient patient) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel viewBookingLabel = new JLabel("View Booking");
		viewBookingLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		viewBookingLabel.setBounds(195, 6, 126, 25);
		contentPane.add(viewBookingLabel);
		
		JLabel optionsLabel = new JLabel("Search Appointment ");
		optionsLabel.setBounds(55, 299, 142, 25);
		contentPane.add(optionsLabel);
		contentPane.setVisible(true);
			
		
    	
	
		
		String[] choices = {"2021-03-12", "2021-04-12", "2021-05-06", "2021-05-07"};
		JComboBox List = new JComboBox(choices);
		List.setBounds(195, 299, 150, 27);
		contentPane.add(List);
		
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(38, 43, 416, 224);
		contentPane.add(scrollPane);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setBounds(38, 351, 117, 29);
		contentPane.add(enterButton);
		enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String s=String.valueOf(List.getSelectedItem());
            	DBManager database = new DBManager();
            	String result = (String) database.checkBooking(s);
            	
            	
        		textArea.setText(result);
        		
            	}
            
        });
		
		
		
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(337, 351, 117, 29);
		contentPane.add(backButton);
		backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	contentPane.setVisible(false);
            	InformationPage info = new InformationPage(patient);
            	info.setVisible(true);
            	
            		
            	}
            
        });
	}

}

