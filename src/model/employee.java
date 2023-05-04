package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;
import Connection.dbcontroller;
public class employee {
	dbcontroller con =  new dbcontroller();
private int id;
private String fullname;
private String address;
private String gender;
private String position;
private int age;
private String avatar;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getAvatar() {
	return avatar;
}
public void setAvatar(String avatar) {
	this.avatar = avatar;
}
public employee() {
	super();
	// TODO Auto-generated constructor stub
}
public employee(int id, String fullname, String address, String gender, String position, int age, String avatar) {
	this.id = id;
	this.fullname = fullname;
	this.address = address;
	this.gender = gender;
	this.position = position;
	this.age = age;
	this.avatar = avatar;
}
ArrayList<employee> employeee =new ArrayList<employee>();
public ArrayList<employee> getEmployeee() {
	return employeee;
}
public void setEmployeee(ArrayList<employee> employeee) {
	this.employeee = employeee;
}
@Override
public int hashCode() {
	return Objects.hash(address, age, avatar, employeee, fullname, gender, id, position);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	employee other = (employee) obj;
	return Objects.equals(address, other.address) && age == other.age && Objects.equals(avatar, other.avatar)
			&& Objects.equals(employeee, other.employeee) && Objects.equals(fullname, other.fullname)
			&& Objects.equals(gender, other.gender) && id == other.id && Objects.equals(position, other.position);
}
@Override
public String toString() {
	return "employee [id=" + id + ", fullname=" + fullname + ", address=" + address + ", gender=" + gender
			+ ", position=" + position + ", age=" + age + ", avatar=" + avatar + "]";
}
public void SaveInforEmployee() {
	ResultSet rs = con.getAllemployee();
	try {
		while(rs.next()) {
			int eid  = Integer.parseInt(rs.getString(1));
			String efullname = rs.getString(2);
			String eaddress = rs.getString(3);
			String egender = rs.getString(4);
			String eposition = rs.getString(5);
			int eage = Integer.parseInt(rs.getString(6));
			String eavatar = rs.getString(7);
			employee em = new employee(eid, efullname, eaddress, egender, eposition, eage, eavatar);
			employeee.add(em);
			}
	} catch (Exception e) {
		// TODO: handle exception
	}
}
public static int maxidemployee() {
	employee em = new employee();
	em.SaveInforEmployee();
	int max=0;
	for(int i=0;i<em.employeee.size();i++) {
		if(em.employeee.get(i).getId()>max) {
			max = em.employeee.get(i).getId();
		}
	}
	return max;
}
}
