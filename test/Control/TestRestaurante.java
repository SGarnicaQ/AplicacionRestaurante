package Control;

import Entidad.Restaurante;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestRestaurante {
    
 private static final ValidarRestaurante validarRestaurante = new ValidarRestaurante();

    private static final String LONGITUD_RESTAURANTE = "Longitud nombre incorrecta";
    private static final String LONGITUD_UBICACION = "Longitud ubicación incorrecta";
    private static final String LONGITUD_TIPO = "Longitud tipo incorrecta";
    private static final String LONGITUD_HORARIO = "Longitud horario incorrecta";
    private static final String DATOS_GUARDADOS = "Datos guardados";

    @BeforeClass
    public static void setUpClass() throws Exception {

        ArrayList<Restaurante> restaurantes = new ArrayList<>();

        Restaurante a = new Restaurante();

        a.setNombre("Delicias del Mar");
        a.setUbicacion("Cubierta 2");
        a.setTipo("Buffet");
        a.setHorario("6:30 - 9:30");

        restaurantes.add(a);

        sistema.setRestaurantes(restaurantes);

        for (Restaurante restaurante : restaurantes) {
            System.out.println(restaurante.getNombre());
            System.out.println(restaurante.getUbicacion());
            System.out.println(restaurante.getTipo());
            System.out.println(restaurante.getHorario());
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
    public void testLongitudRestauranteAsignacion() {

        Restaurante res = new Restaurante();

        res.setNombre("");
        res.setUbicacion("Cubierta 2");
        res.setTipo("Buffet");
        res.setHorario("6:30 - 9:30");
        assertEquals(validarRestaurante.validarRestaurante(res), LONGITUD_RESTAURANTE);

        res.setNombre("Delicias del MarDelicias del MarD");
        res.setUbicacion("Cubierta 2");
        res.setTipo("Buffet");
        res.setHorario("6:30 - 9:30");
        assertEquals(validarRestaurante.validarRestaurante(res), LONGITUD_RESTAURANTE);
    }

    @Test
    public void testLongitudUbicacionAsignacion() {

        Restaurante res = new Restaurante();

        res.setNombre("Delicias del Mar");
        res.setUbicacion("");
        res.setTipo("Buffet");
        res.setHorario("6:30 - 9:30");
        assertEquals(validarRestaurante.validarRestaurante(res), LONGITUD_UBICACION);

        res.setNombre("Delicias del Mar");
        res.setUbicacion("Cubierta 2Cubierta 2Cubierta 2Cub");
        res.setTipo("Buffet");
        res.setHorario("6:30 - 9:30");
        assertEquals(validarRestaurante.validarRestaurante(res), LONGITUD_UBICACION);
    }

    @Test
    public void testLongitudTipoAsignacion() {

        Restaurante res = new Restaurante();

        res.setNombre("Delicias del Mar");
        res.setUbicacion("Cubierta 2");
        res.setTipo("");
        res.setHorario("6:30 - 9:30");
        assertEquals(validarRestaurante.validarRestaurante(res), LONGITUD_TIPO);

        res.setNombre("Delicias del Mar");
        res.setUbicacion("Cubierta 2");
        res.setTipo("BuffetBuffetBuffetBuffetBuffetBuf");
        res.setHorario("6:30 - 9:30");
        assertEquals(validarRestaurante.validarRestaurante(res), LONGITUD_TIPO);
    }

    @Test
    public void testLongitudHorarioAsignacion() {

        Restaurante res = new Restaurante();

        res.setNombre("Delicias del Mar");
        res.setUbicacion("Cubierta 2");
        res.setTipo("Buffet");
        res.setHorario("");
        assertEquals(validarRestaurante.validarRestaurante(res), LONGITUD_HORARIO);

        res.setNombre("Delicias del Mar");
        res.setUbicacion("Cubierta 2");
        res.setTipo("Buffet");
        res.setHorario("6:30 - 9:306:30 - 9:306:30 - 9:30");
        assertEquals(validarRestaurante.validarRestaurante(res), LONGITUD_HORARIO);
    }

    @Test
    public void testDatosGuardados() {

        Restaurante res = new Restaurante();

        res.setNombre("Delicias del Mar");
        res.setUbicacion("Cubierta 2");
        res.setTipo("Buffet");
        res.setHorario("6:30 - 9:30");
        assertEquals(validarRestaurante.validarRestaurante(res), DATOS_GUARDADOS);
    }
    
}
