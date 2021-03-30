/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elias
 */
public class ConsultasProfesores extends Conectar {

    public boolean altaobaja(Profesores p) {
        Connection con = getConnection();
        PreparedStatement ps = null;

        String sql = "UPDATE teachers SET active=? WHERE teacher_id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(p.getActivo()));
            ps.setString(2, String.valueOf(p.getIdProfesor()));
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } 
    }
    
    public boolean ver(Profesores p,javax.swing.JTable tabla) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT t.teacher_id,u.name,u.last_name,u.id,t.active FROM teachers t INNER JOIN users u ON (u.user_id = t.user_id)";
        
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadcolumnas = rsMd.getColumnCount();
            
            modelo.addColumn("id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("DNI");
            modelo.addColumn("Activo");
            
            while(rs.next()){
                Object[] filas = new Object[cantidadcolumnas];
                for(int i=0;i<cantidadcolumnas;i++)
                    filas[i] = rs.getObject(i+1);
                    
                modelo.addRow(filas);
                
            }
            
             return true;

        
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } 
    }
    
    public boolean inscribir(Profesores p, Materias m){
        
        Connection con = getConnection();
        PreparedStatement ps = null;
        
        String sql ="INSERT INTO subjects_teachers (subject_id,teacher_id) SELECT s.subject_id,t.teacher_id FROM teachers t JOIN subjects s WHERE t.active=1 and t.teacher_id=? and s.subject_id=? ";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,String.valueOf(p.getIdProfesor()));
            ps.setString(2,String.valueOf(m.getIdMateria()));
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.println(e);
            return false;
        }
           
    }
    
    public boolean borrarprofesor(Profesores p){
        Connection con = getConnection();
        PreparedStatement ps = null;

        String sql = "DELETE FROM subjects_teachers WHERE teacher_id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(p.getIdProfesor()));
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } 
    }
}
