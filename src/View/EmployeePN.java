package View;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.awt.CardLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.dbcontroller;

import javax.swing.JTextArea;

public class EmployeePN extends JPanel {
     private JMenuItem mntmLogOut;
     dbcontroller con = new dbcontroller();
     private File fi ;
     private JPopupMenu popupMenu;
     private DefaultTableModel dtmall;
     private DefaultTableModel dtmstar;
     private DefaultTableModel dtmbin;
     private DefaultTableModel dtm;
     private JLabel lbavataraccount;
     private ImageIcon icoc ;
     private JTextField tfgenderinaccountpage;
     private JTextField tfaddressinaccountpage;
     private JTextField tfpositioninaccountpage;
     private JTextField tfageinaccountpage;
     private JTextField tffullnameinaccountpage;
     private JTextField tfidinaccountpage;
     private JTextField tfsearchinsalaryemployee;
     private JTextField tfsalaryemployeeyear;
     private JTextField tfsalaryemployeemonth;
     private JTextField tfsalaryemployeesalary;
     private JTable table;
     private JPanel pnaccount;
     private JPanel pncardemployee;
     public JPanel getPncardemployee() {
		return pncardemployee;
	}
	public void setPncardemployee(JPanel pncardemployee) {
		this.pncardemployee = pncardemployee;
	}
	public JPanel getPnaccount() {
		return pnaccount;
	}
	public void setPnaccount(JPanel pnaccount) {
		this.pnaccount = pnaccount;
	}
	private JTextField tfpeersid;
	private JTextField tfusernamemain;
	public JTextField getTfusernamemain() {
		return tfusernamemain;
	}
	public void setTfusernamemain(JTextField tfusernamemain) {
		this.tfusernamemain = tfusernamemain;
	}
	public JTextField getTfpasswordmain() {
		return tfpasswordmain;
	}
	public void setTfpasswordmain(JTextField tfpasswordmain) {
		this.tfpasswordmain = tfpasswordmain;
	}
	private JTextField tfpasswordmain;
	public JMenuItem getMntmLogOut() {
		return mntmLogOut;
	}
	public void setMntmLogOut(JMenuItem mntmLogOut) {
		this.mntmLogOut = mntmLogOut;
	}
	/**
	 * Create the panel.
	 */
	public EmployeePN() {
		setLayout(null);
		//setdata();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(0, 0, 1540, 45);
		add(panel);
		panel.setLayout(null);
		
		JMenuItem mntmaccount = new JMenuItem("ACCOUNT");
		mntmaccount.setIcon(new ImageIcon(EmployeePN.class.getResource("/img1/account.png")));
		mntmaccount.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		mntmaccount.setHorizontalAlignment(SwingConstants.LEFT);
		mntmaccount.setBackground(new Color(240, 248, 255));
		mntmaccount.setBounds(10, 0, 183, 45);
		panel.add(mntmaccount);
		
		JMenuItem mntmSalary = new JMenuItem("SALARY");
		mntmSalary.setIcon(new ImageIcon(EmployeePN.class.getResource("/img1/salary.png")));
		mntmSalary.setHorizontalAlignment(SwingConstants.LEFT);
		mntmSalary.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		mntmSalary.setBackground(new Color(240, 248, 255));
		mntmSalary.setBounds(219, 0, 183, 45);
		panel.add(mntmSalary);
		
		JMenuItem mntmNotifications = new JMenuItem("NOTIFICATIONS");
		mntmNotifications.setIcon(new ImageIcon(EmployeePN.class.getResource("/img1/notification.png")));
		mntmNotifications.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNotifications.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		mntmNotifications.setBackground(new Color(240, 248, 255));
		mntmNotifications.setBounds(446, 0, 233, 45);
		panel.add(mntmNotifications);
		
		JMenuItem mntmRequest = new JMenuItem("REQUEST");
		mntmRequest.setIcon(new ImageIcon(EmployeePN.class.getResource("/img1/request.png")));
		mntmRequest.setHorizontalAlignment(SwingConstants.LEFT);
		mntmRequest.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		mntmRequest.setBackground(new Color(240, 248, 255));
		mntmRequest.setBounds(755, 0, 216, 45);
		panel.add(mntmRequest);
		
	    mntmLogOut = new JMenuItem("LOG OUT");
	    mntmLogOut.setIcon(new ImageIcon(EmployeePN.class.getResource("/img1/log out.png")));
		mntmLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		mntmLogOut.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		mntmLogOut.setBackground(new Color(240, 248, 255));
		mntmLogOut.setBounds(1000, 0, 195, 45);
		panel.add(mntmLogOut);
		
		pncardemployee = new JPanel();
		pncardemployee.setBounds(0, 46, 1540, 799);
		add(pncardemployee);
		pncardemployee.setLayout(new CardLayout(0, 0));
		
		pnaccount = new JPanel();
		pnaccount.setBackground(new Color(248, 248, 255));
		pncardemployee.add(pnaccount, "pnaccount");
		pnaccount.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(224, 255, 255));
		panel_1.setBounds(51, 64, 1432, 673);
		pnaccount.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblGender.setBounds(29, 323, 133, 40);
		panel_1.add(lblGender);
		
