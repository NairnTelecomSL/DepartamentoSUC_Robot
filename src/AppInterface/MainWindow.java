/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppInterface;

import ClassApplication.FileReader;
import Exceptions.NoFilesException;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

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

        robotGeneralActivateButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuRobotW49 = new javax.swing.JMenuItem();
        menuRobotWAct = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nairn Telecom S.L - Robot");
        setIconImage(getIconImage());
        setResizable(false);

        robotGeneralActivateButton.setFont(new java.awt.Font("Copperplate Gothic Light", 2, 10)); // NOI18N
        robotGeneralActivateButton.setText("Fichero General");
        robotGeneralActivateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        robotGeneralActivateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        robotGeneralActivateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robotGeneralActivateButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 2, 10)); // NOI18N
        jLabel1.setText("Desarrollado por Álvaro Rofa Aranda");

        jMenu1.setText("Archivos");

        menuRobotW49.setText("Robot 2020 W49");
        menuRobotW49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRobotW49ActionPerformed(evt);
            }
        });
        jMenu1.add(menuRobotW49);

        menuRobotWAct.setText("Robot 2020 Actual");
        menuRobotWAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRobotWActActionPerformed(evt);
            }
        });
        jMenu1.add(menuRobotWAct);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenuItem1.setText("Manual SUCs Orange");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(robotGeneralActivateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(robotGeneralActivateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void robotGeneralActivateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_robotGeneralActivateButtonActionPerformed
        try {
            new RobotWindow(FileReader.readCSVData() , "ROBOT GENERAL").setVisible(true);
        } catch (NoFilesException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error: Ficheros Generales" , 0);
        }
    }//GEN-LAST:event_robotGeneralActivateButtonActionPerformed

    private void menuRobotW49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRobotW49ActionPerformed
        try {
            new RobotWindow(FileReader.readCSVData("Files//Robot_Tesa_W49.csv") , "ROBOT_20W49").setVisible(true);
        } catch (NoFilesException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error: Fichero W49" , 0);
        }
    }//GEN-LAST:event_menuRobotW49ActionPerformed

    private void menuRobotWActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRobotWActActionPerformed
        try {
            new RobotWindow(FileReader.readCSVData("Files//actual.csv") , "ROBOT 21_WACTUAL").setVisible(true);
        } catch (NoFilesException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error: Fichero Act2021" , 0);
        } 
    }//GEN-LAST:event_menuRobotWActActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            File objetofile = new File("Files//Manual//SUCRD.pdf");
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menuRobotW49;
    private javax.swing.JMenuItem menuRobotWAct;
    private javax.swing.JButton robotGeneralActivateButton;
    // End of variables declaration//GEN-END:variables
}
