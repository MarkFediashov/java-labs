package com.team.mavenproject1;

import com.team.mavenproject1.dao.DataProvider;
import com.team.mavenproject1.dto.IntegralComputationDto;
import com.team.mavenproject1.exception.ValidatorException;
import com.team.mavenproject1.services.IntegralComputationDtoSerializator;
import com.team.mavenproject1.services.Serializator;
import com.team.mavenproject1.validator.ValueValidator;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.function.Consumer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class IntegralForm extends javax.swing.JFrame {

    /**
     * Creates new form IntegralForm
     */
    final Integral<Function> integral;
    private final static int RECORDS_AMOUNT = 10;
    private int collectionStartSince = -1;
    
    
    public IntegralForm() {
        integral = new Integral<>((x)->x+2);                                                //частично мой говнокод (ненужный)
        initComponents();
        fillComputations();
        
    }
    
    private void fillComputations(){
        DataProvider provider = DataProvider.of(this);
        List<IntegralComputationDto> tableRows = provider.getComputationList();
        
        Random rand = new Random();
        
        for(int i = 0; i < RECORDS_AMOUNT; i++){
            IntegralComputationDto temp = new IntegralComputationDto();
            temp.setLeft(rand.nextDouble() * 10);
            temp.setRigth(rand.nextDouble() * 100);
            temp.setDx(rand.nextDouble());
            
            integral.computeIntegralDto(temp);
            tableRows.add(temp);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        addRowButton = new javax.swing.JButton();
        computeButton = new javax.swing.JButton();
        removeSelectedRow = new javax.swing.JButton();
        leftBoundField = new java.awt.TextField();
        rigthBoundField = new java.awt.TextField();
        stepField = new java.awt.TextField();
        removeCollectionRowsButton = new javax.swing.JButton();
        fillFromCollectionButton = new javax.swing.JButton();
        binSaveButton = new javax.swing.JButton();
        fetchBinButton = new javax.swing.JButton();
        saveJsonButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Left bound", "Rigth bound", "Step (dx)", "Result of integration"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(resultTable);

        addRowButton.setText("Add");
        addRowButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addRowButtonMouseClicked(evt);
            }
        });

        computeButton.setText("Compute");
        computeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                computeButtonMouseClicked(evt);
            }
        });

        removeSelectedRow.setText("Remove");
        removeSelectedRow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeSelectedRowMouseClicked(evt);
            }
        });

        leftBoundField.setText("0");

        rigthBoundField.setText("20");

        stepField.setText("0.1");

        removeCollectionRowsButton.setText("Remove collection rows");
        removeCollectionRowsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeCollectionRowsButtonMouseClicked(evt);
            }
        });

        fillFromCollectionButton.setText("Fill from collection");
        fillFromCollectionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fillFromCollectionButtonMouseClicked(evt);
            }
        });

        binSaveButton.setText("Save as bin");
        binSaveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                binSaveButtonMouseClicked(evt);
            }
        });

        fetchBinButton.setText("Fetch from bin");
        fetchBinButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fetchBinButtonMouseClicked(evt);
            }
        });

        saveJsonButton.setText("Save as json");
        saveJsonButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveJsonButtonMouseClicked(evt);
            }
        });

        jButton1.setText("Fetch from json");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(268, 268, 268)
                                .addComponent(computeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(stepField, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rigthBoundField, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(leftBoundField, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeCollectionRowsButton)
                            .addComponent(fillFromCollectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fetchBinButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(binSaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveJsonButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addRowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(645, 645, 645)
                        .addComponent(removeSelectedRow, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(fillFromCollectionButton)
                        .addGap(42, 42, 42)
                        .addComponent(removeCollectionRowsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(removeSelectedRow)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addRowButton)
                        .addGap(36, 36, 36))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(leftBoundField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(rigthBoundField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(stepField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(computeButton)
                .addGap(126, 126, 126)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(binSaveButton)
                    .addComponent(saveJsonButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fetchBinButton)
                    .addComponent(jButton1))
                .addGap(52, 52, 52))
        );

        removeCollectionRowsButton.getAccessibleContext().setAccessibleName("removeCollectionButton");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void computeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_computeButtonMouseClicked
        int selectedRow = resultTable.getSelectedRow();
        
        double left, rigth, dx;
        
        Vector<Object> row = null;
        try{
        
            if(selectedRow != -1){
                row = ((DefaultTableModel) resultTable.getModel()).getDataVector().elementAt(selectedRow);
            
                left = ValueValidator.validateAndParse((String)row.get(0));
                rigth =  ValueValidator.validateAndParse((String)row.get(1));
                dx =  ValueValidator.validateAndParse((String)row.get(2));
            
            } else {
                left = ValueValidator.validateAndParse(leftBoundField.getText());                         // мой говнокод
                rigth = ValueValidator.validateAndParse(rigthBoundField.getText());
                dx = ValueValidator.validateAndParse(stepField.getText());
            }
        } catch (ValidatorException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        } 
        double result = integral.integrateInBounds(left, rigth, dx);
        
        if(row!=null){
            row.insertElementAt(result, 3);
        }
        else {
            IntegralComputationDto dto = new IntegralComputationDto(left, rigth, dx, result);
            DefaultTableModel model = (DefaultTableModel)resultTable.getModel();
            model.addRow(dto.asRow());
        }
        
        
    }//GEN-LAST:event_computeButtonMouseClicked

    private DefaultTableModel getDefaultTableModel (){
        return (DefaultTableModel)resultTable.getModel();
    }
    
    private void addRowButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRowButtonMouseClicked
        DefaultTableModel model = getDefaultTableModel();
        model.addRow(new Object[]{0.0,0.0,0.0,0.0});
    }//GEN-LAST:event_addRowButtonMouseClicked

    private void removeSelectedRowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeSelectedRowMouseClicked
        int selectedRow = resultTable.getSelectedRow();
        DefaultTableModel model = getDefaultTableModel();
        if(selectedRow >= 0){
            model.removeRow(selectedRow);
        }
      
    }//GEN-LAST:event_removeSelectedRowMouseClicked

    private String getRepositoryFile(){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        
        int result = chooser.showOpenDialog(this);
        
        return result == JFileChooser.APPROVE_OPTION ? chooser.getSelectedFile().getAbsolutePath() : null;
    }
    
    private List<IntegralComputationDto> getTableAsList() {
        Vector<Vector> vector = getDefaultTableModel().getDataVector();
        List<IntegralComputationDto> list = new ArrayList<>();
        
        try{
        for(Vector v : vector){
            list.add(new IntegralComputationDto(
                    ValueValidator.validateAndParse((String)v.get(0)),
                    ValueValidator.validateAndParse((String)v.get(1)), 
                    ValueValidator.validateAndParse((String)v.get(2)), 
                    (Double)v.get(3)
            ));
        }}
        catch (ValidatorException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return new ArrayList<>();
        }
        return list;
    }
    
    private void fillFromCollectionButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fillFromCollectionButtonMouseClicked
        if(collectionStartSince == -1){
            collectionStartSince = resultTable.getRowCount();
            List<IntegralComputationDto> list = DataProvider.of(this).getComputationList();
            setListAsTable(list);
        }
        
    }//GEN-LAST:event_fillFromCollectionButtonMouseClicked

    private void setListAsTable(List<IntegralComputationDto> list){
        DefaultTableModel model = getDefaultTableModel();
        
        for(IntegralComputationDto dto : list){
            model.addRow(dto.asRow());
        }
    }
    
    private void removeCollectionRowsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeCollectionRowsButtonMouseClicked
        if(collectionStartSince!=-1){
            
            
            DefaultTableModel model = getDefaultTableModel();
            int counter = RECORDS_AMOUNT;
            while(counter-- > 0){
                model.removeRow(collectionStartSince);
            }
            
            collectionStartSince = -1;
        }
       
    }//GEN-LAST:event_removeCollectionRowsButtonMouseClicked

    private void getFileThenRun(Consumer<String> whenFileSelected){
        String filename = getRepositoryFile();
        
        if(filename != null){
            whenFileSelected.accept(filename);
        }
    }
    
    private void saveTableWithSerializator(IntegralComputationDtoSerializator serializer) {
        getFileThenRun((filename) -> DataProvider.of(this).getRepositiry().saveAll(filename, getTableAsList(), serializer));
    }
    
    private void fetchTableWithSerializator(IntegralComputationDtoSerializator serializer){
        getFileThenRun((filename) -> {
            var list = DataProvider.of(this).getRepositiry().fetchAll(filename, serializer);
            setListAsTable(list);
        });
    }
    
    private void binSaveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_binSaveButtonMouseClicked
 
        saveTableWithSerializator(Serializator.bin);
        
    }//GEN-LAST:event_binSaveButtonMouseClicked

    private void fetchBinButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fetchBinButtonMouseClicked
        fetchTableWithSerializator(Serializator.bin);
    }//GEN-LAST:event_fetchBinButtonMouseClicked

    private void saveJsonButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveJsonButtonMouseClicked
        saveTableWithSerializator(Serializator.json);
    }//GEN-LAST:event_saveJsonButtonMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        fetchTableWithSerializator(Serializator.json);
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(IntegralForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntegralForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntegralForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntegralForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntegralForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRowButton;
    private javax.swing.JButton binSaveButton;
    private javax.swing.JButton computeButton;
    private javax.swing.JButton fetchBinButton;
    private javax.swing.JButton fillFromCollectionButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField leftBoundField;
    private javax.swing.JButton removeCollectionRowsButton;
    private javax.swing.JButton removeSelectedRow;
    private javax.swing.JTable resultTable;
    private java.awt.TextField rigthBoundField;
    private javax.swing.JButton saveJsonButton;
    private java.awt.TextField stepField;
    // End of variables declaration//GEN-END:variables
}
