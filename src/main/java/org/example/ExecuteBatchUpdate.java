package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExecuteBatchUpdate {
	private static final String url = "jdbc:postgresql://localhost:5432/abirdatabase?user=postgres&password=Abirdas@1999";
	public static void main(String[] args) {
		try {

			//step-1--Connect driver
			Class.forName ("org.postgresql.Driver");
			System.out.println ("Driver is connected");

			//step-2--create connection----git
			Connection con = DriverManager.getConnection (url);
			System.out.println ("Connection is Established");

			//step-3--Query created
			String sql = "UPDATE students set sname = ? where sid =?";
			PreparedStatement pt = con.prepareStatement (sql);
			System.out.println ("Statement is created--> SQL Query");

			//step-4--Execute Query


			//data-1
			pt.setString (1,"AbirDas");
			pt.setInt (2,10);

			//add to the batch
			pt.addBatch ();

			//data-2
			pt.setString (1,"Samir Das");
			pt.setInt (2,11);

			//add to the batch
			pt.addBatch ();

			//data-3
			pt.setString (1,"XDas");
			pt.setInt (2,12);

			//add to the batch
			pt.addBatch ();


			//data-4---->
			pt.setString (1,"LaluAmit");
			pt.setInt (2,13);

			//add to the batch
			pt.addBatch ();

			//-->6--execute --> return type is int[]
			int [] ex = pt.executeBatch ();
			for (int a:ex) System.out.print (a+" ");

			//step-5--Close connection
			pt.close ();
			con.close ();

		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException (e);
		}

	}
}
