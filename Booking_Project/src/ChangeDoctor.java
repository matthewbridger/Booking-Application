import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Dialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeDoctor extends JFrame {

	private JPanel contentPane;

	
	public ChangeDoctor(Patient patient) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel changeDocLabel = new JLabel("Change Doctor");
		changeDocLabel.setBounds(196, 65, 112, 16);
		contentPane.add(changeDocLabel);
		
		String[] choices = {"DR.Smith", "DR.Johnson", "DR.Brown", "DR.Jones"};
		JComboBox doctorList = new JComboBox(choices);
		doctorList.setBounds(126, 97, 243, 27);
		contentPane.add(doctorList);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(184, 149, 117, 29);
		contentPane.add(submitButton);
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s=String.valueOf(doctorList.getSelectedItem());
            	DBManager manager = new DBManager();
				patient.setDoctorName(s);
				boolean resultData = manager.ChangeCurrentDoctor(patient);
			if (resultData) {
				System.out.println("successfully");
			}
				InformationPage info = new InformationPage(patient);
				info.setComplete('e');
                    info.setVisible(true);
					
			}
		});
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				InformationPage info = new InformationPage(patient);
            	info.setVisible(true);
				
			}
		});
		backButton.setBounds(184, 204, 117, 29);
		contentPane.add(backButton);
	}

}
