package model;

import java.util.ArrayList;
import java.util.Objects;

public class notification {
 private int nid;
 private String ncontent;
 private int id;
 ArrayList<notification> noti = new ArrayList<notification>();
public ArrayList<notification> getNoti() {
	return noti;
}
public void setNoti(ArrayList<notification> noti) {
	this.noti = noti;
}
@Override
public int hashCode() {
	return Objects.hash(id, ncontent, nid);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	notification other = (notification) obj;
	return id == other.id && Objects.equals(ncontent, other.ncontent) && nid == other.nid;
}
public notification() {
	super();
	// TODO Auto-generated constructor stub
}
public notification(int nid, String ncontent, int id) {
	this.nid = nid;
	this.ncontent = ncontent;
	this.id = id;
}
public int getNid() {
	return nid;
}
public void setNid(int nid) {
	this.nid = nid;
}
public String getNcontent() {
	return ncontent;
}
public void setNcontent(String ncontent) {
	this.ncontent = ncontent;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
}
