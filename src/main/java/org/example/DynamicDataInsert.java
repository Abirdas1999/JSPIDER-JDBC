package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicDataInsert {
	private static final String url = "jdbc:postgresql://localhost:5432/abirdatabase?user=postgres&password=Abirdas@1999";
	public static void main(String[] args) {
		try {

	        //step-1--Connect driver
			Class.forName ("org.postgresql.Driver");
			System.out.println ("Driver is connected");

			//step-2--create connection
			Connection con = DriverManager.getConnection (url);
			System.out.println ("Connection is Established");

			//step-3--Query created
			String sql = "INSERT into students values(?,?,?,?)";
			PreparedStatement pt = con.prepareStatement (sql);
			System.out.println ("Statement is created--> SQL Query");

			//step-4--Execute Query
			pt.setInt (1,6);
			pt.setString (2,"Mr.Das");
			pt.setString (3,"dasboss_12@gamil.com");
			pt.setString (4,"Female");

			//-->
			int res = pt.executeUpdate ();
			if (res!=0) System.out.println ("Data is inserted");

			//step-5--Close connection
			pt.close ();
			con.close ();

		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException (e);
		}

	}


}
