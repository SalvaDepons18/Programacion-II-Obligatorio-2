//Salvador Depons(303738) y Valentina Velazquez(305278)

package Interfaz;
import Dominio.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

// Clase de la ventana Menu Ventanas
public class MenuVentanas extends javax.swing.JFrame {
    private Sistema modelo;
   
    // Constructor vacio
    public MenuVentanas() {
        initComponents();
    }
    
    // Constructor 
    public MenuVentanas(Sistema unSistema){
        modelo = unSistema;
        initComponents();
    }
    
    // Metodo para guardar los datos del sistema actual en el archivo "Sistema.ser"
    public static void guardar(Sistema elSistema){
        try{
            // Crea el archivo "Sistema.ser" y guarda el sistema actual en el
            ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get("Sistema.ser")));
            out.writeObject(elSistema);
            out.close();
        // Captura Exeption
        }catch(IOException e){
            System.out.println("Error al guardar");
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

        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        TematicasMen = new javax.swing.JMenu();
        registroDeTematica = new javax.swing.JMenuItem();
        consultaPorTematica = new javax.swing.JMenuItem();
        EntrevistasMen = new javax.swing.JMenu();
        ingresoDeEntrevista = new javax.swing.JMenuItem();
        PostulantesMen = new javax.swing.JMenu();
        altaDePostulante = new javax.swing.JMenuItem();
        bajaDePostulante = new javax.swing.JMenuItem();
        historiaDePostulante = new javax.swing.JMenuItem();
        PuestosMen = new javax.swing.JMenu();
        registroDePuesto = new javax.swing.JMenuItem();
        consultaParaPuesto = new javax.swing.JMenuItem();
        EvaluadoresMen = new javax.swing.JMenu();
        registroDeEvaluador = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Ventanas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("B I E N V E N I D O");

        TematicasMen.setMnemonic('f');
        TematicasMen.setText("Temáticas");

        registroDeTematica.setText("Registro de Temática");
        registroDeTematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroDeTematicaActionPerformed(evt);
            }
        });
        TematicasMen.add(registroDeTematica);

        consultaPorTematica.setText("Consulta por Temática");
        consultaPorTematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaPorTematicaActionPerformed(evt);
            }
        });
        TematicasMen.add(consultaPorTematica);

        menuBar.add(TematicasMen);

        EntrevistasMen.setText("Entrevistas");

        ingresoDeEntrevista.setText("Ingreso de entrevista");
        ingresoDeEntrevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoDeEntrevistaActionPerformed(evt);
            }
        });
        EntrevistasMen.add(ingresoDeEntrevista);

        menuBar.add(EntrevistasMen);

        PostulantesMen.setText("Postulantes");

        altaDePostulante.setText("Alta de postulante");
        altaDePostulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaDePostulanteActionPerformed(evt);
            }
        });
        PostulantesMen.add(altaDePostulante);

        bajaDePostulante.setText("Baja de postulante");
        bajaDePostulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaDePostulanteActionPerformed(evt);
            }
        });
        PostulantesMen.add(bajaDePostulante);

        historiaDePostulante.setText("Historia de postulante");
        historiaDePostulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historiaDePostulanteActionPerformed(evt);
            }
        });
        PostulantesMen.add(historiaDePostulante);

        menuBar.add(PostulantesMen);

        PuestosMen.setText("Puestos");

        registroDePuesto.setText("Registro de puesto");
        registroDePuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroDePuestoActionPerformed(evt);
            }
        });
        PuestosMen.add(registroDePuesto);

        consultaParaPuesto.setText("Consulta para puesto");
        consultaParaPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaParaPuestoActionPerformed(evt);
            }
        });
        PuestosMen.add(consultaParaPuesto);

        menuBar.add(PuestosMen);

        EvaluadoresMen.setText("Evaluadores");

        registroDeEvaluador.setText("Registro de evaluador");
        registroDeEvaluador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroDeEvaluadorActionPerformed(evt);
            }
        });
        EvaluadoresMen.add(registroDeEvaluador);

        menuBar.add(EvaluadoresMen);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Funcionamiento del boton Consulta Por Tematica
    private void consultaPorTematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaPorTematicaActionPerformed
        // Valido que existan tematicas para consultar
        if(modelo.getListaTematicas().size() == 0){
            JOptionPane.showMessageDialog(this, "No es posible consultar si no existen tematicas.");
        }else{
            // Creo la ventanta y la muestro
            ConsultaPorTematica v = new ConsultaPorTematica(modelo);
            v.setVisible(true);
        }
    }//GEN-LAST:event_consultaPorTematicaActionPerformed

     // Funcionamiento del boton ingreso De Entrevista
    private void ingresoDeEntrevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoDeEntrevistaActionPerformed
        // Valido que existan evaluadores y postulantes 
        if(modelo.getListaEvaluadores().size() == 0 || modelo.getListaPostulantes().size() == 0){
            JOptionPane.showMessageDialog(this, "No es posible ingresar entrevista sin postulantes y evaluadores.");
        }else{
        // Creo la ventana y la muestro
        IngresoEntrevista v = new IngresoEntrevista(modelo);
        v.setVisible(true);
        }
    }//GEN-LAST:event_ingresoDeEntrevistaActionPerformed
    
    // Funcionamiento del boton Alta De Postulante
    private void altaDePostulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaDePostulanteActionPerformed
        // Valido que existan tematicas 
        if(modelo.getListaTematicas().size()==0){
            JOptionPane.showMessageDialog(this, "No es posible registrar postulantes si no existen tematicas.");
        }else{
            // Creo la ventana y la muestro
            AltaPostulante v = new AltaPostulante(modelo);
            v.setVisible(true);
        }
    }//GEN-LAST:event_altaDePostulanteActionPerformed

    // Funcionamiento del boton Baja De Postulante
    private void bajaDePostulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaDePostulanteActionPerformed
        // Valido que existan postulantes para dar de baja
        if(modelo.getListaPostulantes().size()==0){
            JOptionPane.showMessageDialog(this, "No es posible dar de baja si no existen postulantes.");
        }else{
            // Creo la ventana y la muestro
            BajaPostulante v = new BajaPostulante(modelo);
            v.setVisible(true);
        }
    }//GEN-LAST:event_bajaDePostulanteActionPerformed

    // Funcionamiento del boton Historia De Postulante
    private void historiaDePostulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historiaDePostulanteActionPerformed
        // Valido que existan postulantes para ver su historial
        if(modelo.getListaPostulantes().size() == 0){
            JOptionPane.showMessageDialog(this, "No existen postuantes.");
        }else{
            // Creo la venta y la muestro
            HistorialPostulante v = new HistorialPostulante(modelo);
            v.setVisible(true);
        }
    }//GEN-LAST:event_historiaDePostulanteActionPerformed

    // Funcionamiento del boton Registro De Puesto
    private void registroDePuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroDePuestoActionPerformed
        // Valido que existan tematicas 
        if(modelo.getListaTematicas().size()==0){
            JOptionPane.showMessageDialog(this, "No es posible registrar puestos si no existen tematicas.");
        }else{
            // Creo la venta y la muestro
            RegistroPuesto v = new RegistroPuesto(modelo);
            v.setVisible(true);
        }
    }//GEN-LAST:event_registroDePuestoActionPerformed

    // Funcionamiento del boton Consulta Para Puesto
    private void consultaParaPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaParaPuestoActionPerformed
        // Valido que existan puestos para consultar
        if(modelo.getListaPuestos().size() == 0){
            JOptionPane.showMessageDialog(this, "No es posible consultar puestos si no existen.");
        }else {
            // Creo la venta y la muestro
            ConsultaParaPuesto v = new ConsultaParaPuesto(modelo);
            v.setVisible(true);
        }
    }//GEN-LAST:event_consultaParaPuestoActionPerformed

    // Funcionamiento del boton Registro De Tematica
    private void registroDeTematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroDeTematicaActionPerformed
        // Creo la venta y la muestro
        RegistrodeTematica v = new RegistrodeTematica(modelo);
        v.setVisible(true);
    }//GEN-LAST:event_registroDeTematicaActionPerformed

    // Funcionamiento del boton Registro De Evaluador
    private void registroDeEvaluadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroDeEvaluadorActionPerformed
        // Creo la venta y la muestro
        RegistroEvaluador v = new RegistroEvaluador(modelo);
        v.setVisible(true);
    }//GEN-LAST:event_registroDeEvaluadorActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed
   
    // Funcionamiento de la ventana en el momento previo a ser cerrada
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Guardo el sistema 
        guardar(modelo);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(MenuVentanas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuVentanas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuVentanas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuVentanas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuVentanas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu EntrevistasMen;
    private javax.swing.JMenu EvaluadoresMen;
    private javax.swing.JMenu PostulantesMen;
    private javax.swing.JMenu PuestosMen;
    private javax.swing.JMenu TematicasMen;
    private javax.swing.JMenuItem altaDePostulante;
    private javax.swing.JMenuItem bajaDePostulante;
    private javax.swing.JMenuItem consultaParaPuesto;
    private javax.swing.JMenuItem consultaPorTematica;
    private javax.swing.JMenuItem historiaDePostulante;
    private javax.swing.JMenuItem ingresoDeEntrevista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem registroDeEvaluador;
    private javax.swing.JMenuItem registroDePuesto;
    private javax.swing.JMenuItem registroDeTematica;
    // End of variables declaration//GEN-END:variables

}