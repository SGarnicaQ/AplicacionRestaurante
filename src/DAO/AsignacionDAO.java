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

    public void ver() {

    }

    public void editar() {

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
                asiCo.addElement(dataBar[0]+". "+dataBar[1]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asiCo;
    }

    public DefaultComboBoxModel comboPer() {
        DefaultComboBoxModel asiCo = new DefaultComboBoxModel();

        String sqlBar = "SELECT ID,nombre FROM PERSONA";

        String[] dataBar = new String[2];

        try {
            Statement barSQL = Conectado.createStatement();
            ResultSet barRts = barSQL.executeQuery(sqlBar);
            while (barRts.next()) {
                dataBar[0] = barRts.getString(1);
                dataBar[1] = barRts.getString(2);
                asiCo.addElement(dataBar[0]+". "+dataBar[1]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asiCo;
    }

}
