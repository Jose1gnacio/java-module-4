package vistas;

import java.util.Scanner;

public class MenuTemplate {
    protected Scanner scanner = new Scanner(System.in);

    public void iniciarMenu() {
        int opcion;
        do {
            System.out.println("1. Crear Alumnos");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Agregar Materias");
            System.out.println("4. Agregar Notas");
            System.out.println("5. Salir");
            System.out.println("6. Exportar Datos");
            System.out.print("Selección: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Para limpiar el buffer
            switch (opcion) {
                case 1 -> crearAlumno();
                case 2 -> listarAlumnos();
                case 3 -> agregarMateria();
                case 4 -> agregarNotaPasoUno();
                case 6 -> exportarDatos();
                case 5 -> terminarPrograma();
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    // Métodos para ser sobrescritos
    public void exportarDatos() {}
    public void crearAlumno() {}
    public void agregarMateria() {}
    public void agregarNotaPasoUno() {}
    public void listarAlumnos() {}
    public void terminarPrograma() {
        System.out.println("Saliendo del programa.");
    }
}
