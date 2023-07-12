	package View;

import java.awt.EventQueue;
import org.mindrot.jbcrypt.BCrypt;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.servlet.jsp.tagext.TryCatchFinally;
import javax.swing.Icon;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Calendar;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import com.toedter.calendar.JCalendar;

import Connection.dbcontroller;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.TextArea;
import java.awt.Label;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.JTextField;
import java.awt.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import model.*;

import javax.swing.JPasswordField;
public class MainPageView extends JFrame implements Runnable{
   employee employee = new employee();
	private JPanel contentPane;
	
	private JTable Newstables;
	private JTextField tfnamecus;
	private JTextField tfphonecus;
	private JTextField tfemailcus;
	private static JTextField tfusernamelogin;
	private  JCheckBox cbdesignbanner;
	private  JCheckBox cbdesignposter;
	private JCheckBox cbdesignlogo;
	private  JCheckBox cbpicture2d;
	private JCheckBox cbpicture3d;
	private JCheckBox cbeditservice ;
	private String billcustomeruse;
	private JTextArea textArea;
	private static Socket socket;
	public static JTextField getTfusernamelogin() {
		return tfusernamelogin;
	}

	public void setTfusernamelogin(JTextField tfusernamelogin) {
		this.tfusernamelogin = tfusernamelogin;
	}

	public static JPasswordField getTfpasswordlogin() {
		return tfpasswordlogin;
	}

	public void setTfpasswordlogin(JPasswordField tfpasswordlogin) {
		this.tfpasswordlogin = tfpasswordlogin;
	}

	private static BufferedReader reader;
	private static BufferedWriter writer;
	
	
	DefaultTableModel dtmnewstb = new DefaultTableModel();
	LostPassword lpw = new LostPassword();
	AdminPN admpn = new AdminPN();
	static EmployeePN emppn = new EmployeePN();
	dbcontroller con  = new dbcontroller();
	framedisparch fd = new framedisparch();
employee em = new employee();
private static JPasswordField tfpasswordlogin;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainPageView frame = new MainPageView();
					
