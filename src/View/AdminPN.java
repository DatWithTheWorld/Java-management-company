package View;

import javax.swing.JPanel;
import org.mindrot.jbcrypt.BCrypt;
import javax.swing.JPopupMenu;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import Connection.dbcontroller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import java.sql.ResultSet;
import java.util.Locale.Category;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JTable;
import model.employee;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.demo.BarChartDemo1;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import demo.orsoncharts.swing.BarChart3DDemo1;

public class AdminPN extends JPanel {
	
	employee employee = new employee();
	private File fi ;
	private JPopupMenu popupMenu;
	private JComboBox cbbpss;
	private JComboBox cbbmonthdetail;
	private JComboBox cbbyeardetail;
	private JComboBox cbbmonth;
	private JComboBox cbbyear;
	private JComboBox cbbtop;
	private JComboBox cbbpositioncacutlatelong;
	private DefaultTableModel dtmall;
	private DefaultTableModel dtmstar;
	private DefaultTableModel dtmnew;
	private DefaultTableModel dtmbin;
	private DefaultTableModel dtmbad;
	private DefaultTableModel dtmtop;
   private DefaultTableModel dtm ;
   private DefaultTableModel salarydtm;
   private DefaultTableModel tableallemployee;
   private DefaultTableModel dtmshowsalary;
   private JMenu mnlogout;
   private JPanel pncardHomeadmin;
   private JPanel pncardadmin;
   private JTable table;
   private JTextField tfidinsearch;
   static dbcontroller con = new dbcontroller();
   private JTextField tfidemployee;
   private JTextField tffullnameemployee;
   private JTextField tfaddressemployee;
   private JTextField tfage;
   private JTextField tffullnameinsearch;
   private JTextField tfaddressinsearch;
   private JTextField tfageinsearch;
   private JTextField tfidincaculate;
   private JTextField tffullnamecaculate;
   private JTextField tfaddresscaculate;
   private JTextField tfagecaculate;
   private JTextField tfdaysoffcaculate;
   private JTextField tfusername;
   private JTextField tfpassword;
   private JTextField tfusernamesearch;
   private JTextField tfpasswordsearch;
   private JTextField tfidsend;
   private int rowall;
   private JTextField tfchecknew;
	public DefaultTableModel getDtm() {
	return dtm;
}
public void setDtm(DefaultTableModel dtm) {
	this.dtm = dtm;
}
	public JPanel getPncardadmin() {
	return pncardadmin;
}
public void setPncardadmin(JPanel pncardadmin) {
	this.pncardadmin = pncardadmin;
}
	public JPanel getPncardHomeadmin() {
	return pncardHomeadmin;
}
public void setPncardHomeadmin(JPanel pncardHomeadmin) {
	this.pncardHomeadmin = pncardHomeadmin;
}
	public JMenu getMnlogout() {
	return mnlogout;
}
public void setMnlogout(JMenu mnlogout) {
	this.mnlogout = mnlogout;
}
	/**
	 * Create the panel.
	 */
	public AdminPN() {
		setLayout(null);
		String top[]= {"Top","1","3","10","100"};
		String month[]= {"Month","1","2","3","4","5","6","7","8","9","10","11","12"};
		String year[]= {"Year","2021","2022"};
		String positions[] ={"Position","Chief executive officer","Chief financial officer","Chief information officer","Chief marketing officer","Chief operations officer","Human resources manager","Information technology manager","Markerting manager","Product manager","Sales manager","Administrative assistant","Bookkeeper","Business analyst","Sales representative","Software engineer"};
		String gender[]= {"","Man","Woman","Another"};
		String position[]= {"","Chief executive officer","Chief financial officer","Chief information officer","Chief marketing officer","Chief operations officer","Human resources manager","Information technology manager","Markerting manager","Product manager","Sales manager","Administrative assistant","Bookkeeper","Business analyst","Sales representative","Software engineer"};
		employee.SaveInforEmployee();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 255, 255));
		panel.setBounds(0, 0, 1540, 72);
		add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(102, 255, 255));
		menuBar.setBounds(0, 0, 1540, 72);
		panel.add(menuBar);
		
		JMenu mnhome = new JMenu("  HOME");
		mnhome.setIcon(new ImageIcon(AdminPN.class.getResource("/img1/homee.png")));
		mnhome.setHorizontalAlignment(SwingConstants.CENTER);
		mnhome.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
		mnhome.setBackground(new Color(102, 255, 255));
		mnhome.setPreferredSize(new Dimension(200, 72));
		menuBar.add(mnhome);
		
		JMenu mndetails = new JMenu("        DETAILS");
		mndetails.setIcon(new ImageIcon(AdminPN.class.getResource("/img1/detail.png")));
		mndetails.setHorizontalAlignment(SwingConstants.CENTER);
		mndetails.setBackground(new Color(102, 255, 255));
		mndetails.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		mndetails.setPreferredSize(new Dimension(220, 72));
		menuBar.add(mndetails);
		
		JMenu mnmanagement = new JMenu("       MANAGEMENT");
		mnmanagement.setIcon(new ImageIcon(AdminPN.class.getResource("/img1/manage.png")));
		mnmanagement.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		mnmanagement.setPreferredSize(new Dimension(270, 72));
		menuBar.add(mnmanagement);
		
		JMenuItem mntmaeudemployee = new JMenuItem("AD EMPLOYEE");
		mntmaeudemployee.setIcon(new ImageIcon(AdminPN.class.getResource("/img1/aeds.png")));
		mntmaeudemployee.setBackground(new Color(102, 255, 255));
		mntmaeudemployee.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		//mntmaeudemployee.setPreferredSize(new Dimension(100, 72));
		mnmanagement.add(mntmaeudemployee);
		
		JMenuItem mntmsearchemployee = new JMenuItem("SEARCH EMPLOYEE");
		mntmsearchemployee.setIcon(new ImageIcon(AdminPN.class.getResource("/img1/searchemp.png")));
		mntmsearchemployee.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		mntmsearchemployee.setBackground(new Color(102, 255, 255));
		//mntmsearchemployee.setPreferredSize(new Dimension(100, 72));
		mnmanagement.add(mntmsearchemployee);
		
		JMenuItem mntmputnew = new JMenuItem("PUT NEWS");
		mntmputnew.setIcon(new ImageIcon(AdminPN.class.getResource("/img1/addnews.png")));
		mntmputnew.setBackground(new Color(102, 255, 255));
		mntmputnew.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		mnmanagement.add(mntmputnew);
		
		JMenu mncaculatesalary = new JMenu("     CACULATE SALARY");
		mncaculatesalary.setIcon(new ImageIcon(AdminPN.class.getResource("/img1/salary.png")));
		mncaculatesalary.setBackground(new Color(102, 255, 255));
		mncaculatesalary.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		mncaculatesalary.setPreferredSize(new Dimension(285, 72));
		menuBar.add(mncaculatesalary);
		
		JMenu mnnotification = new JMenu("    NOTIFICATIONS");
		mnnotification.setIcon(new ImageIcon(AdminPN.class.getResource("/img1/notification.png")));
		mnnotification.setBackground(new Color(102, 255, 255));
		mnnotification.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		mnnotification.setPreferredSize(new Dimension(250,72));
		menuBar.add(mnnotification);
		
		mnlogout = new JMenu("     LOG OUT");
		mnlogout.setIcon(new ImageIcon(AdminPN.class.getResource("/img1/log out.png")));
		mnlogout.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		mnlogout.setBackground(new Color(102, 255, 255));
		mnlogout.setPreferredSize(new Dimension(200, 72));
		menuBar.add(mnlogout);
		
		pncardadmin = new JPanel();
		pncardadmin.setBounds(0, 71, 1540, 774);
		add(pncardadmin);
		pncardadmin.setLayout(new CardLayout(0, 0));
		
	    pncardHomeadmin = new JPanel();
		pncardadmin.add(pncardHomeadmin, "pnhome");
		pncardHomeadmin.setLayout(null);
		ChartPanel cpn = new ChartPanel(createChart());
		cpn.setPreferredSize(new Dimension(1500, 500));
		cpn.setBounds(0, 0, 1500, 500);
		
		pncardHomeadmin.add(cpn);
		
		
		JPanel pnDetailsadmin = new JPanel();
		pnDetailsadmin.setBackground(new Color(255, 204, 255));
		pncardadmin.add(pnDetailsadmin, "pndetail");
		pnDetailsadmin.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 204));
		panel_6.setBounds(10, 10, 216, 754);
		pnDetailsadmin.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnallemployee = new JButton("All Employee");
		btnallemployee.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnallemployee.setBounds(10, 10, 196, 54);
		panel_6.add(btnallemployee);
		
		JButton btnShowSalary = new JButton("Show Salary");
		btnShowSalary.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnShowSalary.setBounds(10, 74, 196, 54);
		panel_6.add(btnShowSalary);
		
		JButton btnTopEmployee = new JButton("Top Employee");
		btnTopEmployee.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnTopEmployee.setBounds(10, 138, 196, 54);
		panel_6.add(btnTopEmployee);
		
		JButton btnbademployee = new JButton("Bad Employee");
		btnbademployee.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnbademployee.setBounds(10, 202, 196, 54);
		panel_6.add(btnbademployee);
		
		JPanel pncardindetail = new JPanel();
		pncardindetail.setBackground(new Color(255, 204, 204));
		pncardindetail.setBounds(236, 10, 1294, 754);
		pnDetailsadmin.add(pncardindetail);
		pncardindetail.setLayout(new CardLayout(0, 0));
		
		JPanel pnallemployee = new JPanel();
		pnallemployee.setBackground(new Color(255, 255, 204));
		pncardindetail.add(pnallemployee, "pnallemployee");
		pnallemployee.setLayout(null);
		  //table all employee
		tableallemployee = new DefaultTableModel();
		tableallemployee.addColumn("ID");
		tableallemployee.addColumn("Full name");
		tableallemployee.addColumn("Address");
		tableallemployee.addColumn("Gender");
		tableallemployee.addColumn("Position");
		tableallemployee.addColumn("Age");
		final JTable tballemployee = new JTable(tableallemployee);
		 
		JScrollPane scrollPane_2 = new JScrollPane(tballemployee);
		scrollPane_2.setBounds(32, 69, 1215, 659);
		pnallemployee.add(scrollPane_2);
		
		JButton btnchecknew = new JButton("Check");
		btnchecknew.setBounds(84, 21, 99, 35);
		pnallemployee.add(btnchecknew);
		
		tfchecknew = new JTextField();
		tfchecknew.setBounds(204, 19, 408, 40);
		pnallemployee.add(tfchecknew);
		tfchecknew.setColumns(10);
		
		JPanel pnshowsalary = new JPanel();
		pnshowsalary.setBackground(new Color(255, 255, 204));
		pncardindetail.add(pnshowsalary, "pnshowsalary");
		pnshowsalary.setLayout(null);
		
	    cbbmonthdetail = new JComboBox(month);
		cbbmonthdetail.setBounds(214, 10, 176, 36);
		pnshowsalary.add(cbbmonthdetail);
		
	    cbbyeardetail = new JComboBox(year);
		cbbyeardetail.setBounds(419, 10, 176, 36);
		pnshowsalary.add(cbbyeardetail);
		
		JButton btnshowindetail = new JButton("SHOW");
		btnshowindetail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnshowindetail.setBounds(10, 10, 176, 36);
		pnshowsalary.add(btnshowindetail);
		
		
		//table show salary
		dtmshowsalary = new DefaultTableModel();
		dtmshowsalary.addColumn("ID");
		dtmshowsalary.addColumn("Full name");
		dtmshowsalary.addColumn("Address");
        dtmshowsalary.addColumn("Gender");
        dtmshowsalary.addColumn("Position");
        dtmshowsalary.addColumn("Age");
        dtmshowsalary.addColumn("Month");
        dtmshowsalary.addColumn("Year");
        dtmshowsalary.addColumn("Salary");
        final JTable tableshowsalary = new JTable(dtmshowsalary);
		JScrollPane scrollPane_3 = new JScrollPane(tableshowsalary);
		scrollPane_3.setBounds(10, 73, 1258, 671);
		pnshowsalary.add(scrollPane_3);
		
		JPanel pntopemployee = new JPanel();
		pntopemployee.setBackground(new Color(255, 255, 204));
		pncardindetail.add(pntopemployee, "pntopemployee");
		pntopemployee.setLayout(null);
		
		cbbtop = new JComboBox(top);
		cbbtop.setBounds(25, 10, 187, 34);
		pntopemployee.add(cbbtop);
		
		JButton btncheck = new JButton("Check");
		btncheck.setBackground(new Color(255, 204, 255));
		btncheck.setBounds(552, 10, 144, 34);
		pntopemployee.add(btncheck);
		
		dtmtop = new DefaultTableModel();
		dtmtop.addColumn("ID");
		dtmtop.addColumn("Full name");
		dtmtop.addColumn("Address");
		dtmtop.addColumn("Gender");
		dtmtop.addColumn("Position");
		dtmtop.addColumn("Age");
		final JTable tabletop = new JTable(dtmtop);
		JScrollPane scrollPane_4 = new JScrollPane(tabletop);
		scrollPane_4.setBounds(25, 95, 1234, 638);
		pntopemployee.add(scrollPane_4);
		
	    cbbpss = new JComboBox(positions);
		cbbpss.setBounds(236, 10, 293, 34);
		pntopemployee.add(cbbpss);
		
		JPanel pnbademployee = new JPanel();
		pnbademployee.setBackground(new Color(255, 255, 204));
		pncardindetail.add(pnbademployee, "pnbademployee");
		pnbademployee.setLayout(null);
		
		//bademployee
		dtmbad = new DefaultTableModel();
		dtmbad.addColumn("ID");
		dtmbad.addColumn("Full name");
		dtmbad.addColumn("Address");
		dtmbad.addColumn("Gender");
		dtmbad.addColumn("Position");
		dtmbad.addColumn("Age");
		final JTable tablebad = new JTable(dtmbad);
		
		JScrollPane scrollPane_5 = new JScrollPane(tablebad);
		scrollPane_5.setBounds(84, 84, 1060, 585);
		pnbademployee.add(scrollPane_5);
	
		
		JPanel pnManageMent = new JPanel();
		pnManageMent.setBackground(new Color(204, 255, 255));
		pncardadmin.add(pnManageMent, "pnmanagement");
		pnManageMent.setLayout(new CardLayout(0, 0));
		
		JPanel pncardadeemployee = new JPanel();
		pncardadeemployee.setBackground(new Color(204, 255, 255));
		pnManageMent.add(pncardadeemployee, "pnadeemployee");
		pncardadeemployee.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(10, 10, 1520, 756);
		pncardadeemployee.add(panel_1);
		panel_1.setLayout(null);
		dtm = new DefaultTableModel();
		dtm.addColumn("ID");
		dtm.addColumn("Full name");
		dtm.addColumn("Address");
		dtm.addColumn("Gender");
		dtm.addColumn("Position");
		dtm.addColumn("Age");
		dtm.addColumn("User name");
		dtm.addColumn("Password");
		table = new JTable(dtm);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(503, 10, 1007, 736);
		panel_1.add(scrollPane);
		
		
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(18, 92, 59, 32);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Full name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(18, 160, 85, 32);
		panel_1.add(lblNewLabel_1);
		
		JLabel Address = new JLabel("Address");
		Address.setFont(new Font("Tahoma", Font.BOLD, 15));
		Address.setBounds(18, 229, 67, 32);
		panel_1.add(Address);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(18, 306, 59, 32);
		panel_1.add(lblNewLabel_3);
		
		JButton btnadd = new JButton("ADD");
		btnadd.setBackground(new Color(255, 255, 255));
		btnadd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnadd.setBounds(79, 636, 171, 41);
		panel_1.add(btnadd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(260, 636, 171, 41);
		panel_1.add(btnDelete);
		
		JLabel lblNewLabel_3_1 = new JLabel("Position");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(18, 377, 67, 32);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Age");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(18, 447, 59, 32);
		panel_1.add(lblNewLabel_3_2);
		
		tfidemployee = new JTextField();
		tfidemployee.setEditable(false);
		tfidemployee.setBounds(123, 92, 370, 41);
		panel_1.add(tfidemployee);
		tfidemployee.setColumns(10);
		
		tffullnameemployee = new JTextField();
		tffullnameemployee.setColumns(10);
		tffullnameemployee.setBounds(123, 160, 370, 41);
		panel_1.add(tffullnameemployee);
		
		tfaddressemployee = new JTextField();
		tfaddressemployee.setColumns(10);
		tfaddressemployee.setBounds(123, 229, 370, 41);
		panel_1.add(tfaddressemployee);
		
		tfage = new JTextField();
		tfage.setColumns(10);
		tfage.setBounds(123, 447, 249, 41);
		panel_1.add(tfage);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnClear.setBackground(Color.WHITE);
		btnClear.setBounds(79, 689, 352, 41);
		panel_1.add(btnClear);
		
		JComboBox cbbposition = new JComboBox(position);
		cbbposition.setBounds(123, 379, 370, 41);
		panel_1.add(cbbposition);
		
		JComboBox cbbgender = new JComboBox(gender);
		cbbgender.setBounds(123, 306, 370, 41);
		panel_1.add(cbbgender);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("User name");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2_1.setBounds(18, 514, 85, 32);
		panel_1.add(lblNewLabel_3_2_1);
		
		tfusername = new JTextField();
		tfusername.setColumns(10);
		tfusername.setBounds(123, 514, 370, 41);
		panel_1.add(tfusername);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Password");
		lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2_1_1.setBounds(18, 578, 85, 32);
		panel_1.add(lblNewLabel_3_2_1_1);
		
		tfpassword = new JTextField();
		tfpassword.setColumns(10);
		tfpassword.setBounds(123, 576, 370, 41);
		panel_1.add(tfpassword);
		
		JPanel pnsearchemployeeadmin = new JPanel();
		pnsearchemployeeadmin.setBackground(new Color(204, 204, 255));
		pnManageMent.add(pnsearchemployeeadmin, "pnsearchemployeeadmin");
		pnsearchemployeeadmin.setLayout(null);
		
		tfidinsearch = new JTextField();
		tfidinsearch.setBounds(606, 10, 385, 31);
		pnsearchemployeeadmin.add(tfidinsearch);
		tfidinsearch.setColumns(10);
		
		JButton btnsearch = new JButton("");
		btnsearch.setBackground(new Color(255, 153, 153));
		btnsearch.setIcon(new ImageIcon(AdminPN.class.getResource("/img1/searchinsearchpncard3.png")));
		btnsearch.setBounds(1013, 10, 103, 31);
		pnsearchemployeeadmin.add(btnsearch);
		
		JLabel lblNewLabel_6_6 = new JLabel("ID");
		lblNewLabel_6_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_6.setBounds(511, 8, 85, 31);
		pnsearchemployeeadmin.add(lblNewLabel_6_6);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 204, 255));
		pn1.setBounds(129, 134, 819, 583);
		pnsearchemployeeadmin.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Full name");
		lblNewLabel_6.setBounds(61, 72, 85, 31);
		pn1.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_6_1 = new JLabel("Address");
		lblNewLabel_6_1.setBounds(61, 147, 85, 31);
		pn1.add(lblNewLabel_6_1);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_6_2 = new JLabel("Gender");
		lblNewLabel_6_2.setBounds(61, 218, 85, 31);
		pn1.add(lblNewLabel_6_2);
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_6_3 = new JLabel("Position");
		lblNewLabel_6_3.setBounds(61, 282, 85, 31);
		pn1.add(lblNewLabel_6_3);
		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_6_4 = new JLabel("Age");
		lblNewLabel_6_4.setBounds(61, 352, 85, 31);
		pn1.add(lblNewLabel_6_4);
		lblNewLabel_6_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		tffullnameinsearch = new JTextField();
		tffullnameinsearch.setEditable(false);
		tffullnameinsearch.setBounds(214, 67, 543, 45);
		pn1.add(tffullnameinsearch);
		tffullnameinsearch.setColumns(10);
		
		tfaddressinsearch = new JTextField();
		tfaddressinsearch.setEditable(false);
		tfaddressinsearch.setColumns(10);
		tfaddressinsearch.setBounds(214, 142, 543, 45);
		pn1.add(tfaddressinsearch);
		
		tfageinsearch = new JTextField();
		tfageinsearch.setEditable(false);
		tfageinsearch.setColumns(10);
		tfageinsearch.setBounds(214, 352, 543, 45);
		pn1.add(tfageinsearch);
		
		JComboBox cbbgenderinsearch = new JComboBox(gender);
		cbbgenderinsearch.setEditable(false);
		cbbgenderinsearch.setBounds(214, 213, 543, 45);
		pn1.add(cbbgenderinsearch);
		
		JComboBox cbbpositioninsearch = new JComboBox(position);
		cbbpositioninsearch.setEditable(false);
		cbbpositioninsearch.setBounds(214, 282, 543, 45);
		pn1.add(cbbpositioninsearch);
		
		JLabel lblNewLabel_6_4_1 = new JLabel("UserName");
		lblNewLabel_6_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_4_1.setBounds(61, 420, 85, 31);
		pn1.add(lblNewLabel_6_4_1);
		
		tfusernamesearch = new JTextField();
		tfusernamesearch.setEditable(false);
		tfusernamesearch.setColumns(10);
		tfusernamesearch.setBounds(214, 420, 543, 45);
		pn1.add(tfusernamesearch);
		
		JLabel lblNewLabel_6_4_1_1 = new JLabel("Password");
		lblNewLabel_6_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_4_1_1.setBounds(61, 490, 85, 31);
		pn1.add(lblNewLabel_6_4_1_1);
		
		tfpasswordsearch = new JTextField();
		tfpasswordsearch.setEditable(false);
		tfpasswordsearch.setColumns(10);
		tfpasswordsearch.setBounds(214, 490, 543, 45);
		pn1.add(tfpasswordsearch);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 255));
		panel_2.setBounds(1118, 142, 321, 357);
		pnsearchemployeeadmin.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbavatar = new JLabel("");
		lbavatar.setBounds(10, 10, 307, 338);
		panel_2.add(lbavatar);
		lbavatar.setBackground(new Color(204, 204, 255));
		lbavatar.setHorizontalAlignment(SwingConstants.CENTER);
		//lbavatar.setIcon(new ImageIcon(AdminPN.class.getResource("/img1/admin.png")));
		
		//lbavatar.setIcon(imic);
		
		JButton btnopen = new JButton("Open");
		btnopen.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnopen.setEnabled(false);
		btnopen.setBounds(1185, 519, 176, 38);
		pnsearchemployeeadmin.add(btnopen);
		
		JButton btnedit = new JButton("EDIT");
		btnedit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnedit.setBounds(1118, 627, 136, 47);
		pnsearchemployeeadmin.add(btnedit);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setEnabled(false);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBounds(1303, 627, 136, 47);
		pnsearchemployeeadmin.add(btnSave);
		
		JPanel pnputnews = new JPanel();
		pnputnews.setBackground(new Color(255, 204, 255));
		pnManageMent.add(pnputnews, "pnputnews");
		pnputnews.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 23));
		textArea.setBounds(102, 81, 1338, 496);
		pnputnews.add(textArea);
		
		JButton btnsubmitnews = new JButton("SUBMIT");
		btnsubmitnews.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnsubmitnews.setBounds(703, 630, 206, 37);
		pnputnews.add(btnsubmitnews);
		
		JPanel pncaculatesalary = new JPanel();
		pncaculatesalary.setBackground(new Color(255, 204, 255));
		pncardadmin.add(pncaculatesalary, "pncaculatesalary");
		pncaculatesalary.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 255, 255));
		panel_3.setBounds(28, 36, 924, 710);
		pncaculatesalary.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 255, 255));
		panel_4.setBounds(0, 57, 924, 653);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		
		salarydtm = new DefaultTableModel();
		salarydtm.addColumn("ID");
		salarydtm.addColumn("Full name");
		salarydtm.addColumn("Address");
		salarydtm.addColumn("Gender");
		salarydtm.addColumn("Position");
		salarydtm.addColumn("Age");
		final JTable tablesalary = new JTable(salarydtm);
		
		JScrollPane scrollPane_1 = new JScrollPane(tablesalary);
		scrollPane_1.setBounds(0, 0, 924, 653);
		panel_4.add(scrollPane_1);
		
		cbbmonth = new JComboBox(month);
		cbbmonth.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbbmonth.setBounds(10, 10, 197, 38);
		panel_3.add(cbbmonth);
		
		cbbyear = new JComboBox(year);
		cbbyear.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbbyear.setBounds(237, 9, 197, 38);
		panel_3.add(cbbyear);
		
	    cbbpositioncacutlatelong = new JComboBox(positions);
		cbbpositioncacutlatelong.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbbpositioncacutlatelong.setBounds(472, 9, 346, 38);
		panel_3.add(cbbpositioncacutlatelong);
		
		JButton btnquery = new JButton("");
		btnquery.setIcon(new ImageIcon(AdminPN.class.getResource("/img1/iconfindnew.png")));
		btnquery.setBounds(829, 10, 85, 37);
		panel_3.add(btnquery);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(204, 204, 255));
		panel_5.setBounds(1007, 36, 480, 710);
		pncaculatesalary.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(30, 37, 47, 42);
		panel_5.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Full name");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(30, 131, 80, 42);
		panel_5.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Address");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(30, 217, 80, 42);
		panel_5.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Gender");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1.setBounds(30, 308, 80, 42);
		panel_5.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Position");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_2.setBounds(30, 403, 80, 42);
		panel_5.add(lblNewLabel_2_1_1_2);
		
		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Age");
		lblNewLabel_2_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_2_1.setBounds(30, 490, 80, 42);
		panel_5.add(lblNewLabel_2_1_1_2_1);
		
		JLabel lblNewLabel_2_1_1_2_1_1 = new JLabel("Days off");
		lblNewLabel_2_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_2_1_1.setBounds(30, 582, 80, 42);
		panel_5.add(lblNewLabel_2_1_1_2_1_1);
		
		JButton btncaculate = new JButton("CACULATE");
		btncaculate.setBackground(new Color(204, 255, 204));
		btncaculate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btncaculate.setBounds(315, 651, 155, 49);
		panel_5.add(btncaculate);
		
		tfidincaculate = new JTextField();
		tfidincaculate.setEditable(false);
		tfidincaculate.setBounds(127, 40, 343, 42);
		panel_5.add(tfidincaculate);
		tfidincaculate.setColumns(10);
		
		tffullnamecaculate = new JTextField();
		tffullnamecaculate.setEditable(false);
		tffullnamecaculate.setColumns(10);
		tffullnamecaculate.setBounds(127, 131, 343, 42);
		panel_5.add(tffullnamecaculate);
		
		tfaddresscaculate = new JTextField();
		tfaddresscaculate.setEditable(false);
		tfaddresscaculate.setColumns(10);
		tfaddresscaculate.setBounds(127, 217, 343, 42);
		panel_5.add(tfaddresscaculate);
		
		tfagecaculate = new JTextField();
		tfagecaculate.setEditable(false);
		tfagecaculate.setColumns(10);
		tfagecaculate.setBounds(127, 490, 343, 42);
		panel_5.add(tfagecaculate);
		
		tfdaysoffcaculate = new JTextField();
		tfdaysoffcaculate.setColumns(10);
		tfdaysoffcaculate.setBounds(127, 582, 343, 42);
		panel_5.add(tfdaysoffcaculate);
		
		JComboBox cbbgendercaculate = new JComboBox(gender);
		cbbgendercaculate.setBounds(127, 308, 343, 42);
		panel_5.add(cbbgendercaculate);
		
		JComboBox cbbpositioncaculate = new JComboBox(position);
		cbbpositioncaculate.setBounds(127, 403, 343, 42);
		panel_5.add(cbbpositioncaculate);
		
		JPanel pnnotifications = new JPanel();
		pnnotifications.setBackground(new Color(255, 153, 255));
		pncardadmin.add(pnnotifications, "pnnotifications");
		pnnotifications.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("NOTIFICATIONS");
		lblNewLabel_4.setForeground(new Color(255, 51, 102));
		lblNewLabel_4.setFont(new Font("Goudy Old Style", Font.BOLD, 25));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 10, 306, 62);
		pnnotifications.add(lblNewLabel_4);
		
		JPanel pncardnotification = new JPanel();
		pncardnotification.setBounds(36, 63, 1164, 671);
		pnnotifications.add(pncardnotification);
		pncardnotification.setLayout(new CardLayout(0, 0));
		
		JPanel pnallnotification = new JPanel();
		pncardnotification.add(pnallnotification, "pnall");
		pnallnotification.setLayout(null);
		
		
		//table all
		dtmall = new DefaultTableModel();
		dtmall.addColumn("Number");
		dtmall.addColumn("Content");
		final JTable tableall = new JTable(dtmall);
		
		tableall.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableall.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableall.getColumnModel().getColumn(1).setPreferredWidth(1060);
		
		JScrollPane scrollPane_6 = new JScrollPane(tableall);
		scrollPane_6.setBounds(0, 0, 1164, 671);
		pnallnotification.add(scrollPane_6);
		
		popupMenu = new JPopupMenu();
		popupMenu.setBounds(0, 0, 100, 16);
		
		pnallnotification.add(popupMenu);
		
		JMenuItem mndelete = new JMenuItem("Delete");
	
		popupMenu.add(mndelete);
		
		JMenuItem mnstar = new JMenuItem("Star");
	
		popupMenu.add(mnstar);
		
		JPanel pnstar = new JPanel();
		pnstar.setLayout(null);
		pncardnotification.add(pnstar, "pnstar");
		
		dtmstar = new DefaultTableModel();
		dtmstar.addColumn("Number");
		dtmstar.addColumn("Content");
		final JTable tablestar = new JTable(dtmstar);
		
		tablestar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablestar.getColumnModel().getColumn(0).setPreferredWidth(100);
		tablestar.getColumnModel().getColumn(1).setPreferredWidth(1060);
		
		JScrollPane scrollPane_7 = new JScrollPane(tablestar);
		scrollPane_7.setBounds(0, 0, 1164, 671);
		pnstar.add(scrollPane_7);
		
		JPanel pnnew = new JPanel();
		pnnew.setBackground(new Color(255, 204, 255));
		pnnew.setLayout(null);
		pncardnotification.add(pnnew, "pnnew");
		
		JTextArea txtarea = new JTextArea();
		txtarea.setBackground(new Color(255, 255, 204));
		txtarea.setBounds(74, 78, 987, 429);
		pnnew.add(txtarea);
		
		JLabel lblNewLabel_5 = new JLabel("Content");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_5.setBounds(97, 10, 225, 58);
		pnnew.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("To ID");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_5_1.setBounds(316, 517, 59, 58);
		pnnew.add(lblNewLabel_5_1);
		
		tfidsend = new JTextField();
		tfidsend.setBounds(400, 517, 377, 58);
		pnnew.add(tfidsend);
		tfidsend.setColumns(10);
		
		JButton btnsend = new JButton("Send");
		btnsend.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnsend.setBounds(800, 519, 207, 56);
		pnnew.add(btnsend);
	
		
		
		JPanel pnbin = new JPanel();
		pnbin.setLayout(null);
		pncardnotification.add(pnbin, "pnbin");
		dtmbin = new DefaultTableModel();
		dtmbin.addColumn("Number");
		dtmbin.addColumn("Content");
		final JTable tablebin = new JTable(dtmbin);
		tablebin.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablebin.getColumnModel().getColumn(0).setPreferredWidth(100);
		tablebin.getColumnModel().getColumn(1).setPreferredWidth(1060);
		
		JScrollPane scrollPane_8 = new JScrollPane(tablebin);
		scrollPane_8.setBounds(0, 0, 1164, 671);
		pnbin.add(scrollPane_8);
		
		JButton btnall = new JButton("");
		btnall.setIcon(new ImageIcon(AdminPN.class.getResource("/img1/all.png")));
		btnall.setBackground(new Color(204, 51, 255));
		btnall.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnall.setBounds(1290, 63, 133, 44);
		pnnotifications.add(btnall);
		
		JButton btnNew = new JButton("");
		btnNew.setIcon(new ImageIcon(AdminPN.class.getResource("/img1/plus.png")));
		btnNew.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNew.setBackground(new Color(204, 51, 255));
		btnNew.setBounds(1290, 138, 133, 44);
		pnnotifications.add(btnNew);
		
		
		
		
		mnhome.addMouseListener(new MouseListener() {
			
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
				CardLayout c = (CardLayout)pncardadmin.getLayout();
				c.show(pncardadmin, "pnhome");
			}
		});
		mndetails.addMouseListener(new MouseListener() {
			
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
				tableallemployee.setRowCount(0);
				setdataforallemployeetable();
				CardLayout c = (CardLayout)pncardadmin.getLayout();
				c.show(pncardadmin, "pndetail");
				CardLayout c1 = (CardLayout)pncardindetail.getLayout();
				c1.show(pncardindetail, "pnallemployee");
			}
		});
		mntmputnew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.setText("");
				CardLayout c = (CardLayout)pncardadmin.getLayout();
				c.show(pncardadmin, "pnmanagement");
				CardLayout c1 = (CardLayout)pnManageMent.getLayout();
				c1.show(pnManageMent, "pnputnews");
			}
		});
		mntmaeudemployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dtm.setRowCount(0);
				setdataforemtable();
				tfidemployee.setText("");
				tfaddressemployee.setText("");
				tffullnameemployee.setText("");
				tfusername.setText("");
				tfpassword.setText("");
				cbbposition.setSelectedIndex(0);
				cbbgender.setSelectedIndex(0);
				tfage.setText("");
				
				CardLayout c = (CardLayout)pncardadmin.getLayout();
				c.show(pncardadmin, "pnmanagement");
				CardLayout c1 = (CardLayout)pnManageMent.getLayout();
				c1.show(pnManageMent, "pnadeemployee");
			}
		});
		mntmsearchemployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfidinsearch.setText("");
				tffullnameinsearch.setText("");
				tfaddressinsearch.setText("");
				tfageinsearch.setText("");
				cbbpositioninsearch.setSelectedIndex(0);
				cbbgenderinsearch.setSelectedIndex(0);
				 lbavatar.setIcon(null);
				CardLayout c = (CardLayout)pncardadmin.getLayout();
				c.show(pncardadmin, "pnmanagement");
				CardLayout c1 = (CardLayout)pnManageMent.getLayout();
				c1.show(pnManageMent, "pnsearchemployeeadmin");
			}
		});
		mncaculatesalary.addMouseListener(new MouseListener() {
			
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
				salarydtm.setRowCount(0);
				cbbmonth.setSelectedIndex(0);
				cbbyear.setSelectedIndex(0);
				cbbpositioncacutlatelong.setSelectedIndex(0);
				cbbpositioncaculate.setSelectedIndex(0);
				cbbgendercaculate.setSelectedIndex(0);
				tfidincaculate.setText("");
				tffullnamecaculate.setText("");
				tfaddresscaculate.setText("");
				tfagecaculate.setText("");
				tfdaysoffcaculate.setText("" );
				CardLayout c = (CardLayout)pncardadmin.getLayout();
				c.show(pncardadmin, "pncaculatesalary");
			}
		});
		mnnotification.addMouseListener(new MouseListener() {
			
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
			
				CardLayout c = (CardLayout)pncardadmin.getLayout();
				c.show(pncardadmin, "pnnotifications");
				dtmall.setRowCount(0);
	            setdataforallnotification();
				CardLayout c1 = (CardLayout)pncardnotification.getLayout();
				c1.show(pncardnotification, "pnall");
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int resultt = JOptionPane.showConfirmDialog(pncardadeemployee, "Delete this employee","Confirm",JOptionPane.YES_NO_OPTION);
				if(resultt==JOptionPane.YES_OPTION) {
				for(int i=0;i<employee.getEmployeee().size();i++) {
					if(employee.getEmployeee().get(i).getId()==Integer.parseInt(tfidemployee.getText())) {
						employee.getEmployeee().remove(i);
					}
				}
				con.deleteemployee(Integer.parseInt(tfidemployee.getText()));
				dtm.setRowCount(0);
				
				setdataforemtable();
				}
			      tfidemployee.setText("");
			      tffullnameemployee.setText("");
			      tfage.setText("");
			      tfaddressemployee.setText("");
			      cbbgender.setSelectedIndex(0);
			      cbbposition.setSelectedIndex(0);
			    //  tfposition.setText("");
			}
			
		});
		btnadd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int a = employee.maxidemployee()+1;
				if(cbbposition.getSelectedIndex()!=-1) {
					if(cbbgender.getSelectedIndex()!=-1) {
						
						int resultt = JOptionPane.showConfirmDialog(pncardadeemployee, "Add this employee","Confirm",JOptionPane.YES_NO_OPTION);
						if(resultt==JOptionPane.YES_OPTION) {
							//hash pass 
							 String hashedPassword = BCrypt.hashpw(tfpassword.getText(), BCrypt.gensalt());
							 
				con.addnewemployee(tffullnameemployee.getText(),tfaddressemployee.getText(), ""+cbbgender.getItemAt(cbbgender.getSelectedIndex()),""+cbbposition.getItemAt(cbbposition.getSelectedIndex()), Integer.parseInt(tfage.getText()),tfusername.getText(),hashedPassword);
			    dtm.addRow(new String[] {a+"",tffullnameemployee.getText(),tfaddressemployee.getText(),""+cbbgender.getItemAt(cbbgender.getSelectedIndex()),""+cbbposition.getItemAt(cbbposition.getSelectedIndex()),tfage.getText(),tfusername.getText(),tfpassword.getText()}  );
				}
				}else {
					JOptionPane.showMessageDialog(pncardadeemployee,"Choose gender","Error",JOptionPane.ERROR_MESSAGE);
				}
				}else {
					JOptionPane.showMessageDialog(pncardadeemployee,"Choose position","Error",JOptionPane.ERROR_MESSAGE);
				}
		      tfidemployee.setText("");
		      tffullnameemployee.setText("");
		      tfage.setText("");
		      tfaddressemployee.setText("");
		      cbbgender.setSelectedIndex(0);
		      cbbposition.setSelectedIndex(0);
		      tfusername.setText("");
		      tfpassword.setText("");
		     
		    //  tfposition.setText("");
		     
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
				tfusername.setText("");
				tfpassword.setText("");
				
				tfidemployee.setText(""+table.getValueAt(row, 0));
				tffullnameemployee.setText(""+table.getValueAt(row, 1));
				tfaddressemployee.setText(""+table.getValueAt(row, 2));
				for(int i=0;i<gender.length;i++) {
					if(gender[i].equals(""+table.getValueAt(row, 3))) {
						cbbgender.setSelectedIndex(i);
					}
				}
			    for(int i=0;i<position.length;i++) {
			    	if(position[i].equals(""+table.getValueAt(row, 4))) {
			    		cbbposition.setSelectedIndex(i);
			    	}
			    }
				tfage.setText(""+table.getValueAt(row, 5));
				tfusername.setText(""+table.getValueAt(row, 6));
				tfpassword.setText(""+table.getValueAt(row, 7));
			}
		});
      btnClear.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tfusername.setText("");
			tfpassword.setText("");
			tfidemployee.setText("");
			tffullnameemployee.setText("");
			tfaddressemployee.setText("");
			cbbgender.setSelectedIndex(0);
		    tfage.setText("");
			cbbposition.setSelectedIndex(0);
		}
	});
      btnedit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			btnopen.setEnabled(true);
			btnSave.setEnabled(true);
			tffullnameinsearch.setEditable(true);
			tfaddressinsearch.setEditable(true);
			
			tfageinsearch.setEditable(true);
			tfpasswordsearch.setEditable(true);
		   
		}
	});
      btnSave.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int iput = JOptionPane.showConfirmDialog(null, "Confirm ?","",JOptionPane.YES_NO_OPTION);
			if(iput==JOptionPane.YES_OPTION) {
			btnSave.setEnabled(false);
			btnopen.setEnabled(false);
			tffullnameinsearch.setEditable(false);
			tfaddressinsearch.setEditable(false);
			tfpasswordsearch.setEditable(false);
			tfageinsearch.setEditable(false);
			if(cbbpositioninsearch.getSelectedIndex()!=-1) {
		    if(cbbgenderinsearch.getSelectedIndex()!=-1) {
		    	String a="";
		    	String b="";
		    	try {
					b=fi.getAbsolutePath();
				} catch (Exception e2) {
					// TODO: handle exception
				}
		    
	            
		    			if(a.equals("")) {
		    			
		    					con.updateemployee(tffullnameinsearch.getText(), tfaddressinsearch.getText(),""+cbbgenderinsearch.getItemAt(cbbgenderinsearch.getSelectedIndex()), ""+cbbpositioninsearch.getItemAt(cbbpositioninsearch.getSelectedIndex()), Integer.parseInt(tfageinsearch.getText()), Integer.parseInt(tfidinsearch.getText()), ""+lbavatar.getIcon(),tfpasswordsearch.getText());
						
		    			}else {
				con.updateemployee(tffullnameinsearch.getText(), tfaddressinsearch.getText(),""+cbbgenderinsearch.getItemAt(cbbgenderinsearch.getSelectedIndex()), ""+cbbpositioninsearch.getItemAt(cbbpositioninsearch.getSelectedIndex()), Integer.parseInt(tfageinsearch.getText()), Integer.parseInt(tfidinsearch.getText()), a,tfpasswordsearch.getText());
		    }
		    }
			}
			}
		}
	});
      btnopen.addActionListener(new ActionListener() {
		
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
				lbavatar.setIcon(new ImageIcon(fi.getAbsolutePath()));
			}
		}
		
	});
      btnsearch.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tffullnameinsearch.setText("");
			tfaddressinsearch.setText("");
			tfageinsearch.setText("");
			tfusernamesearch.setText("");
			tfpasswordsearch.setText("");
			cbbgenderinsearch.setSelectedIndex(0);
			cbbpositioninsearch.setSelectedIndex(0);
			lbavatar.setIcon(null);
			ResultSet rs = con.searchemployee(Integer.parseInt(tfidinsearch.getText()));
			try {
				while(rs.next()) {
					tffullnameinsearch.setText(rs.getString(1));
					tfaddressinsearch.setText(rs.getString(2));
					for(int i=0;i<gender.length;i++) {
						if(gender[i].equals(rs.getString(3))) {
							cbbgenderinsearch.setSelectedIndex(i);
						}
					}
					for(int i=0;i<position.length;i++) {
						if(position[i].equals(rs.getString(4))) {
							cbbpositioninsearch.setSelectedIndex(i);
						}
					}
					
					tfageinsearch.setText(rs.getString(5));
					System.out.println(rs.getString(6));
					ImageIcon imic = new ImageIcon(""+rs.getString(6));
					lbavatar.setIcon(imic);
					tfusernamesearch.setText(rs.getString(7));
					tfpasswordsearch.setText(rs.getString(8));
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			if(tfageinsearch.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "No information","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	});
      btnquery.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			salarydtm.setRowCount(0);
			if(cbbpositioncacutlatelong.getSelectedIndex()!=-1) {
			ResultSet rs = con.getemployeebyposition(""+cbbpositioncacutlatelong.getItemAt(cbbpositioncacutlatelong.getSelectedIndex()));
			try {
				while(rs.next()) {
					String id = rs.getString(1);
					String fullname = rs.getString(2);
					String address = rs.getString(3);
					String gender = rs.getString(4);
					String position = rs.getString(5);
					String age = rs.getString(6);
					salarydtm.addRow(new String[] {id,fullname,address,gender,position,age});
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			if(salarydtm.getRowCount()==0) {
				JOptionPane.showMessageDialog(null, "No information","Error",JOptionPane.ERROR_MESSAGE);
			}
			}
			tfidincaculate.setText("");
			tffullnamecaculate.setText("");
			tfaddresscaculate.setText("");
			tfagecaculate.setText("");
			cbbpositioncaculate.setSelectedIndex(0);
			cbbgendercaculate.setSelectedIndex(0);
			tfdaysoffcaculate.setText("");
			}
	});
	tablesalary.addMouseListener(new MouseListener() {
		
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
			int row = tablesalary.getSelectedRow();
			tfidincaculate.setText(""+tablesalary.getValueAt(row, 0));
			tffullnamecaculate.setText(""+tablesalary.getValueAt(row, 1));
			tfaddresscaculate.setText(""+tablesalary.getValueAt(row, 2));
			tfagecaculate.setText(""+tablesalary.getValueAt(row, 5));
			for(int i=0;i<gender.length;i++) {
				if(gender[i].equals(""+tablesalary.getValueAt(row, 3))) {
					cbbgendercaculate.setSelectedIndex(i);
				}
			}
			for(int i=0;i<position.length;i++) {
				if(position[i].equals(""+tablesalary.getValueAt(row, 4))) {
					cbbpositioncaculate.setSelectedIndex(i);
				}
			}
		}
	});
	btncaculate.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			con.setSalary(Integer.parseInt(tfidincaculate.getText()),Integer.parseInt(""+cbbyear.getItemAt(cbbyear.getSelectedIndex())),Integer.parseInt(""+cbbmonth.getItemAt(cbbmonth.getSelectedIndex())),caculate());
		}
	});
	btnsubmitnews.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			con.putNew(textArea.getText());
			textArea.setText("");
		}
	});
	btnallemployee.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tableallemployee.setRowCount(0);
			setdataforallemployeetable();
			CardLayout c = (CardLayout)pncardindetail.getLayout();
			c.show(pncardindetail, "pnallemployee");
		}
	});
	btnShowSalary.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			CardLayout c = (CardLayout)pncardindetail.getLayout();
			c.show(pncardindetail, "pnshowsalary");
			dtmshowsalary.setRowCount(0);
			cbbmonthdetail.setSelectedIndex(0);
			cbbyeardetail.setSelectedIndex(0);
		}
	});
	btnchecknew.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tableallemployee.setRowCount(0);
			ResultSet rs = con.getemployeebyname(tfchecknew.getText());
			try {
				while(rs.next()) {
					tableallemployee.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
	});
	btnTopEmployee.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dtmtop.setRowCount(0);
			cbbtop.setSelectedIndex(0);
			cbbpss.setSelectedIndex(0);
			CardLayout c = (CardLayout)pncardindetail.getLayout();
			c.show(pncardindetail, "pntopemployee");
		}
	});
    btnbademployee.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dtmbad.setRowCount(0);
			setdataforbadtable();
			CardLayout c = (CardLayout)pncardindetail.getLayout();
			c.show(pncardindetail, "pnbademployee");
			if(dtmbad.getRowCount()==0) {
				JOptionPane.showMessageDialog(null, "No information","",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	});
    btnshowindetail.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dtmshowsalary.setRowCount(0);
			setdataforshowsalarybymonthandyear();
			if(dtmshowsalary.getRowCount()==0) {
				JOptionPane.showMessageDialog(pnshowsalary, "No information","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	});
    btncheck.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dtmtop.setRowCount(0);
			setdatafortoptable();
			if(dtmtop.getRowCount()==0) {
				JOptionPane.showMessageDialog(pnshowsalary, "No information","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	});
    btnall.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dtmall.setRowCount(0);
            setdataforallnotification();
			CardLayout c = (CardLayout)pncardnotification.getLayout();
			c.show(pncardnotification, "pnall");
		}
	});
    btnNew.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			txtarea.setText("");
			tfidsend.setText("");
			CardLayout c = (CardLayout)pncardnotification.getLayout();
			c.show(pncardnotification, "pnnew");
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
			
			int rowalla=tableall.getSelectedRow();
		   
		}
	});
    btnsend.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			con.insertnotification(txtarea.getText(), tfidsend.getText());
			txtarea.setText("");
			tfidsend.setText("");
		}
	});
    
    
	}
	public void setdataforbadtable() {
		ResultSet rs = con.getembad();
		try {
			while(rs.next()) {
				String id = rs.getString(1);
				String fullname = rs.getString(2);
				String address = rs.getString(3);
				String gender =rs.getString(4);
				String position = rs.getString(5);
				String age = rs.getString(6);
				dtmbad.addRow(new String[] {id,fullname,address,gender,position,age});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
    public void setdataforemtable() {
    	ResultSet rs =con.getAllemployee();
    	try {
			while(rs.next()) {
				String id = rs.getString(1);
				String fullname = rs.getString(2);
				String address = rs.getString(3);
				String gender = rs.getString(4);
				String position = rs.getString(5);
				String age = rs.getString(6);
				String username = rs.getString(8);
				String password = rs.getString(9);
				dtm.addRow(new String[] {id,fullname,address,gender,position,age,username,password});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

    public double caculate() {
    	double a=0;
    	if(cbbpositioncacutlatelong.getSelectedIndex()!=-1) {
    		if(cbbpositioncacutlatelong.getItemAt(cbbpositioncacutlatelong.getSelectedIndex()).equals("Chief executive officer")) {
    			a=100*calday();
    		}
    		if(cbbpositioncacutlatelong.getItemAt(cbbpositioncacutlatelong.getSelectedIndex()).equals("Chief financial officer")) {
    			a=90*calday();
    		}
    		if(cbbpositioncacutlatelong.getItemAt(cbbpositioncacutlatelong.getSelectedIndex()).equals("Chief information officer")) {
    			a=80*calday();
    		}
    		if(cbbpositioncacutlatelong.getItemAt(cbbpositioncacutlatelong.getSelectedIndex()).equals("Chief marketing officer")) {
    			a=70*calday();
    		}
    		if(cbbpositioncacutlatelong.getItemAt(cbbpositioncacutlatelong.getSelectedIndex()).equals("Chief operations officer")) {
    			a=60*calday();
    		}
    		if(cbbpositioncacutlatelong.getItemAt(cbbpositioncacutlatelong.getSelectedIndex()).equals("Human resources manager")) {
    			a=60*calday();
    		}
    		if(cbbpositioncacutlatelong.getItemAt(cbbpositioncacutlatelong.getSelectedIndex()).equals("Information technology manager")) {
    			a=70*calday();
    		}
    		if(cbbpositioncacutlatelong.getItemAt(cbbpositioncacutlatelong.getSelectedIndex()).equals("Markerting manager")) {
    			a=65*calday();
    		}
    		if(cbbpositioncacutlatelong.getItemAt(cbbpositioncacutlatelong.getSelectedIndex()).equals("Product manager")) {
    			a=75*calday();
    		}
    		if(cbbpositioncacutlatelong.getItemAt(cbbpositioncacutlatelong.getSelectedIndex()).equals("Sales manager")) {
    			a=85*calday();
    		}
    		if(cbbpositioncacutlatelong.getItemAt(cbbpositioncacutlatelong.getSelectedIndex()).equals("Administrative assistant")) {
    			a=90*calday();
    		}
    		if(cbbpositioncacutlatelong.getItemAt(cbbpositioncacutlatelong.getSelectedIndex()).equals("Bookkeeper")) {
    			a=60*calday();
    		}
    		if(cbbpositioncacutlatelong.getItemAt(cbbpositioncacutlatelong.getSelectedIndex()).equals("Business analyst")) {
    			a=75*calday();
    		}
    		if(cbbpositioncacutlatelong.getItemAt(cbbpositioncacutlatelong.getSelectedIndex()).equals("Sales representative")) {
    			a=45*calday();
    		}
    		if(cbbpositioncacutlatelong.getItemAt(cbbpositioncacutlatelong.getSelectedIndex()).equals("Software engineer")) {
    			a=120*calday();
    		}
    		}
    	return a;
    }
    public int calday() {
    	int a=daysalary();
    	return a-(Integer.parseInt(tfdaysoffcaculate.getText()));
    }
    public int daysalary() {
    	int c=28;
    	int d=0;
    	if(cbbyear.getSelectedIndex()!=-1) {
    		if(Integer.parseInt((String) cbbyear.getItemAt(cbbyear.getSelectedIndex()))%400==0) {
    			c=29;
    		}
    		if(Integer.parseInt((String) cbbyear.getItemAt(cbbyear.getSelectedIndex()))%4==0&&Integer.parseInt((String) cbbyear.getItemAt(cbbyear.getSelectedIndex()))%100!=0) {
    			c=29;
    		}
    		
    		
    	if(cbbmonth.getSelectedIndex()!=-1) {
    	         String a[]= {"1","3","5","7","8","10","12"};
    	         String b[]= {"4","6","9","11"};
    	         String e[]= {"2"};
    	        for(int i=0;i<7;i++) {
    	        	if(cbbmonth.getItemAt(cbbmonth.getSelectedIndex()).equals(a[i])) {
    	        		 d=31;
    	        	}
    	        	     }
    	        for(int i=0;i<4;i++) {
    	        	if(cbbmonth.getItemAt(cbbmonth.getSelectedIndex()).equals(b[i])) {
    	        		d=30;
    	        	}
    	        }
    	    	if(cbbmonth.getItemAt(cbbmonth.getSelectedIndex()).equals(e[0])) {
	        		d=c;
	        	}
    	}
    	}
		return d;
    }
    public void setdatafortoptable() {
    	if(cbbtop.getSelectedIndex()!=-1) {
    	if(cbbpss.getSelectedIndex()!=-1) {	
    	
    	ResultSet rs = con.getembytopandposition(Integer.parseInt((String) cbbtop.getItemAt(cbbtop.getSelectedIndex())), ""+cbbpss.getItemAt(cbbpss.getSelectedIndex()));
    	try {
			while(rs.next()) {
				String id = rs.getString(2);
				String fullname = rs.getString(3);
				String address = rs.getString(4);
				String gender = rs.getString(5);
				String position = rs.getString(6);
				String age = rs.getString(7);
				dtmtop.addRow(new String[] {id,fullname,address,gender,position,age});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    	}
    }
    public void setdataforallemployeetable() {
    	ResultSet rs = con.getAllemployee();
    	try {
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String gender = rs.getString(4);
				String position = rs.getString(5);
				String age = rs.getString(6);
				tableallemployee.addRow(new String[] {id,name,address,gender,position,age});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    public void setdataforshowsalarybymonthandyear() {
    	if(cbbmonthdetail.getSelectedIndex()!=-1) {
    		if(cbbyeardetail.getSelectedIndex()!=-1) {
    			ResultSet rs = con.getsalarybymonthandyear(Integer.parseInt(""+cbbmonthdetail.getItemAt(cbbmonthdetail.getSelectedIndex())), Integer.parseInt(""+cbbyeardetail.getItemAt(cbbyeardetail.getSelectedIndex())));
    			try {
					while(rs.next()) {
						String id = rs.getString(1);
						String name = rs.getString(2);
						String address = rs.getString(3);
						String gender = rs.getString(4);
						String position = rs.getString(5);
						String age = rs.getString(6);
						String month = rs.getString(7);
						String yaer = rs.getString(8);
						String money = rs.getString(9);
						dtmshowsalary.addRow(new String[] {id,name,address,gender,position,age,month,yaer,money});
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
    		}
    	}
    }
    public void setdataforallnotification() {
    	ResultSet rs = con.getallnotification("0");
    	try {
    		int a=0;
			while(rs.next()) {
				a++;
				String content = rs.getString(2);
				dtmall.addRow(new String[] {""+a,content});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    public void setdataforstarnotification() {
    	ResultSet rs = con.getnotificationtable("0", "Star");
    	try {
    		int a=0;
			while(rs.next()) {
				a++;
				String content = rs.getString(1);
				dtmstar.addRow(new String[] {""+a,content});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    public void setdataforbinnotification() {
    	ResultSet rs = con.getnotificationtable("0", "BIN");
    	try {
    		int a=0;
			while(rs.next()) {
				a++;
				String content = rs.getString(1);
				dtmbin.addRow(new String[] {""+a,content});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    public static CategoryDataset createDataset() {
    	con.setdataforlist1();
    	
    	final DefaultCategoryDataset dts = new DefaultCategoryDataset();
    	for(int i=0;i<con.getList1().size();i++) {
    		dts.addValue(Double.parseDouble(con.getList1().get(i).getMoney()), "Dollar", con.getList1().get(i).getYear());
    	}
    	return dts;
    }
    public static JFreeChart createChart() {
    	JFreeChart bar = ChartFactory.createBarChart("ANNUAL REVENUE", "Year", "Dollar",createDataset(),PlotOrientation.VERTICAL,false,false,false );
    	return bar;
    }
}
