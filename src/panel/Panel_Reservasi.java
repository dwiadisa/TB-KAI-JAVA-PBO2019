package panel;

import db.entitas.Penumpang_Ka_Entitas;
import db.entitas.Reservasi_Entitas;
import db.services.Kereta_api_Service;
import db.services.Penumpang_Ka_Service;
import db.services.Reservasi_Service;
import db.services.Stasiun_Service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.FontMetrics;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.Dimension;
import java.awt.Toolkit;
import static javax.swing.UIManager.getString;

public class Panel_Reservasi extends javax.swing.JPanel {

    private Stasiun_Service stasiun_Service;
    private Penumpang_Ka_Service penumpang_Ka_Service;
    private Reservasi_Service reservasi_Service;
    private Kereta_api_Service kereta_api_Service;

// tambahan print
    public PageFormat getPageFormat(PrinterJob pj) {

        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();

        double middleHeight = 8.0;
        double headerHeight = 2.0;
        double footerHeight = 2.0;
        double width = convert_CM_To_PPI(8);      //printer know only point per inch.default value is 72ppi
        double height = convert_CM_To_PPI(headerHeight + middleHeight + footerHeight);
        paper.setSize(width, height);
        paper.setImageableArea(
                0,
                10,
                width,
                height - convert_CM_To_PPI(1)
        );   //define boarder size    after that print area width is about 180 points

        pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
        pf.setPaper(paper);

        return pf;
    }

    protected static double convert_CM_To_PPI(double cm) {
        return toPPI(cm * 0.393600787);
    }

    protected static double toPPI(double inch) {
        return inch * 72d;
    }

    public class ReservasiPrintable implements Printable {

        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
                throws PrinterException {

            int result = NO_SUCH_PAGE;
            if (pageIndex == 0) {

                Graphics2D g2d = (Graphics2D) graphics;

                double width = pageFormat.getImageableWidth();

                g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

                ////////// code by alqama//////////////
                FontMetrics metrics = g2d.getFontMetrics(new Font("Arial", Font.BOLD, 7));

                int idLength = metrics.stringWidth("000");
                int amtLength = metrics.stringWidth("000000");
                int qtyLength = metrics.stringWidth("00000");
                int priceLength = metrics.stringWidth("000000");
                int prodLength = (int) width - idLength - amtLength - qtyLength - priceLength - 17;

                int productPosition = 0;
                int discountPosition = prodLength + 5;
                int pricePosition = discountPosition + idLength + 10;
                int qtyPosition = pricePosition + priceLength + 4;
                int amtPosition = qtyPosition + qtyLength;

                try {
                    /*Draw Header*/
                    int y = 20;
                    int yShift = 10;
                    int headerRectHeight = 15;
                    int headerRectHeighta = 40;

                    //////////////// tampilan data yg akan di print ////////////////
                    g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                    g2d.drawString("---------------------------------------", 12, y);
                    y += yShift;
                    g2d.drawString("    PT. KERETA API INDONESIA (Persero)        ", 12, y);
                    y += yShift;
                    g2d.drawString("---------------------------------------", 12, y);
                    y += headerRectHeight;
                     g2d.drawString("", 10, y);
                    y += yShift;
                    g2d.drawString("               BOARDING PASS           " , 10, y);
                    y += yShift;
                     g2d.drawString("", 10, y);
                    y += yShift;
                     g2d.drawString("Kode Reservasi "+ (txt_id_reservasi.getText()), 10, y);
                    y += yShift;
                     g2d.drawString("", 10, y);
                    y += yShift;
                    g2d.drawString("ID/Nama :" + combo_id_penumpang.getSelectedItem().toString() + "  ", 10, y);
                    y += yShift;
                    g2d.drawString("", 10, y);
                    y += yShift;
                    g2d.drawString(combo_kereta.getSelectedItem().toString(), 10, y);
                    y += yShift;
                    g2d.drawString("", 10, y);
                    y += yShift;
                    g2d.drawString((combo_dari.getSelectedItem().toString()) + " - " + (txt_jam_berangkat.getText()), 10, y);
                    y += yShift;
                    g2d.drawString("", 10, y);
                    y += yShift;
                    g2d.drawString((combo_tujuan.getSelectedItem().toString()) + " - " + (txt_tiba.getText()), 10, y);
                    y += yShift;
                    g2d.drawString("", 10, y);
                    y += yShift;
                    String tampilan = "dd - MMMM - yyyy";
                    SimpleDateFormat format = new SimpleDateFormat(tampilan);
                    String tanggal;
                    tanggal = String.valueOf(format.format(date_berangkat.getDate()));
                    g2d.drawString(tanggal.toString(), 10, y);
                    y += yShift;
                    g2d.drawString("", 10, y);
                    y += yShift;

                   
                } catch (Exception r) {
                    r.printStackTrace();
                }

                result = PAGE_EXISTS;
            }
            return result;
        }
    }