		tfgenderinaccountpage = new JTextField();
		tfgenderinaccountpage.setEditable(false);
		tfgenderinaccountpage.setColumns(10);
		tfgenderinaccountpage.setBounds(172, 323, 133, 40);
		panel_1.add(tfgenderinaccountpage);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblAddress.setBounds(29, 262, 133, 40);
		panel_1.add(lblAddress);
		
		tfaddressinaccountpage = new JTextField();
		tfaddressinaccountpage.setEditable(false);
		tfaddressinaccountpage.setColumns(10);
		tfaddressinaccountpage.setBounds(172, 262, 475, 40);
		panel_1.add(tfaddressinaccountpage);
		
		tfpositioninaccountpage = new JTextField();
		tfpositioninaccountpage.setEditable(false);
		tfpositioninaccountpage.setColumns(10);
		tfpositioninaccountpage.setBounds(172, 199, 475, 40);
		panel_1.add(tfpositioninaccountpage);
		
		JLabel lblPhone = new JLabel("POSITION");
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblPhone.setBounds(29, 199, 133, 40);
		panel_1.add(lblPhone);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setHorizontalAlignment(SwingConstants.LEFT);
		lblAge.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblAge.setBounds(29, 136, 133, 40);
		panel_1.add(lblAge);
		
		tfageinaccountpage = new JTextField();
		tfageinaccountpage.setEditable(false);
		tfageinaccountpage.setColumns(10);
		tfageinaccountpage.setBounds(172, 136, 475, 40);
		panel_1.add(tfageinaccountpage);
		
		JLabel lblFullName = new JLabel("FULL NAME");
		lblFullName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFullName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblFullName.setBounds(29, 73, 133, 40);
		panel_1.add(lblFullName);
		
		tffullnameinaccountpage = new JTextField();
		tffullnameinaccountpage.setEditable(false);
		tffullnameinaccountpage.setColumns(10);
		tffullnameinaccountpage.setBounds(172, 73, 475, 40);
		panel_1.add(tffullnameinaccountpage);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(29, 10, 133, 40);
		panel_1.add(lblNewLabel);
		
		tfidinaccountpage = new JTextField();
		tfidinaccountpage.setEditable(false);
		tfidinaccountpage.setColumns(10);
		tfidinaccountpage.setBounds(172, 10, 475, 40);
		panel_1.add(tfidinaccountpage);
		
		JButton btnEdit = new JButton("");
		btnEdit.setIcon(new ImageIcon(EmployeePN.class.getResource("/img1/edit.png")));
		btnEdit.setBounds(983, 500, 84, 47);
		panel_1.add(btnEdit);
		
		JButton btnSave = new JButton("");
		btnSave.setIcon(new ImageIcon(EmployeePN.class.getResource("/img1/sv1.png")));
		btnSave.setEnabled(false);
		btnSave.setBounds(1106, 500, 84, 47);
		panel_1.add(btnSave);
		
