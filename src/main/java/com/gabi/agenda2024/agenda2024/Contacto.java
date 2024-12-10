/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gabi.agenda2024.agenda2024;

import java.time.LocalDate;

/**
 *
 * @author alu15d
 */
public class Contacto implements Comparable<Contacto>{
    
    // atributos
    private String nombre;
    private String telefono;
    private String email;
    private LocalDate fechaNac;

    /**
     * Se crea este metodo en caso de que alguien no introduzca su email ni su fecha de nacimiento.
     * @param nombre
     * @param telefono
     */
    public Contacto(String nombre, String telefono) {
        this(nombre,telefono,null);
    } 
    
    
    /**
     * Se crea este metodo en caso de que alguien no introoduzca su fecha de nacimiento.
     * @param nombre
     * @param telefono
     * @param email
     */
    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    
    /**
     * Se crea este metodo en caso de que alguien introduzca todos los datos.
     * @param nombre
     * @param telefono
     * @param email
     */
    public Contacto(String nombre, String telefono, String email, LocalDate fechaNac) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.fechaNac = fechaNac;
    }

    
    @Override
    public String toString() {
        return "Contacto [nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + "]";
    }

    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getFechaNac() {
        return fechaNac;
    }
    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public int compareTo(Contacto c) {
        return this.getNombre().compareToIgnoreCase(c.getNombre());
    }   
}
