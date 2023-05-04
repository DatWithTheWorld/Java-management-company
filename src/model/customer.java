package model;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.util.ArrayList;
import Connection.dbcontroller;
import View.framedisparch;
public class customer {
private int CID;
private String CFullname;
private String Cphone;
private String CEmail;
dbcontroller dbcon = new dbcontroller();
public static ArrayList<customer> cus = new ArrayList<customer>();
public ArrayList<customer> getCus() {
	return cus;
}
public void setCus(ArrayList<customer> cus) {
	this.cus = cus;
}
public customer(int cID, String cFullname, String cphone, String cEmail) {
	CID = cID;
	CFullname = cFullname;
	Cphone = cphone;
	CEmail = cEmail;
}
public customer() {
	super();
	// TODO Auto-generated constructor stub
}
public int getCID() {
	return CID;
}
public void setCID(int cID) {
	CID = cID;
}
public String getCFullname() {
	return CFullname;
}
public void setCFullname(String cFullname) {
	CFullname = cFullname;
}
public String getCphone() {
	return Cphone;
}
public void setCphone(String cphone) {
	Cphone = cphone;
}
public String getCEmail() {
	return CEmail;
}
public void setCEmail(String cEmail) {
	CEmail = cEmail;
}
public void setDataforlist() {
	ResultSet rs = dbcon.getCustomer();
	try {
		while(rs.next()) {
			int a = Integer.parseInt(rs.getString(1));
			String b = rs.getString(2);
			String c = rs.getString(3);
			String d = rs.getString(4);
			customer custom = new customer(a, b, c, d);
			cus.add(custom);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
}
public static int cnum() {
	customer cuss = new customer();
	cuss.setDataforlist();
int max = 0;
	for(int i=0;i<cus.size();i++) {
if(cus.get(i).getCID()>max) {
	max = cus.get(i).getCID();
}
}
	return max;
}
}
