package Frontera;

import Entidad.Asignacion;
import Entidad.Restaurante;
import Entidad.Sistema;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Conexion.Conexion;
import java.sql.Connection;

public class FramePrincipal extends javax.swing.JFrame {

    Conexion con = new Conexion();
    Connection Conectado = con.conectar("root", "17111996");

    private FrameRestaurante restaurante = new FrameRestaurante();
    private FrameAsignacion asignacion = new FrameAsignacion();
    private Dialogo dialogo = new Dialogo(null, true);

    public static Sistema sistema = new Sistema();

    public FramePrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        inicioGUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorPanel = new javax.swing.JPanel();
        tituloPanel = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        servicioDeRestaurante = new javax.swing.JLabel();
        principalPanel = new javax.swing.JPanel();
        inicioPrincipal = new javax.swing.JPanel();
        asignacionIcon = new javax.swing.JLabel();
        asignacionLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        restauranteLabel = new javax.swing.JLabel();
        restauranteLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        restauranteLabel2 = new javax.swing.JLabel();
        restauranteLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        asignacionLabel1 = new javax.swing.JLabel();
        opcionesPanel = new javax.swing.JPanel();
        inicioIcon = new javax.swing.JLabel();
        inicioLabel = new javax.swing.JLabel();

        setTitle("Restaurante");
        setUndecorated(true);
        setResizable(false);

        contenedorPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloPanel.setBackground(new java.awt.Color(36, 56, 63));
        tituloPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cancel.png"))); // NOI18N
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        tituloPanel.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 11, 70, 70));

        servicioDeRestaurante.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 36)); // NOI18N
        servicioDeRestaurante.setForeground(new java.awt.Color(192, 212, 216));
        servicioDeRestaurante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        servicioDeRestaurante.setText("SERVICIO DE RESTAURANTE");
        tituloPanel.add(servicioDeRestaurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 11, 1100, 70));

        contenedorPanel.add(tituloPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 90));

        principalPanel.setBackground(new java.awt.Color(63, 63, 63));
        principalPanel.setLayout(new java.awt.BorderLayout());

        inicioPrincipal.setBackground(new java.awt.Color(164, 186, 191));
        inicioPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        asignacionIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        asignacionIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/profile.png"))); // NOI18N
        asignacionIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        asignacionIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                asignacionIconMouseClicked(evt);
            }
        });
        inicioPrincipal.add(asignacionIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 150, 130));

        asignacionLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        asignacionLabel.setForeground(new java.awt.Color(36, 56, 63));
        asignacionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        asignacionLabel.setText("ASIGNACIÓN");
        asignacionLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        asignacionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                asignacionLabelMouseClicked(evt);
            }
        });
        inicioPrincipal.add(asignacionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 170, 30));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inicioPrincipal.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 150, 130));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/restaurantB1.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        inicioPrincipal.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 150, 130));

        restauranteLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        restauranteLabel.setForeground(new java.awt.Color(36, 56, 63));
        restauranteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restauranteLabel.setText("MENÚS");
        inicioPrincipal.add(restauranteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 220, 170, 30));

        restauranteLabel1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        restauranteLabel1.setForeground(new java.awt.Color(36, 56, 63));
        restauranteLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restauranteLabel1.setText("RESTAURANTE");
        restauranteLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        restauranteLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restauranteLabel1MouseClicked(evt);
            }
        });
        inicioPrincipal.add(restauranteLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 170, 30));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inicioPrincipal.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 330, 150, 130));

        restauranteLabel2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        restauranteLabel2.setForeground(new java.awt.Color(36, 56, 63));
        restauranteLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restauranteLabel2.setText("SOBRE COSTOS");
        inicioPrincipal.add(restauranteLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 460, 170, 30));

        restauranteLabel3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        restauranteLabel3.setForeground(new java.awt.Color(36, 56, 63));
        restauranteLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restauranteLabel3.setText("PEDIDOS");
        inicioPrincipal.add(restauranteLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 170, 30));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inicioPrincipal.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 150, 130));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inicioPrincipal.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 150, 130));

        asignacionLabel1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        asignacionLabel1.setForeground(new java.awt.Color(36, 56, 63));
        asignacionLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        asignacionLabel1.setText("NOCHE DE GALA");
        inicioPrincipal.add(asignacionLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 170, 30));

        principalPanel.add(inicioPrincipal, java.awt.BorderLayout.CENTER);

        contenedorPanel.add(principalPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 1080, 630));

        opcionesPanel.setBackground(new java.awt.Color(68, 85, 89));
        opcionesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inicioIcon.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 22)); // NOI18N
        inicioIcon.setForeground(new java.awt.Color(19, 38, 35));
        inicioIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inicioIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/filter.png"))); // NOI18N
        inicioIcon.setToolTipText("Inicio");
        inicioIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inicioIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inicioIconMouseClicked(evt);
            }
        });
        opcionesPanel.add(inicioIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 70, 70));

        inicioLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        inicioLabel.setForeground(new java.awt.Color(36, 56, 63));
        inicioLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inicioLabel.setText("INICIO");
        inicioLabel.setToolTipText("Inicio");
        inicioLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inicioLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inicioLabelMouseClicked(evt);
            }
        });
        opcionesPanel.add(inicioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 70, 30));

        contenedorPanel.add(opcionesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void inicioIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioIconMouseClicked
        validarInicioGUI();
    }//GEN-LAST:event_inicioIconMouseClicked

    private void asignacionIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignacionIconMouseClicked
        principalPanel.setVisible(false);
        principalPanel.removeAll();
        principalPanel.add(asignacion);
        principalPanel.setVisible(true);
        inicioIcon.setVisible(true);
        inicioLabel.setVisible(true);
    }//GEN-LAST:event_asignacionIconMouseClicked

    private void asignacionLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignacionLabelMouseClicked
        principalPanel.setVisible(false);
        principalPanel.removeAll();
        principalPanel.add(asignacion);
        principalPanel.setVisible(true);
        inicioIcon.setVisible(true);
        inicioLabel.setVisible(true);
    }//GEN-LAST:event_asignacionLabelMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        principalPanel.setVisible(false);
        principalPanel.removeAll();
        principalPanel.add(restaurante);
        principalPanel.setVisible(true);
        inicioIcon.setVisible(true);
        inicioLabel.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void restauranteLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restauranteLabel1MouseClicked
        principalPanel.setVisible(false);
        principalPanel.removeAll();
        principalPanel.add(restaurante);
        principalPanel.setVisible(true);
        inicioIcon.setVisible(true);
        inicioLabel.setVisible(true);
    }//GEN-LAST:event_restauranteLabel1MouseClicked

    private void inicioLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioLabelMouseClicked
        validarInicioGUI();
    }//GEN-LAST:event_inicioLabelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    public void inicioGUI() {
        principalPanel.setVisible(false);
        principalPanel.removeAll();
        principalPanel.add(inicioPrincipal);
        principalPanel.setVisible(true);
        inicioIcon.setVisible(false);
        inicioLabel.setVisible(false);
    }

    public void validarInicioGUI() {
        dialogo.textoLabel("¿Desea volver al inicio?");
        int selCon = dialogo.visible();
        if (selCon == 1) {
            principalPanel.setVisible(false);
            principalPanel.removeAll();
            principalPanel.add(inicioPrincipal);
            principalPanel.setVisible(true);
            inicioIcon.setVisible(false);
            inicioLabel.setVisible(false);
        }
    }

