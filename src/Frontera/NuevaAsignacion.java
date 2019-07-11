package Frontera;

import Control.ValidarAsignacion;
import DAO.AsignacionDAO;
import Entidad.Asignacion;

public class NuevaAsignacion extends javax.swing.JPanel {
    
    private final Dialogo dialogo = new Dialogo(null, true);
    
    private final Asignacion asignacion = new Asignacion();
    private final ValidarAsignacion validar = new ValidarAsignacion();
    private final AsignacionDAO daoAsi = new AsignacionDAO();
    
    private final DialogoOK dialogoOk = new DialogoOK(null, true);
    
    private int filaU = 0;
    
    public NuevaAsignacion() {
        initComponents();
    }
    
    public boolean validarCampos() {
        return (mesaTF.getText().isEmpty());
    }
    
    public void vaciarCampos() {
        comRes.setSelectedIndex(0);
        comPer.setSelectedIndex(0);
        turnoLabel.setText("");
        mesaTF.setText("");
    }
    
    public void guardarDatos() {
        
        String respuesta;
        if ("Ninguno".equals(comRes.getSelectedItem().toString())) {
            asignacion.setRestaurante("");
            
            respuesta = validar.validarAsignacion(asignacion);
            
            dialogoOk.textoLabel(respuesta);
            dialogoOk.visible();
        } else if ("Ninguna".equals(comPer.getSelectedItem().toString())) {
            asignacion.setRestaurante(Character.toString(comRes.getSelectedItem().toString().charAt(0)));
            asignacion.setPersona("");
            
            respuesta = validar.validarAsignacion(asignacion);
            
            dialogoOk.textoLabel(respuesta);
            dialogoOk.visible();
        } else {
            
            asignacion.setRestaurante(Character.toString(comRes.getSelectedItem().toString().charAt(0)));
            asignacion.setPersona(Character.toString(comPer.getSelectedItem().toString().charAt(0)));
            asignacion.setTurno(Integer.parseInt(turnoLabel.getText()));
            asignacion.setMesa(mesaTF.getText());
            
            respuesta = validar.validarAsignacion(asignacion);
            
            if ("Longitud restaurante incorrecta".equals(respuesta)) {
                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else if ("Longitud persona incorrecta".equals(respuesta)) {
                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else if ("Longitud turno incorrecta".equals(respuesta)) {
                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else if ("Longitud mesa incorrecta".equals(respuesta)) {
                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else {
                daoAsi.crear(asignacion.getRestaurante(), asignacion.getPersona(), asignacion.getTurno(), asignacion.getMesa());
                vaciarCampos();
                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            }
            
        }
    }
    
    public void editar(Asignacion asigna, int fila) {
        
        comRes.setModel(daoAsi.comboRes());
        comPer.setModel(daoAsi.comboPer());
        turnoLabel.setText("");
        mesaTF.setText(asigna.getMesa());
        
        filaU = fila;
    }
    
    public void actualizar() {
        if (filaU != 0) {
            
            String respuesta;
            if ("Ninguno".equals(comRes.getSelectedItem().toString())) {
                asignacion.setRestaurante("");
                
                respuesta = validar.validarAsignacion(asignacion);
                
                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else if ("Ninguna".equals(comPer.getSelectedItem().toString())) {
                asignacion.setRestaurante(Character.toString(comRes.getSelectedItem().toString().charAt(0)));
                asignacion.setPersona("");
                
                respuesta = validar.validarAsignacion(asignacion);
                
                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else {
                
            asignacion.setRestaurante(Character.toString(comRes.getSelectedItem().toString().charAt(0)));
            asignacion.setPersona(Character.toString(comPer.getSelectedItem().toString().charAt(0)));
            asignacion.setTurno(Integer.parseInt(turnoLabel.getText()));
            asignacion.setMesa(mesaTF.getText());
                
                respuesta = validar.validarAsignacion(asignacion);
                
                if ("Longitud nombre incorrecta".equals(respuesta)) {
                    dialogoOk.textoLabel(respuesta);
                    dialogoOk.visible();
                } else if ("Longitud ubicación incorrecta".equals(respuesta)) {
                    dialogoOk.textoLabel(respuesta);
                    dialogoOk.visible();
                } else if ("Longitud tipo incorrecta".equals(respuesta)) {
                    dialogoOk.textoLabel(respuesta);
                    dialogoOk.visible();
                } else if ("Longitud horario incorrecta".equals(respuesta)) {
                    dialogoOk.textoLabel(respuesta);
                    dialogoOk.visible();
                } else {
                    daoAsi.editar(Integer.parseInt(asignacion.getRestaurante()), Integer.parseInt(asignacion.getPersona()), asignacion.getTurno(), asignacion.getMesa(), filaU);
                    vaciarCampos();
                    dialogoOk.textoLabel(respuesta);
                    dialogoOk.visible();
                    filaU = 0;
                }
            }
        } else {
            dialogoOk.textoLabel("Por favor vuelva atrás");
            dialogoOk.visible();
        }
    }
    
    public void comboRes() {
        comRes.setVisible(false);
        comRes.removeAll();
        comRes.setModel(daoAsi.comboRes());
        comRes.setVisible(true);
    }
    
    public void comboPer() {
        comPer.setVisible(false);
        comPer.removeAll();
        comPer.setModel(daoAsi.comboPer());
        comPer.setVisible(true);
    }
    
    public void comboTur() {
        if ("Ninguno".equals(comRes.getSelectedItem().toString())) {
            turnoLabel.setText("");
        } else {
            String[] datos = daoAsi.comboTur(Character.toString(comRes.getSelectedItem().toString().charAt(0)));
            turnoLabel.setText(datos[0]);
        }
    }
    
    public void nuevoVisible() {
        guardar.setVisible(true);
        editarNuevo.setVisible(false);
    }
    
    public void editarVisible() {
        guardar.setVisible(false);
        editarNuevo.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mesaTF = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        comRes = new javax.swing.JComboBox<>();
        editarNuevo = new javax.swing.JLabel();
        guardar = new javax.swing.JLabel();
        comPer = new javax.swing.JComboBox<>();
        turnoLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(164, 186, 191));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(36, 56, 63));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Persona");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 200, 30));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(36, 56, 63));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Restaurante");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 200, 30));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(36, 56, 63));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Mesa");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 200, 30));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(36, 56, 63));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Turno");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 200, 30));

        mesaTF.setBackground(new java.awt.Color(164, 186, 191));
        mesaTF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        mesaTF.setForeground(new java.awt.Color(36, 56, 63));
        mesaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mesaTF.setBorder(null);
        add(mesaTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 240, 30));

        jSeparator4.setBackground(new java.awt.Color(36, 56, 63));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 240, 10));

        comRes.setBackground(new java.awt.Color(164, 186, 191));
        comRes.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comRes.setForeground(new java.awt.Color(36, 56, 63));
        comRes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comResItemStateChanged(evt);
            }
        });
        add(comRes, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 60, 240, 30));

        editarNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/test.png"))); // NOI18N
        editarNuevo.setToolTipText("Actualizar");
        editarNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarNuevoMouseClicked(evt);
            }
        });
        add(editarNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 70, 70));

        guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clipboardM.png"))); // NOI18N
        guardar.setToolTipText("Guardar");
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarMouseClicked(evt);
            }
        });
        add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 470, 70, 70));

        comPer.setBackground(new java.awt.Color(164, 186, 191));
        comPer.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPer.setForeground(new java.awt.Color(36, 56, 63));
        add(comPer, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 109, 240, 31));

        turnoLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        turnoLabel.setForeground(new java.awt.Color(36, 56, 63));
        turnoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(turnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 240, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
        guardarDatos();
    }//GEN-LAST:event_guardarMouseClicked

    private void editarNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarNuevoMouseClicked
        actualizar();
    }//GEN-LAST:event_editarNuevoMouseClicked

    private void comResItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comResItemStateChanged
        comboTur();
    }//GEN-LAST:event_comResItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comPer;
    private javax.swing.JComboBox<String> comRes;
    private javax.swing.JLabel editarNuevo;
    private javax.swing.JLabel guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField mesaTF;
    private javax.swing.JLabel turnoLabel;
    // End of variables declaration//GEN-END:variables
}
