/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication20;

/**
 * @author Jorge Pedrajas Rubio
 * @version 1.0.0 27 feb 2024 18:03:22
 */
import java.util.Scanner;

public class App_prin {

    public static void main(String[] args) {

        Control_Glucosa Jorge = crearControl();
        crearUsuario(Jorge);

        Jorge.registrarGlucosa(2000);
        Jorge.registrarGlucosa(1000);
        Jorge.registrarGlucosa(60);

        System.out.println("");
        Jorge.consultarHistorial();
        System.out.println("");
        System.out.println("");
        System.out.println(Jorge.informeGeneral());

    }

    /**
     * //Crea el objeto de control mediante un cuestionario
     *
     * @return Devuelve un objeto de tipo Control_Glucosa
     */
    public static Control_Glucosa crearControl() {
        Scanner sc = new Scanner(System.in);
        Control_Glucosa control = null;
        String confirmacion;

        System.out.println("[Bienvenido a su registro de glucosa personal]");

        do {
            try {
                System.out.println("Por favor, introduzca la marca de su dispositivo de control:");
                String marca = sc.nextLine();

                System.out.println("Marca introducida: " + marca);
                System.out.println("¿Es correcto? (Si/No)");
                confirmacion = sc.nextLine();

                if (confirmacion.equalsIgnoreCase("Si") || marca.equalsIgnoreCase("Sí")) {
                    control = new Control_Glucosa(marca);
                } else if (confirmacion.equalsIgnoreCase("No")) {
                    System.out.println("Datos incorrectos, reinicie el cuestionario");
                } else {
                    System.out.println("Respuesta inválida. Por favor, responda Si o No.");
                }
            } catch (Exception e) {
                System.out.println("Error al crear el control. Reiniciando cuestionario");
            }
        } while (control == null);

        return control;

    }

    /**
     * Metodo que crea un usuario mediante Scanner
     *
     * @param Registro Se le pasa por parametro un objeto Control_Glucosa
     * @return Devuelve un objeto usuario
     */
    public static Usuarios crearUsuario(Control_Glucosa Registro) {
        Scanner sc = new Scanner(System.in);
        String confirmacion;
        Usuarios usuario = null;

        do {
            try {
                System.out.println("[Datos Personales]");
                System.out.println("Introduzca su nombre:");
                String nombre = sc.nextLine();
                System.out.println("Introduzca su edad:");
                int edad = sc.nextInt();
                sc.nextLine();
                System.out.println("Introduzca su peso:");
                double peso = sc.nextDouble();
                sc.nextLine();
                System.out.println("Introduzca la edad en la que debutó:");
                int debut = sc.nextInt();
                sc.nextLine();
                System.out.println("Por último, introduzca su centro de salud:");
                String centro = sc.nextLine();

                System.out.println("Datos introducidos:");
                System.out.println("Nombre: " + nombre + "\nEdad: " + edad + "\nPeso: " + peso + "\nDebut: " + debut + "\nCentro de salud: " + centro);
                System.out.println("");

                System.out.println("¿Los datos son correctos? (Si/No)");
                confirmacion = sc.nextLine();

                if (confirmacion.equalsIgnoreCase("Si") || confirmacion.equalsIgnoreCase("Sí")) {
                    System.out.println("[Usuario creado]");
                    usuario = new Usuarios(nombre, edad, peso, centro, debut, Registro);
                } else if (confirmacion.equalsIgnoreCase("No")) {
                    System.out.println("Datos incorrectos, reinicie el cuestionario");
                } else {
                    System.out.println("Respuesta inválida. Por favor, responda Si o No.");
                }
            } catch (Exception e) {
                System.out.println("Error al crear el usuario. Reiniciando cuestionario");
                sc.nextLine();
            }
        } while (usuario == null);

        sc.close();
        return usuario;
    }
}
