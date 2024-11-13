package vistas;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import servicios.AlumnoServicio;
import servicios.ArchivosServicio;
import utilidades.Utilidad;
import servicios.PromedioServicioImp;

import java.util.Scanner;

public class Menu extends MenuTemplate {
    private AlumnoServicio alumnoServicio = new AlumnoServicio();
    private ArchivosServicio archivoServicio = new ArchivosServicio();
    private Scanner scanner = new Scanner(System.in);
    private PromedioServicioImp promedioServicio = new PromedioServicioImp();

    // Sobrescribe el método de exportación de datos
    @Override
    public void exportarDatos() {
        archivoServicio.exportarDatos(alumnoServicio.listarAlumnos(), "C:\\Users\\josei\\Documents\\promedios.txt");
        Utilidad.mostrarMensaje("Datos exportados correctamente");
    }

    // Sobrescribe el método para crear un nuevo alumno
    @Override
    public void crearAlumno() {
        System.out.print("Ingresa RUT: ");
        String rut = scanner.nextLine();
        System.out.print("Ingresa nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingresa dirección: ");
        String direccion = scanner.nextLine();
        
        Alumno alumno = new Alumno(rut, nombre, apellido, direccion);
        alumnoServicio.crearAlumno(alumno);
        Utilidad.mostrarMensaje("¡Alumno agregado!");
    }

    // Sobrescribe el método para agregar una materia a un alumno
    @Override
    public void agregarMateria() {
        System.out.print("Ingresa RUT del alumno: ");
        String rut = scanner.nextLine();
        
        System.out.print("Selecciona la materia (1: MATEMATICAS, 2: LENGUAJE, 3: CIENCIA, 4: HISTORIA): ");
        int opcionMateria = scanner.nextInt();
        scanner.nextLine();  // Limpia el buffer

        MateriaEnum materiaEnum;
        switch (opcionMateria) {
            case 1 -> materiaEnum = MateriaEnum.MATEMATICAS;
            case 2 -> materiaEnum = MateriaEnum.LENGUAJE;
            case 3 -> materiaEnum = MateriaEnum.CIENCIA;
            case 4 -> materiaEnum = MateriaEnum.HISTORIA;
            default -> {
                Utilidad.mostrarMensaje("Opción inválida.");
                return;
            }
        }
        
        Materia materia = new Materia(materiaEnum);
        alumnoServicio.agregarMateria(rut, materia);
        Utilidad.mostrarMensaje("¡Materia agregada!");
    }

    // Sobrescribe el método para agregar una nota a un alumno
    @Override
    public void agregarNotaPasoUno() {
        System.out.print("Ingresa RUT del alumno: ");
        String rut = scanner.nextLine();
        System.out.print("Ingresa nombre de la materia: ");
        String nombreMateria = scanner.nextLine();
        
        MateriaEnum materiaEnum;
        try {
            materiaEnum = MateriaEnum.valueOf(nombreMateria.toUpperCase());
        } catch (IllegalArgumentException e) {
            Utilidad.mostrarMensaje("Materia no válida.");
            return;
        }

        System.out.print("Ingresa nota: ");
        double nota = scanner.nextDouble();
        scanner.nextLine();  // Limpia el buffer

        alumnoServicio.agregarNota(rut, materiaEnum, nota);
        Utilidad.mostrarMensaje("¡Nota agregada!");
    }

    // Sobrescribe el método para listar los alumnos
    @Override
    public void listarAlumnos() {
        System.out.println("Lista de alumnos:");
        alumnoServicio.listarAlumnos().values().forEach(alumno -> {
            System.out.println("Alumno: " + alumno.getNombre() + " " + alumno.getApellido());
            System.out.println("RUT: " + alumno.getRut());
            System.out.println("Materias:");
            
            alumno.getMaterias().forEach(materia -> {
                System.out.print(" - " + materia.getNombre() + " con notas: " + materia.getNotas());

                // Calcula el promedio de las notas de la materia
                double promedio = promedioServicio.calcularPromedio(materia.getNotas());
                System.out.printf(" | Promedio: %.2f%n", promedio);  // Muestra el promedio con dos decimales
            });
            System.out.println("----------");
        });
    }

    // Sobrescribe el método para terminar el programa
    @Override
    public void terminarPrograma() {
        Utilidad.mostrarMensaje("El programa ha terminado.");
        System.exit(0);  // Finaliza la ejecución del sistema
    }
}

