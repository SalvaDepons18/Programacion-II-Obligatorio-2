//Salvador Depons(303738) y Valentina Velazquez(305278)

package Interfaz;
import Dominio.*;
import javax.swing.*;

// Clase de la ventana Registro de Tematica
public class RegistrodeTematica extends javax.swing.JFrame {
    private Sistema modelo;
  
    // Constructor vacio
    public RegistrodeTematica() {
        initComponents();
    }
    
    // Constructor 
    public RegistrodeTematica(Sistema unSistema) {
        modelo = unSistema;
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

        panelTematica = new javax.swing.JPanel();
        labelNombreTematica = new javax.swing.JLabel();
        labelDescripcionTematica = new javax.swing.JLabel();
        txtNombreTematica = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAdescripcionTematica = new javax.swing.JTextArea();
        lblRegistroTematica = new javax.swing.JLabel();
        btnCancelarTematica = new javax.swing.JButton();
        btnRegistrarTematica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Tematica");
        getContentPane().setLayout(null);

        labelNombreTematica.setText("Nombre: ");

        labelDescripcionTematica.setText("Descripcion:");

        txtNombreTematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreTematicaActionPerformed(evt);
            }
        });

        txtAdescripcionTematica.setColumns(20);
        txtAdescripcionTematica.setRows(5);
        jScrollPane1.setViewportView(txtAdescripcionTematica);

        lblRegistroTematica.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRegistroTematica.setText("Registro de tematica");

        btnCancelarTematica.setText("Cancelar");
        btnCancelarTematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTematicaActionPerformed(evt);
            }
        });

        btnRegistrarTematica.setText("Registrar");
        btnRegistrarTematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarTematicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTematicaLayout = new javax.swing.GroupLayout(panelTematica);
        panelTematica.setLayout(panelTematicaLayout);
        panelTematicaLayout.setHorizontalGroup(
            panelTematicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTematicaLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(panelTematicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNombreTematica)
                    .addComponent(labelDescripcionTematica)
                    .addGroup(panelTematicaLayout.createSequentialGroup()
                        .addComponent(btnCancelarTematica, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTematicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegistrarTematica, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelTematicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombreTematica)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblRegistroTematica, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(36, 36, 36))
        );
        panelTematicaLayout.setVerticalGroup(
            panelTematicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTematicaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblRegistroTematica)
                .addGap(18, 18, 18)
                .addGroup(panelTematicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreTematica)
                    .addComponent(txtNombreTematica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(panelTematicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescripcionTematica)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(panelTematicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarTematica)
                    .addComponent(btnRegistrarTematica))
                .addGap(27, 27, 27))
        );

        getContentPane().add(panelTematica);
        panelTematica.setBounds(50, 30, 530, 350);

        setBounds(0, 0, 628, 435);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreTematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreTematicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreTematicaActionPerformed

    private void btnCancelarTematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTematicaActionPerformed
        // Cierro ventana 
        dispose();
    }//GEN-LAST:event_btnCancelarTematicaActionPerformed

    // Funcionamiento de boton registrar tematica
    private void btnRegistrarTematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarTematicaActionPerformed
        
        // Tomo los datos ingresados 
        String Nombre = txtNombreTematica.getText();
        String Descripcion = txtAdescripcionTematica.getText();
        // Valido que los campos no esten vacios 
        if(Nombre.equals("") || Descripcion.equals("")){
            JOptionPane.showMessageDialog(this, "Debe rellenar los campos vacios.");
        }
        else{
            // Verifico que no exista ya la tematica, la creo y la agrego a la lista
            Tematica t = new Tematica(Nombre, Descripcion);
            if (modelo.verificarTematicaRepetida(t)){
                JOptionPane.showMessageDialog(this, "Ya existe esta tematica.");
            }else{
                // Limpio los campos donde se ingresan los datos
                modelo.agregarTematica(t);
                txtNombreTematica.setText("");
                txtAdescripcionTematica.setText("");
            }
        }
    }//GEN-LAST:event_btnRegistrarTematicaActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrodeTematica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrodeTematica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrodeTematica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrodeTematica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrodeTematica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarTematica;
    private javax.swing.JButton btnRegistrarTematica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDescripcionTematica;
    private javax.swing.JLabel labelNombreTematica;
    private javax.swing.JLabel lblRegistroTematica;
    private javax.swing.JPanel panelTematica;
    private javax.swing.JTextArea txtAdescripcionTematica;
    private javax.swing.JTextField txtNombreTematica;
    // End of variables declaration//GEN-END:variables
}
