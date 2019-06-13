package Entidad;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<Restaurante> restaurantes;
    private ArrayList<Asignacion> asignaciones;

    public Sistema() {
    }

    public ArrayList<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(ArrayList<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }

    public ArrayList<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(ArrayList<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

}
