package Frontera;

import Control.ValidarMenu;
import DAO.MenuDAO;
import Entidad.Menu;

public class NuevoMenu extends javax.swing.JPanel {

    private final Menu menu = new Menu();
    private final ValidarMenu validar = new ValidarMenu();
    private final MenuDAO daoMen = new MenuDAO();

    private final DialogoOK dialogoOk = new DialogoOK(null, true);

    private int filaU = 0;

    public NuevoMenu() {
        initComponents();
    }

    public boolean validarCampos() {
        return (comida1TF.getText().isEmpty()
                && comida2TF.getText().isEmpty()
                && comida3TF.getText().isEmpty()
                && comida4TF.getText().isEmpty()
                && comida5TF.getText().isEmpty()
                && comida6TF.getText().isEmpty()
                && comida7TF.getText().isEmpty());
    }

    public boolean validarComidas() {
        return (comida1TF.getText().isEmpty()
                && comida2TF.getText().isEmpty()
                && comida3TF.getText().isEmpty()
                && comida4TF.getText().isEmpty()
                && comida5TF.getText().isEmpty()
                && comida6TF.getText().isEmpty()
                && comida7TF.getText().isEmpty());
    }

    public void vaciarCampos() {
        comRes.setSelectedIndex(0);
        comFec.setSelectedIndex(0);
        comida1TF.setText("");
        comida2TF.setText("");
        comida3TF.setText("");
        comida4TF.setText("");
        comida5TF.setText("");
        comida6TF.setText("");
        comida7TF.setText("");
    }

