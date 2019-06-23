package Frontera;

import Control.ValidarMenu;
import DAO.MenuDAO;
import Entidad.Menu;

public class NuevoMenu extends javax.swing.JPanel {

    private final Menu menu = new Menu();
    private final ValidarMenu validar = new ValidarMenu();
    private final MenuDAO daoMen = new MenuDAO();

    private final DialogoOK dialogoOk = new DialogoOK(null, true);

    public NuevoMenu() {
        initComponents();
    }

    public boolean validarCampos() {
        return ("Ninguno".equals(comRes.getSelectedItem().toString())
                && "Ninguna".equals(comCom1.getSelectedItem().toString())
                && "Ninguna".equals(comCom2.getSelectedItem().toString())
                && "Ninguna".equals(comCom3.getSelectedItem().toString())
                && "Ninguna".equals(comCom4.getSelectedItem().toString())
                && "Ninguna".equals(comCom5.getSelectedItem().toString())
                && "Ninguna".equals(comCom6.getSelectedItem().toString())
                && "Ninguna".equals(comCom7.getSelectedItem().toString()));
    }

    public void vaciarCampos() {
        comRes.setSelectedIndex(0);
        descripcionTF.setText("");
        comCom1.setSelectedIndex(0);
        comCom2.setSelectedIndex(0);
        comCom3.setSelectedIndex(0);
        comCom4.setSelectedIndex(0);
        comCom5.setSelectedIndex(0);
        comCom6.setSelectedIndex(0);
        comCom7.setSelectedIndex(0);
    }

    public boolean validarComidas() {
        return ("Ninguna".equals(comCom1.getSelectedItem().toString())
                && "Ninguna".equals(comCom2.getSelectedItem().toString())
                && "Ninguna".equals(comCom3.getSelectedItem().toString())
                && "Ninguna".equals(comCom4.getSelectedItem().toString())
                && "Ninguna".equals(comCom5.getSelectedItem().toString())
                && "Ninguna".equals(comCom6.getSelectedItem().toString())
                && "Ninguna".equals(comCom7.getSelectedItem().toString()));
    }

