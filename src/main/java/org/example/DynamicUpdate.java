package org.example;

import java.sql.*;

public class DynamicUpdate {
	private static final String url = "jdbc:postgresql://localhost:5432/abirdatabase?user=postgres&password=Abirdas@1999";
	public static void main (String[] args)  {

		try {

			//1️⃣---Step
			Class.forName ("org.postgresql.Driver");
			System.out.println ("Driver is Loaded and Registered...");

			//2️⃣---Step
			//create the connection ...
			Connection con = DriverManager.getConnection (url);//with single argument inside the url
			System.out.println ("Connection established...");

			//3️⃣--Step
			Statement st = con.createStatement ();
			String sql = "UPDATE students set sname = ? where id =?";
			PreparedStatement pt =con.prepareStatement (sql);
			System.out.println ("PreparedStatement is created");



			//4️⃣--Step
			//update
			pt.setString (1,"Amit Kumar");
			pt.setInt (2,4);


			int res = pt.executeUpdate ();
			if (res!=0) System.out.println ("Data Got Updated");

			//6️⃣--Step
			//close
			con.close ();

		} catch (ClassNotFoundException | SQLException e) {
			e.fillInStackTrace ();

		}



	}
}
