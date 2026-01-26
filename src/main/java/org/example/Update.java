package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Update {
	// specification of my database ...✅protocol:database://hosting server:port number/database name
	private static final String url = "jdbc:postgresql://localhost:5432/abirdatabase";
	private static final String username = "postgres";
	private static final String password = "Abirdas@1999";

	public static void main (String[] args)  {

		try {

			//1️⃣---Step
			Class.forName ("org.postgresql.Driver");
			System.out.println ("Driver is Loaded and Registered...");

			//2️⃣---Step
			//create the connection ...
			Connection con = DriverManager.getConnection (url, username, password);
			System.out.println ("Connection established...");

			//3️⃣--Step
			Statement st = con.createStatement ();


			//4️⃣--Step
			//update
			String updateSql = "UPDATE students SET sname='Ram',email='abc45@gmail.com'  WHERE sid = 3";
			int res = st.executeUpdate (updateSql);
			if (res!=0) System.out.println ("Data Got Updated");
//			st.execute (updateSql);
//			st.executeUpdate (updateSql);


			//6️⃣--Step
			//close
			con.close ();

		} catch (ClassNotFoundException | SQLException e) {
			e.fillInStackTrace ();

		}



	}

}
