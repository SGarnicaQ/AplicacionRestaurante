package Entidad;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<Restaurante> restaurantes;
    private ArrayList<Asignacion> asignaciones;
    private ArrayList<Menu> menus;
    private ArrayList<MenuP> menusP;

    public ArrayList<MenuP> getMenusP() {
        return menusP;
    }

    public void setMenusP(ArrayList<MenuP> menusP) {
        this.menusP = menusP;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }

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
