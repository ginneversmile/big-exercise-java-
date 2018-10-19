/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a
 */
public class DataProvider {

    private static DataProvider instance = null;
    private static Connection connection = null;
    
    public static DataProvider getInstance() {
        if (instance == null) {
            instance = new DataProvider();
        }
        return instance;
    }
    
    public Connection getConnection () {
        if(connection == null){
            try {
                connection = DriverManager.getConnection(connectionURL, username,password);
            } catch (SQLException ex) {
                Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
    public DataProvider() {
    }

    private final String connectionURL = "jdbc:sqlserver://localhost:1433;database=jbdc_btl";
    private final String username = "SA";
    private final String password = "pass";
}
