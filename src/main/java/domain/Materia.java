package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
    private List<Materia> correlativas;
    private String nombre;

    public Materia(String nombre, Materia ... correlativas){
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
        Collections.addAll(this.correlativas, correlativas);
    }

    public boolean aproboCorrelativas(Alumno alumno) {
        return this.correlativas.stream().allMatch(c -> (c.correlativas.isEmpty() || c.aproboCorrelativas(alumno)) && alumno.aprobo(c));
    }
}
