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

    public void crear(int perso, String mesa, String turno, String entrada, String platoFue, String postre, String costoAdi) {
        String sqlAsi = "INSERT INTO MENUP (idPer, mesa, turno, entrada, platoFue, postre, costoAdi) VALUES (?,?,?,?,?,?,?)";

        try {
            try (PreparedStatement ps = Conectado.prepareStatement(sqlAsi)) {
                ps.setInt(1, perso);
                ps.setString(2, mesa);
                ps.setString(3, turno);
                ps.setString(4, entrada);
                ps.setString(5, platoFue);
                ps.setString(6, postre);
                ps.setString(7, costoAdi);
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
        menTa.addColumn("Entrada");
        menTa.addColumn("Plato fuerte");
        menTa.addColumn("Postre");
        menTa.addColumn("Costo adicional");

        String sqlRes = "SELECT menpID, PERSONA.nombre, mesa, turno, entrada, platoFue, postre, costoAdi FROM MENUP "
                + "INNER JOIN PERSONA ON aplicacionrestaurante.PERSONA.perID = aplicacionrestaurante.MENUP.idPer ";

        String[] dataRes = new String[8];

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
                menTa.addRow(dataRes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return menTa;
    }

    public void editar(int perso, String mesa, String turno, String entrada, String platoFue, String postre, String costoAdi, int id) {

        String sqlAsi = "UPDATE MENUP SET idPer = ?, mesa = ?, turno = ?, entrada = ?, platoFue = ?, postre = ?, costoAdi = ? WHERE menpID = ?;";

        try {
            PreparedStatement ps = Conectado.prepareStatement(sqlAsi);
            ps.setInt(1, perso);
            ps.setString(2, mesa);
            ps.setString(3, turno);
            ps.setString(4, entrada);
            ps.setString(5, platoFue);
            ps.setString(6, postre);
            ps.setString(7, costoAdi);
            ps.setInt(8, id);
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
                + "INNER JOIN RESTAURANTE ON aplicacionrestaurante.ASIGNACION.idRes = aplicacionrestaurante.RESTAURANTE.resID WHERE RESTAURANTE.tipo = 'Principal' OR RESTAURANTE.tipo = 'principal'";

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

        String sqlBar = "SELECT menID FROM MENU "
                + "INNER JOIN RESTAURANTE ON aplicacionrestaurante.RESTAURANTE.resID = aplicacionrestaurante.MENU.idRes WHERE RESTAURANTE.nombre = '" + res + "'";

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

    public String[] turno(int id) {

        String sqlDatos = "SELECT mesa, ASIGNACION.turno, RESTAURANTE.nombre FROM ASIGNACION INNER JOIN RESTAURANTE ON aplicacionrestaurante.RESTAURANTE.resID = aplicacionrestaurante.ASIGNACION.idRes WHERE idPer = " + id;

        String[] dataRes = new String[3];

        try {
            Statement bcuSta = Conectado.createStatement();
            ResultSet bcuRts = bcuSta.executeQuery(sqlDatos);
            while (bcuRts.next()) {
                dataRes[0] = bcuRts.getString(1);
                dataRes[1] = bcuRts.getString(2);
                dataRes[2] = bcuRts.getString(3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return dataRes;
    }

    public String[] comidaEnt(String dia, int per) {

        String sqlDatos = "SELECT com1, com2, com3, com4, com5, com6, com7 FROM MENU INNER JOIN ASIGNACION ON aplicacionrestaurante.MENU.idRes = aplicacionrestaurante.ASIGNACION.idRes WHERE dia = '" + dia + "' AND descrip = 'Entrada' AND ASIGNACION.idPer = '" + per + "'";

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

    public String[] comidaPla(String dia, int per) {

        String sqlDatos = "SELECT com1, com2, com3, com4, com5, com6, com7 FROM MENU  INNER JOIN ASIGNACION ON aplicacionrestaurante.MENU.idRes = aplicacionrestaurante.ASIGNACION.idRes WHERE dia = '" + dia + "' AND descrip = 'Plato fuerte' AND ASIGNACION.idPer = '" + per + "'";

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

    public String[] comidaPos(String dia, int per) {

        String sqlDatos = "SELECT com1, com2, com3, com4, com5, com6, com7 FROM MENU  INNER JOIN ASIGNACION ON aplicacionrestaurante.MENU.idRes = aplicacionrestaurante.ASIGNACION.idRes WHERE dia = '" + dia + "' AND descrip = 'Postre' AND ASIGNACION.idPer = '" + per + "'";

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

    public String[] comidaCos(String dia, int per) {

        String sqlDatos = "SELECT com1, com2, com3, com4, com5, com6, com7 FROM MENU  INNER JOIN ASIGNACION ON aplicacionrestaurante.MENU.idRes = aplicacionrestaurante.ASIGNACION.idRes WHERE dia = '" + dia + "' AND descrip = 'Costo adicional' AND ASIGNACION.idPer = '" + per + "'";

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
