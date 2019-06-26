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
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class AsignacionDAO {

    Conexion con = new Conexion();
    Connection Conectado = con.conectar("root", "17111996");

    public void crear(String restaurante, String persona, String turno, String mesa) {
        String sqlAsi = "INSERT INTO ASIGNACION(idRes, idPer, turno, mesa) VALUES (?,?,?,?)";

        try {
            try (PreparedStatement ps = Conectado.prepareStatement(sqlAsi)) {
                ps.setString(1, restaurante);
                ps.setString(2, persona);
                ps.setString(3, turno);
                ps.setString(4, mesa);
                ps.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel ver() {
        DefaultTableModel asiTa = new DefaultTableModel();

        asiTa.addColumn("ID");
        asiTa.addColumn("Restaurante");
        asiTa.addColumn("Persona");
        asiTa.addColumn("Turno");
        asiTa.addColumn("Mesa");

        String sqlRes = "SELECT asiID, RESTAURANTE.nombre, PERSONA.nombre, turno, mesa FROM ASIGNACION "
                + "INNER JOIN RESTAURANTE ON aplicacionrestaurante.RESTAURANTE.resID = aplicacionrestaurante.ASIGNACION.idRes "
                + "INNER JOIN PERSONA ON aplicacionrestaurante.PERSONA.perID = aplicacionrestaurante.ASIGNACION.idPer;";

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
                asiTa.addRow(dataRes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return asiTa;
    }

    public void editar(int restaurante, int persona, String turno, String mesa, int id) {

        String sqlAsi = "UPDATE ASIGNACION SET idRes = ?, idPer = ?,turno = ?, mesa = ? WHERE asiID = ?;";

        try {
            PreparedStatement ps = Conectado.prepareStatement(sqlAsi);
            ps.setInt(1, restaurante);
            ps.setInt(2, persona);
            ps.setString(3, turno);
            ps.setString(4, mesa);
            ps.setInt(5, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public DefaultComboBoxModel comboRes() {
        DefaultComboBoxModel asiCo = new DefaultComboBoxModel();

        String sqlBar = "SELECT resID,nombre FROM RESTAURANTE";

        String[] dataBar = new String[2];

        try {
            Statement barSQL = Conectado.createStatement();
            ResultSet barRts = barSQL.executeQuery(sqlBar);
            while (barRts.next()) {
                dataBar[0] = barRts.getString(1);
                dataBar[1] = barRts.getString(2);
                asiCo.addElement(dataBar[0] + ". " + dataBar[1]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asiCo;
    }

    public DefaultComboBoxModel comboPer() {
        DefaultComboBoxModel asiCo = new DefaultComboBoxModel();

        String sqlBar = "SELECT perID,nombre FROM PERSONA";

        String[] dataBar = new String[2];

        try {
            Statement barSQL = Conectado.createStatement();
            ResultSet barRts = barSQL.executeQuery(sqlBar);
            while (barRts.next()) {
                dataBar[0] = barRts.getString(1);
                dataBar[1] = barRts.getString(2);
                asiCo.addElement(dataBar[0] + ". " + dataBar[1]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asiCo;
    }

}
