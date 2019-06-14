package Control;

import Entidad.Restaurante;

public class ValidarRestaurante {

    public ValidarRestaurante() {
    }

    public String validarRestaurante(Restaurante restaurante) {
        if (!verificarLongitudNombreRestaurante(restaurante.getNombre())) {
            return ("Longitud nombre incorrecta");
        }
        if (!verificarLongitudUbicacionRestaurante(restaurante.getUbicacion())) {
            return ("Longitud ubicación incorrecta");
        }
        if (!verificarLongitudTipoRestaurante(restaurante.getTipo())) {
            return ("Longitud tipo incorrecta");
        }
        if (!verificarLongitudHorarioRestaurante(restaurante.getHorario())) {
            return ("Longitud horario incorrecta");
        }
        return ("Datos guardados");
    }

    public boolean verificarLongitudNombreRestaurante(String nombreRes) {
        return (nombreRes.length() >= 1 && nombreRes.length() <= 32);
    }

    public boolean verificarLongitudUbicacionRestaurante(String nombreRes) {
        return (nombreRes.length() >= 1 && nombreRes.length() <= 32);
    }

    public boolean verificarLongitudTipoRestaurante(String nombreRes) {
        return (nombreRes.length() >= 1 && nombreRes.length() <= 32);
    }

    public boolean verificarLongitudHorarioRestaurante(String nombreRes) {
        return (nombreRes.length() >= 1 && nombreRes.length() <= 32);
    }
}
