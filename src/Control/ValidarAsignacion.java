package Control;

import Entidad.Asignacion;

public class ValidarAsignacion {

    public ValidarAsignacion() {
    }

    public String validarAsignacion(Asignacion asignacion) {
        if (!verificarLongitudRestauranteAsignacion(asignacion.getRestaurante())) {
            return ("Longitud restaurante incorrecta");
        }
        if (!verificarLongitudPersonaAsignacion(asignacion.getPersona())) {
            return ("Longitud persona incorrecta");
        }
        if (!verificarLongitudTurnoAsignacion(asignacion.getTurno())) {
            return ("Longitud turno incorrecta");
        }
        if (!verificarLongitudMesaAsignacion(asignacion.getMesa())) {
            return ("Longitud mesa incorrecta");
        }

        return ("Datos guardados");
    }

    public boolean verificarLongitudRestauranteAsignacion(String nombreRes) {
        return (nombreRes.length() >= 1 && nombreRes.length() <= 32);
    }

    public boolean verificarLongitudPersonaAsignacion(String nombreRes) {
        return (nombreRes.length() >= 1 && nombreRes.length() <= 32);
    }

    public boolean verificarLongitudMesaAsignacion(String nombreRes) {
        return (nombreRes.length() >= 1 && nombreRes.length() <= 32);
    }

    public boolean verificarLongitudTurnoAsignacion(String nombreRes) {
        return (nombreRes.length() >= 1 && nombreRes.length() <= 32);
    }

}
