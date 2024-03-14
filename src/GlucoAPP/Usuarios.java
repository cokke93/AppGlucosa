package GlucoAPP;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jorge Pedrajas Rubio
 * @version 1.0.0 27 feb 2024 18:02:31
 */
public class Usuarios {

    /**
     * El nombre del usuario
     */
    private String nombre;

    /**
     * La edad del usuario
     */
    private int edad;

    /**
     * El peso del usuario
     */
    private double peso;

    /**
     * El centro de salud del usuario
     */
    private String centroSalud;

    /**
     * La edad en la que el usuario tuvo su debut diabético
     */
    private final int debut;

    /**
     * El ID único del usuario
     */
    private int idUsuario = 0;

    /**
     * El número total de usuarios creados
     */
    private static int totalUsuarios;

    /**
     * El control de glucosa asociado a este usuario
     */
    private final ControlGlucosa controlGlucosa;

    /**
     * Registro de usuarios
     */
    private static ArrayList<Usuarios> regUsuarios = new ArrayList<>();

    /**
     * Constructor de la clase Usuarios.
     *
     * @param nombre El nombre del usuario.
     * @param edad La edad del usuario.
     * @param peso El peso del usuario.
     * @param centroSalud El centro de salud del usuario.
     * @param debut La edad en la que el usuario debutó en la diabetes.
     * @param marca del aparato de control del usuario.
     */
    public Usuarios(String nombre, int edad, double peso, String centroSalud, int debut, String marca) {

        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.centroSalud = centroSalud;
        this.debut = debut;
        totalUsuarios++;
        this.idUsuario = totalUsuarios;
        this.controlGlucosa = new ControlGlucosa(marca);

    }

    /**
     * Obtiene el objeto ControlGlucosa asociado a este usuario
     *
     * @return El objeto ControlGlucosa asignado al usuario
     */
    public ControlGlucosa getControlGlucosa() {
        return controlGlucosa;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la edad del usuario.
     *
     * @return La edad del usuario.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Obtiene el peso del usuario.
     *
     * @return El peso del usuario.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Obtiene el centro de salud del usuario.
     *
     * @return El centro de salud del usuario.
     */
    public String getCentroSalud() {
        return centroSalud;
    }

    /**
     * Obtiene la edad en la que el usuario debutó.
     *
     * @return La edad en la que el usuario debutó.
     */
    public int getDebut() {
        return debut;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return El ID del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Obtiene el número total de usuarios creados.
     *
     * @return El número total de usuarios creados.
     */
    public static int getTotalUsuarios() {
        return totalUsuarios;
    }

    /**
     * Modifica el nombre del usuario.
     *
     *
     */
    public void modificarNombre() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre actual: " + this.nombre);
        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = sc.nextLine();
        this.nombre = nuevoNombre;
        System.out.println("Nombre modificado correctamente.");
        System.out.println("");
    }

    /**
     * Modifica la edad del usuario.
     *
     */
    public void modificarEdad() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Edad actual: " + this.edad);
        System.out.print("Ingrese la nueva edad: ");
        int nuevaEdad = sc.nextInt();
        sc.nextLine();
        this.edad = nuevaEdad;
        System.out.println("Edad modificada correctamente.");
        System.out.println("");

    }

    /**
     * Modifica el peso del usuario.
     *
     */
    public void modificarPeso() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Peso actual: " + this.peso);
        System.out.print("Ingrese el nuevo peso: ");
        double nuevoPeso = sc.nextDouble();
        sc.nextLine();
        this.peso = nuevoPeso;
        System.out.println("Peso modificado correctamente.");
        System.out.println("");

    }

    /**
     * Cambia el centro de salud del usuario.
     *
     */
    public void cambiarCentroSalud() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Centro de salud actual: " + this.centroSalud);
        System.out.print("Ingrese el nuevo centro de salud: ");
        String nuevoCentroSalud = sc.nextLine();
        this.centroSalud = nuevoCentroSalud;
        System.out.println("Centro de salud modificado correctamente.");
        System.out.println("");

    }

    /**
     * Metodo que evuelve el registro de usuarios
     *
     * @return registro de usuarios
     */
    public static ArrayList<Usuarios> getRegUsuarios() {
        return regUsuarios;
    }

    /**
     * Metodo que muestra y devuelve los usuarios almacenados para
     * seleccionarlos
     *
     * @return devuelve el usuario seleccionado
     */
    public static Usuarios seleccionarUsuario() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el usuario existente:");

        for (int i = 0; i < regUsuarios.size(); i++) {
            System.out.println((i + 1) + ". " + regUsuarios.get(i).getNombre());
        }
        int opcion = sc.nextInt();
        sc.nextLine();

        return regUsuarios.get(opcion - 1);

    }

    /**
     *
     * @return Informacion usuarios
     */
    public String datosUsuario() {
        return "--------- Datos Usuario ---------\n"
                + "Nombre: " + this.nombre + "\n"
                + "Edad: " + this.edad + "\n"
                + "Peso: " + this.peso + "\n"
                + "Centro de salud: " + this.centroSalud + "\n"
                + "Edad de debut diabético: " + this.debut + "\n"
                + "NºUsuario: " + this.idUsuario;

    }

}
