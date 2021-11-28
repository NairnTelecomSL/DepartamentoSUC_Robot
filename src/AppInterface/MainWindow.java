/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppInterface;

import ClassApplication.CalendarUse;
import ClassApplication.FilesReader;
import DataClass.DataFile;
import Exceptions.FicherosException;
import Exceptions.NoFilesException;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Álvaro Rofa Aranda
 */
public class MainWindow extends javax.swing.JFrame {    
    private DataFile fileUses;
    private final CalendarUse calendarUse;
    
    public MainWindow() {
        initComponents();   
        calendarUse = new CalendarUse();
        this.jlbToday.setText(calendarUse.getDate() + " - " + this.calendarUse.getDayOfTheWeek().toUpperCase());
        this.setResizable(false);
        this.dateAlarm();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/nairn.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        robotGeneralActivateButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlbToday = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivosMenu = new javax.swing.JMenu();
        menuRobotW49 = new javax.swing.JMenuItem();
        menuRobotWAct = new javax.swing.JMenuItem();
        menuTesaMiga = new javax.swing.JMenuItem();
        ayudaMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        aparienciaMenu = new javax.swing.JMenu();
        aluminioButton = new javax.swing.JMenuItem();
        blaquiazulButton = new javax.swing.JMenuItem();
        amarilloButton = new javax.swing.JMenuItem();
        blackButton = new javax.swing.JMenuItem();
        windowsclassicButton = new javax.swing.JMenuItem();
        textureButton = new javax.swing.JMenuItem();
        defaultButton = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Robot");
        setIconImage(getIconImage());
        setLocationByPlatform(true);
        setResizable(false);

        robotGeneralActivateButton.setFont(new java.awt.Font("Copperplate Gothic Light", 2, 10)); // NOI18N
        robotGeneralActivateButton.setText("Fichero General");
        robotGeneralActivateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        robotGeneralActivateButton.setFocusCycleRoot(true);
        robotGeneralActivateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        robotGeneralActivateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robotGeneralActivateButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 2, 10)); // NOI18N
        jLabel1.setText("Desarrollado por Álvaro Rofa Aranda");

        jlbToday.setFont(new java.awt.Font("Consolas", 2, 10)); // NOI18N
        jlbToday.setText("FECHA DE HOY");

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuBar1.setName(""); // NOI18N

        archivosMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        archivosMenu.setText("Archivos");

        menuRobotW49.setText("Robot 2020 W49");
        menuRobotW49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRobotW49ActionPerformed(evt);
            }
        });
        archivosMenu.add(menuRobotW49);

        menuRobotWAct.setText("Robot 2021 Actual");
        menuRobotWAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRobotWActActionPerformed(evt);
            }
        });
        archivosMenu.add(menuRobotWAct);

        menuTesaMiga.setText("CTs Tesa Miga");
        menuTesaMiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTesaMigaActionPerformed(evt);
            }
        });
        archivosMenu.add(menuTesaMiga);

        jMenuBar1.add(archivosMenu);

        ayudaMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ayudaMenu.setText("Ayuda");

        jMenuItem1.setText("Manual SUCs Orange");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        ayudaMenu.add(jMenuItem1);

        jMenuBar1.add(ayudaMenu);

        aparienciaMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        aparienciaMenu.setText("Apariencia");

        aluminioButton.setText("Aluminio");
        aluminioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aluminioButtonActionPerformed(evt);
            }
        });
        aparienciaMenu.add(aluminioButton);

        blaquiazulButton.setText("Blanquiazul");
        blaquiazulButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blaquiazulButtonActionPerformed(evt);
            }
        });
        aparienciaMenu.add(blaquiazulButton);

        amarilloButton.setText("Amarillo");
        amarilloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amarilloButtonActionPerformed(evt);
            }
        });
        aparienciaMenu.add(amarilloButton);

        blackButton.setText("Black Noir");
        blackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blackButtonActionPerformed(evt);
            }
        });
        aparienciaMenu.add(blackButton);

        windowsclassicButton.setText("Window Vista Classic");
        windowsclassicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windowsclassicButtonActionPerformed(evt);
            }
        });
        aparienciaMenu.add(windowsclassicButton);

        textureButton.setText("Texturizado");
        textureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textureButtonActionPerformed(evt);
            }
        });
        aparienciaMenu.add(textureButton);

        defaultButton.setText("Por defecto");
        defaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultButtonActionPerformed(evt);
            }
        });
        aparienciaMenu.add(defaultButton);

        jMenuBar1.add(aparienciaMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbToday, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(robotGeneralActivateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(robotGeneralActivateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlbToday, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void robotGeneralActivateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_robotGeneralActivateButtonActionPerformed
        try {
            new RobotWindow(FilesReader.readCSVData() , "ROBOT GENERAL").setVisible(true);
        } catch (NoFilesException | FicherosException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error: Ficheros Generales" , 0);
        }
    }//GEN-LAST:event_robotGeneralActivateButtonActionPerformed

    private void menuRobotW49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRobotW49ActionPerformed
        try {
            fileUses = new DataFile();
            new RobotWindow(FilesReader.readCSVData(fileUses.getRobotW49Route()) , "Robot_Tesa_W49").setVisible(true);
        } catch (NoFilesException | FicherosException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error: Fichero W49" , 0);
        }
    }//GEN-LAST:event_menuRobotW49ActionPerformed

    private void menuRobotWActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRobotWActActionPerformed
        try {
            fileUses = new DataFile();
            new RobotWindow(FilesReader.readCSVData(fileUses.getRobotWActRoute()) , "Robot_Tesa_2020_2021_WActual").setVisible(true);
        } catch (NoFilesException | FicherosException ex) {
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

    private void aluminioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aluminioButtonActionPerformed
        this.establecerVista(1);
    }//GEN-LAST:event_aluminioButtonActionPerformed

    private void blaquiazulButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blaquiazulButtonActionPerformed
        this.establecerVista(2);
    }//GEN-LAST:event_blaquiazulButtonActionPerformed

    private void amarilloButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amarilloButtonActionPerformed
        this.establecerVista(3);
    }//GEN-LAST:event_amarilloButtonActionPerformed

    private void blackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blackButtonActionPerformed
        this.establecerVista(4);
    }//GEN-LAST:event_blackButtonActionPerformed

    private void windowsclassicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windowsclassicButtonActionPerformed
        this.establecerVista(5);
    }//GEN-LAST:event_windowsclassicButtonActionPerformed

    private void defaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultButtonActionPerformed
        this.establecerVista(6);
    }//GEN-LAST:event_defaultButtonActionPerformed

    private void textureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textureButtonActionPerformed
        this.establecerVista(7);
    }//GEN-LAST:event_textureButtonActionPerformed

    private void menuTesaMigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTesaMigaActionPerformed
        new CentralesWindow(FilesReader.readTesaMigaXLSX()).setVisible(true);
    }//GEN-LAST:event_menuTesaMigaActionPerformed

    private void establecerVista(int n){
        try
        {
            switch(n)
            {
                case 1:
                    UIManager.setLookAndFeel(new AluminiumLookAndFeel()); // ALUMINIO
                    break;
                case 2:
                    UIManager.setLookAndFeel(new AeroLookAndFeel()); // BLANQUIAZUL
                    break;
                case 3:
                    UIManager.setLookAndFeel(new BernsteinLookAndFeel()); // AMARILLO
                    break;                
                case 4:
                    UIManager.setLookAndFeel(new HiFiLookAndFeel()); //BLACK
                    break;        
                case 5:
                    UIManager.setLookAndFeel(new LunaLookAndFeel()); //CLASSIC WINDOWS VISTA
                    break;   
                case 6:
                    UIManager.setLookAndFeel(new McWinLookAndFeel()); //PONER COMO VISTA PRINCIPAL
                    break;      
                case 7:
                    UIManager.setLookAndFeel(new TextureLookAndFeel()); // TEXTURIZADO
                    break;
                case 8:
                    UIManager.setLookAndFeel(new WindowsClassicLookAndFeel()); // MINIMALISTA CLASICO
                    break;
            }
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println(e.getMessage());
        } finally {
            dispose();
            new MainWindow().setVisible(true);
        }
    }
       
    private void dateAlarm(){      
        if(calendarUse.getDayOfTheWeek().toUpperCase().equals("LUNES")){
            JOptionPane.showMessageDialog(null,"¡¡Buenos dias!!, Hoy es lunes, recuerda actualizar el robot de esta semana.\nAñadelos en formato '.csv' en la carpeta Robot/Files.", 
                    "Actualización Fichero Semanal" , 1);
        }        
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                   UIManager.setLookAndFeel(new McWinLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                new MainWindow().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aluminioButton;
    private javax.swing.JMenuItem amarilloButton;
    private javax.swing.JMenu aparienciaMenu;
    private javax.swing.JMenu archivosMenu;
    private javax.swing.JMenu ayudaMenu;
    private javax.swing.JMenuItem blackButton;
    private javax.swing.JMenuItem blaquiazulButton;
    private javax.swing.JMenuItem defaultButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel jlbToday;
    private javax.swing.JMenuItem menuRobotW49;
    private javax.swing.JMenuItem menuRobotWAct;
    private javax.swing.JMenuItem menuTesaMiga;
    private javax.swing.JButton robotGeneralActivateButton;
    private javax.swing.JMenuItem textureButton;
    private javax.swing.JMenuItem windowsclassicButton;
    // End of variables declaration//GEN-END:variables
}
