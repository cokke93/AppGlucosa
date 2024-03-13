/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GlucoAPP;

/**
 * @author Jorge Pedrajas Rubio
 * @version 1.0.0 27 feb 2024 18:03:22
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class App_prin {

    public static void main(String[] args) {

        Control_Glucosa control1 = crearControl();
        System.out.println("");
        Usuarios usuario = crearUsuario(control1);
        System.out.println("");
        menu(usuario);
        

    }

    /**
     * Menu principla de la aplicación
     *
     * @param usuario Se pasa por parametro el usuario activo
     */
    public static void menu(Usuarios usuario) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            try {
                System.out.println("-------- Menú GlucoApp --------");
                System.out.println("1. Registrar niveles de glucosa.");
                System.out.println("2. Consultar Hba1c / Glucosa media en sangre.");
                System.out.println("3. Consultar registro de glucosa.");
                System.out.println("4. Consultar informe general.");
                System.out.println("5. Limpiar registro de Glucosa.");
                System.out.println("6. Modificar datos de usuario.");
                System.out.println("7. Mostrar datos de usuario.");
                System.out.println("8. Salir.");
                System.out.println("");
                System.out.print("Ingrese su opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese el nivel de glucosa: ");
                        int nivelGlucosa = sc.nextInt();
                        usuario.getControlGlucosa().registrarGlucosa(nivelGlucosa);
                        System.out.println("Nivel de glucosa registrado.");
                        System.out.println("");
                    }
                    case 2 -> {
                        System.out.println("--------- Glucosa media ---------");
                        System.out.println(usuario.getControlGlucosa().mediaGlucosa());
                        System.out.println("");
                    }
                    case 3 -> {
                        usuario.getControlGlucosa().consultarHistorial();
                        System.out.println("");
                    }
                    case 4 -> {
                        System.out.println("--------- Informe general ---------");
                        System.out.println(usuario.getControlGlucosa().informeGeneral());
                        System.out.println("");
                    }
                    case 5 -> {
                        System.out.println("¿Estás seguro de que deseas reiniciar el registro? Esto borrará todos los datos almacenados. (Si/No)");
                        String confirmacion = sc.nextLine();
                        if (confirmacion.equalsIgnoreCase("Si") || confirmacion.equalsIgnoreCase("Sí")) {
                            usuario.getControlGlucosa().limpiarRegistro();
                            System.out.println("Registro reinicializado.");
                            System.out.println("");
                        } else {
                            System.out.println("Operación cancelada.");
                            System.out.println("");
                        }
                    }

                    case 6 -> {
                        System.out.println("-------- Modificar Datos de Usuario --------");
                        System.out.println("1. Modificar nombre.");
                        System.out.println("2. Modificar edad.");
                        System.out.println("3. Modificar peso.");
                        System.out.println("4. Cambiar centro de salud.");
                        System.out.println("5. Volver al menú principal.");
                        System.out.print("Ingrese su opción: ");
                        int opcionModificacion = sc.nextInt();
                        sc.nextLine();

                        switch (opcionModificacion) {
                            case 1 -> {
                                System.out.println("Nombre actual: " + usuario.getNombre());
                                System.out.print("Ingrese el nuevo nombre: ");
                                String nuevoNombre = sc.nextLine();
                                usuario.modificarNombre(nuevoNombre);
                                System.out.println("Nombre modificado correctamente.");
                                System.out.println("");
                            }
                            case 2 -> {
                                System.out.println("Edad actual: " + usuario.getEdad());
                                System.out.print("Ingrese la nueva edad: ");
                                int nuevaEdad = sc.nextInt();
                                sc.nextLine();
                                usuario.modificarEdad(nuevaEdad);
                                System.out.println("Edad modificada correctamente.");
                                System.out.println("");
                            }
                            case 3 -> {
                                System.out.println("Peso actual: " + usuario.getPeso());
                                System.out.print("Ingrese el nuevo peso: ");
                                double nuevoPeso = sc.nextDouble();
                                sc.nextLine();
                                usuario.modificarPeso(nuevoPeso);
                                System.out.println("Peso modificado correctamente.");
                                System.out.println("");
                            }
                            case 4 -> {
                                System.out.println("Centro de salud actual: " + usuario.getCentroSalud());
                                System.out.print("Ingrese el nuevo centro de salud: ");
                                String nuevoCentroSalud = sc.nextLine();
                                usuario.cambiarCentroSalud(nuevoCentroSalud);
                                System.out.println("Centro de salud modificado correctamente.");
                                System.out.println("");
                            }
                            case 5 -> {
                                System.out.println("Volviendo al menú principal.");
                                System.out.println("");
                            }
                            default -> {
                                System.out.println("Opción incorrecta. Por favor, ingrese una opción válida.");
                                System.out.println("");
                            }
                        }
                        break;
                    }
                    case 7 -> {
                        System.out.println(usuario.datosUsuario());
                        System.out.println("");
                    }
                    case 8 -> {
                        System.out.println("¿Desea salir de la aplicación? (Si/No)");
                        String confirmacion = sc.nextLine();

                        if (confirmacion.equalsIgnoreCase("Si") || confirmacion.equalsIgnoreCase("Sí")) {
                            opcion = 9;
                            System.out.println("Gracias por usar GlucoApp, hasta pronto.");

                        } else if (confirmacion.equalsIgnoreCase("No")) {
                            System.out.println("Volviendo al menú principal.");
                            System.out.println("");
                        }
                    }
                    default -> {
                        System.out.println("");
                        System.out.println("Opción incorrecta. Por favor, ingrese una opción válida.");
                        System.out.println("");
                    }

                }
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("Opción incorrecta. Por favor, ingrese una opción válida.");
                System.out.println("");
                sc.nextLine();
            }
        } while (opcion != 9);
        System.out.println("");
        sc.close();

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
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduzca Si o No");
                sc.nextLine();
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
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduzca Si o No");
                sc.nextLine();
            }
        } while (usuario == null);
        return usuario;
    }
}
