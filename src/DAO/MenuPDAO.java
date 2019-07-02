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

    public void crear(String perso, String mesa, String com1, String com2, String com3, String com4, String com5, String com6, String com7) {
        String sqlAsi = "INSERT INTO MENUP(idPer, mesa, com1, com2, com3, com4, com5, com6, com7) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            try (PreparedStatement ps = Conectado.prepareStatement(sqlAsi)) {
                ps.setString(1, perso);
                ps.setString(2, mesa);
                ps.setString(3, com1);
                ps.setString(4, com2);
                ps.setString(5, com3);
                ps.setString(6, com4);
                ps.setString(7, com5);
                ps.setString(8, com6);
                ps.setString(9, com7);
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
        menTa.addColumn("Comida #1");
        menTa.addColumn("Comida #2");
        menTa.addColumn("Comida #3");
        menTa.addColumn("Comida #4");
        menTa.addColumn("Comida #5");
        menTa.addColumn("Comida #6");
        menTa.addColumn("Comida #7");

        String sqlRes = "SELECT menpID, PERSONA.nombre, mesa, com1, com2, com3, com4, com5, com6, com7 FROM MENUP "
                + "INNER JOIN PERSONA ON aplicacionrestaurante.PERSONA.perID = aplicacionrestaurante.MENUP.idPer ";

        String[] dataRes = new String[10];

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
                menTa.addRow(dataRes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return menTa;
    }

    public void editar(int perso, String mesa, String com1, String com2, String com3, String com4, String com5, String com6, String com7, int id) {
        
        String sqlAsi = "UPDATE MENUP SET idPer = ?, mesa = ?, com1 = ?, com2 = ?, com3 = ?, com4 = ?, com5 = ?, com6 = ?, com7 = ? WHERE menpID = ?;";

        try {
            PreparedStatement ps = Conectado.prepareStatement(sqlAsi);
            ps.setInt(1, perso);
            ps.setString(2, mesa);
            ps.setString(3, com1);
            ps.setString(4, com2);
            ps.setString(5, com3);
            ps.setString(6, com4);
            ps.setString(7, com5);
            ps.setString(8, com6);
            ps.setString(9, com7);
            ps.setInt(10, id);
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

        String sqlBar = "SELECT perID,nombre FROM PERSONA";

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

}
