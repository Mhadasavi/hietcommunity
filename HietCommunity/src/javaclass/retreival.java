package javaclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class retreival extends HttpServlet{
 public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException {
	 PrintWriter pw2=res.getWriter();
	 
	 try {
		 res.setContentType("text/html");
		 Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","upkar");
			PreparedStatement st=con.prepareStatement("select * from details");
			
			ResultSet rs=st.executeQuery();
			pw2.println("<html>\r\n" + 
				"    <head>\r\n" + 
				"        <style> table,tr,td{\r\n" + 
				"            border:1px solid black;\r\n" + 
				"        }</style>\r\n" + 
				"\r\n" + 
				"        \r\n" + 
				"    </head>\r\n" + 
				"    <body> \r\n" + 
				"    <table style=\"width:100%;\">\r\n" + 
				"    <tr>\r\n" + 
				"    <th>Name</th>\r\n" + 
				"    <th>E-Mail</th>\r\n" + 
				"    <th>Mobile No.</th>\r\n" + 
				"    <th>Address</th>\r\n" + 
				"    </tr>\r\n" + 
				"     ");
		
		while(rs.next()) {
			pw2.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+"</td>");
			
	} pw2.println(" </table>"+"</body>\r\n" +	"</html></html>");}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 }