		JButton btnOpen = new JButton("");
		btnOpen.setIcon(new ImageIcon(EmployeePN.class.getResource("/img1/open.png")));
		btnOpen.setEnabled(false);
		btnOpen.setBounds(1044, 440, 91, 47);
		panel_1.add(btnOpen);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 255, 204));
		panel_4.setBounds(921, 98, 323, 326);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		lbavataraccount = new JLabel("");
		lbavataraccount.setHorizontalAlignment(SwingConstants.CENTER);
		lbavataraccount.setBounds(0, 0, 323, 326);
		panel_4.add(lbavataraccount);
		lbavataraccount.setBackground(new Color(248, 248, 255));
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblUsername.setBounds(29, 384, 133, 40);
		panel_1.add(lblUsername);
		
		tfusernamemain = new JTextField();
		tfusernamemain.setEditable(false);
		tfusernamemain.setColumns(10);
		tfusernamemain.setBounds(172, 384, 475, 40);
		panel_1.add(tfusernamemain);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblPassword.setBounds(29, 447, 133, 40);
		panel_1.add(lblPassword);
		
		tfpasswordmain = new JTextField();
		tfpasswordmain.setEditable(false);
		tfpasswordmain.setColumns(10);
		tfpasswordmain.setBounds(172, 447, 475, 40);
		panel_1.add(tfpasswordmain);
		
		JPanel pnsalary = new JPanel();
		pnsalary.setBackground(new Color(240, 248, 255));
		pncardemployee.add(pnsalary, "pnsalary");
		pnsalary.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(224, 255, 255));
		panel_2.setBounds(125, 33, 706, 629);
		pnsalary.add(panel_2);
		panel_2.setLayout(null);
		dtm = new DefaultTableModel();
		dtm.addColumn("Month");
		dtm.addColumn("Year");
		dtm.addColumn("Salary");
		
		
		table = new JTable(dtm);

	
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 706, 629);
		panel_2.add(scrollPane);
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(224, 255, 255));
		panel_3.setBounds(903, 33, 597, 629);
		pnsalary.add(panel_3);
		panel_3.setLayout(null);
		
		tfsearchinsalaryemployee = new JTextField();
		tfsearchinsalaryemployee.setBounds(232, 10, 262, 41);
		panel_3.add(tfsearchinsalaryemployee);
		tfsearchinsalaryemployee.setColumns(10);
		
		JButton btnsearchsalaryinemployee = new JButton("");
		btnsearchsalaryinemployee.setIcon(new ImageIcon(EmployeePN.class.getResource("/img1/searchinsearchpncard3.png")));
		btnsearchsalaryinemployee.setBounds(504, 10, 83, 41);
		panel_3.add(btnsearchsalaryinemployee);
		String a[] = {"Months of Year", "Months", "Years", "Highest Month"};
		JComboBox comboBox = new JComboBox(a);
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		comboBox.setBounds(10, 10, 195, 41);
		panel_3.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("YEAR");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(26, 125, 131, 41);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("MONTH");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(26, 229, 131, 41);
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("SALARY");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1_1.setBounds(26, 338, 131, 41);
		panel_3.add(lblNewLabel_1_1_1);
		
		tfsalaryemployeeyear = new JTextField();
		tfsalaryemployeeyear.setEditable(false);
		tfsalaryemployeeyear.setBounds(212, 125, 347, 41);
		panel_3.add(tfsalaryemployeeyear);
		tfsalaryemployeeyear.setColumns(10);
		
		tfsalaryemployeemonth = new JTextField();
		tfsalaryemployeemonth.setEditable(false);
		tfsalaryemployeemonth.setColumns(10);
		tfsalaryemployeemonth.setBounds(212, 229, 347, 41);
		panel_3.add(tfsalaryemployeemonth);
		
		tfsalaryemployeesalary = new JTextField();
		tfsalaryemployeesalary.setEditable(false);
		tfsalaryemployeesalary.setColumns(10);
		tfsalaryemployeesalary.setBounds(212, 338, 347, 41);
		panel_3.add(tfsalaryemployeesalary);
		
		JPanel pnnotification = new JPanel();
		pnnotification.setBackground(new Color(204, 255, 255));
		pncardemployee.add(pnnotification, "pnnotification");
		pnnotification.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(204, 255, 204));
		panel_5.setBounds(26, 28, 1436, 744);
		pnnotification.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("NOTIFICATIONS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 10, 402, 58);
		panel_5.add(lblNewLabel_2);
		
		JPanel pncardnotification = new JPanel();
		pncardnotification.setBounds(0, 71, 1201, 673);
		panel_5.add(pncardnotification);
		pncardnotification.setLayout(new CardLayout(0, 0));
		
		JPanel pncardall = new JPanel();
		pncardnotification.add(pncardall, "pnall");
		pncardall.setLayout(null);
		//
		//
		//all notification
		dtmall = new DefaultTableModel();
		dtmall.addColumn("Number");
		dtmall.addColumn("Content");
		final JTable tableall = new JTable(dtmall);
		tableall.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableall.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableall.getColumnModel().getColumn(1).setPreferredWidth(1101);
		JScrollPane scrollPane_1 = new JScrollPane(tableall);
		scrollPane_1.setBounds(0, 0, 1201, 673);
		pncardall.add(scrollPane_1);
		
		
		
		JPanel pncardstared = new JPanel();
		pncardnotification.add(pncardstared, "pnstar");
		pncardstared.setLayout(null);
		dtmstar = new DefaultTableModel();
		dtmstar.addColumn("Number");
		dtmstar.addColumn("Content");
		final JTable tablestar = new JTable(dtmstar);
		tablestar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablestar.getColumnModel().getColumn(0).setPreferredWidth(100);
		tablestar.getColumnModel().getColumn(1).setPreferredWidth(1101);
		JScrollPane scrollPane_2 = new JScrollPane(tablestar);
		scrollPane_2.setBounds(0, 0, 1201, 673);
		pncardstared.add(scrollPane_2);
		JPanel pncardBin = new JPanel();
		pncardnotification.add(pncardBin, "pnbin");
		pncardBin.setLayout(null);
		dtmbin = new DefaultTableModel();
		dtmbin.addColumn("Number");
		dtmbin.addColumn("Content");
		final JTable tablebin = new JTable(dtmbin);
		tablebin.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablebin.getColumnModel().getColumn(0).setPreferredWidth(100);
		tablebin.getColumnModel().getColumn(1).setPreferredWidth(1101);
		JScrollPane scrollPane_3 = new JScrollPane(tablebin);
		scrollPane_3.setBounds(0, 0, 1201, 673);
		pncardBin.add(scrollPane_3);
		
		JPanel pnrequest = new JPanel();
		pnrequest.setBackground(new Color(204, 255, 255));
		pncardemployee.add(pnrequest, "pnrequest");
		pnrequest.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(230, 230, 250));
		panel_6.setBounds(127, 44, 1328, 696);
		pnrequest.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("NOTE");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(28, 23, 148, 42);
		panel_6.add(lblNewLabel_3);
		
		JTextArea txtarearequest = new JTextArea();
		txtarearequest.setBackground(new Color(248, 248, 255));
		txtarearequest.setBounds(186, 23, 1078, 412);
		panel_6.add(txtarearequest);
		
		JLabel lblNewLabel_3_1 = new JLabel("To : ");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3_1.setBounds(408, 503, 83, 42);
		panel_6.add(lblNewLabel_3_1);
		
		JComboBox cbbobject = new JComboBox();
		cbbobject.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		cbbobject.setModel(new DefaultComboBoxModel(new String[] {"All", "Admin", "Peers"}));
		cbbobject.setBounds(501, 501, 196, 42);
		panel_6.add(cbbobject);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Peers ID");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3_1_1.setBounds(394, 567, 97, 42);
		panel_6.add(lblNewLabel_3_1_1);
		
		tfpeersid = new JTextField();
		tfpeersid.setBounds(501, 570, 196, 39);
		panel_6.add(tfpeersid);
		tfpeersid.setColumns(10);
		
		JButton btnsubmitrequest = new JButton("Submit");
		btnsubmitrequest.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnsubmitrequest.setBounds(747, 503, 180, 42);
		panel_6.add(btnsubmitrequest);
		popupMenu = new JPopupMenu();
		popupMenu.setBounds(0, 0, 100, 16);
		
		pnnotification.add(popupMenu);
		
		JMenuItem mndelete = new JMenuItem("Delete");
	
		popupMenu.add(mndelete);
		
		JMenuItem mnstar = new JMenuItem("Star");
	
		popupMenu.add(mnstar);
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfc = new JFileChooser();
				FileNameExtensionFilter imgfilter = new FileNameExtensionFilter("picture", "jpg","png");
				jfc.setFileFilter(imgfilter);
				jfc.setMultiSelectionEnabled(false);
				int x = jfc.showDialog(panel_1, "Choose");
				if(x==jfc.APPROVE_OPTION) {
				fi = jfc.getSelectedFile();
					lbavataraccount.setIcon(new ImageIcon(fi.getAbsolutePath()));
				}
			}
		});
		mntmaccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout c1 = (CardLayout)pncardemployee.getLayout();
				c1.show(pncardemployee, "pnaccount");
			}
		});
		mntmSalary.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfsalaryemployeemonth.setText("");
				tfsalaryemployeesalary.setText("");
				tfsalaryemployeeyear.setText("");
				tfsearchinsalaryemployee.setText("");
				dtm.setRowCount(0);
				CardLayout c1 = (CardLayout)pncardemployee.getLayout();
				c1.show(pncardemployee, "pnsalary");
			}
		});
		mntmNotifications.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dtmall.setRowCount(0);
				setdatafornotificationall();
				CardLayout c1 = (CardLayout)pncardemployee.getLayout();
				c1.show(pncardemployee, "pnnotification");
				CardLayout c = (CardLayout)pncardnotification.getLayout();
				c.show(pncardnotification, "pnall");
			}
		});
		
		mntmRequest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub\
				txtarearequest.setText("");
				tfpeersid.setText("");
				cbbobject.setSelectedIndex(0);
				CardLayout c1 = (CardLayout)pncardemployee.getLayout();
				c1.show(pncardemployee, "pnrequest");
				
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnOpen.setEnabled(true);
				btnSave.setEnabled(true);
				tffullnameinaccountpage.setEditable(true);
				tfaddressinaccountpage.setEditable(true);
				tfpasswordmain.setEditable(true);
				tfageinaccountpage.setEditable(true);
				
			}
		});
		table.addMouseListener(new MouseListener() {
			
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
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			      int row = table.getSelectedRow();
			      tfsalaryemployeemonth.setText(""+table.getValueAt(row, 0));
			      tfsalaryemployeeyear.setText(""+table.getValueAt(row, 1));
			      tfsalaryemployeesalary.setText(""+table.getValueAt(row, 2));
			}
		});
		tableall.addMouseListener(new MouseListener() {
			
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
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tableall.getSelectedRow();
		
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int iput = JOptionPane.showConfirmDialog(null, "Confirm ?","", JOptionPane.YES_NO_OPTION);
				if(iput==JOptionPane.YES_OPTION) {
					btnOpen.setEnabled(false);
					btnSave.setEnabled(false);
					tffullnameinaccountpage.setEditable(false);
					tfaddressinaccountpage.setEditable(false);
					tfpasswordmain.setEditable(false);
					tfageinaccountpage.setEditable(false);
					String a ="";
					try {
						a = fi.getAbsolutePath();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					if(a.equals("")) {
								con.updateemployee(tffullnameinaccountpage.getText(), tfaddressinaccountpage.getText(), tfgenderinaccountpage.getText(),tfpositioninaccountpage.getText(), Integer.parseInt(tfageinaccountpage.getText()), Integer.parseInt(tfidinaccountpage.getText()),""+lbavataraccount.getIcon()  , tfpasswordmain.getText());
					}else {
					System.out.println(a);
					con.updateemployee(tffullnameinaccountpage.getText(), tfaddressinaccountpage.getText(), tfgenderinaccountpage.getText(),tfpositioninaccountpage.getText(), Integer.parseInt(tfageinaccountpage.getText()), Integer.parseInt(tfidinaccountpage.getText()), a, tfpasswordmain.getText());
					}
				}
			
				}
		});
	btnsearchsalaryinemployee.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tfsalaryemployeemonth.setText("");
			tfsalaryemployeesalary.setText("");
			tfsalaryemployeeyear.setText("");
			dtm.setRowCount(0);
			if(comboBox.getSelectedIndex()!=-1) {
				if(comboBox.getSelectedIndex()==0) {
					setdatafordtm();
					if(dtm.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "No information","",JOptionPane.INFORMATION_MESSAGE);
					}
				}else if(comboBox.getSelectedIndex()==1) {
					setdatafordtmmonth();
					if(dtm.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "No information","",JOptionPane.INFORMATION_MESSAGE);
					}
				}else if(comboBox.getSelectedIndex()==2) {
					setdataforallyear();
					if(dtm.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "No information","",JOptionPane.INFORMATION_MESSAGE);
					}
				}else if(comboBox.getSelectedIndex()==3) {
					setdataforhighest();
					if(dtm.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "No information","",JOptionPane.INFORMATION_MESSAGE);
					}
			}
			}
		}
	});

	btnsubmitrequest.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
 			// TODO Auto-generated method stub
			if(cbbobject.getSelectedIndex()!=-1) {
			if(cbbobject.getSelectedIndex()==0) {
				con.insertnotificationall(txtarearequest.getText());
		}
			if(cbbobject.getSelectedIndex()==1) {
				con.insertnotification(txtarearequest.getText(),"0");
			}
			if(cbbobject.getSelectedIndex()==2) {
				con.insertnotification(txtarearequest.getText(), tfpeersid.getText());
			}
			}
		}
	});
	}
	public void setdata() {
		ResultSet rs = con.getembyusnameandpass(tfusernamemain.getText(), tfpasswordmain.getText());
		try {
			while(rs.next()) {
				tfidinaccountpage.setText(rs.getString(1));
				tffullnameinaccountpage.setText(rs.getString(2));
				tfaddressinaccountpage.setText(rs.getString(3));
				tfgenderinaccountpage.setText(rs.getString(4));
				tfpositioninaccountpage.setText(rs.getString(5));
				tfageinaccountpage.setText(rs.getString(6));
			     icoc = new ImageIcon(""+rs.getString(7));
				lbavataraccount.setIcon(icoc);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void setdatafordtm() {
		ResultSet rs = con.getsalarybyyear(tfidinaccountpage.getText());
		try {
			while(rs.next()) {
				String month = rs.getString(1);
				String year = rs.getString(2);
				String salary = rs.getString(3);
				dtm.addRow(new String[] {month,year,salary});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void setdatafordtmmonth(){
		ResultSet rs = con.getsalarybymonth(tfidinaccountpage.getText(), tfsearchinsalaryemployee.getText());
		try {
			while(rs.next()) {
				String month = rs.getString(1);
				String year = rs.getString(2);
				String salary = rs.getString(3);
				dtm.addRow(new String[] {month,year,salary});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void setdataforallyear() {
		ResultSet rs = con.getsalryallyear(tfidinaccountpage.getText());
		try {
			while(rs.next()) {
				String month = "x";
				String year = rs.getString(2);
				String salary = rs.getString(1);
				dtm.addRow(new String[] {month,year,salary});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void setdataforhighest() {
		ResultSet rs = con.getmaxmonthsalary(tfidinaccountpage.getText());
		
		try {
			while(rs.next()) {
				String month = rs.getString(1);
				String year = rs.getString(2);
				String salary = rs.getString(3);
				dtm.addRow(new String[] {month,year,salary});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void setdataforstartable() {
		ResultSet rs = con.getnotificationtable(tfidinaccountpage.getText(), "Star");
		int i=0;
		try {
			while(rs.next()) {
				i++;
				String num = ""+i;
				String content = rs.getString(1);
				dtmstar.addRow(new String[] {num,content});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void setdataforbintable() {
		ResultSet rs = con.getnotificationtable(tfidinaccountpage.getText(), "BIN");
		int i=0;
		try {
			while(rs.next()) {
				i++;
				String num = ""+i;
				String content = rs.getString(1);
				dtmbin.addRow(new String[] {num,content});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void setdatafornotificationall() {
		ResultSet rs = con.getallnotification(tfidinaccountpage.getText());
		int i=0;
		try {
			while(rs.next()) {
				i++;
				String num = ""+i;
				String content = rs.getString(2);
				dtmall.addRow(new String[] {num,content});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
