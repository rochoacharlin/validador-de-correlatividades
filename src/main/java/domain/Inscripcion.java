package domain;

import domain.exceptions.InscripcionSinMateriasException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
    private List<Materia> materias;
    private Alumno alumno;

    public Inscripcion(Alumno alumno){
        this.alumno = alumno;
        this.materias = new ArrayList<>();
    }

    public boolean aprobada() throws InscripcionSinMateriasException {
        if(this.materias.isEmpty()){
            throw new InscripcionSinMateriasException("El alumno no se ha inscripto a ninguna materia.");
        }

        return this.materias.stream().allMatch(m -> m.aproboCorrelativas(this.alumno));
    }

    public void agregarMaterias(Materia ... materias){
        Collections.addAll(this.materias, materias);
    }
}
