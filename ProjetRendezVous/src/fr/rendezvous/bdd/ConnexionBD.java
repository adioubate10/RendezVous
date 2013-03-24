package fr.rendezvous.bdd;

import java.sql.*;
import java.io.*;
import java.util.*;

public class ConnexionBD {

       
        /**
         * Obtient une connexion � la base de donn�es � partir
         * des param�tres sp�cifi�s dans le fichier connect.conf
         * renvoie la connexion � la base de donn�es
         */
        public static Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();
        FileInputStream in = new FileInputStream("connect.conf");
        props.load(in);
        in.close();
       
        String drivers = props.getProperty("jdbc.drivers");
        if (drivers != null)
                System.setProperty("jdbc.drivers",drivers);
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
       
        return DriverManager.getConnection(url, username, password);
        }
}