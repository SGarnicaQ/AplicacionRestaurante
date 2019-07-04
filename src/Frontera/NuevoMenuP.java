package Frontera;

import Control.ValidarMenuP;
import DAO.MenuPDAO;
import Entidad.MenuP;

public class NuevoMenuP extends javax.swing.JPanel {

    private final MenuPDAO daoMenp = new MenuPDAO();
    private final MenuP menup = new MenuP();
    private final ValidarMenuP validar = new ValidarMenuP();

    private final DialogoOK dialogoOk = new DialogoOK(null, true);

    private int filaU = 0;

    public NuevoMenuP() {
        initComponents();
    }

    public boolean validarCampos() {
        return (restauranteLabel.getText().isEmpty()
                && turnoLabel.getText().isEmpty());
    }

    public boolean validarComidas() {
        return (restauranteLabel.getText().isEmpty()
                && turnoLabel.getText().isEmpty());
    }

    public void vaciarCampos() {
        comPer.setSelectedIndex(0);
        mesaLabel.setText("");
        restauranteLabel.setText("");
        turnoLabel.setText("");
        comMen.setSelectedIndex(0);
        descripcionLabel.setText("");
    }

    public void guardarDatos() {

        String respuesta;

        if ("Ninguna".equals(comMen.getSelectedItem().toString())) {
            menup.setPersona("");

            respuesta = validar.validarMenuP(menup);

            dialogoOk.textoLabel(respuesta);
            dialogoOk.visible();
        } else {
            menup.setPersona(Character.toString(comPer.getSelectedItem().toString().charAt(0)));
            menup.setMesa(mesaLabel.getText());
            menup.setTurno(turnoLabel.getText());
            menup.setMenu(Character.toString(comMen.getSelectedItem().toString().charAt(0)));

            respuesta = validar.validarMenuP(menup);

            if ("Longitud mesa incorrecta".equals(respuesta)) {
                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else {
                if (!validarComidas()) {
                    if ("Longitud persona incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud mesa incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud comida #1 incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud comida #2 incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud comida #3 incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud comida #4 incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud comida #5 incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud comida #6 incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud comida #7 incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else {
                        daoMenp.crear(menup.getPersona(), menup.getMesa(), menup.getTurno(), menup.getMenu());
                        vaciarCampos();
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    }
                } else {
                    dialogoOk.textoLabel("Por favor ingrese una comida");
                    dialogoOk.visible();
                }
            }
        }
    }

    public void editar(MenuP men, int fila) {

        comPer.setModel(daoMenp.comboPer());
        mesaLabel.setText(men.getMesa());
        turnoLabel.setText(men.getTurno());

        filaU = fila;
    }

    public void actualizar() {
        if (filaU != 0) {

            String respuesta;
            if ("Ninguna".equals(comMen.getSelectedItem().toString())) {
                menup.setPersona("");

                respuesta = validar.validarMenuP(menup);

                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else {
                menup.setPersona(Character.toString(comPer.getSelectedItem().toString().charAt(0)));
                menup.setMesa(mesaLabel.getText());
                menup.setTurno(turnoLabel.getText());
                menup.setMenu(Character.toString(comMen.getSelectedItem().toString().charAt(0)));

                respuesta = validar.validarMenuP(menup);

                if ("Longitud descripcion incorrecta".equals(respuesta)) {
                    dialogoOk.textoLabel(respuesta);
                    dialogoOk.visible();
                } else {
                    if (!validarComidas()) {
                        if ("Longitud persona incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud mesa incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #1 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #2 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #3 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #4 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #5 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #6 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud comida #7 incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else {
                            daoMenp.editar(Integer.parseInt(menup.getPersona()), menup.getMesa(), menup.getTurno(), menup.getMenu(), filaU);
                            vaciarCampos();
                            System.out.println("asd");
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                            System.out.println(filaU);
                            filaU = 0;
                        }
                    } else {
                        dialogoOk.textoLabel("Por favor ingrese una comida");
                        dialogoOk.visible();
                    }
                }
            }
        } else {
            dialogoOk.textoLabel("Por favor vuelva atrás");
            dialogoOk.visible();

        }
    }

    public void comboPer() {
        comPer.setVisible(false);
        comPer.removeAll();
        comPer.setModel(daoMenp.comboPer());
        comPer.setVisible(true);
    }

    public void comboMen() {
        if ("Ninguna".equals(comPer.getSelectedItem().toString())) {
            comMen.setVisible(false);
            comMen.removeAllItems();
            comMen.addItem("Ninguno");
            comMen.setVisible(true);
        } else {
            comMen.setVisible(false);
            comMen.removeAll();
            comMen.setModel(daoMenp.comboMen(restauranteLabel.getText()));
            comMen.setVisible(true);
        }
    }

    public void datosLabel() {
        if ("Ninguna".equals(comPer.getSelectedItem().toString())) {
            comMen.setVisible(false);
            comMen.removeAllItems();
            comMen.addItem("Ninguno");
            comMen.setVisible(true);
            mesaLabel.setText("");
            turnoLabel.setText("");
            restauranteLabel.setText("");
            descripcionLabel.setText("");
        } else {

            int fila = daoMenp.fila(comPer.getSelectedItem().toString().substring(3, comPer.getSelectedItem().toString().length()));

            String[] datos = daoMenp.mesa(fila);
            String[] descrip = daoMenp.descripcion(fila);

            restauranteLabel.setText(datos[0]);
            mesaLabel.setText(datos[1]);
            turnoLabel.setText(datos[2]);
            descripcionLabel.setText(descrip[0]);

            comboMen();
        }
    }

    public void menCom() {
        if ("Ninguna".equals(comPer.getSelectedItem().toString())) {
        } else {
            int fil = Integer.parseInt(comMen.getSelectedItem().toString());
            String[] descrip = daoMenp.descripcion(fil);
            descripcionLabel.setText(descrip[0]);
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

        guardar = new javax.swing.JLabel();
        comMen = new javax.swing.JComboBox<>();
        editarNuevo = new javax.swing.JLabel();
        comida2 = new javax.swing.JLabel();
        persona = new javax.swing.JLabel();
        comida1 = new javax.swing.JLabel();
        turnoLabel = new javax.swing.JLabel();
        comPer = new javax.swing.JComboBox<>();
        mesaTF = new javax.swing.JLabel();
        restauranteLabel = new javax.swing.JLabel();
        mesaLabel = new javax.swing.JLabel();
        descripcionLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(164, 186, 191));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        comMen.setBackground(new java.awt.Color(164, 186, 191));
        comMen.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comMen.setForeground(new java.awt.Color(36, 56, 63));
        comMen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comMenItemStateChanged(evt);
            }
        });
        add(comMen, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 240, 30));

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

        comida2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida2.setForeground(new java.awt.Color(36, 56, 63));
        comida2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida2.setText("Menu");
        add(comida2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 200, 30));

        persona.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        persona.setForeground(new java.awt.Color(36, 56, 63));
        persona.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        persona.setText("Persona");
        add(persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 200, 30));

        comida1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida1.setForeground(new java.awt.Color(36, 56, 63));
        comida1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida1.setText("Turno");
        add(comida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 200, 30));

        turnoLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        turnoLabel.setForeground(new java.awt.Color(36, 56, 63));
        turnoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(turnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 240, 30));

        comPer.setBackground(new java.awt.Color(164, 186, 191));
        comPer.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPer.setForeground(new java.awt.Color(36, 56, 63));
        comPer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comPerItemStateChanged(evt);
            }
        });
        add(comPer, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 60, 240, 30));

        mesaTF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        mesaTF.setForeground(new java.awt.Color(36, 56, 63));
        mesaTF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mesaTF.setText("Mesa");
        add(mesaTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 200, 30));

        restauranteLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        restauranteLabel.setForeground(new java.awt.Color(36, 56, 63));
        restauranteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(restauranteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 240, 30));

        mesaLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        mesaLabel.setForeground(new java.awt.Color(36, 56, 63));
        mesaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(mesaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 240, 30));

        descripcionLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        descripcionLabel.setForeground(new java.awt.Color(36, 56, 63));
        descripcionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(descripcionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 250, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
        guardarDatos();
    }//GEN-LAST:event_guardarMouseClicked

    private void editarNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarNuevoMouseClicked
        actualizar();
    }//GEN-LAST:event_editarNuevoMouseClicked

    private void comPerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comPerItemStateChanged
        datosLabel();
        menCom();
    }//GEN-LAST:event_comPerItemStateChanged

    private void comMenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comMenItemStateChanged
        menCom();
    }//GEN-LAST:event_comMenItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comMen;
    private javax.swing.JComboBox<String> comPer;
    private javax.swing.JLabel comida1;
    private javax.swing.JLabel comida2;
    private javax.swing.JLabel descripcionLabel;
    private javax.swing.JLabel editarNuevo;
    private javax.swing.JLabel guardar;
    private javax.swing.JLabel mesaLabel;
    private javax.swing.JLabel mesaTF;
    private javax.swing.JLabel persona;
    private javax.swing.JLabel restauranteLabel;
    private javax.swing.JLabel turnoLabel;
    // End of variables declaration//GEN-END:variables
}
