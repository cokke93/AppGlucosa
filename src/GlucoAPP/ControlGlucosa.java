/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GlucoAPP;

/**
 * @author Jorge Pedrajas Rubio
 * @version 1.0.0 27 feb 2024 18:02:40
 */
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ControlGlucosa {

    /**
     * Número total de controles de glucosa realizados.
     */
    private int controles;

    /**
     * Nivel actual de glucosa.
     */
    private int glucosa;

    /**
     * Número de eventos de glucosa baja.
     */
    private int glucosaAlta;

    /**
     * Número de eventos de glucosa alta.
     */
    private int glucosaBaja;

    /**
     * Número de eventos de glucosa dentro del rango normal.
     */
    private int glucosaEnRango;

    /**
     * Valor medio de la glucosa.
     */
    private int glucosaMedia;

    /**
     * Marca del dispositivo de control.
     */
    private final String marca;

    /**
     * Fecha de creación del registro.
     */
    private final LocalDateTime fechaCreacion;

    /**
     * Registro de valores de azúcar en la sangre.
     */
    private final ArrayList<Integer> registroAzucar = new ArrayList();

    /**
     * Registro de fechas y horas de control de glucosa.
     */
    private final ArrayList<LocalDateTime> horasControl = new ArrayList();

    /**
     * Constructor de la clase Control_Glucosa.
     *
     * @param nombre El nombre del dispositivo de control.
     */
    public ControlGlucosa(String marca) {
        this.marca = marca;
        this.fechaCreacion = LocalDateTime.now();
    }

    /**
     * Metodo que registra la glucosa del usuario y devuelve un mensaje conforme
     * al nivel de esta
     *
     * @param glucosa La glucosa actual del usuario
     */
    public void registrarGlucosa(int glucosa) {

        this.glucosa = glucosa;

        if (glucosa > 0) {
            registroAzucar.add(this.glucosa);
            horasControl.add(LocalDateTime.now());
            controles++;

            System.out.println("");
            System.out.println("Glucosa actual: " + this.glucosa);
            if (this.glucosa >= 200) {
                System.out.println("Peligro, glucosa ALTA, administrese insulina y midase el azucar otra vez en media hora.");
                glucosaAlta++;
            } else if (this.glucosa < 80) {
                System.out.println("Peligro, glucosa BAJA, administrese carbohidratos rapidos y midase el azucar de nuevo en media hora.");
                glucosaBaja++;
            } else {
                System.out.println("Glucosa dentro de rango.");
                this.glucosaEnRango++;
            }

        } else {
            System.out.println("Glucosa introducida erronea");
        }
    }

    /**
     * Metodo que devuelve el historico de glucosa
     */
    public void consultarHistorial() {

        System.out.println("");
        System.out.println("Historial de glucosa:");
        System.out.println("----------------------------");
        System.out.println("Fecha               | Glucosa");
        System.out.println("----------------------------");

        if (registroAzucar.isEmpty()) {
            System.out.println("No hay datos registrados.");
        } else {
            for (int i = 0; i < registroAzucar.size(); i++) {
                System.out.printf("%1$tF %1$tT | %2$d%n", horasControl.get(i), registroAzucar.get(i));
            }
        }
        System.out.println("----------------------------");
    }

    /**
     * Metodo que devuelve el numero de eventos de glucosa baja registrados
     */
    public void vecesBaja() {

        System.out.println("Eventos totales de gluocosa baja: " + this.glucosaBaja);
    }

    /**
     * Metodo que devuelve el numero de eventos de glucosa alta registrados
     */
    public void vecesAlta() {

        System.out.println("Eventos totales de gluocosa alta: " + this.glucosaAlta);
    }

    /**
     * Metodo que devuelve el numero de eventos de glucosa en rango registrados
     */
    public void enRango() {

        System.out.println("Eventos totales de Glucosa optimos: " + this.glucosaEnRango);
    }

    /**
     * Metodo que calcula la glucosa media y el Hba1c
     *
     * @return Devuelve un String con la media y Hba1c
     */
    public String mediaGlucosa() {

        int mediaGlucosa = 0;

        try {
            for (int i = 0; i < controles; i++) {
                mediaGlucosa += registroAzucar.get(i);
            }

            this.glucosaMedia = mediaGlucosa / this.controles;

            if (this.glucosaMedia >= 300) {
                return "Tu media de Glucosa es: " + glucosaMedia + " HbA1c estimada: 16-21 - Peligro, media de glucosa muy alta!";
            } else if (this.glucosaMedia >= 200 && this.glucosaMedia < 300) {
                return "Tu media de Glucosa es: " + glucosaMedia + " HbA1c estimada: 10-16 - Media de glucosa alta, cuida la alimentación";
            } else if (this.glucosaMedia > 150 && this.glucosaMedia < 200) {
                return "Tu media de Glucosa es: " + glucosaMedia + " HbA1c estimada: 8-10 - Media de glucosa normal, sigue así!";
            } else if (this.glucosaMedia > 70 && this.glucosaMedia <= 150) {
                return "Tu media de Glucosa es: " + glucosaMedia + " HbA1c estimada: 2-7 - Media en buen rango, genial!!!";
            } else {
                return "Fuera de rango.";
            }

        } catch (ArithmeticException a) {
            System.out.println("");
            return "Error al calcular la media, compruebe los datos del dispositivo";
        }
    }

    /**
     * Metodo toString
     *
     * @return Devuelve datos generales del control de usuario
     */
    public String informeGeneral() {
        return "Nombre del dispositivo de control: " + this.marca
                + "\nFecha de creacion del registro: " + this.fechaCreacion
                + "\nControles totales realizados: " + this.controles
                + "\nEventos de Glucosa Baja: " + this.glucosaBaja
                + "\nEventos de Glucosa Alta: " + this.glucosaAlta
                + "\nMediciones de Glucosa en rango: " + this.glucosaEnRango
                + "\n" + mediaGlucosa();
    }

    /**
     * Metodo que limpia el registro de glucosa dejando los valores a 0
     */
    public void limpiarRegistro() {

        this.controles = 0;
        this.glucosaAlta = 0;
        this.glucosaBaja = 0;
        this.glucosaEnRango = 0;
        registroAzucar.clear();
        horasControl.clear();

    }
}
