package servicios;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlumnoServicioTest {

    private Materia matematicas;
    private Materia lenguaje;
    private Alumno alumno;

    @BeforeEach
    public void setup() {
        // Creando instancias de Materia
        matematicas = new Materia(MateriaEnum.MATEMATICAS);
        lenguaje = new Materia(MateriaEnum.LENGUAJE);
    }

    @Test
    public void testAgregarNota() {
        matematicas.agregarNota(7.0);
        assertEquals(1, matematicas.getNotas().size());
    }

    @Test
    public void testMateriaNombre() {
        assertEquals(MateriaEnum.MATEMATICAS, matematicas.getNombre());
    }

    @Test
    public void testListarMaterias() {
        // Verificamos que el alumno tiene las materias correctas
        assertEquals(2, alumno.getMaterias().size(), "El alumno debe tener 2 materias");
        
        // Verificamos que las materias sean las correctas
        assertTrue(alumno.getMaterias().contains(matematicas), "La materia de matemáticas debe estar en la lista");
        assertTrue(alumno.getMaterias().contains(lenguaje), "La materia de lenguaje debe estar en la lista");
    }
}
