package Frontera;

import Control.ValidarPedido;
import DAO.PedidoDAO;
import Entidad.Pedido;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class NuevoPedido extends javax.swing.JPanel {

    private final PedidoDAO daoPed = new PedidoDAO();
    private final Pedido pedido = new Pedido();
    private final ValidarPedido validar = new ValidarPedido();

    private final DialogoOK dialogoOk = new DialogoOK(null, true);

    private int filaU = 0;

    public NuevoPedido() {
        initComponents();
    }

    public boolean validarCampos() {
        return (habitacionTF.getText().isEmpty());
    }

    public void vaciarCampos() {
        comPer.setSelectedIndex(0);
        habitacionTF.setText("");
        comRes.setSelectedIndex(0);
    }

    public void vaciarCom() {
        com1.setText("");
        com2.setText("");
        com3.setText("");
        com4.setText("");
        com5.setText("");
        com6.setText("");
        com7.setText("");
    }

    public void inhabilitarCom() {
        com1.setEnabled(false);
        com2.setEnabled(false);
        com3.setEnabled(false);
        com4.setEnabled(false);
        com5.setEnabled(false);
        com6.setEnabled(false);
        com7.setEnabled(false);
    }

    public void deseleccionarCom() {
        com1.setSelected(false);
        com2.setSelected(false);
        com3.setSelected(false);
        com4.setSelected(false);
        com5.setSelected(false);
        com6.setSelected(false);
        com7.setSelected(false);
    }

    public void guardarDatos() {

        String respuesta;

        if ("Ninguna".equals(comPer.getSelectedItem().toString())) {
            pedido.setPersona(0);

            respuesta = validar.validarPedido(pedido);

            dialogoOk.textoLabel(respuesta);
            dialogoOk.visible();
        } else if ("".equals(habitacionTF.getText())) {
            pedido.setPersona(Integer.parseInt(Character.toString(comPer.getSelectedItem().toString().charAt(0))));
            pedido.setHabitacion(0);

            respuesta = validar.validarPedido(pedido);

            dialogoOk.textoLabel(respuesta);
            dialogoOk.visible();
        } else if ("Ninguno".equals(comRes.getSelectedItem().toString())) {
            pedido.setPersona(Integer.parseInt(Character.toString(comPer.getSelectedItem().toString().charAt(0))));
            pedido.setHabitacion(Integer.parseInt(habitacionTF.getText()));
            pedido.setRestaurante(0);

            respuesta = validar.validarPedido(pedido);

            dialogoOk.textoLabel(respuesta);
            dialogoOk.visible();
        } else {
            pedido.setPersona(Integer.parseInt(Character.toString(comPer.getSelectedItem().toString().charAt(0))));
            pedido.setHabitacion(Integer.parseInt(habitacionTF.getText()));
            pedido.setRestaurante(Integer.parseInt(Character.toString(comRes.getSelectedItem().toString().charAt(0))));
            pedido.setTipoH(time.getText());

            if (comida()) {
                entCom();

                respuesta = validar.validarPedido(pedido);

                if ("Longitud habitacion incorrecta".equals(respuesta)) {
                    dialogoOk.textoLabel(respuesta);
                    dialogoOk.visible();
                } else {
                    if (!validarCampos()) {
                        if ("Longitud persona incorrecta".equals(respuesta)) {
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        } else if ("Longitud restaurante incorrecta".equals(respuesta)) {
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
                            daoPed.crear(pedido.getPersona(), pedido.getHabitacion(), pedido.getRestaurante(), pedido.getTipoH(), pedido.getCom1(), pedido.getCom2(), pedido.getCom3(), pedido.getCom4(), pedido.getCom5(), pedido.getCom6(), pedido.getCom7());
                            vaciarCampos();
                            dialogoOk.textoLabel(respuesta);
                            dialogoOk.visible();
                        }
                    } else {
                        dialogoOk.textoLabel("Por favor ingrese una comida");
                        dialogoOk.visible();
                    }
                }
            } else {
                dialogoOk.textoLabel("Por favor seleccione una comida");
                dialogoOk.visible();
            }
        }
    }

    public void editar(Pedido ped, int fila) {

        comPer.setModel(daoPed.comboPer());
        comRes.setModel(daoPed.comboRes());

        habitacionTF.setText(String.valueOf(ped.getHabitacion()));
        time.setText(ped.getTipoH());

        filaU = fila;
    }

    public void actualizar() {
        if (filaU != 0) {

            String respuesta;

            if ("Ninguna".equals(comPer.getSelectedItem().toString())) {
                pedido.setPersona(0);

                respuesta = validar.validarPedido(pedido);

                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else if ("".equals(habitacionTF.getText())) {
                pedido.setPersona(Integer.parseInt(Character.toString(comPer.getSelectedItem().toString().charAt(0))));
                pedido.setHabitacion(0);

                respuesta = validar.validarPedido(pedido);

                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else if ("Ninguno".equals(comRes.getSelectedItem().toString())) {
                pedido.setPersona(Integer.parseInt(Character.toString(comPer.getSelectedItem().toString().charAt(0))));
                pedido.setHabitacion(Integer.parseInt(habitacionTF.getText()));
                pedido.setRestaurante(0);

                respuesta = validar.validarPedido(pedido);

                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else {
                pedido.setPersona(Integer.parseInt(Character.toString(comPer.getSelectedItem().toString().charAt(0))));
                pedido.setHabitacion(Integer.parseInt(habitacionTF.getText()));
                pedido.setRestaurante(Integer.parseInt(Character.toString(comRes.getSelectedItem().toString().charAt(0))));
                pedido.setTipoH(time.getText());

                if (comida()) {
                    entCom();

                    respuesta = validar.validarPedido(pedido);

                    if ("Longitud habitacion incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else {
                        if (!validarCampos()) {
                            if ("Longitud persona incorrecta".equals(respuesta)) {
                                dialogoOk.textoLabel(respuesta);
                                dialogoOk.visible();
                            } else if ("Longitud restaurante incorrecta".equals(respuesta)) {
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
                                daoPed.editar(pedido.getPersona(), pedido.getHabitacion(), pedido.getRestaurante(), pedido.getTipoH(), pedido.getCom1(), pedido.getCom2(), pedido.getCom3(), pedido.getCom4(), pedido.getCom5(), pedido.getCom6(), pedido.getCom7(), filaU);
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
                } else {
                    dialogoOk.textoLabel("Por favor seleccione una comida");
                    dialogoOk.visible();
                }
            }
        } else {
            dialogoOk.textoLabel("Por favor vuelva atrás");
            dialogoOk.visible();

        }
    }

    public boolean comida() {
        return ((com1.isSelected() && !"".equals(com1.getText()))
                || (com2.isSelected() && !"".equals(com2.getText()))
                || (com3.isSelected() && !"".equals(com3.getText()))
                || (com4.isSelected() && !"".equals(com4.getText()))
                || (com5.isSelected() && !"".equals(com5.getText()))
                || (com6.isSelected() && !"".equals(com6.getText())
                || (com7.isSelected() && !"".equals(com7.getText()))));
    }

    public void comSel(boolean ent) {
        com1.setEnabled((com1.isSelected() || !ent) && !"".equals(com1.getText()));
        com2.setEnabled((com2.isSelected() || !ent) && !"".equals(com2.getText()));
        com3.setEnabled((com3.isSelected() || !ent) && !"".equals(com3.getText()));
        com4.setEnabled((com4.isSelected() || !ent) && !"".equals(com4.getText()));
        com5.setEnabled((com5.isSelected() || !ent) && !"".equals(com5.getText()));
        com6.setEnabled((com6.isSelected() || !ent) && !"".equals(com6.getText()));
        com7.setEnabled((com7.isSelected() || !ent) && !"".equals(com7.getText()));
    }

    public void entCom() {
        if (comida()) {
            if (com1.isSelected()) {
                pedido.setCom1(com1.getText());
            } else {
                pedido.setCom1("");
            }
            if (com2.isSelected()) {
                pedido.setCom2(com2.getText());
            } else {
                pedido.setCom2("");
            }
            if (com3.isSelected()) {
                pedido.setCom3(com3.getText());
            } else {
                pedido.setCom3("");
            }
            if (com4.isSelected()) {
                pedido.setCom4(com4.getText());
            } else {
                pedido.setCom4("");
            }
            if (com5.isSelected()) {
                pedido.setCom5(com5.getText());
            } else {
                pedido.setCom5("");
            }
            if (com6.isSelected()) {
                pedido.setCom6(com6.getText());
            } else {
                pedido.setCom6("");
            }
            if (com7.isSelected()) {
                pedido.setCom7(com7.getText());
            } else {
                pedido.setCom7("");
            }
        }
    }

    public void comboPer() {
        comPer.setVisible(false);
        comPer.removeAll();
        comPer.setModel(daoPed.comboPer());
        comPer.setVisible(true);
    }

    public void comboRes() {
        comRes.setVisible(false);
        comRes.removeAll();
        comRes.setModel(daoPed.comboRes());
        comRes.setVisible(true);
    }

    public void comboFecEnt(String tipo) {
        if ("Ninguno".equals(comRes.getSelectedItem().toString())) {
            com1.setText("");
            com2.setText("");
            com3.setText("");
            com4.setText("");
            com5.setText("");
            com6.setText("");
            com7.setText("");
        } else {

            deseleccionarCom();

            String[] datos = daoPed.comidaDes(tipo, Integer.parseInt(Character.toString(comRes.getSelectedItem().toString().charAt(0))));

            com1.setText(datos[0]);
            com2.setText(datos[1]);
            com3.setText(datos[2]);
            com4.setText(datos[3]);
            com5.setText(datos[4]);
            com6.setText(datos[5]);
            com7.setText(datos[6]);

            com1.setEnabled(!"".equals(com1.getText()) && com1.getText() != null);
            com2.setEnabled(!"".equals(com2.getText()) && com2.getText() != null);
            com3.setEnabled(!"".equals(com3.getText()) && com3.getText() != null);
            com4.setEnabled(!"".equals(com4.getText()) && com4.getText() != null);
            com5.setEnabled(!"".equals(com5.getText()) && com5.getText() != null);
            com6.setEnabled(!"".equals(com6.getText()) && com6.getText() != null);
            com7.setEnabled(!"".equals(com7.getText()) && com7.getText() != null);
        }
    }

    public float time() {
        Calendar calendario = new GregorianCalendar();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int min = calendario.get(Calendar.MINUTE);
        float valor = hora + min * 0.01F;
        return valor;
    }

    public void timeLabel() {
        if (time() >= 0 && time() <= 11) {
            time.setText("Desayuno");
        } else if (time() > 11 && time() <= 16) {
            time.setText("Almuerzo");
        } else if (time() > 15 && time() <= 25) {
            time.setText("Cena");
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
        habitacionTF = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        comPer = new javax.swing.JComboBox<>();
        editarNuevo = new javax.swing.JLabel();
        guardar = new javax.swing.JLabel();
        comRes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        com1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        com2 = new javax.swing.JCheckBox();
        com3 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        com7 = new javax.swing.JCheckBox();
        com6 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        com5 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        com4 = new javax.swing.JCheckBox();
        time = new javax.swing.JLabel();

        setBackground(new java.awt.Color(164, 186, 191));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(36, 56, 63));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Comida #1");

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(36, 56, 63));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Persona");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(36, 56, 63));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Habitación");

        habitacionTF.setBackground(new java.awt.Color(164, 186, 191));
        habitacionTF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        habitacionTF.setForeground(new java.awt.Color(36, 56, 63));
        habitacionTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        habitacionTF.setBorder(null);

        jSeparator4.setBackground(new java.awt.Color(36, 56, 63));

        comPer.setBackground(new java.awt.Color(164, 186, 191));
        comPer.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPer.setForeground(new java.awt.Color(36, 56, 63));
        comPer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comPerItemStateChanged(evt);
            }
        });

        editarNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/test.png"))); // NOI18N
        editarNuevo.setToolTipText("Actualizar");
        editarNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarNuevoMouseClicked(evt);
            }
        });

        guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clipboardM.png"))); // NOI18N
        guardar.setToolTipText("Guardar");
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarMouseClicked(evt);
            }
        });

        comRes.setBackground(new java.awt.Color(164, 186, 191));
        comRes.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comRes.setForeground(new java.awt.Color(36, 56, 63));
        comRes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comResItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(36, 56, 63));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Restaurante");

        com1.setBackground(new java.awt.Color(164, 186, 191));
        com1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(36, 56, 63));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Comida #2");

        com2.setBackground(new java.awt.Color(164, 186, 191));
        com2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com2ActionPerformed(evt);
            }
        });

        com3.setBackground(new java.awt.Color(164, 186, 191));
        com3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(36, 56, 63));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Comida #3");

        com7.setBackground(new java.awt.Color(164, 186, 191));
        com7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com7ActionPerformed(evt);
            }
        });

        com6.setBackground(new java.awt.Color(164, 186, 191));
        com6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com6ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(36, 56, 63));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Comida #6");

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(36, 56, 63));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Comida #7");

        com5.setBackground(new java.awt.Color(164, 186, 191));
        com5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com5ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(36, 56, 63));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Comida #5");

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(36, 56, 63));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Comida #4");

        com4.setBackground(new java.awt.Color(164, 186, 191));
        com4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com4ActionPerformed(evt);
            }
        });

        time.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        time.setForeground(new java.awt.Color(36, 56, 63));
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(comPer, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(352, 352, 352)
                .addComponent(editarNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(habitacionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(comRes, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(com1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(com2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(com3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(com4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(com5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(com6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(com7, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(350, 350, 350)
                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(comPer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(editarNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(habitacionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comRes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(com1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(com2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(com3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(com4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(com5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(com6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(com7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comPerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comPerItemStateChanged

    }//GEN-LAST:event_comPerItemStateChanged

    private void editarNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarNuevoMouseClicked
        actualizar();
    }//GEN-LAST:event_editarNuevoMouseClicked

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
        guardarDatos();
    }//GEN-LAST:event_guardarMouseClicked

    private void comResItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comResItemStateChanged
        if (comRes.getSelectedIndex() != 0) {
            comboFecEnt(time.getText());
        } else {
            vaciarCom();
            inhabilitarCom();
            deseleccionarCom();
        }
    }//GEN-LAST:event_comResItemStateChanged

    private void com1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com1ActionPerformed
        if (comRes.getSelectedIndex() != 0) {
            comSel(comida());
        }
    }//GEN-LAST:event_com1ActionPerformed

    private void com2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com2ActionPerformed
        if (comRes.getSelectedIndex() != 0) {
            comSel(comida());
        }
    }//GEN-LAST:event_com2ActionPerformed

    private void com3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com3ActionPerformed
        if (comRes.getSelectedIndex() != 0) {
            comSel(comida());
        }
    }//GEN-LAST:event_com3ActionPerformed

    private void com4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com4ActionPerformed
        if (comRes.getSelectedIndex() != 0) {
            comSel(comida());
        }
    }//GEN-LAST:event_com4ActionPerformed

    private void com5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com5ActionPerformed
        if (comRes.getSelectedIndex() != 0) {
            comSel(comida());
        }
    }//GEN-LAST:event_com5ActionPerformed

    private void com6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com6ActionPerformed
        if (comRes.getSelectedIndex() != 0) {
            comSel(comida());
        }
    }//GEN-LAST:event_com6ActionPerformed

    private void com7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com7ActionPerformed
        if (comRes.getSelectedIndex() != 0) {
            comSel(comida());
        }
    }//GEN-LAST:event_com7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox com1;
    private javax.swing.JCheckBox com2;
    private javax.swing.JCheckBox com3;
    private javax.swing.JCheckBox com4;
    private javax.swing.JCheckBox com5;
    private javax.swing.JCheckBox com6;
    private javax.swing.JCheckBox com7;
    private javax.swing.JComboBox<String> comPer;
    private javax.swing.JComboBox<String> comRes;
    private javax.swing.JLabel editarNuevo;
    private javax.swing.JLabel guardar;
    private javax.swing.JTextField habitacionTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
