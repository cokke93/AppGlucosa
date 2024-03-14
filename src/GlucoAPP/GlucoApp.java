package GlucoAPP;

/**
 * @author Jorge Pedrajas Rubio
 * @version 1.0.0 27 feb 2024 18:03:22
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class GlucoApp {

    public static void main(String[] args) {

        menuInicio();

    }
    
 /**
  * Menu inicial de la aplicación
  */
    public static void menuInicio() {

        Scanner sc = new Scanner(System.in);
        int opcion;
        String inicio = """
        [Bienvenido a su registro de glucosa personal]
        
        Seleccione una opción:
        1. Crear nuevo usuario
        2. Elegir usuario existente
        3. Salir
       
        """;

        do {

            System.out.println(inicio);
            try {
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1 -> {
                        crearUsuario();
                    }
                    case 2 -> {
                        if (Usuarios.getRegUsuarios().isEmpty()) {
                            System.out.println("No hay usuarios, cree uno nuevo");
                            System.out.println("");
                        } else {
                            menuPrincipal(Usuarios.seleccionarUsuario());
                        }

                    }
                    case 3 -> {
                        System.out.println("Saliendo de la aplicacion, hasta pronto!!");
                    }
                    default ->
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: entrada no válida. Por favor, ingrese un número.");
                sc.nextLine();
                opcion = 0;
            }
        } while (opcion != 3);

    }

    /**
     * Menu principla de la aplicación
     *
     * @param usuario Se pasa por parametro el usuario activo
     */
    public static void menuPrincipal(Usuarios usuario) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        String menu;

        do {
            try {
                menu = """
                       
        -------- Menú GlucoApp --------
        1. Registrar niveles de glucosa.
        2. Consultar Hba1c / Glucosa media en sangre.
        3. Consultar registro de glucosa.
        4. Consultar informe general.
        5. Limpiar registro de Glucosa.
        6. Modificar datos de usuario.
        7. Mostrar datos de usuario.
        8. Salir.

        Ingrese su opción: 
                       """;
                System.out.print(menu);

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1 -> {

                        usuario.getControlGlucosa().registrarGlucosa(); //Registrar glucosa
                    }
                    case 2 -> {
                        System.out.println(usuario.getControlGlucosa().mediaGlucosa()); //Media glucosa
                    }
                    case 3 -> {
                        usuario.getControlGlucosa().consultarHistorial(); //Consultar historial
                    }
                    case 4 -> {
                        System.out.println(usuario.getControlGlucosa().informeGeneral()); //Mostrar informe general
                    }
                    case 5 -> {
                        usuario.getControlGlucosa().limpiarRegistro(); //Limpiar el registro de glucosa
                    }
                    case 6 -> {
                        menuUsuario(usuario); //Acceder al menu de usuario
                        break;
                    }
                    case 7 -> {
                        System.out.println(usuario.datosUsuario()); //Acceder a los datos de usuario
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

    }

    /**
     * Metodo que contiene el menu para modificar y consultar datos de usuarios
     *
     * @param usuario Se le pasa por parametro el usuario introducido desde el
     * menu principal
     */
    public static void menuUsuario(Usuarios usuario) {

        Scanner sc = new Scanner(System.in);
        String menuUsuario;
        try {
            menuUsuario = """
                               -------- Modificar Datos de Usuario --------
                               1. Modificar nombre.
                               2. Modificar edad.
                               3. Modificar peso.
                               4. Cambiar centro de salud.
                               5. Volver al menú principal.

                               Ingrese su opción: 
                                                       """;
            System.out.print(menuUsuario);

            int opcionModificacion = sc.nextInt();
            sc.nextLine();

            switch (opcionModificacion) {
                case 1 -> {
                    usuario.modificarNombre(); //Modifica el nombre del usuario
                }
                case 2 -> {
                    usuario.modificarEdad(); //Modifica la edad del usuario
                }
                case 3 -> {
                    usuario.modificarPeso(); //Modifica el peso del usuario
                }
                case 4 -> {
                    usuario.cambiarCentroSalud(); //Modifica el centro de salud
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
        } catch (InputMismatchException e) {
            System.out.println("");
            System.out.println("Opción incorrecta. Por favor, ingrese una opción válida.");
            System.out.println("");
            sc.nextLine();

        }

    }

    /**
     * Metodo que crea un usuario y le asigna su aparto de control
     *
     * @return Devuelve un objeto usuario
     */
    public static Usuarios crearUsuario() {
        Scanner sc = new Scanner(System.in);
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

                System.out.println("");
                System.out.println("Datos introducidos:");
                System.out.println("Nombre: " + nombre + "\nEdad: " + edad + "\nPeso: " + peso + "\nDebut: " + debut + "\nCentro de salud: " + centro);
                System.out.println("");

                System.out.println("¿Los datos son correctos? (Si/No)");
                String confirmacion = sc.nextLine();

                if (confirmacion.equalsIgnoreCase("Si") || confirmacion.equalsIgnoreCase("Sí")) {
                    System.out.println("Por favor, introduzca la marca de su medidor de glucosa personal:");
                    String marca = sc.nextLine();
                    usuario = new Usuarios(nombre, edad, peso, centro, debut, marca);
                    Usuarios.getRegUsuarios().add(usuario);
                    System.out.println("[Usuario creado]");
                    System.out.println("");

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
