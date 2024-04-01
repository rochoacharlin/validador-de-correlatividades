package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    private List<Materia> materiasAprobadas;
    private String nombre;

    public Alumno(String nombre){
        this.nombre = nombre;
        this.materiasAprobadas = new ArrayList<>();
    }

    public boolean aprobo(Materia materia) {
        return this.materiasAprobadas.contains(materia);
    }

    public void agregarMateriasAprobadas(Materia ... materias){
        Collections.addAll(this.materiasAprobadas, materias);
    }
}
