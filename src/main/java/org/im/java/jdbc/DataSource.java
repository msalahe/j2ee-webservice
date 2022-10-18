package org.im.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {

	private String driver;
	private String bridge;
	
	private String host;
	private String source;
	private String user;
	private String password;
	
	
	public DataSource(String driver, String bridge, String host, String source, String user, String password) {
		super();
		this.driver = driver;
		this.bridge = bridge;
		this.host = host;
		this.source = source;
		this.user = user;
		this.password = password;
	}



	public Connection getConnection() {
		try {
			Class.forName(driver);
			String url = bridge + "//"+ host + "/" + source;
			Connection db = DriverManager.getConnection(url, user, password);
			//trace
			System.out.println("Connexion bien �tablie...");
			return db;
		} catch (Exception e) {
			//error
			System.out.println("Erreur :"+e);
			return null;
		}
	}
	
}
