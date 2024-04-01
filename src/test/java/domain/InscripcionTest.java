package domain;

import domain.exceptions.InscripcionSinMateriasException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InscripcionTest {

    private Alumno juan;

    @Before
    public void antesDeTestear(){
        juan = new Alumno("Juan");
    }

    @Test
    public void inscripcionAprobada() throws InscripcionSinMateriasException{
        Materia ingles1 = new Materia("Inglés 1");
        Materia ingles2 = new Materia("Inglés 2", ingles1);
        Materia ingYSoc = new Materia("Ingeniería y Sociedad");

        this.juan.agregarMateriasAprobadas(ingles1);

        Inscripcion unaInscripcion = new Inscripcion(this.juan);
        unaInscripcion.agregarMaterias(ingles2, ingYSoc);

        Assert.assertTrue(unaInscripcion.aprobada());
    }

    @Test
    public void inscripcionDesaprobada() throws InscripcionSinMateriasException{
        Materia discreta = new Materia("Matemática Discreta");
        Materia ayed = new Materia("Algoritmos y Estructuras de Datos");
        Materia syo = new Materia("Sistemas y Organizaciones");
        Materia ads = new Materia("Análisis de Sistemas", syo, ayed);
        Materia pdep = new Materia("Paradigmas de Programación", discreta, ayed);
        Materia dds = new Materia("Diseño de Sistemas", ads, pdep);

        this.juan.agregarMateriasAprobadas(discreta, syo, ayed, ads);
        Inscripcion unaInscripcion = new Inscripcion(this.juan);
        unaInscripcion.agregarMaterias(pdep, dds);

        Assert.assertFalse(unaInscripcion.aprobada());
    }

    @Test(expected = InscripcionSinMateriasException.class)
    public void inscripcionSinMaterias() throws InscripcionSinMateriasException{
        Inscripcion unaInscripcion = new Inscripcion(this.juan);

        unaInscripcion.aprobada();
    }
}
