/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppInterface;

import ClassApplication.FilesReader;
import ClassApplication.RegistroApplication;
import DataClass.Registro;
import Exceptions.NoFilesException;
import Exceptions.NoRelationshipException;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Álvaro Rofa Aranda
 */
public class Esquema2RWindow extends javax.swing.JFrame {
    
    private final ArrayList<Registro> registros;
    
    public Esquema2RWindow(ArrayList<Registro> registros, String robotName) {
        initComponents();
        this.registros = registros;
        this.initialiceFilter();
        this.setTitle("Generador de Tramo - " + robotName);
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/nairn.png"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reg2Label = new javax.swing.JTextField();
        reg1Label = new javax.swing.JTextField();
        generateButton = new javax.swing.JButton();
        migaLabel = new javax.swing.JTextField();
        limpiaFiltroButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadosField = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbtAbrirPlantilla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generador de Tramo");
        setIconImage(getIconImage());
        setResizable(false);

        reg2Label.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        reg2Label.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reg2Label.setText("Registro2");
        reg2Label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        reg1Label.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        reg1Label.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reg1Label.setText("Registro1");
        reg1Label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        generateButton.setText("Generar");
        generateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        migaLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        migaLabel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        migaLabel.setText("MIGA");

        limpiaFiltroButton.setText("Limpiar Filtros");
        limpiaFiltroButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        limpiaFiltroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiaFiltroButtonActionPerformed(evt);
            }
        });

        resultadosField.setBorder(new javax.swing.border.MatteBorder(null));
        resultadosField.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        resultadosField.setAutoscrolls(false);
        resultadosField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        resultadosField.setDragEnabled(true);
        jScrollPane1.setViewportView(resultadosField);

        jLabel1.setText("Código Miga: ");

        jLabel2.setFont(new java.awt.Font("Consolas", 2, 10)); // NOI18N
        jLabel2.setText("Desarrollado por Álvaro Rofa Aranda");

        jbtAbrirPlantilla.setText("Abrir Plantilla");
        jbtAbrirPlantilla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtAbrirPlantilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAbrirPlantillaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reg1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reg2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(migaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtAbrirPlantilla, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(limpiaFiltroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(reg1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reg2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(migaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limpiaFiltroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtAbrirPlantilla, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        ArrayList<String> sucs1 = RegistroApplication.getSUCS(this.registros, this.reg1Label.getText(), this.migaLabel.getText());
        ArrayList<String> sucs2 = RegistroApplication.getSUCS(this.registros, this.reg2Label.getText(), this.migaLabel.getText());
        try {
            ArrayList<String> result = RegistroApplication.getSUCRelationship(sucs1, sucs2);
            ArrayList<String []> resultSplit = new ArrayList<>();
            for (int i = 0; i < result.size(); i++) {
                resultSplit.add(result.get(i).split("-"));
            }            
            
            String resultText = "";
            this.resultadosField.setText(null);
            int contador = 1;
            for (int i = 0; i < resultSplit.size(); i++) {
                System.out.println(resultSplit.get(i)[1]);
                if(!resultSplit.get(i)[1].contains("BAJA") && !resultSplit.get(i)[1].contains("ANULADA")){
                    //SI NO ESTÁ ANULADA, LA AÑADO
                    if (resultSplit.get(i)[1].contains("+")) {
                        resultText += ("Cable " + contador + " de X solicitado en SUC: " + resultSplit.get(i)[0] + "\n");
                        contador++;
                        resultText += ("Cable " + contador + " de X solicitado en SUC: " + resultSplit.get(i)[0] + "\n");
                        contador++;
                    }else{
                        resultText += ("Cable " + contador + " de X solicitado en SUC: " + resultSplit.get(i)[0] + "\n");
                        contador++;
                    }
                }
            }   
            resultText += ("Cable " + contador + " de X solicitado en esta SUC. ");
            resultadosField.setText(resultText);
        } catch (NoRelationshipException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Relación de Registros" , 1);
        } 
    }//GEN-LAST:event_generateButtonActionPerformed
    
    private void limpiaFiltroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiaFiltroButtonActionPerformed
        this.initialiceFilter();
    }//GEN-LAST:event_limpiaFiltroButtonActionPerformed

    private void jbtAbrirPlantillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAbrirPlantillaActionPerformed
        try {
            File objetofile = new File("Files//Manual//PLANTILLARQ.ppt");
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex) {
            System.out.println(ex);
        }        
    }//GEN-LAST:event_jbtAbrirPlantillaActionPerformed

    private void initialiceFilter(){
        this.resultadosField.setText("\n\n\n\n\n\t            Resultados de la búsqueda");
        this.reg1Label.setText("Registro1");
        this.reg1Label.setFont(new Font("Verdana", Font.BOLD, 18));
        this.reg1Label.setHorizontalAlignment(JTextField.CENTER);
        
        this.reg2Label.setText("Registro2");
        this.reg2Label.setFont(new Font("Verdana", Font.BOLD, 18));
        this.reg2Label.setHorizontalAlignment(JTextField.CENTER);
        
        this.migaLabel.setText("MIGA");        
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Esquema2RWindow(FilesReader.readCSVData("Files//Robot_Tesa_W49.csv"), "Run").setVisible(true);
                } catch (NoFilesException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage(), "Error: Fichero" , 0);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton generateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtAbrirPlantilla;
    private javax.swing.JButton limpiaFiltroButton;
    private javax.swing.JTextField migaLabel;
    private javax.swing.JTextField reg1Label;
    private javax.swing.JTextField reg2Label;
    private javax.swing.JTextPane resultadosField;
    // End of variables declaration//GEN-END:variables
}