    public void guardarDatos() {

        String respuesta;

        if ("Ninguno".equals(comRes.getSelectedItem().toString())) {
            menu.setRestaurante("");

            respuesta = validar.validarMenu(menu);

            dialogoOk.textoLabel(respuesta);
            dialogoOk.visible();
        } else {
            menu.setRestaurante(Character.toString(comRes.getSelectedItem().toString().charAt(0)));
            menu.setDescripcion(comDes.getSelectedItem().toString());
            menu.setDia(comFec.getSelectedItem().toString());
            menu.setComida1(comida1TF.getText());
            menu.setComida2(comida2TF.getText());
            menu.setComida3(comida3TF.getText());
            menu.setComida4(comida4TF.getText());
            menu.setComida5(comida5TF.getText());
            menu.setComida6(comida6TF.getText());
            menu.setComida7(comida7TF.getText());

            respuesta = validar.validarMenu(menu);

            if ("Longitud descripcion incorrecta".equals(respuesta)) {
                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else {
                if (!validarComidas()) {
                    if ("Longitud restaurante incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud descripcion incorrecta".equals(respuesta)) {
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
                        daoMen.crear(menu.getRestaurante(), menu.getDescripcion(),menu.getDia(), menu.getComida1(), menu.getComida2(), menu.getComida3(), menu.getComida4(), menu.getComida5(), menu.getComida6(), menu.getComida7());
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

    public void editar(Menu men, int fila) {

        comRes.setModel(daoMen.comboRes());
        //comDes.setModel(daoMen.comboRes());
        comida1TF.setText(men.getComida1());
        comida2TF.setText(men.getComida2());
        comida3TF.setText(men.getComida3());
        comida4TF.setText(men.getComida4());
        comida5TF.setText(men.getComida5());
        comida6TF.setText(men.getComida6());
        comida7TF.setText(men.getComida7());

        filaU = fila;
    }

    public void actualizar() {
        if (filaU != 0) {

            String respuesta;
            if ("Ninguno".equals(comDes.getSelectedItem().toString())) {
                menu.setRestaurante("");

                respuesta = validar.validarMenu(menu);

                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else {
                menu.setRestaurante(Character.toString(comRes.getSelectedItem().toString().charAt(0)));
                menu.setDescripcion(comDes.getSelectedItem().toString());
                menu.setDia(comFec.getSelectedItem().toString());
                menu.setComida1(comida1TF.getText());
                menu.setComida2(comida2TF.getText());
                menu.setComida3(comida3TF.getText());
                menu.setComida4(comida4TF.getText());
                menu.setComida5(comida5TF.getText());
                menu.setComida6(comida6TF.getText());
                menu.setComida7(comida7TF.getText());

                respuesta = validar.validarMenu(menu);

                if ("Longitud descripcion incorrecta".equals(respuesta)) {
                    dialogoOk.textoLabel(respuesta);
                    dialogoOk.visible();
                } else {
                    if (!validarComidas()) {
                        if ("Longitud restaurante incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud tipo incorrecta".equals(respuesta)) {
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
                            daoMen.editar(Integer.parseInt(menu.getRestaurante()), menu.getDescripcion(), menu.getComida1(), menu.getComida2(), menu.getComida3(), menu.getComida4(), menu.getComida5(), menu.getComida6(), menu.getComida7(), filaU);
                            vaciarCampos();
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
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

    public void comboFec() {
        comFec.setVisible(false);
        comFec.removeAllItems();
        comFec.addItem("Lunes");
        comFec.addItem("Martes");
        comFec.addItem("Miercoles");
        comFec.addItem("Jueves");
        comFec.addItem("Viernes");
        comFec.addItem("Sábado");
        comFec.addItem("Domingo");
        comFec.setVisible(true);
    }

    public void comboRes() {
        comRes.setVisible(false);
        comRes.removeAll();
        comRes.setModel(daoMen.comboRes());
        comRes.setVisible(true);
    }
    
    public void comboDes(){
        comDes.setVisible(false);
        comDes.removeAllItems();
        comDes.addItem("Entrada");
        comDes.addItem("Plato fuerte");
        comDes.addItem("Postre");
        comDes.addItem("Costo adicional");
        comDes.setVisible(true);
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

        restaurante = new javax.swing.JLabel();
        comDes = new javax.swing.JComboBox<>();
        descripcionLabel = new javax.swing.JLabel();
        comida1TF = new javax.swing.JTextField();
        separador2 = new javax.swing.JSeparator();
        comida2TF = new javax.swing.JTextField();
        separador3 = new javax.swing.JSeparator();
        comida3TF = new javax.swing.JTextField();
        separador4 = new javax.swing.JSeparator();
        comida4TF = new javax.swing.JTextField();
        separador5 = new javax.swing.JSeparator();
        comida5TF = new javax.swing.JTextField();
        separador6 = new javax.swing.JSeparator();
        comida6TF = new javax.swing.JTextField();
        separador7 = new javax.swing.JSeparator();
        comida7TF = new javax.swing.JTextField();
        separador8 = new javax.swing.JSeparator();
        comida1 = new javax.swing.JLabel();
        comida2 = new javax.swing.JLabel();
        comida3 = new javax.swing.JLabel();
        comida4 = new javax.swing.JLabel();
        comida5 = new javax.swing.JLabel();
        comida6 = new javax.swing.JLabel();
        comida7 = new javax.swing.JLabel();
        editarNuevo = new javax.swing.JLabel();
        guardar = new javax.swing.JLabel();
        comFec = new javax.swing.JComboBox<>();
        comRes = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(164, 186, 191));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        restaurante.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        restaurante.setForeground(new java.awt.Color(36, 56, 63));
        restaurante.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        restaurante.setText("Restaurante");
        add(restaurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 200, 30));

        comDes.setBackground(new java.awt.Color(164, 186, 191));
        comDes.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comDes.setForeground(new java.awt.Color(36, 56, 63));
        add(comDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 240, 30));

        descripcionLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        descripcionLabel.setForeground(new java.awt.Color(36, 56, 63));
        descripcionLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        descripcionLabel.setText("Descripción");
        add(descripcionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 200, 30));

        comida1TF.setBackground(new java.awt.Color(164, 186, 191));
        comida1TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida1TF.setForeground(new java.awt.Color(36, 56, 63));
        comida1TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida1TF.setBorder(null);
        add(comida1TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 240, 30));

        separador2.setBackground(new java.awt.Color(36, 56, 63));
        separador2.setForeground(new java.awt.Color(36, 56, 63));
        add(separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 240, 10));

        comida2TF.setBackground(new java.awt.Color(164, 186, 191));
        comida2TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida2TF.setForeground(new java.awt.Color(36, 56, 63));
        comida2TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida2TF.setBorder(null);
        add(comida2TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 240, 30));

        separador3.setBackground(new java.awt.Color(36, 56, 63));
        separador3.setForeground(new java.awt.Color(36, 56, 63));
        add(separador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 240, 10));

        comida3TF.setBackground(new java.awt.Color(164, 186, 191));
        comida3TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida3TF.setForeground(new java.awt.Color(36, 56, 63));
        comida3TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida3TF.setBorder(null);
        add(comida3TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 240, 30));

        separador4.setBackground(new java.awt.Color(36, 56, 63));
        separador4.setForeground(new java.awt.Color(36, 56, 63));
        add(separador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 240, 10));

        comida4TF.setBackground(new java.awt.Color(164, 186, 191));
        comida4TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida4TF.setForeground(new java.awt.Color(36, 56, 63));
        comida4TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida4TF.setBorder(null);
        add(comida4TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 240, 30));

        separador5.setBackground(new java.awt.Color(36, 56, 63));
        separador5.setForeground(new java.awt.Color(36, 56, 63));
        add(separador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 240, 10));

        comida5TF.setBackground(new java.awt.Color(164, 186, 191));
        comida5TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida5TF.setForeground(new java.awt.Color(36, 56, 63));
        comida5TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida5TF.setBorder(null);
        add(comida5TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 240, 30));

        separador6.setBackground(new java.awt.Color(36, 56, 63));
        separador6.setForeground(new java.awt.Color(36, 56, 63));
        add(separador6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 240, 10));

