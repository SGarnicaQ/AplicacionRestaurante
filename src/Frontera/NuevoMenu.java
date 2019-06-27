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
        return (descripcionTF.getText().isEmpty()
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
        comRes.setSelectedIndex(0);
        descripcionTF.setText("");
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
            menu.setDescripcion(descripcionTF.getText());
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
                        daoMen.crear(menu.getRestaurante(), menu.getDescripcion(), menu.getComida1(), menu.getComida2(), menu.getComida3(), menu.getComida4(), menu.getComida5(), menu.getComida6(), menu.getComida7());
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
        descripcionTF.setText(men.getDescripcion());
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
            if ("Ninguno".equals(comRes.getSelectedItem().toString())) {
                menu.setRestaurante("");

                respuesta = validar.validarMenu(menu);

                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else {
                menu.setRestaurante(Character.toString(comRes.getSelectedItem().toString().charAt(0)));
                menu.setDescripcion(descripcionTF.getText());
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

    public void comboRes() {
        comRes.setVisible(false);
        comRes.removeAll();
        comRes.setModel(daoMen.comboRes());
        comRes.setVisible(true);
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
        comRes = new javax.swing.JComboBox<>();
        descripcionLabel = new javax.swing.JLabel();
        descripcionTF = new javax.swing.JTextField();
        separador1 = new javax.swing.JSeparator();
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

        setBackground(new java.awt.Color(164, 186, 191));

        restaurante.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        restaurante.setForeground(new java.awt.Color(36, 56, 63));
        restaurante.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        restaurante.setText("Restaurante");

        comRes.setBackground(new java.awt.Color(164, 186, 191));
        comRes.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comRes.setForeground(new java.awt.Color(36, 56, 63));

        descripcionLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        descripcionLabel.setForeground(new java.awt.Color(36, 56, 63));
        descripcionLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        descripcionLabel.setText("Descripción");

        descripcionTF.setBackground(new java.awt.Color(164, 186, 191));
        descripcionTF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        descripcionTF.setForeground(new java.awt.Color(36, 56, 63));
        descripcionTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        descripcionTF.setBorder(null);

        separador1.setBackground(new java.awt.Color(36, 56, 63));
        separador1.setForeground(new java.awt.Color(36, 56, 63));

        comida1TF.setBackground(new java.awt.Color(164, 186, 191));
        comida1TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida1TF.setForeground(new java.awt.Color(36, 56, 63));
        comida1TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida1TF.setBorder(null);

        separador2.setBackground(new java.awt.Color(36, 56, 63));
        separador2.setForeground(new java.awt.Color(36, 56, 63));

        comida2TF.setBackground(new java.awt.Color(164, 186, 191));
        comida2TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida2TF.setForeground(new java.awt.Color(36, 56, 63));
        comida2TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida2TF.setBorder(null);

        separador3.setBackground(new java.awt.Color(36, 56, 63));
        separador3.setForeground(new java.awt.Color(36, 56, 63));

        comida3TF.setBackground(new java.awt.Color(164, 186, 191));
        comida3TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida3TF.setForeground(new java.awt.Color(36, 56, 63));
        comida3TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida3TF.setBorder(null);

        separador4.setBackground(new java.awt.Color(36, 56, 63));
        separador4.setForeground(new java.awt.Color(36, 56, 63));

        comida4TF.setBackground(new java.awt.Color(164, 186, 191));
        comida4TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida4TF.setForeground(new java.awt.Color(36, 56, 63));
        comida4TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida4TF.setBorder(null);

        separador5.setBackground(new java.awt.Color(36, 56, 63));
        separador5.setForeground(new java.awt.Color(36, 56, 63));

        comida5TF.setBackground(new java.awt.Color(164, 186, 191));
        comida5TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida5TF.setForeground(new java.awt.Color(36, 56, 63));
        comida5TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida5TF.setBorder(null);

        separador6.setBackground(new java.awt.Color(36, 56, 63));
        separador6.setForeground(new java.awt.Color(36, 56, 63));

        comida6TF.setBackground(new java.awt.Color(164, 186, 191));
        comida6TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida6TF.setForeground(new java.awt.Color(36, 56, 63));
        comida6TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida6TF.setBorder(null);

        separador7.setBackground(new java.awt.Color(36, 56, 63));
        separador7.setForeground(new java.awt.Color(36, 56, 63));

        comida7TF.setBackground(new java.awt.Color(164, 186, 191));
        comida7TF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comida7TF.setForeground(new java.awt.Color(36, 56, 63));
        comida7TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comida7TF.setBorder(null);

        separador8.setBackground(new java.awt.Color(36, 56, 63));
        separador8.setForeground(new java.awt.Color(36, 56, 63));

        comida1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida1.setForeground(new java.awt.Color(36, 56, 63));
        comida1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida1.setText("Comida #1");

        comida2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida2.setForeground(new java.awt.Color(36, 56, 63));
        comida2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida2.setText("Comida #2");

        comida3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida3.setForeground(new java.awt.Color(36, 56, 63));
        comida3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida3.setText("Comida #3");

        comida4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida4.setForeground(new java.awt.Color(36, 56, 63));
        comida4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida4.setText("Comida #4");

        comida5.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida5.setForeground(new java.awt.Color(36, 56, 63));
        comida5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida5.setText("Comida #5");

        comida6.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida6.setForeground(new java.awt.Color(36, 56, 63));
        comida6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida6.setText("Comida #6");

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

        guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clipboardM.png"))); // NOI18N
        guardar.setToolTipText("Guardar");
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(restaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comRes, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(352, 352, 352)
                .addComponent(editarNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(descripcionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(descripcionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(restaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comRes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descripcionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editarNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarNuevoMouseClicked
        actualizar();
    }//GEN-LAST:event_editarNuevoMouseClicked

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
        guardarDatos();
    }//GEN-LAST:event_guardarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JTextField descripcionTF;
    private javax.swing.JLabel editarNuevo;
    private javax.swing.JLabel guardar;
    private javax.swing.JLabel restaurante;
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
