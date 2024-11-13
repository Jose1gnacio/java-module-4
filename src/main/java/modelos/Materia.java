package modelos;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private MateriaEnum nombre;
    private List<Double> notas;

    // Constructor
    public Materia(MateriaEnum nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>(); // Inicializa la lista de notas
    }

    // Getters y Setters
    public MateriaEnum getNombre() {
        return nombre;
    }

    public void setNombre(MateriaEnum nombre) {
        this.nombre = nombre;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    // Método para agregar una nota a la lista
    public void agregarNota(double nota) {
        this.notas.add(nota);
    }
}
