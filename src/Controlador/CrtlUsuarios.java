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
import modelo.ConsultasProfesores;
import modelo.ConsultasUsuarios;
import modelo.Materias;
import modelo.Profesores;
import modelo.Usuarios;
import vista.LoginUsuarios;
import vista.MenuAdmin;
import vista.MenuAlumno;
import vista.RegistroUsuarios;
import vista.VistaMateriasAdmin;
import vista.VistaMateriasAlumno;
import vista.VistaProfesores;




/**
 *
 * @author Elias
 */
public class CrtlUsuarios implements ActionListener {

    private Usuarios mod;
    private Profesores modp;
    private Materias modm;
    private ConsultasUsuarios cmod;
    private ConsultasProfesores cmodp;
    private ConsultasMaterias cmodm;
    private RegistroUsuarios frmr;
    private LoginUsuarios frml;
    private MenuAdmin frmma;
    private MenuAlumno frmmal;
    private VistaProfesores frmvp;
    private VistaMateriasAdmin frmvm;
    private VistaMateriasAlumno frmvma;
    private CtrlAdministradores cta;
    private CtrlAlumnos ctal;


    public CrtlUsuarios(Usuarios mod, Profesores modp, Materias modm, ConsultasUsuarios cmod, ConsultasProfesores cmodp, ConsultasMaterias cmodm, 
            RegistroUsuarios frmr, LoginUsuarios frml, MenuAdmin frmma, MenuAlumno frmmal, VistaProfesores frmvp, VistaMateriasAdmin frmvm, 
            VistaMateriasAlumno frmvma, CtrlAdministradores cta, CtrlAlumnos ctal) {
        this.mod = mod;
        this.modp = modp;
        this.modm = modm;
        this.cmod = cmod;
        this.cmodp = cmodp;
        this.cmodm = cmodm;
        this.frmr = frmr;
        this.frml = frml;
        this.frmma = frmma;
        this.frmmal = frmmal;
        this.frmvp = frmvp;
        this.frmvm = frmvm;
        this.frmvma = frmvma;
        this.cta = cta;
        this.ctal = ctal;
        this.frmr.btn_registro.addActionListener(this);
        this.frmr.menu_login.addActionListener(this);
        this.frml.menu_registro.addActionListener(this);
        this.frml.btn_login_admin.addActionListener(this);
        this.frml.btn_login_alumno.addActionListener(this);
        this.frml.btn_alumno.addActionListener(this);
        this.frml.btn_admin.addActionListener(this);
        this.frmmal.btn_materias.addActionListener(this);

    }
    
    public void iniciar(){
        
        frmr.setTitle("Registro de Usuarios") ;
        frmr.setLocationRelativeTo(null);
    
    }
    
    public void limpiar(){
        frmr.txt_nombre.setText("");
        frmr.txt_apellido.setText("");
        frmr.txt_dni.setText("");
        frmr.txt_contra.setText("");
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == frmr.btn_registro){
            mod.setNombre(frmr.txt_nombre.getText());
            mod.setApellido(frmr.txt_apellido.getText());
            mod.setDni(Integer.parseInt(frmr.txt_dni.getText()));
            mod.setRol(frmr.cmb_tipousuario.getSelectedItem().toString());
            mod.setContrasenia(frmr.txt_contra.getText());
            
            if(mod.getNombre().equals("") || mod.getApellido().equals("") || mod.getContrasenia().equals("") || mod.getDni()==0)
            
                JOptionPane.showMessageDialog(null,"Debe llenar todos los campos \n");
            else{
                
                if(cmod.registrar(mod)){
                JOptionPane.showMessageDialog(null,"Registro Exitoso");
                limpiar();
                }
                else
                JOptionPane.showMessageDialog(null,"Error!");
                
            }
        }
        
