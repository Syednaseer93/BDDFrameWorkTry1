package WaitConcept.WaitConcept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UploadFile {//DataBase testing

	public static void main(String[] args) throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","orcl");
		Statement stmt=con.createStatement();
		String query="SELECT FNAME,LNAME,SALARY FROM SELENIUMDATA";
		ResultSet rs=stmt.executeQuery(query);
		boolean flag=false;
		while(rs.next())
		{ 
			String FNAME=rs.getString("FNAME");
			String LNAME=rs.getString("LNAME");
			String SALARY=rs.getString("SALARY");
			
			if(FNAME.equals("JOHN") && LNAME.equals("ALEX") && SALARY.equals("75000"))
			{
				System.out.println("Record avaialble and test passed");
				flag=true;
				break;
			}
	
			
		}
		if(flag==false)
		{
			System.out.println("Record not available && test failed");
		}
		

	}

}