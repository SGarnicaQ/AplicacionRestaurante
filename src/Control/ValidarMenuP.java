package Control;

import Entidad.MenuP;

public class ValidarMenuP {

    public String validarMenu(MenuP menu) {
        if (!verificarLongitudNombrePersona(menu.getPersona())) {
            return ("Longitud persona incorrecta");
        }
        if (!verificarLongitudMesaPersona(menu.getMesa())) {
            return ("Longitud mesa incorrecta");
        }
        if (!verificarLongitudTurnoPersona(menu.getTurno())) {
            return ("Longitud turno incorrecta");
        }
        if (!verificarLongitudMenuPersona(menu.getMenu())) {
            return ("Longitud menu incorrecta");
        }
        return ("Datos guardados");
    }

    public boolean verificarLongitudNombrePersona(String nomPer) {
        return (nomPer.length() >= 1 && nomPer.length() <= 32);
    }

    public boolean verificarLongitudMesaPersona(String mesPer) {
        return (mesPer.length() >= 1 && mesPer.length() <= 64);
    }

    public boolean verificarLongitudTurnoPersona(String turPer) {
        return (turPer.length() >= 0 && turPer.length() <= 32);
    }

    public boolean verificarLongitudMenuPersona(String menPer) {
        return (menPer.length() >= 0 && menPer.length() <= 32);
    }

}
