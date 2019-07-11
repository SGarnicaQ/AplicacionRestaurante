/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Menu;
import Entidad.MenuP;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IS2
 */
public class TestMenuP {
    private static ValidarMenuP validarMenuP = new ValidarMenuP();
    
    private static final String LONGITUD_NOMBRE_PERSONA = "Longitud persona incorrecta";
    private static final String LONGITUD_MESA = "Longitud mesa incorrecta";
    private static final String LONGITUD_TURNO = "Longitud turno incorrecta";
    private static final String LONGITUD_ENTRADA = "Longitud entrada incorrecta";
    
    public TestMenuP() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ArrayList<MenuP> menps = new ArrayList<>();

        MenuP a = new MenuP();

        a.setPersona(123456789);
        a.setMesa("10");
        a.setTurno("2");        
        a.setEntrada("Galletas");
        a.setPlatoFue("Pollo");
        a.setPostre("Gelatina");
        a.setCostoAdi("Vino");

        menps.add(a);

        sistema.setMenusP(menps);

        for (MenuP me : menps) {
            System.out.println(me.getPersona());
            System.out.println(me.getMesa());
            System.out.println(me.getTurno());
            System.out.println(me.getEntrada());
            System.out.println(me.getPlatoFue());
            System.out.println(me.getPostre());
            System.out.println(me.getCostoAdi());
            
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
    @Test
    public void testLongitudNombrePersona() {
        MenuP menp = new MenuP();
        
        menp.setPersona(0);
        menp.setMesa("10");
        menp.setTurno("2");        
        menp.setEntrada("Galletas");
        menp.setPlatoFue("Pollo");
        menp.setPostre("Gelatina");
        menp.setCostoAdi("Vino");

        
        assertEquals(validarMenuP.validarMenuP(menp), LONGITUD_NOMBRE_PERSONA);
    }
    
    @Test
    public void testLongitudMesaPersona() {
        MenuP menp = new MenuP();
                
        menp.setPersona(123456789);
        menp.setMesa("");
        menp.setTurno("2");        
        menp.setEntrada("Galletas");
        menp.setPlatoFue("Pollo");
        menp.setPostre("Gelatina");
        menp.setCostoAdi("Vino");
        
        assertEquals(validarMenuP.validarMenuP(menp), LONGITUD_MESA);
    }
    
    @Test
    public void testLongitudTurnoPersona() {
        MenuP menp = new MenuP();
                
        menp.setPersona(123456789);
        menp.setMesa("10");
        menp.setTurno("121212121212121212121212121212121");        
        menp.setEntrada("Galletas");
        menp.setPlatoFue("Pollo");
        menp.setPostre("Gelatina");
        menp.setCostoAdi("Vino");
        
        assertEquals(validarMenuP.validarMenuP(menp), LONGITUD_TURNO);
    }
}
