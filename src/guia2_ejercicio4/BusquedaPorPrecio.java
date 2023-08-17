package guia2_ejercicio4;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BusquedaPorPrecio extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel();

    public BusquedaPorPrecio() {
        initComponents();
        armarCabezera();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtPreciob = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtP = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jtF = new javax.swing.JTextField();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Busqueda Por Precio");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Entre $");

        jtPreciob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPreciobActionPerformed(evt);
            }
        });

        jtP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtP);

        jLabel3.setText("y");

        jtF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtFKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29)
                                .addComponent(jtPreciob, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtF, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabel1)))
                        .addGap(0, 185, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtPreciob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtPreciobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPreciobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPreciobActionPerformed

    private void jtFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtFKeyTyped
//         TODO add your handling code here:
    }//GEN-LAST:event_jtFKeyTyped

    private void jtFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtFKeyReleased
        borrarFila();
        try {
            double precioB = Double.parseDouble(this.jtPreciob.getText());
            double precioF = Double.parseDouble(this.jtF.getText());

            for (Productos producto : Menu.listP) {
                if (producto.getPrecio() >= precioB && producto.getPrecio() <= precioF) {
                    int cod = producto.getCodigo();
                    String desc = producto.getDescripcion();
                    double pre = producto.getPrecio();
                    int stock = producto.getStock();
                    Categoria cat = producto.getRubro();
                    modelo.addRow(new Object[]{cod, desc, pre, stock, cat});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, " >>> Ingrese el precio de la segunda casilla <<<");
        }
    }//GEN-LAST:event_jtFKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtF;
    private javax.swing.JTable jtP;
    private javax.swing.JTextField jtPreciob;
    // End of variables declaration//GEN-END:variables

    private void armarCabezera() {
        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Categoria");
        this.jtP.setModel(modelo);
    }

    private void borrarFila() {
        int f = this.jtP.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }
}
