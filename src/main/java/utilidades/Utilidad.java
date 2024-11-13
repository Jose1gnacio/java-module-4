package utilidades;

public class Utilidad {

    // Método para limpiar la pantalla (esto depende del sistema operativo)
    public static void limpiarPantalla() {
        try {
            // Limpiar la pantalla para sistemas Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Limpiar la pantalla para sistemas Unix/Linux/Mac
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla.");
        }
    }

    // Método para mostrar un mensaje con formato
    public static void mostrarMensaje(String mensaje) {
        System.out.println("--- " + mensaje + " ---");
    }
}