        if(ae.getSource() == frml.btn_login_admin){
        
            mod.setNombre(frml.txt_nombre.getText());
            mod.setApellido(frml.txt_apellido.getText());
            mod.setContrasenia(frml.txt_contra.getText());
            if(mod.getNombre().equals("") || mod.getApellido().equals("") || mod.getContrasenia().equals("") )
            
                JOptionPane.showMessageDialog(null,"Debe llenar todos los campos \n");
            else{
                
                if(cmod.loginadmin(mod)){
                JOptionPane.showMessageDialog(null,"Logueo Exitoso");
                frmma.setVisible(true);
                frmma.setLocationRelativeTo(null);
                frml.dispose();

                }
                else
                JOptionPane.showMessageDialog(null,"Error!");
                
            }
        }
         if(ae.getSource() == frml.btn_login_alumno){
        
            mod.setDni(Integer.parseInt(frml.txt_dni.getText()));
            mod.setId(Integer.parseInt(frml.txt_legajo.getText()));
            
            if("".equals(Integer.toString(mod.getId())) || "".equals(Integer.toString(mod.getDni())))
            
                JOptionPane.showMessageDialog(null,"Debe llenar todos los campos \n");
            else{
                
                if(cmod.loginalumnos(mod)){
                JOptionPane.showMessageDialog(null,"Logueo Exitoso");
                frmmal.setVisible(true);
                frmmal.setTitle("Menu de Alumnos");
                frmmal.setLocationRelativeTo(null);
                frml.dispose();
                }
                else
                JOptionPane.showMessageDialog(null,"Error!");
                
            }
        }
        
         if(ae.getSource() == frmr.menu_login){
            frml.setVisible(true);
            frmr.dispose();
            frml.setTitle("Iniciar Sesión");
            frml.setLocationRelativeTo(null);
            frml.lbl_alumno.setVisible(false);
            frml.lbl_admin.setVisible(false);
            frml.lbl_nombre.setVisible(false);
            frml.lbl_apellido.setVisible(false);
            frml.lbl_dni.setVisible(false);
            frml.lbl_legajo.setVisible(false);
            frml.txt_nombre.setVisible(false);
            frml.txt_apellido.setVisible(false);
            frml.txt_dni.setVisible(false);
            frml.txt_legajo.setVisible(false);
            frml.btn_login_admin.setVisible(false);
            frml.btn_login_alumno.setVisible(false);
            frml.lbl_contra.setVisible(false);
            frml.txt_contra.setVisible(false);
        
        }
         if(ae.getSource() == frml.menu_registro){
            
            frmr.setVisible(true);
            frml.dispose();
        
        }
    
         if(frml.btn_alumno == ae.getSource()){
            frml.lbl_admin.setVisible(false);
            frml.lbl_nombre.setVisible(false);
            frml.lbl_apellido.setVisible(false);
            frml.txt_nombre.setVisible(false);
            frml.txt_apellido.setVisible(false);
            frml.btn_login_admin.setVisible(false);
            frml.lbl_alumno.setVisible(true);
            frml.lbl_dni.setVisible(true);
            frml.lbl_legajo.setVisible(true);
            frml.txt_dni.setVisible(true);
            frml.txt_legajo.setVisible(true);
            frml.btn_login_alumno.setVisible(true);
            frml.lbl_contra.setVisible(false);
            frml.txt_contra.setVisible(false);
        }
        
         if(ae.getSource() == frml.btn_admin){
            frml.lbl_admin.setVisible(true);
            frml.lbl_nombre.setVisible(true);
            frml.lbl_apellido.setVisible(true);
            frml.txt_nombre.setVisible(true);
            frml.txt_apellido.setVisible(true);
            frml.btn_login_admin.setVisible(true);
            frml.lbl_alumno.setVisible(false);
            frml.lbl_dni.setVisible(false);
            frml.lbl_legajo.setVisible(false);
            frml.txt_dni.setVisible(false);
            frml.txt_legajo.setVisible(false);
            frml.btn_login_alumno.setVisible(false);
            frml.lbl_contra.setVisible(true);
            frml.txt_contra.setVisible(true);
        
        }

    }

    
 }
    
    
    


