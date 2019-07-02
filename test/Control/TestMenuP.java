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
    
    public TestMenuP() {
        ArrayList<MenuP> mensp = new ArrayList<>();

        MenuP a = new MenuP();

        a.setPersona("");
        a.setMesa("Desasyuno #1");
        a.setComida1("Huevos Fritos");
        a.setComida2("Pan tajado con mantequilla");
        a.setComida3("Chocolate");

        mensp.add(a);

        sistema.setMenusp(mensp);

        for (MenuP mep : mensp) {
            System.out.println(mep.getPersona());
            System.out.println(mep.getMesa());
            System.out.println(mep.getComida1());
            System.out.println(mep.getComida2());
            System.out.println(mep.getComida3());
            System.out.println(mep.getComida4());
            System.out.println(mep.getComida5());
            System.out.println(mep.getComida6());
            System.out.println(mep.getComida7());
            
            System.out.println("---------");
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
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
    public void testLongitudRestauranteMenu() {
        MenuP menp = new MenuP();
        
        menp.setPersona("");
        menp.setMesa("Desayuno #1");
        menp.setComida1("Huevos Fritos");
        menp.setComida2("Pan tajado con mantequilla");
        menp.setComida3("Chocolate");
        
        assertEquals(validarMenuP.validarMenuP(menp), );
        
        menp.setPersona("Delicias del MarDelicias del MarD");
        menp.setMesa("Desayuno #1");
        menp.setComida1("Huevos Fritos");
        menp.setComida2("Pan tajado con mantequilla");
        menp.setComida3("Chocolate");
        
        assertEquals(validarMenuP.validarMenuP(menp), );
    }
    
    
    @Test
    public void testLongitudDescripcion() {
        MenuP menp = new MenuP();
        
        menp.setPersona("Delicias del Mar");
        menp.setMesa("");
        menp.setComida1("Huevos Fritos");
        menp.setComida2("Pan tajado con mantequilla");
        menp.setComida3("Chocolate");
        
        assertEquals(validarMenuP.validarMenuP(menp), );
        
        menp.setPersona("Delicias del Mar");
        menp.setMesa("Desayuno #1Desayuno #1Desayuno #1Desayuno #1Desayuno #1Desayuno #");
        menp.setComida1("Huevos Fritos");
        menp.setComida2("Pan tajado con mantequilla");
        menp.setComida3("Chocolate");
        
        assertEquals(validarMenuP.validarMenuP(menp), );
    }
    
    @Test
    public void testLongitudComida() {
        MenuP menp = new MenuP();
                
        menp.setPersona("Delicias del Mar");
        menp.setMesa("Desayuno #1");
        menp.setComida1("Huevos FritosHuevos FritosHuevos ");
        menp.setComida2("Pan tajado con mantequilla");
        menp.setComida3("Chocolate");
        
        assertEquals(validarMenuP.validarMenuP(menp), );
        
        menp.setPersona("Delicias del Mar");
        menp.setMesa("Desayuno #1");
        menp.setComida1("Huevos Fritos");
        menp.setComida2("Pan tajado con mantequillaPan taj");
        menp.setComida3("Chocolate");
        
        assertEquals(validarMenuP.validarMenuP(menp), );
        
        menp.setPersona("Delicias del Mar");
        menp.setMesa("Desayuno #1");
        menp.setComida1("Huevos Fritos");
        menp.setComida2("Pan tajado con mantequilla");
        menp.setComida3("ChocolateChocolateChocolateChocol");
        
        assertEquals(validarMenuP.validarMenuP(menp), );
    }
}
