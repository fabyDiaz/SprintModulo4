package com.stz.model;

/**
 * com.stz.model
 *
 * @author Sergio Teran on 01-07-2022
 */
public class Usuario implements IAsesoria{

    private String nombre;
    private String fechaNacimiento;
    private int run;

    public Usuario() {
    }

    public Usuario(String nombre, String fechaNacimiento, int run) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    /**
     * despliegue el nombre y el RUN
     */
    @Override
    public void analizarUsuario() {

        System.out.println("Nombre Usuario: " + getNombre() + ", run: " + getRun());

    }

    /**
     * Retorna un mensaje que diga �El usuario  tiene X a�os� y en donde X es la edad del usuario en cuesti�n
     * @return String
     */
    public String mostrarEdad(){

        return "";
    }
}
