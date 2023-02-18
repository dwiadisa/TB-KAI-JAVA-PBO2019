/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import db.entitas.Kereta_Api_Entitas;
import db.services.Kelas_KAI_Service;
import db.services.Kereta_api_Service;
import javax.swing.JOptionPane;

/**
 *
 * @author adisa
 */
public class Panel_Kereta extends javax.swing.JPanel {

    private Kereta_api_Service kereta_api_Service;
    private Kelas_KAI_Service kelas_KAI_Service;

    /**
     * Creates new form Panel_Kelas_KAI
     */
    public Panel_Kereta() {
        initComponents();
        kereta_api_Service = new Kereta_api_Service();
        kelas_KAI_Service = new Kelas_KAI_Service();

        tableKereta.setModel(kereta_api_Service.read());
        comboKelasKA.setModel(kelas_KAI_Service.modelComboBox());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        textIdKereta = new javax.swing.JTextField();
        buttonInsert_KA = new javax.swing.JButton();
        buttonUpdate_KA = new javax.swing.JButton();
        buttonDelete_KA = new javax.swing.JButton();
        buttonClear_KA = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKereta = new javax.swing.JTable();
        textNamaKereta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboKelasKA = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        jLabel2.setText("Kelas : ");

        buttonInsert_KA.setText("Insert");
        buttonInsert_KA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsert_KAActionPerformed(evt);
            }
        });

        buttonUpdate_KA.setText("Update");
        buttonUpdate_KA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdate_KAActionPerformed(evt);
            }
        });

        buttonDelete_KA.setText("Delete");
        buttonDelete_KA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDelete_KAActionPerformed(evt);
            }
        });

        buttonClear_KA.setText("Clear");
        buttonClear_KA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClear_KAActionPerformed(evt);
            }
        });

        tableKereta.setModel(new javax.swing.table.DefaultTableModel(
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
        tableKereta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKeretaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableKereta);

        jLabel3.setText("Nama Kereta : ");

        comboKelasKA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboKelasKA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKelasKAActionPerformed(evt);
            }
        });

        jLabel4.setText("ID Kereta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(buttonInsert_KA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textIdKereta, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboKelasKA, javax.swing.GroupLayout.Alignment.LEADING, 0, 138, Short.MAX_VALUE)
                                .addComponent(textNamaKereta, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buttonUpdate_KA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonDelete_KA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonClear_KA)
                                .addGap(28, 28, 28)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textIdKereta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textNamaKereta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboKelasKA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonUpdate_KA)
                            .addComponent(buttonInsert_KA)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonDelete_KA)
                        .addComponent(buttonClear_KA)))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInsert_KAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsert_KAActionPerformed
        // TODO add your handling code here:
        Kereta_Api_Entitas kereta_Api_Entitas = new Kereta_Api_Entitas();
        kereta_Api_Entitas.setId_kereta(textIdKereta.getText());
        kereta_Api_Entitas.setNama_kereta_api(textNamaKereta.getText());
        kereta_Api_Entitas.setKelas_kereta(comboKelasKA.getSelectedItem().toString());

        if (kereta_api_Service.insert(kereta_Api_Entitas)) {
            JOptionPane.showMessageDialog(null, "Insert Data Kereta Api Berhasil");
        }

        tableKereta.setModel(kereta_api_Service.read());

    }//GEN-LAST:event_buttonInsert_KAActionPerformed

    private void buttonUpdate_KAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdate_KAActionPerformed
        // TODO add your handling code here:
        Kereta_Api_Entitas kelas_KAI = new Kereta_Api_Entitas();
        kelas_KAI.setId_kereta(textIdKereta.getText());
        kelas_KAI.setNama_kereta_api(textNamaKereta.getText());
        kelas_KAI.setKelas_kereta(comboKelasKA.getSelectedItem().toString());

        if (kereta_api_Service.update(kelas_KAI)) {
            JOptionPane.showMessageDialog(null, "Update Data Kereta Api Berhasil");
        }

        tableKereta.setModel(kereta_api_Service.read());
    }//GEN-LAST:event_buttonUpdate_KAActionPerformed

    private void buttonDelete_KAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDelete_KAActionPerformed
        // TODO add your handling code here:
        if (kereta_api_Service.delete(textIdKereta.getText())) {
            JOptionPane.showMessageDialog(null, "Hapus Data Kelas KAI Berhasil");
        }

        tableKereta.setModel(kereta_api_Service.read());
    }//GEN-LAST:event_buttonDelete_KAActionPerformed

    private void tableKeretaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKeretaMouseClicked
        // TODO add your handling code here:
        int selectedRow = tableKereta.getSelectedRow();
        if (selectedRow != -1) {
            textIdKereta.setText(tableKereta.getValueAt(selectedRow, 0).toString());
            textNamaKereta.setText(tableKereta.getValueAt(selectedRow, 1).toString());
        }
    }//GEN-LAST:event_tableKeretaMouseClicked

    private void buttonClear_KAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClear_KAActionPerformed
        // TODO add your handling code here:
        textIdKereta.setText("");
        textNamaKereta.setText("");

        tableKereta.setModel(kereta_api_Service.read());
    }//GEN-LAST:event_buttonClear_KAActionPerformed

    private void comboKelasKAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKelasKAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboKelasKAActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClear_KA;
    private javax.swing.JButton buttonDelete_KA;
    private javax.swing.JButton buttonInsert_KA;
    private javax.swing.JButton buttonUpdate_KA;
    private javax.swing.JComboBox<String> comboKelasKA;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableKereta;
    private javax.swing.JTextField textIdKereta;
    private javax.swing.JTextField textNamaKereta;
    // End of variables declaration//GEN-END:variables
}
