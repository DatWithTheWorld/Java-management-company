package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JButton;
import Connection.dbcontroller;

public class LostPassword extends JPanel {
 
    dbcontroller con = new dbcontroller();	
	private JTextField tfidlostpass;
	private JTextField tfusernamelostpass;
	private JTextField tfnewpass;
	private JTextField tfconfirmpass;
	private JTextField tfcapcha;
	private JButton btnOut;
public JButton getBtnOut() {
		return btnOut;
	}
	public void setBtnOut(JButton btnOut) {
		this.btnOut = btnOut;
	}
private JButton btnSubmitLosPoss;
private JLabel lbcapcharandom;
private JTextField tfaddresslostpass;
	public JLabel getLbcapcharandom() {
	return lbcapcharandom;
}
public void setLbcapcharandom(JLabel lbcapcharandom) {
	this.lbcapcharandom = lbcapcharandom;
}
	public JButton getBtnSubmitLosPoss() {
	return btnSubmitLosPoss;
}
public void setBtnSubmitLosPoss(JButton btnSubmitLosPoss) {
	this.btnSubmitLosPoss = btnSubmitLosPoss;
}
	public LostPassword() {
		
	
		setBackground(new Color(255, 204, 204));
		setBorder(new EmptyBorder(5, 5, 5, 5));
setLayout(null);
	
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(396, 5, 84, 48);
		add(lblNewLabel);
		
		tfidlostpass = new JTextField();
		tfidlostpass.setBounds(600, 15, 310, 37);
		add(tfidlostpass);
		tfidlostpass.setColumns(10);
		
		JLabel lblUsername = new JLabel("User name");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblUsername.setBounds(396, 63, 165, 69);
		add(lblUsername);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewPassword.setBounds(386, 193, 165, 57);
		add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblConfirmPassword.setBounds(386, 248, 193, 57);
		add(lblConfirmPassword);
	
		JLabel lblCapcha = new JLabel("Capcha");
		lblCapcha.setHorizontalAlignment(SwingConstants.CENTER);
		lblCapcha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblCapcha.setBounds(369, 377, 193, 69);
		add(lblCapcha);
		Random nrd = new Random();
		int nbnrd = nrd.nextInt((99999-11111)+1)+11111;
		
		JButton btnClearLostPass = new JButton("Clear");
		btnClearLostPass.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnClearLostPass.setBounds(485, 465, 165, 51);
		add(btnClearLostPass);
		
		 btnSubmitLosPoss = new JButton("Submit");
		btnSubmitLosPoss.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnSubmitLosPoss.setBounds(670, 465, 165, 51);
		add(btnSubmitLosPoss);
		
		tfusernamelostpass = new JTextField();
		tfusernamelostpass.setColumns(10);
		tfusernamelostpass.setBounds(600, 72, 310, 37);
		add(tfusernamelostpass);
		
		tfnewpass = new JTextField();
		tfnewpass.setColumns(10);
		tfnewpass.setBounds(600, 200, 310, 37);
		add(tfnewpass);
		
		tfconfirmpass = new JTextField();
		tfconfirmpass.setColumns(10);
		tfconfirmpass.setBounds(600, 262, 310, 37);
		add(tfconfirmpass);
		
		tfcapcha = new JTextField();
		
		tfcapcha.setColumns(10);
		tfcapcha.setBounds(600, 393, 310, 37);
		add(tfcapcha);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setHorizontalAlignment(SwingConstants.LEFT);
		lbladdress.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lbladdress.setBounds(396, 125, 165, 69);
		add(lbladdress);
		
		tfaddresslostpass = new JTextField();
		tfaddresslostpass.setColumns(10);
		tfaddresslostpass.setBounds(600, 134, 310, 37);
		add(tfaddresslostpass);
		
		JPanel panel = new JPanel();
		panel.setBounds(652, 309, 175, 75);
		add(panel);
		panel.setLayout(null);
		
		lbcapcharandom = new JLabel("");
		lbcapcharandom.setBounds(10, 10, 155, 57);
		panel.add(lbcapcharandom);
		lbcapcharandom.setBackground(new Color(0, 255, 128));
		lbcapcharandom.setFont(new Font("Vladimir Script", Font.PLAIN, 24));
		lbcapcharandom.setText(""+nbnrd);
		
		lbcapcharandom.setHorizontalAlignment(SwingConstants.CENTER);
		
	    btnOut = new JButton("OUT");
		btnOut.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnOut.setBounds(846, 465, 165, 51);
		add(btnOut);
		btnOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Random nrd = new Random();
				int nbnrd = nrd.nextInt((99999-11111)+1)+11111;
				lbcapcharandom.setText(""+nbnrd);
				tfidlostpass.setText("");
				tfaddresslostpass.setText("");
				tfcapcha.setText("");
				tfconfirmpass.setText("");
				tfnewpass.setText("");
			}
		});
		btnSubmitLosPoss.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(lblCapcha.getText());
				if(tfnewpass.getText().equals(tfconfirmpass.getText())) {
					if(tfcapcha.getText().equals(lbcapcharandom.getText())) {
					con.changepassword(tfidlostpass.getText(), tfconfirmpass.getText(), tfusernamelostpass.getText());	
					}
				}
				
				
			}
		});
	}
}
