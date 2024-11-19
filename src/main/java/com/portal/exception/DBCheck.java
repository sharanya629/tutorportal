package com.portal.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con= null;
		try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "M@5ter");
            if (con != null) {
                System.out.println("Database is up and running!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
	}

}
