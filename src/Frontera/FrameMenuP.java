package Frontera;

public class FrameMenuP extends javax.swing.JPanel {

    private final NuevoMenuP nuevo = new NuevoMenuP();

    private Dialogo dialogo = new Dialogo(null, true);
    private VerMenuP ver = new VerMenuP();
    private final DialogoOK dialogoOk = new DialogoOK(null, true);

    public FrameMenuP() {
        initComponents();
        inicioMenuP();
    }

    public void inicioMenuP() {
        principalMenuP.setVisible(false);
        principalMenuP.removeAll();
        principalMenuP.add(inicioMenuP);
        principalMenuP.setVisible(true);
        back.setVisible(false);
        editar.setVisible(false);
    }

    public void validarInicioMenuP() {
        if (!nuevo.validarCampos()) {
            dialogo.textoLabel("¿Desea guardar los datos?");
            int selCon = dialogo.visible();
            if (selCon == 0) {
                principalMenuP.setVisible(false);
                principalMenuP.removeAll();
                principalMenuP.add(inicioMenuP);
                principalMenuP.setVisible(true);
                back.setVisible(false);
                editar.setVisible(false);
                nuevo.vaciarCampos();
            }
        }
        if (nuevo.validarCampos()) {
            principalMenuP.setVisible(false);
            principalMenuP.removeAll();
            principalMenuP.add(inicioMenuP);
            principalMenuP.setVisible(true);
            back.setVisible(false);
            editar.setVisible(false);
        }
    }

    public void nuevoMenuP() {
        principalMenuP.setVisible(false);
        principalMenuP.removeAll();
        principalMenuP.add(nuevo);
        principalMenuP.setVisible(true);
        nuevo.comboPer();
        nuevo.comboFec();
        nuevo.vaciarCampos();
        back.setVisible(true);
        editar.setVisible(false);
        nuevo.nuevoVisible();
    }

    public void verMenuP() {
        principalMenuP.setVisible(false);
        principalMenuP.removeAll();
        principalMenuP.add(ver);
        principalMenuP.setVisible(true);
        nuevo.comboPer();
        nuevo.vaciarCampos();
        ver.verMenuP();
        back.setVisible(true);
        editar.setVisible(true);
        nuevo.editarVisible();
    }

    public void editarMenuP() {
        int temInt = ver.fila();
        if (temInt >= 1) {
            principalMenuP.setVisible(false);
            principalMenuP.removeAll();
            principalMenuP.add(nuevo);
            principalMenuP.setVisible(true);
            editar.setVisible(false);
            nuevo.editar(ver.editarMenu(), temInt);
            nuevo.comboPer();
        } else {
            dialogoOk.textoLabel("Por favor seleccione una fila");
            dialogoOk.visible();
        }
    }

    public void inicioPrincipal() {
        principalMenuP.setVisible(false);
        principalMenuP.removeAll();
        principalMenuP.add(inicioMenuP);
        principalMenuP.setVisible(true);
        back.setVisible(false);
        editar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloMenuP = new javax.swing.JPanel();
        menup = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        editar = new javax.swing.JLabel();
        principalMenuP = new javax.swing.JPanel();
        inicioMenuP = new javax.swing.JPanel();
        menupVerIcon = new javax.swing.JLabel();
        menupVerLabel = new javax.swing.JLabel();
        menuNuevaLabel = new javax.swing.JLabel();
        menuNuevaIcon = new javax.swing.JLabel();

        tituloMenuP.setBackground(new java.awt.Color(68, 85, 89));
        tituloMenuP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menup.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        menup.setForeground(new java.awt.Color(164, 186, 191));
        menup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menup.setText("MENÚ PERSONA");
        tituloMenuP.add(menup, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 9, 940, 40));

        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/log-out.png"))); // NOI18N
        back.setToolTipText("Atrás");
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        tituloMenuP.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        editar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/note.png"))); // NOI18N
        editar.setToolTipText("Editar");
        editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarMouseClicked(evt);
            }
        });
        tituloMenuP.add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1024, 10, 40, 40));

        principalMenuP.setBackground(new java.awt.Color(19, 38, 35));
        principalMenuP.setLayout(new java.awt.BorderLayout());

        inicioMenuP.setBackground(new java.awt.Color(164, 186, 191));

        menupVerIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menupVerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/phone-bookB.png"))); // NOI18N
        menupVerIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menupVerIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menupVerIconMouseClicked(evt);
            }
        });

        menupVerLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        menupVerLabel.setForeground(new java.awt.Color(36, 56, 63));
        menupVerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menupVerLabel.setText("VER");
        menupVerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menupVerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menupVerLabelMouseClicked(evt);
            }
        });

        menuNuevaLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        menuNuevaLabel.setForeground(new java.awt.Color(36, 56, 63));
        menuNuevaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuNuevaLabel.setText("CREAR");
        menuNuevaLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuNuevaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuNuevaLabelMouseClicked(evt);
            }
        });

        menuNuevaIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuNuevaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/support-ticketB.png"))); // NOI18N
        menuNuevaIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuNuevaIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuNuevaIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout inicioMenuPLayout = new javax.swing.GroupLayout(inicioMenuP);
        inicioMenuP.setLayout(inicioMenuPLayout);
        inicioMenuPLayout.setHorizontalGroup(
            inicioMenuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioMenuPLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(inicioMenuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inicioMenuPLayout.createSequentialGroup()
                        .addComponent(menuNuevaIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(menupVerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inicioMenuPLayout.createSequentialGroup()
                        .addComponent(menuNuevaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(menupVerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        inicioMenuPLayout.setVerticalGroup(
            inicioMenuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioMenuPLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(inicioMenuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuNuevaIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menupVerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(inicioMenuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuNuevaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menupVerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        principalMenuP.add(inicioMenuP, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloMenuP, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(principalMenuP, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tituloMenuP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(principalMenuP, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        validarInicioMenuP();
    }//GEN-LAST:event_backMouseClicked

    private void editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMouseClicked
        editarMenuP();
    }//GEN-LAST:event_editarMouseClicked

    private void menupVerIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menupVerIconMouseClicked
        verMenuP();
    }//GEN-LAST:event_menupVerIconMouseClicked

    private void menupVerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menupVerLabelMouseClicked
        verMenuP();
    }//GEN-LAST:event_menupVerLabelMouseClicked

    private void menuNuevaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuNuevaLabelMouseClicked
        nuevoMenuP();
    }//GEN-LAST:event_menuNuevaLabelMouseClicked

    private void menuNuevaIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuNuevaIconMouseClicked
        nuevoMenuP();
    }//GEN-LAST:event_menuNuevaIconMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel editar;
    private javax.swing.JPanel inicioMenuP;
    private javax.swing.JLabel menuNuevaIcon;
    private javax.swing.JLabel menuNuevaLabel;
    private javax.swing.JLabel menup;
    private javax.swing.JLabel menupVerIcon;
    private javax.swing.JLabel menupVerLabel;
    private javax.swing.JPanel principalMenuP;
    private javax.swing.JPanel tituloMenuP;
    // End of variables declaration//GEN-END:variables
}
