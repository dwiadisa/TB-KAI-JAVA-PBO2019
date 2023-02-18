package panel;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import panel.Panel_Stasiun;

public class master_perjalanan extends javax.swing.JFrame {

    public master_perjalanan() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        back = new javax.swing.JPanel();
        side_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_daft_kereta = new javax.swing.JButton();
        btn_data_stasiun = new javax.swing.JButton();
        btn_about = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        btn_dftPenumpang = new javax.swing.JButton();
        btn_dftKelas = new javax.swing.JButton();
        main_panel = new javax.swing.JPanel();
        panel_Stasiun1 = new panel.Panel_Stasiun();
        panel_Penumpang1 = new panel.Panel_Penumpang();
        panel_Kelas_KAI2 = new panel.Panel_Kelas_KAI();
        panel_Kereta1 = new panel.Panel_Kereta();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ngetrain - Train Trip Management System (BETA)");

        back.setBackground(new java.awt.Color(5, 151, 242));

        side_panel.setBackground(new java.awt.Color(5, 151, 242));
        side_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo ngetrain icon.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sistem Administrasi Perjalanan KA");

        btn_daft_kereta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_daft_kereta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-train-50.png"))); // NOI18N
        btn_daft_kereta.setText("Manajemen Kereta Api");
        btn_daft_kereta.setIconTextGap(10);
        btn_daft_kereta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daft_keretaActionPerformed(evt);
            }
        });

        btn_data_stasiun.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_data_stasiun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-railway-station-50.png"))); // NOI18N
        btn_data_stasiun.setText("Data Stasiun");
        btn_data_stasiun.setIconTextGap(10);
        btn_data_stasiun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_data_stasiunActionPerformed(evt);
            }
        });

        btn_about.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-info-24.png"))); // NOI18N
        btn_about.setText("About");
        btn_about.setIconTextGap(10);

        btn_exit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-exit-24.png"))); // NOI18N
        btn_exit.setText("Exit");
        btn_exit.setIconTextGap(10);
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        btn_dftPenumpang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_dftPenumpang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-male-user-32.png"))); // NOI18N
        btn_dftPenumpang.setText("Daftar Penumpang");
        btn_dftPenumpang.setIconTextGap(10);
        btn_dftPenumpang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dftPenumpangActionPerformed(evt);
            }
        });

        btn_dftKelas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_dftKelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-class-50.png"))); // NOI18N
        btn_dftKelas.setText("Manajemen Kelas");
        btn_dftKelas.setIconTextGap(10);
        btn_dftKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dftKelasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout side_panelLayout = new javax.swing.GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_dftPenumpang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(side_panelLayout.createSequentialGroup()
                        .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_daft_kereta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_data_stasiun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, side_panelLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_about, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_dftKelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        side_panelLayout.setVerticalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btn_daft_kereta)
                .addGap(18, 18, 18)
                .addComponent(btn_data_stasiun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_dftPenumpang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_dftKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_about, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        main_panel.setBackground(new java.awt.Color(5, 151, 242));
        main_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        main_panel.setLayout(new java.awt.CardLayout());
        main_panel.add(panel_Stasiun1, "card3");
        main_panel.add(panel_Penumpang1, "card4");
        main_panel.add(panel_Kelas_KAI2, "card6");
        main_panel.add(panel_Kereta1, "card2");

        javax.swing.GroupLayout backLayout = new javax.swing.GroupLayout(back);
        back.setLayout(backLayout);
        backLayout.setHorizontalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(side_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );
        backLayout.setVerticalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(side_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dftPenumpangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dftPenumpangActionPerformed
        // TODO add your handling code here:
        main_panel.removeAll();
        main_panel.repaint();
        main_panel.revalidate();

        // tambah panel
        main_panel.add(panel_Penumpang1);
        main_panel.repaint();
        main_panel.revalidate();


    }//GEN-LAST:event_btn_dftPenumpangActionPerformed

    private void btn_daft_keretaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daft_keretaActionPerformed
        // TODO add your handling code here:
        main_panel.removeAll();
        main_panel.repaint();
        main_panel.revalidate();

        // tambah panel
        main_panel.add(panel_Kereta1);
        main_panel.repaint();
        main_panel.revalidate();
    }//GEN-LAST:event_btn_daft_keretaActionPerformed

    private void btn_data_stasiunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_data_stasiunActionPerformed
        // TODO add your handling code here:
        main_panel.removeAll();
        main_panel.repaint();
        main_panel.revalidate();

        // tambah panel
        main_panel.add(panel_Stasiun1);
        main_panel.repaint();
        main_panel.revalidate();
    }//GEN-LAST:event_btn_data_stasiunActionPerformed

    private void btn_dftKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dftKelasActionPerformed
        // TODO add your handling code here:
        main_panel.removeAll();
        main_panel.repaint();
        main_panel.revalidate();

        // tambah panel
        main_panel.add(panel_Kelas_KAI2);
        main_panel.repaint();
        main_panel.revalidate();
    }//GEN-LAST:event_btn_dftKelasActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        // TODO add your handling code here:
        
        int selectedOption = JOptionPane.showConfirmDialog(null, "Apa Anda Yakin untuk keluar", "Keluar", JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            System.exit(0);
           

        }
    }//GEN-LAST:event_btn_exitActionPerformed

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
            java.util.logging.Logger.getLogger(master_perjalanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(master_perjalanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(master_perjalanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(master_perjalanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new master_perjalanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back;
    private javax.swing.JButton btn_about;
    private javax.swing.JButton btn_daft_kereta;
    private javax.swing.JButton btn_data_stasiun;
    private javax.swing.JButton btn_dftKelas;
    private javax.swing.JButton btn_dftPenumpang;
    private javax.swing.JButton btn_exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel main_panel;
    private panel.Panel_Kelas_KAI panel_Kelas_KAI2;
    private panel.Panel_Kereta panel_Kereta1;
    private panel.Panel_Penumpang panel_Penumpang1;
    private panel.Panel_Stasiun panel_Stasiun1;
    private javax.swing.JPanel side_panel;
    // End of variables declaration//GEN-END:variables

}
