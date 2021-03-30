/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Elias
 */
public class VistaProfesores extends javax.swing.JFrame {

    /**
     * Creates new form VistaProfesores
     */
    public VistaProfesores() {
        initComponents();
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
        tb_profesores = new javax.swing.JTable();
        sp_id = new javax.swing.JSpinner();
        btn_cambiar = new javax.swing.JButton();
        cmb_alta = new javax.swing.JComboBox<>();
        cmb_materias = new javax.swing.JComboBox<>();
        btn_inscribir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_menu = new javax.swing.JMenuItem();
        menu_materias = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menu_cerrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_profesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Apellido", "DNI", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_profesores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 610, 350));
        getContentPane().add(sp_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, -1, -1));

        btn_cambiar.setText("Cambiar");
        getContentPane().add(btn_cambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 100, -1));

        cmb_alta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alta", "Baja" }));
        cmb_alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_altaActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_alta, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, -1, -1));

        cmb_materias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Álgebra y Geometría Analítica", "Algoritmos y Estructuras de Datos", "Análisis Matemático I", "Arquitectura de Computadoras", "Ingeniería y Sociedad", "Matemática Discreta", "Química", "Sistemas y Organizaciones", " " }));
        cmb_materias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_materiasActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_materias, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, -1, -1));

        btn_inscribir.setText("Inscribir");
        getContentPane().add(btn_inscribir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 110, -1));

        jMenu1.setText("Volver");

        menu_menu.setText("Voler al Menú");
        menu_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_menuActionPerformed(evt);
            }
        });
        jMenu1.add(menu_menu);

        menu_materias.setText("Ir a Materias");
        jMenu1.add(menu_materias);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sesión");

        menu_cerrar.setText("Cerrar Sesión");
        jMenu2.add(menu_cerrar);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_altaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_altaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_altaActionPerformed

    private void cmb_materiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_materiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_materiasActionPerformed

    private void menu_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_menuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_menuActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaProfesores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_cambiar;
    public javax.swing.JButton btn_inscribir;
    public javax.swing.JComboBox<String> cmb_alta;
    public javax.swing.JComboBox<String> cmb_materias;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JMenuItem menu_cerrar;
    public javax.swing.JMenuItem menu_materias;
    public javax.swing.JMenuItem menu_menu;
    public javax.swing.JSpinner sp_id;
    public javax.swing.JTable tb_profesores;
    // End of variables declaration//GEN-END:variables
}
