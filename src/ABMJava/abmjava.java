/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABMJava;

import Controlador.CrtlUsuarios;
import Controlador.CrtlUsuarios;
import Controlador.CtrlAdministradores;
import Controlador.CtrlAlumnos;
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
public class abmjava {
    
    
    
    
    public static void main(String[] args){
        Usuarios u = new Usuarios();
        ConsultasUsuarios cu = new ConsultasUsuarios();
        RegistroUsuarios ru = new RegistroUsuarios();
        LoginUsuarios lu = new LoginUsuarios();
        MenuAdmin ma = new MenuAdmin ();
        VistaProfesores vp = new VistaProfesores();
        Profesores p = new Profesores();
        ConsultasProfesores cp = new ConsultasProfesores();
        Materias m = new Materias();
        ConsultasMaterias cm = new ConsultasMaterias();
        VistaMateriasAdmin vm = new VistaMateriasAdmin();
        MenuAlumno mal = new MenuAlumno();
        VistaMateriasAlumno vma = new VistaMateriasAlumno();
        CtrlAdministradores cta = new CtrlAdministradores(cp,p,vp,m,cm,vm,ma,lu);
        CtrlAlumnos ctal = new CtrlAlumnos(mal, vma, p, m, u, cm,lu);
        CrtlUsuarios ctu = new CrtlUsuarios(u,p,m,cu,cp,cm,ru,lu,ma,mal,vp,vm,vma,cta,ctal);

        ctu.iniciar();
        ru.setVisible(true);
    
        
    }
}
