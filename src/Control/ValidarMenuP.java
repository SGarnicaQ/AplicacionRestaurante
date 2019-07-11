package Control;

import Entidad.MenuP;

public class ValidarMenuP {

    public String validarMenuP(MenuP menu) {
        if (!verificarLongitudNombrePersona(menu.getPersona())) {
            return ("Longitud persona incorrecta");
        }
        if (!verificarLongitudMesaPersona(menu.getMesa())) {
            return ("Longitud mesa incorrecta");
        }
        if (!verificarLongitudTurnoPersona(menu.getTurno())) {
            return ("Longitud turno incorrecta");
        }
        if (!verificarLongitudEntradaPersona(menu.getEntrada())) {
            return ("Longitud entrada incorrecta");
        }
        if (!verificarLongitudPlatoFuePersona(menu.getPlatoFue())) {
            return ("Longitud plato fuerte incorrecta");
        }
        if (!verificarLongitudPostrePersona(menu.getPostre())) {
            return ("Longitud postre incorrecta");
        }
        if (!verificarLongitudCostoAdiPersona(menu.getCostoAdi())) {
            return ("Longitud costo adicional incorrecta");
        }

        return ("Datos guardados");
    }

    public boolean verificarLongitudNombrePersona(int nomPer) {
        return (nomPer != 0);
    }

    public boolean verificarLongitudMesaPersona(String mesPer) {
        return (mesPer.length() >= 1 && mesPer.length() <= 64);
    }

    public boolean verificarLongitudTurnoPersona(String turPer) {
        return (turPer.length() >= 0 && turPer.length() <= 32);
    }

    public boolean verificarLongitudEntradaPersona(String menPer) {
        return (menPer.length() >= 0 && menPer.length() <= 32);
    }
    
    public boolean verificarLongitudPlatoFuePersona(String menPer) {
        return (menPer.length() >= 0 && menPer.length() <= 32);
    }
    
    public boolean verificarLongitudPostrePersona(String menPer) {
        return (menPer.length() >= 0 && menPer.length() <= 32);
    }

    public boolean verificarLongitudCostoAdiPersona(String menPer) {
        return (menPer.length() >= 0 && menPer.length() <= 32);
    }
    
}
