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
        }if (!verificarLongitudComidaMenu(menu.getComida1())) {
            return ("Longitud comida #1 incorrecta");
        }if (!verificarLongitudComidaMenu(menu.getComida2())) {
            return ("Longitud comida #2 incorrecta");
        }if (!verificarLongitudComidaMenu(menu.getComida3())) {
            return ("Longitud comida #3 incorrecta");
        }if (!verificarLongitudComidaMenu(menu.getComida4())) {
            return ("Longitud comida #4 incorrecta");
        }if (!verificarLongitudComidaMenu(menu.getComida5())) {
            return ("Longitud comida #5 incorrecta");
        }if (!verificarLongitudComidaMenu(menu.getComida6())) {
            return ("Longitud comida #6 incorrecta");
        }if (!verificarLongitudComidaMenu(menu.getComida7())) {
            return ("Longitud comida #7 incorrecta");
        }return ("Datos guardados");
    }

    public boolean verificarLongitudRestauranteMenu(String resMen) {
        return (resMen.length() >= 1 && resMen.length() <= 32);
    }
    
    public boolean verificarLongitudDescripcionMenu(String desMen) {
        return (desMen.length() >= 1 && desMen.length() <= 64);
    }

    public boolean verificarLongitudComidaMenu(String comMen) {
        return (comMen.length() >= 0 && comMen.length() <= 32);
    }    
}
