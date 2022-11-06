package org.im.java.jdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class Database {
	
	private DataSource dataSource;
	
	private Connection db;
	
	public Database(DataSource ds) {
		dataSource = ds;
		db = ds.getConnection();
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public String[][] executeQuery(String query) {
		try {
			Statement sql = db.createStatement();
			ResultSet rs = sql.executeQuery(query);
			
			rs.last();
			int rows = rs.getRow();
			rs.beforeFirst();
			
			ResultSetMetaData rsm = rs.getMetaData();
			int cols = rsm.getColumnCount();
			
			String data[][] = new String[rows + 1][cols];
			for (int i = 0; i < cols; i++) {
				data[0][i] = rsm.getColumnName(i + 1);
			}
			
			int row = 0;
			while(rs.next()) {
				row++;
				for (int i = 0; i < cols ; i++) {
					data[row][i] = rs.getString(i+1);
				}
			}
			
			rs.close();
			return data;
		} catch (Exception e) {
			//error
			System.out.println("Erreur :"+e.getMessage());
			return null;
		}
	}
	
	public String[][] select(String tableName){
		return executeQuery("Select * From "+tableName);
	}
	
	public String [][] select (String tableName, String key, Object value){
		return executeQuery("SELECT * FROM " + tableName + " WHERE " 
				+ key + "= '"+ value +"'");
	}
	
	public String [][] selectLike (String tableName, String key, Object value){
		return executeQuery("SELECT * FROM " + tableName + " WHERE " 
				+ key + " Like '%"+ value +"%'");
	}
	
	public int insert(String tableName, Object... row ) {
		try {
			Statement sql = db.createStatement();
			String query = "INSERT INTO " + tableName + " VALUES('" + row[0] +"'";
			for(int i=1; i<row.length;i++) {
				query += ", '" + row[i] + "'"; 
			}
			query += ");";
			return sql.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			return -1;
		}
	}
}
