package javaclass;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Input extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter ();
		String name=req.getParameter("username");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobile_number");
		String address=req.getParameter("address");
		String event=req.getParameter("cb").toString();
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","upkar");
			PreparedStatement ps=con.prepareStatement("insert into details values(?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2,email);
			ps.setString(3,mobile);
			ps.setString(4, address);
			ps.setString(5,event);
			
			int i=ps.executeUpdate();
			if(i>0) {
				RequestDispatcher rd=req.getRequestDispatcher("/index2.html");
				rd.include(req, res);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		out.close();
	}

}
