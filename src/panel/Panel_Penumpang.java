/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import db.entitas.Penumpang_Ka_Entitas;
import db.services.Penumpang_Ka_Service;
import javax.swing.JOptionPane;

/**
 *
 * @author adisa
 */
public class Panel_Penumpang extends javax.swing.JPanel {

    private Penumpang_Ka_Service penumpang_Ka_Service;

    /**
     * Creates new form Panel_Kelas_KAI
     */
    public Panel_Penumpang() {
        initComponents();
        penumpang_Ka_Service = new Penumpang_Ka_Service();

        tablePenumpang.setModel(penumpang_Ka_Service.read());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textIdPenumpang = new javax.swing.JTextField();
        textNamaPenumpang = new javax.swing.JTextField();
        buttonInsert_Penumpang = new javax.swing.JButton();
        buttonUpdate_Penumpang = new javax.swing.JButton();
        buttonDelete_Penumpang = new javax.swing.JButton();
        buttonClear_Penumpang = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePenumpang = new javax.swing.JTable();

        jLabel1.setText("ID Penumpang  :");

        jLabel2.setText("Nama Penumpang   :");

        buttonInsert_Penumpang.setText("Insert");
        buttonInsert_Penumpang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsert_PenumpangActionPerformed(evt);
            }
        });

        buttonUpdate_Penumpang.setText("Update");
        buttonUpdate_Penumpang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdate_PenumpangActionPerformed(evt);
            }
        });

        buttonDelete_Penumpang.setText("Delete");
        buttonDelete_Penumpang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDelete_PenumpangActionPerformed(evt);
            }
        });

        buttonClear_Penumpang.setText("Clear");
        buttonClear_Penumpang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClear_PenumpangActionPerformed(evt);
            }
        });

        tablePenumpang.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePenumpang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePenumpangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePenumpang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonInsert_Penumpang)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(buttonUpdate_Penumpang)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(buttonDelete_Penumpang)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(buttonClear_Penumpang))
                                    .addComponent(textIdPenumpang, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textNamaPenumpang, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textIdPenumpang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNamaPenumpang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInsert_Penumpang)
                    .addComponent(buttonUpdate_Penumpang)
                    .addComponent(buttonDelete_Penumpang)
                    .addComponent(buttonClear_Penumpang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInsert_PenumpangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsert_PenumpangActionPerformed
        // TODO add your handling code here:
        Penumpang_Ka_Entitas penumpang1 = new Penumpang_Ka_Entitas();
        penumpang1.setId_penumpang(textIdPenumpang.getText());
        penumpang1.setNama_penumpang(textNamaPenumpang.getText());


        if (penumpang_Ka_Service.insert(penumpang1)) {
            JOptionPane.showMessageDialog(null, "Insert Penumpang Berhasil");
        }

        tablePenumpang.setModel(penumpang_Ka_Service.read());

    }//GEN-LAST:event_buttonInsert_PenumpangActionPerformed

    private void buttonUpdate_PenumpangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdate_PenumpangActionPerformed
        // TODO add your handling code here:
        Penumpang_Ka_Entitas penumpang2 = new Penumpang_Ka_Entitas();
        penumpang2.setId_penumpang(textIdPenumpang.getText());
        penumpang2.setNama_penumpang(textNamaPenumpang.getText());
        if (penumpang_Ka_Service.update(penumpang2)) {
            JOptionPane.showMessageDialog(null, "Update Data Penumpang Berhasil");
        }

        tablePenumpang.setModel(penumpang_Ka_Service.read());
    }//GEN-LAST:event_buttonUpdate_PenumpangActionPerformed

    private void buttonDelete_PenumpangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDelete_PenumpangActionPerformed
        // TODO add your handling code here:
        if (penumpang_Ka_Service.delete(textIdPenumpang.getText())) {
            JOptionPane.showMessageDialog(null, "Hapus Data Kelas KAI Berhasil");
        }

        tablePenumpang.setModel(penumpang_Ka_Service.read());
    }//GEN-LAST:event_buttonDelete_PenumpangActionPerformed

    private void tablePenumpangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePenumpangMouseClicked
        // TODO add your handling code here:
        int selectedRow = tablePenumpang.getSelectedRow();
        if (selectedRow != -1) {
            textIdPenumpang.setText(tablePenumpang.getValueAt(selectedRow, 0).toString());
            textNamaPenumpang.setText(tablePenumpang.getValueAt(selectedRow, 1).toString());
        }
    }//GEN-LAST:event_tablePenumpangMouseClicked

    private void buttonClear_PenumpangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClear_PenumpangActionPerformed
        // TODO add your handling code here:
        textNamaPenumpang.setText("");
        textIdPenumpang.setText("");

        tablePenumpang.setModel(penumpang_Ka_Service.read());
    }//GEN-LAST:event_buttonClear_PenumpangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClear_Penumpang;
    private javax.swing.JButton buttonDelete_Penumpang;
    private javax.swing.JButton buttonInsert_Penumpang;
    private javax.swing.JButton buttonUpdate_Penumpang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablePenumpang;
    private javax.swing.JTextField textIdPenumpang;
    private javax.swing.JTextField textNamaPenumpang;
    // End of variables declaration//GEN-END:variables
}