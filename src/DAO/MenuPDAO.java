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

public class MenuPDAO {

    Conexion con = new Conexion();
    Connection Conectado = con.conectar("root", "17111996");

    public void crear(String perso, String mesa, String turno, String menu) {
        String sqlAsi = "INSERT INTO MENUP(idPer, mesa, turno, menu) VALUES (?,?,?,?)";

        try {
            try (PreparedStatement ps = Conectado.prepareStatement(sqlAsi)) {
                ps.setString(1, perso);
                ps.setString(2, mesa);
                ps.setString(3, turno);
                ps.setString(4, menu);
                ps.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel ver() {
        DefaultTableModel menTa = new DefaultTableModel();

        menTa.addColumn("ID");
        menTa.addColumn("Persona");
        menTa.addColumn("Mesa");
        menTa.addColumn("Turno");
        menTa.addColumn("Menú");

        String sqlRes = "SELECT menpID, PERSONA.nombre, mesa, turno, menu FROM MENUP "
                + "INNER JOIN PERSONA ON aplicacionrestaurante.PERSONA.perID = aplicacionrestaurante.MENUP.idPer ";

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
                menTa.addRow(dataRes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return menTa;
    }

    public void editar(int perso, String mesa, String turno, String menu, int id) {

        String sqlAsi = "UPDATE MENUP SET idPer = ?, mesa = ?, turno = ?, menu = ? WHERE menpID = ?;";

        try {
            PreparedStatement ps = Conectado.prepareStatement(sqlAsi);
            ps.setInt(1, perso);
            ps.setString(2, mesa);
            ps.setString(3, turno);
            ps.setString(4, menu);
            ps.setInt(5, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultComboBoxModel comboPer() {
        DefaultComboBoxModel menpCo = new DefaultComboBoxModel();

        menpCo.addElement("Ninguna");

        String sqlBar = "SELECT PERSONA.perID, PERSONA.nombre FROM PERSONA INNER JOIN ASIGNACION ON aplicacionrestaurante.PERSONA.perID = aplicacionrestaurante.ASIGNACION.idPer";

        String[] dataBar = new String[2];

        try {
            Statement barSQL = Conectado.createStatement();
            ResultSet barRts = barSQL.executeQuery(sqlBar);
            while (barRts.next()) {
                dataBar[0] = barRts.getString(1);
                dataBar[1] = barRts.getString(2);
                menpCo.addElement(dataBar[0] + ". " + dataBar[1]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menpCo;
    }

    public DefaultComboBoxModel comboMen(String res) {
        DefaultComboBoxModel menpCo = new DefaultComboBoxModel();

        String sqlBar = "SELECT menID FROM MENU INNER JOIN RESTAURANTE ON aplicacionrestaurante.RESTAURANTE.resID = aplicacionrestaurante.MENU.idRes WHERE RESTAURANTE.nombre = '" + res + "'";

        String[] dataBar = new String[1];

        try {
            Statement barSQL = Conectado.createStatement();
            ResultSet barRts = barSQL.executeQuery(sqlBar);
            while (barRts.next()) {
                dataBar[0] = barRts.getString(1);
                menpCo.addElement(dataBar[0]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menpCo;
    }

    public String[] mesa(int id) {

        String sqlDatos = "SELECT RESTAURANTE.nombre,mesa, ASIGNACION.turno, ASIGNACION.asiID FROM ASIGNACION INNER JOIN RESTAURANTE ON aplicacionrestaurante.RESTAURANTE.resID = aplicacionrestaurante.ASIGNACION.idRes WHERE asiID = " + id;

        String[] dataRes = new String[4];

        try {
            Statement bcuSta = Conectado.createStatement();
            ResultSet bcuRts = bcuSta.executeQuery(sqlDatos);
            while (bcuRts.next()) {
                dataRes[0] = bcuRts.getString(1);
                dataRes[1] = bcuRts.getString(2);
                dataRes[2] = bcuRts.getString(3);
                dataRes[3] = bcuRts.getString(4);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return dataRes;
    }

    public String[] descripcion(int id) {

        String sqlDatos = "SELECT descrip FROM MENU WHERE menID = '" + id + "'";

        String[] dataRes = new String[1];

        try {
            Statement bcuSta = Conectado.createStatement();
            ResultSet bcuRts = bcuSta.executeQuery(sqlDatos);
            while (bcuRts.next()) {
                dataRes[0] = bcuRts.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return dataRes;
    }

    public int fila(String nom) {

        String sqlBar = "SELECT ASIGNACION.asiID FROM ASIGNACION INNER JOIN PERSONA ON aplicacionrestaurante.PERSONA.perID = aplicacionrestaurante.ASIGNACION.idPer WHERE nombre = '" + nom + "'";

        String[] dataBar = new String[1];

        try {
            Statement barSQL = Conectado.createStatement();
            ResultSet barRts = barSQL.executeQuery(sqlBar);
            while (barRts.next()) {
                dataBar[0] = barRts.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.parseInt(dataBar[0]);
    }

}
