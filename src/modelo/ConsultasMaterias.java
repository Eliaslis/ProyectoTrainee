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
public class ConsultasMaterias extends Conectar{
    
    public boolean ver(Materias m, Profesores p,javax.swing.JTable tabla) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT s.subject_id,s.name,t.teacher_id,u.name,u.last_name,st.timetable,st.quotas FROM subjects s INNER JOIN subjects_teachers st ON (s.subject_id = st.subject_id) INNER JOIN teachers t ON (st.teacher_id = t.teacher_id) INNER JOIN users u ON (t.user_id = u.user_id)";
        
        
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadcolumnas = rsMd.getColumnCount();
            
            modelo.addColumn("idMateria");
            modelo.addColumn("Materia");
            modelo.addColumn("idProfesor");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Horarios");
            modelo.addColumn("Cupos");
            
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
    
    
    public boolean cambiar(Materias m,Profesores p){
        
        Connection con = getConnection();
        PreparedStatement ps = null;
        
        String sql ="UPDATE subjects_teachers SET timetable=?, quotas=? WHERE teacher_id=? and subject_id=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,m.getHorarios());
            ps.setString(2,String.valueOf(m.getCupos()));
            ps.setString(3,String.valueOf(p.getIdProfesor()));
            ps.setString(4,String.valueOf(m.getIdMateria()));
            
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.println(e);
            return false;
        }
           
    }
    
    public boolean seleccionar(Materias m,javax.swing.JTable tabla) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT description FROM subjects WHERE subject_id=?";
        
        
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,String.valueOf(m.getIdMateria()));
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadcolumnas = rsMd.getColumnCount();
            
            modelo.addColumn("Descripción");
           
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
    
    public boolean anotarse(Materias m,Usuarios u){
        
        Connection con = getConnection();
        PreparedStatement ps = null;
        
        String sql ="INSERT INTO student_subjects VALUES(?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,String.valueOf(u.getId()));
            ps.setString(2,String.valueOf(m.getIdMateria()));
            
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.println(e);
            return false;
        }
           
    }
    
      public boolean descontarcupo(Materias m){
        
        Connection con = getConnection();
        PreparedStatement ps = null;
        
        String sql ="UPDATE subjects_teachers SET quotas=(quotas-1) WHERE subject_id=? AND teacher_id=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(m.getIdMateria()));
            ps.setString(2, String.valueOf((int) Math.random()*5+1));
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.println(e);
            return false;
        }
           
    }
    
}