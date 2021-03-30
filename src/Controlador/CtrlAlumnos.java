/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasMaterias;
import modelo.Materias;
import modelo.Profesores;
import modelo.Usuarios;
import vista.LoginUsuarios;
import vista.MenuAlumno;
import vista.VistaMateriasAlumno;

/**
 *
 * @author Elias
 */
public class CtrlAlumnos implements ActionListener{
    private MenuAlumno frmma;
    private VistaMateriasAlumno frmvma;
    private Profesores modp;
    private Materias modm;
    private Usuarios mod;
    private ConsultasMaterias cmodm;
    private LoginUsuarios frml;

    public CtrlAlumnos(MenuAlumno frmma, VistaMateriasAlumno frmvma, Profesores modp, Materias modm, Usuarios mod, ConsultasMaterias cmodm, LoginUsuarios frml) {
        this.frmma = frmma;
        this.frmvma = frmvma;
        this.modp = modp;
        this.modm = modm;
        this.mod = mod;
        this.cmodm = cmodm;
        this.frml = frml;
        this.frmma.btn_materias.addActionListener(this);
        this.frmma.menu_cerrar.addActionListener(this);
        this.frmvma.btn_anotarse.addActionListener(this);
        this.frmvma.btn_seleccionar.addActionListener(this);
        this.frmvma.menu_menu.addActionListener(this);
        this.frmvma.menu_cerrar.addActionListener(this);
        
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
        
        if(ae.getSource() == frmma.btn_materias){
             
             frmvma.setVisible(true);
             frmvma.setTitle("Materias");
             frmvma.setLocationRelativeTo(null);
             frmma.dispose();
         
         }
        if(ae.getSource() == frmvma.menu_menu){
            frmma.setVisible(true);
            frmma.setLocationRelativeTo(null);
            frmvma.dispose();
        }
         if(ae.getSource() == frmvma.menu_cerrar){
             
             frml.setVisible(true);
             frml.setLocationRelativeTo(null);
             frml.txt_nombre.setText("");
             frml.txt_apellido.setText("");
             frml.txt_contra.setText("");
             frml.txt_legajo.setText("");
             frml.txt_dni.setText("");
             frmvma.dispose();
        }
         if(ae.getSource() == frmvma.btn_seleccionar){
             
             if(frmvma.cmb_materias.getSelectedItem().toString().equals("Álgebra y Geometría Analítica"))
                modm.setIdMateria(3);
             else if(frmvma.cmb_materias.getSelectedItem().toString().equals("Algortimos y Estructuras de Datos"))
                 modm.setIdMateria(5);
             else if(frmvma.cmb_materias.getSelectedItem().toString().equals("Análisis Matemático I"))
                modm.setIdMateria(2);
             else if(frmvma.cmb_materias.getSelectedItem().toString().equals("Arquitectura de Computadoras"))
                 modm.setIdMateria(8);
             else if(frmvma.cmb_materias.getSelectedItem().toString().equals("Ingeniería y Sociedad"))
                 modm.setIdMateria(1);
             else if(frmvma.cmb_materias.getSelectedItem().toString().equals("Matemática Discreta"))
                 modm.setIdMateria(6);
             else if(frmvma.cmb_materias.getSelectedItem().toString().equals("Química"))
                 modm.setIdMateria(4);
             else if(frmvma.cmb_materias.getSelectedItem().toString().equals("Sistemas y Organizaciones"))
                 modm.setIdMateria(7);
             
             if(cmodm.seleccionar(modm, frmvma.tb_descripcion));
             
             else
                JOptionPane.showMessageDialog(null,"Error!");

         }
         
         if(ae.getSource() == frmvma.btn_anotarse){
             
             if(frmvma.cmb_materias.getSelectedItem().toString().equals("Álgebra y Geometría Analítica"))
                modm.setIdMateria(3);
             else if(frmvma.cmb_materias.getSelectedItem().toString().equals("Algortimos y Estructuras de Datos"))
                 modm.setIdMateria(5);
             else if(frmvma.cmb_materias.getSelectedItem().toString().equals("Análisis Matemático I"))
                modm.setIdMateria(2);
             else if(frmvma.cmb_materias.getSelectedItem().toString().equals("Arquitectura de Computadoras"))
                 modm.setIdMateria(8);
             else if(frmvma.cmb_materias.getSelectedItem().toString().equals("Ingeniería y Sociedad"))
                 modm.setIdMateria(1);
             else if(frmvma.cmb_materias.getSelectedItem().toString().equals("Matemática Discreta"))
                 modm.setIdMateria(6);
             else if(frmvma.cmb_materias.getSelectedItem().toString().equals("Química"))
                 modm.setIdMateria(4);
             else if(frmvma.cmb_materias.getSelectedItem().toString().equals("Sistemas y Organizaciones"))
                 modm.setIdMateria(7);
             
             if(cmodm.anotarse(modm, mod)){
                 JOptionPane.showMessageDialog(null, "Anotado Correctamente!");
                 cmodm.descontarcupo(modm);
             }
             
             else
                 JOptionPane.showMessageDialog(null, "Error");
             
             
             
         }
         
    }
    
}
