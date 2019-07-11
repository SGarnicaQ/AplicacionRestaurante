package Frontera;

import Control.ValidarRestaurante;
import DAO.RestauranteDAO;
import Entidad.Restaurante;

public class NuevoRestaurante extends javax.swing.JPanel {

    private final Restaurante restaurante = new Restaurante();
    private final ValidarRestaurante validar = new ValidarRestaurante();
    private final RestauranteDAO daoRes = new RestauranteDAO();

    private final DialogoOK dialogoOk = new DialogoOK(null, true);

    private int filaU;

    public NuevoRestaurante() {
        initComponents();
    }

    public boolean validarCampos() {
        return (nombreTF.getText().isEmpty()
                && ubicacionTF.getText().isEmpty()
                && tipoTF.getText().isEmpty()
                && horarioTF.getText().isEmpty());
    }

    public void vaciarCampos() {
        nombreTF.setText("");
        ubicacionTF.setText("");
        tipoTF.setText("");
        horarioTF.setText("");
    }

    public void guardarDatos() {

        restaurante.setNombre(nombreTF.getText());
        restaurante.setUbicacion(ubicacionTF.getText());
        restaurante.setTipo(tipoTF.getText());
        restaurante.setHorario(horarioTF.getText());
        if (comTur.isVisible()) {
            restaurante.setTurno(Integer.parseInt(comTur.getSelectedItem().toString()));
        }else {
            System.out.println(restaurante.getTurno());
        }

        String respuesta = validar.validarRestaurante(restaurante);

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
            daoRes.crear(restaurante.getNombre(), restaurante.getUbicacion(), restaurante.getTipo(), restaurante.getTurno(), restaurante.getHorario());
            vaciarCampos();
            dialogoOk.textoLabel(respuesta);
            dialogoOk.visible();
        }
    }

    public void editar(Restaurante resta, int fila) {

        nombreTF.setText(resta.getNombre());
        ubicacionTF.setText(resta.getUbicacion());
        tipoTF.setText(resta.getTipo());
        horarioTF.setText(resta.getHorario());

        filaU = fila;
    }

    public void actualizar() {
        if (filaU != 0) {
            restaurante.setNombre(nombreTF.getText());
            restaurante.setUbicacion(ubicacionTF.getText());
            restaurante.setTipo(tipoTF.getText());
            restaurante.setHorario(horarioTF.getText());
            restaurante.setTurno(Integer.parseInt(comTur.getSelectedItem().toString()));

            String respuesta = validar.validarRestaurante(restaurante);

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
                daoRes.editar(restaurante.getNombre(), restaurante.getUbicacion(), restaurante.getTipo(), restaurante.getHorario(), restaurante.getTurno(), filaU);
                vaciarCampos();
                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
                filaU = 0;
            }
        } else {
            dialogoOk.textoLabel("Por favor vuelva atrás");
            dialogoOk.visible();
        }
    }

    public void comTur() {
        comTur.setVisible(false);
        comTur.removeAllItems();
        comTur.addItem("1");
        comTur.addItem("2");
        comTur.setVisible(true);
    }

    public void comTurVis() {
        comTur.setVisible(false);
        turnoLabel.setVisible(false);
        if ("Mediterraneo".equals(nombreTF.getText()) || "Atlántico".equals(nombreTF.getText())) {
            comTur.setVisible(true);
            turnoLabel.setVisible(true);
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

        ubicacionLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        tipoLabel = new javax.swing.JLabel();
        horarioLabel = new javax.swing.JLabel();
        nombreTF = new javax.swing.JTextField();
        primerSeparador = new javax.swing.JSeparator();
        ubicacionTF = new javax.swing.JTextField();
        segundoSeparador = new javax.swing.JSeparator();
        tipoTF = new javax.swing.JTextField();
        tercerSeparador = new javax.swing.JSeparator();
        horarioTF = new javax.swing.JTextField();
        cuartoSeparador = new javax.swing.JSeparator();
        guardar = new javax.swing.JLabel();
        editarNuevo = new javax.swing.JLabel();
        turnoLabel = new javax.swing.JLabel();
        comTur = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(164, 186, 191));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ubicacionLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        ubicacionLabel.setForeground(new java.awt.Color(36, 56, 63));
        ubicacionLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ubicacionLabel.setText("Ubicación");
        add(ubicacionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 200, 30));

        nombreLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        nombreLabel.setForeground(new java.awt.Color(36, 56, 63));
        nombreLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombreLabel.setText("Nombre");
        add(nombreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 200, 30));

        tipoLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        tipoLabel.setForeground(new java.awt.Color(36, 56, 63));
        tipoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tipoLabel.setText("Tipo");
        add(tipoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 200, 30));

        horarioLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        horarioLabel.setForeground(new java.awt.Color(36, 56, 63));
        horarioLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        horarioLabel.setText("Horario");
        add(horarioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 200, 30));

        nombreTF.setBackground(new java.awt.Color(164, 186, 191));
        nombreTF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        nombreTF.setForeground(new java.awt.Color(36, 56, 63));
        nombreTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombreTF.setBorder(null);
        nombreTF.setCaretColor(new java.awt.Color(36, 56, 63));
        nombreTF.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nombreTF.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nombreTFCaretUpdate(evt);
            }
        });
        add(nombreTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 240, 30));

        primerSeparador.setBackground(new java.awt.Color(36, 56, 63));
        add(primerSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 240, 10));

        ubicacionTF.setBackground(new java.awt.Color(164, 186, 191));
        ubicacionTF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        ubicacionTF.setForeground(new java.awt.Color(36, 56, 63));
        ubicacionTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ubicacionTF.setBorder(null);
        add(ubicacionTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 240, 30));

        segundoSeparador.setBackground(new java.awt.Color(36, 56, 63));
        add(segundoSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 240, 10));

        tipoTF.setBackground(new java.awt.Color(164, 186, 191));
        tipoTF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        tipoTF.setForeground(new java.awt.Color(36, 56, 63));
        tipoTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tipoTF.setBorder(null);
        add(tipoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 240, 30));

        tercerSeparador.setBackground(new java.awt.Color(36, 56, 63));
        add(tercerSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 240, 10));

        horarioTF.setBackground(new java.awt.Color(164, 186, 191));
        horarioTF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        horarioTF.setForeground(new java.awt.Color(36, 56, 63));
        horarioTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        horarioTF.setBorder(null);
        add(horarioTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 240, 30));

        cuartoSeparador.setBackground(new java.awt.Color(36, 56, 63));
        add(cuartoSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 240, 10));

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

        turnoLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        turnoLabel.setForeground(new java.awt.Color(36, 56, 63));
        turnoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        turnoLabel.setText("Turno");
        add(turnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 200, 30));

        comTur.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comTur.setForeground(new java.awt.Color(36, 56, 63));
        add(comTur, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 240, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
        guardarDatos();
    }//GEN-LAST:event_guardarMouseClicked

    private void editarNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarNuevoMouseClicked
        actualizar();
    }//GEN-LAST:event_editarNuevoMouseClicked

    private void nombreTFCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nombreTFCaretUpdate
        comTurVis();
    }//GEN-LAST:event_nombreTFCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comTur;
    private javax.swing.JSeparator cuartoSeparador;
    private javax.swing.JLabel editarNuevo;
    private javax.swing.JLabel guardar;
    private javax.swing.JLabel horarioLabel;
    private javax.swing.JTextField horarioTF;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTF;
    private javax.swing.JSeparator primerSeparador;
    private javax.swing.JSeparator segundoSeparador;
    private javax.swing.JSeparator tercerSeparador;
    private javax.swing.JLabel tipoLabel;
    private javax.swing.JTextField tipoTF;
    private javax.swing.JLabel turnoLabel;
    private javax.swing.JLabel ubicacionLabel;
    private javax.swing.JTextField ubicacionTF;
    // End of variables declaration//GEN-END:variables
}
