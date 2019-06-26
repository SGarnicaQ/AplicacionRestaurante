package Control;

import Entidad.Menu;

public class ValidarMenu {

    public ValidarMenu() {
    }

    public String validarMenu(Menu menu) {
        if (!verificarLongitudRestauranteMenu(menu.getRestaurante())) {
            return ("Longitud restaurante incorrecta");
        }if (!verificarLongitudDescripcionMenu(menu.getDescripcion())) {
            return ("Longitud descripcion incorrecta");
        }if (!verificarLongitudComida1Menu(menu.getComida1())) {
            return ("Longitud comida #1 incorrecta");
        }if (!verificarLongitudComida2Menu(menu.getComida2())) {
            return ("Longitud comida #2 incorrecta");
        }if (!verificarLongitudComida1Menu(menu.getComida1())) {
            return ("Longitud comida #3 incorrecta");
        }if (!verificarLongitudComida1Menu(menu.getComida1())) {
            return ("Longitud comida $4 incorrecta");
        }if (!verificarLongitudComida1Menu(menu.getComida1())) {
            return ("Longitud comida $5 incorrecta");
        }if (!verificarLongitudComida1Menu(menu.getComida1())) {
            return ("Longitud comida #6 incorrecta");
        }if (!verificarLongitudComida1Menu(menu.getComida1())) {
            return ("Longitud comida #7 incorrecta");
        }return ("Datos guardados");
    }

    public boolean verificarLongitudRestauranteMenu(String resMen) {
        return (resMen.length() >= 1 && resMen.length() <= 32);
    }
    
    public boolean verificarLongitudDescripcionMenu(String desMen) {
        return (desMen.length() >= 1 && desMen.length() <= 32);
    }

    public boolean verificarLongitudComida1Menu(String comMen) {
        return (comMen.length() >= 0 && comMen.length() <= 32);
    }
    
    public boolean verificarLongitudComida2Menu(String comMen) {
        return (comMen.length() >= 0 && comMen.length() <= 32);
    }
    
    public boolean verificarLongitudComida3Menu(String comMen) {
        return (comMen.length() >= 0 && comMen.length() <= 32);
    }
    
    public boolean verificarLongitudComida4Menu(String comMen) {
        return (comMen.length() >= 0 && comMen.length() <= 32);
    }
    
    public boolean verificarLongitudComida5Menu(String comMen) {
        return (comMen.length() >= 0 && comMen.length() <= 32);
    }
    
    public boolean verificarLongitudComida6Menu(String comMen) {
        return (comMen.length() >= 0 && comMen.length() <= 32);
    }
    
    public boolean verificarLongitudComida7Menu(String comMen) {
        return (comMen.length() >= 0 && comMen.length() <= 32);
    }
    
}
