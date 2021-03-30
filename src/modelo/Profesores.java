  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Elias
 */
public class Profesores {
    private int idProfesor;
    private Usuarios datos;
    private int activo;

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Usuarios getDatos() {
        return datos;
    }

    public void setDatos(Usuarios datos) {
        this.datos = datos;
    }

  
    
    
}
