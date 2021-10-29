/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppInterface;

import ClassApplication.FileReader;
import DataClass.Registro;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Álvaro Rofa Aranda
 */
public class RobotWindow extends javax.swing.JFrame {

    //VARIABLES DE FILTRO
    private TableRowSorter trs;
    private List<RowFilter<Object, Object>> filterList;
    private RowFilter<Object, Object> rowFilter;
    
    //VARIABLES USO DE DATOS
    private final ArrayList<Registro> registros;
    private String robotName;
    
    //VARIABLES DE DISEÑO
    DefaultTableModel modeloRobot = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/robot.png"));
        return retValue;
    }
    public RobotWindow(ArrayList<Registro> data, String robotName) {
        initComponents();
        setResizable(false);
        this.drawTableRobot();
        this.registros = data;
        this.robotText.setText(this.robotName);
        this.drawDataRegistros(this.registros);
        this.robotName = robotName;
        this.setTitle(this.robotName);
    }

    private void drawTableRobot() {
        tablaDocAc.setModel(modeloRobot);
        String[] columnasTabla = {"NºSUC", "Miga", "Estado", "Identificador", "Uso", "Cable" , "Elemento Pasivo", "IPID_ID"};
        modeloRobot.setColumnIdentifiers(columnasTabla);

        // Para no permitir el redimensionamiento de las columnas con el ratón
        tablaDocAc.getTableHeader().setResizingAllowed(true);

        // Así se fija el ancho de las columnas
        tablaDocAc.getColumnModel().getColumn(0).setPreferredWidth(155);  // numero_SUC
        tablaDocAc.getColumnModel().getColumn(1).setPreferredWidth(60);   // miga
        tablaDocAc.getColumnModel().getColumn(2).setPreferredWidth(100);  // estado
        tablaDocAc.getColumnModel().getColumn(3).setPreferredWidth(180);  // identificador
        tablaDocAc.getColumnModel().getColumn(4).setPreferredWidth(25);   // uso
        tablaDocAc.getColumnModel().getColumn(5).setPreferredWidth(100);  // cable
        tablaDocAc.getColumnModel().getColumn(6).setPreferredWidth(120);  // elementoPasivo
        tablaDocAc.getColumnModel().getColumn(7).setPreferredWidth(60);   // ipid_id
        //AQUI DIBUJAREMOS AUTOMÁTICAMENTE TODOS LOS TÉCNICOS
    }    
    
    private void drawDataRegistros(ArrayList<Registro> registro) {    
        Object[] columna = new Object[8];  
        int numRegistros = registro.size();
        System.out.println(numRegistros);
        for (int i = 0; i < numRegistros; i++) {
            columna[0] = registro.get(i).getNumeroSUC();
            columna[1] = registro.get(i).getMiga();
            columna[2] = registro.get(i).getEstado();
            columna[3] = registro.get(i).getIdentificador();
            columna[4] = registro.get(i).getUso();
            columna[5] = registro.get(i).getCable();
            columna[6] = registro.get(i).getElementoPasivo();
            columna[7] = registro.get(i).getIPIDID(); 
            modeloRobot.addRow(columna);
        }        
    }
    
    public void activateFilter(javax.swing.JTextField textField){
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                filterList = new ArrayList<>(2);
                filterList.add(RowFilter.regexFilter(migaFilter.getText(), 1));           //MIGA
                filterList.add(RowFilter.regexFilter(idFilter.getText(), 7));             //IPID_ID
                filterList.add(RowFilter.regexFilter(identificacionFilter.getText(), 3)); //IDENTIFICADOR
                rowFilter = RowFilter.andFilter(filterList);
                trs.setRowFilter(rowFilter);
            }
        }
        );
        trs = new TableRowSorter(modeloRobot);
        tablaDocAc.setRowSorter(trs);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        robotText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDocAc = new javax.swing.JTable();
        migaFilter = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        idFilter = new javax.swing.JTextField();
        resetFilterButton1 = new javax.swing.JButton();
        identificacionFilter = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabelmiga = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        buscarCablesButton = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(224, 255, 255));
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        robotText.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        robotText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        robotText.setText("AQUI IRÁ REFLEJADO EL ROBOT QUE SE MUESTRA EN LA TABLA DE ABAJO");
        robotText.setToolTipText("");

        tablaDocAc.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaDocAc.setToolTipText("");
        tablaDocAc.setColumnSelectionAllowed(true);
        tablaDocAc.setSelectionBackground(new java.awt.Color(51, 255, 51));
        jScrollPane1.setViewportView(tablaDocAc);

        migaFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                migaFilterActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Filtrar IPID_ID: ");

        idFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFilterActionPerformed(evt);
            }
        });

        resetFilterButton1.setText("Eliminar filtros");
        resetFilterButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFilterButton1ActionPerformed(evt);
            }
        });

        identificacionFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificacionFilterActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Filtrar Identificador:");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabelmiga.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelmiga.setText("Filtrar Miga: ");

        jLabel1.setFont(new java.awt.Font("Consolas", 2, 10)); // NOI18N
        jLabel1.setText("Desarrollado por Álvaro Rofa Aranda");

        jMenu2.setBorder(new javax.swing.border.MatteBorder(null));
        jMenu2.setText("Acciones");

        buscarCablesButton.setText("Buscar cables entre registros");
        buscarCablesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCablesButtonActionPerformed(evt);
            }
        });
        jMenu2.add(buscarCablesButton);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(robotText))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelmiga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(migaFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(identificacionFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(resetFilterButton1)))
                                .addGap(363, 698, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(robotText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(migaFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelmiga, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetFilterButton1)
                    .addComponent(identificacionFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void migaFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_migaFilterActionPerformed
        this.activateFilter(migaFilter);
    }//GEN-LAST:event_migaFilterActionPerformed

    private void idFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFilterActionPerformed
        this.activateFilter(idFilter);
    }//GEN-LAST:event_idFilterActionPerformed

    private void resetFilterButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFilterButton1ActionPerformed
        this.resetFilter();
    }//GEN-LAST:event_resetFilterButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void identificacionFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificacionFilterActionPerformed
        this.activateFilter(identificacionFilter);
    }//GEN-LAST:event_identificacionFilterActionPerformed

    private void buscarCablesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCablesButtonActionPerformed
        new Esquema2RWindow(registros, this.robotName).setVisible(true);
    }//GEN-LAST:event_buscarCablesButtonActionPerformed
    
    private void resetFilter(){
        idFilter.setText(null);
        migaFilter.setText(null);
        identificacionFilter.setText(null);
        filterList = null;
        rowFilter = null;
    }
     
        public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new RobotWindow(FileReader.readCSVData("Files//Robot_Tesa_W49.csv") , "ROBOT_RUN").setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage(), "Error: Fichero" , 0);
                }
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem buscarCablesButton;
    private javax.swing.JTextField idFilter;
    private javax.swing.JTextField identificacionFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelmiga;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField migaFilter;
    private javax.swing.JButton resetFilterButton1;
    private javax.swing.JLabel robotText;
    private javax.swing.JTable tablaDocAc;
    // End of variables declaration//GEN-END:variables
}
