package DAO;

import Conexion.Conexion;
import Frontera.FramePrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class RestauranteDAO {

    Conexion con = new Conexion();
    Connection Conectado = con.conectar("root", "17111996");

    public void crear(String nombre, String ubicacion, String tipo, int turno, String horario) {

        String sqlRes = "INSERT INTO RESTAURANTE(nombre, ubicacion, tipo, turno, horario) VALUES (?,?,?,?,?)";

        try {
            try (PreparedStatement ps = Conectado.prepareStatement(sqlRes)) {
                ps.setString(1, nombre);
                ps.setString(2, ubicacion);
                ps.setString(3, tipo);
                ps.setInt(4, turno);
                ps.setString(5, horario);
                ps.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public DefaultTableModel ver() {
        DefaultTableModel resTa = new DefaultTableModel();

        resTa.addColumn("ID");
        resTa.addColumn("Nombre");
        resTa.addColumn("Ubicación");
        resTa.addColumn("Tipo");
        resTa.addColumn("Horario");

        String sqlRes = "SELECT resID, nombre, ubicacion, tipo, horario FROM RESTAURANTE";

        String[] dataRes = new String[5];

        try {
            Statement bcuSta = Conectado.createStatement();
            ResultSet bcuRts = bcuSta.executeQuery(sqlRes);
            while (bcuRts.next()) {
                dataRes[0] = bcuRts.getString(1);
                dataRes[1] = bcuRts.getString(2);
                dataRes[2] = bcuRts.getString(3);
                dataRes[3] = bcuRts.getString(4);
                dataRes[4] = bcuRts.getString(5);
                resTa.addRow(dataRes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return resTa;
    }

    public void editar(String nombre, String ubicacion, String tipo, String horario, int turno, int id) {

        String sqlRes = "UPDATE RESTAURANTE SET nombre=?, ubicacion=?, tipo=?, horario=?, turno=? WHERE resID = ?";

        try {
            PreparedStatement ps = Conectado.prepareStatement(sqlRes);
            ps.setString(1, nombre);
            ps.setString(2, ubicacion);
            ps.setString(3, tipo);
            ps.setString(4, horario);
            ps.setInt(5, turno);
            ps.setInt(6, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
}
