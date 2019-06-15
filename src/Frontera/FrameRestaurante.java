package Frontera;

import Entidad.Restaurante;
import javax.swing.JOptionPane;

public class FrameRestaurante extends javax.swing.JPanel {

    private NuevoRestaurante nuevo = new NuevoRestaurante();
    private VerRestaurante ver = new VerRestaurante();
    private Dialogo dialogo = new Dialogo(null, true);
    private DialogoOK dialogoOk = new DialogoOK(null, true);

    public FrameRestaurante() {
        initComponents();
        inicioRestaurante();
    }

    public void inicioRestaurante() {
        principalRestaurante.setVisible(false);
        principalRestaurante.removeAll();
        principalRestaurante.add(inicioRestaurante);
        principalRestaurante.setVisible(true);
        back.setVisible(false);
        editar.setVisible(false);
    }

    public void validarInicioRestaurante() {
        if (!nuevo.validarCampos()) {
            dialogo.textoLabel("¿Desea guardar los datos?");
            int selCon = dialogo.visible();
            if (selCon == 1) {
                System.out.println("Datos guardados");
            }
            if (selCon == 0) {
                principalRestaurante.setVisible(false);
                principalRestaurante.removeAll();
                principalRestaurante.add(inicioRestaurante);
                principalRestaurante.setVisible(true);
                back.setVisible(false);
                editar.setVisible(false);
                nuevo.vaciarCampos();
            }
        }
        if (nuevo.validarCampos()) {
            principalRestaurante.setVisible(false);
            principalRestaurante.removeAll();
            principalRestaurante.add(inicioRestaurante);
            principalRestaurante.setVisible(true);
            back.setVisible(false);
            editar.setVisible(false);
        }

    }

    public void nuevoRestaurante() {
        principalRestaurante.setVisible(false);
        principalRestaurante.removeAll();
        principalRestaurante.add(nuevo);
        principalRestaurante.setVisible(true);
        back.setVisible(true);
        editar.setVisible(false);
        nuevo.nuevoVisible();
    }

    public void verRestaurante() {
        principalRestaurante.setVisible(false);
        principalRestaurante.removeAll();
        principalRestaurante.add(ver);
        principalRestaurante.setVisible(true);
        ver.verRestaurante("");
        back.setVisible(true);
        editar.setVisible(true);
        nuevo.editarVisible();
    }

    public void editarRestaurante() {
        int temInt = ver.fila();
        if (temInt >= 1) {
            principalRestaurante.setVisible(false);
            principalRestaurante.removeAll();
            principalRestaurante.add(nuevo);
            principalRestaurante.setVisible(true);
            editar.setVisible(false);
            nuevo.editar(ver.editarRestaurante(), temInt);
        } else {
            dialogoOk.textoLabel("Por favor seleccione una fila");
            dialogoOk.visible();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloRestaurante = new javax.swing.JPanel();
        restaurante = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        editar = new javax.swing.JLabel();
        principalRestaurante = new javax.swing.JPanel();
        inicioRestaurante = new javax.swing.JPanel();
        restauranteNuevaIcon = new javax.swing.JLabel();
        restauranteNuevaLabel = new javax.swing.JLabel();
        restauranteVerIcon = new javax.swing.JLabel();
        restauranteVerLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloRestaurante.setBackground(new java.awt.Color(68, 85, 89));
        tituloRestaurante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        restaurante.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        restaurante.setForeground(new java.awt.Color(164, 186, 191));
        restaurante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restaurante.setText("RESTAURANTE");
        tituloRestaurante.add(restaurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 9, 930, 40));

        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/log-out.png"))); // NOI18N
        back.setToolTipText("Atrás");
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        tituloRestaurante.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        editar.setForeground(new java.awt.Color(255, 255, 255));
        editar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/note.png"))); // NOI18N
        editar.setToolTipText("Editar");
        editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarMouseClicked(evt);
            }
        });
        tituloRestaurante.add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1024, 10, 40, 40));

        add(tituloRestaurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 60));

        principalRestaurante.setBackground(new java.awt.Color(19, 38, 35));
        principalRestaurante.setLayout(new java.awt.BorderLayout());

        inicioRestaurante.setBackground(new java.awt.Color(164, 186, 191));

        restauranteNuevaIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restauranteNuevaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/support-ticketB.png"))); // NOI18N
        restauranteNuevaIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        restauranteNuevaIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restauranteNuevaIconMouseClicked(evt);
            }
        });

        restauranteNuevaLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        restauranteNuevaLabel.setForeground(new java.awt.Color(36, 56, 63));
        restauranteNuevaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restauranteNuevaLabel.setText("CREAR");
        restauranteNuevaLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        restauranteNuevaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restauranteNuevaLabelMouseClicked(evt);
            }
        });

        restauranteVerIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restauranteVerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/phone-bookB.png"))); // NOI18N
        restauranteVerIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        restauranteVerIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restauranteVerIconMouseClicked(evt);
            }
        });

        restauranteVerLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        restauranteVerLabel.setForeground(new java.awt.Color(36, 56, 63));
        restauranteVerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restauranteVerLabel.setText("VER");
        restauranteVerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        restauranteVerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restauranteVerLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout inicioRestauranteLayout = new javax.swing.GroupLayout(inicioRestaurante);
        inicioRestaurante.setLayout(inicioRestauranteLayout);
        inicioRestauranteLayout.setHorizontalGroup(
            inicioRestauranteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioRestauranteLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(inicioRestauranteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inicioRestauranteLayout.createSequentialGroup()
                        .addComponent(restauranteNuevaIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(restauranteVerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inicioRestauranteLayout.createSequentialGroup()
                        .addComponent(restauranteNuevaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(restauranteVerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        inicioRestauranteLayout.setVerticalGroup(
            inicioRestauranteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioRestauranteLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(inicioRestauranteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(restauranteNuevaIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restauranteVerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(inicioRestauranteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(restauranteNuevaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restauranteVerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        principalRestaurante.add(inicioRestaurante, java.awt.BorderLayout.CENTER);

        add(principalRestaurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1080, 570));
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        validarInicioRestaurante();
    }//GEN-LAST:event_backMouseClicked

    private void restauranteNuevaIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restauranteNuevaIconMouseClicked
        nuevoRestaurante();
    }//GEN-LAST:event_restauranteNuevaIconMouseClicked

    private void restauranteVerIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restauranteVerIconMouseClicked
        verRestaurante();
    }//GEN-LAST:event_restauranteVerIconMouseClicked

    private void restauranteNuevaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restauranteNuevaLabelMouseClicked
        nuevoRestaurante();
    }//GEN-LAST:event_restauranteNuevaLabelMouseClicked

    private void restauranteVerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restauranteVerLabelMouseClicked
        verRestaurante();
    }//GEN-LAST:event_restauranteVerLabelMouseClicked

    private void editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMouseClicked
        editarRestaurante();
    }//GEN-LAST:event_editarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel editar;
    private javax.swing.JPanel inicioRestaurante;
    private javax.swing.JPanel principalRestaurante;
    private javax.swing.JLabel restaurante;
    private javax.swing.JLabel restauranteNuevaIcon;
    private javax.swing.JLabel restauranteNuevaLabel;
    private javax.swing.JLabel restauranteVerIcon;
    private javax.swing.JLabel restauranteVerLabel;
    private javax.swing.JPanel tituloRestaurante;
    // End of variables declaration//GEN-END:variables
}
