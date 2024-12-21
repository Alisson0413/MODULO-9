// Nombre: Alisson Ibarguen
// Número de ID: 8-1020-2253
// Facultad: FACULTAD DE INGENIERÍA, ARQUITECTURA Y DISEÑO
// Carrera: Lic. INGENIERÍA EN SISTEMAS COMPUTACIONALES
// Curso: Programación de Computadoras II

/*
Enunciado: Crear una aplicación de consola en Java que utilice expresiones
regulares para validar contraseñas de usuarios de manera concurrente. El
programa debe lanzar varios hilos que, de manera independiente, validen
las contraseñas ingresadas por los usuarios. Cada hilo deberá verificar
si una contraseña cumple con ciertos requisitos: longitud mínima de ocho
(8) caracteres, presencia de caracteres especiales, uso de al menos dos
(2) letras mayúsculas, uso de al menos tres (3) letras minúsculas, uso de
al menos un (1) número.*/

// Importamos las librerias necesarias
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Clase principal
public class Main {
    // Metodo principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Menu principal
        while (true) {
            limpiarPantalla();
            System.out.println("Menu:");
            System.out.println("1. Verificar contraseña");
            System.out.println("2. Salir");
            System.out.print("Elige una opción: ");

            // Manejo de excepciones
            try {
                int option = Integer.parseInt(scanner.nextLine());
                // Verificar la opción seleccionada
                if (option == 1) {
                    // Limpiar la pantalla
                    limpiarPantalla();
                    System.out.println("Una contraseña segura debe cumplir con los siguientes requisitos:");
                    System.out.println("- Longitud mínima de 8 caracteres");
                    System.out.println("- Presencia de caracteres especiales");
                    System.out.println("- Uso de al menos dos letras mayúsculas");
                    System.out.println("- Uso de al menos tres letras minúsculas");
                    System.out.println("- Uso de al menos un número");
                    System.out.print("Ingresa la contraseña: ");
                    String password = scanner.nextLine();
                    executor.execute(new PasswordValidator(password));
                    break;
                } else if (option == 2) {
                    break;
                } else {
                    System.err.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Entrada no válida. Por favor, ingresa un número.");
            }
        }


        executor.shutdown();
        scanner.close();
    }
    // metodo para limpiar la pantalla
    private static void limpiarPantalla() {
        for (int i = 0; i < 30; i++) {
            System.out.println("\n");
        }
    }
}
