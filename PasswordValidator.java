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
import java.util.regex.Pattern;

// Clase que implementa la interfaz Runnable
public class PasswordValidator implements Runnable {
    private final String password;
    // Constructor de la clase
    public PasswordValidator(String password) {
        this.password = password;
    }

    @Override
    public void run() {

        boolean isValid = isValidPassword(password);
        // Mostramos los resultados de la validación
        System.out.println("Resultado de la validación:");
        System.out.println("- Longitud mínima de 8 caracteres: " + (password.length() >= 8 ? "✔" : "✘"));
        System.out.println("- Presencia de caracteres especiales: " + (Pattern.matches(".*[!@#$%^&*(),.?\":{}|<>].*", password) ? "✔" : "✘"));
        System.out.println("- Uso de al menos dos letras mayúsculas: " + (Pattern.matches(".*[A-Z].*[A-Z].*", password) ? "✔" : "✘"));
        System.out.println("- Uso de al menos tres letras minúsculas: " + (Pattern.matches(".*[a-z].*[a-z].*[a-z].*", password) ? "✔" : "✘"));
        System.out.println("- Uso de al menos un número: " + (Pattern.matches(".*[0-9].*", password) ? "✔" : "✘"));

        // Mostramos si la contraseña es válida o no
        if (isValid) {
            System.out.println("La contraseña \"" + password + "\" es válida.");
        } else {
            System.out.println("La contraseña \"" + password + "\" no es válida.");
        }
    }

    // Metodo para validar la contraseña
    private boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        // Expresiones regulares para validar la contraseña
        String specialChars = ".*[!@#$%^&*(),.?\":{}|<>].*";
        String upperCase = ".*[A-Z].*[A-Z].*";
        String lowerCase = ".*[a-z].*[a-z].*[a-z].*";
        String digit = ".*[0-9].*";

        // Validamos la contraseña
        return Pattern.matches(specialChars, password) &&
                Pattern.matches(upperCase, password) &&
                Pattern.matches(lowerCase, password) &&
                Pattern.matches(digit, password);
    }
}