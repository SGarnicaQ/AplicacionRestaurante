/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Asignacion;
import Entidad.Menu;
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
public class TestMenu {
    
    private static ValidarMenu validarMenu = new ValidarMenu();
    
    private static final String LONGITUD_NOMBRE_RESTAURANTE = "Longitud restaurante incorrecta";
    private static final String LONGITUD_DESCRIPCION = "Longitud descripcion incorrecta";
    private static final String LONGITUD_COMIDA_1 = "Longitud comida #1 incorrecta";
    private static final String LONGITUD_COMIDA_2 = "Longitud comida #2 incorrecta";
    private static final String LONGITUD_COMIDA_3 = "Longitud comida #3 incorrecta";
    private static final String LONGITUD_COMIDA_4 = "Longitud comida #4 incorrecta";
    private static final String LONGITUD_COMIDA_5 = "Longitud comida #5 incorrecta";
    private static final String LONGITUD_COMIDA_6 = "Longitud comida #6 incorrecta";
    private static final String LONGITUD_COMIDA_7 = "Longitud comida #7 incorrecta";
    
    public TestMenu() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        ArrayList<Menu> mens = new ArrayList<>();

        Menu a = new Menu();

        a.setRestaurante("");
        a.setDescripcion("Desasyuno #1");
        a.setComida1("Huevos Fritos");
        a.setComida2("Pan tajado con mantequilla");
        a.setComida3("Chocolate");

        mens.add(a);

        sistema.setMenus(mens);

        for (Menu me : mens) {
            System.out.println(me.getRestaurante());
            System.out.println(me.getDescripcion());
            System.out.println(me.getComida1());
            System.out.println(me.getComida2());
            System.out.println(me.getComida3());
            System.out.println(me.getComida4());
            System.out.println(me.getComida5());
            System.out.println(me.getComida6());
            System.out.println(me.getComida7());
            
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
    public void testLongitudRestauranteMenu() {
        Menu men = new Menu();
        
        men.setRestaurante("");
        men.setDescripcion("Desayuno #1");
        men.setComida1("Huevos Fritos");
        men.setComida2("Pan tajado con mantequilla");
        men.setComida3("Chocolate");
        
        assertEquals(validarMenu.validarMenu(men), LONGITUD_NOMBRE_RESTAURANTE);
        
        men.setRestaurante("Delicias del MarDelicias del MarD");
        men.setDescripcion("Desayuno #1");
        men.setComida1("Huevos Fritos");
        men.setComida2("Pan tajado con mantequilla");
        men.setComida3("Chocolate");
        
        assertEquals(validarMenu.validarMenu(men), LONGITUD_NOMBRE_RESTAURANTE);
    }
    
    
    @Test
    public void testLongitudDescripcion() {
        Menu men = new Menu();
        
        men.setRestaurante("Delicias del Mar");
        men.setDescripcion("");
        men.setComida1("Huevos Fritos");
        men.setComida2("Pan tajado con mantequilla");
        men.setComida3("Chocolate");
        
        assertEquals(validarMenu.validarMenu(men), LONGITUD_DESCRIPCION);
        
        men.setRestaurante("Delicias del Mar");
        men.setDescripcion("Desayuno #1Desayuno #1Desayuno #1Desayuno #1Desayuno #1Desayuno #");
        men.setComida1("Huevos Fritos");
        men.setComida2("Pan tajado con mantequilla");
        men.setComida3("Chocolate");
        
        assertEquals(validarMenu.validarMenu(men), LONGITUD_DESCRIPCION);
    }
    
    @Test
    public void testLongitudComida() {
        Menu men = new Menu();
                
        men.setRestaurante("Delicias del Mar");
        men.setDescripcion("Desayuno #1");
        men.setComida1("Huevos FritosHuevos FritosHuevos ");
        men.setComida2("Pan tajado con mantequilla");
        men.setComida3("Chocolate");
        
        assertEquals(validarMenu.validarMenu(men), LONGITUD_COMIDA_1);
        
        men.setRestaurante("Delicias del Mar");
        men.setDescripcion("Desayuno #1");
        men.setComida1("Huevos Fritos");
        men.setComida2("Pan tajado con mantequillaPan taj");
        men.setComida3("Chocolate");
        
        assertEquals(validarMenu.validarMenu(men), LONGITUD_COMIDA_2);
        
        men.setRestaurante("Delicias del Mar");
        men.setDescripcion("Desayuno #1");
        men.setComida1("Huevos Fritos");
        men.setComida2("Pan tajado con mantequilla");
        men.setComida3("ChocolateChocolateChocolateChocol");
        
        assertEquals(validarMenu.validarMenu(men), LONGITUD_COMIDA_3);
    }

}
