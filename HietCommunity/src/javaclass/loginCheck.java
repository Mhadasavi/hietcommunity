package javaclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginCheck extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String name=req.getParameter("username");
		String password=req.getParameter("password");
		if((password.equals("admin"))) {
			 PrintWriter pw2=res.getWriter();
			 try {
				 int count=1;
				 res.setContentType("text/html");
				 Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","upkar");
					PreparedStatement st=con.prepareStatement("select * from details");
					
					ResultSet rs=st.executeQuery();
					pw2.println("<html><head>\r\n" + 
							"      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \r\n" + 
							"      <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\r\n" + 
							"      <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js\"></script>\r\n" + 
							"      <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\r\n" + 
							"    </head>\r\n" + 
							"    <body><<h2 style=\"text-align:center;\">List of registered students</h2>\r\n" + 
							"    <div class=\"container\">\r\n" + 
							"      <div class=\"table-responsive\">          \r\n" + 
							"      <table class='table table-striped table-bordered table-hover table-condensed' style='border:1px solid black'>\r\n" + 
							"       <tr><th>S.No</th>\r\n" + 
							"            <th>Name</th>\r\n" + 
							"     	 <th>E-Mail</th>\r\n" + 
							"	   <th>Mobile No.</th>\r\n" + 
							"        <th>Address</th>\r\n" + 
							"    <th>Events</th></tr>");
				
				while(rs.next()) {
					
					pw2.println("<tr><td>"+count+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getLong(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</tr>");
					count++;
			} pw2.println(" </table>"+"</body>\r\n" +	"</html></html>");}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
		
			pw.println("alert('wrong password')");
		}
	}

}

