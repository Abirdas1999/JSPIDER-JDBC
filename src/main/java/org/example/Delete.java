package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Delete {
	// specification of my database ...✅protocol:database://hosting server:port number/database name
	private static final String url = "jdbc:postgresql://localhost:5432/abirdatabase?user=postgres&password=Abirdas@1999";
//	private static final String username = "postgres";
//	private static final String password = "Abirdas@1999";

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


			//4️⃣--Step
			//update
			String DeleteSql = "DELETE from students WHERE sid = 2";
			int res = st.executeUpdate (DeleteSql);
			if (res!=0) System.out.println ("Data Got Deleted");

			//6️⃣--Step
			//close
			con.close ();

		} catch (ClassNotFoundException | SQLException e) {
			e.fillInStackTrace ();

		}



	}

}
