package fr.rendezvous.bdd;

import java.sql.*;
import java.io.*;
import java.util.*;

public class ConnexionBD {

       
        /**
         * Obtient une connexion à la base de données à partir
         * des paramètres spécifiés dans le fichier connect.conf
         * renvoie la connexion à la base de données
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