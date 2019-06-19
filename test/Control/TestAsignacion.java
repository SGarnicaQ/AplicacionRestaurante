package Control;

import Entidad.Asignacion;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestAsignacion {

    private static ValidarAsignacion validarAsignacion = new ValidarAsignacion();

    private static final String LONGITUD_NOMBRE_RESTAURANTE = "Longitud restaurante incorrecta";
    private static final String LONGITUD_NOMBRE_PERSONA = "Longitud persona incorrecta";
    private static final String LONGITUD_NOMBRE_TURNO = "Longitud turno incorrecta";
    private static final String LONGITUD_NOMBRE_MESA = "Longitud mesa incorrecta";
    private static final String DATOS_GUARDADOS = "Datos guardados";

    @BeforeClass
    public static void setUpClass() throws Exception {

        ArrayList<Asignacion> asignaciones = new ArrayList<>();

        Asignacion a = new Asignacion();

        a.setRestaurante("Delicias del Mar");
        a.setPersona("Alejandra");
        a.setMesa("21");
        a.setTurno("1");

        asignaciones.add(a);

        sistema.setAsignaciones(asignaciones);

        for (Asignacion asignacione : asignaciones) {
            System.out.println(asignacione.getRestaurante());
            System.out.println(asignacione.getPersona());
            System.out.println(asignacione.getMesa());
            System.out.println(asignacione.getTurno());
            System.out.println("---------");
        }
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLongitudNombreRestaurante() {

        Asignacion asi = new Asignacion();

        asi.setRestaurante("");
        asi.setPersona("Alejandra");
        asi.setTurno("21");
        asi.setMesa("1");
        assertEquals(validarAsignacion.validarAsignacion(asi), LONGITUD_NOMBRE_RESTAURANTE);

        asi.setRestaurante("Delicias del MarDelicias del MarD");
        asi.setPersona("Alejandra");
        asi.setTurno("21");
        asi.setMesa("1");
        assertEquals(validarAsignacion.validarAsignacion(asi), LONGITUD_NOMBRE_RESTAURANTE);
    }

    @Test
    public void testLongitudNombrePersona() {

        Asignacion asi = new Asignacion();

        asi.setRestaurante("Delicias del Mar");
        asi.setPersona("");
        asi.setTurno("21");
        asi.setMesa("1");
        assertEquals(validarAsignacion.validarAsignacion(asi), LONGITUD_NOMBRE_PERSONA);

        asi.setRestaurante("Delicias del Mar");
        asi.setPersona("AlejandraAlejandraAlejandraAlejan");
        asi.setTurno("21");
        asi.setMesa("1");
        assertEquals(validarAsignacion.validarAsignacion(asi), LONGITUD_NOMBRE_PERSONA);
    }

    @Test
    public void testLongitudNombreTurno() {

        Asignacion asi = new Asignacion();

        asi.setRestaurante("Delicias del Mar");
        asi.setPersona("Alejandra");
        asi.setTurno("");
        asi.setMesa("1");
        assertEquals(validarAsignacion.validarAsignacion(asi), LONGITUD_NOMBRE_TURNO);

        asi.setRestaurante("Delicias del Mar");
        asi.setPersona("Alejandra");
        asi.setTurno("123456789012345678901234567890123");
        asi.setMesa("1");
        assertEquals(validarAsignacion.validarAsignacion(asi), LONGITUD_NOMBRE_TURNO);
    }

    @Test
    public void testLongitudNombreMesa() {

        Asignacion asi = new Asignacion();

        asi.setRestaurante("Delicias del Mar");
        asi.setPersona("Alejandra");
        asi.setTurno("21");
        asi.setMesa("");
        assertEquals(validarAsignacion.validarAsignacion(asi), LONGITUD_NOMBRE_MESA);

        asi.setRestaurante("Delicias del Mar");
        asi.setPersona("Alejandra");
        asi.setTurno("21");
        asi.setMesa("123456789012345678901234567890123");
        assertEquals(validarAsignacion.validarAsignacion(asi), LONGITUD_NOMBRE_MESA);
    }

    @Test
    public void testDatosGuardados() {

        Asignacion asi = new Asignacion();

        asi.setRestaurante("Delicias del Mar");
        asi.setPersona("Alejandra");
        asi.setTurno("21");
        asi.setMesa("1");
        assertEquals(validarAsignacion.validarAsignacion(asi), DATOS_GUARDADOS);
    }

}
