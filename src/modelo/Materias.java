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
public class Materias {
    
    private int idMateria;
    private String nombre;
    private String descripcion;
    private String horarios;
    private int cupos;

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
