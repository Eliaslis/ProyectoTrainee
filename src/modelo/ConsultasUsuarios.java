/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Elias
 */
public class ConsultasUsuarios extends Conectar{
    
    public boolean registrar(Usuarios u){
        
        Connection con = getConnection();
        PreparedStatement ps = null;
        
        String sql ="INSERT INTO users (name,last_name,id,role,password) VALUES(?,?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,u.getNombre());
            ps.setString(2,u.getApellido());
            ps.setInt(3,u.getDni());
            ps.setString(4,u.getRol());
            ps.setString(5,u.getContrasenia());
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.println(e);
            return false;
        }
           
    }
    public boolean loginadmin(Usuarios u){
        
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql ="SELECT * FROM users WHERE name=? and last_name=? and password=? and role='Administrador' ";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,u.getNombre());
            ps.setString(2,u.getApellido());
            ps.setString(3,u.getContrasenia());
            rs = ps.executeQuery();
            if(rs.next())
                return true;
            return false;
        }
        catch(SQLException e){
            System.err.println(e);
            return false;
        }
             
    }    
    
    public boolean loginalumnos(Usuarios u){
        
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql ="SELECT * FROM users WHERE id=? and user_id=? and role='Alumno' ";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,u.getDni());
            ps.setInt(2,u.getId());
            rs = ps.executeQuery();
            if(rs.next())
                return true;
            return false;
        }
        catch(SQLException e){
            System.err.println(e);
            return false;
        }
              
    }    
}


