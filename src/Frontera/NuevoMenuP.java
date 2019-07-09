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
    }

    public void vaciarCom() {
        comEnt1.setText("");
        comEnt2.setText("");
        comEnt3.setText("");
        comEnt4.setText("");
        comEnt5.setText("");
        comEnt6.setText("");
        comEnt7.setText("");
        comPla1.setText("");
        comPla2.setText("");
        comPla3.setText("");
        comPla4.setText("");
        comPla5.setText("");
        comPla6.setText("");
        comPla7.setText("");
        comPos1.setText("");
        comPos2.setText("");
        comPos3.setText("");
        comPos4.setText("");
        comPos5.setText("");
        comPos6.setText("");
        comPos7.setText("");
        comCos1.setText("");
        comCos2.setText("");
        comCos4.setText("");
        comCos3.setText("");
        comCos5.setText("");
        comCos7.setText("");
        comCos5.setText("");
    }

    public void guardarDatos() {

        String respuesta;

        if ("Ninguna".equals(comPer.getSelectedItem().toString())) {
            menup.setPersona(0);

            respuesta = validar.validarMenuP(menup);

            dialogoOk.textoLabel(respuesta);
            dialogoOk.visible();
        } else {
            menup.setPersona(Integer.parseInt(Character.toString(comPer.getSelectedItem().toString().charAt(0))));
            menup.setMesa(mesaLabel.getText());
            menup.setTurno(turnoLabel.getText());
            menup.setEntrada("asd");
            menup.setPlatoFue("asd");
            menup.setPostre("asdas");
            menup.setCostoAdi("asd");

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
                        daoMenp.crear(menup.getPersona(), menup.getMesa(), menup.getTurno(), menup.getEntrada(), menup.getPlatoFue(), menup.getPostre(), menup.getCostoAdi());
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
            if (true/*"Ninguna".equals(comMen.getSelectedItem().toString())*/) {
                //menup.setPersona("");

                respuesta = validar.validarMenuP(menup);

                dialogoOk.textoLabel(respuesta);
                dialogoOk.visible();
            } else {
                //menup.setPersona(Character.toString(comPer.getSelectedItem().toString().charAt(0)));
                menup.setMesa(mesaLabel.getText());
                menup.setTurno(turnoLabel.getText());
                //menup.setMenu(Character.toString(comMen.getSelectedItem().toString().charAt(0)));

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
                            //daoMenp.editar(Integer.parseInt(menup.getPersona()), menup.getMesa(), menup.getTurno(), menup.getMenu(), filaU);
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

    public void comboTur() {
        if ("Ninguna".equals(comPer.getSelectedItem().toString())) {
            mesaLabel.setText("");
            turnoLabel.setText("");
            vaciarCom();
        } else {
            String[] datos = daoMenp.turno(Integer.valueOf(Character.toString(comPer.getSelectedItem().toString().charAt(0))));
            mesaLabel.setText(datos[0]);
            turnoLabel.setText(datos[1]);
        }
    }

    public void comboFecEnt(String dia) {
        String[] datos = daoMenp.comidaEnt(comFec.getSelectedItem().toString());
        if (dia.equals(comFec.getSelectedItem().toString())) {
            comEnt1.setText(datos[0]);
            comEnt2.setText(datos[1]);
            comEnt3.setText(datos[2]);
            comEnt4.setText(datos[3]);
            comEnt5.setText(datos[4]);
            comEnt6.setText(datos[5]);
            comEnt7.setText(datos[6]);
        }
    }

    public void comboFecPla(String dia) {
        String[] datos = daoMenp.comidaPla(comFec.getSelectedItem().toString());
        if (dia.equals(comFec.getSelectedItem().toString())) {
            comPla1.setText(datos[0]);
            comPla2.setText(datos[1]);
            comPla3.setText(datos[2]);
            comPla4.setText(datos[3]);
            comPla5.setText(datos[4]);
            comPla6.setText(datos[5]);
            comPla7.setText(datos[6]);
        }
    }

    public void comboFecPos(String dia) {
        String[] datos = daoMenp.comidaPos(comFec.getSelectedItem().toString());
        if (dia.equals(comFec.getSelectedItem().toString())) {
            comPos1.setText(datos[0]);
            comPos2.setText(datos[1]);
            comPos3.setText(datos[2]);
            comPos4.setText(datos[3]);
            comPos5.setText(datos[4]);
            comPos6.setText(datos[5]);
            comPos7.setText(datos[6]);
        }
    }

    public void comboFecCos(String dia) {
        String[] datos = daoMenp.comidaCos(comFec.getSelectedItem().toString());
        if (dia.equals(comFec.getSelectedItem().toString())) {
            comCos1.setText(datos[0]);
            comCos2.setText(datos[1]);
            comCos3.setText(datos[2]);
            comCos4.setText(datos[3]);
            comCos5.setText(datos[4]);
            comCos6.setText(datos[5]);
            comCos7.setText(datos[6]);
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

    public boolean entrada() {
        if (comEnt1.isSelected() || comEnt2.isSelected() || comEnt3.isSelected() || comEnt4.isSelected() || comEnt5.isSelected() || comEnt6.isSelected() || comEnt7.isSelected()) {
            return true;
        } else {
            return true;
        }
    }

    public void entSel(boolean ent) {
        if (ent) {
            System.out.println("adss");
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
        editarNuevo = new javax.swing.JLabel();
        comida2 = new javax.swing.JLabel();
        persona = new javax.swing.JLabel();
        comida1 = new javax.swing.JLabel();
        turnoLabel = new javax.swing.JLabel();
        comPer = new javax.swing.JComboBox<>();
        mesaTF = new javax.swing.JLabel();
        restauranteLabel = new javax.swing.JLabel();
        mesaLabel = new javax.swing.JLabel();
        comida4 = new javax.swing.JLabel();
        comida5 = new javax.swing.JLabel();
        comida6 = new javax.swing.JLabel();
        comida7 = new javax.swing.JLabel();
        comida3 = new javax.swing.JLabel();
        comida8 = new javax.swing.JLabel();
        comida9 = new javax.swing.JLabel();
        comPla1 = new javax.swing.JCheckBox();
        comEnt1 = new javax.swing.JCheckBox();
        comCos1 = new javax.swing.JCheckBox();
        comPos1 = new javax.swing.JCheckBox();
        comCos2 = new javax.swing.JCheckBox();
        comPos2 = new javax.swing.JCheckBox();
        comPla2 = new javax.swing.JCheckBox();
        comEnt2 = new javax.swing.JCheckBox();
        comPla4 = new javax.swing.JCheckBox();
        comEnt3 = new javax.swing.JCheckBox();
        comCos4 = new javax.swing.JCheckBox();
        comPos4 = new javax.swing.JCheckBox();
        comPla3 = new javax.swing.JCheckBox();
        comEnt4 = new javax.swing.JCheckBox();
        comPos3 = new javax.swing.JCheckBox();
        comCos3 = new javax.swing.JCheckBox();
        comPos7 = new javax.swing.JCheckBox();
        comPla7 = new javax.swing.JCheckBox();
        comCos7 = new javax.swing.JCheckBox();
        comEnt6 = new javax.swing.JCheckBox();
        comPos6 = new javax.swing.JCheckBox();
        comPos5 = new javax.swing.JCheckBox();
        comPla5 = new javax.swing.JCheckBox();
        comPla6 = new javax.swing.JCheckBox();
        comEnt7 = new javax.swing.JCheckBox();
        comEnt5 = new javax.swing.JCheckBox();
        comCos5 = new javax.swing.JCheckBox();
        comCos6 = new javax.swing.JCheckBox();
        comFec = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(164, 186, 191));

        guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clipboardM.png"))); // NOI18N
        guardar.setToolTipText("Guardar");
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarMouseClicked(evt);
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

        comida2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida2.setForeground(new java.awt.Color(36, 56, 63));
        comida2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida2.setText("Plato fuerte");

        persona.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        persona.setForeground(new java.awt.Color(36, 56, 63));
        persona.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        persona.setText("Persona");

        comida1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida1.setForeground(new java.awt.Color(36, 56, 63));
        comida1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        comida1.setText("Turno");

        turnoLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        turnoLabel.setForeground(new java.awt.Color(36, 56, 63));
        turnoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        comPer.setBackground(new java.awt.Color(164, 186, 191));
        comPer.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPer.setForeground(new java.awt.Color(36, 56, 63));
        comPer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comPerItemStateChanged(evt);
            }
        });

        mesaTF.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        mesaTF.setForeground(new java.awt.Color(36, 56, 63));
        mesaTF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mesaTF.setText("Mesa");

        restauranteLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        restauranteLabel.setForeground(new java.awt.Color(36, 56, 63));
        restauranteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        mesaLabel.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        mesaLabel.setForeground(new java.awt.Color(36, 56, 63));
        mesaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        comida4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida4.setForeground(new java.awt.Color(36, 56, 63));
        comida4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida4.setText("Entrada");

        comida5.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida5.setForeground(new java.awt.Color(36, 56, 63));
        comida5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida5.setText("Costo adicional");

        comida6.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida6.setForeground(new java.awt.Color(36, 56, 63));
        comida6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida6.setText("Postre");

        comida7.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida7.setForeground(new java.awt.Color(36, 56, 63));
        comida7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida7.setText("Entrada");

        comida3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida3.setForeground(new java.awt.Color(36, 56, 63));
        comida3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida3.setText("Plato fuerte");

        comida8.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida8.setForeground(new java.awt.Color(36, 56, 63));
        comida8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida8.setText("Postre");

        comida9.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        comida9.setForeground(new java.awt.Color(36, 56, 63));
        comida9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida9.setText("Costo adicional");

        comPla1.setBackground(new java.awt.Color(164, 186, 191));
        comPla1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPla1.setForeground(new java.awt.Color(36, 56, 63));
        comPla1.setText("Arroz");

        comEnt1.setBackground(new java.awt.Color(164, 186, 191));
        comEnt1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comEnt1.setForeground(new java.awt.Color(36, 56, 63));

        comCos1.setBackground(new java.awt.Color(164, 186, 191));
        comCos1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCos1.setForeground(new java.awt.Color(36, 56, 63));

        comPos1.setBackground(new java.awt.Color(164, 186, 191));
        comPos1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPos1.setForeground(new java.awt.Color(36, 56, 63));

        comCos2.setBackground(new java.awt.Color(164, 186, 191));
        comCos2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCos2.setForeground(new java.awt.Color(36, 56, 63));

        comPos2.setBackground(new java.awt.Color(164, 186, 191));
        comPos2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPos2.setForeground(new java.awt.Color(36, 56, 63));

        comPla2.setBackground(new java.awt.Color(164, 186, 191));
        comPla2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPla2.setForeground(new java.awt.Color(36, 56, 63));

        comEnt2.setBackground(new java.awt.Color(164, 186, 191));
        comEnt2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comEnt2.setForeground(new java.awt.Color(36, 56, 63));

        comPla4.setBackground(new java.awt.Color(164, 186, 191));
        comPla4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPla4.setForeground(new java.awt.Color(36, 56, 63));

        comEnt3.setBackground(new java.awt.Color(164, 186, 191));
        comEnt3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comEnt3.setForeground(new java.awt.Color(36, 56, 63));

        comCos4.setBackground(new java.awt.Color(164, 186, 191));
        comCos4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCos4.setForeground(new java.awt.Color(36, 56, 63));

        comPos4.setBackground(new java.awt.Color(164, 186, 191));
        comPos4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPos4.setForeground(new java.awt.Color(36, 56, 63));

        comPla3.setBackground(new java.awt.Color(164, 186, 191));
        comPla3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPla3.setForeground(new java.awt.Color(36, 56, 63));

        comEnt4.setBackground(new java.awt.Color(164, 186, 191));
        comEnt4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comEnt4.setForeground(new java.awt.Color(36, 56, 63));

        comPos3.setBackground(new java.awt.Color(164, 186, 191));
        comPos3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPos3.setForeground(new java.awt.Color(36, 56, 63));

        comCos3.setBackground(new java.awt.Color(164, 186, 191));
        comCos3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCos3.setForeground(new java.awt.Color(36, 56, 63));

        comPos7.setBackground(new java.awt.Color(164, 186, 191));
        comPos7.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPos7.setForeground(new java.awt.Color(36, 56, 63));

        comPla7.setBackground(new java.awt.Color(164, 186, 191));
        comPla7.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPla7.setForeground(new java.awt.Color(36, 56, 63));

        comCos7.setBackground(new java.awt.Color(164, 186, 191));
        comCos7.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCos7.setForeground(new java.awt.Color(36, 56, 63));

        comEnt6.setBackground(new java.awt.Color(164, 186, 191));
        comEnt6.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comEnt6.setForeground(new java.awt.Color(36, 56, 63));

        comPos6.setBackground(new java.awt.Color(164, 186, 191));
        comPos6.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPos6.setForeground(new java.awt.Color(36, 56, 63));

        comPos5.setBackground(new java.awt.Color(164, 186, 191));
        comPos5.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPos5.setForeground(new java.awt.Color(36, 56, 63));

        comPla5.setBackground(new java.awt.Color(164, 186, 191));
        comPla5.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPla5.setForeground(new java.awt.Color(36, 56, 63));

        comPla6.setBackground(new java.awt.Color(164, 186, 191));
        comPla6.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comPla6.setForeground(new java.awt.Color(36, 56, 63));

        comEnt7.setBackground(new java.awt.Color(164, 186, 191));
        comEnt7.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comEnt7.setForeground(new java.awt.Color(36, 56, 63));

        comEnt5.setBackground(new java.awt.Color(164, 186, 191));
        comEnt5.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comEnt5.setForeground(new java.awt.Color(36, 56, 63));

        comCos5.setBackground(new java.awt.Color(164, 186, 191));
        comCos5.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCos5.setForeground(new java.awt.Color(36, 56, 63));

        comCos6.setBackground(new java.awt.Color(164, 186, 191));
        comCos6.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comCos6.setForeground(new java.awt.Color(36, 56, 63));

        comFec.setBackground(new java.awt.Color(164, 186, 191));
        comFec.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        comFec.setForeground(new java.awt.Color(36, 56, 63));
        comFec.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comFecItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(restauranteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(persona, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(comPer, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(comFec, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(editarNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(mesaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(mesaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(comida1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(turnoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comida4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comida7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comida2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comida3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comida6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comida8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comida5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comida9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(comEnt1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(comPla1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPos1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comCos1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(comEnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPla2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPos2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comCos2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(comEnt4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPla3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPos3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comCos3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(comEnt3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPla4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPos4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comCos4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(comEnt5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPla5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comPos5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(comCos5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comEnt7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comEnt6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comPla6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comPla7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comPos6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comPos7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comCos6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comCos7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(restauranteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(persona, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(comPer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(comFec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(editarNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mesaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(turnoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comida4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comida9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comEnt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPla1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPos1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCos1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comEnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPla2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPos2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCos2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comEnt4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPla3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPos3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCos3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comEnt3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPla4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPos4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCos4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comEnt5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPla5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comPos5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCos5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comEnt7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(comEnt6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comPla6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(comPla7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comPos6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(comPos7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comCos6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(comCos7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
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

    private void comPerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comPerItemStateChanged
        comboTur();
        if (comPer.getSelectedIndex() != 0) {
            comboFecEnt(comFec.getSelectedItem().toString());
            comboFecPla(comFec.getSelectedItem().toString());
            comboFecPos(comFec.getSelectedItem().toString());
            comboFecCos(comFec.getSelectedItem().toString());
        } else {
            vaciarCom();
        }
    }//GEN-LAST:event_comPerItemStateChanged

    private void comFecItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comFecItemStateChanged
        if (comPer.getSelectedIndex() != 0) {
            comboFecEnt(comFec.getSelectedItem().toString());
            comboFecPla(comFec.getSelectedItem().toString());
            comboFecPos(comFec.getSelectedItem().toString());
            comboFecCos(comFec.getSelectedItem().toString());
        } else {
            vaciarCom();
        }
    }//GEN-LAST:event_comFecItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox comCos1;
    private javax.swing.JCheckBox comCos2;
    private javax.swing.JCheckBox comCos3;
    private javax.swing.JCheckBox comCos4;
    private javax.swing.JCheckBox comCos5;
    private javax.swing.JCheckBox comCos6;
    private javax.swing.JCheckBox comCos7;
    private javax.swing.JCheckBox comEnt1;
    private javax.swing.JCheckBox comEnt2;
    private javax.swing.JCheckBox comEnt3;
    private javax.swing.JCheckBox comEnt4;
    private javax.swing.JCheckBox comEnt5;
    private javax.swing.JCheckBox comEnt6;
    private javax.swing.JCheckBox comEnt7;
    private javax.swing.JComboBox<String> comFec;
    private javax.swing.JComboBox<String> comPer;
    private javax.swing.JCheckBox comPla1;
    private javax.swing.JCheckBox comPla2;
    private javax.swing.JCheckBox comPla3;
    private javax.swing.JCheckBox comPla4;
    private javax.swing.JCheckBox comPla5;
    private javax.swing.JCheckBox comPla6;
    private javax.swing.JCheckBox comPla7;
    private javax.swing.JCheckBox comPos1;
    private javax.swing.JCheckBox comPos2;
    private javax.swing.JCheckBox comPos3;
    private javax.swing.JCheckBox comPos4;
    private javax.swing.JCheckBox comPos5;
    private javax.swing.JCheckBox comPos6;
    private javax.swing.JCheckBox comPos7;
    private javax.swing.JLabel comida1;
    private javax.swing.JLabel comida2;
    private javax.swing.JLabel comida3;
    private javax.swing.JLabel comida4;
    private javax.swing.JLabel comida5;
    private javax.swing.JLabel comida6;
    private javax.swing.JLabel comida7;
    private javax.swing.JLabel comida8;
    private javax.swing.JLabel comida9;
    private javax.swing.JLabel editarNuevo;
    private javax.swing.JLabel guardar;
    private javax.swing.JLabel mesaLabel;
    private javax.swing.JLabel mesaTF;
    private javax.swing.JLabel persona;
    private javax.swing.JLabel restauranteLabel;
    private javax.swing.JLabel turnoLabel;
    // End of variables declaration//GEN-END:variables
}