        comida6TF.setBackground(new java.awt.Color(164, 186, 191));
        comida6TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida6TF.setForeground(new java.awt.Color(36, 56, 63));
        comida6TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida6TF.setBorder(null);
        add(comida6TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 240, 30));

        separador7.setBackground(new java.awt.Color(36, 56, 63));
        separador7.setForeground(new java.awt.Color(36, 56, 63));
        add(separador7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 240, 10));

        comida7TF.setBackground(new java.awt.Color(164, 186, 191));
        comida7TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida7TF.setForeground(new java.awt.Color(36, 56, 63));
        comida7TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida7TF.setBorder(null);
        add(comida7TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, 240, 30));

        separador8.setBackground(new java.awt.Color(36, 56, 63));
        separador8.setForeground(new java.awt.Color(36, 56, 63));
        add(separador8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 240, 10));

        comida1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida1.setForeground(new java.awt.Color(36, 56, 63));
        comida1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida1.setText("Comida #1");
        add(comida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 200, 30));

        comida2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida2.setForeground(new java.awt.Color(36, 56, 63));
        comida2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida2.setText("Comida #2");
        add(comida2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 200, 30));

        comida3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida3.setForeground(new java.awt.Color(36, 56, 63));
        comida3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida3.setText("Comida #3");
        add(comida3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 200, 30));

        comida4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida4.setForeground(new java.awt.Color(36, 56, 63));
        comida4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida4.setText("Comida #4");
        add(comida4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 200, 30));

        comida5.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida5.setForeground(new java.awt.Color(36, 56, 63));
        comida5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida5.setText("Comida #5");
        add(comida5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 200, 30));

        comida6.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida6.setForeground(new java.awt.Color(36, 56, 63));
        comida6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida6.setText("Comida #6");
        add(comida6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 200, 30));

        comida7.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida7.setForeground(new java.awt.Color(36, 56, 63));
        comida7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida7.setText("Comida #7");
        add(comida7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 200, 30));

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

        comFec.setBackground(new java.awt.Color(164, 186, 191));
        comFec.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comFec.setForeground(new java.awt.Color(36, 56, 63));
        comFec.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comFecItemStateChanged(evt);
            }
        });
        add(comFec, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 200, 30));

        comRes.setBackground(new java.awt.Color(164, 186, 191));
        comRes.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comRes.setForeground(new java.awt.Color(36, 56, 63));
        add(comRes, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 60, 240, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void editarNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarNuevoMouseClicked
        actualizar();
    }//GEN-LAST:event_editarNuevoMouseClicked

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
        guardarDatos();
    }//GEN-LAST:event_guardarMouseClicked

    private void comFecItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comFecItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comFecItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comDes;
    private javax.swing.JComboBox<String> comFec;
    private javax.swing.JComboBox<String> comRes;
    private javax.swing.JLabel comida1;
    private javax.swing.JTextField comida1TF;
    private javax.swing.JLabel comida2;
    private javax.swing.JTextField comida2TF;
    private javax.swing.JLabel comida3;
    private javax.swing.JTextField comida3TF;
    private javax.swing.JLabel comida4;
    private javax.swing.JTextField comida4TF;
    private javax.swing.JLabel comida5;
    private javax.swing.JTextField comida5TF;
    private javax.swing.JLabel comida6;
    private javax.swing.JTextField comida6TF;
    private javax.swing.JLabel comida7;
    private javax.swing.JTextField comida7TF;
    private javax.swing.JLabel descripcionLabel;
    private javax.swing.JLabel editarNuevo;
    private javax.swing.JLabel guardar;
    private javax.swing.JLabel restaurante;
    private javax.swing.JSeparator separador2;
    private javax.swing.JSeparator separador3;
    private javax.swing.JSeparator separador4;
    private javax.swing.JSeparator separador5;
    private javax.swing.JSeparator separador6;
    private javax.swing.JSeparator separador7;
    private javax.swing.JSeparator separador8;
    // End of variables declaration//GEN-END:variables
}
