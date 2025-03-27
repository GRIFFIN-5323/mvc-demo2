/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.edu.mvc.DBConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author gihan5323
 */
public class DBConnection {
    
    private static DBConnection dbConnection;
    private Connection conection;
            
    
    
    private DBConnection()throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "mysql");
        
    }
    
    
    public static DBConnection getInstance()throws ClassNotFoundException, SQLException{
        if(dbConnection==null){
            dbConnection=new DBConnection();
        }
        
        return dbConnection;
    }
    
    public Connection getConnection(){
        return this.conection;
    }
}
