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
    private static final String LONGITUD_MENU = "Longitud menu incorrecta";
    
    public TestMenuP() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ArrayList<MenuP> menps = new ArrayList<>();

        MenuP a = new MenuP();

        a.setPersona("Maria");
        a.setMesa("10");
        a.setTurno("2");
        a.setMenu("5");

        menps.add(a);

        sistema.setMenusP(menps);

        for (MenuP me : menps) {
            System.out.println(me.getPersona());
            System.out.println(me.getMesa());
            System.out.println(me.getTurno());
            System.out.println(me.getMenu());
            
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
    public void testLongitudPersona() {
        MenuP menp = new MenuP();
        
        menp.setPersona("");
        menp.setMesa("10");
        menp.setTurno("2");
        menp.setMenu("#Cena 1");
        
        assertEquals(validarMenuP.validarMenuP(menp), LONGITUD_NOMBRE_PERSONA);
        
        menp.setPersona("MariaMariaMariaMariaMariaMariaMar");
        menp.setMesa("10");
        menp.setTurno("2");
        menp.setMenu("#Cena 1");
        
        assertEquals(validarMenuP.validarMenuP(menp), LONGITUD_NOMBRE_PERSONA);
    }
    
    @Test
    public void testLongitudMenu() {
        MenuP menp = new MenuP();
                
        menp.setPersona("Maria");
        menp.setMesa("10");
        menp.setTurno("2");
        menp.setMenu("#Cena 1#Cena 1#Cena 1#Cena 1#Cena ");
        
        assertEquals(validarMenuP.validarMenuP(menp), LONGITUD_MENU);
    }
}