/*    public void inicializacion() {

        ArrayList<Asignacion> asignaciones = new ArrayList<>();

        Asignacion a = new Asignacion();

        a.setRestaurante("Delicias del Mar");
        a.setPersona("Juana");
        a.setMesa("21");
        a.setTurno("2");

        asignaciones.add(a);

        sistema.setAsignaciones(asignaciones);

        for (Asignacion asignacione : asignaciones) {
            System.out.println(asignacione.getRestaurante());
            System.out.println(asignacione.getPersona());
            System.out.println(asignacione.getMesa());
            System.out.println(asignacione.getTurno());
            System.out.println("---------");
        }
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asignacionIcon;
    private javax.swing.JLabel asignacionLabel;
    private javax.swing.JLabel asignacionLabel1;
    private javax.swing.JLabel close;
    private javax.swing.JPanel contenedorPanel;
    private javax.swing.JLabel inicioIcon;
    private javax.swing.JLabel inicioLabel;
    private javax.swing.JPanel inicioPrincipal;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel opcionesPanel;
    private javax.swing.JPanel principalPanel;
    private javax.swing.JLabel restauranteLabel;
    private javax.swing.JLabel restauranteLabel1;
    private javax.swing.JLabel restauranteLabel2;
    private javax.swing.JLabel restauranteLabel3;
    private javax.swing.JLabel servicioDeRestaurante;
    private javax.swing.JPanel tituloPanel;
    // End of variables declaration//GEN-END:variables
}
