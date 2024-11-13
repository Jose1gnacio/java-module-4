package servicios;

import java.util.List;

public class PromedioServicioImp {

    // Método para calcular el promedio de una lista de valores
    public double calcularPromedio(List<Double> notas) {
        if (notas == null || notas.isEmpty()) {
            return 0.0; // Retorna 0 si la lista está vacía o es nula
        }
        
        double suma = 0.0;
        for (double nota : notas) {
            suma += nota;
        }
        
        return suma / notas.size();
    }
}
