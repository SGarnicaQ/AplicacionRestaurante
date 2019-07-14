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

public class PedidoDAO {

    Conexion con = new Conexion();
    Connection Conectado = con.conectar("root", "17111996");

    public void crear(int persona, int habitacion, int restaurante, String tipoH, String com1, String com2, String com3, String com4, String com5, String com6, String com7) {
        String sqlAsi = "INSERT INTO PEDIDO(idPer, habitacion, idRes, tipoH, com1, com2, com3, com4, com5, com6, com7) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            try (PreparedStatement ps = Conectado.prepareStatement(sqlAsi)) {
                ps.setInt(1, persona);
                ps.setInt(2, habitacion);
                ps.setInt(3, restaurante);
                ps.setString(4, tipoH);
                ps.setString(5, com1);
                ps.setString(6, com2);
                ps.setString(7, com3);
                ps.setString(8, com4);
                ps.setString(9, com5);
                ps.setString(10, com6);
                ps.setString(11, com7);
                ps.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel ver() {
        DefaultTableModel menTa = new DefaultTableModel();

        menTa.addColumn("pedID");
        menTa.addColumn("Persona");
        menTa.addColumn("Habitación");
        menTa.addColumn("Restaurante");
        menTa.addColumn("Tipo");
        menTa.addColumn("Comida #1");
        menTa.addColumn("Comida #2");
        menTa.addColumn("Comida #3");
        menTa.addColumn("Comida #4");
        menTa.addColumn("Comida #5");
        menTa.addColumn("Comida #6");
        menTa.addColumn("Comida #7");

        String sqlRes = "SELECT pedID, PERSONA.nombre, habitacion, RESTAURANTE.nombre, tipoH, com1, com2, com3, com4, com5, com6, com7 FROM PEDIDO "
                + "INNER JOIN RESTAURANTE ON aplicacionrestaurante.RESTAURANTE.resID = aplicacionrestaurante.PEDIDO.idRes "
                + "INNER JOIN PERSONA ON aplicacionrestaurante.PERSONA.perID = aplicacionrestaurante.PEDIDO.idPer ";

        String[] dataRes = new String[11];

        try {
            Statement bcuSta = Conectado.createStatement();
            ResultSet bcuRts = bcuSta.executeQuery(sqlRes);
            while (bcuRts.next()) {
                dataRes[0] = bcuRts.getString(1);
                dataRes[1] = bcuRts.getString(2);
                dataRes[2] = bcuRts.getString(3);
                dataRes[3] = bcuRts.getString(4);
                dataRes[4] = bcuRts.getString(5);
                dataRes[5] = bcuRts.getString(6);
                dataRes[6] = bcuRts.getString(7);
                dataRes[7] = bcuRts.getString(8);
                dataRes[8] = bcuRts.getString(9);
                dataRes[9] = bcuRts.getString(10);
                dataRes[10] = bcuRts.getString(11);
                menTa.addRow(dataRes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return menTa;
    }

    public void editar(int persona, int habitacion, int restaurante, String tipoH, String com1, String com2, String com3, String com4, String com5, String com6, String com7, int id) {

        String sqlAsi = "UPDATE PEDIDO SET idPer = ?, habitacion = ?, idRes = ?, tipoH = ?, com1 = ?, com2 = ?, com3 = ?, com4 = ?, com5 = ?, com6 = ?, com7 = ? WHERE pedID = ?;";

        try {
            PreparedStatement ps = Conectado.prepareStatement(sqlAsi);
            ps.setInt(1, persona);
            ps.setInt(2, habitacion);
            ps.setInt(3, restaurante);
            ps.setString(4, tipoH);
            ps.setString(5, com1);
            ps.setString(6, com2);
            ps.setString(7, com3);
            ps.setString(8, com4);
            ps.setString(9, com5);
            ps.setString(10, com6);
            ps.setString(11, com7);
            ps.setInt(12, id);
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

        String sqlBar = "SELECT PERSONA.perID, PERSONA.nombre FROM PERSONA "
                + "INNER JOIN ASIGNACION ON aplicacionrestaurante.PERSONA.perID = aplicacionrestaurante.ASIGNACION.idPer "
                + "INNER JOIN RESTAURANTE ON aplicacionrestaurante.ASIGNACION.idRes = aplicacionrestaurante.RESTAURANTE.resID ";

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

    public DefaultComboBoxModel comboRes() {
        DefaultComboBoxModel asiCo = new DefaultComboBoxModel();

        asiCo.addElement("Ninguno");

        String sqlBar = "SELECT resID,nombre FROM RESTAURANTE WHERE tipo != 'Principal' OR tipo != 'principal'";

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

    public String[] comidaDes(String tipo, int res) {

        String sqlDatos = "SELECT com1, com2, com3, com4, com5, com6, com7 FROM MENU  WHERE descrip = 'Buffet - " + tipo + "' AND idRes = '" + res + "'";

        String[] dataRes = new String[7];

        try {
            Statement bcuSta = Conectado.createStatement();
            ResultSet bcuRts = bcuSta.executeQuery(sqlDatos);
            while (bcuRts.next()) {
                dataRes[0] = bcuRts.getString(1);
                dataRes[1] = bcuRts.getString(2);
                dataRes[2] = bcuRts.getString(3);
                dataRes[3] = bcuRts.getString(4);
                dataRes[4] = bcuRts.getString(5);
                dataRes[5] = bcuRts.getString(6);
                dataRes[6] = bcuRts.getString(7);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return dataRes;
    }

}
