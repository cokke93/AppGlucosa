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
     * @param controlGlucosa El objeto ControlGlucosa asociado al usuario.
     */
    public Usuarios(String nombre, int edad, double peso, String centroSalud, int debut, ControlGlucosa controlGlucosa) {

        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.centroSalud = centroSalud;
        this.debut = debut;
        totalUsuarios++;
        this.idUsuario = totalUsuarios;
        this.controlGlucosa = controlGlucosa;

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
     * @param nombre El nuevo nombre del usuario.
     */
    public void modificarNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Modifica la edad del usuario.
     *
     * @param edad La nueva edad del usuario.
     */
    public void modificarEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Modifica el peso del usuario.
     *
     * @param peso El nuevo peso del usuario.
     */
    public void modificarPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Cambia el centro de salud del usuario.
     *
     * @param centroSalud El nuevo centro de salud del usuario.
     */
    public void cambiarCentroSalud(String centroSalud) {
        this.centroSalud = centroSalud;
    }
    
    /**
     * Metodo que evuelve el registro de usuarios
     * @return registro de usuarios
     */

    public static ArrayList<Usuarios> getRegUsuarios() {
        return regUsuarios;
    }

    
    /**
     * Metodo que muestra y devuelve los usuarios almacenados para seleccionarlos
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
        return "Datos de usuario\n"
                + "Nombre: " + nombre + "\n"
                + "Edad: " + edad + "\n"
                + "Peso: " + peso + "\n"
                + "Centro de salud: " + centroSalud + "\n"
                + "Edad de debut diabético: " + debut + "\n"
                + "NºUsuario: " + idUsuario;

    }

}
