package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class viewjs extends JFrame {

	private JPanel contentPane;
	private JTextField tffullname;
	private JTextField tfaddress;
	private JTextField tfage;
	private JTextField tfposition;
	private JTextField tfgender;
	private JTextField tfusername;
	private JTextField tfpassword;

	public JTextField getTffullname() {
		return tffullname;
	}

	public void setTffullname(JTextField tffullname) {
		this.tffullname = tffullname;
	}

	public JTextField getTfaddress() {
		return tfaddress;
	}

	public void setTfaddress(JTextField tfaddress) {
		this.tfaddress = tfaddress;
	}

	public JTextField getTfage() {
		return tfage;
	}

	public void setTfage(JTextField tfage) {
		this.tfage = tfage;
	}

	public JTextField getTfposition() {
		return tfposition;
	}

	public void setTfposition(JTextField tfposition) {
		this.tfposition = tfposition;
	}

	public JTextField getTfgender() {
		return tfgender;
	}

	public void setTfgender(JTextField tfgender) {
		this.tfgender = tfgender;
	}

	public JTextField getTfusername() {
		return tfusername;
	}

	public void setTfusername(JTextField tfusername) {
		this.tfusername = tfusername;
	}

	public JTextField getTfpassword() {
		return tfpassword;
	}

	public void setTfpassword(JTextField tfpassword) {
		this.tfpassword = tfpassword;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewjs frame = new viewjs();
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
	public viewjs() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 755, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FullName");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(21, 71, 114, 44);
		contentPane.add(lblNewLabel);
		
		tffullname = new JTextField();
		tffullname.setBounds(151, 71, 330, 44);
		contentPane.add(tffullname);
		tffullname.setColumns(10);
		
		JLabel Address = new JLabel("Address");
		Address.setHorizontalAlignment(SwingConstants.RIGHT);
		Address.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Address.setBounds(21, 139, 114, 44);
		contentPane.add(Address);
		
		tfaddress = new JTextField();
		tfaddress.setColumns(10);
		tfaddress.setBounds(151, 139, 330, 44);
		contentPane.add(tfaddress);
		
		JLabel Age = new JLabel("Age");
		Age.setHorizontalAlignment(SwingConstants.RIGHT);
		Age.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Age.setBounds(21, 213, 114, 44);
		contentPane.add(Age);
		
		tfage = new JTextField();
		tfage.setColumns(10);
		tfage.setBounds(151, 213, 330, 44);
		contentPane.add(tfage);
		
		JLabel lblNewLabel_1_2 = new JLabel("Position");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(21, 288, 114, 44);
		contentPane.add(lblNewLabel_1_2);
		
		tfposition = new JTextField();
		tfposition.setColumns(10);
		tfposition.setBounds(151, 288, 330, 44);
		contentPane.add(tfposition);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gender");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(21, 362, 114, 44);
		contentPane.add(lblNewLabel_1_3);
		
		tfgender = new JTextField();
		tfgender.setColumns(10);
		tfgender.setBounds(151, 362, 330, 44);
		contentPane.add(tfgender);
		
		JLabel lblNewLabel_1_4 = new JLabel("UserName");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(21, 435, 114, 44);
		contentPane.add(lblNewLabel_1_4);
		
		tfusername = new JTextField();
		tfusername.setColumns(10);
		tfusername.setBounds(151, 435, 330, 44);
		contentPane.add(tfusername);
		
		JLabel lblNewLabel_1_5 = new JLabel("Password");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_5.setBounds(21, 508, 114, 44);
		contentPane.add(lblNewLabel_1_5);
		
		tfpassword = new JTextField();
		tfpassword.setColumns(10);
		tfpassword.setBounds(151, 508, 330, 44);
		contentPane.add(tfpassword);
	}
}
