package servicios;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlumnoServicio {
    private Map<String, Alumno> listaAlumnos = new HashMap<>();

    // Método para crear un nuevo alumno y agregarlo a listaAlumnos
    public void crearAlumno(Alumno alumno) {
        listaAlumnos.put(alumno.getRut(), alumno);
    }

    // Método para agregar una materia a un alumno existente
    public void agregarMateria(String rutAlumno, Materia currentMate) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            alumno.getMaterias().add(currentMate);
        } else {
            System.out.println("Alumno no encontrado con el RUT: " + rutAlumno);
        }
    }

    // Método para agregar una nota a una materia de un alumno
    public void agregarNota(String rutAlumno, MateriaEnum materiaEnum, double nota) {
        // Buscar al alumno por su RUT
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno == null) {
            System.out.println("Alumno no encontrado.");
            return;
        }

        // Buscar la materia del alumno
        Materia materia = alumno.getMaterias().stream()
            .filter(m -> m.getNombre() == materiaEnum)
            .findFirst()
            .orElse(null);

        // Si no tiene la materia, se puede agregar
        if (materia == null) {
            System.out.println("Materia no encontrada, por favor asigna la materia primero.");
            return;
        }

        // Agregar la nota a la materia
        materia.getNotas().add(nota);
        System.out.println("Nota agregada a la materia " + materiaEnum);
    }


    // Método para obtener la lista de materias de un alumno
    public List<Materia> materiasPorAlumnos(String rutAlumno) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            return alumno.getMaterias();
        } else {
            System.out.println("Alumno no encontrado con el RUT: " + rutAlumno);
            return new ArrayList<>(); // Retorna una lista vacía si no se encuentra el alumno
        }
    }

    // Método para listar todos los alumnos
    public Map<String, Alumno> listarAlumnos() {
        return listaAlumnos;
    }
}
