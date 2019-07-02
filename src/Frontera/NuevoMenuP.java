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
        return (mesaTF.getText().isEmpty()
                && comida1TF.getText().isEmpty()
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
        comPer.setSelectedIndex(0);
        mesaTF.setText("");
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

        if ("Ninguna".equals(comPer.getSelectedItem().toString())) {
            menup.setPersona("");

            respuesta = validar.validarMenu(menup);

            dialogoOk.textoLabel(respuesta);
            dialogoOk.visible();
        } else {
            menup.setPersona(Character.toString(comPer.getSelectedItem().toString().charAt(0)));
            menup.setMesa(mesaTF.getText());
            menup.setComida1(comida1TF.getText());
            menup.setComida2(comida2TF.getText());
            menup.setComida3(comida3TF.getText());
            menup.setComida4(comida4TF.getText());
            menup.setComida5(comida5TF.getText());
            menup.setComida6(comida6TF.getText());
            menup.setComida7(comida7TF.getText());

            respuesta = validar.validarMenu(menup);

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
                        daoMenp.crear(menup.getPersona(), menup.getMesa(), menup.getComida1(), menup.getComida2(), menup.getComida3(), menup.getComida4(), menup.getComida5(), menup.getComida6(), menup.getComida7());
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
        mesaTF.setText(men.getMesa());
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
            if ("Ninguna".equals(comPer.getSelectedItem().toString())) {
                menup.setPersona("");

                respuesta = validar.validarMenu(menup);

                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else {
                menup.setPersona(Character.toString(comPer.getSelectedItem().toString().charAt(0)));
                menup.setMesa(mesaTF.getText());
                menup.setComida1(comida1TF.getText());
                menup.setComida2(comida2TF.getText());
                menup.setComida3(comida3TF.getText());
                menup.setComida4(comida4TF.getText());
                menup.setComida5(comida5TF.getText());
                menup.setComida6(comida6TF.getText());
                menup.setComida7(comida7TF.getText());

                respuesta = validar.validarMenu(menup);

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
                            daoMenp.editar(Integer.parseInt(menup.getPersona()), menup.getMesa(), menup.getComida1(), menup.getComida2(), menup.getComida3(), menup.getComida4(), menup.getComida5(), menup.getComida6(), menup.getComida7(), filaU);
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

        comida3 = new javax.swing.JLabel();
        comida7TF = new javax.swing.JTextField();
        comida5TF = new javax.swing.JTextField();
        comida4TF = new javax.swing.JTextField();
        separador4 = new javax.swing.JSeparator();
        separador5 = new javax.swing.JSeparator();
        separador2 = new javax.swing.JSeparator();
        separador8 = new javax.swing.JSeparator();
        guardar = new javax.swing.JLabel();
        separador1 = new javax.swing.JSeparator();
        comPer = new javax.swing.JComboBox<>();
        comida7 = new javax.swing.JLabel();
        editarNuevo = new javax.swing.JLabel();
        comida2 = new javax.swing.JLabel();
        separador3 = new javax.swing.JSeparator();
        comida6TF = new javax.swing.JTextField();
        mesaTF = new javax.swing.JTextField();
        persona = new javax.swing.JLabel();
        comida2TF = new javax.swing.JTextField();
        separador7 = new javax.swing.JSeparator();
        separador6 = new javax.swing.JSeparator();
        comida5 = new javax.swing.JLabel();
        comida1 = new javax.swing.JLabel();
        comida6 = new javax.swing.JLabel();
        mesaLabel = new javax.swing.JLabel();
        comida4 = new javax.swing.JLabel();
        comida1TF = new javax.swing.JTextField();
        comida3TF = new javax.swing.JTextField();

        setBackground(new java.awt.Color(164, 186, 191));

        comida3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida3.setForeground(new java.awt.Color(36, 56, 63));
        comida3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida3.setText("Comida #3");

        comida7TF.setBackground(new java.awt.Color(164, 186, 191));
        comida7TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida7TF.setForeground(new java.awt.Color(36, 56, 63));
        comida7TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida7TF.setBorder(null);

        comida5TF.setBackground(new java.awt.Color(164, 186, 191));
        comida5TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida5TF.setForeground(new java.awt.Color(36, 56, 63));
        comida5TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida5TF.setBorder(null);

        comida4TF.setBackground(new java.awt.Color(164, 186, 191));
        comida4TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida4TF.setForeground(new java.awt.Color(36, 56, 63));
        comida4TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida4TF.setBorder(null);

        separador4.setBackground(new java.awt.Color(36, 56, 63));
        separador4.setForeground(new java.awt.Color(36, 56, 63));

        separador5.setBackground(new java.awt.Color(36, 56, 63));
        separador5.setForeground(new java.awt.Color(36, 56, 63));

        separador2.setBackground(new java.awt.Color(36, 56, 63));
        separador2.setForeground(new java.awt.Color(36, 56, 63));

        separador8.setBackground(new java.awt.Color(36, 56, 63));
        separador8.setForeground(new java.awt.Color(36, 56, 63));

        guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clipboardM.png"))); // NOI18N
        guardar.setToolTipText("Guardar");
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarMouseClicked(evt);
            }
        });

        separador1.setBackground(new java.awt.Color(36, 56, 63));
        separador1.setForeground(new java.awt.Color(36, 56, 63));

        comPer.setBackground(new java.awt.Color(164, 186, 191));
        comPer.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPer.setForeground(new java.awt.Color(36, 56, 63));

        comida7.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida7.setForeground(new java.awt.Color(36, 56, 63));
        comida7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida7.setText("Comida #7");

        editarNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/test.png"))); // NOI18N
        editarNuevo.setToolTipText("Actualizar");
        editarNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarNuevoMouseClicked(evt);
            }
        });

        comida2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida2.setForeground(new java.awt.Color(36, 56, 63));
        comida2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida2.setText("Comida #2");

        separador3.setBackground(new java.awt.Color(36, 56, 63));
        separador3.setForeground(new java.awt.Color(36, 56, 63));

        comida6TF.setBackground(new java.awt.Color(164, 186, 191));
        comida6TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida6TF.setForeground(new java.awt.Color(36, 56, 63));
        comida6TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida6TF.setBorder(null);

        mesaTF.setBackground(new java.awt.Color(164, 186, 191));
        mesaTF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        mesaTF.setForeground(new java.awt.Color(36, 56, 63));
        mesaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mesaTF.setBorder(null);

        persona.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        persona.setForeground(new java.awt.Color(36, 56, 63));
        persona.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        persona.setText("Persona");

        comida2TF.setBackground(new java.awt.Color(164, 186, 191));
        comida2TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida2TF.setForeground(new java.awt.Color(36, 56, 63));
        comida2TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida2TF.setBorder(null);

        separador7.setBackground(new java.awt.Color(36, 56, 63));
        separador7.setForeground(new java.awt.Color(36, 56, 63));

        separador6.setBackground(new java.awt.Color(36, 56, 63));
        separador6.setForeground(new java.awt.Color(36, 56, 63));

        comida5.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida5.setForeground(new java.awt.Color(36, 56, 63));
        comida5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida5.setText("Comida #5");

        comida1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida1.setForeground(new java.awt.Color(36, 56, 63));
        comida1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida1.setText("Comida #1");

        comida6.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida6.setForeground(new java.awt.Color(36, 56, 63));
        comida6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida6.setText("Comida #6");

        mesaLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        mesaLabel.setForeground(new java.awt.Color(36, 56, 63));
        mesaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mesaLabel.setText("Mesa");

        comida4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida4.setForeground(new java.awt.Color(36, 56, 63));
        comida4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida4.setText("Comida #4");

        comida1TF.setBackground(new java.awt.Color(164, 186, 191));
        comida1TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida1TF.setForeground(new java.awt.Color(36, 56, 63));
        comida1TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida1TF.setBorder(null);

        comida3TF.setBackground(new java.awt.Color(164, 186, 191));
        comida3TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida3TF.setForeground(new java.awt.Color(36, 56, 63));
        comida3TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida3TF.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(persona, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comPer, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(352, 352, 352)
                        .addComponent(editarNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(mesaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(mesaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(comida1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(comida1TF, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(comida2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(comida2TF, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(separador3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(comida3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(comida3TF, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(separador4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(comida4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(comida4TF, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(separador5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(comida5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(comida5TF, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(separador6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(comida6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(comida6TF, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(separador7, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(comida7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comida7TF, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(separador8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(350, 350, 350)
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editarNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(persona, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comPer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mesaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida1TF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida2TF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(separador3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida3TF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(separador4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida4TF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(separador5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida5TF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(separador6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida6TF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(separador7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comida7TF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separador8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
        guardarDatos();
    }//GEN-LAST:event_guardarMouseClicked

    private void editarNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarNuevoMouseClicked
        actualizar();
    }//GEN-LAST:event_editarNuevoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comPer;
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
    private javax.swing.JLabel editarNuevo;
    private javax.swing.JLabel guardar;
    private javax.swing.JLabel mesaLabel;
    private javax.swing.JTextField mesaTF;
    private javax.swing.JLabel persona;
    private javax.swing.JSeparator separador1;
    private javax.swing.JSeparator separador2;
    private javax.swing.JSeparator separador3;
    private javax.swing.JSeparator separador4;
    private javax.swing.JSeparator separador5;
    private javax.swing.JSeparator separador6;
    private javax.swing.JSeparator separador7;
    private javax.swing.JSeparator separador8;
    // End of variables declaration//GEN-END:variables
}
