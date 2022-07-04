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
            System.out.println("sca una opci�n:\n"+
                    "1.-    Almacenar Cliente\n"+
                    "2.-    Almacenar Profesional\n"+
                    "3.-    Almacenar Administrativo\n"+
                    "4.-    Almacenar Capacitaci�n\n"+
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
                        //System.out.println("almacenar pro");
                        break;
                    case 3:
                        validaAdministrativo();
                        sc.nextLine();
                        //System.out.println("almacenar admin");
                        break;
                    case 4:
                        System.out.println("almacenar cap");
                        break;
                    case 5:
                        System.out.println("eliminar user");
                        break;
                    case 6:
                        System.out.println("listar user");
                        break;
                    case 7:
                        System.out.println("listar user x tipo");
                        break;
                    case 8:
                        System.out.println("listar cap");
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opci�n incorrecta");
                }
            }catch (NumberFormatException e){
                System.out.println("Solo n�meros");
            }
        }while (!salir);
    }

    public static void validaCliente(){

        boolean salir = false;
        int rut = 0;
        int sistSalud = 0;
        int edad = 0;
        String nombre, apellido, telefono, afp, direccion, comuna;
        Scanner sc = new Scanner(System.in);

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
            System.out.println("Tel�fono Cliente");
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

            System.out.println("Sistema de Salud:\n"+
                    "1.-    Fonasa\n"+
                    "2.-    Isapre");
            try {
                sistSalud = Integer.parseInt(sc.nextLine());
                if (sistSalud == 1 || sistSalud == 2){
                    salir = true;
                }else System.out.println("Opci�n incorrecta");
            }catch (NumberFormatException e){
                System.out.println("1 o 2");
            }
        }while (!salir);
        salir = false;


        do {
            System.out.println("Direcci�n Cliente:");
            direccion = sc.nextLine();
            if (direccion.matches("[\\D\\d]{10,70}")){
                salir = true;
            }else {
                System.out.println("Formato incorrecto");
            }
        }while (!salir);
        salir = false;

        do {
            System.out.println("Comuna Cliente:");
            comuna = sc.nextLine();
            if (comuna.matches("[a-zA-Z]{5,40}")){
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
                System.out.println("Solo n�meros");
            }
        }while (!salir);
        salir = false;

        contenedor.almacenarCliente(rut, nombre, apellido, telefono, afp, sistSalud, direccion, comuna, edad);

    }

    public static void validaProfesional(){

        String titulo;
        String fechaIngreso;

        do {
            System.out.println("T�tulo:");
            titulo = sc.nextLine();
            if (titulo.matches("\\D{10,50}")){
                salir = true;
            }else {
                System.out.println("Solo texto. 10 a 50 caracteres");
            }
        }while (!salir);
        salir = false;
        fechaIngreso = "ingreso";
        fechaIngreso = validaFechas(fechaIngreso);

        /*do {
            System.out.println("Fecha de ingreso:");
            fechaIngreso = sc.nextLine();
            if (fechaIngreso.matches("(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}")){
                salir = true;
            }else {
                System.out.println("Formatao de ser dd/mm/aaaa");
            }
        }while (!salir);
        salir = false;*/

    }

    public static void validaAdministrativo(){

        String area;
        String exPrevia;

        String nombreUser;
        String fechaNacUser;
        int runUser;

        do {
            System.out.println("Nombre usuario:");
            nombreUser = sc.nextLine();
            if (nombreUser.matches("[\\D\\d]{10,50}")){
                salir = true;
            }else {
                System.out.println("10 a 50 caracteres");
            }
        }while (!salir);
        salir = false;

        fechaNacUser = "nacimiento";
        fechaNacUser = validaFechas(fechaNacUser);

        runUser = validaRut();

        do {
            System.out.println("Area:");
            area = sc.nextLine();
            if (area.matches("\\D{5,20}")){
                salir = true;
            }else {
                System.out.println("Solo texto. 5 a 20 caracteres");
            }
        }while (!salir);
        salir = true;

        do {
            System.out.println("Experiencia previa:");
            exPrevia = sc.nextLine();
            if (exPrevia.matches("[\\d\\D]{100}")){
                salir = true;
            }else {
                System.out.println("M�ximo 100 caracteres");
            }
        }while (!salir);
        salir = false;


    }


    /**
     * Validar run ingresado
     * @return rut
     */
    public static int validaRut(){

        int run = 0;

        do {
            System.out.println("Ingresa RUN:");
            try{
                run = Integer.parseInt(sc.nextLine());
                if (run > 99999999){
                    System.out.println("Supera rango");
                }else {
                    salir = true;
                }
            }catch (NumberFormatException e){
                System.out.println("Solo n�meros");
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

}
