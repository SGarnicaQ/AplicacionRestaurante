package DAO;

import Conexion.Conexion;
import Frontera.FramePrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestauranteDAO {

    Conexion con = new Conexion();
    Connection Conectado = con.conectar("root", "17111996");

    public void crear(String nombre, String ubicacion, String tipo, String horario) {

        String sqlRes = "INSERT INTO RESTAURANTE(nombre, ubicacion, tipo, horario) VALUES (?,?,?,?)";

        try {
            try (PreparedStatement ps = Conectado.prepareStatement(sqlRes)) {
                ps.setString(1, nombre);
                ps.setString(2, ubicacion);
                ps.setString(3, tipo);
                ps.setString(4, horario);
                ps.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ver() {

    }

    public void editar() {

    }
}
