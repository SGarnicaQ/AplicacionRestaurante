package DAO;

import Conexion.Conexion;
import Frontera.FramePrincipal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class AsignacionDAO {

    Conexion con = new Conexion();
    Connection Conectado = con.conectar("root", "17111996");

    public void crear() {

    }

    public void ver() {

    }

    public void editar() {

    }

    public DefaultComboBoxModel comboRes() {
        DefaultComboBoxModel asiCo = new DefaultComboBoxModel();

        String sqlBar = "SELECT nombre FROM RESTAURANTE";

        String[] dataBar = new String[1];

        try {
            Statement barSQL = Conectado.createStatement();
            ResultSet barRts = barSQL.executeQuery(sqlBar);
            while (barRts.next()) {
                dataBar[0] = barRts.getString(1);
                asiCo.addElement(dataBar[0]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asiCo;
    }

    public DefaultComboBoxModel comboPer() {
        DefaultComboBoxModel asiCo = new DefaultComboBoxModel();

        String sqlBar = "SELECT nombre FROM PERSONA";

        String[] dataBar = new String[1];

        try {
            Statement barSQL = Conectado.createStatement();
            ResultSet barRts = barSQL.executeQuery(sqlBar);
            while (barRts.next()) {
                dataBar[0] = barRts.getString(1);
                asiCo.addElement(dataBar[0]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asiCo;
    }

}
