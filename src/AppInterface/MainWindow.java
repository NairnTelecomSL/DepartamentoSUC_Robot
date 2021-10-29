/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppInterface;

import ClassApplication.RegistroApplication;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Álvaro Rofa Aranda
 */
public class MainWindow extends javax.swing.JFrame {
    
    
    public MainWindow() {
        initComponents();        
        this.setResizable(false);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/robot.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        robotwActualActivateButton = new javax.swing.JButton();
        robotw49ActivateButton = new javax.swing.JButton();
        robotGeneralActivateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nairn Telecom S.L - Robot");
        setIconImage(getIconImage());
        setResizable(false);

        robotwActualActivateButton.setFont(new java.awt.Font("Copperplate Gothic Light", 2, 10)); // NOI18N
        robotwActualActivateButton.setText("ROBOT 2021 WActual");
        robotwActualActivateButton.setActionCommand("ROBOT 202WActual");
        robotwActualActivateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robotwActualActivateButtonActionPerformed(evt);
            }
        });

        robotw49ActivateButton.setFont(new java.awt.Font("Copperplate Gothic Light", 2, 10)); // NOI18N
        robotw49ActivateButton.setText("ROBOT 2020 W49");
        robotw49ActivateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robotw49ActivateButtonActionPerformed(evt);
            }
        });

        robotGeneralActivateButton.setFont(new java.awt.Font("Copperplate Gothic Light", 2, 10)); // NOI18N
        robotGeneralActivateButton.setText("Fichero General");
        robotGeneralActivateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        robotGeneralActivateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        robotGeneralActivateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robotGeneralActivateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(robotw49ActivateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(robotwActualActivateButton)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(robotGeneralActivateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(robotwActualActivateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(robotw49ActivateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(robotGeneralActivateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void robotw49ActivateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_robotw49ActivateButtonActionPerformed
        new RobotWindow(RegistroApplication.readCSVData("Files//Robot_Tesa_W49.csv") , "ROBOT_20W49").setVisible(true);
    }//GEN-LAST:event_robotw49ActivateButtonActionPerformed

    private void robotwActualActivateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_robotwActualActivateButtonActionPerformed
        new RobotWindow(RegistroApplication.readCSVData("Files//actual.csv") , "ROBOT 21_WACTUAL").setVisible(true);
    }//GEN-LAST:event_robotwActualActivateButtonActionPerformed

    private void robotGeneralActivateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_robotGeneralActivateButtonActionPerformed
        new RobotWindow(RegistroApplication.readCSVData() , "ROBOT GENERAL").setVisible(true);
    }//GEN-LAST:event_robotGeneralActivateButtonActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton robotGeneralActivateButton;
    private javax.swing.JButton robotw49ActivateButton;
    private javax.swing.JButton robotwActualActivateButton;
    // End of variables declaration//GEN-END:variables
}