package Control;

import Entidad.Pedido;

public class ValidarPedido {

    public String validarPedido(Pedido pedido) {
        if (!verificarLongitudNombrePersona(pedido.getPersona())) {
            return ("Longitud persona incorrecta");
        }
        if (!verificarLongitudHabitacionPedido(pedido.getHabitacion())) {
            return ("Longitud habitación incorrecta");
        }
        if (!verificarLongitudRestaurantePedido(pedido.getRestaurante())) {
            return ("Longitud restaurante incorrecta");
        }
        if (!verificarLongitudComidaPedido(pedido.getCom1())) {
            return ("Longitud comida #1 incorrecta");
        }
        if (!verificarLongitudComidaPedido(pedido.getCom2())) {
            return ("Longitud comida #2 incorrecta");
        }
        if (!verificarLongitudComidaPedido(pedido.getCom3())) {
            return ("Longitud comida #3 incorrecta");
        }
        if (!verificarLongitudComidaPedido(pedido.getCom4())) {
            return ("Longitud comida #4 incorrecta");
        }
        if (!verificarLongitudComidaPedido(pedido.getCom5())) {
            return ("Longitud comida #5 incorrecta");
        }
        if (!verificarLongitudComidaPedido(pedido.getCom6())) {
            return ("Longitud comida #6 incorrecta");
        }
        if (!verificarLongitudComidaPedido(pedido.getCom7())) {
            return ("Longitud comida #7 incorrecta");
        }
        return ("Datos guardados");
    }

    public boolean verificarLongitudNombrePersona(int nomPer) {
        return (nomPer > 0);
    }

    public boolean verificarLongitudHabitacionPedido(int nomPer) {
        return (nomPer > 0);
    }

    public boolean verificarLongitudRestaurantePedido(int nomPer) {
        return (nomPer > 0);
    }

    public boolean verificarLongitudComidaPedido(String comMen) {
        return (comMen.length() >= 0 && comMen.length() <= 32);
    }
}
