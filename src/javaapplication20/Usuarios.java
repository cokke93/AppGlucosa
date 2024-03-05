/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication20;

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
    private String centro_de_salud;

    /**
     * La edad en la que el usuario debutó
     */
    private final int debut;

    /**
     * El ID único del usuario
     */
    private int id_usuario = 0;

    /**
     * El número total de usuarios creados
     */
    private static int total_usuarios;

    /**
     * El control de glucosa asociado a este usuario
     */
    private final Control_Glucosa controlGlucosa;

    /**
     * Constructor de la clase Usuarios.
     *
     * @param nombre El nombre del usuario.
     * @param edad La edad del usuario.
     * @param peso El peso del usuario.
     * @param centro_de_salud El centro de salud del usuario.
     * @param debut La edad en la que el usuario debutó.
     * @param controlGlucosa El objeto Control_Glucosa asociado al usuario.
     */
    public Usuarios(String nombre, int edad, double peso, String centro_de_salud, int debut, Control_Glucosa controlGlucosa) {

        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.centro_de_salud = centro_de_salud;
        this.debut = debut;
        total_usuarios++;
        this.id_usuario = total_usuarios;
        this.controlGlucosa = controlGlucosa;

    }

    /**
     * Obtiene el objeto Control_Glucosa asociado a este usuario
     *
     * @return El objeto Control_Glucosa asignado al usuario
     */
    public Control_Glucosa getControlGlucosa() {
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
    public String getCentro_de_salud() {
        return centro_de_salud;
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
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * Obtiene el número total de usuarios creados.
     *
     * @return El número total de usuarios creados.
     */
    public static int getTotal_usuarios() {
        return total_usuarios;
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
     * @param centro_de_salud El nuevo centro de salud del usuario.
     */
    public void cambiarCentroSalud(String centro_de_salud) {
        this.centro_de_salud = centro_de_salud;
    }

    public String datosUsuario() {
        return "Datos de usuario\n"
                + "Nombre: " + nombre + "\n"
                + "Edad: " + edad + "\n"
                + "Peso: " + peso + "\n"
                + "Centro de salud: " + centro_de_salud + "\n"
                + "Edad de debut: " + debut + "\n"
                + "NºUsuario: " + id_usuario;
                
                
    }

}
