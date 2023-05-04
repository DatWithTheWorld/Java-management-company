package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class framedisparch extends JFrame {

	private JPanel contentPane;
    private JLabel lbpay;
	
    
	public JLabel getLbpay() {
		return lbpay;
	}


	public void setLbpay(JLabel lbpay) {
		this.lbpay = lbpay;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					framedisparch frame = new framedisparch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public framedisparch() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 300, 609, 396);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(framedisparch.class.getResource("/img1/pr.jpg")));
		lblNewLabel.setBounds(187, 73, 209, 215);
		contentPane.add(lblNewLabel);
		
		
	
		JLabel lblNewLabel_1 = new JLabel("Hover this QR Code to pay for services");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(145, 10, 347, 53);
		contentPane.add(lblNewLabel_1);
		
		lbpay = new JLabel("");
		lbpay.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbpay.setHorizontalAlignment(SwingConstants.CENTER);
		lbpay.setBounds(197, 296, 188, 32);
		contentPane.add(lbpay);
		lblNewLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				lbpay.setText("SUCCESSED");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
	}
}
