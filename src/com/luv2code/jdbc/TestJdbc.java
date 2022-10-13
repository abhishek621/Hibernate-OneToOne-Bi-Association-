package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";

		try {
			System.out.println("Connecting to Database : " + jdbcUrl);

			Connection myCon = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println(myCon.toString());
			System.out.println("Schema Name : " + myCon.getSchema());
			System.out.println("Holdability: " + myCon.getHoldability());
			System.out.println("MetaData : " + myCon.getMetaData());
			System.out.println("Catalog : " + myCon.getCatalog());
			System.out.println("getClientInfo : " + myCon.getClientInfo());
			System.out.println("Connection Succssfull..  !!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
