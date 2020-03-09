package javaapplication; 
import java.sql.DriverManager; 
import java.sql.Connection; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.sql.ResultSet; 
import java.util.*;

public class JavaApplication { 
  Connection conn; ResultSet rs; 
  Statement stmt; Scanner sc = new Scanner(System.in); 
  public static void main(String[] args) { 
  int ch; 
  JavaApplication o=new JavaApplication(); 
  Scanner sc = new Scanner(System.in); 
  o.ConnectDb(); 
  do { 
  System.out.println("-------MENU-------"); 
  System.out.println("1. Insert"); 
  System.out.println("2. Display"); 
  System.out.println("3. Delete"); 
  System.out.println("4. Update"); 
  System.out.println("5. Exit"); 
  System.out.println("Enter your choice"); 
  ch=sc.nextInt(); switch(ch) {

            case 1:  o.InsertData(); 
            break;
            case 2: o.DisplayData();
            break;
            case 3: o.DeleteData();
            break;
            case 4: o.UpdateData(); 
            break;
            case 5: o.CloseConn(); 
            break;
            
        }
    }while(ch!=5);
}
 void ConnectDb()
{
    
    System.out.println("-------- PostgreSQL "
			+ "JDBC Connection Testing ------------");

	try {

		Class.forName("org.postgresql.Driver");

	} catch (ClassNotFoundException e) {

		System.out.println("Where is your PostgreSQL JDBC Driver? "
				+ "Include in your library path!");
		return;
	}
	System.out.println("PostgreSQL JDBC Driver Registered!");

	conn = null;
            try {
            conn = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/demo", "postgres",
				"vit123");
            System.out.println("You made it, take control your database now!");
            }
            catch(Exception e)
            {
                 System.out.println("Failed to make connection!"+e);
            }
}
  void DisplayData()
{
     try{
stmt = conn.createStatement(); 
rs = stmt.executeQuery("SELECT CustId, FN, LN, Email, Steet, City, State, Zip FROM Customer ORDER BY CustId ASC;"); 
System.out.println("CustId " + "\t" + "FN" + "\t" + "LN" + "\t" + "Email" + "\t\t\t" + "Street" + "\t" + "City" + "\t" + "State" + "\t\t" + "Zip"); 
while (rs.next()) { 
int i1 = rs.getInt("CustId"); 
String s1 = rs.getString("FN"); 
String s2 = rs.getString("LN"); 
String s3 = rs.getString("Email"); 
String s4 = rs.getString("Steet"); 
String s5 = rs.getString("City"); 
String s6 = rs.getString("State"); 
int i2 = rs.getInt("Zip"); 
System.out.println(i1 + "\t" + s1 + "\t" + s2 + "\t" + s3 + "\t\t" + s4 + "\t" + s5 + "\t"+ s6 + "\t" + i2); 
}
rs.close();
} catch (SQLException e){ 
System.out.println("Connection Failed! Check output console"); 
e.printStackTrace(); 
}
} void InsertData() { 
try{ 
stmt=conn.createStatement(); 
int CustId, Zip; String FN,LN, Email, Street, City, State; 
System.out.println("Enter CustId"); 
CustId=sc.nextInt(); 
System.out.println("Enter FN"); 
FN=sc.next(); 
System.out.println("Enter LN"); 
LN=sc.next(); 
System.out.println("Enter Email"); 
Email=sc.next(); 
System.out.println("Enter Street"); 
Street=sc.next(); 
System.out.println("Enter City"); 
City=sc.next(); 
System.out.println("Enter State"); 
State=sc.next(); 
System.out.println("Enter Zip"); 
Zip=sc.nextInt(); 
String sql="insert into Customer values("+CustId+",'"+FN+"','"+LN+"','"+Email+"','"+Street+"','"+City+"','"+State+"','"+Zip+"');"; 
stmt.executeUpdate(sql); 
System.out.println(sql); 
System.out.println("Insertion done successfully"); 
} catch(Exception e) { 
System.out.println("Error:"+e); 
} 
}
//End of inert data 
void UpdateData() { 
int c, ch1; 
System.out.println("Enter the CustId whose data have to update: "); 
c=sc.nextInt();

        System.out.println("1. FN");
        System.out.println("2. LN");
        System.out.println("3. Email");
        System.out.println("4. Street");
        System.out.println("5. City");
        System.out.println("6. State");
        System.out.println("7. Zip");
        System.out.println("Enter the value which you have to update: ");
        ch1=sc.nextInt();
        switch(ch1)
        {
            case 1: System.out.println("Enter FN : ");
                    String s1 = sc.next();
                    try
                    {
                        stmt=conn.createStatement();
                        String sql="update Customer set FN= '"+s1+"' where CustId= "+c+";";
                        stmt.executeUpdate(sql);
                        System.out.println("Updation done successfully");
                    }
                    catch(Exception e)
                    {
                         System.out.println("Error:"+e);
                    }
                    break;
            case 2:  System.out.println("Enter LN : ");
                     String s2 = sc.next();
                     try
                     {
                         stmt=conn.createStatement();
                        String sql="update Customer set LN= '"+s2+"' where CustId= "+c+";";
                        stmt.executeUpdate(sql);
                        System.out.println("Updation done successfully");
                     }
                     catch(Exception e)
                     {
                         System.out.println("Error:"+e);
                     }
                     break;

            case 3:  System.out.println("Enter Email : ");
                     String s3 = sc.next();
                        try
                        {
                            stmt=conn.createStatement();
                       
                            String sql="update Customer set Email='"+s3+"' where CustId= "+c+";";
                            stmt.executeUpdate(sql);
                            System.out.println("Updation done successfully");
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error:"+e);
                        }
                        break;
            case 4:  System.out.println("Enter Street : ");
                    String s4 = sc.next();
                    try
                    {
                        stmt=conn.createStatement();
                        String sql="update Customer set Steet= '"+s4+"' where CustId= "+c+";";
                        stmt.executeUpdate(sql);
                        System.out.println("Updation done successfully");
                    }
                    catch(Exception e)
                    {
                         System.out.println("Error:"+e);
                    }
                    break;

            case 5:  System.out.println("Enter City : ");
                    String s5 = sc.next();
                    try
                    {
                        stmt=conn.createStatement();
       
                        String sql="update Customer set City= '"+s5+"' where CustId= "+c+";";
                        stmt.executeUpdate(sql);
                        System.out.println("Updation done successfully");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error:"+e);
                    }
                    break;
          case 6: System.out.println("Enter State : ");
                    String s6= sc.next();
                    try
                    {
                        stmt=conn.createStatement();
                        String sql="update Customer set State= '"+s6+"' where CustId= "+c+";";
                        stmt.executeUpdate(sql);
                        System.out.println("Updation done successfully");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error:"+e);
                    }
                    break;
          case 7:  System.out.println("Enter Zip : ");
                   int s7 = sc.nextInt();
                   try
                   {
                       stmt=conn.createStatement();
                       String sql="update Customer set Zip= "+s7+" where CustId= "+c+";";
                        stmt.executeUpdate(sql);
                         System.out.println("Updation done successfully");
                   }
                   catch(Exception e)
                   {
                        System.out.println("Error:"+e);
                   }
                    break;
                   default :System.out.println("Column doesn’t exist");           
        }

}

   void CloseConn()
{

    try{
    conn.close();
    conn=null;
     System.out.println("Connection is closed");
    }
    catch(Exception e)
    {
         System.out.println("Error:"+e);
    }
    
}
    void DeleteData()
{
    int n;
    System.out.println("Enter the CustId which have to delete");
    n=sc.nextInt();
    
    try{
        stmt=conn.createStatement();
        String sql="delete from Customer where CustId="+n+"";
        stmt.executeUpdate(sql);
        System.out.println("Deletion done successfully");
    }
    catch(Exception e)
    {
        System.out.println("Error:"+e);
    }
}
}
