package data;

import model.Arquive;
import java.sql.*;

public class DataProvideFactory implements DataProvider {
	private Connection connection;
	
	public DataProvideFactory () {
		try {
			this.initializateDataBase();
		}catch (Exception e){
			e.getStackTrace();
		}
	}
	
	@Override
	public void insertArquive(Arquive arquive) throws ClassNotFoundException, SQLException{
		
		Class.forName("org.sqlite.JDBC");
		this.connection = DriverManager.getConnection("jdbc:sqlite:ustore-demo.db");
		this.connection.setAutoCommit(false);
		System.out.println("Connected with db");
		Statement stmt =  null;
		
		try {
			stmt = this.connection.createStatement();
			String sqlInsert = "INSERT INTO ARQUIVE (ID, PATH, LASTLENGTH) "+
								"VALUES(" + arquive.getIndexOnTable() + "," + arquive.getPath() + "," + arquive.getFileLength() + ")";
			
			stmt.executeUpdate(sqlInsert);
			stmt.close();
			this.connection.commit();
			this.connection.close();
			
		}catch(Exception e){
			e.getStackTrace();
		}
		
		System.out.println("Arquive inserted");
		
	}

	@Override
	public void updateArquive(Arquive arquive) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fetchArquivesWithQuery(String pathName) throws ClassNotFoundException, SQLException {
		
		Class.forName("org.sqlite.JDBC");
		this.connection = DriverManager.getConnection("jdbc:sqlite:ustore-demo.db");
		
	}

	public Connection getConnection(){
		return this.connection;
	}
	
	public void setConnection( Connection conn){
		this.connection = conn;
	}
	
	public void initializateDataBase() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		this.connection = DriverManager.getConnection("jdbc:sqlite:ustore-demo.db");
		System.out.println("Establish connection");
		this.createTableArquive();
	}
	
	private void createTableArquive() {
		Statement stmt = null;
		
		try {
			stmt = this.connection.createStatement();
			String sqlTable = "CREATE TABLE ARQUIVE " +
							  "(ID INT PRIMARY KEY NOT NULL," +
							  " PATH           TEXT NOT NULL,"+
							  "LASTLENGTH      TEXT NOT NULL)";
			stmt.executeUpdate(sqlTable);
			stmt.close();
			this.connection.close();
		} catch (Exception e){
			e.getStackTrace();
		}
		
		System.out.println("Create table arquive");

	}
	
	
}