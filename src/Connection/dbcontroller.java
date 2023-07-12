package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.customer;
import model.employee;

import java.net.SocketTimeoutException;

public class dbcontroller {
//	customer customerr = new customer();
	 Connection con;
	   Statement stmt;
	   private String money;
	   private String year;
	   public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public dbcontroller(String money, String year) {
		this.money = money;
		this.year = year;
	}
	ArrayList<String> list = new ArrayList<String>();
	   
	  ArrayList<dbcontroller> list1 = new ArrayList<dbcontroller>();
	  
	public ArrayList<dbcontroller> getList1() {
		return list1;
	}
	public void setList1(ArrayList<dbcontroller> list1) {
		this.list1 = list1;
	}
	public Statement getStmt() {
			return stmt;
		}
		public void setStmt(Statement stmt) {
			this.stmt = stmt;
		}
	   public dbcontroller() {
		   // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		   try {
	           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	           try {
	               this.con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-BDFP0NO\\SQLEXPRESS;databaseName=computermanagementdatabase;"+"portNumber=1433;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2","sc","1234");
	               this.stmt = con.createStatement();
	                        } catch (SQLException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	               System.out.println("Connection");
	           }
	       } catch (ClassNotFoundException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	       }
} 
	  public void setdataforlist1() {
		  ResultSet rs = getyear();
		  try {
			while(rs.next()) {
				String money = rs.getString(1);
				String year = rs.getString(2);
				dbcontroller c = new dbcontroller(money, year);
				list1.add(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	  }
	   public void setdataforlist() {
		   ResultSet rs = getidinfor();
		   try {
			   while(rs.next()) {
				   String id = rs.getString(1);
				   list.add(id);
			   }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	   }
	   public void insertnotificationall(String content) {
		   setdataforlist();
		   int a = getMaxnotifications()+1;
		   for(int i=0;i<list.size();i++) {
			   String sql = "insert into Notification(NID,NContent,ID) values ('"+a+"','"+content+"','"+list.get(i)+"')";
			   try {
				   System.out.println(sql);
				stmt.executeUpdate(sql);
			} catch (Exception e) {
				// TODO: handle exception
			}
			   a++;
		   }
	   }
	   public ResultSet getidinfor() {
		   ResultSet rs=null;
		   String sql = "Select ID from Information";
		   try {
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		   return rs;
	   }
	   public ResultSet getembyusnameandpass(String username,String password) {
		   ResultSet rs = null;
		   String sql = "Select ID,FullName,Address,Gender,Position,Age,Avatar,Username,Password from Information where Username = '"+username+"' and Password = '"+password+"'";
        try {
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}	   
        return rs;
	   }
	   
	   public ResultSet getpassword(String username) {
		   ResultSet rs = null;
		   String sql = "Select Password from Information where Username = '"+username+"'";
        try {
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}	   
        return rs;
	   }
	   public ResultSet getembad() {
		   ResultSet rs = null;
		   String sql = "select i.ID,i.FullName,i.Address,i.Gender,i.Position,i.Age from Information i inner join Salary s on i.ID=s.ID where i.id = (select ID from Information i1 where i.ID=i1.ID ) group by i.ID,i.FullName,i.Address,i.Gender,i.Position,i.Age having COUNT(s.Month)>=3 and SUM(s.Money)<=900";
		   
		   try {
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		   return rs;
	   }
	   public ResultSet getmaxyear(String id)
	   {	  
		   
		   ResultSet rs = null;
		   String sql="select MAX(Year) from Salary where ID = '"+id+"'";
		   try {
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		   return rs;
	   }
	   public String maxyear(String id) {
		  ResultSet rs = getmaxyear(id);
		  String a="";
		  try {
			  while(rs.next()) {
			a=rs.getString(1);
			  }
		} catch (Exception e) {
			// TODO: handle exception
		}
		  return a;
	   }
	   public ResultSet getsalarybyyear(String id)
	   {	
		   ResultSet rs=null;
		   String a = maxyear(id);
	
		  		   String sql="select Month, Year, Money from Salary where ID = '"+id+"' and Year = '"+a+"'  ";
		   try {
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		   return rs;
	   }
	   public ResultSet getmaxmonthsalary(String id) {
		   ResultSet rs= null;
		   String sql = "select Month,Year,MAX(Money) from Salary s where ID='"+id+"' and Month in (Select Month from Salary s1 where s.ID=s1.ID ) group by Month,Year ";
		   try {
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		   return rs;
	   }

	   public ResultSet getsalarybymonth(String id,String month) {
		   ResultSet rs = null;
		   String sql="select Month,Year,Money from Salary where ID='"+id+"' and Month = '"+month+"'";
		   try {
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		   return rs;
	   }
	   public ResultSet getyear() {
		   ResultSet rs = null;
		   String sql = "select SUM(Money), Year from Salary group by Year";
		   try {
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		   return rs;
	   }
	   public ResultSet getsalryallyear(String id) {
		   ResultSet rs = null;
		    String sql="select SUM(Money),s.Year from Salary s where ID = '"+id+"' and Year in (Select Year from Salary s1 where s.Year=s1.Year) GROUP BY s.Year";
		    try {
				System.out.println(sql);
				rs = stmt.executeQuery(sql);
			} catch (Exception e) {
				// TODO: handle exception
			}
		    return rs;
	   }
	   public ResultSet getallnotification(String id) {
		   ResultSet rs = null;
		   String sql ="Select NID,NContent from Notification i where ID = '"+id+"' and NID = (Select NID from Notification n where i.NID=n.NID) ";
		   try {
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO:	 handle exception
		}
		   return rs;
	   }
	   public ResultSet getnotificationtable(String id,String tablename) {
		   ResultSet rs = null;
		   String sql ="Select NInfor from "+tablename+"  where ID = '"+id+"' ";
		   try {
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		   return rs;
	   }
	   
	   public int getMaxnotifications() {
		   ResultSet rs = getmaxnotification();
		   int a =0;
		   try {
			   while(rs.next()) {
			a=Integer.parseInt(rs.getString(1));
			   }
		} catch (Exception e) {
			// TODO: handle exception
		}
		   return a;
	   }
	   public void managenotification(String table, String id, String content) {
            String sql="delete from Notification where ID = '"+id+"' and NContent like '"+content+"' ";
            String sql1="insert into "+table+" (NInfor,ID) values ('"+content+"','"+id+"') ";
            try {
            	System.out.println(sql1);
            	System.out.println(sql);
				stmt.executeUpdate(sql1);
				stmt.executeUpdate(sql1);
			} catch (Exception e) {
				// TODO: handle exception
			}
	   }
	   public void changepassword(String id,String password,String username) {
		   String sql = "Update Information set Password = '"+password+"' where ID='"+id+"' and Username = '"+username+"'";
		   try {
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
	   }
	   public void insertnotification(String content,String id) {
		   int a = getMaxnotifications()+1;
		   String sql = "insert into Notification(NID,NContent,ID) values ('"+a+"','"+content+"','"+id+"')";
		   try {
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		   
	   }
	   public ResultSet getmaxnotification() {
		   ResultSet rs = null;
		   String sql = "Select MAX(NID) from Notification";
		   try {
			   System.out.println(sql);
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		   return rs;
	   }
	   public ResultSet getnotification(String id) {
		   ResultSet rs = null;
		   String sql = "Select NID,NContent from Notification where id = '"+id+"'";
		   try {
			   System.out.println(sql);
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		   return rs;
	   }
	   public ResultSet getembytopandposition(int top, String position) {
		   ResultSet rs = null;
		   String sql="select TOP "+top+" SUM(s.Money), i.ID,i.FullName,i.Address,i.Gender,i.Position,i.Age from Information i inner join Salary s on i.ID=s.ID where i.Position = '"+position+"' and Year = "+2022+" group by i.ID,i.FullName,i.Address,i.Gender,i.Position,i.Age";
		   try {
			   System.out.println(sql);
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		   return rs;
	   }
 	   public int returnmaxnumnew() {
		   ResultSet rs = getmaxnumnew();
		   int a = 0;
		   try {
			while(rs.next()){
				a=Integer.parseInt(rs.getString(1));
			}
		   }
		   catch (Exception e) {
			// TODO: handle exception
		}
		   return a;
	   }
	   public ResultSet getmaxnumnew() {
		   ResultSet rs = null;
		   String sql ="Select MAX(Number) from News";
		   try {
			   System.out.println(sql);
			rs=stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		   return rs;
	   }
		   public void putNew(String news) {
			   int a = returnmaxnumnew()+1;
			   String sql = "insert into News(Number,News) values ('"+a+"','"+news+"')";
			   try {
				   System.out.println(sql);
				stmt.executeUpdate(sql);
			} catch (Exception e) {
				// TODO: handle exception
			}
		   }
	public ResultSet getNews() {
		ResultSet rs = null;
		String sql = "select Number,News,Imageee from News  ";
		try {
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	public ResultSet getCustomer() {
		ResultSet rs = null;
		String sql="select CID,CFullName,CPhone,CEmail from Customer";
		try {
			rs=stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	public ResultSet getnumorder() {
		ResultSet rs = null;
		String sql = "select MAX(OId) from Orderr ";
		try {
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	public ResultSet getOIdnum() {
		ResultSet rs = null;
		String sql = "select OId from Orderr";
		try {
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	public void insertcustomer(String cfullname,String cphone,String cemail) {
		int cid = customer.cnum()+1;
		String sql="insert into Customer (CID,CFullname,CPhone,CEmail) values ('"+cid+"','"+cfullname+"','"+cphone+"','"+cemail+"') ";
		try {
			System.out.println(sql);
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void insertorder(int a,double Omoney,String Odescription, String sid) {
		int cid=customer.cnum();
		String sql="insert into Orderr (OId,OMoney,ODescription,CID,SID) values ('"+a+"','"+Omoney+"','"+Odescription+"','"+cid+"','"+sid+"')";
				try {
					System.out.println(sql);
					stmt.executeUpdate(sql);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	public ResultSet getAllemployee() {
		ResultSet rs = null;
		String sql = "select ID,FullName,Address,Gender,Position,Age,Avatar,Username,Password from Information";
		try {
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	public void setSalary(int id,int year,int month,double money) {
		String sql ="insert into Salary (ID,Year,Month,Money) values ('"+id+"','"+year+"','"+month+"','"+money+"')";
		try {
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void addnewemployee(String fullname,String address,String Gender,String Position,int age,String username,String password){
	  int id = employee.maxidemployee()+1;
	   String sql = "insert into Information(ID,FullName,Address,Gender,Position,Age,Username,Password) values ('"+id+"','"+fullname+"','"+address+"','"+Gender+"','"+Position+"','"+age+"','"+username+"','"+password+"')";	
	   try {
		   System.out.println(sql);
		stmt.executeUpdate(sql);
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
	public void updateemployee(String fullname,String address,String gender,String position,int age,int id,String avatar,String password) {
		String sql = "update Information set FullName = '"+fullname+"',Address = '"+address+"',Gender = '"+gender+"',Position='"+position+"',Age='"+age+"',Avatar = '"+avatar+"',Password = '"+password+"' where id='"+id+"'";
		try {
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public ResultSet getemployeebyname(String name) {
		ResultSet rs = null;
		String sql = "select ID,FullName,Address,Gender,Position,Age from Information where FullName like '%"+name+"%'";
		try {
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	public ResultSet getemployeebyposition(String position) {
		ResultSet rs = null;
		String sql = "select ID,FullName,Address,Gender,Position,Age from Information where position like '"+position+"'";
		try {
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	public ResultSet searchemployee(int id) {
		ResultSet rs = null;
		String sql = "select FullName,Address,Gender,Position,Age,Avatar,Username,Password from Information where id = '"+id+"'";
		try {
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	public void deleteemployee(int id) {
		String sql = "delete from Information where id = '"+id+"'";
		try {
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		   dbcontroller db = new dbcontroller();
			   ResultSet rs =  db.getNews();
		  
		   try {
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
				
			
	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		   
	   }
	public ResultSet getsalarybymonthandyear(int month,int year) {
		ResultSet rs = null;
		String sql="select i.Id,i.FullName,i.Address,i.Gender,i.Position,i.Age,s.Month,s.Year,s.Money from Information i inner join Salary s on i.ID=s.ID where s.Month='"+month+"' and s.Year='"+year+"'";
		try {
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
}

