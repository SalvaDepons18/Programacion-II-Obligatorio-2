//Salvador Depons(303738) y Valentina Velazquez(305278)
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;
import Dominio.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.table.DefaultTableModel;

// Clase de la ventana Historial Postulante
public class HistorialPostulante extends javax.swing.JFrame implements Observer {
    Sistema modelo;
    
    // Constructor vacio
    public HistorialPostulante() {
        initComponents();
    }
   
    // Constructor 
    public HistorialPostulante(Sistema elSistema){
        modelo = elSistema;
        initComponents();
        cargarLista();
        modelo.addObserver(this);
    }
    
    // Metodo que mantiene actualizado la lista de postulanes, la lista de experiencias del postulante y la tabla
    @Override
    public void update(Observable o, Object arg){
        Postulante p = listPostulantesHistorialPostulante.getSelectedValue();
        cargarLista();
        
        if(modelo.getListaPostulantes().contains(p)){
            listPostulantesHistorialPostulante.setSelectedValue(p, true); 
            String pal = txtPerfilABuscar.getText();
            ArrayList<Entrevista> entrevistas = modelo.entrevistasDePostulante(p);
            cargarTabla(entrevistas,pal);
            cargarDatosPostulante();
            buscarPalabra();
        }
    }
    
    // Metodo encargado de cargar la lista de los postulantes
    public void cargarLista(){
        ArrayList<Postulante> losPostulantes = modelo.postulantesOrdenadosPorCI();
         
        Postulante[] losPostulantesArray = new Postulante[losPostulantes.size()];
        for(int i=0 ; i<losPostulantes.size(); i++){
            losPostulantesArray[i] = losPostulantes.get(i);
        }
        
        listPostulantesHistorialPostulante.setListData(losPostulantesArray);    
    }
    
    // Metodo que carga la lista de tematicas de un postulante
    public void cargarListaTems(Postulante elPostulante){
        ArrayList<String> experiencias = elPostulante.darExperiencias();
        
        String[] experienciasArray = new String[experiencias.size()];
        for (int i = 0; i < experiencias.size(); i++) {
            String experiencia = experiencias.get(i);
            Tematica nombreTema = modelo.temaPorNombre(experiencia);
            String nivelExperiencia = elPostulante.darNivelExperienciaEnTematica(nombreTema);
            experienciasArray[i] = experiencia + "(" + nivelExperiencia + ")";
        }

        listTematicasPostulanteHistorial.setListData(experienciasArray);    
    }
    
    // Metodo que carga la tabla con las entrevistas ingresadas y resalta un texto 
    public void cargarTabla(ArrayList<Entrevista> entrevistas,String pal){
        
        // Por cada entrevista de la lista ingresada creo una fila e ingreso los datos de la entrevista
        DefaultTableModel modeloTabla = (DefaultTableModel) TableHistorialPostulante.getModel();
        modeloTabla.setRowCount(0);
        for (Entrevista e: entrevistas){
            Object[] rowData = new Object[4];
            rowData[0] = e.getNumeroEntrevista();
            rowData[1] = e.getEvaluador().getNombre()+" ("+e.getEvaluador().getCI()+")";
            rowData[2] = e.getPuntaje();
            rowData[3] = resaltarPalabra(e.getComentario(),pal);  

            modeloTabla.addRow(rowData); 
        }    
    }
    
    // Metodo que recibe un comentario y un texto y devuelve el comentario con el texto en rojo 
    public static String resaltarPalabra(String texto, String palabra) {
        texto = texto.replaceAll("(?i)" + palabra, "<font color='red'>$0</font>");
        return ("<html>" + texto + "</html>");
    }
    
