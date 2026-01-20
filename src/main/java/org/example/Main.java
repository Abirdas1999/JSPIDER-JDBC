package org.example;

import java.sql.*;

class Main {


	//specification of my database ...
	//✅protocol:database://hosting server:port number/database name
	private static final String url = "jdbc:postgresql://localhost:5432/abirdatabase";
	private static final String username = "postgres";
	private static final String password = "Abirdas@1999";

	static void main (String[] args)  {

		try {
			Class.forName ("org.postgresql.Driver");
			System.out.println ("Driver is Loaded and Registered...");

			//create the connection ...
			Connection con = DriverManager.getConnection (url, username, password);
			System.out.println ("Connection established...");
			Statement st = con.createStatement ();

		} catch (ClassNotFoundException | SQLException e) {
			e.fillInStackTrace ();

		}












//
//
//
//		// GET
//		String selectSql = "SELECT sname FROM students WHERE sid = 1";
//		ResultSet rs1 = st.executeQuery (selectSql);
//		rs1.next ();
//		System.out.println ("Before update: " + rs1.getString ("sname"));
//
//
//		// UPDATE
//		String updateSql = "UPDATE students SET sname = 'Abir' WHERE sid = 1";
//		st.executeUpdate (updateSql);
//
//		// READ (after update)
//		ResultSet rs2 = st.executeQuery (selectSql);
//		rs2.next ();
//		System.out.println ("After update: " + rs2.getString ("sname"));
//
//
//		//close all the connection
//
//		rs1.close ();
//		rs2.close ();
//		st.close ();
//		con.close ();

	}


}