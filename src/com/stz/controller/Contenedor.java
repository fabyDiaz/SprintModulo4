package com.stz.controller;

import com.stz.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * com.stz.controller
 *
 * @author Sergio Teran on 01-07-2022
 */
public class Contenedor {

    List<IAsesoria> asesorias;
    List<Capacitacion> capacitaciones;

    public Contenedor() {
        this.asesorias = new ArrayList<>();
        this.capacitaciones = new ArrayList<>();
    }

    /**
     * permite agregar un nuevo cliente a la lista de instancias dela interface Asesoria
     */
    public void almacenarCliente(String nombreUser, String fechaNac, int rut, String nombre, String apellido,
                                 String telefono, String afp, int sistSalud, String direccion, String comuna,
                                 int edad){

        asesorias.add(new Cliente(nombreUser, fechaNac, rut, rut, nombre, apellido, telefono, afp, sistSalud,
                direccion, comuna, edad));

        for (IAsesoria ia: asesorias) {
            ia.analizarUsuario();
        }
    }

    /**
     * permite agregar un nuevo profesional a la lista de instancias de la interface Asesoria
     */
    public void almacenarProfesional(String nombreUser, int run, String fechaNac, String titulo, String fechaIng){

        asesorias.add(new Profesional(nombreUser, fechaNac, run, titulo, fechaIng));

    }

    /**
     * permite agregar un nuevo administrativo a la lista de instancias de la interface Asesoria
     */
    public void almacenarAdministrativo(String nombreUser, String fecha, int run, String area, String exPre){

        asesorias.add(new Administrativo(nombreUser, fecha, run, area, exPre));

    }

    /**
     * permite agregar una nueva capacitaci�n a la lista de instancias de la clase Capacitaci�n
     */
    public void almacenarCapacitacion(){

    }

    /**
     * permite eliminar un usuario desde la lista de interfaces de Asesor�a acuerdo con el RUN del usuario
     */
    public void eliminarUsuario(){

    }

    /**
     * permite desplegar la lista completa de usuarios, independiente del tipo. En este m�todo solo se deben
     * desplegar los datos de la clase usuario
     */
    public void listarUsuarios(){

        for (IAsesoria ia: asesorias) {

            ia.analizarUsuario();

        }

    }

    /**
     * recibe un tipo de usuario (cliente, administrador o profesional), y retorna los datos respectivos seg�n
     * el tipo de usuario
     */
    public void listarUsuariosPorTipo(){

    }

    /**
     * este m�todo despliega las capacitaciones registradas en la lista respectiva, junto con los datos del
     * cliente al que est� asociada dicha capacitaci�n
     */
    public void listarCapacitaciones(){

    }
}
