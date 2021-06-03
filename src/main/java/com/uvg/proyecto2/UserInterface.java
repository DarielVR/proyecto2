package com.uvg.proyecto2;

import java.util.Scanner;

public class UserInterface {

    Scanner scan = new Scanner(System.in);

    public void MenuBienvenida () {
        System.out.println(
            "Bienvenido al sistema de recomendacion de juegos.\nPor favor, elija una opcion." +
            "\n1. Iniciar sesion\n2. Registrarse\n3. Salir"
            );
        boolean loop = true;
        while (loop) {
            switch (LeerNumero()) {
                case 1:
                    IniciarSesion();
                    MenuUsuario();
                    break;
                case 2:
                    Registrarse();
                    MenuUsuario();
                    break;
                case 3:
                    loop = false;
                default:
                    break;
            }
        }
    }
    
    private String[] IngresoDatos () {
        System.out.println("\nPor favor, Ingrese su nombre de usuario y clave.");
        String[] registro = new String[2];
        registro[0] = scan.nextLine();
        registro[1] = scan.nextLine();
        return registro;
    }

    private boolean comprobarUsuario (String nombre, String clave) {
        return false;
    }

    private boolean comprobarUsuario (String nombre) {
        return false;
    }

    private boolean IniciarSesion () {
        boolean comprobado = true;
        while (comprobado) {
            String[] registro = IngresoDatos();
            boolean comprobacion = comprobarUsuario(registro[0], registro[1]);
            if (comprobacion == false) {
                System.out.println("Nombre o clave incorrectos.");
                comprobado = nuevoIntento();  
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean Registrarse () {
        boolean comprobado = true;
        while (comprobado) {
            String[] registro = IngresoUsuario();
            boolean comprobacion = comprobarUsuario(registro[0]);
            if (comprobacion == false) {
                System.out.println("Nombre de usuario ya está registrado.");
                comprobado = nuevoIntento();  
            } else {
                return true;
            }
        }
        return false;
    }

    private void MenuUsuario () {
        System.out.println(
            "Bienvenido al sistema de recomendacion de juegos.\nPor favor, elija una opcion." +
            "\n1. Buscar juegos\n2. BorrarCuenta\n3. Salir"
            );
        boolean loop = true;
        while (loop) {
            switch (LeerNumero()) {
                case 1:
                    BuscarJuegos();
                    break;
                case 2:
                    BorrarCuenta();
                    break;
                case 3:
                    loop = false;
                default:
                    break;
            }
        }
    }

    private void BorrarCuenta() {
    }

    private void BuscarJuegos() {
    }

    private String[] IngresoUsuario () {
        System.out.println("\nPor favor, Ingrese un nombre de usuario, nombre y apellidos y clave.");
        String[] registro = new String[3];
        registro[0] = scan.nextLine();
        registro[1] = scan.nextLine();
        System.out.println("Ingrese su genero de videojuegos preferido:");
        registro[3] = scan.nextLine();
        return registro;
    }

    private boolean nuevoIntento () {
        System.out.println("Intentar de nuevo?(y/n)");
        while (true) {
            String string = scan.nextLine().toLowerCase();
            if(string == "y") {
                return true;
            }
            if (string == "n") {
                return false;
            }
            System.out.println("Entrada Incorrecta. La entrada debe ser (y/n)");
        }
    }

    private int LeerNumero () {
        try {
            int num = Integer.parseInt(scan.nextLine());
            return num;
        } catch (Exception e) {
            return 0;
        }
    }

    
}
