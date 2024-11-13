package servicios;

import modelos.Alumno;
import modelos.Materia;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArchivosServicio {

    private List<Alumno> alumnosACargar; // Lista temporal para almacenar los alumnos
    private PromedioServicioImp promediosServicioImp = new PromedioServicioImp(); // Instancia de PromedioServicioImp

    // Método para exportar los datos de los alumnos
    public void exportarDatos(Map<String, Alumno> alumnos, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Alumno alumno : alumnos.values()) {
                String linea = generarLineaAlumno(alumno);
                writer.write(linea);
                writer.newLine();
            }
            System.out.println("Datos exportados exitosamente a: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al exportar los datos: " + e.getMessage());
        }
    }

    // Método auxiliar para generar una línea de texto con la información de un alumno
    private String generarLineaAlumno(Alumno alumno) {
        StringBuilder sb = new StringBuilder();
        sb.append("RUT: ").append(alumno.getRut())
          .append(", Nombre: ").append(alumno.getNombre())
          .append(", Apellido: ").append(alumno.getApellido())
          .append(", Dirección: ").append(alumno.getDireccion())
          .append(", Promedio: ").append(calcularPromedioAlumno(alumno));
        
        return sb.toString();
    }

    // Método para calcular el promedio de todas las notas de las materias de un alumno
    private double calcularPromedioAlumno(Alumno alumno) {
        List<Double> todasLasNotas = new ArrayList<>();
        for (Materia materia : alumno.getMaterias()) {
            todasLasNotas.addAll(materia.getNotas());
        }
        return promediosServicioImp.calcularPromedio(todasLasNotas);
    }

    // Getters y setters para alumnosACargar (opcional, dependiendo de la lógica que vayas a implementar)
    public List<Alumno> getAlumnosACargar() {
        return alumnosACargar;
    }

    public void setAlumnosACargar(List<Alumno> alumnosACargar) {
        this.alumnosACargar = alumnosACargar;
    }
}
