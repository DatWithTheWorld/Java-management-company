package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import Connection.dbcontroller;
public class order {
private int  OId;
private double OMoney;
private String ODescription;
private int CID;
private int SID;
dbcontroller con = new dbcontroller();
ArrayList<order> orderlist = new ArrayList<order>();
public order(int oId, double oMoney, String oDescription, int cID, int sID) {
	OId = oId;
	OMoney = oMoney;
	ODescription = oDescription;
	CID = cID;
	SID = sID;
}
public order() {
	super();
	// TODO Auto-generated constructor stub
}
public int getOId() {
	return OId;
}
public void setOId(int oId) {
	OId = oId;
}
public double getOMoney() {
	return OMoney;
}
public void setOMoney(double oMoney) {
	OMoney = oMoney;
}
public String getODescription() {
	return ODescription;
}
public void setODescription(String oDescription) {
	ODescription = oDescription;
}
public int getCID() {
	return CID;
}
public void setCID(int cID) {
	CID = cID;
}
public int getSID() {
	return SID;
}
public void setSID(int sID) {
	SID = sID;
}


}
