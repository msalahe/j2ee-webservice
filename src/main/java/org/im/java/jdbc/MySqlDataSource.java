package org.im.java.jdbc;

public class MySqlDataSource extends DataSource {

	public static final String MYSQL_DRIVER ="com.mysql.jdbc.Driver";
	public static final  String MYSQL_BRIDGE="jdbc:mysql:";

	public MySqlDataSource(String host, String source, String user, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, host, source, user, password);
	}
	
	public MySqlDataSource(String source, String user, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", source, user, password);
	}
	
	public MySqlDataSource(String source, String user) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", source, user, "");
	}
	
	public MySqlDataSource(String source) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", source, "root", "");
	}
	
	public MySqlDataSource() {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", "mysql", "root", "");
	}
	

}