					frame.setVisible(true);
					 try {
				            socket = new Socket("localhost", 1234);
				            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				            MessageReceiver messageReceiver = new MessageReceiver();
				            
				            messageReceiver.start();
				         

				        } catch (Exception e) {
				            e.printStackTrace();
				        }
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			   class MessageReceiver extends Thread {
			        public void run() {
			            try {
			                String message;
			                while ((message = reader.readLine()) != null) {
			                   emppn.getTxtarearequest().append(message + "\n");
			                }
			            } catch (Exception e) {
			                e.printStackTrace();
			            }
			        }
			    }
		});
	}
	
	 public static void sendMessage(String message) {
	        try {
	            writer.write(message);
	            writer.newLine();
	            writer.flush();
	            emppn.getTxtarearequest().append("Me: " + message + "\n"); // Hiển thị tin nhắn gửi đi trên giao diện của client
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	/**
	 * Create the frame.
	 */
	public MainPageView() {
		
		//em.SaveInforEmployee();
	   super("Design Company V1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1555,882);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel HomePageMain = new JPanel();
		contentPane.add(HomePageMain, "HomePageMain");
		HomePageMain.setLayout(null);
		contentPane.add(admpn, "adminPage");
		contentPane.add(emppn,"employeePage");
		
		JPanel BannerHomePageMain = new JPanel();
		BannerHomePageMain.setBounds(0, 0, 1550, 176);
		HomePageMain.add(BannerHomePageMain);
		BannerHomePageMain.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/building.jpg")));
		lblNewLabel.setBounds(0, 0, 1540, 176);
		BannerHomePageMain.add(lblNewLabel);
		
		JPanel MenuBarHomePageMain = new JPanel();
		MenuBarHomePageMain.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		MenuBarHomePageMain.setBounds(0, 176, 1540, 53);
		HomePageMain.add(MenuBarHomePageMain);
		MenuBarHomePageMain.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DESIGN COMPANY");
		lblNewLabel_1.setLabelFor(lblNewLabel_1);
		lblNewLabel_1.setBackground(Color.red);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 260, 53);
		MenuBarHomePageMain.add(lblNewLabel_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("    HOME");
		mntmNewMenuItem.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/iconhome.png")));
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem.setBounds(259, 10, 228, 33);
		MenuBarHomePageMain.add(mntmNewMenuItem);
		
		JMenuItem mntmNews = new JMenuItem("       NEWS");
		mntmNews.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/iconnews.png")));
		mntmNews.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNews.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
		mntmNews.setBounds(497, 10, 228, 33);
		MenuBarHomePageMain.add(mntmNews);
		
		JMenuItem mntmOrder = new JMenuItem("      ORDER");
		mntmOrder.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/iconorder.png")));
		mntmOrder.setHorizontalAlignment(SwingConstants.LEFT);
		mntmOrder.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
		mntmOrder.setBounds(750, 10, 228, 33);
		MenuBarHomePageMain.add(mntmOrder);
		
		JMenuItem mntmLogin = new JMenuItem("        Log In");
		mntmLogin.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/iconlogin.png")));
		mntmLogin.setHorizontalAlignment(SwingConstants.LEFT);
		mntmLogin.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
		mntmLogin.setBounds(1014, 10, 228, 33);
		MenuBarHomePageMain.add(mntmLogin);
		
		JPanel HomePageMainCardCenter = new JPanel();
		HomePageMainCardCenter.setBounds(0, 228, 1540, 617);
		HomePageMain.add(HomePageMainCardCenter);
		HomePageMainCardCenter.setLayout(new CardLayout(0, 0));
		
		JPanel MainCardCenterHome = new JPanel();
		HomePageMainCardCenter.add(MainCardCenterHome, "homeee");
		MainCardCenterHome.setLayout(null);
		
		JPanel BannerAndButtonWest = new JPanel();
		BannerAndButtonWest.setBackground(new Color(255, 255, 255));
		BannerAndButtonWest.setBounds(0, 0, 260, 617);
		MainCardCenterHome.add(BannerAndButtonWest);
		BannerAndButtonWest.setLayout(null);
		
		JButton btnCalander = new JButton("CALENDER");
		btnCalander.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnCalander.setBounds(0, 440, 260, 60);
	    btnCalander.setBackground(Color.white);
		BannerAndButtonWest.add(btnCalander);
		
		JButton btnHistory = new JButton("HISTORY");
		btnHistory.setBackground(new Color(255, 255, 255));
		btnHistory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnHistory.setBounds(0, 497, 260, 60);
		BannerAndButtonWest.add(btnHistory);
		
		JButton btnServices = new JButton("SERVICES");
		btnServices.setBackground(new Color(255, 255, 255));
		btnServices.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnServices.setBounds(0, 557, 260, 60);
		BannerAndButtonWest.add(btnServices);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/tetho.jpg")));
		lblNewLabel_2.setBounds(0, 0, 260, 442);
		BannerAndButtonWest.add(lblNewLabel_2);
		
		JPanel CardCenterInCardMain = new JPanel();
		CardCenterInCardMain.setBounds(259, 0, 1281, 617);
		MainCardCenterHome.add(CardCenterInCardMain);
		CardCenterInCardMain.setLayout(new CardLayout(0, 0));
		
		 JPanel CardHomeDe = new JPanel();
		 CardHomeDe.setBackground(new Color(255, 255, 128));
	        CardCenterInCardMain.add(CardHomeDe, "homeee");
	        CardHomeDe.setLayout(null);
	        
	        JLabel lblNewLabel_4 = new JLabel("DESIGN COMPANY");
	        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
	        lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
	        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_4.setBounds(462, 275, 399, 43);
	        CardHomeDe.add(lblNewLabel_4);
	        
	        JLabel lblNewLabel_5 = new JLabel("WE ARE HERE TO GIVE YOU THE BEST QUALITY SERVICE");
	        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
	        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_5.setBounds(405, 328, 520, 29);
	        CardHomeDe.add(lblNewLabel_5);
	        
	        JLabel lblNewLabel_6 = new JLabel("470 Tran Dai Nghia, Ngu Hanh Son, Da Nang, Viet Nam");
	        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
	        lblNewLabel_6.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/mapicon1.png")));
	        lblNewLabel_6.setBounds(103, 399, 501, 43);
	        CardHomeDe.add(lblNewLabel_6);
	        
	        JLabel lblNewLabel_8 = new JLabel("0826329970");
	        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
	        lblNewLabel_8.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/phone1.png")));
	        lblNewLabel_8.setBounds(103, 495, 291, 29);
	        CardHomeDe.add(lblNewLabel_8);
	        
	        JLabel lblNewLabel_9 = new JLabel("https://www.facebook.com/profile.php?id=100029356732191");
	        lblNewLabel_9.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/facbook.png")));
	        lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
	        lblNewLabel_9.setBounds(103, 536, 635, 34);
	        CardHomeDe.add(lblNewLabel_9);
	        
	        JLabel lblNewLabel_3 = new JLabel("");
	        lblNewLabel_3.setBounds(0, 0, 1281, 260);
	        CardHomeDe.add(lblNewLabel_3);
	        lblNewLabel_3.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/homepicture.jpg")));
	        
	        JLabel lblNewLabel_7 = new JLabel("datnd.22git@vku.udn.vn");
	        lblNewLabel_7.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/emailicon1.png")));
	        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
	        lblNewLabel_7.setBounds(103, 449, 507, 36);
	        CardHomeDe.add(lblNewLabel_7);
		
		JPanel CardCalender = new JPanel();
		CardCalender.setBackground(new Color(255, 255, 0));
		CardCenterInCardMain.add(CardCalender, "calander");
		CardCalender.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		calendar.setBounds(100, 79, 698, 465);
	
		CardCalender.add(calendar);
		
		JPanel card2dclock = new JPanel();
		card2dclock.setBackground(new Color(255, 255, 0));
		card2dclock.setBounds(880, 135, 401, 322);
		CardCalender.add(card2dclock);
		  Clock2d clock2d = new Clock2d();
		  clock2d.setBackground(new Color(255, 255, 0));
	        clock2d.setPreferredSize(new Dimension(320, 320));
	        clock2d.init();
	        card2dclock.add(clock2d);
	        
	        JPanel CardHistory = new JPanel();
	        CardHistory.setBackground(new Color(255, 255, 0));
	        CardCenterInCardMain.add(CardHistory, "cardHistory");
	        CardHistory.setLayout(null);
	        
	        JTextArea txtrWeWereEstablished = new JTextArea();
	        txtrWeWereEstablished.setEditable(false);
	        txtrWeWereEstablished.setBackground(new Color(255, 255, 0));
	        txtrWeWereEstablished.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
	        txtrWeWereEstablished.setText("We were established in 2021/09/01 by a team of nearly 30 people\r\nIn the early stages, we started with small jobs like editing and processing \r\ndefective products from customers.\r\n After a period of accumulation of experience, we launched the first \r\nproducts under our company's \r\ncopyright in the first months of 2022. \r\nExperience and credibility have made us quickly catch up with market \r\nand since then many partnersknow us \r\neven though we have only been established for about 2 years");
	        txtrWeWereEstablished.setBounds(31, 99, 773, 315);
	        CardHistory.add(txtrWeWereEstablished);
	        
	        JLabel lblNewLabel_10 = new JLabel("");
	        lblNewLabel_10.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/building11.jpg")));
	        lblNewLabel_10.setBounds(869, 0, 412, 617);
	        CardHistory.add(lblNewLabel_10);
	        
	        JPanel CardServices = new JPanel();
	        CardServices.setBackground(new Color(255, 255, 0));
	        CardCenterInCardMain.add(CardServices, "cardservices");
	        CardServices.setLayout(null);
	        
	        JTextArea txtrcreateNewDesign = new JTextArea();
	        txtrcreateNewDesign.setEditable(false);
	        txtrcreateNewDesign.setText("-Create New Design\r\n-Design Banner\r\n-Design Poster\r\n-Design Logo \r\n-Edit Banner\r\n-Edit Poster\r\n-Edit Logo\r\n-Draw \r\n-Create picture 2D\r\n-Create picture 3D");
	        txtrcreateNewDesign.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 28));
	        txtrcreateNewDesign.setBackground(new Color(255, 255, 0));
	        txtrcreateNewDesign.setBounds(94, 95, 341, 424);
	        CardServices.add(txtrcreateNewDesign);
	        
	        JLabel lblNewLabel_11 = new JLabel("");
	        lblNewLabel_11.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/banner1.png")));
	        lblNewLabel_11.setBounds(527, 28, 357, 185);
	        CardServices.add(lblNewLabel_11);
	        
	        JLabel lblNewLabel_11_1 = new JLabel("");
	        lblNewLabel_11_1.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/bannerr.jpg")));
	        lblNewLabel_11_1.setBounds(894, 28, 357, 185);
	        CardServices.add(lblNewLabel_11_1);
	        
	        JLabel lblNewLabel_12 = new JLabel("");
	        lblNewLabel_12.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/poster1.jpg")));
	        lblNewLabel_12.setBounds(527, 223, 357, 384);
	        CardServices.add(lblNewLabel_12);
	        
	        JLabel lblNewLabel_12_1 = new JLabel("");
	        lblNewLabel_12_1.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/poster.jpg")));
	        lblNewLabel_12_1.setBounds(894, 223, 357, 384);
	        CardServices.add(lblNewLabel_12_1);
	        
	        JPanel NewsCard = new JPanel();
	        HomePageMainCardCenter.add(NewsCard, "cardNews");
	        NewsCard.setLayout(null);
	        
	        JPanel pnSttNews = new JPanel();
	        pnSttNews.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 255, 255)));
	        pnSttNews.setBackground(new Color(255, 255, 0));
	        pnSttNews.setBounds(0, 0, 256, 617);
	        NewsCard.add(pnSttNews);
	        pnSttNews.setLayout(null);
	        
	        JLabel lblNewLabel_13 = new JLabel("NEWS");
	        lblNewLabel_13.setBackground(new Color(0, 255, 255));
	        lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
	        lblNewLabel_13.setBounds(0, 0, 256, 60);
	        pnSttNews.add(lblNewLabel_13);
	        dtmnewstb.addColumn("Number");
	        dtmnewstb.addColumn("Content");
	        PutNews();
	        Newstables = new JTable(dtmnewstb);
	        Newstables.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        Newstables.setBackground(new Color(255, 255, 255));
	        
	        
	        JScrollPane scrollPane = new JScrollPane(Newstables);
	        
	        //
	       
	        
	        scrollPane.setBounds(0, 50, 256, 567);
	        pnSttNews.add(scrollPane);
	        
	        JPanel pnDetailNew = new JPanel();
	        pnDetailNew.setBackground(new Color(255, 255, 0));
	        pnDetailNew.setBounds(255, 0, 1285, 617);
	        NewsCard.add(pnDetailNew);
	        pnDetailNew.setLayout(null);
	        
	        JLabel lblNewLabel_15 = new JLabel("");
	        lblNewLabel_15.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/buiding3.jpg")));
	        lblNewLabel_15.setBounds(939, 0, 346, 617);
	        pnDetailNew.add(lblNewLabel_15);
	        
	        JTextArea textArea_1 = new JTextArea();
	        textArea_1.setFont(new Font("Monospaced", Font.BOLD, 18));
	        textArea_1.setBackground(new Color(255, 255, 204));
	        textArea_1.setBounds(10, 10, 919, 597);
	        pnDetailNew.add(textArea_1);
	        
	        JPanel OrderCard = new JPanel();
	        OrderCard.setBackground(new Color(255, 255, 0));
	        HomePageMainCardCenter.add(OrderCard, "ordercard");
	        OrderCard.setLayout(null);
	        
	        JPanel pnOrder = new JPanel();
	        pnOrder.setBackground(new Color(255, 255, 255));
	        pnOrder.setBounds(262, 24, 1017, 570);
	        OrderCard.add(pnOrder);
	        pnOrder.setLayout(null);
	        
	        JLabel lbNameCus = new JLabel("Name");
	        lbNameCus.setFont(new Font("Tahoma", Font.BOLD, 20));
	        lbNameCus.setHorizontalAlignment(SwingConstants.CENTER);
	        lbNameCus.setBounds(10, 61, 87, 35);
	        pnOrder.add(lbNameCus);
	        
	        tfnamecus = new JTextField();
	        tfnamecus.setBounds(107, 61, 322, 35);
	        pnOrder.add(tfnamecus);
	        tfnamecus.setColumns(10);
	        
	        JLabel lbPhoneCus = new JLabel("Phone");
	        lbPhoneCus.setHorizontalAlignment(SwingConstants.CENTER);
	        lbPhoneCus.setFont(new Font("Tahoma", Font.BOLD, 20));
	        lbPhoneCus.setBounds(10, 106, 87, 35);
	        pnOrder.add(lbPhoneCus);
	        
	        tfphonecus = new JTextField();
	        tfphonecus.setColumns(10);
	        tfphonecus.setBounds(107, 106, 322, 35);
	        pnOrder.add(tfphonecus);
	        
	        JLabel lbEmailCus = new JLabel("Email");
	        lbEmailCus.setHorizontalAlignment(SwingConstants.CENTER);
	        lbEmailCus.setFont(new Font("Tahoma", Font.BOLD, 20));
	        lbEmailCus.setBounds(10, 151, 87, 35);
	        pnOrder.add(lbEmailCus);
	        
	        tfemailcus = new JTextField();
	        tfemailcus.setColumns(10);
	        tfemailcus.setBounds(107, 151, 322, 35);
	        pnOrder.add(tfemailcus);
	        
	        JLabel lblNewLabel_14 = new JLabel("SERVICES");
	        lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
	        lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_14.setBounds(105, 206, 218, 60);
	        pnOrder.add(lblNewLabel_14);
	        
	        JLabel lblNewLabel_14_1 = new JLabel("CONTACT");
	        lblNewLabel_14_1.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_14_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
	        lblNewLabel_14_1.setBounds(119, 10, 218, 60);
	        pnOrder.add(lblNewLabel_14_1);
	        
	        JPanel panel = new JPanel();
	        panel.setBackground(new Color(255, 255, 255));
	        panel.setBounds(34, 286, 403, 274);
	        pnOrder.add(panel);
	        panel.setLayout(new GridLayout(3, 2, 0, 0));
	        
	        cbdesignbanner = new JCheckBox("Design Banner");
	        cbdesignbanner.setBackground(new Color(255, 255, 255));
	        panel.add(cbdesignbanner);
	        cbdesignbanner.setHorizontalAlignment(SwingConstants.LEFT);
	        cbdesignbanner.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
	        
	        cbdesignposter = new JCheckBox("Design Poster");
	        cbdesignposter.setBackground(new Color(255, 255, 255));
	        panel.add(cbdesignposter);
	        cbdesignposter.setHorizontalAlignment(SwingConstants.LEFT);
	        cbdesignposter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
	        
	        cbdesignlogo = new JCheckBox("Design Logo");
	        cbdesignlogo.setBackground(new Color(255, 255, 255));
	        panel.add(cbdesignlogo);
	        cbdesignlogo.setHorizontalAlignment(SwingConstants.LEFT);
	        cbdesignlogo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
	        
	        cbpicture2d = new JCheckBox("Picture 2D");
	        cbpicture2d.setBackground(new Color(255, 255, 255));
	        panel.add(cbpicture2d);
	        cbpicture2d.setHorizontalAlignment(SwingConstants.LEFT);
	        cbpicture2d.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
	        
	        cbpicture3d = new JCheckBox("Picture 3D");
	        cbpicture3d.setBackground(new Color(255, 255, 255));
	        panel.add(cbpicture3d);
	        cbpicture3d.setHorizontalAlignment(SwingConstants.LEFT);
	        cbpicture3d.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
	        
	        cbeditservice = new JCheckBox("Edit");
	        cbeditservice.setBackground(new Color(255, 255, 255));
	        panel.add(cbeditservice);
	        cbeditservice.setHorizontalAlignment(SwingConstants.LEFT);
	        cbeditservice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
	        
	        JButton btnsubmitservice = new JButton("Submit");
	        btnsubmitservice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
	        btnsubmitservice.setBounds(823, 525, 130, 35);
	        pnOrder.add(btnsubmitservice);
	        
	        JButton btnPreviewServices = new JButton("Preview");
	        btnPreviewServices.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
	        btnPreviewServices.setBounds(537, 525, 130, 35);
	        pnOrder.add(btnPreviewServices);
	        
	        JPanel pnReportServices = new JPanel();
	        pnReportServices.setBackground(new Color(255, 255, 153));
	        pnReportServices.setBorder(new LineBorder(new Color(0, 255, 255), 4));
	        pnReportServices.setBounds(519, 33, 447, 457);
	        pnOrder.add(pnReportServices);
	        pnReportServices.setLayout(null);
	        
	        textArea = new JTextArea();
	        textArea.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
	        textArea.setBackground(new Color(255, 255, 153));
	        textArea.setBounds(10, 10, 427, 437);
	        pnReportServices.add(textArea);
	        
	        JButton btnCancelServices = new JButton("Cancel");
	        btnCancelServices.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
	        btnCancelServices.setBounds(683, 525, 130, 35);
	        pnOrder.add(btnCancelServices);
	        
	        JPanel LogIn = new JPanel();
	        HomePageMainCardCenter.add(LogIn, "cardLogin");
	        LogIn.setLayout(null);
	        
	        String object[]= {"Admin","Employee"};
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBackground(new Color(153, 255, 255));
	        panel_1.setBounds(491, 185, 590, 220);
	        LogIn.add(panel_1);
	        panel_1.setLayout(null);
	        
	        JLabel lblNewLabel_16 = new JLabel("User name : ");
	        lblNewLabel_16.setBounds(10, 10, 163, 50);
	        panel_1.add(lblNewLabel_16);
	        lblNewLabel_16.setForeground(new Color(0, 0, 0));
	        lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 20));
	        lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
	        
	        tfusernamelogin = new JTextField();
	        tfusernamelogin.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
	        tfusernamelogin.setBackground(new Color(240, 248, 255));
	        tfusernamelogin.setBounds(161, 16, 365, 38);
	        panel_1.add(tfusernamelogin);
	        tfusernamelogin.setColumns(10);
	        
	        JLabel lblNewLabel_16_1 = new JLabel("Password   : ");
	        lblNewLabel_16_1.setBounds(11, 51, 163, 50);
	        panel_1.add(lblNewLabel_16_1);
	        lblNewLabel_16_1.setForeground(new Color(0, 0, 0));
	        lblNewLabel_16_1.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_16_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	        
	        JLabel lbforgotpass = new JLabel("Forgot your password ?");
	        lbforgotpass.setBackground(new Color(204, 0, 102));
	        lbforgotpass.setBounds(44, 111, 213, 24);
	        panel_1.add(lbforgotpass);
	        lbforgotpass.setForeground(new Color(204, 0, 153));
	        lbforgotpass.setFont(new Font("Tahoma", Font.BOLD, 17));
	       
	        
	        JButton btnNewButton = new JButton("OK");
	        btnNewButton.setForeground(new Color(204, 0, 102));
	        btnNewButton.setBackground(new Color(153, 255, 255));
	        btnNewButton.setBounds(445, 158, 131, 38);
	        panel_1.add(btnNewButton);
	        btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
	        
	        JLabel lblNewLabel_18 = new JLabel("");
	        lblNewLabel_18.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/backgroundLogin.jpg")));
	        lblNewLabel_18.setBounds(0, 0, 1540, 617);
	        LogIn.add(lblNewLabel_18);
	       
	        JComboBox cbselectlogin = new JComboBox(object);
	        cbselectlogin.setForeground(new Color(153, 0, 255));
	        cbselectlogin.setBackground(new Color(255, 255, 255));
	        cbselectlogin.setBounds(454, 107, 122, 45);
	        panel_1.add(cbselectlogin);
	        cbselectlogin.setFont(new Font("Tahoma", Font.BOLD, 16));
	       tfusernamelogin.setText("Username");
	       
	       JLabel lbeye = new JLabel("");
	       lbeye.setHorizontalAlignment(SwingConstants.CENTER);
	       lbeye.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/eyee.png")));
	       lbeye.setBounds(536, 65, 45, 31);
	       panel_1.add(lbeye);
	       
	       tfpasswordlogin = new JPasswordField();
	       tfpasswordlogin.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
	       tfpasswordlogin.setBounds(161, 64, 365, 31);
	       panel_1.add(tfpasswordlogin);
	       
	       JButton btnqr = new JButton("QR SCAN");
	       btnqr.setBounds(44, 151, 122, 45);
	       panel_1.add(btnqr);
	        lbeye.addMouseListener(new MouseListener() {
				
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
					lbeye.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/eyee.png")));
					tfpasswordlogin.setEchoChar('*');
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					lbeye.setIcon(new ImageIcon(MainPageView.class.getResource("/img1/eyee-open.png")));
					tfpasswordlogin.setEchoChar((char)0);
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					 
				}
			});
	       tfusernamelogin.addMouseListener(new MouseListener() {
			
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
				tfusernamelogin.setText("");
			}
		});
	      tfpasswordlogin.addMouseListener(new MouseListener() {
			
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
				tfpasswordlogin.setText("");
			}
		});
	      ////
	    	   
	    	   
	    	   ////
	    	   
	    	   ////
	    	   
	        
	    	   /// Login 
	        btnNewButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				String hashedPassword = BCrypt.hashpw(tfpasswordlogin.getText(), BCrypt.gensalt());
                ResultSet rsg = con.getpassword(tfusernamelogin.getText());
                String passwordx = "";
                boolean matched = false;
                try {
					while(rsg.next()) {
						matched = BCrypt.checkpw(tfpasswordlogin.getText(), rsg.getString(1));
						passwordx = rsg.getString(1);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
               
				ResultSet rs = con.getembyusnameandpass(tfusernamelogin.getText(), passwordx);
				try {
					while(rs.next()) {
					emppn.getTfusernamemain().setText(rs.getString(8));
					emppn.getTfpasswordmain().setText(tfpasswordlogin.getText());
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
					if(cbselectlogin.getSelectedIndex()!=-1) {
					CardLayout c1 = (CardLayout)contentPane.getLayout();
					if(cbselectlogin.getItemAt(cbselectlogin.getSelectedIndex()).equals("Admin")) {
					if(tfusernamelogin.getText().equals("admin")) {
						if(tfpasswordlogin.getText().equals("admin")) {
					c1.show(contentPane, "adminPage");
					CardLayout c2 = (CardLayout)admpn.getPncardadmin().getLayout();
					c2.show(admpn.getPncardadmin(), "pnhome");
					}else {
						JOptionPane.showMessageDialog(LogIn,"Wrong password","Error",JOptionPane.ERROR_MESSAGE);
					}
						
					}else{
						JOptionPane.showMessageDialog(LogIn, "Wrong username","Error",JOptionPane.ERROR_MESSAGE);
					}
					}
//					 boolean matched = BCrypt.checkpw(emppn.getTfpasswordmain().getText(), hashedPassword);
					 if(matched==true) {
							if(cbselectlogin.getItemAt(cbselectlogin.getSelectedIndex()).equals("Employee")) {
								
								if(emppn.getTfusernamemain().getText().equals("")||emppn.getTfpasswordmain().getText().equals("")) {
									JOptionPane.showMessageDialog(LogIn, "Wrong password or username","Error",JOptionPane.ERROR_MESSAGE);
									
								}else {
									emppn.setdata();
									c1.show(contentPane, "employeePage");	
									CardLayout c3 = (CardLayout)emppn.getPncardemployee().getLayout();
									c3.show(emppn.getPncardemployee(), "pnaccount");
								}
								}
		                }
				
				}
			}
		});
	        //
	        ////
	       
	       
	       btnCalander.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			CardLayout c1 = (CardLayout)CardCenterInCardMain.getLayout();
			c1.show(CardCenterInCardMain, "calander");
			}
		});
	  mntmNewMenuItem.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			CardLayout c1 = (CardLayout)CardCenterInCardMain.getLayout();
			c1.show(CardCenterInCardMain, "homeee");
			CardLayout c2 = (CardLayout)HomePageMainCardCenter.getLayout();
			c2.show(HomePageMainCardCenter, "homeee");
		}
	});
	  btnHistory.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			CardLayout c1 = (CardLayout)CardCenterInCardMain.getLayout();
			c1.show(CardCenterInCardMain, "cardHistory");
		}
	});
	  btnServices.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			CardLayout c1 = (CardLayout)CardCenterInCardMain.getLayout();
			c1.show(CardCenterInCardMain, "cardservices");
		}
	});
		mntmNews.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dtmnewstb.setRowCount(0);
                PutNews();
				CardLayout c2 = (CardLayout)HomePageMainCardCenter.getLayout();
				c2.show(HomePageMainCardCenter, "cardNews");
			}
		});
		mntmOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout c2 = (CardLayout)HomePageMainCardCenter.getLayout();
				c2.show(HomePageMainCardCenter, "ordercard");
			}
		});
	mntmLogin.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tfpasswordlogin.setText("Password");
			tfusernamelogin.setText("Username");
			CardLayout c2 = (CardLayout)HomePageMainCardCenter.getLayout();
			c2.show(HomePageMainCardCenter, "cardLogin");
		}
	});
	btnqr.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Camera cam = new Camera();
			cam.setVisible(true);
			Thread thread = new Thread(cam);
			thread.start();
		}
	});
	lbforgotpass.addMouseListener(new MouseListener() {
		
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
			
			HomePageMainCardCenter.add(lpw,"forgotpass");
			
			CardLayout c2 = (CardLayout)HomePageMainCardCenter.getLayout();
			c2.show(HomePageMainCardCenter, "forgotpass");
			
			
		}
	});
            lpw.getBtnOut().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CardLayout c2 = (CardLayout)HomePageMainCardCenter.getLayout();
					c2.show(HomePageMainCardCenter, "cardLogin");
				}
			});
            admpn.getMnlogout().addMouseListener(new MouseListener() {
				
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
					//admpn.getDtm().setRowCount(0);
					CardLayout c1 = (CardLayout)contentPane.getLayout();
					c1.show(contentPane, "HomePageMain");
					CardLayout c2 = (CardLayout)CardCenterInCardMain.getLayout();
					c2.show(CardCenterInCardMain, "homeee");
					CardLayout c3 = (CardLayout)HomePageMainCardCenter.getLayout();
					c3.show(HomePageMainCardCenter, "homeee");
					tfusernamelogin.setText("");
					tfpasswordlogin.setText("");
				}
			});
            emppn.getMntmLogOut().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CardLayout c1 = (CardLayout)contentPane.getLayout();
					c1.show(contentPane, "HomePageMain");
					CardLayout c2 = (CardLayout)CardCenterInCardMain.getLayout();
					c2.show(CardCenterInCardMain, "homeee");
					CardLayout c3 = (CardLayout)HomePageMainCardCenter.getLayout();
					c3.show(HomePageMainCardCenter, "homeee");
					emppn.getTfusernamemain().setText("");
					emppn.getTfpasswordmain().setText("");
					tfusernamelogin.setText("");
					tfpasswordlogin.setText("");
				}
			});
            
            //preview button
		btnPreviewServices.addActionListener(new ActionListener() {
			public int check() {
				String a = "";
				String b="";
				int pri= 0;
				billcustomeruse=(String)"CUSTOMER \n\n Name : "+tfnamecus.getText()+"\n Email : "+tfemailcus.getText()+"\n Phone number : "+tfphonecus.getText()+"\n\n SERVICES \n\n";
				if(cbdesignbanner.isSelected()) {
					billcustomeruse+="\t"+cbdesignbanner.getText()+"\n";
					b=cbdesignbanner.getText();
					pri+=20;
				}
				if(cbdesignlogo.isSelected()) {
					billcustomeruse+="\t"+cbdesignlogo.getText()+"\n";
					b=cbdesignlogo.getText();
					pri+=30;
				}
				if(cbdesignposter.isSelected()) {
					billcustomeruse+="\t"+cbdesignposter.getText()+"\n";
					b=cbdesignposter.getText();
				    pri+=50;
				}
				if(cbeditservice.isSelected()) {
					billcustomeruse+="\t"+cbeditservice.getText()+"\n";
					b=cbeditservice.getText();
				    pri+=20;
				}
				if(cbpicture2d.isSelected()) {
					billcustomeruse+="\t"+cbpicture2d.getText()+"\n";
					b=cbpicture2d.getText();
				   pri+=100;
				}
				if(cbpicture3d.isSelected()) {
					billcustomeruse+="\t"+cbpicture3d.getText()+"\n";
					b=cbpicture3d.getText();
				   pri+=200;
				}
				billcustomeruse+="\nPRICE :  "+pri+" $";
				pri=0;
				if(tfemailcus.getText().equals(a)||tfnamecus.getText().equals(a)||tfphonecus.getText().equals(a)) {
					//JOptionPane.showMessageDialog(null,"Please fill all the informations", "Wrong input", JOptionPane.ERROR_MESSAGE);
					return 1;
					}
				if(b.equals(a)) {
					JOptionPane.showMessageDialog(null,"No service is selected", "Wrong input", JOptionPane.ERROR_MESSAGE);
				return 2;
				}
				return 0;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(check()==1) {
				JOptionPane.showMessageDialog(null,"Please fill all the informations", "Wrong input", JOptionPane.ERROR_MESSAGE);
				
				}
				if(check()==2) {
					JOptionPane.showMessageDialog(null,"No service is selected", "Wrong input", JOptionPane.ERROR_MESSAGE);
				}
				if(check()==0) {
				System.out.println(billcustomeruse);
				textArea.setText(billcustomeruse);
				billcustomeruse="";
			
				}
			}
		});
		btnCancelServices.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			
				if(JOptionPane.showConfirmDialog(null, "Clear all ?", "Clear", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
			tfemailcus.setText("");
			tfnamecus.setText("");
			tfphonecus.setText("");
			textArea.setText("");
			cbdesignbanner.setSelected(false);
			cbdesignlogo.setSelected(false);
			cbdesignposter.setSelected(false);
			cbeditservice.setSelected(false);
			cbpicture2d.setSelected(false);
			cbpicture3d.setSelected(false);
				}
			
			}
		});
		btnsubmitservice.addActionListener(new ActionListener() {
			public int check() {
				String a = "";
				String b="";
		        int pri= 0;
				String sid="";
				billcustomeruse=(String)"CUSTOMER \n\n Name : "+tfnamecus.getText()+"\n Email : "+tfemailcus.getText()+"\n Phone number : "+tfphonecus.getText()+"\n\n SERVICES \n\n";
				if(cbdesignbanner.isSelected()) {
					billcustomeruse+="\t"+cbdesignbanner.getText()+"\n";
					b=cbdesignbanner.getText();
					pri+=20;
					if(sid.equals(a)) {sid+="1";}else {
						sid+=",1";
						}
				}
				if(cbdesignlogo.isSelected()) {
					billcustomeruse+="\t"+cbdesignlogo.getText()+"\n";
					b=cbdesignlogo.getText();
					pri+=30;
					if(sid.equals(a)) {
						sid+="2";
					}else {
					sid+=",2";
					}
				}
				if(cbdesignposter.isSelected()) {
					billcustomeruse+="\t"+cbdesignposter.getText()+"\n";
					b=cbdesignposter.getText();
				    pri+=50;
				    if(sid.equals(a)) {sid+="3";}else {
						sid+=",3";
						}
				}
				if(cbeditservice.isSelected()) {
					billcustomeruse+="\t"+cbeditservice.getText()+"\n";
					b=cbeditservice.getText();
				    pri+=20;
				    if(sid.equals(a)) {sid+="4";}else {
						sid+=",4";
						}
				}
				if(cbpicture2d.isSelected()) {
					billcustomeruse+="\t"+cbpicture2d.getText()+"\n";
					b=cbpicture2d.getText();
				   pri+=100;
				   if(sid.equals(a)) {sid+="5";}else {
						sid+=",5";
						}
				}
				if(cbpicture3d.isSelected()) {
					billcustomeruse+="\t"+cbpicture3d.getText()+"\n";
					b=cbpicture3d.getText();
				   pri+=200;
				   if(sid.equals(a)) {sid+="6";}else {
						sid+=",6";
						}
				}
				billcustomeruse+="\nPRICE :  "+pri+" $";
				
				if(tfemailcus.getText().equals(a)||tfnamecus.getText().equals(a)||tfphonecus.getText().equals(a)) {
					//JOptionPane.showMessageDialog(null,"Please fill all the informations", "Wrong input", JOptionPane.ERROR_MESSAGE);
					return 1;
					}
				if(b.equals(a)) {
					JOptionPane.showMessageDialog(null,"No service is selected", "Wrong input", JOptionPane.ERROR_MESSAGE);
				return 2;
				}
				return 0;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String a = "";
				String b="";
		        double pri= 0;
				String[] c = new String[6];
				double[] d = new double[6];
				int i=-1;
				billcustomeruse=(String)"CUSTOMER \n\n Name : "+tfnamecus.getText()+"\n Email : "+tfemailcus.getText()+"\n Phone number : "+tfphonecus.getText()+"\n\n SERVICES \n\n";
				if(cbdesignbanner.isSelected()) {
					billcustomeruse+="\t"+cbdesignbanner.getText()+"\n";
					b=cbdesignbanner.getText();
					pri+=20;
					i++;
					c[i]="1";
					d[i]=20;
					
				}
				if(cbdesignlogo.isSelected()) {
					billcustomeruse+="\t"+cbdesignlogo.getText()+"\n";
					b=cbdesignlogo.getText();
					pri+=30;
					i++;
					c[i]="2";
					d[i]=30;
				}
				if(cbdesignposter.isSelected()) {
					billcustomeruse+="\t"+cbdesignposter.getText()+"\n";
					b=cbdesignposter.getText();
				    pri+=50;
				    i++;
					c[i]="3";
					d[i]=50;
				}
				if(cbeditservice.isSelected()) {
					billcustomeruse+="\t"+cbeditservice.getText()+"\n";
					b=cbeditservice.getText();
				    pri+=20;
				    i++;
					c[i]="4";
					d[i]=20;
				}
				if(cbpicture2d.isSelected()) {
					billcustomeruse+="\t"+cbpicture2d.getText()+"\n";
					b=cbpicture2d.getText();
				   pri+=100;
				   i++;
					c[i]="5";
					d[i]=100;
				}
				if(cbpicture3d.isSelected()) {
					billcustomeruse+="\t"+cbpicture3d.getText()+"\n";
					b=cbpicture3d.getText();
				   pri+=200;
				   i++;
					c[i]="6";
					d[i]=200;
				}
				int anum=0;
				billcustomeruse+="\nPRICE :  "+pri+" $";
				String emailred = "^[\\w-]+@([\\w- ]+\\.)+[\\w-]+$";
				String number = "^-?\\d+$";
				
				if(check()==1) {
					JOptionPane.showMessageDialog(null,"Please fill all the informations", "Wrong input", JOptionPane.ERROR_MESSAGE);
					
					}
					if(check()==2) {
						JOptionPane.showMessageDialog(null,"No service is selected", "Wrong input", JOptionPane.ERROR_MESSAGE);
					}
					if(check()==0) {
						ResultSet grs = con.getnumorder();
						try {
						    while(grs.next()) {
						    anum = grs.getInt(1)+1;
						    	
						    }
						} catch (Exception e2) {
							// TODO: handle exception
						}
						
						
						
						con.insertcustomer(tfnamecus.getText(), tfphonecus.getText(), tfemailcus.getText());
						for(int y=0;y<i+1;y++) {
							
							con.insertorder(anum,d[y], billcustomeruse,c[y]);
							anum++;
							
							
						}
						 con.insertnotification("New "+billcustomeruse, "0");
						  fd.setVisible(true);
						  fd.getLbpay().setText("");
		                  tfemailcus.setText("");
		      			tfnamecus.setText("");
		      			tfphonecus.setText("");
		      			textArea.setText("");
		      			cbdesignbanner.setSelected(false);
		      			cbdesignlogo.setSelected(false);
		      			cbdesignposter.setSelected(false);
		      			cbeditservice.setSelected(false);
		      			cbpicture2d.setSelected(false);
		      			cbpicture3d.setSelected(false);
                             
				
					}
				                
			}
		});
                Newstables.addMouseListener(new MouseListener() {
					
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
						int row = Newstables.getSelectedRow();
						String a = (String)Newstables.getValueAt(row, 0);
						String b = (String)Newstables.getValueAt(row, 1);
						String c = "\tNews : "+a+"\n\n\t"+b;
						textArea_1.setText(c);
					}
				});
               
	}
	 
	 //put news into table news
    public void PutNews() {
    	  ResultSet rs = con.getNews();
    	  int i=1;
    	    try {
				while(rs.next()) {
					dtmnewstb.addRow(new String[] {""+i,rs.getString(2)});
					i++;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
    }
 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
