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

public class MenuDAO {

    Conexion con = new Conexion();
    Connection Conectado = con.conectar("root", "17111996");

    public void crear(String resta, String desc, String com1,String com2,String com3,String com4,String com5,String com6,String com7) {
        String sqlAsi = "INSERT INTO MENU(idRes, descrip, com1, com2, com3, com4, com5, com6, com7) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            try (PreparedStatement ps = Conectado.prepareStatement(sqlAsi)) {
                ps.setString(1, resta);
                ps.setString(2, desc);
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

    public void ver() {

    }

    public void editar() {

    }

    public DefaultComboBoxModel comboRes() {
        DefaultComboBoxModel menCo = new DefaultComboBoxModel();

        menCo.addElement("Ninguno");

        String sqlBar = "SELECT resID,nombre FROM RESTAURANTE";

        String[] dataBar = new String[2];

        try {
            Statement barSQL = Conectado.createStatement();
            ResultSet barRts = barSQL.executeQuery(sqlBar);
            while (barRts.next()) {
                dataBar[0] = barRts.getString(1);
                dataBar[1] = barRts.getString(2);
                menCo.addElement(dataBar[0] + ". " + dataBar[1]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menCo;
    }

    public DefaultComboBoxModel comboCom() {
        DefaultComboBoxModel menCo = new DefaultComboBoxModel();

        menCo.addElement("Ninguna");

        String sqlBar = "SELECT comID,nombre FROM COMIDA";

        String[] dataBar = new String[2];

        try {
            Statement barSQL = Conectado.createStatement();
            ResultSet barRts = barSQL.executeQuery(sqlBar);
            while (barRts.next()) {
                dataBar[0] = barRts.getString(1);
                dataBar[1] = barRts.getString(2);
                menCo.addElement(dataBar[0] + ". " + dataBar[1]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menCo;
    }

}