    public void guardarDatos() {

        if ("Ninguno".equals(comRes.getSelectedItem().toString())) {
            menu.setRestaurante("");
            
            String respuesta = validar.validarMenu(menu);
            
            dialogoOk.textoLabel(respuesta);
            dialogoOk.visible();
        } else {
            menu.setRestaurante(Character.toString(comRes.getSelectedItem().toString().charAt(0)));
            menu.setDescripcion(descripcionTF.getText());
            
            String respuesta = validar.validarMenu(menu);
            
            if ("Longitud descripcion incorrecta".equals(respuesta)) {
                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else {
                if (!validarComidas()) {
                    if ("Ninguna".equals(comCom1.getSelectedItem().toString())) {
                        menu.setComida1(null);
                    } else {
                        menu.setComida1(Character.toString(comCom1.getSelectedItem().toString().charAt(0)));
                    }
                    if ("Ninguna".equals(comCom2.getSelectedItem().toString())) {
                        menu.setComida2(null);
                    } else {
                        menu.setComida2(Character.toString(comCom2.getSelectedItem().toString().charAt(0)));
                    }
                    if ("Ninguna".equals(comCom3.getSelectedItem().toString())) {
                        menu.setComida3(null);
                    } else {
                        menu.setComida3(Character.toString(comCom3.getSelectedItem().toString().charAt(0)));
                    }
                    if ("Ninguna".equals(comCom4.getSelectedItem().toString())) {
                        menu.setComida4(null);
                    } else {
                        menu.setComida4(Character.toString(comCom4.getSelectedItem().toString().charAt(0)));
                    }
                    if ("Ninguna".equals(comCom5.getSelectedItem().toString())) {
                        menu.setComida5(null);
                    } else {
                        menu.setComida5(Character.toString(comCom5.getSelectedItem().toString().charAt(0)));
                    }
                    if ("Ninguna".equals(comCom6.getSelectedItem().toString())) {
                        menu.setComida6(null);
                    } else {
                        menu.setComida6(Character.toString(comCom6.getSelectedItem().toString().charAt(0)));
                    }
                    if ("Ninguna".equals(comCom7.getSelectedItem().toString())) {
                        menu.setComida7(null);
                    } else {
                        menu.setComida7(Character.toString(comCom7.getSelectedItem().toString().charAt(0)));
                    }
                    if ("Longitud restaurante incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud tipo incorrecta".equals(respuesta)) {
                        dialogoOk.textoLabel(respuesta);
                        dialogoOk.visible();
                    } else if ("Longitud horario incorrecta".equals(respuesta)) {
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

    public void comboCom() {
        comRes.setVisible(false);

        comCom1.setVisible(false);
        comCom2.setVisible(false);
        comCom3.setVisible(false);
        comCom4.setVisible(false);
        comCom5.setVisible(false);
        comCom6.setVisible(false);
        comCom7.setVisible(false);

        comRes.removeAll();

        comCom1.removeAll();
        comCom2.removeAll();
        comCom3.removeAll();
        comCom4.removeAll();
        comCom5.removeAll();
        comCom6.removeAll();
        comCom7.removeAll();

        comRes.setModel(daoMen.comboRes());

        comCom1.setModel(daoMen.comboCom());
        comCom2.setModel(daoMen.comboCom());
        comCom3.setModel(daoMen.comboCom());
        comCom4.setModel(daoMen.comboCom());
        comCom5.setModel(daoMen.comboCom());
        comCom6.setModel(daoMen.comboCom());
        comCom7.setModel(daoMen.comboCom());

        comRes.setVisible(true);

        comCom1.setVisible(true);
        comCom2.setVisible(true);
        comCom3.setVisible(true);
        comCom4.setVisible(true);
        comCom5.setVisible(true);
        comCom6.setVisible(true);
        comCom7.setVisible(true);
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
        comida1 = new javax.swing.JLabel();
        comCom1 = new javax.swing.JComboBox<>();
        comida2 = new javax.swing.JLabel();
        comCom2 = new javax.swing.JComboBox<>();
        comida3 = new javax.swing.JLabel();
        comCom3 = new javax.swing.JComboBox<>();
        comida4 = new javax.swing.JLabel();
        comCom4 = new javax.swing.JComboBox<>();
        comida5 = new javax.swing.JLabel();
        comCom5 = new javax.swing.JComboBox<>();
        comida6 = new javax.swing.JLabel();
        comCom6 = new javax.swing.JComboBox<>();
        comida7 = new javax.swing.JLabel();
        comCom7 = new javax.swing.JComboBox<>();
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

        comida1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida1.setForeground(new java.awt.Color(36, 56, 63));
        comida1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida1.setText("Comida #1");

        comCom1.setBackground(new java.awt.Color(164, 186, 191));
        comCom1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCom1.setForeground(new java.awt.Color(36, 56, 63));

        comida2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida2.setForeground(new java.awt.Color(36, 56, 63));
        comida2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida2.setText("Comida #2");

        comCom2.setBackground(new java.awt.Color(164, 186, 191));
        comCom2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCom2.setForeground(new java.awt.Color(36, 56, 63));

        comida3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida3.setForeground(new java.awt.Color(36, 56, 63));
        comida3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida3.setText("Comida #3");

        comCom3.setBackground(new java.awt.Color(164, 186, 191));
        comCom3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCom3.setForeground(new java.awt.Color(36, 56, 63));

        comida4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida4.setForeground(new java.awt.Color(36, 56, 63));
        comida4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida4.setText("Comida #4");

        comCom4.setBackground(new java.awt.Color(164, 186, 191));
        comCom4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCom4.setForeground(new java.awt.Color(36, 56, 63));

        comida5.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida5.setForeground(new java.awt.Color(36, 56, 63));
        comida5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida5.setText("Comida #5");

        comCom5.setBackground(new java.awt.Color(164, 186, 191));
        comCom5.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCom5.setForeground(new java.awt.Color(36, 56, 63));

        comida6.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida6.setForeground(new java.awt.Color(36, 56, 63));
        comida6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida6.setText("Comida #6");

        comCom6.setBackground(new java.awt.Color(164, 186, 191));
        comCom6.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCom6.setForeground(new java.awt.Color(36, 56, 63));

        comida7.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida7.setForeground(new java.awt.Color(36, 56, 63));
        comida7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida7.setText("Comida #7");

        comCom7.setBackground(new java.awt.Color(164, 186, 191));
        comCom7.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCom7.setForeground(new java.awt.Color(36, 56, 63));

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(comCom1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(comida2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(comCom2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(comida3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(comCom3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(comida4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(comCom4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(comida5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(comCom5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(comida6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(comCom6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(comida7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(comCom7, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(comCom1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCom2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCom3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCom4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCom5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCom6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCom7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editarNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarNuevoMouseClicked

    }//GEN-LAST:event_editarNuevoMouseClicked

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
        guardarDatos();
    }//GEN-LAST:event_guardarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comCom1;
    private javax.swing.JComboBox<String> comCom2;
    private javax.swing.JComboBox<String> comCom3;
    private javax.swing.JComboBox<String> comCom4;
    private javax.swing.JComboBox<String> comCom5;
    private javax.swing.JComboBox<String> comCom6;
    private javax.swing.JComboBox<String> comCom7;
    private javax.swing.JComboBox<String> comRes;
    private javax.swing.JLabel comida1;
    private javax.swing.JLabel comida2;
    private javax.swing.JLabel comida3;
    private javax.swing.JLabel comida4;
    private javax.swing.JLabel comida5;
    private javax.swing.JLabel comida6;
    private javax.swing.JLabel comida7;
    private javax.swing.JLabel descripcionLabel;
    private javax.swing.JTextField descripcionTF;
    private javax.swing.JLabel editarNuevo;
    private javax.swing.JLabel guardar;
    private javax.swing.JLabel restaurante;
    private javax.swing.JSeparator separador1;
    // End of variables declaration//GEN-END:variables
}
