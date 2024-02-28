/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication20;

/**
 * @author Jorge Pedrajas Rubio
 * @version 1.0.0 27 feb 2024 18:02:40
 */
import java.util.Date;

public class Control_Glucosa {

    /**
     * Número total de controles de glucosa realizados.
     */
    private int controles = 0;

    /**
     * Nivel actual de glucosa.
     */
    private int glucosa;

    /**
     * Número de eventos de glucosa baja.
     */
    private int glucosa_baja;

    /**
     * Número de eventos de glucosa alta.
     */
    private int glucosa_alta;

    /**
     * Número de eventos de glucosa dentro del rango normal.
     */
    private int glucosa_en_rango;

    /**
     * Valor medio de la glucosa.
     */
    private int glucosa_media;

    /**
     * Nombre del dispositivo de control.
     */
    private final String nombre;

    /**
     * Fecha de creación del registro.
     */
    private final Date fecha_creacion;

    /**
     * Registro de valores de azúcar en la sangre.
     */
    private final int[] registro_azucar = new int[200];

    /**
     * Registro de fechas y horas de control de glucosa.
     */
    private final Date[] horasControl = new Date[200];

    /**
     * Constructor de la clase Control_Glucosa.
     *
     * @param nombre El nombre del dispositivo de control.
     */
    public Control_Glucosa(String nombre) {
        this.nombre = nombre;
        this.fecha_creacion = new Date();
    }

    /**
     * Metodo que registra la glucosa del usuario y devuelve un mensaje conforme
     * al nivel de esta
     *
     * @param glucosa La glucosa actual del usuario
     */
    public void registrarGlucosa(int glucosa) {
        this.glucosa = glucosa;
        registro_azucar[controles] = this.glucosa;
        controles++;
        horasControl[controles - 1] = new Date();
        System.out.println("Glucosa actual: " + this.glucosa);
        if (this.glucosa >= 200) {
            System.out.println("Peligro, glucosa ALTA, administrese insulina y midase el azucar otra vez en media hora.");
            glucosa_alta++;
        } else if (this.glucosa < 80) {
            System.out.println("Peligro, glucosa BAJA, administrese carbohidratos rapidos y midase el azucar de nuevo en media hora.");
            glucosa_baja++;
        } else {
            System.out.println("Glucosa dentro de rango.");
            this.glucosa_en_rango++;
        }

    }

    /**
     * Metodo que devuelve el historico de glucosa
     */
    public void consultarHistorial() {

        System.out.println("Historial de glucosa:");
        System.out.println("----------------------------");
        System.out.println("Fecha               | Glucosa");
        System.out.println("----------------------------");
        for (int i = 0; i < registro_azucar.length; i++) {
            if (registro_azucar[i] != 0) {
                System.out.printf("%1$tF %1$tT | %2$d%n", horasControl[i], registro_azucar[i]);
            } else if (registro_azucar[0] == 0) {
                System.out.println("No hay datos registrados.");
                break;
            }
        }
        System.out.println("----------------------------");
    }

    /**
     * Metodo que devuelve el numero de eventos de glucosa baja registrados
     */
    public void vecesBaja() {

        System.out.println("Eventos totales de gluocosa baja: " + this.glucosa_baja);
    }

    /**
     * Metodo que devuelve el numero de eventos de glucosa alta registrados
     */
    public void vecesAlta() {

        System.out.println("Eventos totales de gluocosa alta: " + this.glucosa_alta);
    }

    /**
     * Metodo que devuelve el numero de eventos de glucosa en rango registrados
     */
    public void enRango() {

        System.out.println("Eventos totales de Glucosa optimos: " + this.glucosa_en_rango);
    }

    /**
     * Metodo que calcula la glucosa media y el Hba1c
     *
     * @return Devuelve un String con la media y Hba1c
     */
    public String mediaGlucosa() {

        int mediaGlucosa = 0;

        for (int i = 0; i < registro_azucar.length; i++) {
            if (registro_azucar[i] != 0) {
                mediaGlucosa += registro_azucar[i];
            }
        }

        this.glucosa_media = mediaGlucosa / this.controles;

        if (this.glucosa_media >= 200 && this.glucosa_media < 300) {
            return "Tu media de Glucosa es: " + glucosa_media + " HbA1c estimada: 10-16 - Media de glucosa alta, cuida la alimentación";
        } else if (this.glucosa_media >= 300) {
            return "Tu media de Glucosa es: " + glucosa_media + " HbA1c estimada: 16-21 - Peligro, media de glucosa muy alta!";
        } else if (this.glucosa_media > 150 && this.glucosa_media < 200) {
            return "Tu media de Glucosa es: " + glucosa_media + " HbA1c estimada: 8-10 - Media de glucosa normal, sigue así!";
        } else if (this.glucosa_media > 50 && this.glucosa_media <= 150) {
            return "Tu media de Glucosa es: " + glucosa_media + " HbA1c estimada: 2-7 - Media en buen rango, genial!!!";
        } else {
            return "Fuera de rango.";
        }
    }

    /**
     * Metodo toString
     *
     * @return Devuelve datos generales del control de usuario
     */
    public String informeGeneral() {

        return "Nombre del dispositivo de control: " + this.nombre + "\nFecha de creacion del registro: " + this.fecha_creacion + "\nControles totales realizados: "
                + this.controles + "\nEventos de Glucosa Baja: " + this.glucosa_baja + "\nEventos de Glucosa Alta: " + this.glucosa_alta + "\nMediciones de Glucosa en rango: "
                + this.glucosa_en_rango + "\n" + mediaGlucosa();
    }

    /**
     * Metodo que limpia el registro de glucosa dejando los valores a 0
     */
    public void limpiarRegistro() {

        for (int i = 0; i < registro_azucar.length; i++) {
            if (registro_azucar[i] != 0) {
                registro_azucar[i] = 0;
            }

            for (int j = 0; j < horasControl.length; j++) {
                if (horasControl[i] != null) {
                    horasControl[i] = null;
                }
            }
        }

    }
}
