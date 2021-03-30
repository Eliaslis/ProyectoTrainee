/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import modelo.ConsultasMaterias;
import modelo.ConsultasProfesores;
import modelo.Materias;
import modelo.Profesores;
import vista.LoginUsuarios;
import vista.MenuAdmin;
import vista.VistaMateriasAdmin;
import vista.VistaProfesores;

/**
 *
 * @author Elias
 */
public class CtrlAdministradores implements ActionListener{

    private MenuAdmin frmma;
    private VistaMateriasAdmin frmvm;
    private VistaProfesores frmvp;
    private ConsultasProfesores cmodp;
    private Profesores modp;
    private Materias modm;
    private ConsultasMaterias cmodm;
    private LoginUsuarios frml;
    

    public CtrlAdministradores(ConsultasProfesores cmodp, Profesores modp, VistaProfesores frmvp, Materias m, ConsultasMaterias cmodm, 
            VistaMateriasAdmin frmvm, MenuAdmin frmma, LoginUsuarios frml) {
        this.cmodp = cmodp;
        this.modp = modp;
        this.frmvp = frmvp;
        this.modm = m;
        this.cmodm = cmodm;
        this.frmvm = frmvm;
        this.frmma = frmma;
        this.frml = frml;
        this.frmvm.btn_cambiar.addActionListener(this);
        this.frmvm.menu_menu.addActionListener(this);
        this.frmvm.menu_profesores.addActionListener(this);
        this.frmvp.btn_cambiar.addActionListener(this);
        this.frmvp.menu_menu.addActionListener(this);
        this.frmvp.menu_materias.addActionListener(this);
        this.frmvp.menu_cerrar.addActionListener(this);
        this.frmvp.btn_inscribir.addActionListener(this);
        this.frmma.btn_profesores.addActionListener(this);
        this.frmma.btn_materias.addActionListener(this);
        this.frmma.menu_cerrar.addActionListener(this);
        

    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == frmma.menu_cerrar){
             frml.setVisible(true);
             frml.setLocationRelativeTo(null);
             frml.txt_nombre.setText("");
             frml.txt_apellido.setText("");
             frml.txt_contra.setText("");
             frml.txt_legajo.setText("");
             frml.txt_dni.setText("");
             frmma.dispose();
         }
        
        if(ae.getSource() == frmma.btn_profesores){
         
            frmvp.setVisible(true);
            frmvp.setTitle("Profesores");
            frmvp.setLocationRelativeTo(null);
            cmodp.ver(modp,frmvp.tb_profesores);
            frmma.dispose();
            TableColumn ci = frmvp.tb_profesores.getColumn("id");
            ci.setMaxWidth(50);
            TableColumn cn = frmvp.tb_profesores.getColumn("Nombre");
            cn.setMaxWidth(100);
            TableColumn ca = frmvp.tb_profesores.getColumn("Apellido");
            ca.setMaxWidth(120);
            TableColumn cd = frmvp.tb_profesores.getColumn("DNI");
            cd.setMaxWidth(90);
            TableColumn ce = frmvp.tb_profesores.getColumn("Activo");
            ce.setMaxWidth(90);
          
         }
        if(ae.getSource() == frmvp.menu_menu){
             frmma.setVisible(true);
             frmma.setTitle("Menu Administrador");
             frmma.setLocationRelativeTo(null);
             frmvp.dispose();
         }
         
         if(ae.getSource() == frmvp.menu_materias){
             frmvm.setVisible(true);
             frmvm.setTitle("Materias");
             frmvm.setLocationRelativeTo(null);
             frmvp.dispose();
             cmodm.ver(modm,modp,frmvm.tb_materias);
         }
         if(ae.getSource() == frmvp.menu_cerrar){
             frml.setVisible(true);
             frml.setLocationRelativeTo(null);
             frml.txt_nombre.setText("");
             frml.txt_apellido.setText("");
             frml.txt_contra.setText("");
             frml.txt_legajo.setText("");
             frml.txt_dni.setText("");
             frmvp.dispose();
         }
        
          if(ae.getSource() == frmvp.btn_inscribir){
             
             modp.setIdProfesor(Integer.parseInt(frmvp.sp_id.getValue().toString()));
             if(frmvp.cmb_materias.getSelectedItem().toString().equals("Álgebra y Geometría Analítica"))
                    modm.setIdMateria(3);
            else if(frmvp.cmb_materias.getSelectedItem().toString().equals("Algoritmos y Estructuras de Datos"))
                modm.setIdMateria(5);
            else if(frmvp.cmb_materias.getSelectedItem().toString().equals("Análisis Matemático I"))
                modm.setIdMateria(2);
            else if(frmvp.cmb_materias.getSelectedItem().toString().equals("Arquitectura de Computadoras"))
                modm.setIdMateria(8);
            else if(frmvp.cmb_materias.getSelectedItem().toString().equals("Ingeniería y Sociedad"))
                modm.setIdMateria(1);
            else if(frmvp.cmb_materias.getSelectedItem().toString().equals("Matemática Discreta"))
                modm.setIdMateria(6);
            else if(frmvp.cmb_materias.getSelectedItem().toString().equals("Química"))
                modm.setIdMateria(4);
            else if(frmvp.cmb_materias.getSelectedItem().toString().equals("Sistemas y Organizaciones"))
                modm.setIdMateria(7);
             
             if(cmodp.inscribir(modp, modm))
                 JOptionPane.showMessageDialog(null,"Incripto!");
             else
                JOptionPane.showMessageDialog(null,"Error!");
         }
          
