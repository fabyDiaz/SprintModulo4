package com.stz.model;

/**
 * com.stz.model
 *
 * @author Sergio Teran on 01-07-2022
 */
public class Administrativo extends Usuario{

    private String area;
    private String experiencia;

    public Administrativo() {
    }

    public Administrativo(String nombre, String fechaNacimiento, int run, String area, String experiencia) {
        super(nombre, fechaNacimiento, run);
        this.area = area;
        this.experiencia = experiencia;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "Administrativo{" +
                "area='" + area + '\'' +
                ", experiencia='" + experiencia + '\'' +
                '}';
    }
}