    // Metodo encargado de mostrar los datos del postulante seleccionado
    public void cargarDatosPostulante(){
        // Valido que este seleccionada la lista 
        if(listPostulantesHistorialPostulante.getSelectedValue() == (null)){
            // Si no hay nada seleccionado pongo los datos vacios 
            lblInsertarNombreHistorialPostulante.setText("");
            lblInsertarCIHistorialPostulante.setText("");
            lblInstertarDirecHistorialPostulante.setText("");
            lblInsertarTelHistorialPostulante.setText("");
            lblInsertarMailHistorialPostulante.setText("");
            lblInertarLinkedinHistorialPostulante.setText("");
            lblInsertarFormatoHistorialPostulante.setText("");
            cargarListaTems(new Postulante());   
            cargarTabla(new ArrayList<>(),"");
        }else{
            // Si hay un postulante seleccioado tomo sus datos y los muestro en la ventana
            Postulante p = listPostulantesHistorialPostulante.getSelectedValue();
            String ci = p.getCI();
            String direc = p.getDireccion();
            String tel = p.getTelefono();
            String mail = p.getMail();
            String link = p.getLinkedin();
            String form = p.getFormato();
            lblInsertarNombreHistorialPostulante.setText(p.getNombre());
            lblInsertarCIHistorialPostulante.setText(ci);
            lblInstertarDirecHistorialPostulante.setText(direc);
            lblInsertarTelHistorialPostulante.setText(tel);
            lblInsertarMailHistorialPostulante.setText(mail);
            lblInertarLinkedinHistorialPostulante.setText(link);
            lblInsertarFormatoHistorialPostulante.setText(form);
            cargarListaTems(p);  
            ArrayList<Entrevista> entrevistas = modelo.entrevistasDePostulante(p);
            cargarTabla(entrevistas,"");
        }
    }
   
    // Funcion encargada resaltar en los comentarios la palabra ingresada
    public void buscarPalabra(){
        // Valido que haya datos ingresados
        if (!(txtPerfilABuscar.getText() == (null))){
            // Tomo la palabra o el texto y cargo la tabla con esa palabra 
            String pal = txtPerfilABuscar.getText();
            Postulante p = listPostulantesHistorialPostulante.getSelectedValue();
            ArrayList<Entrevista> entrevistas = modelo.entrevistasDePostulanteConPal(p, pal);
            cargarTabla(entrevistas,pal);
        }
    }
    
    // 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblHistorialPostulante = new javax.swing.JLabel();
        lblPostulantesHistorialPostulante = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPostulantesHistorialPostulante = new javax.swing.JList<>();
        lblNombreHistorialPostulante = new javax.swing.JLabel();
        lblCIHistorialPostulante = new javax.swing.JLabel();
        lblTelHistorialPostulante = new javax.swing.JLabel();
        lblMailHistorialPostulante = new javax.swing.JLabel();
        lblLinkedinHistorialPostulante = new javax.swing.JLabel();
        lblFormatoHistorialPostulante = new javax.swing.JLabel();
        lblExperienciaHistorialPostulante = new javax.swing.JLabel();
        lblInsertarNombreHistorialPostulante = new javax.swing.JLabel();
        lblInsertarCIHistorialPostulante = new javax.swing.JLabel();
        lblInsertarTelHistorialPostulante = new javax.swing.JLabel();
        lblInsertarMailHistorialPostulante = new javax.swing.JLabel();
        lblInertarLinkedinHistorialPostulante = new javax.swing.JLabel();
        lblInsertarFormatoHistorialPostulante = new javax.swing.JLabel();
        lblInstertarDirecHistorialPostulante = new javax.swing.JLabel();
        listInertarExperienciaHistorialPostulante = new javax.swing.JScrollPane();
        listTematicasPostulanteHistorial = new javax.swing.JList<>();
        SeparatorHistorialPostulante = new javax.swing.JSeparator();
        lblBuscarHistorialPostulante = new javax.swing.JLabel();
        txtPerfilABuscar = new javax.swing.JTextField();
        btnResetearHistorialPostulante = new javax.swing.JButton();
        btnBuscarHistorialPostulante = new javax.swing.JButton();
        btnSalirHistorialPostulante1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableHistorialPostulante = new javax.swing.JTable();
        lblDirecHistorialPostulante = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Historial Postulante");
        getContentPane().setLayout(null);

        lblHistorialPostulante.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHistorialPostulante.setText("Historial Postulante");

        lblPostulantesHistorialPostulante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPostulantesHistorialPostulante.setText("Postulantes");

