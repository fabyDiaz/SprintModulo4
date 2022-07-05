package com.stz;

import com.stz.controller.Contenedor;

import java.util.Scanner;

public class Main {

    static boolean salir = false;
    static int opcion;
    static Scanner sc = new Scanner(System.in);
    static Contenedor contenedor = new Contenedor();

    public static void main(String[] args) {

        do {
            System.out.println("Selecciona una opción:\n"+
                    "1.-    Almacenar Cliente\n"+
                    "2.-    Almacenar Profesional\n"+
                    "3.-    Almacenar Administrativo\n"+
                    "4.-    Almacenar Capacitación\n"+
                    "5.-    Eliminar Usuario\n"+
                    "6.-    Listar Usuarios\n"+
                    "7.-    Listar Usuarios Por Tipo\n"+
                    "8.-    Listar Capacitaciones\n"+
                    "9.-    Para SALIR"
            );

            try{
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion){
                    case 1:
                        validaCliente();
                        sc.nextLine();
                        break;
                    case 2:
                        validaProfesional();
                        sc.nextLine();
                        break;
                    case 3:
                        validaAdministrativo();
                        sc.nextLine();
                        break;
                    case 4:
                        validaCapacitacion();
                        break;
                    case 5:
                        System.out.println("ingrese rut del usuario a eliminar");
                        int rut= validaRut();
                        contenedor.eliminarUsuario(rut);

                        break;
                    case 6:
                        contenedor.listarUsuarios();
                        sc.nextLine();
                        break;
                    case 7:
                        System.out.println("listar user x tipo");
                        usuarioPorTipo();
                        break;
                    case 8:
                        contenedor.listarCapacitaciones();
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                }
            }catch (NumberFormatException e){
                System.out.println("Solo números");
            }
        }while (!salir);
    }

    public static void validaCliente(){

        boolean salir = false;
        int rut;
        int sistSalud = 0;
        int edad = 0;
        String nombre, apellido, telefono, afp, direccion, comuna;
        String fechaNac = "nacimiento";
        String nombreUser;
        Scanner sc = new Scanner(System.in);

        nombreUser = validaNombreUser();
        fechaNac = validaFechas(fechaNac);
        rut = validaRut();


        do {
            System.out.println("Nombres Cliente:");
            nombre = sc.nextLine();
            if (nombre.matches("[a-zA-Z]{5,30}")){
                salir = true;
            }else {
                System.out.println("Formato incorrecto");
            }
        }while (!salir);
        salir = false;

        do {
            System.out.println("Apellidos Cliente:");
            apellido = sc.nextLine();
            if (apellido.matches("[a-zA-Z]{5,30}")){
                salir = true;
            }else {
                System.out.println("Formato incorrecto");
            }
        }while (!salir);
        salir = false;

        do {
            System.out.println("Teléfono Cliente");
            telefono = sc.nextLine();
            if (telefono.matches("\\D*([+56]\\d[2-9])(\\d{4})(\\d{4})\\D*")){
                salir = true;
            }else {
                System.out.println("Incorrecto");
            }
        }while (!salir);
        salir = false;

        do {
            System.out.println("AFP Cliente:");
            afp = sc.nextLine();
            if (afp.matches("[a-zA-Z]{4,30}")){
                salir = true;
            }else {
                System.out.println("Formato incorrecto");
            }
        }while (!salir);
        salir = false;

        do {
            System.out.println("""
                    Sistema de Salud:
                    1.-    Fonasa
                    2.-    Isapre""");
            try {
                sistSalud = Integer.parseInt(sc.nextLine());
                if (sistSalud == 1 || sistSalud == 2){
                    salir = true;
                }else System.out.println("Opción incorrecta");
            }catch (NumberFormatException e){
                System.out.println("1 o 2");
            }
        }while (!salir);
        salir = false;


        do {
            System.out.println("Dirección Cliente:");
            direccion = sc.nextLine();
            if (direccion.matches("[\\D\\d]{1,70}")){
                salir = true;
            }else {
                System.out.println("Formato incorrecto");
            }
        }while (!salir);
        salir = false;

        do {
            System.out.println("Comuna Cliente:");
            comuna = sc.nextLine();
            if (comuna.matches("[a-zA-Z]{1,50}")){
                salir = true;
            }else {
                System.out.println("Formato incorrecto");
            }
        }while (!salir);
        salir = false;

        do {
            System.out.println("Edad Cliente:");
            try {
                edad = Integer.parseInt(sc.nextLine());
                if (edad >= 0 && edad < 150){
                    salir = true;
                }
            }catch (NumberFormatException e){
                System.out.println("Solo números");
            }

        }while (!salir);
        salir = false;


        contenedor.almacenarCliente(nombreUser, fechaNac, rut, nombre, apellido, telefono, afp, sistSalud, direccion, comuna, edad);

    }

    /**
     * Valida datos del prosefional
     */
    public static void validaProfesional(){

        String titulo;
        String fechaIngreso = "ingreso";
        String nombreUser;
        int run;
        String fechaNac = "nacimiento";

        nombreUser = validaNombreUser();
        run = validaRut();
        fechaNac = validaFechas(fechaNac);

        do {
            System.out.println("Título:");
            titulo = sc.nextLine();
            if (titulo.matches("^[A-Za-z\\s]{10,50}$")){
                salir = true;
            }else {
                System.out.println("Solo texto. 10 a 50 caracteres");
            }
        }while (!salir);
        salir = false;

        fechaIngreso = validaFechas(fechaIngreso);

        contenedor.almacenarProfesional(nombreUser, run, fechaNac, titulo, fechaIngreso);

    }

    public static void validaAdministrativo(){

        String area;
        String exPrevia;
        String nombreUser;
        String fechaNacUser = "nacimiento";
        int runUser;

        nombreUser = validaNombreUser();
        fechaNacUser = validaFechas(fechaNacUser);
        runUser = validaRut();

        do {
            System.out.println("Area:");
            area = sc.nextLine();
            if (area.matches("^[A-Za-z\\s]{5,20}$")){
                salir = true;
            }else {
                System.out.println("Solo texto. 5 a 20 caracteres");
            }
        }while (!salir);
        salir = false;

        do {
            System.out.println("Experiencia previa:");
            exPrevia = sc.nextLine();
            if (exPrevia.matches("^[A-Za-z\\s\\d\\D]{10,100}$")){
                salir = true;
            }else {
                System.out.println("Letras y numeros, máximo 100 caracteres");
            }
        }while (!salir);
        salir = false;

        contenedor.almacenarAdministrativo(nombreUser, fechaNacUser, runUser, area, exPrevia);

    }

    /**
     * Validar run ingresado
     * @return rut
     */
    public static int validaRut(){

        int run = 0;
        String cadena;

        do {
            System.out.println("Ingresa RUN:");
            cadena = sc.nextLine();

            if (cadena.matches("[0-9]{7,8}")){
                try{
                    run =Integer.parseInt(cadena);
                    salir = true;
                }catch (NumberFormatException e){
                    System.out.println("Solo números");
                }
            }else {
                System.out.println("Rango 9.999.999 a 99.999.999");
            }

        }while (!salir);
        salir = false;

        return run;

    }

    /**
     * Valida fecha ingresada
     * @return fecha
     */
    public static String validaFechas(String cadena){

        String fecha;

        do {
            System.out.println("Fecha de " + cadena);
            fecha = sc.nextLine();
            if (fecha.matches("(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[\\/]\\d{4}")){
                salir = true;
            }else {
                System.out.println("Formatao de ser dd/mm/aaaa");
            }
        }while (!salir);
        salir = false;

        return fecha;

    }

    /**
     * Valida el nombre del usuario
     * @return String usuario
     */
    public static String validaNombreUser(){

        String nombre;

        do {
            System.out.println("Nombre de Usuario:");
            nombre = sc.nextLine();
            if (nombre.matches("^[A-Za-z\\s\\d]{10,50}$")){
                salir = true;
            }else {
                System.out.println("Solo letras, 10 a 50 caracteres");
            }
        }while (!salir);
        salir = false;

        return nombre;
    }

    /**
     * Valida datos de capacitaciones
     */

    public static void validaCapacitacion(){
        int id=0, rut, asistentes=0;
        String dia, hora, lugar, duracion;
        do {
            System.out.println("Identificador:");
            try {
                id = Integer.parseInt(sc.nextLine());
                if (id > 0){
                    salir = true;
                }
            }catch (NumberFormatException e){
                System.out.println("Solo números");
            }
        }while (!salir);
        salir = false;

        rut= validaRut();

        do {
            System.out.println("Día:");
            dia = sc.nextLine();
            if(dia.equalsIgnoreCase("Lunes")||dia.equalsIgnoreCase("Martes")
            ||dia.equalsIgnoreCase("Miercoles")||dia.equalsIgnoreCase("Jueves")
            ||dia.equalsIgnoreCase("Viernes")||dia.equalsIgnoreCase("Sabado")
            ||dia.equalsIgnoreCase("Domingo")){
                salir=true;
            } else {
                System.out.println("El día ingresado no es válido");
            }
        }while (!salir);
        salir = false;

        do {
            System.out.println("Hora (HH:MM): ");
            hora = sc.nextLine();
            if (hora.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")){
                salir = true;
            }else {
                System.out.println("Formato debe ser HH:MM");
            }
        }while (!salir);
        salir = false;

        do {
            System.out.println("Lugar Capacitación:");
            lugar = sc.nextLine();
            if (lugar.matches("^[A-Za-z\\s\\d]{10,50}$")){
                salir = true;
            }else {
                System.out.println("Solo letras, 10 a 50 caracteres");
            }
        }while (!salir);
        salir = false;

        do {
            System.out.println("Duración Capacitación:");
            duracion = sc.nextLine();
            if (duracion.length()<=70){
                salir = true;
            }else {
                System.out.println("máximo 70 caracteres");
            }
        }while (!salir);
        salir = false;

        do {
            System.out.println("Cantidad de Asistentes:");
            try {
                asistentes = Integer.parseInt(sc.nextLine());
                if (asistentes > 0 && asistentes<=1000){
                    salir = true;
                }
            }catch (NumberFormatException e){
                System.out.println("Solo números");
            }
        }while (!salir);
        salir = false;
        contenedor.almacenarCapacitacion(id,rut,dia,hora,lugar,duracion,asistentes);
    }


    public static void usuarioPorTipo(){

        do {

            System.out.println("""
                    Tipo de Usuario
                    1.-    Cliente
                    2.-    Profesional
                    3.-    Administrativo
                    4.-    Volver""");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion){
                case 1:
                    contenedor.listarUsuariosPorTipo("Cliente");
                    break;
                case 2:
                    contenedor.listarUsuariosPorTipo("Profesional");
                    break;
                case 3:
                    contenedor.listarUsuariosPorTipo("Administrativo");
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        }while (!salir);
        salir = false;

    }


}
