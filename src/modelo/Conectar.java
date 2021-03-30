/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





/**
 *
 * @author Elias
 */
public class Conectar {
    private static Connection conn;
    private static final String driver = "com.mysql.cj.jdbc.Driver"; 
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/ejerciciojava?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public Conectar(){
        conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null)
                 System.out.println("Conectado!!");
        } catch (ClassNotFoundException | SQLException e){
            System.out.println("Error al conectarse: " + e); 
        }
    }
    
    
    //este metodo nos retorna la conexion
    public Connection getConnection(){
        return conn;
    }
    
    
    //este metodo nos desconecta de la bdd
    public void desconectar(){
        conn = null;
        if(conn==null)
            System.out.println("Conexion terminada");
    }
    
}
