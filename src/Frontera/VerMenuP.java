package Frontera;

import DAO.MenuPDAO;
import Entidad.MenuP;

public class VerMenuP extends javax.swing.JPanel {

    private final MenuPDAO daoMenp = new MenuPDAO();
    
    public VerMenuP() {
        initComponents();
    }

    public void verMenuP() {
        tableMenp.setModel(daoMenp.ver());
    }

    public MenuP editarMenu() {
        MenuP menu = new MenuP();

        int rowSel = tableMenp.getSelectedRow();
        if (rowSel >= 0) {
            menu.setPersona(tableMenp.getValueAt(rowSel, 1).toString());
            menu.setMesa(tableMenp.getValueAt(rowSel, 2).toString());
            menu.setComida1(tableMenp.getValueAt(rowSel, 3).toString());
            menu.setComida2(tableMenp.getValueAt(rowSel, 4).toString());
            menu.setComida3(tableMenp.getValueAt(rowSel, 5).toString());
            menu.setComida4(tableMenp.getValueAt(rowSel, 6).toString());
            menu.setComida5(tableMenp.getValueAt(rowSel, 7).toString());
            menu.setComida6(tableMenp.getValueAt(rowSel, 8).toString());
            menu.setComida7(tableMenp.getValueAt(rowSel, 9).toString());
        }
        return menu;
    }

    public int fila() {
        int rowSel = tableMenp.getSelectedRow();
        if (rowSel >= 0) {
            return Integer.parseInt(tableMenp.getValueAt(rowSel, 0).toString());
        }
        return 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableMenp = new javax.swing.JTable();

        setBackground(new java.awt.Color(164, 186, 191));

        tableMenp.setBackground(new java.awt.Color(36, 56, 63));
        tableMenp.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        tableMenp.setForeground(new java.awt.Color(192, 212, 216));
        tableMenp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableMenp.setGridColor(new java.awt.Color(36, 56, 63));
        tableMenp.setSelectionBackground(new java.awt.Color(164, 186, 191));
        tableMenp.setSelectionForeground(new java.awt.Color(36, 56, 63));
        jScrollPane1.setViewportView(tableMenp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMenp;
    // End of variables declaration//GEN-END:variables
}
