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
        }return ("Datos guardados");
    }

    public boolean verificarLongitudRestauranteMenu(String nombreRes) {
        return (nombreRes.length() >= 1 && nombreRes.length() <= 32);
    }
    
    public boolean verificarLongitudDescripcionMenu(String nombreRes) {
        return (nombreRes.length() >= 1 && nombreRes.length() <= 32);
    }

}