        listPostulantesHistorialPostulante.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listPostulantesHistorialPostulanteValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listPostulantesHistorialPostulante);

        lblNombreHistorialPostulante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombreHistorialPostulante.setText("Nombre:");

        lblCIHistorialPostulante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCIHistorialPostulante.setText("Cédula:");

        lblTelHistorialPostulante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTelHistorialPostulante.setText("Teléfono:");

        lblMailHistorialPostulante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMailHistorialPostulante.setText("Mail:");

        lblLinkedinHistorialPostulante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblLinkedinHistorialPostulante.setText("Linkedin:");

        lblFormatoHistorialPostulante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFormatoHistorialPostulante.setText("Formato:");

        lblExperienciaHistorialPostulante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblExperienciaHistorialPostulante.setText("Experiencia:");

        lblInertarLinkedinHistorialPostulante.setForeground(new java.awt.Color(102, 102, 255));
        lblInertarLinkedinHistorialPostulante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblInertarLinkedinHistorialPostulante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInertarLinkedinHistorialPostulanteMouseClicked(evt);
            }
        });

        listInertarExperienciaHistorialPostulante.setViewportView(listTematicasPostulanteHistorial);

        lblBuscarHistorialPostulante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBuscarHistorialPostulante.setText("Buscar:");

        txtPerfilABuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPerfilABuscarActionPerformed(evt);
            }
        });

        btnResetearHistorialPostulante.setText("Resetear");
        btnResetearHistorialPostulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetearHistorialPostulanteActionPerformed(evt);
            }
        });

        btnBuscarHistorialPostulante.setText("Buscar");
        btnBuscarHistorialPostulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHistorialPostulanteActionPerformed(evt);
            }
        });

        btnSalirHistorialPostulante1.setText("Salir");
        btnSalirHistorialPostulante1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirHistorialPostulante1ActionPerformed(evt);
            }
        });

        TableHistorialPostulante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nro", "Evaluador", "Puntaje", "Comentarios"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableHistorialPostulante.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TableHistorialPostulante.setEnabled(false);
        TableHistorialPostulante.setUpdateSelectionOnSort(false);
        jScrollPane2.setViewportView(TableHistorialPostulante);
        if (TableHistorialPostulante.getColumnModel().getColumnCount() > 0) {
            TableHistorialPostulante.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableHistorialPostulante.getColumnModel().getColumn(1).setPreferredWidth(180);
            TableHistorialPostulante.getColumnModel().getColumn(2).setPreferredWidth(50);
            TableHistorialPostulante.getColumnModel().getColumn(3).setPreferredWidth(470);
        }
        TableHistorialPostulante.getAccessibleContext().setAccessibleName("");
        TableHistorialPostulante.getAccessibleContext().setAccessibleDescription("");

        lblDirecHistorialPostulante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDirecHistorialPostulante.setText("Direccion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(lblHistorialPostulante, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblBuscarHistorialPostulante)
                                .addGap(12, 12, 12)
                                .addComponent(txtPerfilABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarHistorialPostulante)
                                .addGap(18, 18, 18)
                                .addComponent(btnResetearHistorialPostulante))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblInertarLinkedinHistorialPostulante, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblPostulantesHistorialPostulante, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(121, 121, 121)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblExperienciaHistorialPostulante)
                                        .addComponent(lblFormatoHistorialPostulante)
                                        .addComponent(lblLinkedinHistorialPostulante)
                                        .addComponent(lblMailHistorialPostulante)
                                        .addComponent(lblTelHistorialPostulante)
                                        .addComponent(lblCIHistorialPostulante)
                                        .addComponent(lblNombreHistorialPostulante)
                                        .addComponent(lblDirecHistorialPostulante))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(28, 28, 28)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(listInertarExperienciaHistorialPostulante, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblInsertarFormatoHistorialPostulante, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblInsertarMailHistorialPostulante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblInsertarTelHistorialPostulante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblInstertarDirecHistorialPostulante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblInsertarCIHistorialPostulante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblInsertarNombreHistorialPostulante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(SeparatorHistorialPostulante, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalirHistorialPostulante1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHistorialPostulante, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreHistorialPostulante)
                            .addComponent(lblInsertarNombreHistorialPostulante))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCIHistorialPostulante, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInsertarCIHistorialPostulante, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblInstertarDirecHistorialPostulante)
                            .addComponent(lblDirecHistorialPostulante))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelHistorialPostulante)
                            .addComponent(lblInsertarTelHistorialPostulante))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMailHistorialPostulante)
                            .addComponent(lblInsertarMailHistorialPostulante))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLinkedinHistorialPostulante)
                            .addComponent(lblInertarLinkedinHistorialPostulante))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFormatoHistorialPostulante)
                            .addComponent(lblInsertarFormatoHistorialPostulante))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblExperienciaHistorialPostulante)
                            .addComponent(listInertarExperienciaHistorialPostulante, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblPostulantesHistorialPostulante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(SeparatorHistorialPostulante, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarHistorialPostulante)
                    .addComponent(txtPerfilABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetearHistorialPostulante)
                    .addComponent(btnBuscarHistorialPostulante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalirHistorialPostulante1)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 0, 830, 740);

        setBounds(0, 0, 865, 774);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirHistorialPostulante1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirHistorialPostulante1ActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirHistorialPostulante1ActionPerformed

    private void btnBuscarHistorialPostulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHistorialPostulanteActionPerformed
        buscarPalabra();
    }//GEN-LAST:event_btnBuscarHistorialPostulanteActionPerformed

    private void txtPerfilABuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPerfilABuscarActionPerformed
        
    }//GEN-LAST:event_txtPerfilABuscarActionPerformed

    
    private void listPostulantesHistorialPostulanteValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listPostulantesHistorialPostulanteValueChanged
        cargarDatosPostulante();
    }//GEN-LAST:event_listPostulantesHistorialPostulanteValueChanged
    
    // Funcionamiento del boton resetear
    private void btnResetearHistorialPostulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetearHistorialPostulanteActionPerformed
        
        // Tomo el postulante y cargo la tabla sin ningun texto a colorear
        Postulante p = listPostulantesHistorialPostulante.getSelectedValue();
        ArrayList<Entrevista> entrevistas = modelo.entrevistasDePostulante(p);
        cargarTabla(entrevistas,"");
        
    }//GEN-LAST:event_btnResetearHistorialPostulanteActionPerformed
    
    // Funcionamiento del linkedin
    private void lblInertarLinkedinHistorialPostulanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInertarLinkedinHistorialPostulanteMouseClicked
        // Intento abrir el link
        try {
            // Abre el navegador web predeterminado para visitar el perfil de LinkedIn
            Desktop.getDesktop().browse(new URI(lblInertarLinkedinHistorialPostulante.getText()));
        // Capturo Exeption
        } catch (IOException | URISyntaxException e) {
             JOptionPane.showMessageDialog(this, "No se pudo abrir el enlace. Verifique que la URL sea válida.");
        }
    }//GEN-LAST:event_lblInertarLinkedinHistorialPostulanteMouseClicked

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
            java.util.logging.Logger.getLogger(HistorialPostulante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistorialPostulante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistorialPostulante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistorialPostulante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistorialPostulante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator SeparatorHistorialPostulante;
    private javax.swing.JTable TableHistorialPostulante;
    private javax.swing.JButton btnBuscarHistorialPostulante;
    private javax.swing.JButton btnResetearHistorialPostulante;
    private javax.swing.JButton btnSalirHistorialPostulante1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBuscarHistorialPostulante;
    private javax.swing.JLabel lblCIHistorialPostulante;
    private javax.swing.JLabel lblDirecHistorialPostulante;
    private javax.swing.JLabel lblExperienciaHistorialPostulante;
    private javax.swing.JLabel lblFormatoHistorialPostulante;
    private javax.swing.JLabel lblHistorialPostulante;
    private javax.swing.JLabel lblInertarLinkedinHistorialPostulante;
    private javax.swing.JLabel lblInsertarCIHistorialPostulante;
    private javax.swing.JLabel lblInsertarFormatoHistorialPostulante;
    private javax.swing.JLabel lblInsertarMailHistorialPostulante;
    private javax.swing.JLabel lblInsertarNombreHistorialPostulante;
    private javax.swing.JLabel lblInsertarTelHistorialPostulante;
    private javax.swing.JLabel lblInstertarDirecHistorialPostulante;
    private javax.swing.JLabel lblLinkedinHistorialPostulante;
    private javax.swing.JLabel lblMailHistorialPostulante;
    private javax.swing.JLabel lblNombreHistorialPostulante;
    private javax.swing.JLabel lblPostulantesHistorialPostulante;
    private javax.swing.JLabel lblTelHistorialPostulante;
    private javax.swing.JScrollPane listInertarExperienciaHistorialPostulante;
    private javax.swing.JList<Postulante> listPostulantesHistorialPostulante;
    private javax.swing.JList<String> listTematicasPostulanteHistorial;
    private javax.swing.JTextField txtPerfilABuscar;
    // End of variables declaration//GEN-END:variables
}
