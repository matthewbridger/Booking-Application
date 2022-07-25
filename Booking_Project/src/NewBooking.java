import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SpinnerModel;

public class NewBooking extends JFrame {

	private JPanel contentPane;
	private JButton backButton;
	

	
	public NewBooking(Patient patient) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel dataLabel = new JLabel("Date");
		dataLabel.setBounds(120, 140, 61, 16);
		contentPane.add(dataLabel);
		
		JLabel timeLabel = new JLabel("Time");
		timeLabel.setBounds(120, 200, 61, 16);
		contentPane.add(timeLabel);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setBounds(189, 240, 117, 29);
		contentPane.add(enterButton);
		
		backButton = new JButton("Back");
		backButton.setBounds(189, 292, 117, 29);
		contentPane.add(backButton);
		backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {	
            	contentPane.setVisible(false);
            	InformationPage info = new InformationPage(patient);
            	info.setVisible(true);
            	
            		
            	}
            
        });
		
		
		JSpinner spinnerDate = new JSpinner( new SpinnerDateModel());
		JSpinner.DateEditor edit = new JSpinner.DateEditor(spinnerDate, "dd/MM/yyyy");
		spinnerDate.setEditor(edit);
		spinnerDate.setBounds(189, 135, 141, 21);
		contentPane.add(spinnerDate);
		
		JSpinner spinnerTime = new JSpinner( new SpinnerDateModel());
		JSpinner.DateEditor editTime = new JSpinner.DateEditor(spinnerTime, "hh:mm");
		spinnerTime.setEditor(editTime);
		spinnerTime.setBounds(189, 195, 141, 21);
		contentPane.add(spinnerTime);
		
		
		
		
		
		
		
		
		
		
		

	
		
		
		
	}
}