          if(ae.getSource() == frmvp.btn_cambiar){
         
            modp.setIdProfesor(Integer.parseInt(frmvp.sp_id.getValue().toString()));
            if(String.valueOf(frmvp.cmb_alta.getSelectedItem()).equals("Alta"))
                modp.setActivo(1);
            else
                modp.setActivo(0);

            if(cmodp.altaobaja(modp) && modp.getActivo()==1){
                JOptionPane.showMessageDialog(null,"Estado actualizado");
                cmodp.ver(modp,frmvp.tb_profesores);
                TableColumn ci = frmvp.tb_profesores.getColumn("id");
                ci.setMaxWidth(50);
                TableColumn cn = frmvp.tb_profesores.getColumn("Nombre");
                cn.setMaxWidth(100);
                TableColumn ca = frmvp.tb_profesores.getColumn("Apellido");
                ca.setMaxWidth(120);
                TableColumn cd = frmvp.tb_profesores.getColumn("DNI");
                cd.setMaxWidth(90);
                TableColumn ce = frmvp.tb_profesores.getColumn("Activo");
                ce.setMaxWidth(90);
            }
            else if(cmodp.altaobaja(modp) && modp.getActivo()==0){
                cmodp.borrarprofesor(modp);
                JOptionPane.showMessageDialog(null,"Estado actualizado");
                cmodp.ver(modp,frmvp.tb_profesores);
                TableColumn ci = frmvp.tb_profesores.getColumn("id");
                ci.setMaxWidth(50);
                TableColumn cn = frmvp.tb_profesores.getColumn("Nombre");
                cn.setMaxWidth(100);
                TableColumn ca = frmvp.tb_profesores.getColumn("Apellido");
                ca.setMaxWidth(120);
                TableColumn cd = frmvp.tb_profesores.getColumn("DNI");
                cd.setMaxWidth(90);
                TableColumn ce = frmvp.tb_profesores.getColumn("Activo");
                ce.setMaxWidth(90);
            }
                
            
            else
                JOptionPane.showMessageDialog(null,"Error!");

         }
          
      
         
         if(ae.getSource() == frmma.btn_materias){
             frmvm.setVisible(true);
             frmvm.setTitle("Materias");
             frmvm.setLocationRelativeTo(null);
             frmma.dispose();
             cmodm.ver(modm,modp,frmvm.tb_materias);   
         }
        if(ae.getSource() == frmvm.menu_menu){
             frmma.setVisible(true);
             frmma.setTitle("Menu Administrador");
             frmma.setLocationRelativeTo(null);
             frmvm.dispose();
         }
        if(ae.getSource() == frmvm.menu_cerrar){
             frml.setVisible(true);
             frml.setLocationRelativeTo(null);
             frml.txt_nombre.setText("");
             frml.txt_apellido.setText("");
             frml.txt_contra.setText("");
             frml.txt_legajo.setText("");
             frml.txt_dni.setText("");
             frmvm.dispose();
         }
         
         if(ae.getSource() == frmvm.menu_profesores){
            frmvp.setVisible(true);
            frmvp.setTitle("Profesores");
            frmvp.setLocationRelativeTo(null);
            frmvm.dispose();
            cmodp.ver(modp,frmvp.tb_profesores);
            TableColumn ci = frmvp.tb_profesores.getColumn("id");
            ci.setMaxWidth(50);
            TableColumn cn = frmvp.tb_profesores.getColumn("Nombre");
            cn.setMaxWidth(100);
            TableColumn ca = frmvp.tb_profesores.getColumn("Apellido");
            ca.setMaxWidth(120);
            TableColumn cd = frmvp.tb_profesores.getColumn("DNI");
            cd.setMaxWidth(90);
            TableColumn ce = frmvp.tb_profesores.getColumn("Activo");
            ce.setMaxWidth(90);
         }
         if(ae.getSource() == frmvm.btn_cambiar){
             
             modp.setIdProfesor(Integer.parseInt(frmvm.sp_idprofesor.getValue().toString()));
             modm.setIdMateria(Integer.parseInt(frmvm.sp_idmateria.getValue().toString()));
             modm.setCupos(Integer.parseInt(frmvm.txt_cupos.getText()));
             modm.setHorarios(frmvm.txt_horarios.getText());
            
            if(cmodm.cambiar(modm,modp)){
                JOptionPane.showMessageDialog(null,"Estado actualizado");
                cmodm.ver(modm,modp,frmvm.tb_materias);
            }
            else
                JOptionPane.showMessageDialog(null,"Error!");
            
         }
    }
    
 
}
