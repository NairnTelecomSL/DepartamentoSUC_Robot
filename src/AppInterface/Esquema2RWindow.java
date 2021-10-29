/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppInterface;

import ClassApplication.RegistroApplication;
import DataClass.Registro;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
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
        this.jPanel1.setVisible(true);
        this.registros = registros;
        this.initialiceFilter();
        this.setTitle("Generador de Tramo - " + robotName);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(130, 118, 3, 112);
        //drawLine(x1,y1,x2,y2)
        //donde x1 e y1 son los puntos de inicio de dibujado.
        //x2 e y2 son la coordenada donde finaliza la linea.
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/robot.png"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reg2Label = new javax.swing.JTextField();
        reg1Label = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        migaLabel = new javax.swing.JTextField();
        limpiaFiltroButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadosField = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();

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

        jButton1.setText("Generar");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

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
        resultadosField.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        resultadosField.setAutoscrolls(false);
        resultadosField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        resultadosField.setDragEnabled(true);
        jScrollPane1.setViewportView(resultadosField);

        jLabel1.setText("Código Miga: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reg1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reg2Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(migaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(limpiaFiltroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(reg1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(reg2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
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
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
         ArrayList<String> sucs1 = RegistroApplication.getSUCS(this.registros, this.reg1Label.getText(), this.migaLabel.getText());
            ArrayList<String> sucs2 = RegistroApplication.getSUCS(this.registros, this.reg2Label.getText(), this.migaLabel.getText());
        try {
            ArrayList<String> result = RegistroApplication.getSUCRelationship(sucs1, sucs2);
            
            String resultText = "\n\n";
            this.resultadosField.setText(null);
            for (int i = 0; i < result.size(); i++) {
                resultText += " - " +result.get(i) + "\n";
            }
            
            resultadosField.setText(resultText);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error: Relación de Registros" , 0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void limpiaFiltroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiaFiltroButtonActionPerformed
        this.initialiceFilter();
    }//GEN-LAST:event_limpiaFiltroButtonActionPerformed

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
                new Esquema2RWindow(RegistroApplication.readCSVData("Files//Robot_Tesa_W49.csv"), "Run").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiaFiltroButton;
    private javax.swing.JTextField migaLabel;
    private javax.swing.JTextField reg1Label;
    private javax.swing.JTextField reg2Label;
    private javax.swing.JTextPane resultadosField;
    // End of variables declaration//GEN-END:variables
}
