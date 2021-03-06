
package com.mycompany.practica10diu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;

/**
 *
 * @author marti
 */
public class Practica10 extends javax.swing.JFrame {
    Tarea tarea;
    private String pathOrigin,pathDestino, nombreCarpeta;
    private File carpeta;
    private List<String> files;
    private File[] archivosCarpeta;
    private List<String> filesPath = new ArrayList<>();
    private JFileChooser fc= new JFileChooser();
    
    private class Tarea extends SwingWorker<Void,Void>{
        @Override
        protected Void doInBackground() throws Exception {
           try{
                BufferedInputStream origin = null;
                FileOutputStream dest = new FileOutputStream(pathDestino+"\\" + nombreCarpeta + ".zip");
                ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
                int BUFFER_SIZE = 10000;
                byte[] data = new byte[BUFFER_SIZE];
                int size = 100 / filesPath.size();
                Iterator i = filesPath.iterator();
                while(i.hasNext()){
                    String filename = (String)i.next();
                    FileInputStream fi = new FileInputStream(filename);
                    origin = new BufferedInputStream(fi, BUFFER_SIZE);
                    ZipEntry entry = new ZipEntry( filename );
                    out.putNextEntry( entry );
                    int count;
                    while((count = origin.read(data, 0, BUFFER_SIZE)) != -1){
                        out.write(data, 0, count);
                    }
                    origin.close();
                    progresBar.setValue(progresBar.getValue() + size);
                    Thread.sleep(100);
                }
                out.close();
            } catch( Exception e ){
                e.printStackTrace();
            }
           return null;
        }
        @Override
        public void done(){
            System.out.println("Tarea terminada");
        }
    
    }
    
    
    public Practica10() {
        initComponents();
        setLocationRelativeTo(null);
        progresBar.setStringPainted(true);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        originLabel.setText("No has seleccionado ninguna carpeta para comprimirla (Ctrl+O)");
        pathDestino="";
        jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        beginZip = new javax.swing.JButton();
        endZip = new javax.swing.JButton();
        progresBar = new javax.swing.JProgressBar();
        progresLabel = new javax.swing.JLabel();
        originLabel = new javax.swing.JLabel();
        destinoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        nameLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        selectItem = new javax.swing.JMenuItem();
        selectDestinoItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        aboutItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        beginZip.setText("Comenzar");
        beginZip.setEnabled(false);
        beginZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginZipActionPerformed(evt);
            }
        });

        endZip.setText("Terminar");
        endZip.setEnabled(false);
        endZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endZipActionPerformed(evt);
            }
        });

        progresLabel.setText("Progreso:");

        originLabel.setText("No has seleccionado ninguna carpeta para comprimirla (Ctrl+O)");

        jScrollPane1.setViewportView(jList1);

        fileMenu.setText("Archivo");

        selectItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        selectItem.setText("Seleccionar carpeta origen");
        selectItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectItemActionPerformed(evt);
            }
        });
        fileMenu.add(selectItem);

        selectDestinoItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        selectDestinoItem.setText("Seleccionar carpeta destino");
        selectDestinoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDestinoItemActionPerformed(evt);
            }
        });
        fileMenu.add(selectDestinoItem);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Seleccionar nombre archivo comprimido");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        jMenuBar1.add(fileMenu);

        aboutMenu.setText("Ayuda");

        aboutItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        aboutItem.setText("Acerca de");
        aboutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutItemActionPerformed(evt);
            }
        });
        aboutMenu.add(aboutItem);

        jMenuBar1.add(aboutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(progresLabel)
                    .addComponent(progresBar, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(beginZip)
                        .addGap(76, 76, 76)
                        .addComponent(endZip))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(originLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(destinoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(originLabel)
                .addGap(18, 18, 18)
                .addComponent(destinoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beginZip)
                    .addComponent(endZip))
                .addGap(18, 18, 18)
                .addComponent(progresLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progresBar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void beginZipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beginZipActionPerformed
        progresBar.setValue(0);
        filesPath = toPath(jList1.getSelectedValuesList());
        if(Arrays.asList(new File(pathDestino).list()).contains(nombreCarpeta + ".zip")){
            int res = JOptionPane.showConfirmDialog(this, "??Desea sobreescribir el archivo '"+ nombreCarpeta +".zip'?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (res == JOptionPane.OK_OPTION){
                tarea=new Tarea();
                tarea.execute();
                endZip.setEnabled(true);
            }
        }else{
                tarea=new Tarea();
                tarea.execute();
                endZip.setEnabled(true);
        }
    }//GEN-LAST:event_beginZipActionPerformed

    private void endZipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endZipActionPerformed
       tarea.cancel(true);
    }//GEN-LAST:event_endZipActionPerformed

    private void carpetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carpetButtonActionPerformed

    }//GEN-LAST:event_carpetButtonActionPerformed

    private void selectItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectItemActionPerformed
        int res = fc.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            carpeta = fc.getSelectedFile();
            
            String[] names;
            names = carpeta.list();
            archivosCarpeta = carpeta.listFiles();
            jList1.setListData(names);
            
            nombreCarpeta= carpeta.getName();
            pathOrigin = carpeta.getAbsolutePath();
            files = Arrays.asList(fc.getSelectedFile().list());
            originLabel.setText("Se comprimir?? la ruta: "+pathOrigin);
            pathDestino = carpeta.getParent();
            destinoLabel.setText("Destino de la compresi??n: " +pathDestino);
            nameLabel.setText("Nombre de la compresi??n: " + nombreCarpeta);
            beginZip.setEnabled(true);
        }
    }//GEN-LAST:event_selectItemActionPerformed

    private List<String> toPath(List<String> names){
        List<String> res = new ArrayList<>();
        for (String name : names) {
            for (File file : archivosCarpeta) {
                if(name.equals(file.getName()))
                    res.add(file.getAbsolutePath());
            }
        }    
        return res;
    }
    
    private void selectDestinoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDestinoItemActionPerformed
        int res = fc.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            pathDestino = fc.getSelectedFile().getAbsolutePath();
            destinoLabel.setText("Destino de la compresi??n: " +pathDestino);

        }
    }//GEN-LAST:event_selectDestinoItemActionPerformed

    private void aboutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutItemActionPerformed
        JOptionPane.showMessageDialog(rootPane,  "Software que efect??a compresi??n de archivos y se visualiza el proceso.\n" +
                                                 "Product Version: Compresi??n de archivos\n"+
                                                 "Devs: @martinvplopez, @joelnavri"
                        , "AYUDA", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        nombreCarpeta = JOptionPane.showInputDialog(rootPane, "Introduzca el nombre del archivo.");
        nameLabel.setText("Nombre de la compresi??n: " + nombreCarpeta);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Practica10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Practica10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Practica10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Practica10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Practica10().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutItem;
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JButton beginZip;
    private javax.swing.JLabel destinoLabel;
    private javax.swing.JButton endZip;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel originLabel;
    private javax.swing.JProgressBar progresBar;
    private javax.swing.JLabel progresLabel;
    private javax.swing.JMenuItem selectDestinoItem;
    private javax.swing.JMenuItem selectItem;
    // End of variables declaration//GEN-END:variables
}
