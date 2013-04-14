package fr.rendezvous.modeles;

import java.sql.*;
import java.io.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ModeleDAO implements DAO {

	DataSource dataSource = null;
	Connection conn=null;
	public Connection getConnection1(){
		 try  {
			Context initCtx =   new   InitialContext();
			Context envCtx = (Context) initCtx.lookup( "java:comp/env"  ) ;
			DataSource ds  = (DataSource) envCtx.lookup("jdbc/ConnectDB");
			conn = ds.getConnection();  
			 
 
		}  catch  (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void setConnection (DataSource dataSource){
		this.dataSource=dataSource;
	}
	
	
	public Connection getConnection(){
		try
		{
	    // Chargement du pilote ok
	    Class.forName("com.mysql.jdbc.Driver");
	    
		}
		catch(Exception ex)
		{
	    System.out.println(" Erreur pilote de "+ ex.getMessage());
		}
		
		try
		{        	
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gestionrdv","root","");
			
		}
		catch(SQLException exc)
	   {
		    System.out.println("Erreur de connection " + exc.toString());
	   }
			 

		return conn;
	}
}