    public Panel_Reservasi() {

        initComponents();

        stasiun_Service = new Stasiun_Service();
        penumpang_Ka_Service = new Penumpang_Ka_Service();
        reservasi_Service = new Reservasi_Service();
        kereta_api_Service = new Kereta_api_Service();

        combo_id_penumpang.setModel(penumpang_Ka_Service.modelComboBox());
        combo_dari.setModel(stasiun_Service.modelComboBox());
        combo_tujuan.setModel(stasiun_Service.modelComboBox());
        combo_kereta.setModel(kereta_api_Service.modelComboBox());

        tbl_kereta.setModel(reservasi_Service.read());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        date_berangkat = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txt_id_reservasi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        combo_dari = new javax.swing.JComboBox<>();
        combo_tujuan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_kereta = new javax.swing.JTable();
        btn_cetak = new javax.swing.JButton();
        combo_id_penumpang = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txt_jam_berangkat = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_tiba = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        combo_kereta = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(92, 148, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pemesanan Tiket Kereta Api");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID Penumpang : ");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tanggal Berangkat : ");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kode Reservasi : ");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Berangkat :");

        combo_dari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        combo_tujuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tujuan : ");

        tbl_kereta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_kereta);

        btn_cetak.setText("Cetak");
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });

        combo_id_penumpang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Jam Berangkat : ");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Jam Tiba : ");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Kereta : ");

        combo_kereta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo ngetrain icon.png"))); // NOI18N

        jLabel11.setText("Ngetrain - Train Reservation System");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_id_reservasi, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combo_id_penumpang, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_jam_berangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_tiba, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combo_tujuan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo_dari, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(date_berangkat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo_kereta, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel11))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id_reservasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(combo_id_penumpang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(date_berangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo_dari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo_tujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_jam_berangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tiba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(combo_kereta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cetak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel11)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        // TODO add your handling code here:
        Reservasi_Entitas penumpang1 = new Reservasi_Entitas();
        String penumpangSplit[] = combo_id_penumpang.getSelectedItem().toString().split(" | ");
        String berangkatSplit[] = combo_dari.getSelectedItem().toString().split(" | ");
        String tujuanSplit[] = combo_tujuan.getSelectedItem().toString().split(" | ");
        String keretaSplit[] = combo_kereta.getSelectedItem().toString().split(" | ");

//        penumpang1.setHarga(txt_id_reservasi.getText());
        penumpang1.setId_penumpang(penumpangSplit[0].trim());

        penumpang1.setId_reservasi(txt_id_reservasi.getText());
        penumpang1.setJam_berangkat(txt_jam_berangkat.getText());
        penumpang1.setJam_tiba(txt_tiba.getText());

        penumpang1.setStasiun_berangkat(berangkatSplit[0].trim());
        penumpang1.setStasiun_tujuan(tujuanSplit[0].trim());

        penumpang1.setWaktu_pemesanan(new Timestamp(new Date().getTime()));
        penumpang1.setKereta(keretaSplit[0].trim());

        penumpang1.setTanggal_berangkat(date_berangkat.getDate());

        if (reservasi_Service.insert(penumpang1)) {
            JOptionPane.showMessageDialog(null, "Insert Penumpang Berhasil");
        }

        tbl_kereta.setModel(reservasi_Service.read());

        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(new ReservasiPrintable(), getPageFormat(pj));
        try {
            pj.print();

        } catch (PrinterException ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_btn_cetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cetak;
    private javax.swing.JComboBox<String> combo_dari;
    private javax.swing.JComboBox<String> combo_id_penumpang;
    private javax.swing.JComboBox<String> combo_kereta;
    private javax.swing.JComboBox<String> combo_tujuan;
    private com.toedter.calendar.JDateChooser date_berangkat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_kereta;
    private javax.swing.JTextField txt_id_reservasi;
    private javax.swing.JTextField txt_jam_berangkat;
    private javax.swing.JTextField txt_tiba;
    // End of variables declaration//GEN-END:variables
}
